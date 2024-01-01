package com.maozi.system.config.api.rest.v1.global;

import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.config.vo.v1.platform.SystemPropertiesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "【全局】【V1】系统模块")
@RequestMapping("/config/global/system")
public interface RestSystemService {
	
	@GetMapping("/get")
	@ApiOperation(value = "详情")
	AbstractBaseResult<SystemPropertiesVo> get();

}
