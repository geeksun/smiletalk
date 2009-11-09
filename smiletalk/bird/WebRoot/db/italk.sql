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

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicId` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `topicContent` varchar(140) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `topicTime` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `topicStatus` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=gbk;

/*Data for the table `topic` */

insert  into `topic`(`topicId`,`username`,`topicContent`,`userid`,`topicTime`,`remark`,`topicStatus`) values (71,'13812345678','Mic',16,'2009-11-04 12:11:00','sms','1'),(72,'13812345678','Mic你好',16,'2009-11-04 12:11:00','sms','1'),(73,'13812345678','Mic梭子鱼销售C梭子鱼销梭子',16,'2009-11-04 12:11:00','sms','1'),(74,'13812345678','Mic子',16,'2009-11-04 12:11:00','sms','1'),(75,'13812345678','Mic梭子鱼销售C梭子鱼销梭子',16,'2009-11-04 12:11:00','sms','1'),(76,'13812345678','sdfMic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销梭子Mic梭子鱼销售C梭子鱼销adsf',16,'2009-11-06 04:59:41',NULL,NULL),(77,'13812345678','test',16,'2009-11-06 05:07:36',NULL,NULL),(78,'13812345678','test',16,'2009-11-06 05:09:03',NULL,NULL),(79,'13812345678','test',16,'2009-11-06 05:21:57',NULL,NULL),(80,'13812345678','test',16,'2009-11-06 05:33:37',NULL,NULL),(81,'13812345678','test',16,'2009-11-06 05:34:07',NULL,NULL),(82,'13812345678','test',16,'2009-11-06 05:34:28',NULL,NULL),(83,'13812345678','test',16,'2009-11-06 05:35:23',NULL,NULL),(84,'13812345678','test',16,'2009-11-06 05:36:31',NULL,NULL),(85,'13812345678','test',16,'2009-11-06 05:37:09',NULL,NULL),(86,'13812345678','test',16,'2009-11-06 05:51:42',NULL,NULL),(87,'13812345678','test',16,'2009-11-06 05:55:48',NULL,NULL),(88,'13812345678','test',16,'2009-11-06 06:04:36',NULL,NULL),(89,'13812345678','test',16,'2009-11-06 06:10:59',NULL,NULL),(90,'13812345678','test',16,'2009-11-06 06:11:03',NULL,NULL),(91,'13812345678','test',16,'2009-11-06 06:11:06',NULL,NULL),(92,'13812345678','test',16,'2009-11-06 06:21:09',NULL,NULL),(93,'13812345678','test',16,'2009-11-06 06:21:12',NULL,NULL),(94,'13812345678','test',16,'2009-11-06 06:21:15',NULL,NULL),(95,'13812345678','test',16,'2009-11-06 06:39:21',NULL,NULL),(96,'13812345678','demo',16,'2009-11-06 06:45:25',NULL,NULL),(97,'13812345678','demo',16,'2009-11-06 06:45:30',NULL,NULL),(98,'13812345678','22222',16,'2009-11-06 07:03:33',NULL,NULL),(99,'13812345678','22222',16,'2009-11-06 07:04:27',NULL,NULL),(100,'13812345678','22222',16,'2009-11-06 07:04:44',NULL,NULL),(101,'13812345678','22222',16,'2009-11-06 07:08:55',NULL,NULL),(102,'13812345678','eeeee',16,'2009-11-09 11:29:34',NULL,NULL),(103,'13812345678','test222',16,'2009-11-09 11:39:06',NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `regTime` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

/*Data for the table `user` */

insert  into `user`(`userId`,`username`,`password`,`email`,`regTime`,`remark`) values (1,'geeksun','geeksun','jzq1999@gmail.com','2009-11-04 12:27:23',NULL),(16,'13812345678','13812345678',NULL,'2009-11-04 12:11:00','sms');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
