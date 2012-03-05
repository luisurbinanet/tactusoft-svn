CREATE DATABASE  IF NOT EXISTS `kpi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kpi`;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-05  7:09:44
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
  `url_image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `type_video` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  `url_video` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_parent` decimal(19,0) DEFAULT NULL,
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
INSERT INTO `med_question` VALUES (1,'Hace menos de una semana que ha tenido un hijo',1,'ASSERTIVE',NULL,NULL,NULL,0,2,3,1),(2,'La DEPRESIÓN AL TERCER DÍA es el nombre mas común para este sentimiento de tristeza y depresión que afecta a muchas mujeres en los 7 días siguientes al parto',1,'FINAL',NULL,NULL,'http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto',1,NULL,NULL,2),(3,'Se siente bien la mayor parte del tiempo pero a veces se siente deprimida e irritable',1,'ASSERTIVE',NULL,NULL,NULL,1,4,5,3),(4,'Los periodos de DEPRESION e IRRITABILIDAD son comunes en los meses siguientes al nacimiento del niño. Al mismo tiempo que se ve afectada por los cambios hormonales y pósibles sentimientos contradictorios, también es posible que se encuentre cansada y preocupada por su responsabilidad maternal o por el desarrollo general del niño',1,'FINAL',NULL,NULL,'http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto',2,NULL,NULL,4),(5,'La DEPRESIÓN POSTPARTO es un problema que afecta madres primerizas en los primeros 6 meses después del parto',1,'FINAL',NULL,NULL,'http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto',2,NULL,NULL,5),(6,'P1',1,'ASSERTIVE',NULL,NULL,NULL,1,7,8,6),(7,'R1',1,'FINAL',NULL,NULL,NULL,6,NULL,NULL,7),(8,'R2',1,'FINAL',NULL,NULL,NULL,6,NULL,NULL,8),(9,'nnbncv',1,'ASSERTIVE',NULL,NULL,NULL,1,NULL,NULL,9);
/*!40000 ALTER TABLE `med_question` ENABLE KEYS */;
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
  `url_image` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
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
INSERT INTO `med_topic` VALUES (1,'Depresión Postparto',NULL,1,1),(2,'Problemas de Lactancia',NULL,1,1),(3,'Micción Frecuente',NULL,1,1);
/*!40000 ALTER TABLE `med_topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-03-05  7:09:44
