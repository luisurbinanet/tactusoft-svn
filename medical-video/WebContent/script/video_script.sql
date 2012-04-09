CREATE DATABASE  IF NOT EXISTS `medical_video_db` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `medical_video_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: medical_video_db
-- ------------------------------------------------------
-- Server version	5.5.20

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
-- Table structure for table `vid_answer`
--

DROP TABLE IF EXISTS `vid_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_answer` (
  `id` decimal(19,0) NOT NULL,
  `name` text COLLATE latin1_spanish_ci NOT NULL,
  `id_question` decimal(19,0) NOT NULL,
  `next_question` decimal(19,0) DEFAULT NULL,
  `enter_key` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vid_answer_1` (`id_question`),
  CONSTRAINT `fk_vid_answer_1` FOREIGN KEY (`id_question`) REFERENCES `vid_question` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_answer`
--

LOCK TABLES `vid_answer` WRITE;
/*!40000 ALTER TABLE `vid_answer` DISABLE KEYS */;
INSERT INTO `vid_answer` VALUES (1,'R1',2,-1,'A'),(2,'R2',2,-1,'B'),(3,'r5',3,-1,'C'),(4,'r6',3,-1,'D');
/*!40000 ALTER TABLE `vid_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_package_topic`
--

DROP TABLE IF EXISTS `vid_package_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_package_topic` (
  `id` decimal(19,0) NOT NULL,
  `id_package` decimal(19,0) NOT NULL,
  `id_topic` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vid_package_topic_1` (`id_topic`),
  KEY `fk_vid_package_topic_2` (`id_package`),
  CONSTRAINT `fk_vid_package_topic_1` FOREIGN KEY (`id_topic`) REFERENCES `vid_topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vid_package_topic_2` FOREIGN KEY (`id_package`) REFERENCES `vid_package` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_package_topic`
--

LOCK TABLES `vid_package_topic` WRITE;
/*!40000 ALTER TABLE `vid_package_topic` DISABLE KEYS */;
INSERT INTO `vid_package_topic` VALUES (1,1,1),(2,1,2),(3,2,1);
/*!40000 ALTER TABLE `vid_package_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_topic`
--

DROP TABLE IF EXISTS `vid_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_topic` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `gender` varchar(1) COLLATE latin1_spanish_ci NOT NULL,
  `state` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_topic`
--

LOCK TABLES `vid_topic` WRITE;
/*!40000 ALTER TABLE `vid_topic` DISABLE KEYS */;
INSERT INTO `vid_topic` VALUES (1,'LACTANCIA','topic_vid1.jpeg','M',1),(2,'PRUEBA','topic_vid2.jpeg','W',1);
/*!40000 ALTER TABLE `vid_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMINISTRADOR',1),(2,'USUARIO',1);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` decimal(19,0) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(1000) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_role` decimal(19,0) NOT NULL,
  `state` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_kpi_user_1` (`id_role`),
  CONSTRAINT `fk_user_1` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'carlossarmientor@gmail.com','202cb962ac59075b964b07152d234b70','CARLOS','ARTURO','SARMIENTO','carlossarmientor@gmail.com',NULL,2,1),(2,'gsolorzano@gmail.com','202cb962ac59075b964b07152d234b70','Gerardo','','Solorzano','gsolorzano@gmail.com','123',1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_user_topic`
--

DROP TABLE IF EXISTS `vid_user_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_user_topic` (
  `id` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) NOT NULL,
  `id_topic` decimal(19,0) NOT NULL,
  `init_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `transactions_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vid_user_package_1` (`id_topic`),
  KEY `fk_vid_user_topic_2` (`id_user`),
  CONSTRAINT `fk_vid_user_topic_1` FOREIGN KEY (`id_topic`) REFERENCES `vid_topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vid_user_topic_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_user_topic`
--

LOCK TABLES `vid_user_topic` WRITE;
/*!40000 ALTER TABLE `vid_user_topic` DISABLE KEYS */;
INSERT INTO `vid_user_topic` VALUES (1,1,2,'2012-04-07 00:00:00','2013-04-07 00:00:00',1);
/*!40000 ALTER TABLE `vid_user_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_question`
--

DROP TABLE IF EXISTS `vid_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_question` (
  `id` decimal(19,0) NOT NULL,
  `name` text COLLATE latin1_spanish_ci NOT NULL,
  `id_topic` decimal(19,0) NOT NULL,
  `question_type` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `audio_type` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `audio` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `video_type` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `video` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `positive` decimal(19,0) DEFAULT NULL,
  `negative` decimal(19,0) DEFAULT NULL,
  `order_question` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vid_question_1` (`id_topic`),
  CONSTRAINT `fk_vid_question_1` FOREIGN KEY (`id_topic`) REFERENCES `vid_topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_question`
--

LOCK TABLES `vid_question` WRITE;
/*!40000 ALTER TABLE `vid_question` DISABLE KEYS */;
INSERT INTO `vid_question` VALUES (1,'Prueba',1,'ASSERTIVE','flash','audio1.mp3','quicktime','video1.mp4',-1,-1,1),(2,'Mensaje',1,'UNIQUE',NULL,NULL,NULL,NULL,-1,-1,2),(3,'mensaje',1,'UNIQUE',NULL,NULL,NULL,NULL,-1,-1,3),(4,'Prueba',1,'ASSERTIVE',NULL,NULL,'quicktime','video4.mp4',-1,-1,4);
/*!40000 ALTER TABLE `vid_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_user_package`
--

DROP TABLE IF EXISTS `vid_user_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_user_package` (
  `id` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) NOT NULL,
  `id_package` decimal(19,0) NOT NULL,
  `init_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vid_user_package_1` (`id_user`),
  KEY `fk_vid_user_package_2` (`id_package`),
  CONSTRAINT `fk_vid_user_package_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vid_user_package_2` FOREIGN KEY (`id_package`) REFERENCES `vid_package` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_user_package`
--

LOCK TABLES `vid_user_package` WRITE;
/*!40000 ALTER TABLE `vid_user_package` DISABLE KEYS */;
INSERT INTO `vid_user_package` VALUES (1,1,1,'2012-04-07 00:00:00','2013-04-07 00:00:00');
/*!40000 ALTER TABLE `vid_user_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid_package`
--

DROP TABLE IF EXISTS `vid_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vid_package` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `state` int(5) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid_package`
--

LOCK TABLES `vid_package` WRITE;
/*!40000 ALTER TABLE `vid_package` DISABLE KEYS */;
INSERT INTO `vid_package` VALUES (1,'Paquete 1',1),(2,'Paquete 2',1);
/*!40000 ALTER TABLE `vid_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameter`
--

DROP TABLE IF EXISTS `parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameter` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `value_text` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `value_number` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameter`
--

LOCK TABLES `parameter` WRITE;
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` VALUES (1,'URL_IMAGES','http://localhost:8080/images/',NULL),(2,'DIRECTORY_IMAGES','C:\\affinity\\medical\\',NULL);
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-09  7:09:09
