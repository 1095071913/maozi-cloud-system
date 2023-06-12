package com.maozi.system.user.vo.v1.platform;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class InfoVo extends AbstractBaseVomain{
	
	@ApiModelProperty("账号")
	private String username;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("客户端")
	private DropDownResult client;
	
	@ApiModelProperty("图标")
	private String icon;
	
	@ApiModelProperty("状态")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Status status;
	
	@ApiModelProperty(value = "权限列表",dataType = "com.maozi.base.result.ListStringResult")
	private List<Long> roleIds;

}
