package com.maozi.user.role.dto.v1.platform;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.base.enums.Status;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveUpdateParam extends AbstractBaseDtomain{
	
	@ApiModelProperty("名称")
	private String name;
	
	@ApiModelProperty("描述")
	private String description;
	
	@ApiModelProperty("状态")
	private Status status;
	
	@ApiModelProperty("绑定权限列表")
	private List<Long> bindPermissionIds;
	
	@ApiModelProperty("解绑权限列表")
	private List<Long> unbindPermissionIds;

}
