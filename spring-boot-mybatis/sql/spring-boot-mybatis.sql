SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zcdc_zx
-- ----------------------------
DROP TABLE IF EXISTS `zcdc_zx`;
CREATE TABLE `zcdc_zx` (
  `zx_uuid` varchar(32) NOT NULL COMMENT '主键',
  `zx_code` varchar(50) DEFAULT NULL COMMENT '专项编号',
  `zx_name` varchar(50) DEFAULT NULL COMMENT '专项名称',
  `zx_range` varchar(50) DEFAULT NULL COMMENT '专项范围',
  `zx_status` varchar(2) DEFAULT NULL COMMENT '专项状态(1.进行中2.已结束)',
  `start_time` datetime DEFAULT NULL COMMENT '专项开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '专项结束时间',
  `zx_type` varchar(10) DEFAULT NULL COMMENT '专项类型（1.事件2.案件）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `key1` varchar(500) DEFAULT NULL COMMENT '备用字段1',
  `key2` varchar(500) DEFAULT NULL COMMENT '备用字段2',
  `key3` varchar(500) DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`zx_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专项';

-- ----------------------------
-- Records of zcdc_zx
-- ----------------------------
INSERT INTO `zcdc_zx` VALUES ('1', '20170929-001', '网络案件', '1', '1', null, null, '1', '2017-09-29 15:32:03', null, null, null, null);
INSERT INTO `zcdc_zx` VALUES ('2', '20171030-001', '我是名称', '1', '1', '2017-10-25 08:00:00', '2017-10-31 08:00:00', '1', '2017-10-30 14:01:54', null, null, null, null);
INSERT INTO `zcdc_zx` VALUES ('3', '20171030-004', '我是测试数据', '2', '1', '2017-10-17 08:00:00', '2017-10-28 08:00:00', '1', '2017-10-30 14:02:37', null, null, null, null);