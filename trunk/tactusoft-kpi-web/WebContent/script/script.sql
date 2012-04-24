CREATE DATABASE  IF NOT EXISTS `kpi_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kpi_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: kpi
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
-- Table structure for table `kpi_data`
--

DROP TABLE IF EXISTS `kpi_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_data` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `desired_direction` varchar(5) NOT NULL,
  `plan_attainment` decimal(19,3) NOT NULL,
  `daily` tinyint(4) DEFAULT NULL,
  `weekly` tinyint(4) DEFAULT NULL,
  `monthly` tinyint(4) DEFAULT NULL,
  `yearly` tinyint(4) DEFAULT NULL,
  `calculation_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_data`
--

LOCK TABLES `kpi_data` WRITE;
/*!40000 ALTER TABLE `kpi_data` DISABLE KEYS */;
INSERT INTO `kpi_data` VALUES (1,'Cumplimiento Programa HH','%','UP',0.800,1,1,0,0,1),(2,'Imprevistos','%','UP',0.200,1,1,0,0,2),(3,'Demoras','Hrs','DOWN',23.000,1,1,0,0,3);
/*!40000 ALTER TABLE `kpi_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_header_delay`
--

DROP TABLE IF EXISTS `kpi_header_delay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_header_delay` (
  `id` decimal(19,0) NOT NULL,
  `id_header` decimal(19,0) NOT NULL,
  `id_delay` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_config_1` (`id_header`),
  KEY `fk_kpi_config_2` (`id_delay`),
  CONSTRAINT `fk_kpi_config_1` FOREIGN KEY (`id_header`) REFERENCES `kpi_header` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kpi_config_2` FOREIGN KEY (`id_delay`) REFERENCES `kpi_delay` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_header_delay`
--

LOCK TABLES `kpi_header_delay` WRITE;
/*!40000 ALTER TABLE `kpi_header_delay` DISABLE KEYS */;
INSERT INTO `kpi_header_delay` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,2,1),(14,2,6),(15,2,12),(16,2,2),(17,2,3),(18,2,4),(19,2,5),(20,2,7),(21,2,8),(22,1,7),(23,1,8);
/*!40000 ALTER TABLE `kpi_header_delay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_user`
--

DROP TABLE IF EXISTS `kpi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_user` (
  `id` decimal(19,0) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_company` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_user_1` (`id_company`),
  CONSTRAINT `fk_kpi_user_1` FOREIGN KEY (`id_company`) REFERENCES `kpi_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_user`
--

LOCK TABLES `kpi_user` WRITE;
/*!40000 ALTER TABLE `kpi_user` DISABLE KEYS */;
INSERT INTO `kpi_user` VALUES (1,'carlossarmientor@gmail.com','202cb962ac59075b964b07152d234b70','CARLOS','ARTURO','SARMIENTO',NULL,1),(2,'barrientose@gmail.com','202cb962ac59075b964b07152d234b70','EDUARDO',NULL,'BARRIENTOS',NULL,1);
/*!40000 ALTER TABLE `kpi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_daily`
--

DROP TABLE IF EXISTS `kpi_daily`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_daily` (
  `id` decimal(19,0) NOT NULL,
  `current_day` datetime NOT NULL,
  `description` varchar(255) DEFAULT '0',
  `scheduled_orders` int(11) DEFAULT '0',
  `finished_orders` int(11) DEFAULT '0',
  `failures_orders` int(11) DEFAULT '0',
  `id_week` decimal(19,0) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_daily_week` (`id_week`),
  CONSTRAINT `fk_daily_week` FOREIGN KEY (`id_week`) REFERENCES `kpi_week` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_daily`
--

LOCK TABLES `kpi_daily` WRITE;
/*!40000 ALTER TABLE `kpi_daily` DISABLE KEYS */;
INSERT INTO `kpi_daily` VALUES (8,'2012-02-12 00:00:00',NULL,7,4,3,2,1),(9,'2012-02-13 00:00:00',NULL,10,7,5,2,1),(10,'2012-02-14 00:00:00',NULL,9,4,3,2,1),(11,'2012-02-15 00:00:00',NULL,10,8,7,2,1),(12,'2012-02-16 00:00:00',NULL,10,6,3,2,1),(13,'2012-02-17 00:00:00',NULL,10,9,6,2,0),(14,'2012-02-18 00:00:00',NULL,8,6,2,2,1),(15,'2012-02-01 00:00:00',NULL,5,3,2,1,1),(16,'2012-02-02 00:00:00',NULL,6,0,0,1,1),(17,'2012-02-03 00:00:00',NULL,8,0,0,1,1),(18,'2012-02-04 00:00:00',NULL,8,0,0,1,1),(19,'2012-02-05 00:00:00',NULL,9,0,0,1,1),(20,'2012-02-06 00:00:00',NULL,6,0,0,1,1),(21,'2012-02-07 00:00:00',NULL,8,0,0,1,1),(22,'2012-04-29 00:00:00',NULL,10,0,0,5,1);
/*!40000 ALTER TABLE `kpi_daily` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_header_data`
--

DROP TABLE IF EXISTS `kpi_header_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_header_data` (
  `id` decimal(19,0) NOT NULL,
  `id_header` decimal(19,0) NOT NULL,
  `id_data` decimal(19,0) NOT NULL,
  `korder` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_header_data_1` (`id_header`),
  KEY `fk_kpi_header_data_2` (`id_data`),
  CONSTRAINT `fk_kpi_header_data_1` FOREIGN KEY (`id_header`) REFERENCES `kpi_header` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kpi_header_data_2` FOREIGN KEY (`id_data`) REFERENCES `kpi_data` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_header_data`
--

LOCK TABLES `kpi_header_data` WRITE;
/*!40000 ALTER TABLE `kpi_header_data` DISABLE KEYS */;
INSERT INTO `kpi_header_data` VALUES (1,1,1,1),(2,1,2,2),(3,1,3,3);
/*!40000 ALTER TABLE `kpi_header_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_header`
--

DROP TABLE IF EXISTS `kpi_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_header` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_company` decimal(19,0) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_kpi_header_1` (`id_company`),
  CONSTRAINT `fk_kpi_header_1` FOREIGN KEY (`id_company`) REFERENCES `kpi_company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_header`
--

LOCK TABLES `kpi_header` WRITE;
/*!40000 ALTER TABLE `kpi_header` DISABLE KEYS */;
INSERT INTO `kpi_header` VALUES (1,'Mantención Mina','Mantención Mina',1,1),(2,'MANTENIMIENTO','MANTENIMIENTO',1,1),(3,'Prueba','Prueba',1,1),(4,'Prueba 2','Prueba 2',1,1);
/*!40000 ALTER TABLE `kpi_header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `kpi_last_day_week`
--

DROP TABLE IF EXISTS `kpi_last_day_week`;
/*!50001 DROP VIEW IF EXISTS `kpi_last_day_week`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `kpi_last_day_week` (
  `id` decimal(19,0),
  `current_day` datetime,
  `description` varchar(255),
  `scheduled_orders` int(11),
  `finished_orders` int(11),
  `failures_orders` int(11),
  `id_week` decimal(19,0),
  `state` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kpi_role`
--

DROP TABLE IF EXISTS `kpi_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_role` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_role`
--

LOCK TABLES `kpi_role` WRITE;
/*!40000 ALTER TABLE `kpi_role` DISABLE KEYS */;
INSERT INTO `kpi_role` VALUES (1,'SUPER_ADMIN',1),(2,'ADMIN',1);
/*!40000 ALTER TABLE `kpi_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_user_role`
--

DROP TABLE IF EXISTS `kpi_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_user_role` (
  `id` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) NOT NULL,
  `id_role` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_user_role_1` (`id_user`),
  KEY `fk_kpi_user_role_2` (`id_role`),
  CONSTRAINT `fk_kpi_user_role_1` FOREIGN KEY (`id_user`) REFERENCES `kpi_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kpi_user_role_2` FOREIGN KEY (`id_role`) REFERENCES `kpi_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_user_role`
--

LOCK TABLES `kpi_user_role` WRITE;
/*!40000 ALTER TABLE `kpi_user_role` DISABLE KEYS */;
INSERT INTO `kpi_user_role` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `kpi_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `kpi_daily_sum_hours`
--

DROP TABLE IF EXISTS `kpi_daily_sum_hours`;
/*!50001 DROP VIEW IF EXISTS `kpi_daily_sum_hours`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `kpi_daily_sum_hours` (
  `id_daily` decimal(19,0),
  `id_delay` decimal(19,0),
  `name_daily` varchar(255),
  `num_hours` decimal(41,2)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kpi_week`
--

DROP TABLE IF EXISTS `kpi_week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_week` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `assigned_orders` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '40',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_week`
--

LOCK TABLES `kpi_week` WRITE;
/*!40000 ALTER TABLE `kpi_week` DISABLE KEYS */;
INSERT INTO `kpi_week` VALUES (1,'SC20121','SEMANA 6 DE TRABAJO','2012-02-01 00:00:00','2012-02-07 00:00:00',7,40),(2,'SC20122','SEMANA 7 DE TRABAJO','2012-02-12 00:00:00','2012-02-18 00:00:00',10,40),(3,'SC20123',NULL,'2012-02-18 00:00:00','2012-02-24 00:00:00',20,40),(4,'SC20124',NULL,'2012-02-25 00:00:00','2012-03-02 00:00:00',10,40),(5,'18',NULL,'2012-04-29 00:00:00','2012-05-05 00:00:00',1,40),(6,'17',NULL,'2012-04-22 00:00:00','2012-04-28 00:00:00',5,40);
/*!40000 ALTER TABLE `kpi_week` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_daily_delay`
--

DROP TABLE IF EXISTS `kpi_daily_delay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_daily_delay` (
  `id` decimal(19,0) NOT NULL,
  `id_daily` decimal(19,0) NOT NULL,
  `id_delay` decimal(19,0) NOT NULL,
  `num_hours` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_daily_delay_1` (`id_delay`),
  KEY `fk_kpi_daily_delay_2` (`id_daily`),
  CONSTRAINT `fk_kpi_daily_delay_1` FOREIGN KEY (`id_delay`) REFERENCES `kpi_delay` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_kpi_daily_delay_2` FOREIGN KEY (`id_daily`) REFERENCES `kpi_daily` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_daily_delay`
--

LOCK TABLES `kpi_daily_delay` WRITE;
/*!40000 ALTER TABLE `kpi_daily_delay` DISABLE KEYS */;
INSERT INTO `kpi_daily_delay` VALUES (1,8,1,30.00),(2,8,2,0.00),(3,8,3,8.00),(4,8,4,0.00),(5,8,5,2.00),(6,8,6,24.00),(7,8,7,0.00),(8,8,8,2.00),(9,8,9,11.00),(10,8,10,0.00),(11,8,11,0.00),(12,8,12,0.00),(13,9,1,0.00),(14,9,2,0.00),(15,9,3,0.00),(16,9,4,0.00),(17,9,5,0.00),(18,9,6,26.00),(19,9,7,0.00),(20,9,8,1.00),(21,9,9,25.00),(22,9,10,0.00),(23,9,11,0.00),(24,9,12,0.00),(25,10,1,0.00),(26,10,2,0.00),(27,10,3,15.00),(28,10,4,0.00),(29,10,5,0.00),(30,10,6,9.00),(31,10,7,0.00),(32,10,8,1.00),(33,10,9,12.00),(34,10,10,0.00),(35,10,11,0.00),(36,10,12,0.00),(37,11,1,0.00),(38,11,2,0.00),(39,11,3,0.00),(40,11,4,0.00),(41,11,5,0.00),(42,11,6,0.00),(43,11,7,0.00),(44,11,8,0.00),(45,11,9,0.00),(46,11,10,0.00),(47,11,11,0.00),(48,11,12,0.00),(49,12,1,0.00),(50,12,2,0.00),(51,12,3,0.00),(52,12,4,0.00),(53,12,5,0.00),(54,12,6,0.00),(55,12,7,0.00),(56,12,8,0.00),(57,12,9,0.00),(58,12,10,0.00),(59,12,11,0.00),(60,12,12,0.00),(61,13,1,0.00),(62,13,2,0.00),(63,13,3,2.00),(64,13,4,5.00),(65,13,5,0.00),(66,13,6,0.00),(67,13,7,0.00),(68,13,8,0.00),(69,13,9,17.50),(70,13,10,0.00),(71,13,11,0.00),(72,13,12,0.00),(73,14,1,0.00),(74,14,2,4.50),(75,14,3,26.00),(76,14,4,6.00),(77,14,5,5.50),(78,14,6,6.00),(79,14,7,0.00),(80,14,8,0.00),(81,14,9,25.00),(82,14,10,0.00),(83,14,11,0.00),(84,14,12,0.00),(85,15,1,5.00),(86,15,2,0.00),(87,15,3,0.00),(88,15,4,0.00),(89,15,5,0.00),(90,15,6,0.00),(91,15,7,0.00),(92,15,8,0.00),(93,15,9,0.00),(94,15,10,0.00),(95,15,11,0.00),(96,15,12,0.00),(97,16,1,0.00),(98,16,2,0.00),(99,16,3,0.00),(100,16,4,0.00),(101,16,5,0.00),(102,16,6,0.00),(103,16,7,0.00),(104,16,8,0.00),(105,16,9,0.00),(106,16,10,0.00),(107,16,11,0.00),(108,16,12,0.00),(109,17,1,0.00),(110,17,2,0.00),(111,17,3,0.00),(112,17,4,0.00),(113,17,5,0.00),(114,17,6,0.00),(115,17,7,0.00),(116,17,8,0.00),(117,17,9,0.00),(118,17,10,0.00),(119,17,11,0.00),(120,17,12,0.00),(121,18,1,0.00),(122,18,2,0.00),(123,18,3,0.00),(124,18,4,0.00),(125,18,5,0.00),(126,18,6,0.00),(127,18,7,0.00),(128,18,8,0.00),(129,18,9,0.00),(130,18,10,0.00),(131,18,11,0.00),(132,18,12,0.00),(133,19,1,0.00),(134,19,2,0.00),(135,19,3,0.00),(136,19,4,0.00),(137,19,5,0.00),(138,19,6,0.00),(139,19,7,0.00),(140,19,8,0.00),(141,19,9,0.00),(142,19,10,0.00),(143,19,11,0.00),(144,19,12,0.00),(145,20,1,0.00),(146,20,2,0.00),(147,20,3,0.00),(148,20,4,0.00),(149,20,5,0.00),(150,20,6,0.00),(151,20,7,0.00),(152,20,8,0.00),(153,20,9,0.00),(154,20,10,0.00),(155,20,11,0.00),(156,20,12,0.00),(157,21,1,2.00),(158,21,2,0.00),(159,21,3,0.00),(160,21,4,0.00),(161,21,5,0.00),(162,21,6,0.00),(163,21,7,0.00),(164,21,8,0.00),(165,21,9,2.00),(166,21,10,4.00),(167,21,11,6.00),(168,21,12,0.00),(169,22,1,10.00),(170,22,2,0.00),(171,22,3,0.00),(172,22,4,0.00),(173,22,5,0.00),(174,22,6,20.00),(175,22,7,0.00),(176,22,8,0.00),(177,22,9,0.00),(178,22,10,0.00),(179,22,11,0.00),(180,22,12,0.00);
/*!40000 ALTER TABLE `kpi_daily_delay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_delay`
--

DROP TABLE IF EXISTS `kpi_delay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_delay` (
  `ID` decimal(19,0) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `KORDER` int(11) DEFAULT NULL,
  `STATE` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_delay`
--

LOCK TABLES `kpi_delay` WRITE;
/*!40000 ALTER TABLE `kpi_delay` DISABLE KEYS */;
INSERT INTO `kpi_delay` VALUES (1,'Seguridad','Seguridad',1,1),(2,'Entrega de Equipo','',2,1),(3,'Disponibilidad de Repuesto',NULL,3,1),(4,'Reasignación de Trabajo',NULL,4,1),(5,'Falta de Herramientas',NULL,5,1),(6,'Cambio de Alcance de Trabajo',NULL,6,1),(7,'Camión Lubricador','Camión Lubricador',7,1),(8,'Tronadura',NULL,8,1),(9,'Falta de Personal',NULL,9,1),(10,'Causas Naturales',NULL,10,1),(11,'Falta de Conocimiento',NULL,11,1),(12,'Retrabajo',NULL,12,1);
/*!40000 ALTER TABLE `kpi_delay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kpi_company`
--

DROP TABLE IF EXISTS `kpi_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kpi_company` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `legal_rep` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kpi_company`
--

LOCK TABLES `kpi_company` WRITE;
/*!40000 ALTER TABLE `kpi_company` DISABLE KEYS */;
INSERT INTO `kpi_company` VALUES (0,'NIT1','KPI','','KPI','carlossarmientor@gmail.com',1),(1,'NIT2','EMPRESA 1','123','PERSONA 1','correo@empresa1.com',1),(2,NULL,'EMPRESA 2','888','PERSONA 2','correo@empresa2.com',1),(3,NULL,'EMPRESA 3',NULL,'PERSONA 3','correo@empresa3.com',1),(4,NULL,'EMPRESA 4','12348','PERSONA 4','correo@empresa4.com',1),(5,'NIT5','EMPRESA 5','','PERSONA 5','correo5@persona5.com',1);
/*!40000 ALTER TABLE `kpi_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `kpi_last_day_week`
--

/*!50001 DROP TABLE IF EXISTS `kpi_last_day_week`*/;
/*!50001 DROP VIEW IF EXISTS `kpi_last_day_week`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `kpi_last_day_week` AS select `d`.`id` AS `id`,`d`.`current_day` AS `current_day`,`d`.`description` AS `description`,`d`.`scheduled_orders` AS `scheduled_orders`,`d`.`finished_orders` AS `finished_orders`,`d`.`failures_orders` AS `failures_orders`,`d`.`id_week` AS `id_week`,`d`.`state` AS `state` from `kpi_daily` `d` where (`d`.`current_day` = (select max(`e`.`current_day`) from `kpi_daily` `e` where (`e`.`id_week` = `d`.`id_week`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `kpi_daily_sum_hours`
--

/*!50001 DROP TABLE IF EXISTS `kpi_daily_sum_hours`*/;
/*!50001 DROP VIEW IF EXISTS `kpi_daily_sum_hours`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `kpi_daily_sum_hours` AS select `a`.`id_daily` AS `id_daily`,`b`.`ID` AS `id_delay`,`b`.`NAME` AS `name_daily`,sum(`a`.`num_hours`) AS `num_hours` from (`kpi_daily_delay` `a` join `kpi_delay` `b`) where ((`b`.`ID` = `a`.`id_delay`) and (`a`.`num_hours` > 0)) group by `a`.`id_daily`,`b`.`ID`,`b`.`NAME` order by sum(`a`.`num_hours`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-24  6:37:34
