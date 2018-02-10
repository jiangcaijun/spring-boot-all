package com.joe.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Configuration;

public interface BaseJob extends Job{
    void execute(JobExecutionContext context) throws JobExecutionException;
}