package com.maozi.system.test.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.maozi.base.AbstractBaseNameDomain;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@TableName("test2")
@TableComment("测试表2")
public class Test2Do extends AbstractBaseNameDomain {

}
