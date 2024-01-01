package com.maozi.system.config.api.impl.rest.v1.global;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.maozi.base.annotation.RestService;
import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.config.api.impl.RegionServiceImpl;
import com.maozi.system.config.api.rest.v1.global.RestRegionServiceV1;
import com.maozi.system.config.domain.RegionDo;
import java.util.List;

@RestService
public class RestRegionServiceImplV1 extends RegionServiceImpl implements RestRegionServiceV1 {

	@Override
	public AbstractBaseResult<List<DropDownResult>> list(Long parentId) {
		
		MPJLambdaWrapper<RegionDo> wrapper = MPJWrappers.lambdaJoin(RegionDo.builder().parentId(parentId).build());
		
		wrapper.select(RegionDo::getId,RegionDo::getName);
		
		return success(list(wrapper,DropDownResult::new));
		
	}

}
