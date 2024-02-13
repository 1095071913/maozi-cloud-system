package com.maozi.system.user.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.plugin.mapping.QueryMapping;
import com.maozi.base.result.DropDownResult;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo extends AbstractBaseVomain {
	
	@JsonIgnore
	@Schema(hidden = true)
	private Long id;
	
	@Schema(description = "账号")
	private String username;
	
	@Schema(description = "名称")
	private String name;
	
	@JsonIgnore
	@Schema(hidden = true)
	private Long clientId;
	
	@Schema(description = "客户端")
	@QueryMapping(isService = true,serviceName = "rpcClientServiceV1",relationField = "clientId")
	private DropDownResult client;
	
	@Schema(description = "图标")
	private String icon;
	
	@Schema(description = "状态")
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	private Status status;
	
	@Schema(description = "权限列表",ref = "ListStringResult")
	@QueryMapping(isService = true,serviceName = "userRoleServiceImpl",functionName = "getRolesByUser",relationField = "id")
	private List<Long> roleIds;

}
