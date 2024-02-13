package com.maozi.system.config.api.rest.v1.global;

import com.maozi.base.annotation.Get;
import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "【全局】【V1】地区模块")
public interface RestRegionServiceV1 {

	String PATH = "/config/global/v1";

	@Get(value = PATH + "/region/{parentId}/list",description = "列表")
	AbstractBaseResult<List<DropDownResult>> list(@PathVariable("parentId") Long parentId);
	
}