package com.jiumao.user.user.api.impl.rpc.v1;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jiumao.base.api.impl.rpc.BaseServiceRpcImpl;
import com.jiumao.factory.result.AbstractBaseResult;
import com.jiumao.user.api.rpc.v1.UserServiceRpcV1;
import com.jiumao.user.permission.api.PermissionService;
import com.jiumao.user.user.domain.UserDo;
import com.jiumao.user.user.enums.UserStatusEnum;
import com.jiumao.user.user.mapper.UserMapper;
import com.zhongshi.sso.info.SystemUser;

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