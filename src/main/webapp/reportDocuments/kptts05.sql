/*
SQLyog Community Edition- MySQL GUI v8.02 
MySQL - 5.5.27 : Database - kptts2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`kptts2` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `kptts2`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `category` */

insert  into `category`(`id`,`category`) values (1,'Documents For View'),(2,'Request For Help'),(3,'Customer Issue'),(4,'Customer Service Request'),(5,'Internal Harware Issue'),(6,'Create Document'),(7,'Release Payment');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `department` */

insert  into `department`(`id`,`department`) values (1,'HR'),(2,'Administration'),(3,'Production'),(4,'Distribution');

/*Table structure for table `designation` */

DROP TABLE IF EXISTS `designation`;

CREATE TABLE `designation` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `designation` */

insert  into `designation`(`id`,`name`) values (1,'ADMIN'),(2,'MANAGER'),(3,'DIVISION HEAD'),(4,'REGION HEAD'),(5,'FIELD EXECUTIVE'),(6,'DEALER'),(7,'USER'),(8,'CASHER'),(9,'HR MANAGER');

/*Table structure for table `kpstatus` */

DROP TABLE IF EXISTS `kpstatus`;

CREATE TABLE `kpstatus` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scolour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kpstatus` */

insert  into `kpstatus`(`id`,`name`,`scolour`) values (1,'Closed','green'),(2,'Assigned','light-red'),(3,'Acknowledged','grey'),(4,'Resolved','light-green'),(5,'Feedback','purple'),(6,'Reopen','red'),(7,'Duplicate','pink'),(8,'Won\'t fix','brown');

/*Table structure for table `kpstatuslogs` */

DROP TABLE IF EXISTS `kpstatuslogs`;

CREATE TABLE `kpstatuslogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `iassignby` varchar(255) DEFAULT NULL,
  `iassignto` varchar(255) DEFAULT NULL,
  `issueid` varchar(255) DEFAULT NULL,
  `kpstatus` varchar(255) DEFAULT NULL,
  `statustime` datetime DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `kpstatuslogs` */

insert  into `kpstatuslogs`(`id`,`description`,`iassignby`,`iassignto`,`issueid`,`kpstatus`,`statustime`,`subject`) values (1,'test for document 25',NULL,'2','10','2','2018-01-02 16:50:24','testfor post'),(2,'test for document 25',NULL,'2','10','2','2018-01-02 16:52:07','testfor post'),(3,'test for document 25',NULL,'2','10','2','2018-01-04 10:59:12','testfor post'),(4,'teamwork',NULL,'2','19','6','2018-01-04 10:59:20','test subject');

/*Table structure for table `kpusers` */

DROP TABLE IF EXISTS `kpusers`;

CREATE TABLE `kpusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `mobilenumber` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `reportto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `kpusers` */

insert  into `kpusers`(`id`,`created_time`,`department`,`designation`,`email`,`enabled`,`firstname`,`lastname`,`mobilenumber`,`password`,`updated_time`,`username`,`reportto`) values (1,'2017-12-14 15:39:25','1','1','leelakrishnacce@gmail.com','','leela','krishna','9293139394','admin','2017-12-26 13:24:15','admin','0'),(2,'2017-12-14 15:39:25','1','1','leelakrishnacce@gmail.com','','admin','admin','9293139394','admin2','2017-12-26 13:23:45','admin2','1'),(4,'2017-12-14 16:45:13','4','9','rjrv.143@gmail.com','','raju','bandi','8555863691','123456','2018-01-04 12:05:44','rajubandi','2'),(5,'2017-12-26 11:16:04',NULL,NULL,'leelakrishnacce@gmail.com',NULL,'leela','krishna','9293139394','123456','2018-01-04 12:03:51','leelakrishnap','2'),(6,'2017-12-26 11:23:40','4','7','leelakrishnacce@gmail.com','','leela','krishna','8636416614','stfc12012','2017-12-26 11:23:40','pasupuleti','2'),(7,'2017-12-26 11:25:24','3','7','leelakrishnacce@gmail.com','','leela','krishna','9293139394','123456','2017-12-26 11:25:24','leela1','2'),(8,'2017-12-26 11:27:44','3','7','leelakrishnacce@gmail.com','','raju','raju','9293139394','raju','2017-12-26 11:27:44','rajubandi','2'),(9,'2017-12-26 11:31:15','2','7','leelakrishnacce@gmail.com','','leela','bandi','9293139394','123456','2017-12-26 11:31:15','administrator','2'),(10,'2017-12-26 11:35:42','4','8','leelakrishnacce@gmail.com','','admin1','bandi','8639416614','123456','2017-12-26 11:35:42','sai kumari','2'),(11,'2017-12-26 14:39:29','3','7','leelakrishnacce@gmail.com','','admin1','krishna','9293139394','12345','2017-12-26 14:39:29','administrator','2'),(12,'2017-12-28 10:52:36',NULL,NULL,'leelakrishnacce@gmail.com',NULL,'leelakrishna','pasupuleti','9293139394','admin3','2018-01-04 11:56:08','admin3','2'),(13,'2018-01-03 14:43:04','3','2','kotaiahandraju@gmail.com','','kotaiah','andraju','9293139394','kotaiah','2018-01-03 14:43:04','kotaiah','2');

/*Table structure for table `kpuserslogs` */

DROP TABLE IF EXISTS `kpuserslogs`;

CREATE TABLE `kpuserslogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logintime` datetime DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `sessionname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=329 DEFAULT CHARSET=latin1;

/*Data for the table `kpuserslogs` */

insert  into `kpuserslogs`(`id`,`logintime`,`userid`,`sessionname`) values (6,'2017-12-23 16:19:50','1','login'),(7,'2017-12-23 16:20:00','1','logout'),(8,'2017-12-23 16:32:07','2','login'),(9,'2017-12-23 16:56:32','3','login'),(10,'2017-12-23 16:56:55','3','logout'),(11,'2017-12-23 16:58:13','2','login'),(12,'2017-12-23 16:58:20','2','logout'),(13,'2017-12-23 17:01:00','1','login'),(14,'2017-12-23 17:01:08','2','login'),(15,'2017-12-23 17:01:27','2','logout'),(16,'2017-12-23 17:04:22','3','login'),(17,'2017-12-23 17:04:57','3','logout'),(18,'2017-12-23 17:10:24','2','login'),(19,'2017-12-23 17:24:58','2','logout'),(20,'2017-12-23 17:31:18','2','login'),(21,'2017-12-23 17:31:27','2','logout'),(22,'2017-12-23 17:56:25','2','login'),(23,'2017-12-26 11:15:13','2','login'),(24,'2017-12-26 11:22:24','2','login'),(25,'2017-12-26 11:27:05','2','login'),(26,'2017-12-26 11:29:48','2','login'),(27,'2017-12-26 11:34:51','2','login'),(28,'2017-12-26 13:04:11','2','login'),(29,'2017-12-26 13:09:03','2','login'),(30,'2017-12-26 13:32:37','2','login'),(31,'2017-12-26 14:22:27','2','login'),(32,'2017-12-26 14:39:04','2','login'),(33,'2017-12-26 14:49:30','2','login'),(34,'2017-12-26 14:51:18','2','login'),(35,'2017-12-26 16:11:06','2','login'),(36,'2017-12-26 16:17:31','2','login'),(37,'2017-12-26 16:35:50','2','login'),(38,'2017-12-26 16:41:27','2','login'),(39,'2017-12-26 16:42:27','2','login'),(40,'2017-12-26 16:47:25','2','login'),(41,'2017-12-26 16:57:39','2','login'),(42,'2017-12-26 16:59:30','2','login'),(43,'2017-12-26 17:01:55','2','login'),(44,'2017-12-26 17:04:04','2','login'),(45,'2017-12-26 17:05:51','2','login'),(46,'2017-12-26 17:11:43','2','login'),(47,'2017-12-26 17:28:59','2','login'),(48,'2017-12-26 17:30:16','2','login'),(49,'2017-12-26 17:30:59','2','login'),(50,'2017-12-26 17:39:33','2','login'),(51,'2017-12-27 10:49:48','2','login'),(52,'2017-12-27 10:58:58','2','login'),(53,'2017-12-27 11:03:52','2','login'),(54,'2017-12-27 11:10:17','2','login'),(55,'2017-12-27 11:16:01','2','login'),(56,'2017-12-27 11:24:27','2','login'),(57,'2017-12-27 11:25:09','2','login'),(58,'2017-12-27 11:35:20','2','login'),(59,'2017-12-27 11:40:35','2','login'),(60,'2017-12-27 11:43:42','2','login'),(61,'2017-12-27 12:58:20','2','login'),(62,'2017-12-27 12:59:18','2','login'),(63,'2017-12-27 13:00:16','2','login'),(64,'2017-12-27 13:11:10','2','login'),(65,'2017-12-27 13:17:16','2','login'),(66,'2017-12-27 13:19:58','2','login'),(67,'2017-12-27 13:21:51','2','login'),(68,'2017-12-27 13:23:05','2','login'),(69,'2017-12-27 13:27:23','2','login'),(70,'2017-12-27 13:30:31','2','login'),(71,'2017-12-27 13:32:36','2','login'),(72,'2017-12-27 13:48:37','2','login'),(73,'2017-12-27 13:50:07','2','login'),(74,'2017-12-27 14:03:28','2','login'),(75,'2017-12-27 14:06:30','2','login'),(76,'2017-12-27 14:10:50','2','login'),(77,'2017-12-27 14:11:56','2','login'),(78,'2017-12-27 14:13:53','2','login'),(79,'2017-12-27 14:14:39','2','login'),(80,'2017-12-27 14:40:07','2','login'),(81,'2017-12-27 14:42:14','2','login'),(82,'2017-12-27 14:43:19','2','login'),(83,'2017-12-27 14:44:45','2','login'),(84,'2017-12-27 14:50:17','2','login'),(85,'2017-12-27 14:51:17','2','login'),(86,'2017-12-27 14:57:16','2','login'),(87,'2017-12-27 15:09:19','2','login'),(88,'2017-12-27 15:11:38','2','login'),(89,'2017-12-27 15:19:56','2','login'),(90,'2017-12-27 15:21:23','2','login'),(91,'2017-12-27 15:23:09','2','login'),(92,'2017-12-27 15:47:05','2','login'),(93,'2017-12-27 15:52:58','2','login'),(94,'2017-12-27 17:22:44','2','login'),(95,'2017-12-27 17:28:10','2','login'),(96,'2017-12-27 17:34:48','2','login'),(97,'2017-12-27 17:36:02','2','login'),(98,'2017-12-27 17:38:53','2','login'),(99,'2017-12-27 17:41:34','2','login'),(100,'2017-12-27 17:46:44','2','login'),(101,'2017-12-28 10:47:54','2','login'),(102,'2017-12-28 11:16:03','2','login'),(103,'2017-12-28 11:19:48','2','login'),(104,'2017-12-28 11:27:15','2','login'),(105,'2017-12-28 11:31:16','2','login'),(106,'2017-12-28 11:40:08','2','login'),(107,'2017-12-28 11:43:35','2','login'),(108,'2017-12-28 11:48:27','1','login'),(109,'2017-12-28 11:52:21','2','login'),(110,'2017-12-28 12:18:35','2','login'),(111,'2017-12-28 12:20:38','2','login'),(112,'2017-12-28 12:25:19','2','login'),(113,'2017-12-28 12:40:34','2','login'),(114,'2017-12-28 13:03:59','2','login'),(115,'2017-12-28 13:05:13','2','login'),(116,'2017-12-28 13:06:16','2','login'),(117,'2017-12-28 13:41:02','1','login'),(118,'2017-12-28 13:41:06','1','logout'),(119,'2017-12-28 13:51:32','2','login'),(120,'2017-12-28 14:23:05','2','login'),(121,'2017-12-28 14:45:28','2','logout'),(122,'2017-12-28 14:57:05','2','login'),(123,'2017-12-28 16:35:32','2','login'),(124,'2017-12-28 16:41:59','2','login'),(125,'2017-12-28 16:43:46','2','login'),(126,'2017-12-28 16:57:07','2','login'),(127,'2017-12-28 17:05:45','2','login'),(128,'2017-12-28 17:07:03','2','login'),(129,'2017-12-28 17:10:13','2','login'),(130,'2017-12-28 17:20:45','2','login'),(131,'2017-12-28 17:36:26','2','login'),(132,'2017-12-28 17:36:58','2','login'),(133,'2017-12-28 17:39:22','2','login'),(134,'2017-12-29 11:22:13','2','login'),(135,'2017-12-29 11:32:22','2','login'),(136,'2017-12-29 12:09:49','2','login'),(137,'2017-12-29 12:16:25','2','login'),(138,'2017-12-29 12:22:22','2','login'),(139,'2017-12-29 12:42:21','7','login'),(140,'2017-12-29 12:42:43','7','logout'),(141,'2017-12-29 12:43:10','8','login'),(142,'2017-12-29 12:43:48','8','logout'),(143,'2017-12-29 12:44:03','5','login'),(144,'2017-12-29 12:44:22','5','logout'),(145,'2017-12-29 12:44:35','6','login'),(146,'2017-12-29 12:44:53','6','logout'),(147,'2017-12-29 12:45:09','8','login'),(148,'2017-12-29 12:46:53','8','logout'),(149,'2017-12-29 12:47:12','9','login'),(150,'2017-12-29 12:47:34','9','logout'),(151,'2017-12-29 12:47:45','10','login'),(152,'2017-12-29 12:48:09','10','logout'),(153,'2017-12-29 12:48:51','11','login'),(154,'2017-12-29 12:49:16','11','logout'),(155,'2017-12-29 12:49:29','12','login'),(156,'2017-12-29 12:54:44','12','logout'),(157,'2017-12-29 12:54:52','2','login'),(158,'2017-12-29 13:22:41','2','login'),(159,'2017-12-29 14:13:08','2','login'),(160,'2017-12-29 14:31:46','2','login'),(161,'2017-12-29 14:45:55','2','login'),(162,'2017-12-29 14:46:02','2','logout'),(163,'2017-12-29 14:46:08','1','login'),(164,'2017-12-29 14:47:53','1','logout'),(165,'2017-12-29 14:53:32','2','login'),(166,'2017-12-29 14:59:24','2','login'),(167,'2017-12-29 15:19:12','2','login'),(168,'2017-12-29 16:06:11','1','login'),(169,'2017-12-29 16:06:18','1','logout'),(170,'2017-12-29 16:17:17','2','login'),(171,'2017-12-29 16:35:41','2','login'),(172,'2017-12-29 17:20:09','2','login'),(173,'2017-12-29 17:28:43','2','login'),(174,'2017-12-29 17:41:31','2','login'),(175,'2017-12-29 17:45:01','2','login'),(176,'2017-12-29 17:49:29','2','login'),(177,'2017-12-29 17:55:07','2','login'),(178,'2017-12-29 17:57:32','2','login'),(179,'2017-12-29 17:58:13','2','logout'),(180,'2017-12-29 18:03:30','2','login'),(181,'2017-12-29 18:03:34','2','logout'),(182,'2017-12-29 18:03:43','2','login'),(183,'2017-12-29 18:03:48','2','logout'),(184,'2017-12-29 18:04:13','2','login'),(185,'2017-12-29 18:07:03','2','logout'),(186,'2017-12-29 18:07:12','2','login'),(187,'2017-12-29 18:13:20','2','login'),(188,'2017-12-29 18:15:37','2','login'),(189,'2017-12-29 18:15:46','2','logout'),(190,'2017-12-29 18:15:55','2','login'),(191,'2017-12-29 18:17:46','2','logout'),(192,'2017-12-29 18:18:24','2','login'),(193,'2017-12-30 10:31:33','2','login'),(194,'2017-12-30 10:31:48','2','logout'),(195,'2017-12-30 10:31:57','2','login'),(196,'2017-12-30 10:32:06','2','logout'),(197,'2017-12-30 10:32:13','2','login'),(198,'2017-12-30 10:33:00','2','login'),(199,'2017-12-30 10:43:13','2','login'),(200,'2017-12-30 10:48:17','2','login'),(201,'2017-12-30 10:50:36','2','login'),(202,'2017-12-30 10:57:37','2','login'),(203,'2017-12-30 11:10:40','2','login'),(204,'2017-12-30 11:11:15','2','login'),(205,'2017-12-30 11:15:08','2','login'),(206,'2017-12-30 11:19:38','2','login'),(207,'2017-12-30 11:26:42','2','login'),(208,'2017-12-30 11:27:50','2','login'),(209,'2017-12-30 11:31:40','2','login'),(210,'2017-12-30 11:33:25','2','login'),(211,'2017-12-30 11:36:59','2','login'),(212,'2017-12-30 11:41:29','2','login'),(213,'2017-12-30 12:03:49','2','login'),(214,'2017-12-30 12:10:51','2','login'),(215,'2017-12-30 12:22:59','2','login'),(216,'2017-12-30 12:29:46','2','logout'),(217,'2017-12-30 12:29:51','1','login'),(218,'2017-12-30 12:30:22','1','logout'),(219,'2017-12-30 12:30:30','2','login'),(220,'2017-12-30 12:34:13','2','login'),(221,'2017-12-30 12:43:50','2','logout'),(222,'2017-12-30 12:44:03','2','login'),(223,'2017-12-30 13:00:20','2','logout'),(224,'2017-12-30 13:00:26','1','login'),(225,'2017-12-30 13:13:09','2','login'),(226,'2017-12-30 13:14:55','2','login'),(227,'2017-12-30 13:29:30','2','logout'),(228,'2017-12-30 13:30:01','1','login'),(229,'2017-12-30 13:31:48','1','logout'),(230,'2017-12-30 13:32:08','2','login'),(231,'2017-12-30 13:39:45','2','logout'),(232,'2018-01-02 11:12:16','2','login'),(233,'2018-01-02 11:14:03','2','login'),(234,'2018-01-02 11:15:15','2','login'),(235,'2018-01-02 11:23:53','2','login'),(236,'2018-01-02 11:28:25','2','login'),(237,'2018-01-02 12:00:21','2','login'),(238,'2018-01-02 12:02:41','2','login'),(239,'2018-01-02 12:04:53','2','login'),(240,'2018-01-02 12:07:37','2','login'),(241,'2018-01-02 12:08:15','2','login'),(242,'2018-01-02 12:11:12','2','login'),(243,'2018-01-02 12:21:55','2','login'),(244,'2018-01-02 12:25:04','2','login'),(245,'2018-01-02 12:28:15','2','login'),(246,'2018-01-02 12:35:15','2','login'),(247,'2018-01-02 12:38:19','2','login'),(248,'2018-01-02 12:39:32','2','login'),(249,'2018-01-02 12:41:52','2','login'),(250,'2018-01-02 12:45:04','2','login'),(251,'2018-01-02 12:46:01','2','login'),(252,'2018-01-02 12:49:12','2','login'),(253,'2018-01-02 12:50:15','2','login'),(254,'2018-01-02 12:51:07','2','logout'),(255,'2018-01-02 12:51:13','1','login'),(256,'2018-01-02 12:54:29','1','login'),(257,'2018-01-02 13:00:01','2','login'),(258,'2018-01-02 14:30:41','2','login'),(259,'2018-01-02 14:32:03','2','login'),(260,'2018-01-02 14:34:28','2','login'),(261,'2018-01-02 14:39:07','2','login'),(262,'2018-01-02 14:55:34','2','login'),(263,'2018-01-02 15:37:11','2','login'),(264,'2018-01-02 16:00:50','2','login'),(265,'2018-01-02 16:04:58','2','login'),(266,'2018-01-02 16:08:32','2','login'),(267,'2018-01-02 16:12:11','2','login'),(268,'2018-01-02 16:50:16','2','login'),(269,'2018-01-02 18:02:59','1','login'),(270,'2018-01-02 18:03:04','1','logout'),(271,'2018-01-02 18:03:12','2','login'),(272,'2018-01-03 11:07:52','2','login'),(273,'2018-01-03 11:34:21','2','login'),(274,'2018-01-03 12:26:52','2','login'),(275,'2018-01-03 12:29:22','2','login'),(276,'2018-01-03 12:30:54','2','login'),(277,'2018-01-03 12:37:20','2','login'),(278,'2018-01-03 12:47:51','2','login'),(279,'2018-01-03 12:50:29','2','login'),(280,'2018-01-03 12:52:08','2','login'),(281,'2018-01-03 12:56:19','2','login'),(282,'2018-01-03 12:57:41','2','login'),(283,'2018-01-03 13:00:30','2','login'),(284,'2018-01-03 13:01:41','2','login'),(285,'2018-01-03 13:03:51','2','login'),(286,'2018-01-03 13:06:25','2','login'),(287,'2018-01-03 13:11:28','2','login'),(288,'2018-01-03 13:13:47','2','login'),(289,'2018-01-03 13:15:11','2','login'),(290,'2018-01-03 13:15:45','2','login'),(291,'2018-01-03 13:20:48','2','login'),(292,'2018-01-03 13:23:21','2','login'),(293,'2018-01-03 13:25:55','2','login'),(294,'2018-01-03 13:38:46','2','login'),(295,'2018-01-03 14:41:36','2','login'),(296,'2018-01-03 14:44:51','2','login'),(297,'2018-01-03 15:02:44','2','login'),(298,'2018-01-03 15:06:39','2','login'),(299,'2018-01-03 15:11:06','2','login'),(300,'2018-01-03 15:14:48','2','login'),(301,'2018-01-03 15:51:44','2','login'),(302,'2018-01-03 15:52:27','2','logout'),(303,'2018-01-03 15:52:32','1','login'),(304,'2018-01-03 15:53:01','1','logout'),(305,'2018-01-03 16:02:40','2','login'),(306,'2018-01-03 16:42:17','2','login'),(307,'2018-01-03 17:55:21','2','login'),(308,'2018-01-04 10:59:06','2','login'),(309,'2018-01-04 11:39:48','2','login'),(310,'2018-01-04 11:44:44','2','logout'),(311,'2018-01-04 11:50:14','2','login'),(312,'2018-01-04 11:55:40','2','logout'),(313,'2018-01-04 11:55:48','12','login'),(314,'2018-01-04 11:59:02','12','logout'),(315,'2018-01-04 11:59:11','2','login'),(316,'2018-01-04 11:59:51','2','logout'),(317,'2018-01-04 12:01:27','2','login'),(318,'2018-01-04 12:03:06','2','logout'),(319,'2018-01-04 12:03:17','5','login'),(320,'2018-01-04 12:05:11','5','logout'),(321,'2018-01-04 12:05:19','2','login'),(322,'2018-01-04 12:59:50','2','login'),(323,'2018-01-04 13:01:58','2','login'),(324,'2018-01-04 16:40:31','2','login'),(325,'2018-01-04 16:41:24','2','login'),(326,'2018-01-04 16:53:15','2','login'),(327,'2018-01-04 16:55:39','2','login'),(328,'2018-01-04 16:56:22','2','login');

/*Table structure for table `priority` */

DROP TABLE IF EXISTS `priority`;

CREATE TABLE `priority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `priority` */

insert  into `priority`(`id`,`priority`) values (1,'Low'),(2,'Normal'),(3,'High'),(4,'Immediately');

/*Table structure for table `report_issue` */

DROP TABLE IF EXISTS `report_issue`;

CREATE TABLE `report_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assignto` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  `severity` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `uploadfile` varchar(255) DEFAULT NULL,
  `assignby` varchar(255) DEFAULT NULL,
  `kstatus` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `report_issue` */

insert  into `report_issue`(`id`,`assignto`,`category`,`created_time`,`description`,`priority`,`severity`,`subject`,`updated_time`,`uploadfile`,`assignby`,`kstatus`) values (2,'2','2','2017-10-15 12:23:20','okay','3','2','test55','2017-12-22 14:43:35','reportDocuments/VVS-logo.png','3','4'),(5,'2','4','2017-12-15 12:23:20','check details','2','3','testtoraju1','2017-12-27 11:00:23','reportDocuments/projectasso_2.DOC','4','1'),(7,'4','6','2017-11-15 12:23:20','check test3','2','2','rajubandi255','2017-12-22 15:19:29','reportDocuments/Penguins.jpg','4','4'),(9,'2','6','2017-08-15 12:23:20','test for document 25','2','2','testt','2017-12-21 16:45:19','reportDocuments/catalina.2017-12-07.log','3','4'),(10,'2','2','2017-06-15 12:23:20','test for document 25','1','2','testfor post','2017-12-29 16:46:39','reportDocuments/catalina.2017-12-07.log','3','2'),(11,'12','4','2017-12-22 15:16:56','to work test to develop application','3','2','subject test','2017-12-23 11:45:24','reportDocuments/mahesh.pdf','3','2'),(12,'9','1','2017-12-22 15:18:44','from raju checking ','1','1','subject test2','2017-12-28 14:23:34','reportDocuments/photo1 (1) (1).jpg','2','4'),(13,'8','4','2017-12-23 13:47:47','chooses itmes','3','2','seferw','2017-12-23 13:47:47','reportDocuments/sites.xml','2','2'),(15,'2','5','2017-12-26 13:06:18','test','3','1','testrwrw','2017-12-29 17:31:28','reportDocuments/125.txt','3','4'),(16,'7','2','2017-12-26 13:09:17','wedwdw','2','2','sersfserew','2017-12-26 13:09:17','reportDocuments/125.txt','3','2'),(19,'2','4','2017-12-26 14:23:28','teamwork','2','3','test subject','2017-12-26 16:18:34','','3','6'),(20,'1','3','2018-01-03 14:49:40','test for admin1','2','2','test to admin','2018-01-03 14:49:40',NULL,'2','2');

/*Table structure for table `severity` */

DROP TABLE IF EXISTS `severity`;

CREATE TABLE `severity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `severity` varchar(255) DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `severity` */

insert  into `severity`(`id`,`severity`,`colour`) values (1,'Minor','blue'),(2,'Major','orange'),(3,'Critical','red');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
