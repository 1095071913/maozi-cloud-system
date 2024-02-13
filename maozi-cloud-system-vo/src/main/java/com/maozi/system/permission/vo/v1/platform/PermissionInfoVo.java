package com.maozi.system.permission.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.system.permission.enums.PermissionType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionInfoVo extends AbstractBaseVomain {
	
	@Schema(description = "上级ID")
	private Long parentId;
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "图标")
	private String icon;
	
	@Schema(description = "标识")
	private String mark;
	
	@Schema(description = "路由")
	private String route;
	
	@Schema(description = "服务地址")
	private String serviceUri;
	
	@Schema(description = "类型")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private PermissionType type;
	
	@Schema(description = "排序")
	private Integer sort;
	
}
