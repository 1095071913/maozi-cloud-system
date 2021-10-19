package com.zhongshi;

import org.springframework.stereotype.Component;

import com.zhongshi.factory.BaseResultFactory;
import com.zhongshi.factory.result.AbstractBaseResult;

@Component
public class FeignTestFallback implements FeignTest {

	@Override
	public AbstractBaseResult<String> test2() {
		
		return BaseResultFactory.error(BaseResultFactory.code(500));
	}

}
