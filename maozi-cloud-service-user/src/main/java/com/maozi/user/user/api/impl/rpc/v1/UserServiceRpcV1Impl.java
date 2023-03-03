package com.maozi.user.user.api.impl.rpc.v1;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.DubboService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.maozi.base.api.impl.rpc.BaseServiceRpcImpl;
import com.maozi.factory.result.AbstractBaseResult;
import com.maozi.sso.info.SystemUser;
import com.maozi.user.permission.api.PermissionService;
import com.maozi.user.user.api.rpc.v1.UserServiceRpcV1;
import com.maozi.user.user.domain.UserDo;
import com.maozi.user.user.enums.UserStatusEnum;
import com.maozi.user.user.mapper.UserMapper;

@DubboService
public class UserServiceRpcV1Impl extends BaseServiceRpcImpl<UserMapper, UserDo, SystemUser> implements UserServiceRpcV1 {
	
	@Resource(name = "permissionServiceImpl")
	private PermissionService permissionService;
	
	@Override
	public AbstractBaseResult<SystemUser> rpcGetInfoPermissionByUsername(String username) throws Exception{
		
		isNullThrow(username,"账号");
		
		LambdaQueryWrapper<UserDo> queryWrapper = new LambdaQueryWrapper<UserDo>();
		
		queryWrapper.select(UserDo::getId,UserDo::getUsername,UserDo::getRoleId).eq(UserDo::getStatus, UserStatusEnum.enable).eq(UserDo::getUsername, username);
		
		UserDo user = isNullThrow(getOne(queryWrapper),"账号");
		
		SystemUser response = copy(user, SystemUser.class);
		
		response.setPermissions(permissionService.getPermissionsByRoleId(user.getRoleId()));
		
		return success(response);
		
	}

	@Override
	public AbstractBaseResult<String> rpcGetPasswordById(Long userId) {
		return success(isNullThrow(getById(userId), "用户").getPassword());
	}
	
}