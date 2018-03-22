package com.joe.service.impl;

import com.joe.mapper.ApiQuartzMapper;
import com.joe.model.ApiQuartz;
import com.joe.service.QuartzService;
import com.joe.util.QuartzUtils;
import org.quartz.*;
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