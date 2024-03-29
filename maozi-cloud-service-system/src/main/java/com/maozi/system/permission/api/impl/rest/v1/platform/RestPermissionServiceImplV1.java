package com.maozi.system.permission.api.impl.rest.v1.platform;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.maozi.base.annotation.RestService;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.permission.api.impl.PermissionServiceImpl;
import com.maozi.system.permission.api.rest.v1.platform.RestPermissionServiceV1;
import com.maozi.system.permission.domain.PermissionDo;
import com.maozi.system.permission.dto.v1.platform.PermissionSaveUpdateParam;
import com.maozi.system.permission.vo.v1.platform.PermissionDropDownResult;
import com.maozi.system.permission.vo.v1.platform.PermissionInfoVo;
import com.maozi.system.permission.vo.v1.platform.PermissionListVo;
import java.util.List;

@RestService
public class RestPermissionServiceImplV1 extends PermissionServiceImpl implements RestPermissionServiceV1 {

	@Override
	public AbstractBaseResult<List<PermissionListVo>> restList() {
		
		MPJLambdaWrapper<PermissionDo> wrapper = MPJWrappers.lambdaJoin();
		
		wrapper.select(getColumns(PermissionListVo.class));
		
		wrapper.orderByDesc(PermissionDo::getLevel,PermissionDo::getSort);
		
		return success(list(wrapper, PermissionListVo::new));
		
	}

	@Override
	public AbstractBaseResult<Long> restSave(PermissionSaveUpdateParam param) {
		return saveUpdateResult(null,param);
	}

	@Override
	public AbstractBaseResult<List<PermissionDropDownResult>> dropDownListResultCustomize() {
		return success(list(PermissionDropDownResult::new,PermissionDo::getId,PermissionDo::getParentId,PermissionDo::getLevel,PermissionDo::getName));
	}
	
	@RestService
	public class RestPermissionServiceCurrentImplV1 extends PermissionServiceImpl implements RestPermissionServiceCurrentV1 {

		@Override
		public AbstractBaseResult<PermissionInfoVo> restGet(Long id) {
			return success(getByIdThrowError(id, PermissionInfoVo.class, PermissionDo::getParentId,PermissionDo::getName,PermissionDo::getIcon,PermissionDo::getMark,PermissionDo::getRoute,PermissionDo::getServiceUri,PermissionDo::getType,PermissionDo::getSort));
		}

		@Override
		public AbstractBaseResult<Void> restRemove(Long id) {
			return removeByIdResult(id);
		}

		@Override
		public AbstractBaseResult<Void> restUpdate(Long id, PermissionSaveUpdateParam param) {
			
			saveUpdate(id,param);
			
			return success(null);
			
		}
		
	}

}
