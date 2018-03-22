# spring-boot-log-log4j2

* 概述：[spring-boot](https://github.com/jiangcaijun/spring-boot-all)
* 项目描述
    * 利用`logj2`实现日志的打印与归类

### 相关pom依赖
```
<dependency> <!-- exclude掉spring-boot的默认log配置 -->
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency> <!-- 引入log4j2依赖 -->
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

### yml配置
```
logging:
  config:
    classpath: log4j2-spring.xml
```
### 要点
##### 1、`log4j2.xml`中，关于日志输出格式格式的定义如下：
```
<!-- 项目统一日志输出格式-控制台 -->
<property name="lOBACK_CONSOLE_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss} [%thread] %highlight{%p} %style{%logger}{Normal,cyan} :%L %style{->}{yellow} %msg%n" />
```
该配置可以按日志级别打印出不同颜色的日志，最终效果可参见底部图片
##### 2、`junit`单元测试
```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLogApplicationTests {

	private static Logger logger = LoggerFactory.getLogger(SpringBootLogApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("info级别的日志");
		logger.warn("warn级别的日志");
		logger.error("error级别的日志");
	}
}
```

### 运行
`junit`方法运行,效果如下：
![log4j2日志运行效果图](https://raw.githubusercontent.com/jiangcaijun/pictureAsset/HEAD/src/spring-boot-all/log_2018-03-21.jpeg)

### 其他
`log4j2`的日志输出格式，可参考官方链接：[http://logging.apache.org/log4j/2.x/manual/layouts.html](http://logging.apache.org/log4j/2.x/manual/layouts.html)