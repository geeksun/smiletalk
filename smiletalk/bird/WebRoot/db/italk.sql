-- MySQL dump 10.13  Distrib 5.1.53, for Win32 (ia32)
--
-- Host: localhost    Database: italk
-- ------------------------------------------------------
-- Server version	5.1.53-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act_module`
--

DROP TABLE IF EXISTS `act_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `action` varchar(40) DEFAULT NULL,
  `action_cn` varchar(40) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `module_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `data_log`
--

DROP TABLE IF EXISTS `data_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module_id` bigint(20) DEFAULT NULL,
  `opt_id` varchar(40) DEFAULT NULL,
  `opt_content` varchar(200) DEFAULT NULL,
  `opt_time` datetime DEFAULT NULL,
  `changes_data` varchar(100) DEFAULT NULL,
  `original_data` varchar(100) DEFAULT NULL,
  `obj_id` varchar(100) DEFAULT NULL,
  `ip_address` varchar(40) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `opt_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `follow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `followId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_follow_userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opt_id` varchar(40) DEFAULT NULL,
  `opt_content` varchar(200) DEFAULT NULL,
  `opt_time` datetime DEFAULT NULL,
  `obj_id` varchar(100) DEFAULT NULL,
  `ip_address` varchar(40) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `module_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-12-13 16:30:41
