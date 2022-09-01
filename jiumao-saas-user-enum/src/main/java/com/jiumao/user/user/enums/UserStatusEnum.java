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

package com.jiumao.user.user.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.jiumao.enums.config.annotation.SwaggerDisplayEnum;

import lombok.Getter;
import lombok.Setter;

/**	
 * 
 *  Specifications：功能
 * 
 *  Author：彭晋龙
 * 
 *  Creation Date：2021-12-18:16:32:34
 *
 *  Copyright Ownership：xiao mao zi
 * 
 *  Agreement That：Apache 2.0
 * 
 */

@SwaggerDisplayEnum
public enum UserStatusEnum {

	enable(0,"启用"),disable(1,"禁用");
	
	UserStatusEnum(Integer key,String value) {
		this.key=key;
		this.value=value;
	}
	
	@Getter
	@Setter 
	@EnumValue
	private Integer key;
	
	@Getter
	@Setter 
	public String value;
	
}