/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : mp

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-09-15 21:43:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('10');

-- ----------------------------
-- Table structure for lucy_money
-- ----------------------------
DROP TABLE IF EXISTS `lucy_money`;
CREATE TABLE `lucy_money` (
  `id` int(11) NOT NULL,
  `consumer` varchar(255) DEFAULT NULL,
  `money` decimal(6,2) DEFAULT NULL,
  `producer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lucy_money
-- ----------------------------
INSERT INTO `lucy_money` VALUES ('1', '飞机', '8888.00', 'rong');
INSERT INTO `lucy_money` VALUES ('2', null, '8888.00', '荣儿');
INSERT INTO `lucy_money` VALUES ('3', null, '6688.00', '荣');
INSERT INTO `lucy_money` VALUES ('8', null, '88.88', '阿飞');
INSERT INTO `lucy_money` VALUES ('9', null, '888.88', '阿荣');

-- ----------------------------
-- Table structure for tt_user
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '直属上级id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `manager_fk` (`manager_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tt_user
-- ----------------------------
INSERT INTO `tt_user` VALUES ('1087982257332887553', '大boss', '40', 'boss@baomidou.com', null, '2019-01-11 14:20:20');
INSERT INTO `tt_user` VALUES ('1088248166370832385', '王天风', '26', 'wtf@baomidou.com', '1087982257332887553', '2019-02-05 11:12:22');
INSERT INTO `tt_user` VALUES ('1088250446457389058', '李艺伟', '28', 'lyw@baomidou.com', '1088248166370832385', '2019-02-14 08:31:16');
INSERT INTO `tt_user` VALUES ('1094590409767661570', '张雨琪', '31', 'zjq@baomidou.com', '1088248166370832385', '2019-01-14 09:15:15');
INSERT INTO `tt_user` VALUES ('1094592041087729666', '刘红雨', '32', 'lhm@baomidou.com', '1088248166370832385', '2019-01-14 09:48:16');
INSERT INTO `tt_user` VALUES ('1165069654564294658', '测试2', '22', '3434343@qq.com', '1087982257332887553', '2019-08-24 09:13:46');
INSERT INTO `tt_user` VALUES ('1165076512381374465', '测试7', '26', '77777@qq.com', '1087982257332887553', '2019-08-24 09:41:01');
INSERT INTO `tt_user` VALUES ('1165077518678773762', '测试8', '33', '888888@qq.com', '1087982257332887553', '2019-08-24 09:45:01');
INSERT INTO `tt_user` VALUES ('1166351711428943874', '测试999', null, null, null, null);
INSERT INTO `tt_user` VALUES ('1166360466136875010', '测试14', '14', 'dfsdff@qq.com', '1094592041087729666', '2019-08-27 22:42:59');
INSERT INTO `tt_user` VALUES ('1166370280069959681', '测试171717', '26', null, null, null);
INSERT INTO `tt_user` VALUES ('1168178847437574146', '测试14', '14', 'dfsdff@qq.com', '1094592041087729666', '2019-09-01 23:08:36');
INSERT INTO `tt_user` VALUES ('1168178852315549697', '测试10', '18', '1010101@qq.com', '1087982257332887553', '2019-09-01 23:08:37');
INSERT INTO `tt_user` VALUES ('1168178858091106306', '测试16', '23', null, null, null);
INSERT INTO `tt_user` VALUES ('1168178858091106307', '测试17', '34', null, null, null);
