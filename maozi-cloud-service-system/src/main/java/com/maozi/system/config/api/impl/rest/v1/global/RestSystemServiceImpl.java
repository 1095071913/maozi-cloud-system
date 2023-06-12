package com.maozi.system.config.api.impl.rest.v1.global;

import com.maozi.base.annotation.RestService;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.config.api.impl.SystemServiceImpl;
import com.maozi.system.config.api.rest.v1.global.RestSystemService;
import com.maozi.system.config.vo.v1.platform.SystemPropertiesVo;

@RestService
public class RestSystemServiceImpl extends SystemServiceImpl implements RestSystemService {

	@Override
	public AbstractBaseResult<SystemPropertiesVo> get() {
		return success(copy(systemProperties, SystemPropertiesVo.class));
	}

}
