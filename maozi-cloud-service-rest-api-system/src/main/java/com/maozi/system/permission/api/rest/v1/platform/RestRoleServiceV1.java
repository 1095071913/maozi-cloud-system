package com.maozi.system.permission.api.rest.v1.platform;

import com.maozi.base.annotation.Get;
import com.maozi.base.annotation.Post;
import com.maozi.base.result.DropDownResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.role.dto.v1.platform.RoleSaveUpdateParam;
import com.maozi.system.role.vo.v1.platform.RoleInfoVo;
import com.maozi.system.role.vo.v1.platform.RoleListVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = RestRoleServiceV1.NAME)
public interface RestRoleServiceV1 {

	String NAME = "【平台】【V1】角色模块";

	String PATH = "/role/platform/v1";

	@Get(value = PATH + "/list",description = "列表")
	@PreAuthorize("hasAuthority('system:role:list')")
	AbstractBaseResult<List<RoleListVo>> restList();

	@Post(value = PATH + "/save",description = "保存")
	@PreAuthorize("hasAuthority('system:role:save')")
	AbstractBaseResult<Long> restSave(@RequestBody @Valid RoleSaveUpdateParam param);

	@Get(value = PATH + "/dropDownList",description = "下拉列表")
	@PreAuthorize("hasAuthority('system:role:save') or hasAuthority('system:role:update')")
	AbstractBaseResult<List<DropDownResult>> dropDownListResult();

	@Tag(name = NAME)
	public interface RestRoleServiceCurrentV1 {

		String CURRENT_PATH = PATH + "/{id}";

		@Get(value = CURRENT_PATH + "/get",description = "详情")
		@PreAuthorize("hasAuthority('system:role:get')")
		AbstractBaseResult<RoleInfoVo> restGet(@PathVariable Long id);

		@Post(value = CURRENT_PATH + "/remove",description = "删除")
		@PreAuthorize("hasAuthority('system:role:remove')")
		AbstractBaseResult<Void> restRemove(@PathVariable Long id);

		@Post(value = CURRENT_PATH + "/update",description = "更新")
		@PreAuthorize("hasAuthority('system:role:update')")
		AbstractBaseResult<Void> restUpdate(@PathVariable Long id,@RequestBody RoleSaveUpdateParam param);

		@Post(value = CURRENT_PATH + "/updateStatus",description = "更新状态")
		@PreAuthorize("hasAuthority('system:role:update')")
		AbstractBaseResult<Void> updateStatus(@PathVariable Long id);
		
	}

}
