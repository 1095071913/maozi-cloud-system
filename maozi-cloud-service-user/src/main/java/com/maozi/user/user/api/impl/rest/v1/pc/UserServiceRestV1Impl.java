/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.maozi.user.user.api.impl.rest.v1.pc;

import org.springframework.stereotype.Service;

import com.maozi.factory.result.AbstractBaseResult;
import com.maozi.sso.info.SystemUser;
import com.maozi.user.user.api.impl.UserServiceImpl;
import com.maozi.user.user.api.rest.v1.pc.UserServiceRestV1;
import com.maozi.user.user.domain.UserDo;
import com.maozi.user.user.dto.rest.v1.pc.UpdateUserV1Dto;
import com.maozi.user.vo.v1.pc.LoginVo;

/**
 * 
 * 功能说明：用户Rest API实现
 * 
 * 功能作者：彭晋龙 ( 联系方式QQ/微信：1095071913 )
 *
 * 创建日期：2019-10-03 ：23:08:00
 *
 * 版权归属：蓝河团队
 *
 * 协议说明：Apache2.0（ 文件顶端 ）
 *
 */

@Service
public class UserServiceRestV1Impl extends UserServiceImpl implements UserServiceRestV1 {
	
	@Override
	public AbstractBaseResult<LoginVo> restUserLogin(String username,String password) {
		return success(userLogin(username, password));
	}

	@Override
	public AbstractBaseResult<Void> restUpdateUser(UpdateUserV1Dto param) {
		
		if(isNotNull(param.getPassword())) {
			param.setPassword("{MD5}"+passwordEncoder.encode(param.getPassword()));
		}
		
		UserDo user = copy(param, UserDo.class);
		
		user.setId(getOauthUserDetail(SystemUser.class).getId());;
		
		updateById(user);
		
		return success(null);
		
	}

}
