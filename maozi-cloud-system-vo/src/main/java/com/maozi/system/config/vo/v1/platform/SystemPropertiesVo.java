package com.maozi.system.config.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SystemPropertiesVo extends AbstractBaseVomain {
	
	@Schema(description = "项目名称")
	private String projectName;
	
	@Schema(description = "公司名称")
	private String corporationName;
	
	@Schema(description = "项目图标")
	private String icon;
	
	@Schema(description = "项目环境")
	private String environment;
	
	@Schema(description = "项目描述")
	private String description;
	
	@Schema(description = "项目版权")
	private String copyright;

}
