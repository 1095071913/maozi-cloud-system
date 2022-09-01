package com.jiumao.user.user.domain;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiumao.base.AbstractBaseDomain;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableComment("用户")
@TableName("sys_user")
@SuperBuilder(toBuilder = true)
public class SysUserDo extends AbstractBaseDomain{

	@Column(value = "username",comment = "登录账号")
	private String username;

	@Column(value = "password",comment = "密码")
	private String password;

	@Column(value = "role_id",comment = "角色")
	private Long roleId;

	@Column(value = "status",comment = "0-启用/1-禁用")
	private Long status;


}