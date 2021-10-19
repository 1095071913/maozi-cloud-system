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

package com.zhongshi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhongshi.factory.result.AbstractBaseResult;

/**
 * 
 * 功能说明：SSO认证授权启动
 * 
 * 功能作者：彭晋龙 ( 联系方式QQ/微信1.：1095071913 ) 
 * 
 * 创建日期：2019-10-04 ：9:37:0
 *
 * 版权归属：蓝河团队
 * 
 * 
 * 协议说明：Apache2.0（ 文件顶端 ）
 * 
 */
@RestController
public class UserApplication extends BaseApplicationDB {

	public static void main(String[] args) {
		ApplicationRun(UserApplication.class);	
	}
	
	@Autowired
	public FeignTest feignTest;
	
	@GetMapping("/test1")
	public AbstractBaseResult test1() {
		
		return feignTest.test2();
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "成功";
	}

}