package com.maozi.system.permission.enums;

import com.maozi.base.IEnum;
import com.maozi.base.enums.config.annotation.SwaggerDisplayEnum;

import lombok.Getter;
import lombok.Setter;

@SwaggerDisplayEnum
public enum PermissionType implements IEnum{

	directory(0,"目录"),menu(1,"菜单"),button(2,"按钮");
	
	PermissionType(Integer value,String desc) {
		
		this.value = value;
		
		this.desc = desc;
		
	}
	
	@Getter
	@Setter
	private Integer value;
	
	@Getter
	@Setter
	private String desc;
	
}
