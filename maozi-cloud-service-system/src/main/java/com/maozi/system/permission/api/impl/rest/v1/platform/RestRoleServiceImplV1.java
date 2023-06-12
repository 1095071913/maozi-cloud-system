package com.maozi.system.permission.api.impl.rest.v1.platform;

import java.util.List;

import com.maozi.base.annotation.RestService;
import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.sso.oauth.dto.platform.param.ClientUserParam;
import com.maozi.system.permission.api.impl.RoleServiceImpl;
import com.maozi.system.permission.api.rest.v1.platform.RestRoleServiceV1;
import com.maozi.system.permission.domain.RoleDo;
import com.maozi.system.role.vo.v1.platform.InfoVo;
import com.maozi.system.role.vo.v1.platform.ListVo;
import com.maozi.user.role.dto.v1.platform.SaveUpdateParam;

@RestService
public class RestRoleServiceImplV1 extends RoleServiceImpl implements RestRoleServiceV1 {

	@Override
	public AbstractBaseResult<List<ListVo>> restList() {
		return success(list(ListVo::new, RoleDo::getId,RoleDo::getName));
	}

	@Override
	public AbstractBaseResult<Long> restSave(SaveUpdateParam param) {
		return success(restSaveUpdate(null,param));
	}
	
	@Override
	public AbstractBaseResult<List<DropDownResult>> dropDownListResult(){
		return super.dropDownListResult();
	}
	
	
	@RestService
	public class RestRoleServiceCurrentImplV1 extends RoleServiceImpl implements RestRoleServiceCurrentV1 {

		@Override
		public AbstractBaseResult<InfoVo> restGet(Long id) {
			
			InfoVo response = getByIdThrowError(id, InfoVo.class, RoleDo::getName,RoleDo::getDescription,RoleDo::getStatus);
			
			response.setPermissionIds(rolePermissionService.getPermissionsByRole(id));
			
			return success(response);
			
		}

		@Override
		public AbstractBaseResult<Void> restRemove(Long id) {
			return removeByIdResult(id);
		}
		
		@Override
		public AbstractBaseResult<Void> restUpdate(Long id, SaveUpdateParam param) {
			
			restSaveUpdate(id, param);
			
			List<Long> userIds = userRoleService.getUsersByRole(id);
			
			List<ClientUserParam> clientUsers = userService.getClientUsers(userIds);
			
			rpcOauthTokenService.rpcDestroys(clientUsers).getResultDataThrowError();
			
			return success(null);
			
		}
		
		@Override
		public AbstractBaseResult<Void> updateStatus(Long id){
			return super.updateStatus(id);
		}
		
	}

}
