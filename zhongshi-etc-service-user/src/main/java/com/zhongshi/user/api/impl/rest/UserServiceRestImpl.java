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

package com.zhongshi.user.api.impl.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Maps;
import com.zhongshi.factory.result.AbstractBaseResult;
import com.zhongshi.sso.api.OauthTokenServiceRpc;
import com.zhongshi.user.api.UserServiceRest;
import com.zhongshi.user.api.impl.UserServiceImpl;
import com.zhongshi.user.domain.UserDo;
import com.zhongshi.uservo.LoginAndRegisterVo;

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

public class UserServiceRestImpl extends UserServiceImpl implements UserServiceRest {

	@DubboReference
	protected OauthTokenServiceRpc oauthTokenServiceRpc;
	
	@Override
	public AbstractBaseResult<UserDo> userRegister(LoginAndRegisterVo loginAndRegisterVo) {
		
		Integer userCount = count(new QueryWrapper<UserDo>(UserDo.builder().username(loginAndRegisterVo.getUsername()).build()));
		if (userCount > 0) {
			return error(code(2002));
		}
		
		UserDo user = copy(loginAndRegisterVo,UserDo.class);
		user.setPassword("{MD5}"+passwordEncoder.encode(user.getPassword()));
		if (!save(user)) {
			return error(code(2004));
		}
		
		return success("注册成功");
	}


	@Override
	public AbstractBaseResult userLogin(LoginAndRegisterVo loginAndRegisterVo) {
		
		Map<String, String> params = Maps.newHashMap();
		params.put("username", loginAndRegisterVo.getUsername());
		params.put("password", loginAndRegisterVo.getPassword());
		params.put("grant_type", "password");    
		params.put("client_id", "client");    
		params.put("client_secret", "secret"); 
		DefaultOAuth2AccessToken oAuth2AccessToken = oauthTokenServiceRpc.getToken(params).ifResultThrowErrorOrGetData();
		
		Long tokenTime=(oAuth2AccessToken.getExpiration().getTime()-System.currentTimeMillis())/1000;
		
		
		Map<String, String> data = Maps.newHashMap();
		data.put("accessToken",oAuth2AccessToken.getValue());
		data.put("refreshToken",oAuth2AccessToken.getRefreshToken().getValue());
		data.put("expiresTime",tokenTime.toString());
		return success(data);

	}
	
	
	@Override
	public AbstractBaseResult userLogout(HttpServletRequest request) throws Exception {
		return oauthTokenServiceRpc.destroyToken(request.getHeader("Authorization").replace("Bearer ", ""));
	}


	@Override
	public AbstractBaseResult<Map<String, Object>> getUserInfo() {
		Map<String, Map<String,Object>> userInfo = userInfo();
		return isNull(userInfo) ? error(code(2010)) : success(userInfo);
	}

}
