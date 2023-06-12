package com.maozi.user.user.dto.v1.platform;

import javax.validation.constraints.NotNull;

import com.maozi.base.AbstractBaseDtomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountParam extends AbstractBaseDtomain{
	
	@NotNull(message = "账号不能为空")
	private String username;
	
	@NotNull(message = "密码不能为空")
	private String password;

}
