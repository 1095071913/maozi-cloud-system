package com.maozi.system.role.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RoleListVo extends AbstractBaseVomain{
	
	@Schema(description = "标识")
	private Long id;
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "描述")
	private String description;
	
	@Schema(description = "更新时间")
	private Long updateTime;
	
	@Schema(description = "状态",ref = "EnumResult")
	private Status status;
	
}
