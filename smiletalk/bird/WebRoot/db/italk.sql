/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.1.39-community : Database - italk
*********************************************************************
Server version : 5.1.39-community
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `italk`;

USE `italk`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `follow` */

DROP TABLE IF EXISTS `follow`;

CREATE TABLE `follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_follow_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) DEFAULT NULL,
  `topicContent` varchar(280) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `topicTime` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `topicStatus` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`topicId`),
  KEY `index_topic_userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=gbk;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮件',
  `regTime` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `isActive` varchar(2) DEFAULT NULL COMMENT '激活状态0：未激活1：激活',
  `validateCode` varchar(40) DEFAULT NULL COMMENT '验证码',
  `photoPath` varchar(150) DEFAULT NULL COMMENT '头像地址',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `region` varchar(40) DEFAULT NULL COMMENT '地区',
  PRIMARY KEY (`userId`),
  KEY `index_user_username` (`userName`),
  KEY `index_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=gbk;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
