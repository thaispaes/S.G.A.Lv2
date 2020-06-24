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
-- Temporary view structure for view `book_view`
--

DROP TABLE IF EXISTS `book_view`;
/*!50001 DROP VIEW IF EXISTS `book_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `book_view` AS SELECT 
 1 AS `id_book`,
 1 AS `book_name`,
 1 AS `book_author`,
 1 AS `book_publisher`,
 1 AS `book_stock`,
 1 AS `book_genre`,
 1 AS `book_acquired_date`,
 1 AS `id_images`,
 1 AS `image_name`,
 1 AS `image_bytes`,
 1 AS `image_way`,
 1 AS `id_image_book`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `client_view`
--

DROP TABLE IF EXISTS `client_view`;
/*!50001 DROP VIEW IF EXISTS `client_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `client_view` AS SELECT 
 1 AS `client_name`,
 1 AS `client_CEP`,
 1 AS `client_address`,
 1 AS `client_phone`,
 1 AS `cliente_login`,
 1 AS `client_password`,
 1 AS `client_image_perfil`,
 1 AS `client_email`,
 1 AS `id_client`,
 1 AS `id_images`,
 1 AS `image_name`,
 1 AS `image_bytes`,
 1 AS `image_way`,
 1 AS `id_image_book`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `data_of_rents_view`
--

DROP TABLE IF EXISTS `data_of_rents_view`;
/*!50001 DROP VIEW IF EXISTS `data_of_rents_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `data_of_rents_view` AS SELECT 
 1 AS `id_rent`,
 1 AS `rented_date`,
 1 AS `id_of_book`,
 1 AS `id_of_student`,
 1 AS `return_date`,
 1 AS `rent_returned`,
 1 AS `rent_penality`,
 1 AS `rent_observation`,
 1 AS `id_of_client`,
 1 AS `client_name`,
 1 AS `client_CEP`,
 1 AS `client_address`,
 1 AS `client_phone`,
 1 AS `cliente_login`,
 1 AS `client_password`,
 1 AS `client_image_perfil`,
 1 AS `client_email`,
 1 AS `id_client`,
 1 AS `id_student`,
 1 AS `student_name`,
 1 AS `student_registration`,
 1 AS `student_email`,
 1 AS `student_phone`,
 1 AS `student_CEP`,
 1 AS `student_address`,
 1 AS `student_module`,
 1 AS `student_grade`,
 1 AS `student_course`,
 1 AS `student_school`,
 1 AS `student_shift`,
 1 AS `student_login`,
 1 AS `student_password`,
 1 AS `student_image_perfil`,
 1 AS `id_book`,
 1 AS `book_name`,
 1 AS `book_author`,
 1 AS `book_publisher`,
 1 AS `book_stock`,
 1 AS `book_genre`,
 1 AS `book_acquired_date`,
 1 AS `id_images`,
 1 AS `image_name`,
 1 AS `image_bytes`,
 1 AS `image_way`,
 1 AS `id_image_book`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `student_view`
--

DROP TABLE IF EXISTS `student_view`;
/*!50001 DROP VIEW IF EXISTS `student_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `student_view` AS SELECT 
 1 AS `id_student`,
 1 AS `student_name`,
 1 AS `student_registration`,
 1 AS `student_email`,
 1 AS `student_phone`,
 1 AS `student_CEP`,
 1 AS `student_address`,
 1 AS `student_module`,
 1 AS `student_grade`,
 1 AS `student_course`,
 1 AS `student_school`,
 1 AS `student_shift`,
 1 AS `student_login`,
 1 AS `student_password`,
 1 AS `student_image_perfil`,
 1 AS `id_images`,
 1 AS `image_name`,
 1 AS `image_bytes`,
 1 AS `image_way`,
 1 AS `id_image_book`*/;
SET character_set_client = @saved_cs_client;

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
  `book_stock` int(11) NOT NULL,
  `book_genre` varchar(45) DEFAULT NULL,
  `book_acquired_date` date NOT NULL,
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
-- Table structure for table `tb_client`
--

DROP TABLE IF EXISTS `tb_client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_client` (
  `client_name` varchar(150) NOT NULL,
  `client_CEP` varchar(30) DEFAULT NULL,
  `client_address` varchar(150) NOT NULL,
  `client_phone` varchar(25) NOT NULL,
  `cliente_login` varchar(50) NOT NULL,
  `client_password` varchar(50) NOT NULL,
  `client_image_perfil` varchar(50) DEFAULT NULL,
  `client_email` tinytext,
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `client_password` (`client_password`),
  UNIQUE KEY `id_client` (`id_client`),
  KEY `FK_id_client_image` (`client_image_perfil`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_client`
--

LOCK TABLES `tb_client` WRITE;
/*!40000 ALTER TABLE `tb_client` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_images`
--

DROP TABLE IF EXISTS `tb_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_images` (
  `id_images` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(50) NOT NULL,
  `image_bytes` varbinary(55530) DEFAULT NULL,
  `image_way` text,
  `id_image_book` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_images`),
  UNIQUE KEY `image_name_UNIQUE` (`image_name`),
  KEY `FK_id_image_book` (`id_image_book`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_images`
--

LOCK TABLES `tb_images` WRITE;
/*!40000 ALTER TABLE `tb_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_images` ENABLE KEYS */;
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
  `id_of_student` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `rent_returned` tinyint(1) NOT NULL,
  `rent_penality` double DEFAULT NULL,
  `rent_observation` text,
  `id_of_client` int(11) NOT NULL,
  PRIMARY KEY (`id_rent`),
  KEY `idlivro` (`id_of_book`),
  KEY `idcli` (`id_of_student`),
  CONSTRAINT `tb_rent_ibfk_1` FOREIGN KEY (`id_of_book`) REFERENCES `tb_book` (`id_book`),
  CONSTRAINT `tb_rent_ibfk_2` FOREIGN KEY (`id_of_student`) REFERENCES `tb_student` (`id_student`)
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
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(100) NOT NULL,
  `student_registration` varchar(100) NOT NULL,
  `student_email` tinytext,
  `student_phone` varchar(30) DEFAULT NULL,
  `student_CEP` tinytext,
  `student_address` tinytext NOT NULL,
  `student_module` varchar(45) NOT NULL,
  `student_grade` varchar(100) NOT NULL,
  `student_course` varchar(100) DEFAULT NULL,
  `student_school` tinytext NOT NULL,
  `student_shift` varchar(25) NOT NULL,
  `student_login` varchar(100) NOT NULL,
  `student_password` varchar(100) NOT NULL,
  `student_image_perfil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_student`),
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
  `user_image_perfil` varchar(50) DEFAULT NULL,
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
-- Temporary view structure for view `user_view`
--

DROP TABLE IF EXISTS `user_view`;
/*!50001 DROP VIEW IF EXISTS `user_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_view` AS SELECT 
 1 AS `id_user`,
 1 AS `user_name`,
 1 AS `user_login`,
 1 AS `user_password`,
 1 AS `user_access_level`,
 1 AS `user_image_perfil`,
 1 AS `user_email`,
 1 AS `user_address`,
 1 AS `user_cep`,
 1 AS `user_phone`,
 1 AS `user_school`,
 1 AS `id_images`,
 1 AS `image_name`,
 1 AS `image_bytes`,
 1 AS `image_way`,
 1 AS `id_image_book`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'dbbiblio'
--

--
-- Dumping routines for database 'dbbiblio'
--

--
-- Final view structure for view `book_view`
--

/*!50001 DROP VIEW IF EXISTS `book_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_view` AS select `tb_book`.`id_book` AS `id_book`,`tb_book`.`book_name` AS `book_name`,`tb_book`.`book_author` AS `book_author`,`tb_book`.`book_publisher` AS `book_publisher`,`tb_book`.`book_stock` AS `book_stock`,`tb_book`.`book_genre` AS `book_genre`,`tb_book`.`book_acquired_date` AS `book_acquired_date`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_book` left join `tb_images` on((`tb_book`.`id_book` = `tb_images`.`id_image_book`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `client_view`
--

/*!50001 DROP VIEW IF EXISTS `client_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `client_view` AS select `tb_client`.`client_name` AS `client_name`,`tb_client`.`client_CEP` AS `client_CEP`,`tb_client`.`client_address` AS `client_address`,`tb_client`.`client_phone` AS `client_phone`,`tb_client`.`cliente_login` AS `cliente_login`,`tb_client`.`client_password` AS `client_password`,`tb_client`.`client_image_perfil` AS `client_image_perfil`,`tb_client`.`client_email` AS `client_email`,`tb_client`.`id_client` AS `id_client`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_client` left join `tb_images` on((`tb_client`.`client_image_perfil` = convert(`tb_images`.`image_name` using utf8)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `data_of_rents_view`
--

/*!50001 DROP VIEW IF EXISTS `data_of_rents_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `data_of_rents_view` AS select `tb_rent`.`id_rent` AS `id_rent`,`tb_rent`.`rented_date` AS `rented_date`,`tb_rent`.`id_of_book` AS `id_of_book`,`tb_rent`.`id_of_student` AS `id_of_student`,`tb_rent`.`return_date` AS `return_date`,`tb_rent`.`rent_returned` AS `rent_returned`,`tb_rent`.`rent_penality` AS `rent_penality`,`tb_rent`.`rent_observation` AS `rent_observation`,`tb_rent`.`id_of_client` AS `id_of_client`,`tb_client`.`client_name` AS `client_name`,`tb_client`.`client_CEP` AS `client_CEP`,`tb_client`.`client_address` AS `client_address`,`tb_client`.`client_phone` AS `client_phone`,`tb_client`.`cliente_login` AS `cliente_login`,`tb_client`.`client_password` AS `client_password`,`tb_client`.`client_image_perfil` AS `client_image_perfil`,`tb_client`.`client_email` AS `client_email`,`tb_client`.`id_client` AS `id_client`,`tb_student`.`id_student` AS `id_student`,`tb_student`.`student_name` AS `student_name`,`tb_student`.`student_registration` AS `student_registration`,`tb_student`.`student_email` AS `student_email`,`tb_student`.`student_phone` AS `student_phone`,`tb_student`.`student_CEP` AS `student_CEP`,`tb_student`.`student_address` AS `student_address`,`tb_student`.`student_module` AS `student_module`,`tb_student`.`student_grade` AS `student_grade`,`tb_student`.`student_course` AS `student_course`,`tb_student`.`student_school` AS `student_school`,`tb_student`.`student_shift` AS `student_shift`,`tb_student`.`student_login` AS `student_login`,`tb_student`.`student_password` AS `student_password`,`tb_student`.`student_image_perfil` AS `student_image_perfil`,`tb_book`.`id_book` AS `id_book`,`tb_book`.`book_name` AS `book_name`,`tb_book`.`book_author` AS `book_author`,`tb_book`.`book_publisher` AS `book_publisher`,`tb_book`.`book_stock` AS `book_stock`,`tb_book`.`book_genre` AS `book_genre`,`tb_book`.`book_acquired_date` AS `book_acquired_date`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from ((((`tb_rent` left join `tb_client` on((`tb_rent`.`id_of_client` = `tb_client`.`id_client`))) left join `tb_student` on((`tb_rent`.`id_of_student` = `tb_student`.`id_student`))) left join `tb_book` on((`tb_rent`.`id_of_book` = `tb_book`.`id_book`))) left join `tb_images` on(((`tb_client`.`client_image_perfil` = `tb_images`.`id_images`) or (`tb_student`.`student_image_perfil` = `tb_images`.`id_images`) or (`tb_book`.`id_book` = `tb_images`.`id_image_book`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `student_view`
--

/*!50001 DROP VIEW IF EXISTS `student_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `student_view` AS select `tb_student`.`id_student` AS `id_student`,`tb_student`.`student_name` AS `student_name`,`tb_student`.`student_registration` AS `student_registration`,`tb_student`.`student_email` AS `student_email`,`tb_student`.`student_phone` AS `student_phone`,`tb_student`.`student_CEP` AS `student_CEP`,`tb_student`.`student_address` AS `student_address`,`tb_student`.`student_module` AS `student_module`,`tb_student`.`student_grade` AS `student_grade`,`tb_student`.`student_course` AS `student_course`,`tb_student`.`student_school` AS `student_school`,`tb_student`.`student_shift` AS `student_shift`,`tb_student`.`student_login` AS `student_login`,`tb_student`.`student_password` AS `student_password`,`tb_student`.`student_image_perfil` AS `student_image_perfil`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_student` left join `tb_images` on((`tb_student`.`student_image_perfil` = convert(`tb_images`.`image_name` using utf8)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_view`
--

/*!50001 DROP VIEW IF EXISTS `user_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_view` AS select `tb_user`.`id_user` AS `id_user`,`tb_user`.`user_name` AS `user_name`,`tb_user`.`user_login` AS `user_login`,`tb_user`.`user_password` AS `user_password`,`tb_user`.`user_access_level` AS `user_access_level`,`tb_user`.`user_image_perfil` AS `user_image_perfil`,`tb_user`.`user_email` AS `user_email`,`tb_user`.`user_address` AS `user_address`,`tb_user`.`user_cep` AS `user_cep`,`tb_user`.`user_phone` AS `user_phone`,`tb_user`.`user_school` AS `user_school`,`tb_images`.`id_images` AS `id_images`,`tb_images`.`image_name` AS `image_name`,`tb_images`.`image_bytes` AS `image_bytes`,`tb_images`.`image_way` AS `image_way`,`tb_images`.`id_image_book` AS `id_image_book` from (`tb_user` left join `tb_images` on((`tb_user`.`user_image_perfil` = convert(`tb_images`.`image_name` using utf8)))) */;
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

-- Dump completed on 2020-06-24 15:39:39
