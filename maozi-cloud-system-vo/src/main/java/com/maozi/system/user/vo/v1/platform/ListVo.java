package com.maozi.system.user.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.result.DropDownResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListVo extends AbstractBaseVomain {
	
	@ApiModelProperty("标识")
	private Long id;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("客户端")
	private DropDownResult client;
	
	@ApiModelProperty(value = "状态",dataType = "com.maozi.base.result.EnumResult")
	private Status status;
	
	@ApiModelProperty("更新时间")
	private Long updateTime;
	
}
