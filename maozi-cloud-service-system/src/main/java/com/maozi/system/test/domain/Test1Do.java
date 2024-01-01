package com.maozi.system.test.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.TableComment;
import com.maozi.base.AbstractBaseNameDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@TableName("test1")
@TableComment("测试表1")
public class Test1Do extends AbstractBaseNameDomain {

    @Column(value = "test_id",comment = "关联字段")
    private Long testId;

//    @TableField(exist=false)
//    @QueryMapping(isService = false,tableName = "test2")
//    private Test2Do test2Do;

}
