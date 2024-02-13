package com.maozi.system.role.dto.v1.platform;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.base.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleSaveUpdateParam extends AbstractBaseDtomain{
	
	@Schema(description = "名称")
	private String name;
	
	@Schema(description = "描述")
	private String description;
	
	@Schema(description = "状态")
	private Status status;
	
	@Schema(description = "绑定权限列表")
	private List<Long> bindPermissionIds;
	
	@Schema(description = "解绑权限列表")
	private List<Long> unbindPermissionIds;

}
