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
-- Table structure for table `tb_book`
--

DROP TABLE IF EXISTS `tb_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_book` (
  `id_book` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(100) NOT NULL,
  `book_author` varchar(100) NOT NULL,
  `book_publisher` varchar(100) NOT NULL,
  `quantity_of_book` int(11) NOT NULL,
  `image_book` varbinary(55530) NOT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `acquired` varchar(11) NOT NULL,
  PRIMARY KEY (`id_book`),
  UNIQUE KEY `book_publisher` (`book_publisher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_book`
--

LOCK TABLES `tb_book` WRITE;
/*!40000 ALTER TABLE `tb_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `access_level` int(11) NOT NULL,
  `image` varbinary(55530) NOT NULL,
  `email` tinytext,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_password` (`user_password`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `tbaluguel_ibfk_1` FOREIGN KEY (`idlivro`) REFERENCES `tb_book` (`id_book`),
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

-- Dump completed on 2020-06-10 16:46:26
