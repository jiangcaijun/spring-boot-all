package com.joe.quartz.job;

import com.joe.quartz.service.QuartzService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 天气预报24小时
 */
@Component
public class Forecast24hoursJob implements BaseJob {

    private static Logger logger = LoggerFactory.getLogger(Forecast24hoursJob.class);

    @Autowired
    private QuartzService quartzService;


    public Forecast24hoursJob() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        quartzService.doSomething(this.getClass().getName());
    }
}