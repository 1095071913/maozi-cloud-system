package com.maozi.system.permission.api.rest.v1.platform;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.role.vo.v1.platform.InfoVo;
import com.maozi.system.role.vo.v1.platform.ListVo;
import com.maozi.user.role.dto.v1.platform.SaveUpdateParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "【平台】【V1】角色模块")
@RequestMapping("/role/platform/v1")
public interface RestRoleServiceV1 {
	
	@GetMapping(value="/list")
	@ApiOperation(value = "列表")
	@PreAuthorize("hasAuthority('system:role:list')")
	AbstractBaseResult<List<ListVo>> restList();
	
	@PostMapping(value="/save")
	@ApiOperation(value = "保存")
	@PreAuthorize("hasAuthority('system:role:save')")
	AbstractBaseResult<Long> restSave(@RequestBody @Valid SaveUpdateParam param);
	
	@GetMapping(value="/dropDownList")
	@ApiOperation(value = "下拉列表")
	@PreAuthorize("hasAuthority('system:role:save') or hasAuthority('system:role:update')")
	AbstractBaseResult<List<DropDownResult>> dropDownListResult();
	
	@Api(tags = "【平台】【V1】角色模块")
	@RequestMapping("/role/platform/v1/{id}")
	public interface RestRoleServiceCurrentV1 {

		@GetMapping(value="/get")
		@ApiOperation(value = "详情")
		@PreAuthorize("hasAuthority('system:role:get')")
		AbstractBaseResult<InfoVo> restGet(@PathVariable Long id);
		
		@PostMapping(value="/remove")
		@ApiOperation(value = "删除")
		@PreAuthorize("hasAuthority('system:role:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);
		
		@PostMapping(value="/update")
		@ApiOperation(value = "更新")
		@PreAuthorize("hasAuthority('system:role:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody SaveUpdateParam param);
		
		@PostMapping(value="/updateStatus")
		@ApiOperation(value = "更新状态")
		@PreAuthorize("hasAuthority('system:role:update')")
		AbstractBaseResult<Void> updateStatus(@PathVariable Long id);
		
	}

}
