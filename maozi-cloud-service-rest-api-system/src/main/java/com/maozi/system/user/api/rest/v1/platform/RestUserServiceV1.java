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

package com.maozi.system.user.api.rest.v1.platform;

import com.maozi.base.param.PageParam;
import com.maozi.base.result.PageResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.oauth.token.dto.platform.dto.OauthToken;
import com.maozi.system.user.vo.v1.platform.IndividualInfoVo;
import com.maozi.system.user.vo.v1.platform.InfoVo;
import com.maozi.system.user.vo.v1.platform.ListVo;
import com.maozi.user.user.dto.v1.platform.AccountParam;
import com.maozi.user.user.dto.v1.platform.ListParam;
import com.maozi.user.user.dto.v1.platform.SaveUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 	功能说明：领域模型Do
 * 
 *	功能作者：彭晋龙 ( 联系方式QQ/微信：1095071913 )
 *
 *	创建日期：2019-09-02 : 1:36:00
 *
 *	版权归属：蓝河团队
 *
 *	协议说明：Apache2.0（ 文件顶端 ）
 *
 */


@Api(tags = "【平台】【V1】用户模块")
@RequestMapping("/user/platform/v1")
public interface RestUserServiceV1 {
	
	@PostMapping(value="/getToken")
	@ApiOperation(value = "【个人】获取通行令牌")
	AbstractBaseResult<OauthToken> restGetToken(@RequestBody @Valid AccountParam param) throws Exception;
	
	@PostMapping(value="/list")
	@ApiOperation(value = "【管理员】列表")
	@PreAuthorize("hasAuthority('system:user:list')")
	AbstractBaseResult<PageResult<ListVo>> restList(@RequestBody PageParam<ListParam> pageParam);
	
	@PostMapping(value = "/save")
	@ApiOperation(value = "【管理员】保存")
	@PreAuthorize("hasAuthority('system:user:save')")
	AbstractBaseResult<Long> restSave(@RequestBody SaveUpdateParam param);
	
	@Api(tags = "【平台】【V1】用户模块")
	@RequestMapping("/user/platform/v1/{id}")
	public interface RestUserServiceCurrentV1{
		
		@GetMapping(value="/get")
		@ApiOperation(value = "【管理员】详情")
		@PreAuthorize("hasAuthority('system:user:get')")
		AbstractBaseResult<InfoVo> restGet(@PathVariable Long id);
		
		@PostMapping("/remove")
		@ApiOperation(value = "【管理员】删除")
		@PreAuthorize("hasAuthority('system:user:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);
		
		@PostMapping(value="/updateStatus")
		@ApiOperation(value = "【管理员】更新状态")
		@PreAuthorize("hasAuthority('system:user:update')")
		AbstractBaseResult<Void> restUpdateStatus(@PathVariable Long id);
		
		@PostMapping("/update")
		@ApiOperation(value = "【管理员】更新")
		@PreAuthorize("hasAuthority('system:user:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody SaveUpdateParam param);
		
	}
	
	@Api(tags = "【平台】【V1】用户模块")
	@RequestMapping("/user/platform/v1/individual")
	public interface RestUserServiceIndividualV1{
		
		@GetMapping("/get")
		@ApiOperation(value = "【个人】详情")
		AbstractBaseResult<IndividualInfoVo> restIndividualGet();
		
		@PostMapping("/refreshToken")
		@ApiOperation(value = "【个人】刷新令牌")
		AbstractBaseResult<OauthToken> restIndividualRefreshToken() throws Exception;
		
		@PostMapping("/destroyToken")
		@ApiOperation(value = "【个人】销毁令牌")
		AbstractBaseResult<Void> restIndividualDestroyToken();
		
	}
	
}
