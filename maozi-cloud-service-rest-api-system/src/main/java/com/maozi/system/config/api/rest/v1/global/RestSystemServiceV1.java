package com.maozi.system.config.api.rest.v1.global;

import com.maozi.base.annotation.Get;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.config.vo.v1.platform.SystemPropertiesVo;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "【全局】【V1】系统模块")
public interface RestSystemServiceV1 {

	String PATH = "/config/global/v1";

	@Get(value = PATH + "/system/get",description = "详情")
	AbstractBaseResult<SystemPropertiesVo> get();

}
