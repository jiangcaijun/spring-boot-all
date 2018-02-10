package com.joe.quartz.job;

import com.joe.quartz.service.QuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 天气实况
 */
public class ConditionJob implements BaseJob {

    private static Logger logger = LoggerFactory.getLogger(ConditionJob.class);

    @Autowired
    private QuartzService quartzService;

    public ConditionJob() {

    }
    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        quartzService.doSomething(this.getClass().getName());
    }
}