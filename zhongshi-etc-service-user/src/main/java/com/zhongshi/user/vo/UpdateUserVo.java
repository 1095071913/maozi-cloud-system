package com.zhongshi.user.vo;

import com.zhongshi.base.AbstractBaseVomain;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value ="UpdateUserVo",description="更新用户信息表单")
public class UpdateUserVo extends AbstractBaseVomain{
	
	private Long permissionId;
	
	private String nickName;
	
}
