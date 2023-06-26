package com.maozi.system.permission.api.impl.rest.v1.platform;

import java.util.List;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.maozi.base.annotation.RestService;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.permission.api.impl.PermissionServiceImpl;
import com.maozi.system.permission.api.rest.v1.platform.RestPermissionServiceV1;
import com.maozi.system.permission.domain.PermissionDo;
import com.maozi.system.permission.vo.v1.platform.DropDownResult;
import com.maozi.system.permission.vo.v1.platform.InfoVo;
import com.maozi.system.permission.vo.v1.platform.ListVo;
import com.maozi.user.permission.dto.v1.platform.SaveUpdateParam;

@RestService
public class RestPermissionServiceImplV1 extends PermissionServiceImpl implements RestPermissionServiceV1 {

	@Override
	public AbstractBaseResult<List<ListVo>> restList() {
		
		MPJLambdaWrapper<PermissionDo> wrapper = MPJWrappers.lambdaJoin();
		
		wrapper.select(getColumns(ListVo.class));
		
		wrapper.orderByDesc(PermissionDo::getLevel,PermissionDo::getSort);
		
		return success(list(wrapper,ListVo::new));
		
	}

	@Override
	public AbstractBaseResult<Long> restSave(SaveUpdateParam param) {
		return saveUpdateResult(null,param);
	}

	@Override
	public AbstractBaseResult<List<DropDownResult>> dropDownListResultCustomize() {
		return success(list(DropDownResult::new,PermissionDo::getId,PermissionDo::getParentId,PermissionDo::getLevel,PermissionDo::getName));
	}
	
	@RestService
	public class RestPermissionServiceCurrentImplV1 extends PermissionServiceImpl implements RestPermissionServiceCurrentV1 {

		@Override
		public AbstractBaseResult<InfoVo> restGet(Long id) {
			return success(getByIdThrowError(id, InfoVo.class, PermissionDo::getParentId,PermissionDo::getName,PermissionDo::getIcon,PermissionDo::getMark,PermissionDo::getRoute,PermissionDo::getServiceUri,PermissionDo::getType,PermissionDo::getSort));
		}

		@Override
		public AbstractBaseResult<Void> restRemove(Long id) {
			return removeByIdResult(id);
		}

		@Override
		public AbstractBaseResult<Void> restUpdate(Long id, SaveUpdateParam param) {
			
			saveUpdate(id,param);
			
			return success(null);
			
		}
		
	}

}
