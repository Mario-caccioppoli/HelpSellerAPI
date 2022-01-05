CREATE DATABASE  IF NOT EXISTS `helpseller` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `helpseller`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: helpseller
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amministratore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `id_amministratore` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES (1,'aldo123','aldo@culo.it','password',0),(5,'234','aldo@culo.itt','passwword',0),(7,NULL,'aldo@aonnazudunna.it','passwword',0),(10,NULL,NULL,'password',0),(11,NULL,NULL,'password',0);
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `azienda`
--

DROP TABLE IF EXISTS `azienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `azienda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nomeAzienda` varchar(45) DEFAULT NULL,
  `VATNumber` varchar(12) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `logo` varchar(45) DEFAULT NULL,
  `vat` varchar(255) DEFAULT NULL,
  `nome_azienda` varchar(255) DEFAULT NULL,
  `id_azienda` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`VATNumber`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,NULL,NULL,'bevande SPA',NULL,NULL,NULL,NULL,NULL,NULL,0),(2,NULL,NULL,'surgelati',NULL,NULL,NULL,NULL,NULL,NULL,0),(3,NULL,NULL,'mexican foods',NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distributore`
--

DROP TABLE IF EXISTS `distributore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distributore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `VATNumber` varchar(12) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `indirizzoSede` varchar(45) DEFAULT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  `vat` varchar(255) DEFAULT NULL,
  `indirizzo_sede` varchar(255) DEFAULT NULL,
  `id_distributore` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`VATNumber`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `ordineprova_idx` (`id_ordine_prova`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributore`
--

LOCK TABLES `distributore` WRITE;
/*!40000 ALTER TABLE `distributore` DISABLE KEYS */;
INSERT INTO `distributore` VALUES (1,'aldo123',NULL,NULL,'aldo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,'manfredi',NULL,NULL,'giacobbe',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(3,'anselmo',NULL,NULL,'stuart',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,'aldoo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(5,'menfranco',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(6,'alsazio',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `distributore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(45) DEFAULT NULL,
  `autore` varchar(45) DEFAULT NULL,
  `dataUpload` date DEFAULT NULL,
  `id_ordine` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_documento` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ordinedoc_idx` (`id_ordine`),
  CONSTRAINT `ordinedoc` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataOrdinazione` date DEFAULT NULL,
  `dataConsegna` date DEFAULT NULL,
  `commento` varchar(45) DEFAULT NULL,
  `stato` varchar(45) DEFAULT NULL,
  `id_distributore` int DEFAULT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `data_ordinazione` date DEFAULT NULL,
  `id_ordine` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `distributore_idx` (`id_distributore`),
  KEY `ordineProva_idx` (`id_ordine_prova`),
  CONSTRAINT `distrib` FOREIGN KEY (`id_distributore`) REFERENCES `distributore` (`id`),
  CONSTRAINT `ordineP` FOREIGN KEY (`id_ordine_prova`) REFERENCES `distributore` (`id_ordine_prova`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine_prodotto`
--

DROP TABLE IF EXISTS `ordine_prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine_prodotto` (
  `id_ordine` int NOT NULL,
  `id_prodotto` int NOT NULL,
  `quantita` int DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `id` int NOT NULL,
  `prezzo_unitario` double NOT NULL,
  PRIMARY KEY (`id_ordine`,`id_prodotto`),
  KEY `prodottofk_idx` (`id_prodotto`),
  CONSTRAINT `ordinefk` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`),
  CONSTRAINT `prodottofk` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine_prodotto`
--

LOCK TABLES `ordine_prodotto` WRITE;
/*!40000 ALTER TABLE `ordine_prodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordine_prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomeProdotto` varchar(45) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `immagine` varchar(45) DEFAULT NULL,
  `quantitaMinima` int DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `id_prodotto` int NOT NULL,
  `nome_prodotto` varchar(255) DEFAULT NULL,
  `quantita_minima` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomeProdotto_UNIQUE` (`nomeProdotto`),
  KEY `Azienda_idx` (`id_azienda`),
  CONSTRAINT `Azienda` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'cola',1,'bevanda gusto cola generica',NULL,NULL,NULL,NULL,NULL,1,0,NULL,0),(2,'cherry cola',1.15,'bevanda gusto cola alla ciliegia',NULL,NULL,NULL,NULL,NULL,1,0,NULL,0),(3,'cola zero',1,'bevanda gusto cola zero calorie',NULL,NULL,NULL,NULL,NULL,1,0,NULL,0),(4,'sofficini',2,'sofficini generici surgelati',NULL,NULL,NULL,NULL,NULL,2,0,NULL,0),(5,'bastoncini',2,'bastoncini di merluzzo surgelati',NULL,NULL,NULL,NULL,NULL,2,0,NULL,0),(6,'kebab',3,'kebab surgelato',NULL,NULL,NULL,NULL,NULL,2,0,NULL,0),(7,'tacos',1.5,'tacos surgelati',NULL,NULL,NULL,NULL,NULL,3,0,NULL,0),(8,'chili sauce',1,'salsa chili piccante',NULL,NULL,NULL,NULL,NULL,3,0,NULL,0),(9,'kebab piccante',3,'kebab piccante surgelato',NULL,NULL,NULL,NULL,NULL,2,0,NULL,0),(10,'spicy doritos',1.5,'tortillas chips piccanti',NULL,NULL,NULL,NULL,NULL,3,0,NULL,0);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recensione` (
  `id` bigint NOT NULL,
  `testo` varchar(255) DEFAULT NULL,
  `voto` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_prodotto` int DEFAULT NULL,
  `id_distributore` int DEFAULT NULL,
  `id_recensione` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Distributore_idx` (`id_distributore`),
  KEY `Prodotto` (`id_prodotto`),
  CONSTRAINT `Distributore` FOREIGN KEY (`id_distributore`) REFERENCES `distributore` (`id`),
  CONSTRAINT `Prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (1,'adoro il piccante',5,NULL,9,1,0),(2,'adoro il piccante',5,NULL,8,1,0),(3,'adoro il piccante',5,NULL,10,1,0),(4,'buona la cola',5,NULL,1,2,0),(5,'buona la cola',5,NULL,2,2,0),(6,'buona la cola',5,NULL,3,2,0),(7,'ottimo surgelato',5,NULL,4,3,0),(8,'ottimo surgelato',5,NULL,5,3,0),(9,'ottimo surgelato',5,NULL,6,3,0),(10,'anche a me piace il piccante',5,NULL,9,4,0),(11,'sono un patito della cola',5,NULL,1,5,0),(12,'molto comodi da cucinare ',5,NULL,4,6,0),(13,'pessimo sapore',1,NULL,3,4,0),(14,'troppo piccante',1,NULL,10,5,0);
/*!40000 ALTER TABLE `recensione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sconto`
--

DROP TABLE IF EXISTS `sconto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sconto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `percentuale` int DEFAULT NULL,
  `dataInizio` date DEFAULT NULL,
  `dataFine` date DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  `id_sconto` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `azienda_idx` (`id_azienda`),
  CONSTRAINT `aziend` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto`
--

LOCK TABLES `sconto` WRITE;
/*!40000 ALTER TABLE `sconto` DISABLE KEYS */;
/*!40000 ALTER TABLE `sconto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sconto_prodotto`
--

DROP TABLE IF EXISTS `sconto_prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sconto_prodotto` (
  `id_sconto` int NOT NULL,
  `id_prodotto` int NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id_sconto`,`id_prodotto`),
  KEY `productNN_idx` (`id_prodotto`),
  CONSTRAINT `productNN` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotto` (`id`),
  CONSTRAINT `scontoNN` FOREIGN KEY (`id_sconto`) REFERENCES `sconto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto_prodotto`
--

LOCK TABLES `sconto_prodotto` WRITE;
/*!40000 ALTER TABLE `sconto_prodotto` DISABLE KEYS */;
/*!40000 ALTER TABLE `sconto_prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trasporto`
--

DROP TABLE IF EXISTS `trasporto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trasporto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `indirizzoConsegna` varchar(45) DEFAULT NULL,
  `quantitaMinima` int DEFAULT NULL,
  `dataConsegna` date DEFAULT NULL,
  `id_ordine` int DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `indirizzo_consegna` varchar(255) DEFAULT NULL,
  `quantita_minima` int NOT NULL,
  `id_trasporto` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ordine_idx` (`id_ordine`),
  CONSTRAINT `ordine` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasporto`
--

LOCK TABLES `trasporto` WRITE;
/*!40000 ALTER TABLE `trasporto` DISABLE KEYS */;
/*!40000 ALTER TABLE `trasporto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-05 20:27:07
