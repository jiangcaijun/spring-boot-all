package com.joe.quartz.service.impl;

import com.joe.quartz.mapper.ApiQuartzMapper;
import com.joe.quartz.model.ApiQuartz;
import com.joe.quartz.service.QuartzService;
import com.joe.quartz.util.QuartzUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuartzServiceImpl implements QuartzService {

    //加入Qulifier注解，通过名称注入bean
    @Autowired
    @Qualifier("Scheduler")
    private Scheduler scheduler;

    @Resource
    private ApiQuartzMapper apiQuartzMapper;

    @Override
    public void loadQuartz(){
        List<ApiQuartz> apiQuartzList = apiQuartzMapper.selectAll();
        for(ApiQuartz apiQuartz : apiQuartzList){
            try {
                QuartzUtils.addJob(apiQuartz.getJobClassName(),apiQuartz.getJobGroupName(),apiQuartz.getJobCron(),scheduler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<ApiQuartz> getApiQuartzlist() {
        return apiQuartzMapper.selectAll();
    }

    @Override
    public void doSomething(String className){
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(String.format("className:%s 在时刻：%s 执行", className, dateTime));
    }

}