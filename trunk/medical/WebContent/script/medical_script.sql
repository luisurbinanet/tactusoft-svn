CREATE DATABASE  IF NOT EXISTS `medical_db` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `medical_db`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: medical_db
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
-- Table structure for table `med_user`
--

DROP TABLE IF EXISTS `med_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_user` (
  `id` decimal(19,0) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_role` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kpi_user_1` (`id_role`),
  CONSTRAINT `fk_med_user_1` FOREIGN KEY (`id_role`) REFERENCES `med_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_user`
--

LOCK TABLES `med_user` WRITE;
/*!40000 ALTER TABLE `med_user` DISABLE KEYS */;
INSERT INTO `med_user` VALUES (1,'gsolorzano','123','Gerardo','','Solorzano',NULL,1);
/*!40000 ALTER TABLE `med_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_combination`
--

DROP TABLE IF EXISTS `med_combination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_combination` (
  `id` decimal(19,0) NOT NULL,
  `id_group` int(11) DEFAULT NULL,
  `id_question` decimal(19,0) NOT NULL,
  `id_answer` decimal(19,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_med_combination_1` (`id_question`),
  KEY `fk_med_combination_2` (`id_answer`),
  CONSTRAINT `fk_med_combination_2` FOREIGN KEY (`id_answer`) REFERENCES `med_answer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_med_combination_1` FOREIGN KEY (`id_question`) REFERENCES `med_question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_combination`
--

LOCK TABLES `med_combination` WRITE;
/*!40000 ALTER TABLE `med_combination` DISABLE KEYS */;
INSERT INTO `med_combination` VALUES (1,1,25,3),(2,1,25,5),(3,2,25,4);
/*!40000 ALTER TABLE `med_combination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_topic`
--

DROP TABLE IF EXISTS `med_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_topic` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) COLLATE latin1_spanish_ci NOT NULL,
  `image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `state` int(5) NOT NULL DEFAULT '1',
  `num_version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_topic`
--

LOCK TABLES `med_topic` WRITE;
/*!40000 ALTER TABLE `med_topic` DISABLE KEYS */;
INSERT INTO `med_topic` VALUES (1,'Depresión Postparto','topic1.jpeg',1,1),(2,'Problemas de Lactancia','topic2.jpeg',1,1),(3,'Micción Frecuente','topic3.jpeg',1,1),(4,'Preclancia','topic4.jpeg',1,1),(5,'Hipertension','topic5.jpeg',1,1);
/*!40000 ALTER TABLE `med_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_answer`
--

DROP TABLE IF EXISTS `med_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_answer` (
  `id` decimal(19,0) NOT NULL,
  `name` text COLLATE latin1_spanish_ci NOT NULL,
  `id_question` decimal(19,0) NOT NULL,
  `next_question` decimal(19,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_med_answer_1` (`id_question`),
  CONSTRAINT `fk_med_answer_1` FOREIGN KEY (`id_question`) REFERENCES `med_question` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_answer`
--

LOCK TABLES `med_answer` WRITE;
/*!40000 ALTER TABLE `med_answer` DISABLE KEYS */;
INSERT INTO `med_answer` VALUES (1,'Opcion 1',22,5),(2,'Opción 2',22,4),(3,'R1',24,-1),(4,'R2',24,-1),(5,'R3',24,-1);
/*!40000 ALTER TABLE `med_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_question`
--

DROP TABLE IF EXISTS `med_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_question` (
  `id` decimal(19,0) NOT NULL,
  `name` text COLLATE latin1_spanish_ci NOT NULL,
  `id_topic` decimal(19,0) NOT NULL,
  `type_question` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `resource_type` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `url_link` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `type_video` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `load_mode` varchar(15) COLLATE latin1_spanish_ci DEFAULT NULL,
  `positive` decimal(19,0) DEFAULT NULL,
  `negative` decimal(19,0) DEFAULT NULL,
  `order_question` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_med_question_1` (`id_topic`),
  CONSTRAINT `fk_med_question_1` FOREIGN KEY (`id_topic`) REFERENCES `med_topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_question`
--

LOCK TABLES `med_question` WRITE;
/*!40000 ALTER TABLE `med_question` DISABLE KEYS */;
INSERT INTO `med_question` VALUES (1,'Hace menos de una semana que ha tenido un hijo',1,'ASSERTIVE',NULL,NULL,NULL,NULL,'',2,3,1),(2,'La DEPRESIÓN AL TERCER DÍA es el nombre mas común para este sentimiento de tristeza y depresión que afecta a muchas mujeres en los 7 días siguientes al parto',1,'FINAL','IMAGE',NULL,'question2.jpeg',NULL,'',-1,-1,2),(3,'Se siente bien la mayor parte del tiempo pero a veces se siente deprimida e irritable',1,'ASSERTIVE',NULL,'',NULL,NULL,'',4,22,3),(4,'Los periodos de DEPRESIÓN e IRRITABILIDAD son comunes en los meses siguientes al nacimiento del niño. Al mismo tiempo que se ve afectada por los cambios hormonales y posibles sentimientos contradictorios, también es posible que se encuentre cansada y preocupada por su responsabilidad maternal o por el desarrollo general del niño',1,'FINAL','VIDEO','http://www.youtube.com/v/f5_ZFg0mIvI',NULL,'flash','ON_LINE',-1,-1,4),(5,'La DEPRESIÓN POSTPARTO es un problema que afecta madres primerizas en los primeros 6 meses después del parto',1,'FINAL','LINK','http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto',NULL,NULL,'',-1,-1,5),(9,'Siente dolor o malestar al orinar',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',11,10,1),(10,'Cuando va a orinar lo hace en grandes cantidades y de color palido',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',12,13,2),(11,'Ver Tabla',3,'FINAL','LINK','',NULL,NULL,'',-1,-1,3),(12,'Tiene mucho frío y se siente tensa',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',20,-1,4),(13,'Has notado algunos de los siguientes síntomas: Aumento de la sed, perdida de peso, cansancio, prurito genital',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',14,15,5),(14,'La Diabetes MELLITUS es una posibilidad, este problema es provocado por una producción insuficiente de insulina (hormona que ayuda a convertir el azucar)',3,'FINAL','IMAGE',NULL,'question14.jpeg',NULL,'OFF_LINE',-1,-1,6),(15,'Ha Bebido más cafe de lo habitual',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',16,17,7),(16,'El Alcohol y la Cafeína puede alimentar la producción de Orina',3,'FINAL','IMAGE',NULL,'question16.jpeg',NULL,'OFF_LINE',-1,-1,8),(17,'Está siguiendo algún tratamiento con fármacos',3,'ASSERTIVE',NULL,NULL,NULL,NULL,'',18,12,9),(18,'Ciertos Fármacos, sobre todo los que se utilizan para prevenir la retención de líquidos, provoca el aumento de la producción de orina.\r\n\r\nCONSULTE A SU MEDICO!',3,'FINAL','LINK','http://affinitycolombia.com/web_affinity/',NULL,NULL,'',-1,-1,10),(19,'Consulte a su médico sino puede hacer un diagnostico a partir de esta tabla',3,'FINAL','IMAGE',NULL,'question19.png',NULL,'OFF_LINE',-1,-1,11),(20,'El frío o la excitación puede provocar un aumento en la frecuencia en la micción, pero esto no es motivo de preocupación.',3,'FINAL','IMAGE',NULL,'question20.png',NULL,'OFF_LINE',9,11,12),(21,'qqqqq',3,'ASSERTIVE','IMAGE',NULL,NULL,NULL,'OFF_LINE',9,10,13),(22,'Escoja una Respuesta',1,'UNIQUE','IMAGE',NULL,NULL,NULL,'OFF_LINE',-1,-1,6),(23,'Prueba',1,'FINAL','IMAGE',NULL,'question23.png',NULL,'OFF_LINE',-1,-1,7),(24,'SELECCIÓN MÚLTIPLE',5,'MULTIPLE','IMAGE',NULL,NULL,NULL,'ON_LINE',-1,-1,1),(25,'Pregunta 2',5,'MESSAGE','IMAGE',NULL,NULL,NULL,'ON_LINE',-1,-1,2);
/*!40000 ALTER TABLE `med_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_parameter`
--

DROP TABLE IF EXISTS `med_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_parameter` (
  `id` decimal(19,0) NOT NULL,
  `code` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `value_text` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `value_number` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_parameter`
--

LOCK TABLES `med_parameter` WRITE;
/*!40000 ALTER TABLE `med_parameter` DISABLE KEYS */;
INSERT INTO `med_parameter` VALUES (1,'URL_IMAGES','http://localhost:8080/images/',NULL),(2,'DIRECTORY_IMAGES','C:\\affinity\\medical\\',NULL);
/*!40000 ALTER TABLE `med_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `med_role`
--

DROP TABLE IF EXISTS `med_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `med_role` (
  `id` decimal(19,0) NOT NULL,
  `name` varchar(255) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `med_role`
--

LOCK TABLES `med_role` WRITE;
/*!40000 ALTER TABLE `med_role` DISABLE KEYS */;
INSERT INTO `med_role` VALUES (1,'ADMIN',1);
/*!40000 ALTER TABLE `med_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-15  7:59:30
