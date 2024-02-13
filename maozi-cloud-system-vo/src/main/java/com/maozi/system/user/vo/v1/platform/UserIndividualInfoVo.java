package com.maozi.system.user.vo.v1.platform;

import com.maozi.base.AbstractBaseVomain;
import com.maozi.base.plugin.mapping.QueryMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserIndividualInfoVo extends AbstractBaseVomain{
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "头像")
	private String icon;
	
	@Schema(description = "权限列表")
	@QueryMapping(isService = true,serviceName = "userServiceImpl",functionName = "getPermissions")
	private List<String> permissions;

}
