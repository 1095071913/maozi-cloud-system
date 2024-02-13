package com.maozi.system.user.vo.v1.platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.enums.Status;
import com.maozi.base.plugin.mapping.QueryMapping;
import com.maozi.base.result.DropDownResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListVo extends AbstractBaseVomain {
	
	@Schema(description = "标识")
	private Long id;
	
	@Schema(description = "名称")
	private String name;

	@Schema(description = "客户端")
	@QueryMapping(relationField = "clientId",isService = true,serviceName = "rpcClientServiceV1")
	private DropDownResult client;
	
	@Schema(description = "状态",ref = "EnumResult")
	private Status status;
	
	@Schema(description = "更新时间")
	private Long updateTime;
	
	@JsonIgnore
	@Schema(hidden = true)
	private Long clientId;
	
}
