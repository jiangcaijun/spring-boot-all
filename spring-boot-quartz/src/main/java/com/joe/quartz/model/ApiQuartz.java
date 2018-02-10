package com.joe.quartz.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 实体类 对应 api_quartz 表，定时任务配置
 */
@Data
public class ApiQuartz implements Serializable {

    private static final long serialVersionUID = 7485426523275431367L;

    /**
     * 需要执行定时任务的类的全路径（包名和类名）
     */
    private String jobClassName;


    /**
     * 'job的分组名'
     */
    private String jobGroupName;

    /**
     * '定时任务的时间间隔，可参考http://cron.qqe2.com/
     */
    private String jobCron;

    /**
     * '描述'
     */
    private String jobDesc;

    @Override
    public String toString() {
        return "ApiQuartz{" +
                "jobClassName='" + jobClassName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", jobCron='" + jobCron + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                '}';
    }
}
