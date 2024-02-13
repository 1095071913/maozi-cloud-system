package com.maozi.system.permission.vo.v1.platform;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.system.permission.enums.PermissionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionListVo extends AbstractBaseDtomain{

	@Schema(description = "标识")
	private Long id;
	
	@Schema(description = "上级ID")
	private Long parentId;
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "图标")
	private String icon;
	
	@Schema(description = "标识")
	private String mark;
	
	@Schema(description = "类型",ref = "EnumResult")
	private PermissionType type;
	
}
