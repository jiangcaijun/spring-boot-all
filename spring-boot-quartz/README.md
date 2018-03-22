# spring-boot-quartz
* 概述：[spring-boot](https://github.com/jiangcaijun/spring-boot-all)
* 项目描述
    * 利用`quartz`实现定时任务
    * 定时的相关`job`任务类、`group`任务组、`corn`时间间隔等均可配置
    * 解决job任务类中注入`@Autowired` `service`时候，报NPE空指针的问题（该问题是由于`quartz`框架本身造成的）

### 相关pom依赖
```
<!-- quartz定时任务 -->
<dependency>
	<groupId>org.quartz-scheduler</groupId>
	<artifactId>quartz</artifactId>
	<version>2.2.3</version>
</dependency>
<dependency>
	<groupId>org.quartz-scheduler</groupId>
	<artifactId>quartz-jobs</artifactId>
	<version>2.2.3</version>
</dependency>
```

### mysql初始化
执行sql目录下的spring-boot-quartz.sql,如下：
```
-- ----------------------------
--  Table structure for `api_quartz`
-- ----------------------------
CREATE TABLE `api_quartz` (
  `job_class_name` varchar(100) NOT NULL COMMENT '需要执行定时任务的类的全路径（包名和类名）',
  `job_group_name` varchar(40) DEFAULT NULL COMMENT 'job的分组名',
  `job_cron` varchar(40) DEFAULT NULL COMMENT '定时任务的时间间隔，可参考http://cron.qqe2.com/',
  `job_desc` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`job_class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `api_quartz` VALUES ('ConditionJob', 'group-name', '0/10 * * * * ?','天气实况');
INSERT INTO `api_quartz` VALUES ('Forecast24hoursJob', 'group-name', '0/20 * * * * ?','天气预报24小时');
INSERT INTO `api_quartz` VALUES ('Forecast15daysJob', 'group-name', '0/30 * * * * ?','天气预报15天');
```

其中,时间间隔`corn`表达式的书写，可参考：http://cron.qqe2.com/

### yml配置
quartz无相关配置，但由于需要从`mysql`中加载定时任务，因此需要`mybatis`与`mysql`相关配置，可参考：[spring-boot-mybatis](https://github.com/jiangcaijun/spring-boot-all/tree/master/spring-boot-mybatis)

### 要点
1、job任务类中注入`@Autowired` `service`时候，报NPE空指针的问题（该问题是由于`quartz`框架本身造成的）
 
解决方案：引入`AutowireCapableBeanFactory`，如下：
```
@Service
public final class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements
        ApplicationContextAware {

    private transient static AutowireCapableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
```
然后在 `SchedulerConfig.java` 中将其引入，如下：
```
@Configuration
public class SchedulerConfig {

    @Bean(name="SchedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        factory.setOverwriteExistingJobs(true);
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();

        factory.setJobFactory(jobFactory);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /*
     * quartz初始化监听器
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="Scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

}
```

### 运行
`main`方法运行
