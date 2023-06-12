package com.maozi.system.config.api.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.maozi.common.BaseCommon;
import com.maozi.system.config.api.SystemService;
import com.maozi.system.config.properties.SystemProperties;

@Service
public class SystemServiceImpl extends BaseCommon implements SystemService {
	
	@Resource
	protected SystemProperties systemProperties;

}
