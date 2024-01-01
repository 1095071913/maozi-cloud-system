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
 */
package com.maozi.system.permission.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.maozi.base.AbstractBaseNameDomain;
import com.maozi.system.permission.enums.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 
 * 	功能说明：用户Do
 * 
 *	功能作者：彭晋龙 ( 联系方式QQ/微信：1095071913 )
 *
 *	创建日期：2019-10-02 : 20:03:00
 *
 *	版权归属：蓝河团队
 *
 *	协议说明：Apache2.0（ 文件顶端 ）
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@TableName("system_permission")
@TableComment("权限")
public class PermissionDo extends AbstractBaseNameDomain {
	
	@Column(value = "parent_id",comment = "父ID",defaultValue = "0")
	private Long parentId;
	
	@Column(value = "icon",comment = "图标")
	private String icon;
	
	@Column(value = "mark",comment = "标识")
	private String mark;
	
	@Column(value = "level",comment = "深度")
	private Integer level;
	
	@Column(value = "route",comment = "路由")
	private String route;
	
	@Column(value = "service_uri",comment = "服务地址")
	private String serviceUri;
	
	@Column(value = "type",type = MySqlTypeConstant.BIGINT,comment = "类型")
	private PermissionType type;
	
	@Column(value = "sort",comment = "排序",defaultValue = "0")
	private Integer sort;
	
}
