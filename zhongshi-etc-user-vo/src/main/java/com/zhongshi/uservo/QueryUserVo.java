package com.zhongshi.uservo;

import com.zhongshi.base.AbstractBaseVomain;
import com.zhongshi.user.UserDo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value ="QueryUserVo",description="查询用户表单")
public class QueryUserVo extends AbstractBaseVomain<UserDo>{
	
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    
}
