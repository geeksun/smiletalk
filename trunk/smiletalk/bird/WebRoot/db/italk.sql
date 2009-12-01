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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

/*Data for the table `follow` */

insert  into `follow`(`id`,`userId`,`followId`) values (1,1,18);

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
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=gbk;

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
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (122,'geeksun','hi,123',1,'2009-11-16 09:43:56',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (123,'geeksun','test',1,'2009-11-16 11:15:58',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (124,'test2','haha',18,'2009-11-16 14:31:22',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (125,'geeksun','haha',1,'2009-11-16 15:59:34',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (126,'geeksun','heihei',1,'2009-11-18 17:00:36',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (127,'geeksun','2009-11-24',1,'2009-11-24 14:16:09',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (128,'geeksun','????',1,'2009-11-24 14:33:35',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (129,'geeksun','ctrl+enter submit',1,'2009-11-24 16:36:02',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (130,'geeksun','test by talk',1,'2009-11-25 11:49:17',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (131,'geeksun',NULL,1,'2009-12-01 10:24:58',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (132,'geeksun',NULL,1,'2009-12-01 10:25:12',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (133,'geeksun',NULL,1,'2009-12-01 10:25:19',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (134,'geeksun',NULL,1,'2009-12-01 10:25:21',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (135,'geeksun',NULL,1,'2009-12-01 10:25:24',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (136,'geeksun',NULL,1,'2009-12-01 14:36:13',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (137,'test2','ieheheeh',18,'2009-12-01 14:36:35',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (138,'geeksun','twitter????',1,'2009-12-01 14:36:54',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (139,'geeksun','kdlas k?й?)?????',1,'2009-12-01 14:49:13',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (140,'geeksun',NULL,1,'2009-12-01 14:52:24',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (141,'geeksun',NULL,1,'2009-12-01 14:53:02',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (142,'geeksun',NULL,1,'2009-12-01 14:53:03',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (143,'geeksun',NULL,1,'2009-12-01 14:53:04',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (144,'geeksun','??????',1,'2009-12-01 14:54:52',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (145,'geeksun','??????????140??',1,'2009-12-01 14:55:56',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (146,'geeksun','可以输入140字',1,'2009-12-01 14:59:02',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (147,'geeksun',NULL,1,'2009-12-01 14:59:25',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (148,'geeksun','总有低潮！克',1,'2009-12-01 15:46:50',NULL,NULL);
insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`) values (149,'geeksun',NULL,1,'2009-12-01 18:25:10',NULL,NULL);

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
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=gbk;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (1,'geeksun','geeksun','jzq1999@gmail.com','2009-11-04 12:27:23',NULL,NULL,'eedqwer','/photo/3ab_d7a47830_b232_4936_8847_0d50fefcb5c9_0.jpg','1',', , , ','');
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (16,'13812345678','13812345678',NULL,'2009-11-04 12:11:00','sms',NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (17,'geeksun3','geeksun','geeksun@163.com','2009-11-16 12:05:55',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (18,'test2','geeksun','geeksuerwn@163.com','2009-11-16 14:29:52',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (19,'geeksun3','ggggggg','ddafds','2009-11-16 14:49:58',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (20,'13812345678','geeeeee','jzq1999@gmail.com','2009-11-16 15:18:20',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (21,'13812345678','ggggg','jzq1999@gmail.com','2009-11-16 15:20:16',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (22,'geedksun','ggggg','jzq1999@gmail.com','2009-11-16 15:21:24',NULL,NULL,'eedqwer',NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (23,'test333','geeksun','jzqdd9@163.com','2009-11-18 11:20:53',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (24,'138123456783','geeksu','jzdddd899@163.com','2009-11-18 11:24:09',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (25,'13812345','geeks','jzqere9@163.com','2009-11-18 11:28:47',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`photoPath`,`sex`,`birthday`,`region`) values (26,'1381234567','geeksun','jzq9899@163.com','2009-11-18 15:52:51',NULL,'0','77C1EF7BF7F25B46B6EB29FA7CDA3693',NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
