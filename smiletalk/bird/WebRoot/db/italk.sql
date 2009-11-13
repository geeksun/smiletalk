﻿/*
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

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) DEFAULT NULL,
  `topicContent` varchar(140) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `topicTime` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `topicStatus` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=gbk;

/*Data for the table `topic` */

insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (71,'13812345678','Mic',16,'2009-11-04 12:11:00','sms','1');
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (72,'13812345678','Mic你好',16,'2009-11-04 12:11:00','sms','1');
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (73,'13812345678','Mic梭子鱼销售C梭子鱼销梭子',16,'2009-11-04 12:11:00','sms','1');
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (74,'13812345678','Mic子',16,'2009-11-04 12:11:00','sms','1');
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (75,'13812345678','Mic梭子鱼销售C梭子鱼销梭子',16,'2009-11-04 12:11:00','sms','1');
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (76,'13812345678','sdfMic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销adsf',16,'2009-11-06 04:59:41',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (77,'13812345678','test',16,'2009-11-06 05:07:36',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (96,'13812345678','demo',16,'2009-11-06 06:45:25',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (97,'13812345678','demo',16,'2009-11-06 06:45:30',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (98,'13812345678','22222',16,'2009-11-06 07:03:33',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (102,'13812345678','eeeee',16,'2009-11-09 11:29:34',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (103,'13812345678','test222',16,'2009-11-09 11:39:06',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (104,'13812345678','onet',16,'2009-11-09 03:28:04',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (105,'13812345678','tokentest',16,'2009-11-10 11:47:57',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (106,'13812345678','test2',16,'2009-11-10 11:53:51',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (107,'13812345678','333',16,'2009-11-10 11:57:13',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (108,'13812345678','www',16,'2009-11-10 01:12:40',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (109,'13812345678','nnn',16,'2009-11-10 01:16:20',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (110,'13812345678','test',16,'2009-11-10 01:27:19',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (111,'13812345678','aaaa',16,'2009-11-10 01:28:46',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (112,'13812345678','1',16,'2009-11-10 01:53:18',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (113,'13812345678','s',16,'2009-11-10 02:01:08',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (114,'13812345678','t',16,'2009-11-10 02:14:36',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (115,'13812345678','sss',16,'2009-11-10 02:15:39',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (116,'13812345678','ddd',16,'2009-11-10 14:17:38',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (117,'13812345678','test',16,'2009-11-12 10:34:15',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (118,'13812345678','tt',16,'2009-11-12 11:35:40',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (120,'13812345678','ss',16,'2009-11-12 15:25:56',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (121,'13812345678','13812345678',16,'2009-11-12 15:27:24',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `regTime` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`) values (1,'geeksun','geeksun','jzq1999@gmail.com','2009-11-04 12:27:23',NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`) values (16,'13812345678','13812345678',NULL,'2009-11-04 12:11:00','sms');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;