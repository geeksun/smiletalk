/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.0.22-community-nt : Database - italk
*********************************************************************
Server version : 5.0.22-community-nt
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
  `id` bigint(20) NOT NULL auto_increment,
  `userId` bigint(20) default NULL,
  `followId` bigint(20) default NULL,
  `remark` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `follow` */

insert  into `follow`(`id`,`userId`,`followId`,`remark`) values (1,1,18,NULL);

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `topicId` bigint(20) NOT NULL auto_increment,
  `userName` varchar(32) default NULL,
  `topicContent` varchar(140) default NULL,
  `userId` bigint(20) default NULL,
  `topicTime` varchar(20) default NULL,
  `remark` varchar(100) default NULL,
  `topicStatus` varchar(2) default NULL,
  `followUserId` bigint(20) default NULL,
  PRIMARY KEY  (`topicId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `topic` */

insert  into `topic`(`topicId`,`userName`,`topicContent`,`userId`,`topicTime`,`remark`,`topicStatus`,`followUserId`) values (71,'13812345678','Mic',16,'2009-11-04 12:11:00','sms','1',NULL),(72,'13812345678','Mic浣犲ソ',16,'2009-11-04 12:11:00','sms','1',NULL),(73,'13812345678','Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙',16,'2009-11-04 12:11:00','sms','1',NULL),(74,'13812345678','Mic瀛?',16,'2009-11-04 12:11:00','sms','1',NULL),(75,'13812345678','Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙',16,'2009-11-04 12:11:00','sms','1',NULL),(76,'13812345678','sdfMic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢姊?瓙Mic姊?瓙楸奸攢鍞瓹姊?瓙楸奸攢',16,'2009-11-06 04:59:41',NULL,NULL,NULL),(77,'13812345678','test',16,'2009-11-06 05:07:36',NULL,NULL,NULL),(96,'13812345678','demo',16,'2009-11-06 06:45:25',NULL,NULL,NULL),(97,'13812345678','demo',16,'2009-11-06 06:45:30',NULL,NULL,NULL),(98,'13812345678','22222',16,'2009-11-06 07:03:33',NULL,NULL,NULL),(102,'13812345678','eeeee',16,'2009-11-09 11:29:34',NULL,NULL,NULL),(103,'13812345678','test222',16,'2009-11-09 11:39:06',NULL,NULL,NULL),(104,'13812345678','onet',16,'2009-11-09 03:28:04',NULL,NULL,NULL),(105,'13812345678','tokentest',16,'2009-11-10 11:47:57',NULL,NULL,NULL),(106,'13812345678','test2',16,'2009-11-10 11:53:51',NULL,NULL,NULL),(107,'13812345678','333',16,'2009-11-10 11:57:13',NULL,NULL,NULL),(108,'13812345678','www',16,'2009-11-10 01:12:40',NULL,NULL,NULL),(109,'13812345678','nnn',16,'2009-11-10 01:16:20',NULL,NULL,NULL),(110,'13812345678','test',16,'2009-11-10 01:27:19',NULL,NULL,NULL),(111,'13812345678','aaaa',16,'2009-11-10 01:28:46',NULL,NULL,NULL),(112,'13812345678','1',16,'2009-11-10 01:53:18',NULL,NULL,NULL),(113,'13812345678','s',16,'2009-11-10 02:01:08',NULL,NULL,NULL),(114,'13812345678','t',16,'2009-11-10 02:14:36',NULL,NULL,NULL),(115,'13812345678','sss',16,'2009-11-10 02:15:39',NULL,NULL,NULL),(116,'13812345678','ddd',16,'2009-11-10 14:17:38',NULL,NULL,NULL),(117,'13812345678','test',16,'2009-11-12 10:34:15',NULL,NULL,NULL),(118,'13812345678','tt',16,'2009-11-12 11:35:40',NULL,NULL,NULL),(120,'13812345678','ss',16,'2009-11-12 15:25:56',NULL,NULL,NULL),(121,'13812345678','13812345678',16,'2009-11-12 15:27:24',NULL,NULL,NULL),(122,'geeksun','hi,123',1,'2009-11-16 09:43:56',NULL,NULL,NULL),(123,'geeksun','test',1,'2009-11-16 11:15:58',NULL,NULL,NULL),(124,'test2','haha',18,'2009-11-16 14:31:22',NULL,NULL,NULL),(125,'geeksun','haha',1,'2009-11-16 15:59:34',NULL,NULL,NULL),(126,'geeksun','heihei',1,'2009-11-18 17:00:36',NULL,NULL,NULL),(127,'geeksun','天朝也要有twitter额',1,'2009-11-18 21:52:47',NULL,NULL,NULL),(128,'geeksun',NULL,1,'2009-11-28 21:24:09',NULL,NULL,NULL),(129,'geeksun',NULL,1,'2009-11-28 21:24:58',NULL,NULL,NULL),(130,'geeksun','test',1,'2009-11-28 21:28:41',NULL,NULL,NULL),(131,'geeksun','test3',1,'2009-11-28 21:47:26',NULL,NULL,NULL),(132,'geeksun','test34',1,'2009-11-28 21:50:19',NULL,NULL,NULL),(133,'geeksun','134123412',1,'2009-11-28 21:59:45',NULL,NULL,NULL),(134,'geeksun','222222',1,'2009-11-29 17:01:09',NULL,NULL,NULL),(135,'geeksun','eee',1,'2009-11-30 12:52:45',NULL,NULL,NULL),(136,NULL,'eee',NULL,'2009-11-30 12:54:23',NULL,NULL,NULL),(137,NULL,NULL,NULL,'2009-11-30 12:59:22',NULL,NULL,NULL),(138,'geeksun','333',1,'2009-11-30 13:04:22',NULL,NULL,NULL),(139,'geeksun','rrr',1,'2009-11-30 13:05:59',NULL,NULL,NULL),(140,'geeksun','test',1,'2009-11-30 13:07:53',NULL,NULL,NULL),(141,'geeksun','yy',1,'2009-11-30 13:08:26',NULL,NULL,NULL),(142,'geeksun','123',1,'2009-11-30 13:38:46',NULL,NULL,NULL),(143,'geeksun','234',1,'2009-11-30 13:38:54',NULL,NULL,NULL),(144,'geeksun','sdfas',1,'2009-11-30 13:39:22',NULL,NULL,NULL),(145,'geeksun','456',1,'2009-11-30 13:39:42',NULL,NULL,NULL),(146,'geeksun','asdf',1,'2009-11-30 13:41:33',NULL,NULL,NULL),(147,'geeksun','sss',1,'2009-11-30 13:51:19',NULL,NULL,NULL),(148,'geeksun','ter',1,'2009-11-30 13:51:27',NULL,NULL,NULL),(149,'geeksun','134234',1,'2009-11-30 13:51:45',NULL,NULL,NULL),(150,'test2','test333',18,'2009-11-30 19:48:19',NULL,NULL,NULL),(151,'geeksun','hy',1,'2009-11-30 20:47:08',NULL,NULL,NULL),(152,'geeksun3','tset',17,'2009-11-30 20:51:17',NULL,NULL,NULL),(153,'geeksun','dd',1,'2009-11-30 20:51:33',NULL,NULL,NULL),(154,'geeksun','tes',1,'2009-11-30 20:51:46',NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` bigint(20) NOT NULL auto_increment COMMENT '鐢ㄦ埛id',
  `userName` varchar(20) default NULL COMMENT '鐢ㄦ埛鍚�',
  `password` varchar(20) default NULL COMMENT '瀵嗙爜',
  `email` varchar(30) default NULL COMMENT '閭欢',
  `regTime` varchar(20) default NULL COMMENT '娉ㄥ唽鏃堕棿',
  `remark` varchar(100) default NULL COMMENT '澶囨敞',
  `isActive` varchar(2) default NULL COMMENT '婵�娲荤姸鎬�0锛氭湭婵�娲�1锛氭縺娲�',
  `validateCode` varchar(40) default NULL COMMENT '楠岃瘉鐮�',
  `followUserId` bigint(20) default NULL,
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `user` */

insert  into `user`(`userId`,`userName`,`password`,`email`,`regTime`,`remark`,`isActive`,`validateCode`,`followUserId`) values (1,'geeksun','geeksun','jzq1999@gmail.com','2009-11-04 12:27:23',NULL,NULL,'eedqwer',NULL),(16,'13812345678','13812345678',NULL,'2009-11-04 12:11:00','sms',NULL,NULL,NULL),(17,'geeksun3','geeksun','geeksun@163.com','2009-11-16 12:05:55',NULL,NULL,NULL,NULL),(18,'test2','geeksun','geeksuerwn@163.com','2009-11-16 14:29:52',NULL,NULL,NULL,NULL),(19,'geeksun3','ggggggg','ddafds','2009-11-16 14:49:58',NULL,NULL,NULL,NULL),(20,'13812345678','geeeeee','jzq1999@gmail.com','2009-11-16 15:18:20',NULL,NULL,NULL,NULL),(21,'13812345678','ggggg','jzq1999@gmail.com','2009-11-16 15:20:16',NULL,NULL,NULL,NULL),(22,'geedksun','ggggg','jzq1999@gmail.com','2009-11-16 15:21:24',NULL,NULL,'eedqwer',NULL),(23,'test333','geeksun','jzqdd9@163.com','2009-11-18 11:20:53',NULL,NULL,NULL,NULL),(24,'138123456783','geeksu','jzdddd899@163.com','2009-11-18 11:24:09',NULL,NULL,NULL,NULL),(25,'13812345','geeks','jzqere9@163.com','2009-11-18 11:28:47',NULL,NULL,NULL,NULL),(26,'1381234567','geeksun','jzq944899@163.com','2009-11-18 15:52:51',NULL,'0','77C1EF7BF7F25B46B6EB29FA7CDA3693',NULL),(27,'geeksun33','geeksu','jzq9894449@163.com','2009-11-29 01:45:23',NULL,'0',NULL,NULL),(28,'geeksun1','geeksu','jzq9899@163.com','2009-11-29 01:52:11',NULL,'0','665AF006C362960B26CB343C0650C4B0',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
