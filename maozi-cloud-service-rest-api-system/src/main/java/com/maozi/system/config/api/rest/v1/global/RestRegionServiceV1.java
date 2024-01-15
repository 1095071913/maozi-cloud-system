package com.maozi.system.config.api.rest.v1.global;

import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "【全局】【V1】地区模块")
@RequestMapping("/config/global/v1")
public interface RestRegionServiceV1 {

	@GetMapping("/region/{parentId}/list")
	@ApiOperation(value = "列表")
	AbstractBaseResult<List<DropDownResult>> list(@PathVariable("parentId") Long parentId);
	
}
