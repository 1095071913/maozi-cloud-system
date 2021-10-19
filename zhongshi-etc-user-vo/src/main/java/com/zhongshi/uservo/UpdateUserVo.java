package com.zhongshi.uservo;

import com.zhongshi.base.AbstractBaseVomain;
import com.zhongshi.user.UserDo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value ="UpdateUserVo",description="更新用户信息表单")
public class UpdateUserVo extends AbstractBaseVomain<UserDo>{
	
	private Long permissionId;
	
	private String nickName;
	
}
