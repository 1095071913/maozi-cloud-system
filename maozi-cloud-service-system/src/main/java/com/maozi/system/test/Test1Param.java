package com.maozi.system.test;

import com.maozi.base.AbstractBaseDtomain;
import com.maozi.base.plugin.join.JoinBaseType;
import com.maozi.base.plugin.join.JoinPlugin;
import com.maozi.base.plugin.join.JoinPlugins;
import com.maozi.base.plugin.query.QueryBaseType;
import com.maozi.base.plugin.query.QueryPlugin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JoinPlugins({
    @JoinPlugin(value = JoinBaseType.innerJoin,on = "t.test_id = t2.id",tableName = "test2",tableAlias = "t2")
})
public class Test1Param extends AbstractBaseDtomain {

    @QueryPlugin(value = QueryBaseType.eq,tableName = "t2",field = "name")
    private String test2Name;

}
