package com.joe.service;

import com.joe.model.ApiQuartz;

import java.util.List;

/**
 * @desc 定时任务
 * @author jiangcaijun
 */
public interface QuartzService {

    /**
     *  初始化quartz定时任务
     */
    void loadQuartz();

    /**
     * 获取所有定时任务数据
     * @return
     */
    List<ApiQuartz> getApiQuartzlist();

    void doSomething(String className);
}
