/*
Navicat MySQL Data Transfer

Source Server         : 本机3306-wproot
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : turnipweb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-07-31 00:21:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `userprofile`
-- ----------------------------
DROP TABLE IF EXISTS `userprofile`;
CREATE TABLE `userprofile` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `userId` varchar(32) DEFAULT NULL COMMENT '关联user表的主键',
  `birthday` varchar(19) DEFAULT NULL COMMENT '生日（格式：yyyy:mm:dd HH:mm:ss）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId_index` (`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userprofile
-- ----------------------------
