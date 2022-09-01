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

package com.jiumao.user.user.api.impl.rest.v1.pc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiumao.factory.result.AbstractBaseResult;
import com.jiumao.factory.result.error.exception.BusinessResultException;
import com.jiumao.user.api.rest.v1.pc.UserServiceRestV1;
import com.jiumao.user.dto.v1.pc.UpdateUserV1Dto;
import com.jiumao.user.user.api.impl.UserServiceImpl;
import com.jiumao.user.user.domain.UserDo;
import com.jiumao.user.vo.pc.LoginVo;

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

public class UserServiceRestV1Impl extends UserServiceImpl implements UserServiceRestV1 {
	
	@Override
	public AbstractBaseResult<LoginVo> restUserLogin(String username,String password) {
		return success(userLogin(username, password));
	}

	@Override
	public AbstractBaseResult<Void> restUpdateUser(UpdateUserV1Dto param) {
		
		if(isNull(param.getId())) {
			
			isNullThrow(param.getPassword(), "密码");
			
			if(count(new QueryWrapper<UserDo>(UserDo.builder().username(param.getUsername()).build())) > 0) {
				throw new BusinessResultException("账号已存在");
			}
			
		}
		
		if(isNotNull(param.getPassword())) {
			param.setPassword("{MD5}"+passwordEncoder.encode(param.getPassword()));
		}
		
		save(copy(param, UserDo.class));
		
		return success(null);
		
	}

}
