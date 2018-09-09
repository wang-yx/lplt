# lplt
数据库设计:

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost
 Source Database       : d_proj

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : utf-8

 Date: 09/09/2018 18:11:29 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `qqqq`
-- ----------------------------
DROP TABLE IF EXISTS `qqqq`;
CREATE TABLE `qqqq` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `prod_name` longtext COMMENT '产品名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `is_show` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `comy_name` varchar(50) DEFAULT NULL COMMENT '公司的名称',
  `comy_logokey` varchar(50) DEFAULT NULL COMMENT 'logo图片',
  `comy_introduce` longtext COMMENT '公司介绍',
  `comy_detail` longtext COMMENT '公司详细',
  `comy_comment` longtext COMMENT '公司备注',
  `comy_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `comy_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `comy_phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `comy_email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `comy_zipcode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `comy_fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `comy_person` varchar(20) DEFAULT NULL COMMENT '法人或者负责人',
  `comy_registtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_info` tinyint(4) DEFAULT '0' COMMENT '是否是联系我们的info，0不info，1是info',
  `is_release` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司简介表 或 联系我们的信息';

-- ----------------------------
--  Table structure for `t_news`
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `new_name` varchar(50) DEFAULT NULL COMMENT '新闻的名称',
  `new_imgskey` varchar(50) DEFAULT NULL COMMENT '小图片，在目录显示',
  `new_imgmkey` varchar(50) DEFAULT NULL COMMENT '中图片，在列表显示',
  `new_imglkey` varchar(50) DEFAULT NULL COMMENT '可保存大图片',
  `new_introduce` longtext COMMENT '新闻介绍',
  `new_detail` longtext COMMENT '新闻详细',
  `new_comment` longtext COMMENT '新闻备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_release` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `show_homepage` tinyint(4) DEFAULT '0' COMMENT '是否显示在首页，0不显示，1显示',
  `read_num` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- ----------------------------
--  Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(10) NOT NULL,
  `permission_name` varchar(50) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `img_key` varchar(50) DEFAULT NULL COMMENT '图片的key',
  `img_path` varchar(100) DEFAULT NULL COMMENT '图片路径',
  `img_catg` tinyint(4) DEFAULT NULL COMMENT '//是首页图片0，新闻中的图片1，还是产品的图片2',
  `img_comment` longtext COMMENT '图片备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_release` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
--  Table structure for `t_prodcategory`
-- ----------------------------
DROP TABLE IF EXISTS `t_prodcategory`;
CREATE TABLE `t_prodcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `catg_name` varchar(50) DEFAULT NULL COMMENT '产品类别的名称',
  `catg_comment` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品类别表';

-- ----------------------------
--  Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `prod_name` varchar(50) DEFAULT NULL COMMENT '产品类别的名称',
  `prod_catg` int(11) DEFAULT NULL COMMENT '产品类别的ID',
  `prod_imgskey` varchar(50) DEFAULT NULL COMMENT '小图片，在目录显示',
  `prod_imgmkey` varchar(50) DEFAULT NULL COMMENT '中图片，在列表显示',
  `prod_imglkey` varchar(50) DEFAULT NULL COMMENT '可保存大图片',
  `prod_introduce` longtext COMMENT '产品介绍',
  `prod_detail` longtext COMMENT '产品详细',
  `prod_comment` longtext COMMENT '产品备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_release` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `show_homepage` tinyint(4) DEFAULT '0' COMMENT '是否显示在首页，0不显示，1显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
--  Records of `t_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES ('2', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:22:58', '0', '2018-09-08 00:22:58', '0'), ('3', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:27:02', '0', '2018-09-08 00:27:02', '0'), ('4', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:29:57', '0', '2018-09-08 00:29:57', '0'), ('5', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:30:58', '0', '2018-09-08 00:30:58', '0'), ('6', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:32:45', '0', '2018-09-08 00:32:45', '0'), ('7', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 00:34:23', '0', '2018-09-08 00:34:23', '0'), ('8', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 19:42:02', '0', '2018-09-08 19:42:02', '0'), ('9', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 19:53:59', '0', '2018-09-08 19:53:59', '0'), ('10', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 21:04:59', '0', '2018-09-08 21:04:59', '0'), ('11', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 21:07:16', '0', '2018-09-08 21:07:16', '0'), ('12', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 21:11:19', '0', '2018-09-08 21:11:19', '0'), ('13', 'prodName', '1', '123456', '123456', '123456', 'ProdIntroduce', 'ProdDetail', 'Comment', '2018-09-08 21:13:31', '0', '2018-09-08 21:13:31', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(10) NOT NULL,
  `role_name` varchar(40) DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `permission_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'wyx');
COMMIT;

-- ----------------------------
--  Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(50) DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `is_admin` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不是，1是',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `t_users`
-- ----------------------------
BEGIN;
INSERT INTO `t_users` VALUES ('1', 'admin', 'admin', 'jack', '1', '2018-09-07 00:08:21');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
