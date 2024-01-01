package com.maozi.system.test.api.impl.rest.v1.platform;

import com.alibaba.ttl.TtlWrappers;
import com.alibaba.ttl.threadpool.TtlExecutors;
import com.maozi.base.annotation.RestService;
import com.maozi.base.param.PageParam;
import com.maozi.base.result.PageResult;
import com.maozi.common.result.AbstractBaseResult;
import com.maozi.system.test.Test1Param;
import com.maozi.system.test.api.impl.Test1ServiceImpl;
import com.maozi.system.test.domain.Test1Do;
import com.maozi.utils.context.ApplicationLinkContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestService
@Api(tags = "【平台】【V1】测试模块")
@RequestMapping("/test/platform/v1")
public class RestTest1ServiceImplV1 extends Test1ServiceImpl {

    public static final ExecutorService executorService = TtlExecutors.getTtlExecutorService(new ForkJoinPool());

    @PostMapping(value="/test")
    @ApiOperation(value = "【测试】测试")
    public AbstractBaseResult<PageResult<Test1Do>> test(@RequestBody PageParam<Test1Param> param) throws Exception {

        List<String> strings = Arrays.asList("a", "b", "c");


                Consumer<String> consumer = TtlWrappers.wrapConsumer(s -> {
                    System.out.println(ApplicationLinkContext.USERNAMES.get());
                    System.out.println(ApplicationLinkContext.VERSIONS.get());
                });
                strings.parallelStream().forEach(consumer);



        return success(listRelation(param,Test1Do::new));

    }

}
