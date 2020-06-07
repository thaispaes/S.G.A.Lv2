CREATE DATABASE  IF NOT EXISTS `dbbiblio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dbbiblio`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: dbbiblio
-- ------------------------------------------------------
-- Server version	5.7.28

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
-- Table structure for table `tbaluguel`
--

DROP TABLE IF EXISTS `tbaluguel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbaluguel` (
  `idaluguel` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataaluguel` date DEFAULT NULL,
  `idlivro` int(11) DEFAULT NULL,
  `idcli` int(11) DEFAULT NULL,
  `alugado` date DEFAULT NULL,
  `prazo` date DEFAULT NULL,
  `entregue` tinyint(1) DEFAULT NULL,
  `penalidade` double DEFAULT NULL,
  PRIMARY KEY (`idaluguel`),
  KEY `idlivro` (`idlivro`),
  KEY `idcli` (`idcli`),
  CONSTRAINT `tbaluguel_ibfk_1` FOREIGN KEY (`idlivro`) REFERENCES `tblivros` (`idlivro`),
  CONSTRAINT `tbaluguel_ibfk_2` FOREIGN KEY (`idcli`) REFERENCES `tbcliente` (`idcli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbaluguel`
--

LOCK TABLES `tbaluguel` WRITE;
/*!40000 ALTER TABLE `tbaluguel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbaluguel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcliente`
--

DROP TABLE IF EXISTS `tbcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcliente` (
  `idcli` int(11) NOT NULL AUTO_INCREMENT,
  `nomecli` varchar(100) NOT NULL,
  `matriculacli` varchar(100) DEFAULT NULL,
  `emailcli` varchar(100) DEFAULT NULL,
  `fonecli` varchar(100) NOT NULL,
  `enderecocli` varchar(200) DEFAULT NULL,
  `cidadecli` varchar(70) NOT NULL,
  `modulocli` varchar(100) DEFAULT NULL,
  `seriecli` varchar(50) DEFAULT NULL,
  `cursocli` varchar(100) DEFAULT NULL,
  `escola` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idcli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcliente`
--

LOCK TABLES `tbcliente` WRITE;
/*!40000 ALTER TABLE `tbcliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblivros`
--

DROP TABLE IF EXISTS `tblivros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tblivros` (
  `idlivro` int(11) NOT NULL AUTO_INCREMENT,
  `nomelivro` varchar(100) NOT NULL,
  `autorlivro` varchar(100) NOT NULL,
  `editoratlivro` varchar(100) NOT NULL,
  `quantidadelivro` varchar(100) DEFAULT NULL,
  `imagelivro` longblob,
  `genero` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idlivro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblivros`
--

LOCK TABLES `tblivros` WRITE;
/*!40000 ALTER TABLE `tblivros` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblivros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbuser`
--

DROP TABLE IF EXISTS `tbuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `loguin` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `tipo` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbuser`
--

LOCK TABLES `tbuser` WRITE;
/*!40000 ALTER TABLE `tbuser` DISABLE KEYS */;
INSERT INTO `tbuser` VALUES (1,'Administrador','admin','admin','User');
/*!40000 ALTER TABLE `tbuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbbiblio'
--

--
-- Dumping routines for database 'dbbiblio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-07 17:07:31
