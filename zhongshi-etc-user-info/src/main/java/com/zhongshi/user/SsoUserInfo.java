package com.zhongshi.user;

import com.zhongshi.base.AbstractBaseDtomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SsoUserInfo extends AbstractBaseDtomain{
	
	private String username;
	
}
