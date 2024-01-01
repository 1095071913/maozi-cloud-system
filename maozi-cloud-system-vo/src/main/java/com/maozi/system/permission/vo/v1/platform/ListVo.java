package com.maozi.system.permission.vo.v1.platform;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.system.permission.enums.PermissionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListVo extends AbstractBaseDtomain{

	@ApiModelProperty("标识")
	private Long id;
	
	@ApiModelProperty("上级ID")
	private Long parentId;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("图标")
	private String icon;
	
	@ApiModelProperty("标识")
	private String mark;
	
	@ApiModelProperty(value = "类型",dataType = "com.maozi.base.result.EnumResult")
	private PermissionType type;
	
}
