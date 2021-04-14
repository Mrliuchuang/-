/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50535
Source Host           : localhost:3306
Source Database       : renren_security

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2021-04-15 00:46:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_food
-- ----------------------------
DROP TABLE IF EXISTS `tb_food`;
CREATE TABLE `tb_food` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户user_id',
  `name_food` varchar(50) DEFAULT NULL COMMENT '美食名',
  `content_food` varchar(500) DEFAULT NULL COMMENT '美食内容',
  `url_food` varchar(500) DEFAULT NULL COMMENT '美食文件的url',
  `time_food` varchar(500) DEFAULT NULL COMMENT '美食上传时间',
  `extends1` varchar(500) DEFAULT NULL COMMENT '拓展字段1',
  `extends2` varchar(500) DEFAULT NULL COMMENT '拓展字段2',
  `food_id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`food_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='晒美食';

-- ----------------------------
-- Records of tb_food
-- ----------------------------
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd', '大是大非烦烦烦烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:42', null, null, '3');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd1', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:45', null, null, '4');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd12', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:48', null, null, '5');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd124', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:50', null, null, '6');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd1241', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:51', null, null, '7');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd12414', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:53', null, null, '8');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd12414123', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:55', null, null, '9');
INSERT INTO `tb_food` VALUES ('2', '黄门就w\'w\'wdsd12414123123', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:57', null, null, '10');
INSERT INTO `tb_food` VALUES ('2', '222', '大是大非烦烦烦www烦烦烦烦烦烦烦烦烦烦烦烦方法', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:23:59', null, null, '11');
INSERT INTO `tb_food` VALUES ('2', '烧烤', '阿斯顿发射点', 'http://localhost:8081/renren-api/touxiang/3b25874e-f322-4c77-af9b-5f6fce834e9120210413003124.png', '2021-04-13 23:24:01', null, null, '12');

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '商品名',
  `intro` varchar(500) DEFAULT NULL COMMENT '介绍',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商品管理';

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('1', 'string', 'string', '0.00', '0');

-- ----------------------------
-- Table structure for tb_market
-- ----------------------------
DROP TABLE IF EXISTS `tb_market`;
CREATE TABLE `tb_market` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户user_id',
  `name_market` varchar(50) DEFAULT NULL COMMENT '商品名',
  `content_market` varchar(500) DEFAULT NULL COMMENT '商品内容',
  `url_market` varchar(500) DEFAULT NULL COMMENT '商品文件的url',
  `time_market` varchar(500) DEFAULT NULL COMMENT '商品上传时间',
  `extends1` varchar(500) DEFAULT NULL COMMENT '拓展字段1',
  `extends2` varchar(500) DEFAULT NULL COMMENT '拓展字段2',
  `money_market` int(200) DEFAULT NULL COMMENT '商品价格',
  `number_market` int(200) DEFAULT NULL COMMENT '商品数量',
  `market_id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`market_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='集市';

-- ----------------------------
-- Records of tb_market
-- ----------------------------

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户user_id',
  `name_menu` varchar(50) DEFAULT NULL COMMENT '菜谱名',
  `content_menu` varchar(500) DEFAULT NULL COMMENT '菜谱内容',
  `url_menu` varchar(500) DEFAULT NULL COMMENT '菜谱文件的url',
  `time_menu` varchar(500) DEFAULT NULL COMMENT '菜谱上传时间',
  `extends1` varchar(500) DEFAULT NULL COMMENT '拓展字段1',
  `extends2` varchar(500) DEFAULT NULL COMMENT '拓展字段2',
  `menu_id` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8 COMMENT='菜谱';

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('2', '黄焖鸡', '顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', 'string', 'string', 'stringw\'w\'w', 'string', '23');
INSERT INTO `tb_menu` VALUES ('2', 'vvvvv', 'vvvvv', 'vvvvv', 'vvvv', 'vvvv', 'vvv', '33');
INSERT INTO `tb_menu` VALUES ('12', null, null, null, null, null, null, '230');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES ('1', 'd959b88b14a04fc9945ef0dfb0215783', '2021-04-12 13:58:07', '2021-04-12 01:58:07');
INSERT INTO `tb_token` VALUES ('2', '6c3801ad05664d658fdd02c3ea15843d', '2021-04-14 11:30:06', '2021-04-13 23:30:06');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
INSERT INTO `tb_user` VALUES ('2', '18840179228', '18840179228', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2021-04-12 01:59:03');
