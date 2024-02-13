package com.maozi.system.role.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.plugin.mapping.QueryMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoVo extends AbstractBaseVomain{
	
	@JsonIgnore
	@Schema(hidden = true)
	private Long id;
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "描述")
	private String description;
	
	@Schema(description = "状态")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Status status;
	
	@Schema(description = "权限列表",ref = "ListStringResult")
	@QueryMapping(isService = true,serviceName = "rolePermissionServiceImpl",functionName = "getPermissionsByRole",relationField = "id")
	private List<Long> permissionIds;

}
