CREATE DATABASE  IF NOT EXISTS `crm_db` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `crm_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: crm_db
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
-- Table structure for table `crm_parameter`
--

DROP TABLE IF EXISTS `crm_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_parameter` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `text_value` varchar(5000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `number_value` decimal(19,3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_parameter`
--

LOCK TABLES `crm_parameter` WRITE;
/*!40000 ALTER TABLE `crm_parameter` DISABLE KEYS */;
INSERT INTO `crm_parameter` VALUES (1,'SAP_ENVIRONMENT',NULL,'300',NULL),(2,'SAP_URL_CUSTOMER_MAINTAIN_ALL',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/300/zsd_customer_maintain_all/zsd_customer_maintain_all',NULL),(3,'SAP_URL_CUSTOMER_FIND',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zbapi_customer_find/300/zbapi_customer_find/zbapi_customer_find',NULL),(4,'SAP_URL_SALESORDER_CREATEFROMDAT',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zbapi_salesorder_createfromdat/300/zbapi_salesorder_createfromdat/zbapi_salesorder_createfromdat',NULL),(5,'SAP_URL_CUSTOMER2',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2',NULL),(6,'SAP_USERNAME',NULL,'TACTUSOFT',NULL),(7,'SAP_PASSWORD',NULL,'AFFINITY',NULL),(8,'RUTA_ARCHIVO_MATERIALES',NULL,'C:\\affinity\\Materiales4000.xlsx',0.000);
/*!40000 ALTER TABLE `crm_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_user`
--

DROP TABLE IF EXISTS `crm_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_user` (
  `id` decimal(19,0) NOT NULL,
  `username` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `first_name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `middle_name` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `first_surname` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `second_surname` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(1000) COLLATE latin1_spanish_ci NOT NULL,
  `phone` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `extension` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_departament` decimal(19,0) NOT NULL,
  `id_profile` decimal(19,0) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_crm_user_1` (`id_departament`),
  KEY `fk_crm_user_2` (`id_profile`),
  CONSTRAINT `fk_crm_user_1` FOREIGN KEY (`id_departament`) REFERENCES `crm_department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_user_2` FOREIGN KEY (`id_profile`) REFERENCES `crm_profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_user`
--

LOCK TABLES `crm_user` WRITE;
/*!40000 ALTER TABLE `crm_user` DISABLE KEYS */;
INSERT INTO `crm_user` VALUES (1,'gsolorzano','250cf8b51c773f3f8dc8b4be867a9a02','Gerardo','','Solorzano','','gsolorzano@affinity.com.co',NULL,NULL,1,2,1),(2,'jennyalvarez','202cb962ac59075b964b07152d234b70','Jenny',NULL,'Alvarez',NULL,'jennyalvarez@affinitycolombia.com',NULL,NULL,1,1,1),(3,'jperez','123','juan','','perez','','JUAN.PEREZ@hotmail.com','','',1,1,1);
/*!40000 ALTER TABLE `crm_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_department`
--

DROP TABLE IF EXISTS `crm_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_department` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_department`
--

LOCK TABLES `crm_department` WRITE;
/*!40000 ALTER TABLE `crm_department` DISABLE KEYS */;
INSERT INTO `crm_department` VALUES (1,'TCN','Tecnología',1),(2,'CLC','CALL CENTER',1),(3,'SALUD','SALUD',1);
/*!40000 ALTER TABLE `crm_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_page_role`
--

DROP TABLE IF EXISTS `crm_page_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_page_role` (
  `id` decimal(19,0) NOT NULL,
  `id_page` decimal(19,0) NOT NULL,
  `id_role` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_page_role_1` (`id_page`,`id_role`),
  KEY `fk_crm_page_role_1` (`id_page`),
  KEY `fk_crm_page_role_2` (`id_role`),
  CONSTRAINT `fk_crm_page_role_1` FOREIGN KEY (`id_page`) REFERENCES `crm_page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_page_role_2` FOREIGN KEY (`id_role`) REFERENCES `crm_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_page_role`
--

LOCK TABLES `crm_page_role` WRITE;
/*!40000 ALTER TABLE `crm_page_role` DISABLE KEYS */;
INSERT INTO `crm_page_role` VALUES (52,1,1),(12,1,2),(53,2,1),(13,2,2),(39,3,1),(10,3,2),(41,4,1),(45,5,1),(47,6,1),(42,7,1),(49,8,1),(11,8,2),(44,9,1),(40,10,1),(54,11,1),(24,11,2),(38,11,3),(66,11,4),(50,12,1),(37,12,3),(61,12,4),(46,13,1),(48,14,1),(55,15,1),(67,15,4),(43,16,1),(51,17,1),(62,17,4),(56,18,1),(63,18,4),(57,19,1),(64,19,4),(58,20,1),(59,21,1),(60,22,1),(65,22,4);
/*!40000 ALTER TABLE `crm_page_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_profile`
--

DROP TABLE IF EXISTS `crm_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_profile` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `sales_org` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `distr_chan` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `division` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_profile`
--

LOCK TABLES `crm_profile` WRITE;
/*!40000 ALTER TABLE `crm_profile` DISABLE KEYS */;
INSERT INTO `crm_profile` VALUES (1,'Finders Canal10','Utiizado para perfiles de Finders Canal 10','4000','10','10',1),(2,'Affinity Canal10','Affinity Canal10','1000','10','10',1),(3,'Finders Canal20','','4000','20','10',1),(4,'Finders Canal30','','4000','30','10',1),(5,'Finders Canal31','1','4000','31','10',1);
/*!40000 ALTER TABLE `crm_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_appointment`
--

DROP TABLE IF EXISTS `crm_appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_appointment` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `patient` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `patient_names` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `patient_sap` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_branch` decimal(19,0) NOT NULL,
  `id_procedure_detail` decimal(19,0) NOT NULL,
  `id_doctor` decimal(19,0) NOT NULL,
  `start_appointment_date` datetime NOT NULL,
  `end_appointment_date` datetime NOT NULL,
  `id_publicity` decimal(19,0) DEFAULT NULL,
  `obs` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_crm_appointment_1` (`id_doctor`),
  KEY `fk_crm_appointment_2` (`id_procedure_detail`),
  KEY `fk_crm_appointment_3` (`id_branch`),
  CONSTRAINT `fk_crm_appointment_1` FOREIGN KEY (`id_doctor`) REFERENCES `crm_doctor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_appointment_2` FOREIGN KEY (`id_procedure_detail`) REFERENCES `crm_procedure_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_appointment_3` FOREIGN KEY (`id_branch`) REFERENCES `crm_branch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_appointment`
--

LOCK TABLES `crm_appointment` WRITE;
/*!40000 ALTER TABLE `crm_appointment` DISABLE KEYS */;
INSERT INTO `crm_appointment` VALUES (1,'1','0000137537','ALVAREZ DIMAS JENNY PAOLA',NULL,1,1,1,'2012-05-29 08:00:00','2012-05-29 08:45:00',NULL,NULL,1),(2,'2','0000765439','SARMIENTO ROYERO CARLOS ARTURO',NULL,1,1,2,'2012-05-29 08:00:00','2012-05-29 08:45:00',NULL,NULL,1),(3,'3','0000137537','ALVAREZ DIMAS JENNY PAOLA',NULL,1,1,1,'2012-05-29 09:30:00','2012-05-29 10:15:00',NULL,NULL,1),(4,'4','0000765439','SARMIENTO ROYERO CARLOS ARTURO',NULL,1,1,1,'2012-05-29 08:50:00','2012-05-29 09:20:00',NULL,NULL,1),(5,'5','0000137537','ALVAREZ DIMAS JENNY PAOLA',NULL,1,1,2,'2012-05-29 13:00:00','2012-05-29 13:30:00',NULL,NULL,1),(6,'C00006','0000137537','ALVAREZ DIMAS JENNY PAOLA','0000137537',1,1,2,'2012-05-29 10:30:00','2012-05-29 11:00:00',NULL,NULL,2),(7,'C00007','0000137537','ALVAREZ DIMAS JENNY PAOLA','0000137537',1,1,1,'2012-05-29 11:00:00','2012-05-29 11:30:00',NULL,NULL,2),(8,'C00008','0000137537','ALVAREZ DIMAS JENNY PAOLA','0000137537',1,1,1,'2012-05-29 11:30:00','2012-05-29 12:00:00',NULL,NULL,2),(9,'C00009','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,1,'2012-05-29 10:30:00','2012-05-29 11:00:00',NULL,NULL,2),(10,'C00010','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,1,'2012-05-30 10:30:00','2012-05-30 11:00:00',NULL,NULL,3);
/*!40000 ALTER TABLE `crm_appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_doctor`
--

DROP TABLE IF EXISTS `crm_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_doctor` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `first_name` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `second_name` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `first_surname` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `second_surname` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_speciality` decimal(19,0) NOT NULL,
  `gender` varchar(1) COLLATE latin1_spanish_ci DEFAULT NULL,
  `on_site` tinyint(1) DEFAULT NULL,
  `virtual` tinyint(1) DEFAULT NULL,
  `id_branch` decimal(19,0) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  `id_user` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_crm_doctor_1` (`id_speciality`),
  KEY `fk_crm_doctor_2` (`id_branch`),
  KEY `fk_crm_doctor_3` (`id_user`),
  CONSTRAINT `fk_crm_doctor_3` FOREIGN KEY (`id_user`) REFERENCES `crm_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_doctor_1` FOREIGN KEY (`id_speciality`) REFERENCES `crm_speciality` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_doctor_2` FOREIGN KEY (`id_branch`) REFERENCES `crm_branch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor`
--

LOCK TABLES `crm_doctor` WRITE;
/*!40000 ALTER TABLE `crm_doctor` DISABLE KEYS */;
INSERT INTO `crm_doctor` VALUES (1,'8647362','JUAN','','PEREZ','',1,'M',1,0,1,1,1),(2,'123','Pedro','','Perez','',1,'W',1,0,1,1,1),(3,'456','Adriana','','Fuente','',1,'W',1,1,1,1,1),(4,'142589','MARIA','','JUANA','',1,'W',1,1,1,0,1);
/*!40000 ALTER TABLE `crm_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_country`
--

DROP TABLE IF EXISTS `crm_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_country` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_country_1` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_country`
--

LOCK TABLES `crm_country` WRITE;
/*!40000 ALTER TABLE `crm_country` DISABLE KEYS */;
INSERT INTO `crm_country` VALUES (1,'CO','Colombia'),(2,'MX','México');
/*!40000 ALTER TABLE `crm_country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_speciality`
--

DROP TABLE IF EXISTS `crm_speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_speciality` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_speciality`
--

LOCK TABLES `crm_speciality` WRITE;
/*!40000 ALTER TABLE `crm_speciality` DISABLE KEYS */;
INSERT INTO `crm_speciality` VALUES (1,'MED_GENERAL','Médico General',1),(2,'FISIOTERAPIA','Fisioterapia',1);
/*!40000 ALTER TABLE `crm_speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_user_role`
--

DROP TABLE IF EXISTS `crm_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_user_role` (
  `id` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) NOT NULL,
  `id_role` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_crm_user_role_1` (`id_user`),
  KEY `fk_crm_user_role_2` (`id_role`),
  CONSTRAINT `fk_crm_user_role_1` FOREIGN KEY (`id_user`) REFERENCES `crm_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_user_role_2` FOREIGN KEY (`id_role`) REFERENCES `crm_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_user_role`
--

LOCK TABLES `crm_user_role` WRITE;
/*!40000 ALTER TABLE `crm_user_role` DISABLE KEYS */;
INSERT INTO `crm_user_role` VALUES (1,1,1),(2,2,1),(3,3,4);
/*!40000 ALTER TABLE `crm_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_doctor_hour`
--

DROP TABLE IF EXISTS `vw_doctor_hour`;
/*!50001 DROP VIEW IF EXISTS `vw_doctor_hour`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_doctor_hour` (
  `id_branch` decimal(19,0),
  `appointment_date` date,
  `id_doctor` decimal(19,0),
  `doctor_name` varchar(45),
  `doctor_surname` varchar(45),
  `hours` double(23,6)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `crm_user_branch`
--

DROP TABLE IF EXISTS `crm_user_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_user_branch` (
  `id` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) DEFAULT NULL,
  `id_branch` decimal(19,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_user_brach_1` (`id_user`,`id_branch`),
  KEY `fk_crm_user_brach_1` (`id_user`),
  KEY `fk_crm_user_brach_2` (`id_branch`),
  CONSTRAINT `fk_crm_user_brach_1` FOREIGN KEY (`id_user`) REFERENCES `crm_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_user_brach_2` FOREIGN KEY (`id_branch`) REFERENCES `crm_branch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_user_branch`
--

LOCK TABLES `crm_user_branch` WRITE;
/*!40000 ALTER TABLE `crm_user_branch` DISABLE KEYS */;
INSERT INTO `crm_user_branch` VALUES (5,1,1),(6,1,2),(3,2,1),(4,2,2),(7,3,1);
/*!40000 ALTER TABLE `crm_user_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_branch`
--

DROP TABLE IF EXISTS `crm_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_branch` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `name` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `formula` varchar(4) COLLATE latin1_spanish_ci NOT NULL,
  `doctors` int(11) DEFAULT NULL,
  `nurses` int(11) DEFAULT NULL,
  `stretchers` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_branch`
--

LOCK TABLES `crm_branch` WRITE;
/*!40000 ALTER TABLE `crm_branch` DISABLE KEYS */;
INSERT INTO `crm_branch` VALUES (1,'4025','4025','ZHD2',NULL,NULL,NULL,1),(2,'1013','1013','ZHD2',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `crm_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_role`
--

DROP TABLE IF EXISTS `crm_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_role` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_page` decimal(19,0) DEFAULT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_crm_role_1` (`id_page`),
  CONSTRAINT `fk_crm_role_1` FOREIGN KEY (`id_page`) REFERENCES `crm_page` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_role`
--

LOCK TABLES `crm_role` WRITE;
/*!40000 ALTER TABLE `crm_role` DISABLE KEYS */;
INSERT INTO `crm_role` VALUES (1,'ADMINISTRADOR','Administrador',17,1),(2,'CALL_CENTER','',3,1),(3,'GERENCIA','',12,1),(4,'MEDICO','MEDICO',22,1);
/*!40000 ALTER TABLE `crm_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_doctor_schedule`
--

DROP TABLE IF EXISTS `crm_doctor_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_doctor_schedule` (
  `id` decimal(19,0) NOT NULL,
  `id_doctor` decimal(19,0) NOT NULL,
  `day` int(11) NOT NULL,
  `start_hour` time NOT NULL,
  `end_hour` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_doctor_schedule_1` (`id_doctor`,`day`,`start_hour`),
  KEY `fk_crm_doctor_schedule_1` (`id_doctor`),
  CONSTRAINT `fk_crm_doctor_schedule_1` FOREIGN KEY (`id_doctor`) REFERENCES `crm_doctor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor_schedule`
--

LOCK TABLES `crm_doctor_schedule` WRITE;
/*!40000 ALTER TABLE `crm_doctor_schedule` DISABLE KEYS */;
INSERT INTO `crm_doctor_schedule` VALUES (1,1,2,'08:00:00','12:00:00'),(2,1,2,'13:00:00','18:00:00'),(3,1,3,'08:00:00','12:00:00'),(4,1,3,'13:00:00','18:00:00'),(5,1,6,'08:00:00','12:00:00'),(6,1,4,'08:00:00','12:00:00'),(7,1,4,'13:00:00','18:00:00'),(8,1,5,'08:00:00','12:00:00'),(9,1,5,'13:00:00','18:00:00'),(10,2,5,'13:00:00','17:00:00'),(11,4,4,'08:00:00','12:00:00');
/*!40000 ALTER TABLE `crm_doctor_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_procedure_detail`
--

DROP TABLE IF EXISTS `crm_procedure_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_procedure_detail` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `id_procedure` decimal(19,0) NOT NULL,
  `time_doctor` int(11) DEFAULT '0',
  `time_nurses` int(11) DEFAULT '0',
  `time_stretchers` int(11) DEFAULT '0',
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_crm_procedure_detail_1` (`id_procedure`),
  CONSTRAINT `fk_crm_procedure_detail_1` FOREIGN KEY (`id_procedure`) REFERENCES `crm_procedure` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_procedure_detail`
--

LOCK TABLES `crm_procedure_detail` WRITE;
/*!40000 ALTER TABLE `crm_procedure_detail` DISABLE KEYS */;
INSERT INTO `crm_procedure_detail` VALUES (1,'Primera Cita',1,30,0,0,1),(2,'Control',2,30,0,0,1),(3,'Terapia 1',3,45,45,45,1),(4,'Terapia 2',3,50,50,50,1);
/*!40000 ALTER TABLE `crm_procedure_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_doctor_exception`
--

DROP TABLE IF EXISTS `crm_doctor_exception`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_doctor_exception` (
  `id` decimal(19,0) NOT NULL,
  `id_doctor` decimal(19,0) NOT NULL,
  `start_hour` datetime NOT NULL,
  `end_hour` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_crm_doctor_exception_1` (`id_doctor`),
  CONSTRAINT `fk_crm_doctor_exception_1` FOREIGN KEY (`id_doctor`) REFERENCES `crm_doctor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor_exception`
--

LOCK TABLES `crm_doctor_exception` WRITE;
/*!40000 ALTER TABLE `crm_doctor_exception` DISABLE KEYS */;
INSERT INTO `crm_doctor_exception` VALUES (1,1,'2012-06-04 08:00:00','2012-06-04 10:00:00'),(3,1,'2012-06-18 08:00:00','2012-06-18 20:00:00'),(4,1,'2012-06-04 11:00:00','2012-06-04 12:00:00'),(5,1,'2012-06-04 14:00:00','2012-06-04 14:30:00');
/*!40000 ALTER TABLE `crm_doctor_exception` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_procedure`
--

DROP TABLE IF EXISTS `crm_procedure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_procedure` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `description` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `parallel` tinyint(1) NOT NULL DEFAULT '0',
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_procedure`
--

LOCK TABLES `crm_procedure` WRITE;
/*!40000 ALTER TABLE `crm_procedure` DISABLE KEYS */;
INSERT INTO `crm_procedure` VALUES (1,'Primera Cita','Primera Cita',0,1),(2,'Control','Control',0,1),(3,'Terapias','Terapias',1,1);
/*!40000 ALTER TABLE `crm_procedure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_specialty`
--

DROP TABLE IF EXISTS `crm_specialty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_specialty` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_specialty`
--

LOCK TABLES `crm_specialty` WRITE;
/*!40000 ALTER TABLE `crm_specialty` DISABLE KEYS */;
INSERT INTO `crm_specialty` VALUES (1,'MED_GENERAL','Médico General',1);
/*!40000 ALTER TABLE `crm_specialty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_domain`
--

DROP TABLE IF EXISTS `crm_domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_domain` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `item_value` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `group` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_domain_1` (`code`,`group`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_domain`
--

LOCK TABLES `crm_domain` WRITE;
/*!40000 ALTER TABLE `crm_domain` DISABLE KEYS */;
INSERT INTO `crm_domain` VALUES (1,'E','Efectivo','FORMA_PAGO'),(2,'C','Cheque','FORMA_PAGO'),(3,'T','Tarjeta de Crédito','FORMA_PAGO'),(4,'Z001','Pagadero Inmediato','CONDICION_PAGO'),(5,'Z024','Cuotas: 25% + 6 semanales','CONDICION_PAGO'),(6,'Z025','Cuotas: 12.5% + 3 semanales','CONDICION_PAGO'),(7,'P18','P18','PAUTA');
/*!40000 ALTER TABLE `crm_domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_holiday`
--

DROP TABLE IF EXISTS `crm_holiday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_holiday` (
  `id` decimal(19,0) NOT NULL,
  `description` varchar(1000) COLLATE latin1_spanish_ci NOT NULL,
  `holiday` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_holiday_1` (`holiday`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_holiday`
--

LOCK TABLES `crm_holiday` WRITE;
/*!40000 ALTER TABLE `crm_holiday` DISABLE KEYS */;
INSERT INTO `crm_holiday` VALUES (1,'Festivo','2012-06-02'),(2,'Festivo 11/06','2012-06-11');
/*!40000 ALTER TABLE `crm_holiday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vw_doctor_schedule`
--

DROP TABLE IF EXISTS `vw_doctor_schedule`;
/*!50001 DROP VIEW IF EXISTS `vw_doctor_schedule`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `vw_doctor_schedule` (
  `id_doctor` decimal(19,0),
  `first_name` varchar(45),
  `first_surname` varchar(45),
  `id_branch` decimal(19,0),
  `day` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `crm_region`
--

DROP TABLE IF EXISTS `crm_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_region` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `id_country` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_region_1` (`code`),
  KEY `fk_crm_region_1` (`id_country`),
  CONSTRAINT `fk_crm_state_1` FOREIGN KEY (`id_country`) REFERENCES `crm_country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_region`
--

LOCK TABLES `crm_region` WRITE;
/*!40000 ALTER TABLE `crm_region` DISABLE KEYS */;
INSERT INTO `crm_region` VALUES (1,'5','ANTIOQUIA',1),(2,'8','ATLÁNTICO',1),(3,'11','BOGOTÁ',1),(4,'13','BOLÍVAR',1),(5,'15','BOYACA',1),(6,'17','CALDAS',1),(7,'18','CAQUETA',1),(8,'19','CAUCA',1),(9,'20','CESAR',1),(10,'23','CÓRDOBA',1),(11,'25','CUNDINAMARCA',1),(12,'27','CHOCO',1),(13,'41','HUILA',1),(14,'44','LA GUAJIRA',1),(15,'47','MAGDALENA',1),(16,'50','META',1),(17,'52','NARIÑO',1),(18,'54','NORTE SANTANDER',1),(19,'63','QUINDIO',1),(20,'66','RISARALDA',1),(21,'68','SANTANDER',1),(22,'70','SUCRE',1),(23,'73','TOLIMA',1),(24,'76','VALLE',1),(25,'81','ARAUCA',1),(26,'85','CASANARE',1),(27,'86','PUTUMAYO',1),(28,'88','SAN ANDRÉS',1),(29,'91','AMAZONAS',1),(30,'94','GUAINIA',1),(31,'95','GUAVIARE',1),(32,'97','VAUPES',1),(33,'99','VICHADA',1);
/*!40000 ALTER TABLE `crm_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_city`
--

DROP TABLE IF EXISTS `crm_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_city` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `id_region` decimal(19,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_city_1` (`code`),
  KEY `fk_crm_city_1` (`id_region`),
  CONSTRAINT `fk_crm_city_1` FOREIGN KEY (`id_region`) REFERENCES `crm_region` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_city`
--

LOCK TABLES `crm_city` WRITE;
/*!40000 ALTER TABLE `crm_city` DISABLE KEYS */;
INSERT INTO `crm_city` VALUES (1,'1','MEDELLIN',1),(2,'2','BARRANQUILLA',2),(3,'3','BOGOTÁ',3),(4,'4','CARTAGENA',4),(5,'5','TUNJA',5),(6,'6','MANIZALES',6),(7,'7','FLORENCIA',7),(8,'8','POPAYAN',8),(9,'9','VALLEDUPAR',9),(10,'10','MONTERIA',10),(11,'11','BOGOTÁ',11),(12,'12','QUIBDO',12),(13,'13','NEIVA',13),(14,'14','RIOHACHA',14),(15,'15','SANTA MARTA',15),(16,'16','VILLAVIVENCIO',16),(17,'17','PASTO',17),(18,'18','CUCUTA',18),(19,'19','ARMENIA',19),(20,'20','PEREIRA',20),(21,'21','BUCARAMANGA',21),(22,'22','SINCELEJO',22),(23,'23','IBAGUE',23),(24,'24','CALI',24),(25,'25','ARAUCA',25),(26,'26','YOPAL',26),(27,'27','MOCOA',27),(28,'28','SAN ANDRES',28),(29,'29','LETICIA',29),(30,'30','INIRIDA',30),(31,'31','SAN JOSE DE GUAVIARE',31),(32,'32','MITU',32),(33,'33','PUERTO CARREÑO',33);
/*!40000 ALTER TABLE `crm_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_page`
--

DROP TABLE IF EXISTS `crm_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_page` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `page` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `icon` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `parent` decimal(19,0) DEFAULT NULL,
  `orderby` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_page`
--

LOCK TABLES `crm_page` WRITE;
/*!40000 ALTER TABLE `crm_page` DISABLE KEYS */;
INSERT INTO `crm_page` VALUES (1,'Seguridad',NULL,'ui-icon-document',NULL,1),(2,'Tablas',NULL,'ui-icon-gear',NULL,2),(3,'Usuarios','/pages/secure/user.jsf',NULL,1,2),(4,'Roles','/pages/secure/role.jsf',NULL,1,1),(5,'Doctor','/pages/tables/doctor.jsf',NULL,2,1),(6,'Parámetros','/pages/tables/parameter.jsf',NULL,2,2),(7,'Especialdades','/pages/tables/speciality.jsf',NULL,2,3),(8,'Pacientes','/pages/processes/patient.jsf',NULL,11,1),(9,'Perfiles','/pages/tables/profile.jsf',NULL,2,5),(10,'Cambiar Clave','/pages/secure/changePassword.jsf',NULL,1,3),(11,'Procesos',NULL,'ui-icon-contact',NULL,3),(12,'Crear Pedido','/pages/processes/salesOrder.jsf',NULL,11,2),(13,'Sucursales','/pages/tables/branch.jsf',NULL,2,4),(14,'Departamentos','/pages/tables/department.jsf',NULL,2,6),(15,'Agenda',NULL,'ui-icon-calendar',NULL,4),(16,'Procedimientos','/pages/tables/procedure.jsf',NULL,2,7),(17,'Crear Cita','/pages/processes/appointment.jsf',NULL,15,1),(18,'Cancelar Cita','/pages/processes/appointmentCancel.jsf',NULL,15,2),(19,'Chequear Cita','/pages/processes/appointmentCheck.jsf',NULL,15,3),(20,'Días No Hábiles','/pages/tables/holiday.jsf',NULL,2,8),(21,'Días No Trabajados','/pages/tables/exception.jsf',NULL,2,9),(22,'Búsqueda Por Paciente','/pages/processes/searchByPatient.jsf',NULL,15,10);
/*!40000 ALTER TABLE `crm_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `vw_doctor_hour`
--

/*!50001 DROP TABLE IF EXISTS `vw_doctor_hour`*/;
/*!50001 DROP VIEW IF EXISTS `vw_doctor_hour`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_doctor_hour` AS select `a`.`id_branch` AS `id_branch`,cast(`a`.`start_appointment_date` as date) AS `appointment_date`,`a`.`id_doctor` AS `id_doctor`,`b`.`first_name` AS `doctor_name`,`b`.`first_surname` AS `doctor_surname`,sum(timediff(`a`.`end_appointment_date`,`a`.`start_appointment_date`)) AS `hours` from (`crm_appointment` `a` join `crm_doctor` `b` on((`a`.`id_doctor` = `b`.`id`))) group by `a`.`id_branch`,cast(`a`.`start_appointment_date` as date),`a`.`id_doctor`,`b`.`first_name`,`b`.`first_surname` order by sum(timediff(`a`.`end_appointment_date`,`a`.`start_appointment_date`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_doctor_schedule`
--

/*!50001 DROP TABLE IF EXISTS `vw_doctor_schedule`*/;
/*!50001 DROP VIEW IF EXISTS `vw_doctor_schedule`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_doctor_schedule` AS select distinct `a`.`id` AS `id_doctor`,`a`.`first_name` AS `first_name`,`a`.`first_surname` AS `first_surname`,`a`.`id_branch` AS `id_branch`,`b`.`day` AS `day` from (`crm_doctor` `a` join `crm_doctor_schedule` `b` on((`b`.`id_doctor` = `a`.`id`))) */;
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

-- Dump completed on 2012-06-05  6:58:02
