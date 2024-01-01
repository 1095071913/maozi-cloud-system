package com.maozi.system.test.api.impl;

import com.maozi.base.api.impl.BaseServiceImpl;
import com.maozi.system.test.api.Test1Service;
import com.maozi.system.test.domain.Test1Do;
import com.maozi.system.test.mapper.Test1Mapper;
import org.springframework.stereotype.Service;

@Service
public class Test1ServiceImpl extends BaseServiceImpl<Test1Mapper, Test1Do, Void> implements Test1Service {

    @Override
    protected String getAbbreviationModelName() {
        return "【测试1】";
    }

}
