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

package com.jiumao.user.permission.api.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.jiumao.user.permission.api.PermissionService;
import com.jiumao.user.permission.api.RolePermissionService;
import com.jiumao.user.permission.domain.PermissionDo;
import com.jiumao.user.permission.mapper.PermissionMapper;

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

public class PermissionServiceImpl extends MPJBaseServiceImpl<PermissionMapper, PermissionDo> implements PermissionService{
	
	@Resource(name = "rolePermissionServiceImpl")
	private RolePermissionService rolePermissionService;

	@Override
	public List<String> getPermissionsByRoleId(Long roleId) throws Exception {
		
		List<Long> permissionIds = rolePermissionService.getPermissionIdsByRoleId(roleId);
		
		if(permissionIds.size() < 1) {
			return null;
		}
		
		List<PermissionDo> permissions = listByIds(permissionIds, getColumns(PermissionDo::getEnname));
		
		return permissions.stream().map(PermissionDo::getEnname).collect(Collectors.toList());
		
	}

}
