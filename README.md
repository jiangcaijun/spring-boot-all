# spring-boot
依赖1.5.8版本，http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/

即，引入的springboot官方推荐的`spring-boot-starter-parent`，如下：
```
<!-- Inherit defaults from Spring Boot -->
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.8.RELEASE</version>
</parent>
```
### 环境
* `jdk 8+`
* `maven 3.*` (`Spring Boot`提供了一系列的依赖包，所以需要构建工具的支持：`maven` 或 `gradle`，该项目采用前者)

### 各模块分类
| 项目名 | 描述 |
| --- | --- |
| spring-boot-log-log4j2 | 利用`log4j2`实现日志打印 |
| spring-boot-mybatis | 利用`mybatis`链接`mysql` |
| spring-boot-redis | `redis`缓存的基本操作等 |
| spring-boot-quartz | `quartz`实现定时任务（利用`mysql`维护定时间隔等配置） |
| spring-boot-kafka | 包含`producer`与`consumer` |
| others | 其他，待续。。。 |
### FAQ
1、项目中实体类model中，`@Data`报错。

解决：这是由于pom中引入依赖`lombok`，可在idea的`setting`>`plugins`,搜索`lombok`，然后`install`，安装成功后，重启idea即可。可参考：http://blog.csdn.net/zw235345721/article/details/50737549
