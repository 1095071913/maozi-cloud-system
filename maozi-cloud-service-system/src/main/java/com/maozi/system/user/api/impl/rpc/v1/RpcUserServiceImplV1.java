package com.maozi.system.user.api.impl.rpc.v1;

import java.util.Collection;
import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.apache.dubbo.config.annotation.DubboService;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.user.api.impl.UserServiceImpl;
import com.maozi.system.user.api.rpc.v1.RpcUserServiceV1;
import com.maozi.system.user.domain.UserDo;

@DubboService
public class RpcUserServiceImplV1 extends UserServiceImpl implements RpcUserServiceV1 {

	@Override
	public AbstractBaseResult<String> rpcGetPasswordByUsername(String username) {
		
		isNullThrowError(username, getAbbreviationModelName());
		
		MPJLambdaWrapper<UserDo> wrapper = MPJWrappers.lambdaJoin(UserDo.builder().username(username).build());
		
		wrapper.select(UserDo::getPassword);
		
		UserDo domain = getOne(wrapper);
		
		isNullThrowError(domain, getAbbreviationModelName());
		
		return success(domain.getPassword());
		
	}

	@Override
	public AbstractBaseResult<List<String>> rpcGetPermissionsByUsername(String username) {
		
		Long id = getAvailableByUsername(username);
		
		List<String> responses = Lists.newArrayList();
		
		List<Long> roleIds = userRoleService.getRolesByUser(id);
		
		if(roleIds.size() > 0) {
			
			Collection<Long> permissionIds = rolePermissionService.getPermissionsByRoles(roleIds);
			
			List<String> marks = permissionService.getMarks(permissionIds);
			
			marks.stream().forEach((mark)->{
				responses.add(mark);
			});
			
		}
		
		return success(responses);
		
	}

	@Override
	public AbstractBaseResult<List<String>> rpcGetPermissionsByUsernameRole(String username, Long roleId) {
		
		Long id = getAvailableByUsername(username);
		
		userRoleService.hasUserBindRole(id,roleId);
		
		List<String> responses = Lists.newArrayList();
		
		List<Long> permissionIds = rolePermissionService.getPermissionsByRole(roleId);
		
		List<String> marks = permissionService.getMarks(permissionIds);
		
		marks.stream().forEach((mark)->{
			responses.add(mark);
		});
		
		return success(responses);
		
	}
	
}