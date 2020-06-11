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
-- Table structure for table `tb_rent`
--

DROP TABLE IF EXISTS `tb_rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_rent` (
  `id_rent` int(11) NOT NULL AUTO_INCREMENT,
  `rented_date` date NOT NULL,
  `id_of_book` int(11) NOT NULL,
  `id_of_client` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `returned` tinyint(1) NOT NULL,
  `penality` double DEFAULT NULL,
  `observation` text,
  PRIMARY KEY (`id_rent`),
  KEY `idlivro` (`id_of_book`),
  KEY `idcli` (`id_of_client`),
  CONSTRAINT `tb_rent_ibfk_1` FOREIGN KEY (`id_of_book`) REFERENCES `tb_book` (`id_book`),
  CONSTRAINT `tb_rent_ibfk_2` FOREIGN KEY (`id_of_client`) REFERENCES `tb_student` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rent`
--

LOCK TABLES `tb_rent` WRITE;
/*!40000 ALTER TABLE `tb_rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_student`
--

DROP TABLE IF EXISTS `tb_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_student` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `student_registration` varchar(100) NOT NULL,
  `student_email` tinytext,
  `student_phone` varchar(30) DEFAULT NULL,
  `student_CEP` tinytext,
  `student_city` tinytext NOT NULL,
  `student_module` varchar(45) NOT NULL,
  `student_grade` varchar(100) NOT NULL,
  `student_course` varchar(100) DEFAULT NULL,
  `student_school` tinytext NOT NULL,
  `student_shift` varchar(25) NOT NULL,
  `student_login` varchar(100) NOT NULL,
  `student_password` varchar(100) NOT NULL,
  `student_image_perfil` varbinary(55530) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `senha` (`student_password`),
  UNIQUE KEY `student_password` (`student_password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_student`
--

LOCK TABLES `tb_student` WRITE;
/*!40000 ALTER TABLE `tb_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_student` ENABLE KEYS */;
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
  `user_login` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_access_level` int(11) NOT NULL,
  `user_image_perfil` varbinary(55530) NOT NULL,
  `user_email` tinytext,
  `user_address` tinytext NOT NULL,
  `user_cep` varchar(30) DEFAULT NULL,
  `user_phone` varchar(30) DEFAULT NULL,
  `user_school` varchar(100) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `user_password` (`user_password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
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

-- Dump completed on 2020-06-11 15:46:48
