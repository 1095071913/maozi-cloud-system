package com.maozi.system.permission.api.impl;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import com.github.yulichang.toolkit.MPJWrappers;
import com.maozi.base.api.impl.BaseServiceImpl;
import com.maozi.sso.oauth.api.rpc.v1.RpcOauthTokenServiceV1;
import com.maozi.system.permission.api.RolePermissionService;
import com.maozi.system.permission.api.RoleService;
import com.maozi.system.permission.api.UserRoleService;
import com.maozi.system.permission.domain.RoleDo;
import com.maozi.system.permission.mapper.RoleMapper;
import com.maozi.system.user.api.UserService;
import com.maozi.user.role.dto.v1.platform.SaveUpdateParam;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper,RoleDo,Void> implements RoleService{
	
	@Resource(name = "userServiceImpl")
	protected UserService userService;

	@Resource(name = "userRoleServiceImpl")
	protected UserRoleService userRoleService;
	
	@Resource(name = "rolePermissionServiceImpl")
	protected RolePermissionService rolePermissionService;
	
	@DubboReference
	protected RpcOauthTokenServiceV1 rpcOauthTokenService;
	
	@Override
	protected String getAbbreviationModelName() {return "【角色】";}

	@Override
	protected void checkBind(Long id) {
		userRoleService.checkUserBindRoleByRole(id);
	}

	@Override
	public boolean has(Long id) {
		return count(MPJWrappers.lambdaJoin(RoleDo.builder().id(id).build())) > 0;
	}
	
	protected Long restSaveUpdate(Long id,SaveUpdateParam param) {
		
		id = saveUpdate(null,param);
		
		rolePermissionService.updateBind(id, param.getBindPermissionIds(), param.getUnbindPermissionIds());
		
		return id;
		
	}

}
