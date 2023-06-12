package com.maozi.system.permission.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.system.permission.enums.PermissionType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoVo extends AbstractBaseVomain {
	
	@ApiModelProperty("上级ID")
	private Long parentId;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("图标")
	private String icon;
	
	@ApiModelProperty("标识")
	private String mark;
	
	@ApiModelProperty("路由")
	private String route;
	
	@ApiModelProperty("服务地址")
	private String serviceUri;
	
	@ApiModelProperty("类型")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private PermissionType type;
	
	@ApiModelProperty("排序")
	private Integer sort;
	
}
