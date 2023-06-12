package com.maozi.system.permission.vo.v1.platform;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropDownResult extends com.maozi.base.result.DropDownResult{

	@ApiModelProperty("上级ID")
	private Long parentId;
	
	@ApiModelProperty("深度")
	private Integer level;
	
}
