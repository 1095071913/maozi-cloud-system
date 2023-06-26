package com.maozi.system.user.vo.v1.platform;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.plugin.QueryRelation;
import com.maozi.base.result.DropDownResult;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoVo extends AbstractBaseVomain {
	
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private Long id;
	
	@ApiModelProperty("账号")
	private String username;
	
	@ApiModelProperty("名称")
	private String name;
	
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private Long clientId;
	
	@ApiModelProperty("客户端")
	@QueryRelation(isService = true,serviceName = "rpcClientServiceV1",relationField = "clientId")
	private DropDownResult client;
	
	@ApiModelProperty("图标")
	private String icon;
	
	@ApiModelProperty("状态")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Status status;
	
	@ApiModelProperty(value = "权限列表",dataType = "com.maozi.base.result.ListStringResult")
	@QueryRelation(isService = true,serviceName = "userRoleServiceImpl",functionName = "getRolesByUser",relationField = "id")
	private List<Long> roleIds;

}
