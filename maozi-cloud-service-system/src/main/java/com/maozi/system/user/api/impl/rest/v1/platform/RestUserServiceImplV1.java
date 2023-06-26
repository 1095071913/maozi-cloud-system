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

package com.maozi.system.user.api.impl.rest.v1.platform;

import com.maozi.base.annotation.RestService;
import com.maozi.base.enums.Status;
import com.maozi.base.param.PageParam;
import com.maozi.base.result.PageResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.sso.oauth.dto.platform.dto.OauthToken;
import com.maozi.sso.oauth.dto.platform.param.ClientParam;
import com.maozi.sso.oauth.dto.platform.param.ClientUserParam;
import com.maozi.sso.oauth.dto.platform.param.TokenInfoParam;
import com.maozi.system.user.api.impl.UserServiceImpl;
import com.maozi.system.user.api.rest.v1.platform.RestUserServiceV1;
import com.maozi.system.user.domain.UserDo;
import com.maozi.system.user.vo.v1.platform.IndividualInfoVo;
import com.maozi.system.user.vo.v1.platform.InfoVo;
import com.maozi.system.user.vo.v1.platform.ListVo;
import com.maozi.user.user.dto.v1.platform.AccountParam;
import com.maozi.user.user.dto.v1.platform.ListParam;
import com.maozi.user.user.dto.v1.platform.SaveUpdateParam;

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

@RestService
public class RestUserServiceImplV1 extends UserServiceImpl implements RestUserServiceV1 {

	@Override
	public AbstractBaseResult<OauthToken> restGetToken(AccountParam param) throws Exception {
		
		TokenInfoParam tokenParam = TokenInfoParam.builder().clientId(clientId).clientSecret(clientSecret).username(param.getUsername()).password(param.getPassword()).build();
	    
	    return success(rpcOauthTokenServiceV1.rpcGet(tokenParam).getResultDataThrowError());
	    
	}

	@Override
	public AbstractBaseResult<PageResult<ListVo>> restList(PageParam<ListParam> pageParam) {
		return success(listRelation(pageParam,ListVo::new));
	}
	
	@Override
	public AbstractBaseResult<Long> restSave(SaveUpdateParam param) {
		return success(restSaveUpdate(null,param));
	}

	@RestService
	public class RestUserServiceUserImplV1 extends UserServiceImpl implements RestUserServiceCurrentV1{

		@Override
		public AbstractBaseResult<Void> restRemove(Long id) {
			
			UserDo user = getById(id, UserDo::getUsername,UserDo::getClientId);
			
			rpcOauthTokenServiceV1.rpcDestroy(new ClientUserParam(user.getClientId(),user.getUsername())).getResultDataThrowError();
			
			return removeByIdResult(id);
			
		}
		
		@Override
		public AbstractBaseResult<InfoVo> restGet(Long id) {
			return success(getByIdThrowErrorRelation(id,InfoVo.class));
		}
		
		@Override
		public AbstractBaseResult<Void> restUpdate(Long id,SaveUpdateParam param) {
			
			restSaveUpdate(id,param);
			
			UserDo user = getById(id, UserDo::getUsername,UserDo::getClientId);
			
			rpcOauthTokenServiceV1.rpcDestroy(new ClientUserParam(user.getClientId(),user.getUsername())).getResultDataThrowError();
			
			return success(null);
			
		}
		
		@Override
		public AbstractBaseResult<Void> restUpdateStatus(Long id){
			
			UserDo user = getByIdThrowError(id,UserDo::getUsername,UserDo::getClientId,UserDo::getStatus);
			
			updateById(UserDo.builder().id(id).status(user.getStatus() == Status.enable ? Status.disable : Status.enable).build());
			
			if(user.getStatus() == Status.enable) {
				rpcOauthTokenServiceV1.rpcDestroy(new ClientUserParam(user.getClientId(),user.getUsername())).getResultDataThrowError();
			}
			
			return updateStatus(id);
			
		}
		
	}
	
	@RestService
	public class RestUserServiceIndividualImplV1 extends UserServiceImpl implements RestUserServiceIndividualV1{
		
		@Override
		public AbstractBaseResult<IndividualInfoVo> restIndividualGet() {
			return success(getByUsername(getCurrentUserName(),IndividualInfoVo.class,getColumns(UserDo::getName,UserDo::getIcon)));
		}

		@Override
		public AbstractBaseResult<OauthToken> restIndividualRefreshToken() throws Exception {
			
			ClientParam tokenParam = ClientParam.builder().clientId(clientId).clientSecret(clientSecret).build();
			
			return rpcOauthTokenServiceV1.rpcRefresh(getRequest().getHeader("Authorization").replace("Bearer ", ""),tokenParam);
			
		}

		@Override
		public AbstractBaseResult<Void> restIndividualDestroyToken() {
			
			rpcOauthTokenServiceV1.rpcDestroy(getRequest().getHeader("Authorization").replace("Bearer ", "")).getResultDataThrowError();
			
			return success(null);
			
		}
		
	}

}