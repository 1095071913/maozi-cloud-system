package com.maozi.system.user.dto.v1.platform;

import com.maozi.base.AbstractBaseDtomain;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountParam extends AbstractBaseDtomain{
	
	@NotNull(message = "账号不能为空")
	@Schema(description = "账号")
	private String username;
	
	@NotNull(message = "密码不能为空")
	@Schema(description = "密码")
	private String password;

}
