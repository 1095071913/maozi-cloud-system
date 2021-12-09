
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

package com.zhongshi.uservo;

import javax.validation.constraints.NotNull;
import com.zhongshi.base.AbstractBaseVomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 
 * 	功能说明：登录与注册VO
 * 
 *	功能作者：彭晋龙 ( 联系方式QQ/微信：1095071913 )
 *
 *	创建日期：2019-10-01 ：6:32:00
 *
 *	版权归属：蓝河团队
 *
 *	协议说明：Apache2.0（ 文件顶端 ）
 *
 */

@Data
@ApiModel(value ="LoginAndRegisterVo",description="登录与注册")
public class LoginAndRegisterVo extends AbstractBaseVomain{
    
	@ApiModelProperty(value = "用户名", required = true)
	@NotNull(message = "用户名不能为空")
	private String username;
	
    @ApiModelProperty(value = "密码", required = true)
	@NotNull(message = "密码不能为空")
	private String password;
    
    @ApiModelProperty(value = "用户角色", required = true)
	private Long permissionId;
    
    @ApiModelProperty(value = "昵称", required = true)
	private String nickName;
    
}
