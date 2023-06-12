package com.maozi.system.config.api.impl.rpc.v1;

import org.apache.dubbo.config.annotation.DubboService;

import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.config.api.impl.RegionServiceImpl;
import com.maozi.system.config.api.rpc.v1.RpcRegionServiceV1;

@DubboService
public class RpcRegionServiceImplV1 extends RegionServiceImpl implements RpcRegionServiceV1{

	@Override
	public AbstractBaseResult<DropDownResult> rpcGet(Long id) {
		return success(dropDown(id));
	}

}
