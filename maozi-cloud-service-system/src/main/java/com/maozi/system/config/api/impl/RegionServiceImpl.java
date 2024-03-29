package com.maozi.system.config.api.impl;

import com.maozi.base.api.impl.BaseServiceImpl;
import com.maozi.system.config.api.RegionService;
import com.maozi.system.config.domain.RegionDo;
import com.maozi.system.config.mapper.RegionMapper;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends BaseServiceImpl<RegionMapper,RegionDo,Void> implements RegionService {

	@Override
	protected String getAbbreviationModelName() {return "【地区】";}

}
