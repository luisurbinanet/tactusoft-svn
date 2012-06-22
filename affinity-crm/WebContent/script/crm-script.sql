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
INSERT INTO `crm_parameter` VALUES (1,'SAP_ENVIRONMENT',NULL,'300',NULL),(2,'SAP_URL_CUSTOMER_MAINTAIN_ALL',NULL,'http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/300/zsd_customer_maintain_all/zsd_customer_maintain_all',NULL),(3,'SAP_URL_CUSTOMER_FIND',NULL,'http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zbapi_customer_find/300/zbapi_customer_find/zbapi_customer_find',NULL),(4,'SAP_URL_SALESORDER_CREATEFROMDAT',NULL,'http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zbapi_salesorder_createfromdat/300/zbapi_salesorder_createfromdat/zbapi_salesorder_createfromdat',NULL),(5,'SAP_URL_CUSTOMER2',NULL,'http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2',NULL),(6,'SAP_USERNAME',NULL,'TACTUSOFT',NULL),(7,'SAP_PASSWORD',NULL,'AFFINITY',NULL),(8,'RUTA_ARCHIVO_MATERIALES',NULL,'/opt/affinity/Materiales4000.xlsx',0.000),(9,'SAP_URL_ZWEBLIST',NULL,'http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zweblist/300/zweblist/zweblist',NULL);
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
INSERT INTO `crm_user` VALUES (1,'gsolorzano','250cf8b51c773f3f8dc8b4be867a9a02','Gerardo','','Solorzano','','gsolorzano@affinity.com.co','','',1,2,1),(2,'jennyalvarez','202cb962ac59075b964b07152d234b70','Jenny',NULL,'Alvarez',NULL,'jennyalvarez@affinitycolombia.com',NULL,NULL,1,1,1),(3,'jperez','202cb962ac59075b964b07152d234b70','juan','','perez','','JUAN.PEREZ@hotmail.com','','',1,1,1),(4,'ccbog_age1','202cb962ac59075b964b07152d234b70','Agente1','','Call Center','','agente1.bogota@affinitycolombia.com','6231629','',2,2,1);
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
-- Table structure for table `crm_holiday_branch`
--

DROP TABLE IF EXISTS `crm_holiday_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_holiday_branch` (
  `id` decimal(19,0) NOT NULL,
  `id_holiday` decimal(19,0) NOT NULL,
  `id_branch` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crm_holiday_branch_1` (`id_holiday`,`id_branch`),
  KEY `fk_crm_holiday_branch_1` (`id_holiday`),
  KEY `fk_crm_holiday_branch_2` (`id_branch`),
  CONSTRAINT `fk_crm_holiday_branch_1` FOREIGN KEY (`id_holiday`) REFERENCES `crm_holiday` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_holiday_branch_2` FOREIGN KEY (`id_branch`) REFERENCES `crm_branch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_holiday_branch`
--

LOCK TABLES `crm_holiday_branch` WRITE;
/*!40000 ALTER TABLE `crm_holiday_branch` DISABLE KEYS */;
INSERT INTO `crm_holiday_branch` VALUES (4,1,1),(5,1,2),(2,2,1),(3,2,2);
/*!40000 ALTER TABLE `crm_holiday_branch` ENABLE KEYS */;
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
INSERT INTO `crm_page_role` VALUES (97,1,1),(98,2,1),(77,3,1),(79,4,1),(84,5,1),(87,6,1),(81,7,1),(89,8,1),(70,8,2),(83,9,1),(78,10,1),(99,11,1),(75,11,2),(38,11,3),(66,11,4),(90,12,1),(71,12,2),(37,12,3),(61,12,4),(86,13,1),(80,14,1),(100,15,1),(76,15,2),(67,15,4),(82,16,1),(92,17,1),(72,17,2),(62,17,4),(93,18,1),(73,18,2),(63,18,4),(94,19,1),(64,19,4),(85,20,1),(88,21,1),(91,22,1),(74,22,2),(65,22,4),(101,23,1),(95,24,1),(96,25,1),(102,26,1),(103,27,1);
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
  `society` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
  `account` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `payment_term` varchar(4) COLLATE latin1_spanish_ci DEFAULT NULL,
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
INSERT INTO `crm_profile` VALUES (1,'Finders  - Canal 10','Finders  - Canal 10','4000','10','10','1000','1305050000','Z001',1),(2,'Finders  - Canal 20','Finders  - Canal 20','4000','20','10','1000','1305050000','Z001',1),(3,'Finders  - Canal 30','Finders  - Canal 30','4000','30','10','1000','1305050000','Z001',1),(4,'Finders  - Canal 31','Finders  - Canal 31','4000','31','10','1000','1305050000','Z001',1),(5,'Finders  - Canal 40','Finders  - Canal 40','4000','40','10','1000','1305050000','Z001',1),(6,'Finders  - Canal 50','Finders  - Canal 50','4000','50','10','1000','1305050000','Z001',1),(7,'Finders  - Canal 70','Finders  - Canal 70','4000','70','10','1000','1305050000','Z001',1),(8,'Affinity  - Canal 10','Affinity  - Canal 10','4000','10','10','1000','1305050000','Z001',1),(9,'Affinity  - Canal 20','Affinity  - Canal 20','4000','20','10','1000','1305050000','Z001',1),(10,'Affinity  - Canal 30','Affinity  - Canal 30','4000','30','10','1000','1305050000','Z001',1),(11,'Affinity  - Canal 31','Affinity  - Canal 31','4000','31','10','1000','1305050000','Z001',1),(12,'Affinity  - Canal 40','Affinity  - Canal 40','4000','40','10','1000','1305050000','Z001',1),(13,'Affinity  - Canal 50','Affinity  - Canal 50','4000','50','10','1000','1305050000','Z001',1),(14,'Affinity  - Canal 70','Affinity  - Canal 70','4000','70','10','1000','1305050000','Z001',1);
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
  `cod_publicity` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `name_publicity` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
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
INSERT INTO `crm_appointment` VALUES (2,'C00002','0000765441','ADRIANA M FUENTE E','0000765441',1,1,5,'2012-06-14 08:30:00','2012-06-14 09:00:00',NULL,NULL,NULL,1),(3,'C00003','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,6,'2012-06-14 11:30:00','2012-06-14 12:00:00',NULL,NULL,NULL,1),(4,'C00004','0000007623','EMIRO SOLORZANO GARCIA','0000007623',1,1,5,'2012-06-14 09:30:00','2012-06-14 10:00:00',NULL,NULL,NULL,1),(5,'C00005','0000765472','PACIENTE1','0000765465',1,1,5,'2012-06-20 10:00:00','2012-06-20 10:30:00',NULL,NULL,NULL,3),(6,'C00006','0000765472','PACIENTE1','0000000467',1,3,6,'2012-06-14 10:15:00','2012-06-14 11:00:00',NULL,NULL,NULL,3),(7,'C00007','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,5,'2012-06-21 08:00:00','2012-06-21 08:30:00',NULL,NULL,NULL,1),(8,'C00008','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,5,'2012-06-20 10:30:00','2012-06-20 11:00:00',NULL,NULL,NULL,1),(9,'C00009','0000765441','ADRIANA M FUENTE E','0000765441',1,1,5,'2012-06-21 08:30:00','2012-06-21 09:00:00',NULL,NULL,NULL,1),(10,'C00010','0000765439','SARMIENTO ROYERO CARLOS ARTURO','0000765439',1,1,6,'2012-06-14 10:30:00','2012-06-14 11:00:00',NULL,NULL,NULL,1),(11,'C00011','0000000467','TIBERIO TORRES SARMIENTO','0000000467',1,1,8,'2012-06-15 08:00:00','2012-06-15 08:30:00',NULL,NULL,NULL,1),(12,'C00012','0000765465','Prueba 14  junio de 2012','0000765465',2,1,5,'2012-06-21 09:00:00','2012-06-21 09:30:00',NULL,NULL,NULL,1),(13,'C00013','0000765465','Prueba 14  junio de 2012','0000765465',2,1,7,'2012-06-15 16:30:00','2012-06-15 17:00:00',NULL,NULL,NULL,1),(14,'C00014','0000686399','EDWIN MONROY','0000686399',2,1,9,'2012-06-15 15:30:00','2012-06-15 16:00:00',NULL,NULL,NULL,1),(15,'C00015','0000765465','Prueba 14  junio de 2012','0000765465',2,1,7,'2012-06-19 09:30:00','2012-06-19 10:00:00',NULL,NULL,NULL,1),(16,'C00016','0000686399','EDWIN MONROY','0000686399',2,1,7,'2012-06-19 08:30:00','2012-06-19 09:00:00',NULL,NULL,NULL,1),(17,'C00017','0000765441','ADRIANA M FUENTE E','0000765441',2,1,9,'2012-06-16 17:00:00','2012-06-16 17:30:00','102','TELEMEDICINA',NULL,1),(18,'C00018','0000765472','PACIENTE1','0000765471',1,1,8,'2012-06-22 08:00:00','2012-06-22 08:30:00','I20','VOLANTE',NULL,3),(19,'C00019','0000765473','PACIENTE2 PACIENTE2','0000765473',137,1,8,'2012-06-21 13:00:00','2012-06-21 13:30:00','B21','PASACALLE',NULL,3);
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
  `names` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `id_speciality` decimal(19,0) NOT NULL,
  `id_user` decimal(19,0) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  KEY `fk_crm_doctor_1` (`id_speciality`),
  KEY `fk_crm_doctor_3` (`id_user`),
  CONSTRAINT `fk_crm_doctor_1` FOREIGN KEY (`id_speciality`) REFERENCES `crm_speciality` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_doctor_3` FOREIGN KEY (`id_user`) REFERENCES `crm_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor`
--

LOCK TABLES `crm_doctor` WRITE;
/*!40000 ALTER TABLE `crm_doctor` DISABLE KEYS */;
INSERT INTO `crm_doctor` VALUES (5,'00000082','GOMEZ ALEXANDER',1,1,1),(6,'00000086','HERNANDEZ DIANA',1,3,1),(7,'00000089','ESPITIA EVANGELINA',1,1,1),(8,'00000090','ESCOBAR GUILLERMO',1,1,1),(9,'00000118','CASTAÑEDA RANGEL JAVIER AUGUST',1,1,1);
/*!40000 ALTER TABLE `crm_doctor` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Table structure for table `crm_history_record`
--

DROP TABLE IF EXISTS `crm_history_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_history_record` (
  `id` decimal(19,0) NOT NULL,
  `id_patient` decimal(19,0) NOT NULL,
  `hypertension` tinyint(1) DEFAULT NULL,
  `heart` tinyint(1) DEFAULT NULL,
  `cancer` tinyint(1) DEFAULT NULL,
  `arthritis` tinyint(1) DEFAULT NULL,
  `diabetes` tinyint(1) DEFAULT NULL,
  `diabetes_time` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `diabetes_glycemia` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `others` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `surgical_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `pharmacological_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `toxic_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `transfusion_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `allergy_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `immunizations_desc` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `others_recors` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `family_history` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `gestation` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obst_gyn_p` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obst_gyn_a` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obst_gyn_c` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obst_gyn_fur` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obst_gyn_others` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_patient_UNIQUE` (`id_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_history_record`
--

LOCK TABLES `crm_history_record` WRITE;
/*!40000 ALTER TABLE `crm_history_record` DISABLE KEYS */;
INSERT INTO `crm_history_record` VALUES (1,5,1,1,0,0,NULL,'','','','NO','NO','NO','NO','NO','NO','','NO','NO','NO','NO','NO','NO','NO'),(2,6,1,0,0,0,NULL,'','','','NO','NO','NO','NO','NO','NO','NO','DIABETES','NO','NO','NO','NO','NO','NO');
/*!40000 ALTER TABLE `crm_history_record` ENABLE KEYS */;
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
-- Table structure for table `crm_patient`
--

DROP TABLE IF EXISTS `crm_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_patient` (
  `id` decimal(19,0) NOT NULL,
  `doc` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `code_sap` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `firstnames` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `surnames` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `born_date` date DEFAULT NULL,
  `gender` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `occupation` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `address` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `neighborhood` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `phone_number` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `cell_number` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `type_housing` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `country` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `region` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `city` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `guardian` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `guardian_address` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `guardian_relationship` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `guardian_telephone` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `obs` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `cycle` tinyint(1) DEFAULT NULL,
  `send_phone` tinyint(1) DEFAULT NULL,
  `send_email` tinyint(1) DEFAULT NULL,
  `send_postal` tinyint(1) DEFAULT NULL,
  `send_sms` tinyint(1) DEFAULT NULL,
  `sales_org` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doc_UNIQUE` (`doc`),
  UNIQUE KEY `code_sap_UNIQUE` (`code_sap`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_patient`
--

LOCK TABLES `crm_patient` WRITE;
/*!40000 ALTER TABLE `crm_patient` DISABLE KEYS */;
INSERT INTO `crm_patient` VALUES (1,'PRUEBAC1','0000765467','PRUEBAC1','PRUEBAC1',NULL,'W',NULL,'PRUEBAC1',NULL,'PRUEBAC1',NULL,NULL,NULL,'CO','91','LETICIA',NULL,NULL,NULL,NULL,NULL,0,0,0,0,0,NULL),(2,'PRUEBAC2','0000765468','PRUEBAC2','PRUEBAC2',NULL,'W',NULL,'PRUEBAC2',NULL,'PRUEBAC2',NULL,NULL,NULL,'CO','5','MEDELLIN',NULL,NULL,NULL,NULL,NULL,1,NULL,1,NULL,1,NULL),(3,'PRUEBAC9','0000765470','NPRUEBAC9','APRUEBAC9','1994-06-01','W','ADMINSITRADOR','PRUEBAC9','CEDROS','PRUEBAC9','','PRUEBAC9@PRUEBAC9.COM','R','CO','13','4','A','B','C','D','E',0,0,0,0,0,'4000'),(4,'PRUEBAC10','0000765471','NPRUEBAC10','APRUEBAC10','1982-09-03','W','INGENIERO','PRUEBAC10','CEDRITOS','PRUEBAC10','PRUEBAC10','PRUEBAC10@HOTMAIL.COM','R','CO','15','5','NPRUEBAC10','DNPRUEBAC10','PNPRUEBAC10','TNPRUEBAC10','OPRUEBAC10',0,0,0,0,0,'4000'),(5,'PACIENTE1','0000765472','PACIENTE1','PACIENTE1','1994-06-01','W','PACIENTE1','PACIENTE1','PACIENTE1','PACIENTE1','','PACIENTE1@HOTMAIL.COM','U','CO','91','29','PACIENTE1','PACIENTE1','PACIENTE1','PACIENTE1','PACIENTE1',0,1,0,1,1,'4000'),(6,'PACIENTE2','0000765473','PACIENTE2','PACIENTE2','1972-06-01','W','ingeniero','PACIENTE2','CEDRO','PACIENTE2','','','U','CO','91','29','PACIENTE2','PACIENTE2','PACIENTE2','PACIENTE2','PACIENTE2',0,1,1,0,0,'4000');
/*!40000 ALTER TABLE `crm_patient` ENABLE KEYS */;
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
INSERT INTO `crm_user_role` VALUES (2,2,1),(3,3,4),(4,4,2),(5,1,1);
/*!40000 ALTER TABLE `crm_user_role` ENABLE KEYS */;
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
INSERT INTO `crm_doctor_exception` VALUES (1,6,'2012-06-21 08:00:00','2012-06-21 10:00:00'),(2,8,'2012-06-21 15:00:00','2012-06-21 17:00:00');
/*!40000 ALTER TABLE `crm_doctor_exception` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `crm_user_branch` VALUES (12,1,137),(13,1,139),(3,2,1),(4,2,2),(7,3,1),(8,4,2),(9,4,3),(10,4,6),(11,4,8);
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
INSERT INTO `crm_branch` VALUES (1,'9900','Naturizza Calle 75 - Finders','ZHD2',NULL,NULL,NULL,1),(2,'9901','Naturizza Calle 75 - Affinity','ZHD2',NULL,NULL,NULL,1),(3,'9902','Naturizza Venecia - Affinity','ZHD2',NULL,NULL,NULL,1),(4,'9903','Naturizza Venecia - Finders','zhd2',NULL,NULL,NULL,1),(5,'9904','Naturizza 7Agosto - Finders','ZHD2',NULL,NULL,NULL,1),(6,'9905','Naturizza 7Agosto - Affinity','ZHD2',NULL,NULL,NULL,1),(7,'9906','Naturizza Vanity - Finders','zhd2',NULL,NULL,NULL,1),(8,'9907','Naturizza Vanity - Affinity','ZHD2',NULL,NULL,NULL,1),(9,'0001','Oficina ventas sur','ZHD2',NULL,NULL,NULL,1),(10,'1000','NZ-MONTERIA','ZHD2',NULL,NULL,NULL,1),(11,'1001','NX-SINCELEJO','ZHD2',NULL,NULL,NULL,1),(12,'1002','NZ-CARTAGENA','ZHD2',NULL,NULL,NULL,1),(13,'1003','NZ-BARRANQUILLA','ZHD2',NULL,NULL,NULL,1),(14,'1004','NZ-SANTA MARTA','ZHD2',NULL,NULL,NULL,1),(15,'1005','NZ-VALLEDUPAR','ZHD2',NULL,NULL,NULL,1),(16,'1006','NZ-CALI','ZHD2',NULL,NULL,NULL,1),(17,'1007','NZ-POPAYAN','ZHD2',NULL,NULL,NULL,1),(18,'1008','NZ-PASTO','ZHD2',NULL,NULL,NULL,1),(19,'1009','NZ-TULUA','ZHD2',NULL,NULL,NULL,1),(20,'1010','NZ-PALMIRA','ZHD2',NULL,NULL,NULL,1),(21,'1011','NX-BUGA','ZHD2',NULL,NULL,NULL,1),(22,'1012','NZ-BTA. CALLE 94','ZHD2',NULL,NULL,NULL,1),(23,'1503','BS Cali','ZHD2',NULL,NULL,NULL,1),(24,'1145','NX-OCANA','ZHD2',NULL,NULL,NULL,1),(25,'1146','N. Express  Soledad','ZHD2',NULL,NULL,NULL,1),(26,'1147','NX-STDER QUILICH','ZHD2',NULL,NULL,NULL,1),(27,'1148','NX-ESPINAL','ZHD2',NULL,NULL,NULL,1),(28,'1150','NZ-APARTADO','ZHD2',NULL,NULL,NULL,1),(29,'1151','NX-TUMACO','ZHD2',NULL,NULL,NULL,1),(30,'1152','N. Express Quibdo','ZHD2',NULL,NULL,NULL,1),(31,'1153','NX-RIOHACHA','ZHD2',NULL,NULL,NULL,1),(32,'1502','BS Bucaramanga','ZHD2',NULL,NULL,NULL,1),(33,'3008','Clinica Iztapalapa','ZHD2',NULL,NULL,NULL,1),(34,'1205','VD-MEDELLIN','ZHD2',NULL,NULL,NULL,1),(35,'1301','VN-CALI','ZHD2',NULL,NULL,NULL,1),(36,'3009','Axihoma','ZHD2',NULL,NULL,NULL,1),(37,'2250','NX-VILLETA','ZHD2',NULL,NULL,NULL,1),(38,'1036','NZ-RIONEGRO','ZHD2',NULL,NULL,NULL,1),(39,'3007','Clinica Guadalajara','ZHD2',NULL,NULL,NULL,1),(40,'4000','NZ-BARRANCA','ZHD2',NULL,NULL,NULL,1),(41,'1013','NZ-BTA. CALLE 75','ZHD2',NULL,NULL,NULL,1),(42,'1014','NZ-BTA. VENECIA','ZHD2',NULL,NULL,NULL,1),(43,'1015','NZ-IBAGUE','ZHD2',NULL,NULL,NULL,1),(44,'1016','NZ-NEIVA','ZHD2',NULL,NULL,NULL,1),(45,'1017','NZ-VILLAVICENCIO','ZHD2',NULL,NULL,NULL,1),(46,'1018','NX-VILLETA','ZHD2',NULL,NULL,NULL,1),(47,'1019','NZ-CUCUTA','ZHD2',NULL,NULL,NULL,1),(48,'1020','NZ-BUCARAMANGA','ZHD2',NULL,NULL,NULL,1),(49,'1021','NZ-TUNJA','ZHD2',NULL,NULL,NULL,1),(50,'1022','NZ-CHIQUINQUIRA','ZHD2',NULL,NULL,NULL,1),(51,'1023','NZ-MEDELLIN','ZHD2',NULL,NULL,NULL,1),(52,'1024','NZ-PEREIRA','ZHD2',NULL,NULL,NULL,1),(53,'1025','Clínica Manizales','ZHD2',NULL,NULL,NULL,1),(54,'1026','Clínica Armenia','ZHD2',NULL,NULL,NULL,1),(55,'1027','Clínica Girardot','ZHD2',NULL,NULL,NULL,1),(56,'1028','Clínica Duitama','ZHD2',NULL,NULL,NULL,1),(57,'1029','Clínica Pamplona','ZHD2',NULL,NULL,NULL,1),(58,'1030','Clínica Leticia','ZHD2',NULL,NULL,NULL,1),(59,'1031','Clínica San Andres','ZHD2',NULL,NULL,NULL,1),(60,'1032','Clínica Riohacha','ZHD2',NULL,NULL,NULL,1),(61,'1033','Clínica Pitalito','ZHD2',NULL,NULL,NULL,1),(62,'1034','NZ-BARRANCA','ZHD2',NULL,NULL,NULL,1),(63,'1035','Clínica Mompos','ZHD2',NULL,NULL,NULL,1),(64,'1037','NZ-7 DE AGOSTO','ZHD2',NULL,NULL,NULL,1),(65,'1100','Botica Norte','ZHD2',NULL,NULL,NULL,1),(66,'1101','NX-BTA ALCAZARES','ZHD2',NULL,NULL,NULL,1),(67,'1102','NX-BTA SUBA','ZHD2',NULL,NULL,NULL,1),(68,'1103','NX-BTA CENTRO','ZHD2',NULL,NULL,NULL,1),(69,'1104','Botica Centro Viejo','ZHD2',NULL,NULL,NULL,1),(70,'1105','NX-BTA RESTREPO','ZHD2',NULL,NULL,NULL,1),(71,'1106','NX-BTA FONTIBON','ZHD2',NULL,NULL,NULL,1),(72,'1107','Botica Chapinero','ZHD2',NULL,NULL,NULL,1),(73,'1108','Botica Montería','ZHD2',NULL,NULL,NULL,1),(74,'1109','Botica Sincelejo','ZHD2',NULL,NULL,NULL,1),(75,'1110','Botica Cartagena','ZHD2',NULL,NULL,NULL,1),(76,'1111','Botica Barranquilla','ZHD2',NULL,NULL,NULL,1),(77,'1112','Botica Santamarta','ZHD2',NULL,NULL,NULL,1),(78,'1113','NX-VALLEDUPAR','ZHD2',NULL,NULL,NULL,1),(79,'1114','Botica Cali','ZHD2',NULL,NULL,NULL,1),(80,'1115','Botica Popayán','ZHD2',NULL,NULL,NULL,1),(81,'1116','Botica Pasto','ZHD2',NULL,NULL,NULL,1),(82,'1117','Botica Tulúa','ZHD2',NULL,NULL,NULL,1),(83,'1118','Botica Palmira','ZHD2',NULL,NULL,NULL,1),(84,'1119','Botica Buga','ZHD2',NULL,NULL,NULL,1),(85,'1120','Botica Ibagué','ZHD2',NULL,NULL,NULL,1),(86,'1121','Botica Neiva','ZHD2',NULL,NULL,NULL,1),(87,'1122','Botica V/cencio','ZHD2',NULL,NULL,NULL,1),(88,'1123','Botica Villeta','ZHD2',NULL,NULL,NULL,1),(89,'1124','Botica Cúcuta','ZHD2',NULL,NULL,NULL,1),(90,'1125','Botica Bucaramanga','ZHD2',NULL,NULL,NULL,1),(91,'1126','Botica Tunja','ZHD2',NULL,NULL,NULL,1),(92,'1127','Botica Chiquinquira','ZHD2',NULL,NULL,NULL,1),(93,'1128','Botica Medellín','ZHD2',NULL,NULL,NULL,1),(94,'1129','Botica Pereira','ZHD2',NULL,NULL,NULL,1),(95,'1130','Botica Manizales','ZHD2',NULL,NULL,NULL,1),(96,'1131','Botica Armenia','ZHD2',NULL,NULL,NULL,1),(97,'1132','Botica Girardot','ZHD2',NULL,NULL,NULL,1),(98,'1133','Botica Duitama','ZHD2',NULL,NULL,NULL,1),(99,'1134','Botica Pamplona','ZHD2',NULL,NULL,NULL,1),(100,'1135','Botica Leticia','ZHD2',NULL,NULL,NULL,1),(101,'1136','Botica San Andres','ZHD2',NULL,NULL,NULL,1),(102,'1137','Botica Riohacha','ZHD2',NULL,NULL,NULL,1),(103,'1138','Botica Pitalito','ZHD2',NULL,NULL,NULL,1),(104,'1139','Botica Barranca','ZHD2',NULL,NULL,NULL,1),(105,'1140','Botica Mompos','ZHD2',NULL,NULL,NULL,1),(106,'1141','Botica Pie De Cuesta','ZHD2',NULL,NULL,NULL,1),(107,'1142','N. Express Americas','ZHD2',NULL,NULL,NULL,1),(108,'1144','N. Express Itagui','ZHD2',NULL,NULL,NULL,1),(109,'1149','NX-MAGANGUE','ZHD2',NULL,NULL,NULL,1),(110,'1154','NX-SAN JOSE GUAV','ZHD2',NULL,NULL,NULL,1),(111,'1155','NX-PIE DE CUESTA','ZHD2',NULL,NULL,NULL,1),(112,'1200','VD-BARRANQUILLA','ZHD2',NULL,NULL,NULL,1),(113,'1201','VD-BUCARAMANGA','ZHD2',NULL,NULL,NULL,1),(114,'1202','AD Neiva','ZHD2',NULL,NULL,NULL,1),(115,'1203','VD-CALI','ZHD2',NULL,NULL,NULL,1),(116,'1204','VD-BOGOTA','ZHD2',NULL,NULL,NULL,1),(117,'1300','VN-BOGOTA','ZHD2',NULL,NULL,NULL,1),(118,'1400','CC-BOGOTA','ZHD2',NULL,NULL,NULL,1),(119,'1401','Affinity Bogotá','ZHD2',NULL,NULL,NULL,1),(120,'1500','BS Bogotá','ZHD2',NULL,NULL,NULL,1),(121,'1501','BS Itagui','ZHD2',NULL,NULL,NULL,1),(122,'1999','Otras Vtas Affinity','ZHD2',NULL,NULL,NULL,1),(123,'2000','Axioma Bogotá','ZHD2',NULL,NULL,NULL,1),(124,'2110','NZ-CUCUTA','ZHD2',NULL,NULL,NULL,1),(125,'2999','Otras Vtas Axioma','ZHD2',NULL,NULL,NULL,1),(126,'3000','Clinica Valle Nueva','ZHD2',NULL,NULL,NULL,1),(127,'3001','Productos OTC','ZHD2',NULL,NULL,NULL,1),(128,'3002','Clinica Puebla','ZHD2',NULL,NULL,NULL,1),(129,'3003','Clinica Cuernavaca','ZHD2',NULL,NULL,NULL,1),(130,'3004','Clinica Toluca','ZHD2',NULL,NULL,NULL,1),(131,'3005','Clinica Queretaro','ZHD2',NULL,NULL,NULL,1),(132,'3006','Clinica Xalapa','ZHD2',NULL,NULL,NULL,1),(133,'3400','Call Mexico DF','ZHD2',NULL,NULL,NULL,1),(134,'3999','Otras Vtas Mexico','ZHD2',NULL,NULL,NULL,1),(135,'4001','NZ-7 DE AGOSTO','ZHD2',NULL,NULL,NULL,1),(136,'4002','NZ-BARRANQUILLA','ZHD2',NULL,NULL,NULL,1),(137,'4003','NZ-BTA. CALLE 75','ZHD2',NULL,NULL,NULL,1),(138,'4004','NZ-BTA. CALLE 94','ZHD2',NULL,NULL,NULL,1),(139,'4005','NZ-BTA. VENECIA','ZHD2',NULL,NULL,NULL,1),(140,'4006','NZ-BUCARAMANGA','ZHD2',NULL,NULL,NULL,1),(141,'4007','NZ-CALI','ZHD2',NULL,NULL,NULL,1),(142,'4008','NZ-CARTAGENA','ZHD2',NULL,NULL,NULL,1),(143,'4009','NZ-CHIQUINQUIRA','ZHD2',NULL,NULL,NULL,1),(144,'4010','NZ-CUCUTA','ZHD2',NULL,NULL,NULL,1),(145,'4011','NZ-IBAGUE','ZHD2',NULL,NULL,NULL,1),(146,'4012','NZ-MEDELLIN','ZHD2',NULL,NULL,NULL,1),(147,'4013','NZ-MONTERIA','ZHD2',NULL,NULL,NULL,1),(148,'4014','NZ-NEIVA','ZHD2',NULL,NULL,NULL,1),(149,'4015','NZ-PALMIRA','ZHD2',NULL,NULL,NULL,1),(150,'4016','NZ-PASTO','ZHD2',NULL,NULL,NULL,1),(151,'4017','NZ-PEREIRA','ZHD2',NULL,NULL,NULL,1),(152,'4018','NZ-POPAYAN','ZHD2',NULL,NULL,NULL,1),(153,'4019','NZ-SANTA MARTA','ZHD2',NULL,NULL,NULL,1),(154,'4020','NZ-TULUA','ZHD2',NULL,NULL,NULL,1),(155,'4021','NZ-TUNJA','ZHD2',NULL,NULL,NULL,1),(156,'4022','NZ-VALLEDUPAR','ZHD2',NULL,NULL,NULL,1),(157,'4023','NZ-VILLAVICENCIO','ZHD2',NULL,NULL,NULL,1),(158,'4024','NZ-VILLETA','ZHD2',NULL,NULL,NULL,1),(159,'4025','CC-BOGOTA','ZHD2',NULL,NULL,NULL,1),(160,'4026','NX-VALLEDUPAR','ZHD2',NULL,NULL,NULL,1),(161,'4027','NZ-RIONEGRO','ZHD2',NULL,NULL,NULL,1),(162,'4028','NZ-APARTADO','ZHD2',NULL,NULL,NULL,1),(163,'4029','NX-BTA ALCAZARES','ZHD2',NULL,NULL,NULL,1),(164,'4030','NX-BTA CENTRO','ZHD2',NULL,NULL,NULL,1),(165,'4031','NX-BTA FONTIBON','ZHD2',NULL,NULL,NULL,1),(166,'4032','NX-BTA RESTREPO','ZHD2',NULL,NULL,NULL,1),(167,'4033','NX-BTA SUBA','ZHD2',NULL,NULL,NULL,1),(168,'4034','NX-BUGA','ZHD2',NULL,NULL,NULL,1),(169,'4035','NX-ESPINAL','ZHD2',NULL,NULL,NULL,1),(170,'4036','NX-MAGANGUE','ZHD2',NULL,NULL,NULL,1),(171,'4037','NX-OCANA','ZHD2',NULL,NULL,NULL,1),(172,'4038','NX-PIE DE CUESTA','ZHD2',NULL,NULL,NULL,1),(173,'4039','NX-RIOHACHA','ZHD2',NULL,NULL,NULL,1),(174,'4040','NX-SAN JOSE GUAV','ZHD2',NULL,NULL,NULL,1),(175,'4041','NX-SINCELEJO','ZHD2',NULL,NULL,NULL,1),(176,'4042','NX-STDER QUILICH','ZHD2',NULL,NULL,NULL,1),(177,'4043','NX-TUMACO','ZHD2',NULL,NULL,NULL,1),(178,'4044','VD-BARRANQUILLA','ZHD2',NULL,NULL,NULL,1),(179,'4045','VD-BOGOTA','ZHD2',NULL,NULL,NULL,1),(180,'4046','VD-BUCARAMANGA','ZHD2',NULL,NULL,NULL,1),(181,'4047','VD-CALI','ZHD2',NULL,NULL,NULL,1),(182,'4048','VD-MEDELLIN','ZHD2',NULL,NULL,NULL,1),(183,'4049','VN-BOGOTA','ZHD2',NULL,NULL,NULL,1),(184,'4050','VN-CALI','ZHD2',NULL,NULL,NULL,1);
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
INSERT INTO `crm_role` VALUES (1,'ADMINISTRADOR','Administrador',8,1),(2,'CALL_CENTER','',17,1),(3,'GERENCIA','',12,1),(4,'MEDICO','MEDICO',22,1);
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
  `id_branch` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_crm_doctor_schedule_1` (`id_doctor`),
  KEY `fk_crm_doctor_schedule_2` (`id_branch`),
  CONSTRAINT `fk_crm_doctor_schedule_1` FOREIGN KEY (`id_doctor`) REFERENCES `crm_doctor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_crm_doctor_schedule_2` FOREIGN KEY (`id_branch`) REFERENCES `crm_branch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_doctor_schedule`
--

LOCK TABLES `crm_doctor_schedule` WRITE;
/*!40000 ALTER TABLE `crm_doctor_schedule` DISABLE KEYS */;
INSERT INTO `crm_doctor_schedule` VALUES (18,7,2,'08:00:00','17:30:00',2),(19,7,3,'08:00:00','17:30:00',2),(20,7,4,'08:00:00','17:30:00',2),(21,7,5,'08:00:00','17:30:00',2),(22,7,6,'08:00:00','17:30:00',2),(23,9,2,'08:00:00','17:30:00',2),(24,9,3,'08:00:00','17:30:00',2),(25,9,4,'08:00:00','17:30:00',2),(26,9,5,'08:00:00','17:30:00',2),(27,9,6,'08:00:00','17:30:00',2),(28,9,7,'08:00:00','17:30:00',2),(29,6,2,'08:00:00','17:30:00',3),(30,6,3,'08:00:00','17:30:00',3),(31,6,4,'08:00:00','17:30:00',3),(32,6,5,'08:00:00','17:30:00',3),(33,6,6,'08:00:00','17:30:00',3),(34,6,7,'08:00:00','17:30:00',3),(35,5,2,'08:00:00','17:30:00',6),(36,5,3,'08:00:00','17:30:00',6),(37,5,4,'08:00:00','17:30:00',6),(38,5,5,'08:00:00','17:30:00',6),(39,5,6,'08:00:00','17:30:00',6),(40,5,7,'08:00:00','17:30:00',6),(41,8,6,'08:00:00','12:00:00',1),(42,8,5,'08:00:00','17:00:00',137);
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
INSERT INTO `crm_procedure_detail` VALUES (1,'Primera Cita',1,30,0,0,1),(2,'Control',2,15,0,0,0),(3,'Terapia 1',3,45,45,45,1),(4,'Terapia 2',3,50,50,50,1);
/*!40000 ALTER TABLE `crm_procedure_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_consultation`
--

DROP TABLE IF EXISTS `crm_consultation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_consultation` (
  `id` decimal(19,0) NOT NULL,
  `id_patient` decimal(19,0) NOT NULL,
  `review` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `date` date NOT NULL,
  `id_doctor` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_consultation`
--

LOCK TABLES `crm_consultation` WRITE;
/*!40000 ALTER TABLE `crm_consultation` DISABLE KEYS */;
/*!40000 ALTER TABLE `crm_consultation` ENABLE KEYS */;
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
-- Table structure for table `crm_history_physique`
--

DROP TABLE IF EXISTS `crm_history_physique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_history_physique` (
  `id` decimal(19,0) NOT NULL,
  `id_patient` decimal(19,0) NOT NULL,
  `physique_ta` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `physique_fc` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `physique_fr` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `physique_to` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `physique_size` decimal(5,2) DEFAULT NULL,
  `physique_weight` decimal(5,2) DEFAULT NULL,
  `general_state` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `skull` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `chest` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `lungs` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `heart` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `abdomen` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `genitals` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `tips` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `highlights` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `skin` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `review` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_patient_UNIQUE` (`id_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_history_physique`
--

LOCK TABLES `crm_history_physique` WRITE;
/*!40000 ALTER TABLE `crm_history_physique` DISABLE KEYS */;
/*!40000 ALTER TABLE `crm_history_physique` ENABLE KEYS */;
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
INSERT INTO `crm_holiday` VALUES (1,'Festivo','2012-06-18'),(2,'Festivo 11/06','2012-06-11');
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
  `names` varchar(45),
  `id_branch` decimal(19,0),
  `day` int(11)
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

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
INSERT INTO `crm_page` VALUES (1,'Seguridad',NULL,'ui-icon-document',NULL,1),(2,'Tablas',NULL,'ui-icon-gear',NULL,2),(3,'Usuarios','/pages/secure/user.jsf',NULL,1,2),(4,'Roles','/pages/secure/role.jsf',NULL,1,1),(5,'Doctor','/pages/tables/doctor.jsf',NULL,2,1),(6,'Parámetros','/pages/tables/parameter.jsf',NULL,2,2),(7,'Especialdades','/pages/tables/speciality.jsf',NULL,2,3),(8,'Pacientes','/pages/processes/patient.jsf',NULL,11,1),(9,'Perfiles','/pages/tables/profile.jsf',NULL,2,5),(10,'Cambiar Clave','/pages/secure/changePassword.jsf',NULL,1,3),(11,'Procesos',NULL,'ui-icon-contact',NULL,3),(12,'Crear Pedido','/pages/processes/salesOrder.jsf',NULL,11,3),(13,'Sucursales','/pages/tables/branch.jsf',NULL,2,4),(14,'Departamentos','/pages/tables/department.jsf',NULL,2,6),(15,'Agenda',NULL,'ui-icon-calendar',NULL,4),(16,'Procedimientos','/pages/tables/procedure.jsf',NULL,2,7),(17,'Crear Cita','/pages/processes/appointment.jsf',NULL,15,1),(18,'Cancelar Cita','/pages/processes/appointmentCancel.jsf',NULL,15,2),(19,'Chequear Cita','/pages/processes/appointmentCheck.jsf',NULL,15,3),(20,'Días No Hábiles','/pages/tables/holiday.jsf',NULL,2,8),(21,'Días No Trabajados','/pages/tables/exception.jsf',NULL,2,9),(22,'Búsqueda Por Paciente','/pages/processes/searchByPatient.jsf',NULL,15,10),(23,'Vistas',NULL,'ui-icon-bookmark',NULL,5),(24,'Vista Por Médico','/pages/views/viewDoctor.jsf',NULL,23,1),(25,'Vista Por Sucursal','/pages/views/viewBranch.jsf',NULL,23,2),(26,'Paciente - Otros Datos','/pages/processes/patientComplementary.jsf',NULL,11,2),(27,'Historia Clínica','/pages/processes/history.jsf',NULL,11,3);
/*!40000 ALTER TABLE `crm_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crm_history_history`
--

DROP TABLE IF EXISTS `crm_history_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crm_history_history` (
  `id` decimal(19,0) NOT NULL,
  `id_patient` decimal(19,0) NOT NULL,
  `reason` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `disease` varchar(1000) COLLATE latin1_spanish_ci DEFAULT NULL,
  `head` varchar(1) COLLATE latin1_spanish_ci DEFAULT NULL,
  `orl` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `cr` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `gi` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `neuromuscular` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `gu` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `psychiatric` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  `skin` varchar(1) COLLATE latin1_spanish_ci DEFAULT 'N',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_patient_UNIQUE` (`id_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crm_history_history`
--

LOCK TABLES `crm_history_history` WRITE;
/*!40000 ALTER TABLE `crm_history_history` DISABLE KEYS */;
INSERT INTO `crm_history_history` VALUES (1,5,'DOLOR DE CABEZA','MIGRAA','N','N','P','N','P','N','N','P'),(2,6,'','','N','N','N','N','N','N','N','N');
/*!40000 ALTER TABLE `crm_history_history` ENABLE KEYS */;
UNLOCK TABLES;

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
/*!50001 VIEW `vw_doctor_schedule` AS select distinct `a`.`id` AS `id_doctor`,`a`.`names` AS `names`,`b`.`id_branch` AS `id_branch`,`b`.`day` AS `day` from (`crm_doctor` `a` join `crm_doctor_schedule` `b` on((`b`.`id_doctor` = `a`.`id`))) where (`a`.`state` = 1) */;
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

-- Dump completed on 2012-06-22  7:13:43
