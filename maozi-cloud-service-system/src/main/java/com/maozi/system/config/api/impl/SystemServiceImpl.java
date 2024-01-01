package com.maozi.system.config.api.impl;

import com.maozi.common.BaseCommon;
import com.maozi.system.config.api.SystemService;
import com.maozi.system.config.properties.SystemProperties;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl extends BaseCommon implements SystemService {
	
	@Resource
	protected SystemProperties systemProperties;

}
