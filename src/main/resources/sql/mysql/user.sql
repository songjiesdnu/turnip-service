/*
Navicat MySQL Data Transfer

Source Server         : 本机3306-wproot
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : turnipweb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-07-31 00:21:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `name` varchar(40) NOT NULL COMMENT '用户名（登录使用）',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `salt` varchar(32) NOT NULL COMMENT '密码的加盐',
  `realName` varchar(48) DEFAULT NULL COMMENT '真实姓名（可以重复）',
  `nickName` varchar(48) DEFAULT NULL COMMENT '昵称（可以重复）',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobileNo` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `registerTime` varchar(19) NOT NULL COMMENT '注册时间（格式:yyyy:mm:dd HH:mm:ss）',
  `status` varchar(1) NOT NULL DEFAULT '1' COMMENT '账号状态（0：未激活；1：已激活；2：锁定）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_index` (`name`) USING BTREE,
  KEY `mobileNo_index` (`mobileNo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='此表主要用于记录用户的登录注册信息。其他一些信息，比如：生日、学历、家庭住址等在另外的表中记录。';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '名称', 'sfasgfaf', '24', '', '', null, '', '', '1');
INSERT INTO `user` VALUES ('5df37f22b42a4853a6d243640cea5d54', 'name_test', 'de29d77448ebb2e6dade9e1f557c824b', 'da7a1a894e0447278381c5c247bb3a01', null, null, null, null, '2015:16:31 00:16:08', '1');
