package com.maozi.system.user.api.impl.rpc.v1;

import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.user.api.impl.UserServiceImpl;
import com.maozi.system.user.api.rpc.v1.RpcUserInfoServiceV1;
import com.maozi.system.user.dto.global.dto.SystemUser;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class RpcUserInfoServiceImplV1 extends UserServiceImpl implements RpcUserInfoServiceV1 {

	@Override
	public AbstractBaseResult<SystemUser> rpcGetByUsername(String username, String... colums) {
		return success(getByUsername(username,SystemUser.class,colums));
	}

}
