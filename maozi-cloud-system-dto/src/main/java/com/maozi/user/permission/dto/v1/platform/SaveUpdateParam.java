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

package com.maozi.user.permission.dto.v1.platform;

import javax.validation.constraints.NotNull;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.system.permission.enums.PermissionType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveUpdateParam extends AbstractBaseDtomain {
	
	@ApiModelProperty("上级ID")
	private Long parentId;
	
	@ApiModelProperty("名称")
	@NotNull(message = "名称不能为空")
	private String name;
	
	@ApiModelProperty("图标")
	@NotNull(message = "图标不能为空")
	private String icon;

	@ApiModelProperty("标识")
	@NotNull(message = "标识不能为空")
	private String mark;
	
	@ApiModelProperty("深度")
	@NotNull(message = "深度不能为空")
	private Integer level;
	
	@ApiModelProperty("路由")
	private String route;
	
	@ApiModelProperty("服务地址")
	private String serviceUri;
	
	@ApiModelProperty("类型")
	@NotNull(message = "类型不能为空")
	private PermissionType type;
	
	@ApiModelProperty("排序")
	private Integer sort;
	
}
