/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost
 Source Database       : d_lplt

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : utf-8

 Date: 11/26/2018 22:51:48 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_after_service`
-- ----------------------------
DROP TABLE IF EXISTS `t_after_service`;
CREATE TABLE `t_after_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '保修人姓名',
  `phone` varchar(15) DEFAULT NULL COMMENT '报修人手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '报修人邮箱',
  `company` varchar(50) DEFAULT NULL COMMENT '报修人公司名称',
  `question` longtext COMMENT '报修问题',
  `reply` longtext COMMENT '问题答复，解答',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isdeal` tinyint(4) DEFAULT '0' COMMENT '是否已经处理完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='售后问题处理表';

-- ----------------------------
--  Records of `t_after_service`
-- ----------------------------
BEGIN;
INSERT INTO `t_after_service` VALUES ('1', '问题1', '123456789', 'aaaa@123.com', '报修公司', '问题', '售后回复11111', '2018-11-25 23:46:43', '2018-11-25 23:44:20', '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_company`
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '公司的名称',
  `introduce` longtext COMMENT '公司介绍',
  `detail` longtext COMMENT '公司详细',
  `comment` longtext COMMENT '公司备注',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `language` tinyint(4) DEFAULT '0' COMMENT '0汉语，1英语',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='公司简介表 或 联系我们的信息';

-- ----------------------------
--  Records of `t_company`
-- ----------------------------
BEGIN;
INSERT INTO `t_company` VALUES ('3', '公司名', '公司介绍', '公司详细', '公司备注信息', '城市', '地址', '2018-11-26 22:21:19', '2018-11-26 22:21:19', '0'), ('4', 'name', 'introduce', 'detail', 'comment', 'city', 'address', '2018-11-26 22:21:19', '2018-11-26 22:21:19', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `chineseid` int(11) NOT NULL COMMENT '关联中文company的id',
  `englishid` int(11) NOT NULL COMMENT '关联英文company的id',
  `logokey` varchar(200) DEFAULT NULL COMMENT 'logo图片',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `zipcode` varchar(20) DEFAULT NULL COMMENT '邮编',
  `fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `person` varchar(20) DEFAULT NULL COMMENT '法人或者负责人',
  `registtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isinfo` tinyint(4) DEFAULT '0' COMMENT '是否是联系我们的info，0不info，1是info',
  `isrelease` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `releasetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='公司简介表 或 联系我们的信息';

-- ----------------------------
--  Records of `t_info`
-- ----------------------------
BEGIN;
INSERT INTO `t_info` VALUES ('2', '3', '4', '图片url', '123456789', 'aaa@email.com', '123456', '12345', '公司法人', '2017-12-31 10:00:00', '2018-11-26 22:21:19', '0', '0', null, '2018-11-26 22:21:19'), ('4', '0', '0', '图片url', '0000000000', 'aaa@email.com', '123456', '12345', '公司法人', '2017-12-31 10:00:00', '2018-11-26 22:43:44', '1', '0', null, '2018-11-26 22:43:44'), ('5', '0', '0', '图片url', '0000000000', 'aaa@email.com', '123456', '12345', '公司法人', '2017-12-31 10:00:00', '2018-11-26 22:43:46', '1', '0', null, '2018-11-26 22:43:46');
COMMIT;

-- ----------------------------
--  Table structure for `t_new`
-- ----------------------------
DROP TABLE IF EXISTS `t_new`;
CREATE TABLE `t_new` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `englishid` int(11) NOT NULL COMMENT '英文id',
  `chineseid` int(11) NOT NULL COMMENT '中文id',
  `img` varchar(200) DEFAULT NULL,
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `isrelease` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `releasetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `showhomepage` tinyint(4) DEFAULT '0' COMMENT '是否显示在首页，0不显示，1显示',
  `readnum` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- ----------------------------
--  Records of `t_new`
-- ----------------------------
BEGIN;
INSERT INTO `t_new` VALUES ('2', '3', '2', null, '2018-11-24 23:42:46', '2018-11-25 00:07:57', '0', '2018-11-25 00:07:57', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_new_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_new_detail`;
CREATE TABLE `t_new_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '新闻的名称',
  `introduce` longtext COMMENT '新闻介绍',
  `detail` longtext COMMENT '新闻详细',
  `comment` longtext COMMENT '新闻备注',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `language` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='新闻表';

-- ----------------------------
--  Records of `t_new_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_new_detail` VALUES ('2', '中文中文11112222', null, '中文中文detail', '中文中文comment', '2018-11-25 00:07:57', '2018-11-24 23:42:46', '0'), ('3', 'englishenglish', null, 'englishenglishenglishdetail', 'englishenglishenglishenglishcomment', '2018-11-25 00:07:57', '2018-11-24 23:42:46', '1');
COMMIT;

-- ----------------------------
--  Table structure for `t_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `img_key` varchar(50) DEFAULT NULL COMMENT '图片的key',
  `img_path` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `img_catg` tinyint(4) DEFAULT NULL COMMENT '//是首页图片0，新闻中的图片1，还是产品的图片2',
  `img_comment` longtext COMMENT '图片备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_release` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `release_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='图片表';

-- ----------------------------
--  Table structure for `t_prodcategory`
-- ----------------------------
DROP TABLE IF EXISTS `t_prodcategory`;
CREATE TABLE `t_prodcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品类别的名称',
  `nameen` varchar(50) DEFAULT NULL COMMENT '产品类别的名称 英文',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='产品类别表';

-- ----------------------------
--  Records of `t_prodcategory`
-- ----------------------------
BEGIN;
INSERT INTO `t_prodcategory` VALUES ('1', '类别11111', 'ccategroy one', 'commentcomment', null), ('2', '类别2', 'ccategroy two', 'commentcomment', null);
COMMIT;

-- ----------------------------
--  Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `englishid` int(11) NOT NULL COMMENT '关联英语的id',
  `chineseid` int(11) NOT NULL COMMENT '关联汉语的id',
  `categoryid` int(11) DEFAULT NULL COMMENT '产品类别的ID',
  `img` varchar(200) DEFAULT NULL COMMENT '图片链接',
  `salehotline` varchar(15) DEFAULT NULL COMMENT '销售电话',
  `servicehotline` varchar(15) DEFAULT NULL COMMENT '服务电话',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `isrelease` tinyint(4) DEFAULT '0' COMMENT '是否发布，0不发布，1发布',
  `releasetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `showhomepage` tinyint(4) DEFAULT '0' COMMENT '是否显示在首页，0不显示，1显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
--  Records of `t_product`
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES ('15', '17', '16', '1', 'imgimgimgimg', '123456789', '123456789', '2018-11-25 13:59:16', '2018-11-25 13:59:16', '0', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `t_product_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_detail`;
CREATE TABLE `t_product_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '产品类别的名称',
  `maker` varchar(50) DEFAULT NULL COMMENT '制造商',
  `dealer` varchar(50) DEFAULT NULL COMMENT '经销商',
  `type` varchar(50) DEFAULT NULL COMMENT '型号',
  `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
  `source` varchar(50) DEFAULT NULL COMMENT '来源',
  `introduce` text COMMENT '产品介绍',
  `techadvantage` longtext COMMENT '技术优势',
  `techparams` longtext COMMENT '技术参数',
  `applicationarea` longtext COMMENT '应用领域',
  `detail` longtext COMMENT '产品详细',
  `comment` text COMMENT '产品备注',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `language` tinyint(4) DEFAULT '0' COMMENT '0中文，1英文',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='中英文产品详细表';

-- ----------------------------
--  Records of `t_product_detail`
-- ----------------------------
BEGIN;
INSERT INTO `t_product_detail` VALUES ('16', '产品名字22', '制造商', '经销商', '型号', '品牌', '来源', '介绍', '技术优势', '技术参数', null, '产品详细', '产品备注', '2018-11-25 13:59:16', '2018-11-25 13:59:16', '0'), ('17', 'name', 'maker', 'dealer ', 'type', 'brand', 'source', 'introduce', 'techadvantage', 'techparams', null, 'detail', 'comment', '2018-11-25 13:59:16', '2018-11-25 13:59:16', '1');
COMMIT;

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

SET FOREIGN_KEY_CHECKS = 1;
