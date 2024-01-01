package com.maozi.system.role.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.plugin.mapping.QueryMapping;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoVo extends AbstractBaseVomain{
	
	@JsonIgnore
	@ApiModelProperty(hidden = true)
	private Long id;
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("描述")
	private String description;
	
	@ApiModelProperty("状态")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Status status;
	
	@ApiModelProperty(value = "权限列表",dataType = "com.maozi.base.result.ListStringResult")
	@QueryMapping(isService = true,serviceName = "rolePermissionServiceImpl",functionName = "getPermissionsByRole",relationField = "id")
	private List<Long> permissionIds;

}
