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

package com.maozi.system.permission.api.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.maozi.base.api.impl.BaseServiceImpl;
import com.maozi.system.permission.api.PermissionService;
import com.maozi.system.permission.api.RolePermissionService;
import com.maozi.system.permission.domain.RolePermissionDo;
import com.maozi.system.permission.mapper.RolePermissionMapper;

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

@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper,RolePermissionDo,Void> implements RolePermissionService {
	
	@Resource(name = "permissionServiceImpl")
	private PermissionService permissionService;
	
	@Override
	protected String getAbbreviationModelName() {return "【角色权限关系】";}

	@Override
	public void checkRoleBindPermissionByPermission(Long permissionId) {
		
		MPJLambdaWrapper<RolePermissionDo> wrapper = MPJWrappers.lambdaJoin(RolePermissionDo.builder().permissionId(permissionId).build());
		
		checkBoolThrowError(count(wrapper) < 1 , "【权限】已被角色绑定");
		
	}

	@Override
	public void updateBind(Long roleId, List<Long> bindPermissionIds, List<Long> unbindPermissionIds) {
		
		if(collectionIsNotEmpty(bindPermissionIds)) {
			
			SecurityContext securityContext = SecurityContextHolder.getContext();
			
			bindPermissionIds.parallelStream().forEach((permissionId)->{
				
				SecurityContextHolder.setContext(securityContext);
				
				RolePermissionDo domainSave = RolePermissionDo.builder().roleId(roleId).permissionId(permissionId).build();
				
				if(count(MPJWrappers.lambdaJoin(domainSave)) < 1 && permissionService.has(permissionId)) {
					save(domainSave);
				}
				
				clear();
				
			});
			
		}
		
		if(collectionIsNotEmpty(unbindPermissionIds)) {
			
			unbindPermissionIds.parallelStream().forEach((permissionId)->{
				
				remove(MPJWrappers.lambdaJoin(RolePermissionDo.builder().roleId(roleId).permissionId(permissionId).build()));
				
				clear();
				
			});
			
		}
		
	}

	@Override
	public Collection<Long> getPermissionsByRoles(List<Long> roleIds) {
		
		MPJLambdaWrapper<RolePermissionDo> wrapper = MPJWrappers.lambdaJoin();
		
		wrapper.select(RolePermissionDo::getPermissionId);
		
		wrapper.in(RolePermissionDo::getRoleId, roleIds);
		
		return list(wrapper).stream().map(RolePermissionDo::getPermissionId).collect(Collectors.toSet());
		
	}

	@Override
	public List<Long> getPermissionsByRole(Long roleId) {
		
		MPJLambdaWrapper<RolePermissionDo> wrapper = MPJWrappers.lambdaJoin();
		
		wrapper.select(RolePermissionDo::getPermissionId);
		
		wrapper.eq(RolePermissionDo::getRoleId, roleId);
		
		return list(wrapper).stream().map(RolePermissionDo::getPermissionId).collect(Collectors.toList());
		
	}
	
	

}