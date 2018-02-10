# spring-boot-mybatis
* 概述：[spring-boot](https://github.com/jiangcaijun/spring-boot-all)
* 项目描述：利用mybatis链接mysql，并给出一个简单的CRUD（增删改查）的例子

### 项目结构

```
├── spring-boot-all/spring-boot-mybatis
│   ├── src                  
│   │   ├── main                
│   │   │   ├── java/com/joe             
│   │   │   │   ├── mapper          // interface 层,对应mybatis的 xml
│   │   │   │   ├── models          // 实体类
│   │   │   │   ├── service         // service接口层
│   │   │   │   │   ├── impl        // service接口的实现层
│   │   │   │   ├── util            // 工具类
│   │   │   ├── resources           // 资源
│   │   │   │   ├── mapping         // mybatis的xml存放目录
│   │   ├── test                    // junit单元测试
│   └── pom.xml                     //maven管理的 pom 文件
│   └── README.md
```
### 相关pom依赖
```
<!-- mybatis -->
<dependency>
	<groupId>org.mybatis.spring.boot</groupId>
	<artifactId>mybatis-spring-boot-starter</artifactId>
	<version>1.1.1</version>
</dependency>
<!-- mysql 驱动 -->
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.38</version>
</dependency>
<!-- 数据库连接池 -->
<dependency>
	<groupId>com.alibaba</groupId>
	<artifactId>druid</artifactId>
	<version>1.0.5</version>
</dependency>
```
### mysql初始化
执行sql目录下的spring-boot-mybatis.sql

### yml配置
```
spring:
  http:
    encoding:
      force: true
      charset: utf-8
      enabled: true
  datasource:
    name: spring-boot-all
    url: jdbc:mysql://127.0.0.1:3306/spring-boot-all
    username: root
    password: Mynewpass@
    # 使用druid数据源
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    filters: stat
    maxActive: 20
    initialSize: 1
    maxWait: 60000
    minIdle: 1
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: select 'x'
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    maxOpenPreparedStatements: 20

mybatis:
  mapper-locations: classpath:mapping/*.xml
  type-aliases-package: com.joe.models
```
注意，在您clone到本地运行时候，根据实际的数据库信息，修改`url` `username` `password`

### 运行
在`test`目录下，有`SpringBootMybatisApplicationTests.java`类，这是个`junit` 单元测试类，具体如下：

```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

	@Autowired
	private ZcdcService zcdcService;

	@Test
	public void contextLoads() {
		PageDo pageDo = new PageDo();
		zcdcService.findDataGrid(pageDo);
		System.out.println(String.format("获取数据的条数：%s", pageDo.getTotal()));
		System.out.println(String.format("获取数据：%s", pageDo.getRows()));
	}
}
```
输出结果为：
```
获取数据的条数：3
获取数据：[Zcdc(zxUuid=3, zxCode=20171030-004, zxName=我是测试数据, zxRange=2, zxStatus=1, zxType=1, startTime=Tue Oct 17 08:00:00 CST 2017, endTime=Sat Oct 28 08:00:00 CST 2017, createTime=Mon Oct 30 14:02:37 CST 2017, updateTime=null, key1=null, key2=null, key3=null), Zcdc(zxUuid=2, zxCode=20171030-001, zxName=我是名称, zxRange=1, zxStatus=1, zxType=1, startTime=Wed Oct 25 08:00:00 CST 2017, endTime=Tue Oct 31 08:00:00 CST 2017, createTime=Mon Oct 30 14:01:54 CST 2017, updateTime=null, key1=null, key2=null, key3=null), Zcdc(zxUuid=1, zxCode=20170929-001, zxName=网络案件, zxRange=1, zxStatus=1, zxType=1, startTime=null, endTime=null, createTime=Fri Sep 29 15:32:03 CST 2017, updateTime=null, key1=null, key2=null, key3=null)]
```