package com.maozi.system.role.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ListVo extends AbstractBaseVomain{
	
	@ApiModelProperty("标识")
	private Long id;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("描述")
	private String description;
	
	@ApiModelProperty("更新时间")
	private Long updateTime;
	
	@ApiModelProperty(value = "状态",dataType = "com.maozi.base.result.EnumResult")
	private Status status;
	
}
