package com.maozi.system.permission.api.impl.rest.v1.platform;

import com.maozi.base.annotation.RestService;
import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.oauth.token.dto.platform.param.ClientUserParam;
import com.maozi.system.permission.api.impl.RoleServiceImpl;
import com.maozi.system.permission.api.rest.v1.platform.RestRoleServiceV1;
import com.maozi.system.permission.domain.RoleDo;
import com.maozi.system.role.dto.v1.platform.RoleSaveUpdateParam;
import com.maozi.system.role.vo.v1.platform.RoleInfoVo;
import com.maozi.system.role.vo.v1.platform.RoleListVo;
import java.util.List;

@RestService
public class RestRoleServiceImplV1 extends RoleServiceImpl implements RestRoleServiceV1 {

	@Override
	public AbstractBaseResult<List<RoleListVo>> restList() {
		return success(list(RoleListVo::new, RoleDo::getId,RoleDo::getName));
	}

	@Override
	public AbstractBaseResult<Long> restSave(RoleSaveUpdateParam param) {
		return success(restSaveUpdate(null,param));
	}
	
	@Override
	public AbstractBaseResult<List<DropDownResult>> dropDownListResult(){
		return super.dropDownListResult();
	}
	
	
	@RestService
	public class RestRoleServiceCurrentImplV1 extends RoleServiceImpl implements RestRoleServiceCurrentV1 {

		@Override
		public AbstractBaseResult<RoleInfoVo> restGet(Long id) {
			return success(getByIdThrowErrorRelation(id, RoleInfoVo.class));
		}

		@Override
		public AbstractBaseResult<Void> restRemove(Long id) {
			return removeByIdResult(id);
		}
		
		@Override
		public AbstractBaseResult<Void> restUpdate(Long id, RoleSaveUpdateParam param) {
			
			restSaveUpdate(id, param);
			
			List<Long> userIds = userRoleService.getUsersByRole(id);
			
			if(collectionIsNotEmpty(userIds)) {
				
				List<ClientUserParam> clientUsers = userService.getClientUsers(userIds);
				
				rpcOauthTokenService.rpcDestroys(clientUsers).getResultDataThrowError();
				
			}
			
			return success(null);
			
		}
		
		@Override
		public AbstractBaseResult<Void> updateStatus(Long id){
			return super.updateStatus(id);
		}
		
	}

}
