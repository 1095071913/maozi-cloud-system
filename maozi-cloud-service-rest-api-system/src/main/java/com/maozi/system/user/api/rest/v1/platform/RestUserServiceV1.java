/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.maozi.system.user.api.rest.v1.platform;

import com.maozi.base.annotation.Get;
import com.maozi.base.annotation.Post;
import com.maozi.base.param.PageParam;
import com.maozi.base.result.PageResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.oauth.token.dto.platform.dto.OauthToken;
import com.maozi.system.user.dto.v1.platform.UserAccountParam;
import com.maozi.system.user.dto.v1.platform.UserListParam;
import com.maozi.system.user.dto.v1.platform.UserSaveUpdateParam;
import com.maozi.system.user.vo.v1.platform.UserIndividualInfoVo;
import com.maozi.system.user.vo.v1.platform.UserInfoVo;
import com.maozi.system.user.vo.v1.platform.UserListVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = RestUserServiceV1.NAME)
public interface RestUserServiceV1 {

	String NAME = "【平台】【V1】用户模块";

	String PATH = "/user/platform/v1";

	@Post(value = PATH + "/getToken",description = "【个人】获取通行令牌")
	AbstractBaseResult<OauthToken> restGetToken(@RequestBody @Valid UserAccountParam param) throws Exception;

	@Post(value = PATH + "/list",description = "【管理员】列表")
	@PreAuthorize("hasAuthority('system:user:list')")
	AbstractBaseResult<PageResult<UserListVo>> restList(@RequestBody PageParam<UserListParam> pageParam);

	@Post(value = PATH + "/save",description = "【管理员】保存")
	@PreAuthorize("hasAuthority('system:user:save')")
	AbstractBaseResult<Long> restSave(@RequestBody UserSaveUpdateParam param);

	@Tag(name = NAME)
	public interface RestUserServiceCurrentV1{

		String CURRENT_PATH = PATH + "/{id}";

		@Get(value = CURRENT_PATH + "/get",description = "【管理员】详情")
		@PreAuthorize("hasAuthority('system:user:get')")
		AbstractBaseResult<UserInfoVo> restGet(@PathVariable Long id);

		@Post(value = CURRENT_PATH + "/remove",description = "【管理员】删除")
		@PreAuthorize("hasAuthority('system:user:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);

		@Post(value = CURRENT_PATH + "/updateStatus",description = "【管理员】更新状态")
		@PreAuthorize("hasAuthority('system:user:update')")
		AbstractBaseResult<Void> restUpdateStatus(@PathVariable Long id);

		@Post(value = CURRENT_PATH + "/update",description = "【管理员】更新")
		@PreAuthorize("hasAuthority('system:user:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody UserSaveUpdateParam param);

	}

	@Tag(name = NAME)
	public interface RestUserServiceIndividualV1{

		String INDIVIDUAL_PATH = PATH + "/individual";

		@Get(value = INDIVIDUAL_PATH + "/get",description = "【个人】详情")
		AbstractBaseResult<UserIndividualInfoVo> restIndividualGet();

		@Post(value = INDIVIDUAL_PATH + "/refreshToken",description = "【个人】刷新令牌")
		AbstractBaseResult<OauthToken> restIndividualRefreshToken() throws Exception;

		@Post(value = INDIVIDUAL_PATH + "/destroyToken",description = "【个人】销毁令牌")
		AbstractBaseResult<Void> restIndividualDestroyToken();

	}

}