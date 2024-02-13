package com.maozi.system.permission.api.rest.v1.platform;

import com.maozi.base.annotation.Get;
import com.maozi.base.annotation.Post;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.permission.dto.v1.platform.PermissionSaveUpdateParam;
import com.maozi.system.permission.vo.v1.platform.PermissionDropDownResult;
import com.maozi.system.permission.vo.v1.platform.PermissionInfoVo;
import com.maozi.system.permission.vo.v1.platform.PermissionListVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = RestPermissionServiceV1.NAME)
public interface RestPermissionServiceV1 {

	String NAME = "【平台】【V1】权限模块";

	String PATH = "/permission/platform/v1";
	
	@Get(value = PATH + "/list",description = "列表")
	@PreAuthorize("hasAuthority('system:permission:list')")
	AbstractBaseResult<List<PermissionListVo>> restList();
	
	@Post(value = PATH + "/save",description = "保存")
	@PreAuthorize("hasAuthority('system:permission:save')")
	AbstractBaseResult<Long> restSave(@RequestBody @Valid PermissionSaveUpdateParam param);
	
	@Get(value = PATH + "/dropDownList",description = "下拉列表")
	@PreAuthorize("security = hasAuthority('system:permission:save') or hasAuthority('system:permission:update')")
	AbstractBaseResult<List<PermissionDropDownResult>> dropDownListResultCustomize();

	@Tag(name = NAME)
	public interface RestPermissionServiceCurrentV1 {

		String CURRENT_PATH = PATH + "/{id}";
		
		@Get(value = CURRENT_PATH + "/get",description = "详情")
		@PreAuthorize("hasAuthority('system:permission:get')")
		AbstractBaseResult<PermissionInfoVo> restGet(@PathVariable Long id);
		
		@Post(value = CURRENT_PATH + "/remove",description = "删除")
		@PreAuthorize("hasAuthority('system:permission:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);
		
		@Post(value = CURRENT_PATH + "/update",description = "更新")
		@PreAuthorize("hasAuthority('system:permission:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody PermissionSaveUpdateParam param);
		
	}

}