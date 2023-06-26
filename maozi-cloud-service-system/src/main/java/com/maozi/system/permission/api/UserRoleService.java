package com.maozi.system.permission.api;

import java.util.List;

public interface UserRoleService {
	
	void checkUserBindRoleByRole(Long roleId);
	
	void updateBind(Long userId,List<Long> bindRoleIds,List<Long> unbindRoleIds);
	
	List<Long> getRolesByUser(Long userId);
	
	List<Long> getUsersByRole(Long roleId);
	
	void hasUserBindRole(Long userId,Long roleId);
	
	void userUnbind(Long userId);

}