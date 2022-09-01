
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

package com.jiumao.user.user.api.impl;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.google.common.collect.Maps;
import com.jiumao.factory.result.AbstractBaseResult;
import com.jiumao.sso.api.OauthTokenServiceRpcV1;
import com.jiumao.user.user.api.UserService;
import com.jiumao.user.user.domain.UserDo;
import com.jiumao.user.user.mapper.UserMapper;
import com.jiumao.user.vo.pc.AccessTokenVo;
import com.jiumao.user.vo.pc.LoginVo;
import com.zhongshi.sso.info.SystemUser;
  
/**
 * 
 * 功能说明：用户服务实现
 * 
 * 功能作者：彭晋龙 ( 联系方式QQ/微信：1095071913 )
 *
 * 创建日期：2019-08-03 ：1:32:00
 *
 * 版权归属：蓝河团队
 *
 * 协议说明：Apache2.0（ 文件顶端 ）
 *
 */

public class UserServiceImpl extends MPJBaseServiceImpl<UserMapper, UserDo> implements UserService {
	
	@DubboReference
	protected OauthTokenServiceRpcV1 oauthTokenServiceRpcV1;
	
	public UserServiceImpl() { setServiceName("user"); }
	
	protected PasswordEncoder passwordEncoder = new MessageDigestPasswordEncoder("MD5");

	// 刷新token
	protected AbstractBaseResult<?> refreshToken(String refreshToken) {
		return null;
	}

	@Override
	public SystemUser getUserByUsername(String username) {
		return copy(getOne(new QueryWrapper<UserDo>(UserDo.builder().username(username).build())), SystemUser.class);
	}
	
	protected LoginVo userLogin(String username,String password) {
		
		Map<String, String> params = Maps.newHashMap();
		params.put("username", username);
		params.put("password", password);
		params.put("grant_type", "password");    
		params.put("client_id", "client");    
		params.put("client_secret", "secret"); 
		DefaultOAuth2AccessToken oAuth2AccessToken = oauthTokenServiceRpcV1.getToken(params).ifResultThrowErrorOrGetData();
		
		Long tokenTime=(oAuth2AccessToken.getExpiration().getTime()-System.currentTimeMillis())/1000;
		
		AccessTokenVo accessToken = new AccessTokenVo(oAuth2AccessToken.getValue(),oAuth2AccessToken.getRefreshToken().getValue(),tokenTime.toString());
		
		SystemUser user = copy(getOne(new LambdaQueryWrapper<UserDo>(UserDo.builder().username(username).build()).select(UserDo::getId,UserDo::getUsername,UserDo::getStatus)), SystemUser.class);
		
		return new LoginVo(accessToken,user);
		
	}
	
}
