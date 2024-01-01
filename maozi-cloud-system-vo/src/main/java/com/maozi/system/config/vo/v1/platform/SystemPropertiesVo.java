package com.maozi.system.config.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SystemPropertiesVo extends AbstractBaseVomain {
	
	@ApiModelProperty("项目名称")
	private String projectName;
	
	@ApiModelProperty("公司名称")
	private String corporationName;
	
	@ApiModelProperty("项目图标")
	private String icon;
	
	@ApiModelProperty("项目环境")
	private String environment;
	
	@ApiModelProperty("项目描述")
	private String description;
	
	@ApiModelProperty("项目版权")
	private String copyright;

}
