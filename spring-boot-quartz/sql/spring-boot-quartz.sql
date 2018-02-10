
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `api_quartz`
-- ----------------------------
DROP TABLE IF EXISTS `api_quartz`;
CREATE TABLE `api_quartz` (
  `job_class_name` varchar(100) NOT NULL COMMENT '需要执行定时任务的类的全路径（包名和类名）',
  `job_group_name` varchar(40) DEFAULT NULL COMMENT 'job的分组名',
  `job_cron` varchar(40) DEFAULT NULL COMMENT '定时任务的时间间隔，可参考http://cron.qqe2.com/',
  `job_desc` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`job_class_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `api_quartz` VALUES ('com.joe.quartz.job.ConditionJob', 'group-name', '0/10 * * * * ?','天气实况');
INSERT INTO `api_quartz` VALUES ('com.joe.quartz.job.Forecast24hoursJob', 'group-name', '0/20 * * * * ?','天气预报24小时');
INSERT INTO `api_quartz` VALUES ('com.joe.quartz.job.Forecast15daysJob', 'group-name', '0/30 * * * * ?','天气预报15天');
