package com.zhongshi.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zhongshi.base.AbstractBaseDtomain;
import lombok.Data;

@Data
public class UserDto extends AbstractBaseDtomain{

	private String username;
	
	@JsonInclude
	private String password;
	
}
