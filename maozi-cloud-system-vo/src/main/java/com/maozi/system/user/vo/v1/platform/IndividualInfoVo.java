package com.maozi.system.user.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.plugin.mapping.QueryMapping;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualInfoVo extends AbstractBaseVomain{
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("头像")
	private String icon;
	
	@ApiModelProperty("权限列表")
	@QueryMapping(isService = true,serviceName = "userServiceImpl",functionName = "getPermissions")
	private List<String> permissions;

}
