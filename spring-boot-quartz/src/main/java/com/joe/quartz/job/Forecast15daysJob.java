package com.joe.quartz.job;

import com.joe.quartz.service.QuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 天气预报15天
 */
@Component
public class Forecast15daysJob implements BaseJob {

    private static Logger logger = LoggerFactory.getLogger(Forecast15daysJob.class);


    @Autowired
    private QuartzService quartzService;

    public Forecast15daysJob() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        quartzService.doSomething(this.getClass().getName());
    }
}