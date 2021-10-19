package com.zhongshi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zhongshi.factory.result.AbstractBaseResult;
import com.zhongshi.feign.ThirdPartyParserResponseFeign;

@FeignClient(name = "test",url = "http://localhost:2000",fallback = FeignTestFallback.class,configuration = ThirdPartyParserResponseFeign.class)
public interface FeignTest {
	
	@GetMapping("/test2")
	public AbstractBaseResult<String> test2();

}
