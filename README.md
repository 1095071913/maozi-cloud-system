# Pdman

有需要的可以下载Pdman导入[项目数据](https://gitee.com/xmaozi/maozi-cloud-parent-script/tree/release/maozi-cloud-service/maozi-cloud-service-pdman)

<img src="http://zs-dev01.oss-cn-shenzhen.aliyuncs.com/202306/cc19854e-0a13-4adb-b06d-66dcec6a366a.png" />

<img src="http://zs-dev01.oss-cn-shenzhen.aliyuncs.com/202306/e4779e5c-9778-4abe-bec0-13db66906248.png" />

<img src="http://zs-dev01.oss-cn-shenzhen.aliyuncs.com/202306/6133de91-6a29-4c18-a2d9-c2077998fa3c.png" />

<br/>

<br/>

<br/>

# ApiFox

有需要的可以下载Apifox导入[项目数据](https://gitee.com/xmaozi/maozi-cloud-parent-script/blob/release/maozi-cloud-service/maozi-cloud-service-apifox/maozi-cloud-system.apifox.json)

<img src="http://zs-dev01.oss-cn-shenzhen.aliyuncs.com/202306/38d4037f-e121-43d1-8949-e1c766a9305d.png" />

<img src="http://zs-dev01.oss-cn-shenzhen.aliyuncs.com/202306/159c99f2-7ef8-4dfa-a581-5274aa62808c.png" />

<br/>

<br/>

# 目录说明

```text
maozi-cloud-system-dto                  (SystemDataTransferObject)
maozi-cloud-system-enum                 (System枚举)
maozi-cloud-system-vo                   (SystemViewObject)
maozi-cloud-service-system              (System服务实现)
maozi-cloud-service-rpc-api-system      (RPC接口)
maozi-cloud-service-rest-api-system     (REST接口)
```

<br/>

# 包说明

<br/>

**maozi-cloud-service-system目录**

```text
com.maozi.                                          
  SystemApplication.java                            (启动类)
  system.                                           (父模块System)  
    permission.                                     (子模块permission)
    system.                                         (子模块system)
      api.
        SystemService.java                          (子模块服务接口)
        impl.                        
          SystemServiceImpl.java                    (子模块服务接口实现)
          rpc.
            v1.
              SystemServiceRpcV1Impl.java           (RPC V1 接口实现)
            v2.                                     (RPC V2 接口实现)
          rest.
            v1.
              app.
                SystemServiceRestV1AppImpl.java     (APP HTTP V1 接口实现)
              pc.
                SystemServiceRestV1PcImpl.java      (PC HTTP V1 接口实现)
      utils.                                        (工具)
      domain.                                       (domain object)
      mapper.                                       (domain mapper)
      config.                                       (配置)
      properties.                                   (配置属性)
    
```

<br/>

<br/>

**maozi-cloud-service-rest-api-system目录**

```
com.maozi.system.                     (父模块)
  permission.                         (子模块)
  system.                             (子模块)
    api.rest.                      
      v1.                               
        app.                          (APP HTPP V1 接口)
        pc.                           (PC HTPP V1 接口)
      v2.                             (HTPP V2 接口)
```

<br/>

<br/>

**maozi-cloud-service-rpc-api-system目录**

```
com.maozi.system.                     (父模块)
  permission.                         (子模块)
  system.                             (子模块)
    api.rpc.                      
      v1.                             (RPC V1 接口)
      v2.                             (RPC V2 接口)
```

<br/>

<br/>

**maozi-cloud-system-enum目录**

```
com.maozi.system.                     (父模块)
  permission.                         (子模块)
  system.                             (子模块)
    enums                      
      v1.                             (V1 枚举)
      v2.                             (V2 枚举)
```

<br/>

<br/>

**maozi-cloud-system-vo目录**

```
com.maozi.system.                     (父模块)
  permission.                         (子模块)
  system.                             (子模块)
    vo                      
      v1.                             
        app.                          (App V1 ViewObject)
        pc.                           (PC V2 ViewObject)
      v2.                             (V2 ViewObject)
```

<br/>

<br/>

**maozi-cloud-system-dto目录**

```
com.maozi.system.                     (父模块)
  permission.                         (子模块)
  system.                             (子模块)
    dto
      rest.
        v1.                             
          app.                        (HTTP App V1 DataTransferObject)
          pc.                         (HTTP PC V1 DataTransferObject)
        v2.                           (HTTP V2 DataTransferObject)
      rpc.                            
        v1.                           (RPC V1 DataTransferObject)
```

<br/>

<br/>

<br/>

<br/>

# 数据库导入

数据库名字默认为：maozi-cloud-system-localhost-db

maozi-cloud-system为父级目录名字

localhost为Nacos配置中cloud-default.yml里面的

```yaml
project: 
  environment: ${environment:localhost}
```

默认为localhost，可根据环境变量environment定义

db为固定名称

<br/>

如：https://gitee.com/xmaozi/maozi-cloud-oauth  定义为：

maozi-cloud-oauth-test-db 

maozi-cloud-oauth-production-db

<br/>

**若需要修改数据库名则看到下面的Nacos配置篇**

<br/>

<br/>

# 项目编译依赖

**此项目依赖  https://gitee.com/xmaozi/maozi-cloud-oauth**

**所以先将以下项目编译了**

**maozi-cloud-oauth/maozi-cloud-oauth-system**

<br/>

编译完成后再去编译本项目就不会报错了

**记住.git文件不可以缺少，不然也会报错**

<br/>

# Nacos配置

<br/>

**Nacos地址默认为localhost:8081，若不是则添加环境变量NACOS_CONFIG_SERVER**

或找到 maozi-cloud-service-system/src/main/resources/bootstrap.properties 添加

```
spring.cloud.nacos.config.server-addr=localhost:8081
```

<br/>

Nacos找到 **maozi-cloud-system.yml** 配置

```yaml
# 端口
application-port: 2000

#数据库配置,这里的值都是默认值,如果值没变可以将以下数据库配置注释掉
application-datasource-jdbc-url: localhost:3306
application-datasource-jdbc-systemname: root
application-datasource-jdbc-password: password
application-datasource-db-name: maozi-cloud-system-localhost-db

# 白名单
application-project-whitelist: /user/pc/v1/login
```

<br/>

<br/>

<br/>

## 设置Jvm VM参数

**因为用的是JDK17 所以要设置以下VM餐宿**

```text
--add-opens java.base/java.math=ALL-UNNAMED  --add-opens java.base/java.lang=ALL-UNNAMED  --add-opens java.base/java.lang.reflect=ALL-UNNAMED
```

<br/>

<br/>

<br/>

# 启动服务

<br/>

```
[ 2023-03-03 00:11:21 ]  [ level：INFO ]  [ TID: N/A ]  [ maozi-cloud-service：maozi-cloud-system ]  [ environment：localhost ]  [ uptime：72469 ms ]  [ config：cloud-default.yml,cloud-nacos.yml,cloud-dubbo.yml,boot-admin.yml,api-whitelist.yml,cloud-oauth.yml,boot-redis.yml,boot-swagger.yml,boot-arthas.yml,cloud-sentinel.yml,boot-datasource.yml,boot-db.yml ]  [ nacosAddr：127.0.0.1:8848 net ]  [ subscribe：null ]
```

<br/>

启动成功 ，访问 **localhost:2000/doc.html**

若已启动 https://gitee.com/xmaozi/maozi-cloud-oauth 即可测试接口

【后台】【V1】用户模块/用户登录

取消请求头选择

username=admin

password=812840531zhang

或者使用ApiFox跑一次全流程测试用例
