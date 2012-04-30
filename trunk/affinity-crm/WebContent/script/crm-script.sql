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
INSERT INTO `crm_user_role` VALUES (1,1,1);
/*!40000 ALTER TABLE `crm_user_role` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `crm_parameter` VALUES (1,'SAP_ENVIRONMENT',NULL,'300',NULL),(2,'SAP_PRUEBA','','',2.000),(3,'SAP_URL_CUSTOMER_MAINTAIN_ALL',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/300/zsd_customer_maintain_all/zsd_customer_maintain_all',NULL),(4,'SAP_URL_CUSTOMER_FIND',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zbapi_customer_find/300/zbapi_customer_find/zbapi_customer_find',NULL),(5,'SAP_URL_SALESORDER_CREATEFROMDAT',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zbapi_salesorder_createfromdat/300/zbapi_salesorder_createfromdat/zbapi_salesorder_createfromdat',NULL),(6,'SAP_URL_CUSTOMER2',NULL,'http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2',NULL),(7,'SAP_LOGIN',NULL,'TACTUSOFT',NULL),(8,'SAP_PASSWORD',NULL,'AFFINITY',NULL);
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
INSERT INTO `crm_user` VALUES (1,'gsolorzano','202cb962ac59075b964b07152d234b70','Geerardo',NULL,'Solorzano',NULL,'gsolorzano@affinity.com.co',NULL,NULL,1,1,1);
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
INSERT INTO `crm_department` VALUES (1,'TCN','Tecnología',1);
/*!40000 ALTER TABLE `crm_department` ENABLE KEYS */;
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
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_role`
--

LOCK TABLES `crm_role` WRITE;
/*!40000 ALTER TABLE `crm_role` DISABLE KEYS */;
INSERT INTO `crm_role` VALUES (1,'ADMINISTRADOR','Administrador',1);
/*!40000 ALTER TABLE `crm_role` ENABLE KEYS */;
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
INSERT INTO `crm_page_role` VALUES (1,1,1),(2,2,1),(3,3,1),(4,4,1),(5,5,1),(6,6,1),(7,7,1);
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
  `sales_off` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
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
INSERT INTO `crm_profile` VALUES (1,'PROFILE 1',NULL,'1000','20','1400','10',1);
/*!40000 ALTER TABLE `crm_profile` ENABLE KEYS */;
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
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_crm_doctor_1` (`id_speciality`),
  CONSTRAINT `fk_crm_doctor_1` FOREIGN KEY (`id_speciality`) REFERENCES `crm_speciality` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor`
--

LOCK TABLES `crm_doctor` WRITE;
/*!40000 ALTER TABLE `crm_doctor` DISABLE KEYS */;
INSERT INTO `crm_doctor` VALUES (1,'8647362','JUAN','','PEREZ','',1,'M',1,0,1),(2,'123','Pedro','','Perez','',1,'W',1,0,1),(3,'456','Adriana','','Fuente','',1,'W',1,1,1);
/*!40000 ALTER TABLE `crm_doctor` ENABLE KEYS */;
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
INSERT INTO `crm_page` VALUES (1,'Seguridad',NULL,'ui-icon-document',NULL,1),(2,'Tablas',NULL,'ui-icon-gear',NULL,2),(3,'Usuarios',NULL,NULL,1,1),(4,'Roles',NULL,NULL,1,2),(5,'Doctor','/pages/tables/doctor.jsf',NULL,2,1),(6,'Parámetros','/pages/tables/parameter.jsf',NULL,2,2),(7,'Especialidad','/pages/tables/speciality.jsf',NULL,2,3);
/*!40000 ALTER TABLE `crm_page` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-29 21:51:15
