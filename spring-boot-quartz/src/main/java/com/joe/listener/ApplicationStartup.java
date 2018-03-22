package com.joe.listener;

import com.joe.service.QuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring初始化后执行的类
 */
@Configuration
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(ApplicationStartup.class);

    @Autowired
    private QuartzService quartzService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("ApplicationListener系统初始化开始");
        long startTime=System.currentTimeMillis();
        quartzService.loadQuartz();
        long endTime=System.currentTimeMillis();
        logger.info("ApplicationListener系统初始化结束,共用时{}毫秒",(endTime-startTime));
    }

}