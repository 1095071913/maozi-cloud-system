package com.maozi.system.permission.api.rest.v1.platform;

import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.permission.vo.v1.platform.DropDownResult;
import com.maozi.system.permission.vo.v1.platform.InfoVo;
import com.maozi.system.permission.vo.v1.platform.ListVo;
import com.maozi.user.permission.dto.v1.platform.SaveUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "【平台】【V1】权限模块")
@RequestMapping("/permission/platform/v1")
public interface RestPermissionServiceV1 {
	
	@GetMapping(value="/list")
	@ApiOperation(value = "列表")
	@PreAuthorize("hasAuthority('system:permission:list')")
	AbstractBaseResult<List<ListVo>> restList();
	
	@PostMapping(value="/save")
	@ApiOperation(value = "保存")
	@PreAuthorize("hasAuthority('system:permission:save')")
	AbstractBaseResult<Long> restSave(@RequestBody @Valid SaveUpdateParam param);
	
	@GetMapping(value="/dropDownList")
	@ApiOperation(value = "下拉列表")
	@PreAuthorize("hasAuthority('system:permission:save') or hasAuthority('system:permission:update')")
	AbstractBaseResult<List<DropDownResult>> dropDownListResultCustomize();
	
	@Api(tags = "【平台】【V1】权限模块")
	@RequestMapping("/permission/platform/v1/{id}")
	public interface RestPermissionServiceCurrentV1 {
		
		@GetMapping(value="/get")
		@ApiOperation(value = "详情")
		@PreAuthorize("hasAuthority('system:permission:get')")
		AbstractBaseResult<InfoVo> restGet(@PathVariable Long id);
		
		@PostMapping(value="/remove")
		@ApiOperation(value = "删除")
		@PreAuthorize("hasAuthority('system:permission:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);
		
		@PostMapping(value="/update")
		@ApiOperation(value = "更新")
		@PreAuthorize("hasAuthority('system:permission:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody SaveUpdateParam param);
		
	}

}