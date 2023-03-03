# 目录说明

```text
maozi-cloud-user-dto                  (UserDataTransferObject)
maozi-cloud-user-enum                 (User枚举)
maozi-cloud-user-vo                   (UserViewObject)
maozi-cloud-service-user              (User服务实现)
maozi-cloud-service-rpc-api-user      (RPC接口)
maozi-cloud-service-rest-api-user     (REST接口)
```

<br/>

# 包说明

<br/>

**maozi-cloud-service-user目录**

```text
com.maozi.                                          
  UserApplication.java                              (启动类)
  user.                                             (父模块User)  
    permission.                                     (子模块permission)
    user.                                           (子模块user)
      api.
        UserService.java                            (子模块服务接口)
        impl.                        
          UserServiceImpl.java                      (子模块服务接口实现)
          rpc.
            v1.
              UserServiceRpcV1Impl.java             (RPC V1 接口实现)
            v2.                                     (RPC V2 接口实现)
          rest.
            v1.
              app.
                UserServiceRestV1AppImpl.java       (APP HTTP V1 接口实现)
              pc.
                UserServiceRestV1PcImpl.java        (PC HTTP V1 接口实现)
      utils.                                        (工具)
      domain.                                       (domain object)
      mapper.                                       (domain mapper)
      config.                                       (配置)
      properties.                                   (配置属性)
    
```

<br/>

<br/>

**maozi-cloud-service-rest-api-user目录**

```
com.maozi.user.                       (父模块)
  permission.                         (子模块)
  user.                               (子模块)
    api.rest.                      
      v1.                               
        app.                          (APP HTPP V1 接口)
        pc.                           (PC HTPP V1 接口)
      v2.                             (HTPP V2 接口)
```

<br/>

<br/>

**maozi-cloud-service-rpc-api-user目录**

```
com.maozi.user.                       (父模块)
  permission.                         (子模块)
  user.                               (子模块)
    api.rpc.                      
      v1.                             (RPC V1 接口)
      v2.                             (RPC V2 接口)
```

<br/>

<br/>

**maozi-cloud-user-enum目录**

```
com.maozi.user.                       (父模块)
  permission.                         (子模块)
  user.                               (子模块)
    enums                      
      v1.                             (V1 枚举)
      v2.                             (V2 枚举)
```

<br/>

<br/>

**maozi-cloud-user-vo目录**

```
com.maozi.user.                       (父模块)
  permission.                         (子模块)
  user.                               (子模块)
    vo                      
      v1.                             
        app.                          (App V1 ViewObject)
        pc.                           (PC V2 ViewObject)
      v2.                             (V2 ViewObject)
```

<br/>

<br/>

**maozi-cloud-user-dto目录**

```
com.maozi.user.                       (父模块)
  permission.                         (子模块)
  user.                               (子模块)
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

数据库名字：maozi-cloud-user-localhost-db

maozi-cloud-user为父级目录名字

localhost为Nacos配置中cloud-default.yml里面的

```yaml
project: 
  environment: ${environment:localhost}
```

默认为localhost，可根据环境变量environment定义

db为固定名称

<br/>

如：https://gitee.com/xmaozi/maozi-cloud-sso  定义为：

maozi-cloud-sso-test-db 

maozi-cloud-sso-production-db

<br/>

<br/>

```sql
/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.27 : Database - maozi-cloud-user-localhost-db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`maozi-cloud-user-localhost-db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `maozi-cloud-user-localhost-db`;

/*Table structure for table `sys_permission` */

CREATE TABLE `sys_permission` (
  `parent_id` bigint DEFAULT NULL COMMENT '父ID',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '权限编码',
  `url` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除键',
  `version` int DEFAULT '0' COMMENT '版本号',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限';

/*Data for the table `sys_permission` */

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `parent_id` int DEFAULT NULL COMMENT '父id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `id` bigint NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除键',
  `version` int DEFAULT '0' COMMENT '版本号',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_permission` */

CREATE TABLE `sys_role_permission` (
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint DEFAULT NULL COMMENT '权限ID',
  `id` bigint NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除键',
  `version` int DEFAULT '0' COMMENT '版本号',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限中间表';

/*Data for the table `sys_role_permission` */

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `username` varchar(255) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role_id` bigint DEFAULT NULL COMMENT '角色',
  `status` bigint DEFAULT '0' COMMENT '0-启用/1-禁用',
  `id` bigint NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除键',
  `version` int DEFAULT '0' COMMENT '版本号',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`username`,`password`,`role_id`,`status`,`id`,`create_by`,`deleted`,`version`,`create_time`,`update_time`) values 
('admin','{MD5}{WxUwIbyfYWqR/dn2H8j00YZWxPmq6bYYus/Ga/iEQGs=}1caa986c31b5a250c6ad34979153ee7e',NULL,0,1560003674365558786,NULL,0,0,1660768834093,NULL);

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `role_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL,
  `create_by` bigint DEFAULT NULL COMMENT '创建人',
  `deleted` int DEFAULT '0' COMMENT '逻辑删除键',
  `version` int DEFAULT '0' COMMENT '版本号',
  `create_time` bigint DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sys_user_role` */

/*Table structure for table `undo_log` */

CREATE TABLE `undo_log` (
  `branch_id` bigint NOT NULL COMMENT 'branch transaction id',
  `xid` varchar(100) NOT NULL COMMENT 'global transaction id',
  `context` varchar(128) NOT NULL COMMENT 'undo_log context,such as serialization',
  `rollback_info` longblob NOT NULL COMMENT 'rollback info',
  `log_status` int NOT NULL COMMENT '0:normal status,1:defense status',
  `log_created` datetime(6) NOT NULL COMMENT 'create datetime',
  `log_modified` datetime(6) NOT NULL COMMENT 'modify datetime',
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb3 COMMENT='AT transaction mode undo table';

/*Data for the table `undo_log` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

```

<br/>

<br/>

# 项目编译依赖

**此项目依赖  https://gitee.com/xmaozi/maozi-cloud-sso**

**所以先将以下项目编译了**

**maozi-cloud-sso/maozi-cloud-sso-user**

<br/>

编译完成后再去编译本项目就不会报错了

**记住.git文件不可以缺少，不然也会报错**

<br/>

# Nacos配置

<br/>

**Nacos地址默认为localhost:8081，若不是则添加环境变量NACOS_CONFIG_SERVER**

或找到 maozi-cloud-service-user/src/main/resources/bootstrap.properties 添加

```
spring.cloud.nacos.config.server-addr=localhost:8081
```

<br/>

Nacos找到 **maozi-cloud-user.yml** 配置

```yaml
# 端口
application-port: 2000

#数据库配置,这里的值都是默认值,如果值没变可以将以下数据库配置注释掉
application-datasource-jdbc-url: localhost:3306
application-datasource-jdbc-username: root
application-datasource-jdbc-password: password

# 白名单
application-project-whitelist: /user/pc/v1/login
```

<br/>

<br/>

# 启动服务

<br/>

```
[ 2023-03-03 00:10:17 ]  [ level：INFO ]  [ TID: N/A ]  [ app：null ]  [ environment：null ]  [ No active profile set, falling back to 1 default profile: "default" ]
log4j:WARN No appenders could be found for logger (org.apache.dubbo.common.Version).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
[ 2023-03-03 00:11:21 ]  [ level：INFO ]  [ TID: N/A ]  [ app：maozi-cloud-user ]  [ environment：localhost ]  [ Started UserApplication in 71.894 seconds (JVM running for 73.315) ]
[ 2023-03-03 00:11:21 ]  [ level：INFO ]  [ TID: N/A ]  [ app：maozi-cloud-user ]  [ environment：localhost ]  [ uptime：72469 ms ]  [ config：cloud-default.yml,cloud-nacos.yml,cloud-dubbo.yml,boot-admin.yml,api-whitelist.yml,cloud-security.yml,boot-redis.yml,boot-swagger.yml,boot-arthas.yml,cloud-sentinel.yml,boot-datasource.yml,boot-mybatisplus.yml ]  [ nacosAddr：127.0.0.1:8848 net ]  [ subscribe：null ]

```

<br/>

启动成功 ，访问 **localhost:2000/doc.html**

若已启动 https://gitee.com/xmaozi/maozi-cloud-sso 即可测试接口

【后台】【V1】用户模块/用户登录

取消请求头选择

username=admin

password=812840531zhang