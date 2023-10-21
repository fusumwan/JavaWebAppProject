CREATE DATABASE  IF NOT EXISTS `sentence` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sentence`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: sentence
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT (uuid()),
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `contact_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--accountaccount

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('0b22d9e5-c8cd-479b-a2e3-bc5fd8f8968b','Timothy','Fu','admin','email0@email.com','2222222221121','$2a$10$s9tWGj5lIFriZ1zyR0Ag4OjOnG9Y7jtvAj.gcZWkj8sGeS1vs63Km','ADMIN'),('1467e2c4-9c99-4346-8f09-fdc6c53081c6','first_name012','last_name012','john11','email0@email.com','11','test11','ADMIN'),('1af50dd9-37a2-4212-9956-d89df10dd2b1','Sun','Fu','user','user1email0@email.com','2323233243232','$2a$10$4X6iEyr3KQwWqCgyx5ZZ0OmaRH2E.A16N537uKWyRxIP8ALn/FYyS','USER'),('23556262-43e1-4a9d-88c0-af06dbdde4f7','Daro11','Mey11','Daro','Mey@hotmail.com','456','$12$xpbBDdLm.OygBHosR7wbqOPXBMQdl9MxoD.KescTN681JPI6hwEa2','USER'),('23cd73e6-637d-4576-b289-85b52753281e','F12','L12','user1122','user1122email0@email.com','23232','$2a$10$WRgHWKjanhKk9q7UOK9Gpeksrs450ona/S46xXDXPCfqZUYd8ZsMm','USER'),('2a73de3a-9ca0-4de7-babd-d728ea335bc1','F1','L1','user11','user11email0@email.com','23232','$2a$10$tygDIrC1MiVi4XYedI6p2O3p8VAYbQR.PZT2S2vF1lezGS3g6OOwC','USER'),('2b58e7ca-eb41-4ce1-b931-42b8b91dcd85','F1','L1','user1','user11email0@email.com','23232','$2a$10$fnyRr6TkdyQV1mw2pWhYS.i5FJtHOcsTv/IdJpVSofhUk8eUFy5Fe','USER'),('4ba82912-a0c0-461c-b4e4-61c5e44bb4da','first_name01','last_name01','john','email0@email.com','0','$2a$10$y8Ih.D760w5OmJUkyD3mtuKVMbpXOrsdNPaDXqZ.7xkUzqsdhFwL.','ADMIN'),('b735161b-477e-43fe-9d1f-b24ddf96d906','Timothy','Fu','manager','email0@email.com','2323233243','$2a$10$u83HkczowLYhfTPxf9ZwreEtvsoxHQLn8PAcJazE6dRpMAzRRrJU.','MANAGER'),('c8a80a4c-1063-4353-b365-c1ce82765a3e','Hoang','Dung','Hoang','Dung@hotmail.com','789','$12$xpbBDdLm.OygBHosR7wbqOPXBMQdl9MxoD.KescTN681JPI6hwEa2','MANAGER'),('d5565ecd-5438-45e3-a27a-1899aae97f5c','Timothy','Fu','timothy','Timothy@hotmail.com','481772223','$12$xpbBDdLm.OygBHosR7wbqOPXBMQdl9MxoD.KescTN681JPI6hwEa2','MANAGER');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `subject_sentence`;

CREATE TABLE subject_sentence (
    subject_sentence_id CHAR(36) NOT NULL DEFAULT (UUID()),
	situation VARCHAR(255),
	event VARCHAR(255),
	sentence_type VARCHAR(255),
    article_01 VARCHAR(255),
    subject_01 VARCHAR(255),
    conjunction_01 VARCHAR(255),
    adverb_01 VARCHAR(255),
    auxiliary_verb_01 VARCHAR(255),
    verb_01 VARCHAR(255),
    infinitive_01 VARCHAR(255),
    conjunction_02 VARCHAR(255),
    adverb_02 VARCHAR(255),
    preposition_01 VARCHAR(255),
    pronoun_01 VARCHAR(255),
    article_02 VARCHAR(255),
    adjective_01 VARCHAR(255),
    noun_01 VARCHAR(255),
    noun_phase_01 VARCHAR(255),
    gerund_01 VARCHAR(255),
    clause_01 VARCHAR(255),
    full_sentence TEXT,
    traditional_chinese TEXT,
    PRIMARY KEY (subject_sentence_id)
);
