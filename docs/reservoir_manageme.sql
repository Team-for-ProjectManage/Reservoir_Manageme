/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : reservoir_manageme

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-04-06 22:09:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_rm_check_record
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_check_record`;
CREATE TABLE `t_rm_check_record` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '检查人',
  `relation_id` varchar(64) DEFAULT NULL COMMENT '关联检查对象id',
  `type` varchar(4) DEFAULT NULL COMMENT '检查类型(1巡检,2日常检查，3汛前检查，4年度检查，5特别检查)',
  `name` varchar(128) DEFAULT NULL COMMENT '检查任务名称',
  `check_info` varchar(1000) DEFAULT NULL COMMENT '检查结果描述',
  `is_standard` varchar(1) DEFAULT NULL COMMENT '是否合格（不合格需要整改)',
  `check_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '检查时间',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='巡查记录信息表';

-- ----------------------------
-- Records of t_rm_check_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_dept`;
CREATE TABLE `t_rm_dept` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL COMMENT '上级部门id',
  `dept_name` varchar(128) DEFAULT NULL COMMENT '部门名称',
  `dept_type` varchar(128) DEFAULT NULL COMMENT '部门类型',
  `level` varchar(1) DEFAULT NULL COMMENT '部门级别(1，2，3）',
  `telphone` varchar(20) DEFAULT NULL COMMENT '部门联系电话',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL COMMENT '标志，预留字段',
  `state` varchar(1) DEFAULT NULL COMMENT '状态：2代表正常，4代表离职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of t_rm_dept
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_device
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_device`;
CREATE TABLE `t_rm_device` (
  `id` varchar(64) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '设备名称',
  `type` varchar(32) DEFAULT NULL COMMENT '设备类型',
  `code` varchar(64) DEFAULT NULL COMMENT '出厂编号',
  `product_name` varchar(128) DEFAULT NULL COMMENT '厂家名称',
  `specs` varchar(64) DEFAULT NULL COMMENT '规格',
  `legend` varchar(128) DEFAULT NULL COMMENT '设备图例',
  `maintenance` varchar(256) DEFAULT NULL COMMENT '维保单位',
  `state` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备表';

-- ----------------------------
-- Records of t_rm_device
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_emerge_base
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_emerge_base`;
CREATE TABLE `t_rm_emerge_base` (
  `id` varchar(64) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '突发事件名称',
  `type` varchar(32) DEFAULT NULL COMMENT '突发类型',
  `level` varchar(12) DEFAULT NULL COMMENT '突发级别',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='突发事件类型表';

-- ----------------------------
-- Records of t_rm_emerge_base
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_emerge_record
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_emerge_record`;
CREATE TABLE `t_rm_emerge_record` (
  `id` varchar(64) NOT NULL,
  `emerge_id` varchar(64) DEFAULT NULL COMMENT '突发事件id',
  `describe` varchar(500) DEFAULT NULL COMMENT '突发事件描述',
  `project_grade` varchar(12) DEFAULT NULL COMMENT '工程等级',
  `step` varchar(256) DEFAULT NULL COMMENT '对于突发事件采取的措施或者预防方案',
  `emerge_time` timestamp NULL DEFAULT NULL COMMENT '记录突发事件发生的时间',
  `handle` varchar(32) DEFAULT NULL COMMENT '处理人（指挥人）',
  `result` varchar(64) DEFAULT NULL COMMENT '结果描述',
  `is_solve` varchar(1) DEFAULT NULL COMMENT '是否解决',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应急管理记录表';

-- ----------------------------
-- Records of t_rm_emerge_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_irrigate
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_irrigate`;
CREATE TABLE `t_rm_irrigate` (
  `id` varchar(64) NOT NULL,
  `project_id` varchar(64) DEFAULT NULL COMMENT '工程表id',
  `name` varchar(128) DEFAULT NULL COMMENT '灌区名称',
  `type` varchar(12) DEFAULT NULL COMMENT '灌区类型',
  `category` varchar(64) DEFAULT NULL COMMENT '灌区类别',
  `lcation` varchar(128) DEFAULT NULL COMMENT '所在区域',
  `village` varchar(64) DEFAULT NULL COMMENT '所在村',
  `longitude` varchar(6) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(6) DEFAULT NULL COMMENT '纬度',
  `is_gate` varchar(1) DEFAULT NULL COMMENT '是否有备用闸门',
  `is_electric` varchar(1) DEFAULT NULL COMMENT '是否有备用电源',
  `affect_town` varchar(128) DEFAULT NULL COMMENT '溃决影响乡镇',
  `state` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='灌区表';

-- ----------------------------
-- Records of t_rm_irrigate
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_irrigate_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_irrigate_detail`;
CREATE TABLE `t_rm_irrigate_detail` (
  `id` varchar(64) NOT NULL,
  `irrigate_id` varchar(64) DEFAULT NULL COMMENT '灌区表id',
  `name` varchar(128) DEFAULT NULL COMMENT '名称（闸门，开关等）',
  `type` varchar(12) DEFAULT NULL COMMENT '类型',
  `open_time` timestamp NULL DEFAULT NULL COMMENT '开启时间',
  `close_time` timestamp NULL DEFAULT NULL COMMENT '关闭时间',
  `state` varchar(4) DEFAULT NULL COMMENT '状态（是否正常）',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='灌区子表';

-- ----------------------------
-- Records of t_rm_irrigate_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_menu`;
CREATE TABLE `t_rm_menu` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL COMMENT '上级菜单id',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `level` varchar(1) DEFAULT NULL COMMENT '菜单级别',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL COMMENT '标志，预留字段',
  `state` varchar(1) DEFAULT NULL COMMENT '状态：2代表正常，4代表离职',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of t_rm_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_project
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_project`;
CREATE TABLE `t_rm_project` (
  `id` varchar(64) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '工程信息名称',
  `code` varchar(32) DEFAULT NULL COMMENT '工程信息代码',
  `project_grade` varchar(12) DEFAULT NULL COMMENT '工程等级',
  `project_contruction` varchar(256) DEFAULT NULL COMMENT '工程建设情况',
  `complete_time` timestamp NULL DEFAULT NULL COMMENT '完工时间',
  `high_system` varchar(128) DEFAULT NULL COMMENT '高程体系',
  `check_time` timestamp NULL DEFAULT NULL COMMENT '竣工验收时间',
  `is_complete` varchar(1) DEFAULT NULL COMMENT '是否完工',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工程表';

-- ----------------------------
-- Records of t_rm_project
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_project_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_project_detail`;
CREATE TABLE `t_rm_project_detail` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `project_id` varchar(64) NOT NULL COMMENT '工程信息id',
  `name` varchar(128) DEFAULT NULL COMMENT '水库名称',
  `type` varchar(64) DEFAULT NULL COMMENT '类型：1灌区，2河道，3水闸，4水库，5水电站，6水文监测站，7提防山塘',
  `mold` varchar(64) DEFAULT NULL COMMENT '水库类别',
  `open_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开启时间',
  `close_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '关闭时间',
  `equipment_state` varchar(4) DEFAULT NULL COMMENT '设备状态',
  `isEmps` varchar(1) DEFAULT NULL COMMENT '是否有备用电源',
  `isGate` varchar(1) DEFAULT NULL COMMENT '是否有闸门',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`,`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水利设备表(工程表的子表)';

-- ----------------------------
-- Records of t_rm_project_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_rain_hyetal
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_rain_hyetal`;
CREATE TABLE `t_rm_rain_hyetal` (
  `id` varchar(64) NOT NULL,
  `reservoir_id` varchar(64) DEFAULT NULL COMMENT '水库表id',
  `avg_rainfall` varchar(64) DEFAULT NULL COMMENT '平均降雨量',
  `rainfall_frequency` varchar(64) DEFAULT NULL COMMENT '降雨频率',
  `recept_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '接收时间',
  `issue_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布日期',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='雨量信息表';

-- ----------------------------
-- Records of t_rm_rain_hyetal
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_reservoir
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_reservoir`;
CREATE TABLE `t_rm_reservoir` (
  `id` varchar(64) NOT NULL,
  `project_id` varchar(64) DEFAULT NULL COMMENT '工程表id',
  `name` varchar(128) DEFAULT NULL COMMENT '水库名称',
  `type` varchar(12) DEFAULT NULL COMMENT '水库类型',
  `category` varchar(64) DEFAULT NULL COMMENT '水库类别',
  `lcation` varchar(128) DEFAULT NULL COMMENT '所在区域',
  `village` varchar(64) DEFAULT NULL COMMENT '所在村',
  `longitude` varchar(6) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(6) DEFAULT NULL COMMENT '纬度',
  `is_gate` varchar(1) DEFAULT NULL COMMENT '是否有备用闸门',
  `is_electric` varchar(1) DEFAULT NULL COMMENT '是否有备用电源',
  `affect_town` varchar(128) DEFAULT NULL COMMENT '溃决影响乡镇',
  `state` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水库表';

-- ----------------------------
-- Records of t_rm_reservoir
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_reservoir_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_reservoir_detail`;
CREATE TABLE `t_rm_reservoir_detail` (
  `id` varchar(64) NOT NULL,
  `reservoir_id` varchar(64) DEFAULT NULL COMMENT '水库表id',
  `name` varchar(128) DEFAULT NULL COMMENT '名称（闸门，开关等）',
  `type` varchar(12) DEFAULT NULL COMMENT '类型',
  `open_time` timestamp NULL DEFAULT NULL COMMENT '开启时间',
  `close_time` timestamp NULL DEFAULT NULL COMMENT '关闭时间',
  `state` varchar(4) DEFAULT NULL COMMENT '状态（是否正常）',
  `remark` varchar(64) DEFAULT NULL COMMENT '预留字段',
  `ceate_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水库子表';

-- ----------------------------
-- Records of t_rm_reservoir_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_role
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_role`;
CREATE TABLE `t_rm_role` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Name` varchar(50) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT NULL COMMENT '类型',
  `value` varchar(200) DEFAULT NULL COMMENT '值',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_rm_role
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_service_record
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_service_record`;
CREATE TABLE `t_rm_service_record` (
  `id` varchar(64) NOT NULL,
  `device_id` varchar(64) DEFAULT NULL COMMENT '设备id',
  `type` varchar(4) DEFAULT NULL COMMENT '检修类型（维修，养护等）',
  `name` varchar(128) DEFAULT NULL COMMENT '维修记录名称',
  `manufactor` varchar(64) DEFAULT NULL COMMENT '服务厂家',
  `manufactor_tel` varchar(24) DEFAULT NULL COMMENT '维修厂家电话',
  `reason` varchar(1000) DEFAULT NULL COMMENT '维修原因',
  `cycle` varchar(64) DEFAULT NULL COMMENT '维保周期',
  `check_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '维保日期',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备维修记录表';

-- ----------------------------
-- Records of t_rm_service_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_rm_user
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_user`;
CREATE TABLE `t_rm_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户姓名--例如张三',
  `loginame` varchar(255) DEFAULT NULL COMMENT '登录用户名--可能为空',
  `password` varchar(50) DEFAULT NULL COMMENT '登陆密码',
  `position` varchar(200) DEFAULT NULL COMMENT '职位',
  `department` varchar(255) DEFAULT NULL COMMENT '所属部门',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `phonenum` varchar(100) DEFAULT NULL COMMENT '手机号码',
  `ismanager` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否为管理者 0==管理者 1==员工',
  `isystem` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统自带数据 ',
  `Status` tinyint(4) DEFAULT '0' COMMENT '状态，0：正常，1：删除，2封禁',
  `description` varchar(500) DEFAULT NULL COMMENT '用户描述信息',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of t_rm_user
-- ----------------------------
INSERT INTO `t_rm_user` VALUES ('132', '13700206315', '13700206315', '96e79218965eb72c92a549dd5a330112', null, null, null, null, '1', '0', '0', null, null, '132');

-- ----------------------------
-- Table structure for t_rm_userbusiness
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_userbusiness`;
CREATE TABLE `t_rm_userbusiness` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Type` varchar(50) DEFAULT NULL COMMENT '类别',
  `KeyId` varchar(50) DEFAULT NULL COMMENT '主ID',
  `Value` varchar(10000) DEFAULT NULL COMMENT '值',
  `BtnStr` varchar(2000) DEFAULT NULL COMMENT '按钮权限',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='用户/角色/模块关系表';

-- ----------------------------
-- Records of t_rm_userbusiness
-- ----------------------------
INSERT INTO `t_rm_userbusiness` VALUES ('70', 'UserRole', '132', '[10]', null, '0');

-- ----------------------------
-- Table structure for t_rm_weter_level
-- ----------------------------
DROP TABLE IF EXISTS `t_rm_weter_level`;
CREATE TABLE `t_rm_weter_level` (
  `id` varchar(64) NOT NULL,
  `reservoir_id` varchar(64) DEFAULT NULL COMMENT '水库id',
  `standard_high` varchar(64) DEFAULT NULL COMMENT '标准水位高度',
  `current_high` varchar(64) DEFAULT NULL COMMENT '当前水位高度',
  `record_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '水位记录时间',
  `emerg_high` varchar(64) DEFAULT NULL COMMENT '告警水位',
  `inflow_volume` varchar(64) DEFAULT NULL COMMENT '流入水库水量（吨）',
  `outflow_volume` varchar(64) DEFAULT NULL COMMENT '泄洪水量（吨）',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(128) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(128) DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水位信息表';

-- ----------------------------
-- Records of t_rm_weter_level
-- ----------------------------
