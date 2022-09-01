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

package com.jiumao.user.api.rest.v1.pc;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiumao.factory.result.AbstractBaseResult;
import com.jiumao.user.dto.v1.pc.UpdateUserV1Dto;
import com.jiumao.user.vo.pc.LoginVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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

//@FeignClient(value = "zhongshi-etc-user", configuration = FeignRequestConfiguration.class, fallback = ProfileFeignFallback.class)
@Api(tags = "【后台】【V1】用户模块")
@RequestMapping("/user/pc/v1")	
@RestController
public interface UserServiceRestV1{
	
	@GetMapping(value="/login")
	@ApiOperation(value = "用户登录")
	AbstractBaseResult<LoginVo> restUserLogin(@RequestParam String username,@RequestParam String password) throws Exception;
	
	@PostMapping("/update")
	@ApiOperation(value = "更新用户信息")
	AbstractBaseResult<Void> restUpdateUser(@Validated @RequestBody UpdateUserV1Dto param);
	
}
