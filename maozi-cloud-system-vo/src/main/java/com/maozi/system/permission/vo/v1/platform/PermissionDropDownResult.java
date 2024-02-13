package com.maozi.system.permission.vo.v1.platform;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDropDownResult extends com.maozi.base.result.DropDownResult{

	@Schema(description = "上级ID")
	private Long parentId;
	
	@Schema(description = "深度")
	private Integer level;
	
}
