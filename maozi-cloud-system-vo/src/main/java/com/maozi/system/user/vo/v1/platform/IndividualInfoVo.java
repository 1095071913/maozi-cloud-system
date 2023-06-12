package com.maozi.system.user.vo.v1.platform;

import java.util.List;

import com.maozi.base.AbstractBaseVomain;

import io.swagger.annotations.ApiModelProperty;
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
	private List<String> permissions;

}
