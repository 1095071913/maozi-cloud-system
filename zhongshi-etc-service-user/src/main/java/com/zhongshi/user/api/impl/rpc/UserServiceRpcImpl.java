package com.zhongshi.user.api.impl.rpc;

import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhongshi.factory.result.AbstractBaseResult;
import com.zhongshi.tool.MapperUtils;
import com.zhongshi.user.UserDo;
import com.zhongshi.user.UserDto;
import com.zhongshi.user.api.impl.UserServiceImpl;
import com.zhongshi.user.rpc.api.UserServiceRpc;

public class UserServiceRpcImpl extends UserServiceImpl implements UserServiceRpc {
	
	
	@Override
	public AbstractBaseResult<UserDto> rpcSelectUserOne(UserDto userDto){  
		UserDo userDo = getOne(new QueryWrapper<UserDo>(copy(userDto,UserDo.class)));
		if(userDo==null) {
			return error(code(2010),401);
		}
		return success(copy(userDo,UserDto.class));
	} 
	
	
	@Override
	public AbstractBaseResult<Map<String,Object>> rpcSelectUserOne(String username){
		
		if(isNull(username)) {
			return error(code(2010),401);
		}
		
		UserDo user = getOne(new QueryWrapper<UserDo>(UserDo.builder().username(username).build()));
		
		if(isNull(user)) {
			return error(code(2010),401);   
		}
		
		Map<String, Object> userInfoMap = MapperUtils.pojo2Map(user);
		userInfoMap.put("password",user.getPassword());
		return success(userInfoMap);
		
	}
	
}