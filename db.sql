CREATE DATABASE  IF NOT EXISTS `helpseller` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `helpseller`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: helpseller
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
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES (1,'aldo123','aldo@libeo.it','password'),(2,'bruno','bruno@gmail.it','passwword'),(3,'saverio','aldo@aonnazudunna.it','briscola123-'),(12,'giangiorgio','gg@ald.org','giooooooonny'),(13,'gianfrancesco','aldo@gg.com','12345678qwertyuiop');
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
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nome_azienda` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vat` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `indirizzo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descrizione` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'bevande@gmail.com','123','bevande SPA','111111','via piedi','vendiamo bevande',NULL),(2,'surgelati@gmail.com','234','surgelati','222222','via vai','vendiamo surgelati',NULL),(3,'messico@gmail.com','2982','mexican foods','333333','corso veloce','vendiamo cibo etnico',NULL);
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
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cognome` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vat` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `indirizzo_sede` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `ordineprova_idx` (`id_ordine_prova`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributore`
--

LOCK TABLES `distributore` WRITE;
/*!40000 ALTER TABLE `distributore` DISABLE KEYS */;
INSERT INTO `distributore` VALUES (1,'mario','mario@gmail.com','111','mario','caccioppoli','125425','2525145','napoli',NULL);
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
  `titolo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `autore` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_ordine` int NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ordinedoc_idx` (`id_ordine`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commento` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stato` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_distributore` int NOT NULL,
  `data_consegna` date NOT NULL,
  `data_ordinazione` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `distributore_idx` (`id_distributore`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
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
  `quantita` int NOT NULL,
  `prezzo` double NOT NULL,
  `prezzo_unitario` double NOT NULL,
  PRIMARY KEY (`id_ordine`,`id_prodotto`),
  KEY `prodottofk_idx` (`id_prodotto`),
  CONSTRAINT `ordinefk` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`),
  CONSTRAINT `prodottofk` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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
  `nome_prodotto` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prezzo` double NOT NULL,
  `descrizione` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantita` int NOT NULL,
  `immagine` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `peso` int NOT NULL,
  `volume` int NOT NULL,
  `id_azienda` int NOT NULL,
  `quantita_minima` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomeProdotto_UNIQUE` (`nome_prodotto`),
  KEY `Azienda_idx` (`id_azienda`),
  CONSTRAINT `Azienda` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'cola',1,'bevanda gusto cola generica',50,NULL,1,1,1,0),(2,'cherry cola',1.15,'bevanda gusto cola alla ciliegia',55,NULL,2,1,1,0),(3,'cola zero',1,'bevanda gusto cola zero calorie',40,NULL,3,1,1,0),(4,'sofficini',2,'sofficini generici surgelati',60,NULL,1,2,2,0),(5,'bastoncini',2,'bastoncini di merluzzo surgelati',50,NULL,2,2,2,0),(6,'kebab',3,'kebab surgelato',40,NULL,3,2,2,0),(7,'tacos',1.5,'tacos surgelati',20,NULL,1,3,3,0),(8,'chili sauce',1,'salsa chili piccante',10,NULL,2,3,3,0),(9,'kebab piccante',3,'kebab piccante surgelato',5,NULL,3,3,3,0),(10,'spicy doritos',1.5,'tortillas chips piccanti',1,NULL,4,3,3,0),(14,'cacca',10000,'simile alla nutella',1000,NULL,999,999,1,10);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recensione` (
  `id` int NOT NULL,
  `testo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `voto` int NOT NULL,
  `data` date NOT NULL,
  `id_prodotto` int NOT NULL,
  `id_distributore` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Distributore_idx` (`id_distributore`),
  KEY `Prodotto` (`id_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
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
  `percentuale` int NOT NULL,
  `tipo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantita` int DEFAULT NULL,
  `id_azienda` int NOT NULL,
  `data_fine` date NOT NULL,
  `data_inizio` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `azienda_idx` (`id_azienda`),
  CONSTRAINT `aziend` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto`
--

LOCK TABLES `sconto` WRITE;
/*!40000 ALTER TABLE `sconto` DISABLE KEYS */;
INSERT INTO `sconto` VALUES (4,10,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(5,5,'catalogo',NULL,3,'2022-09-10','2022-04-10');
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
  PRIMARY KEY (`id_sconto`,`id_prodotto`),
  KEY `productNN_idx` (`id_prodotto`),
  CONSTRAINT `productNN` FOREIGN KEY (`id_prodotto`) REFERENCES `prodotto` (`id`),
  CONSTRAINT `scontoNN` FOREIGN KEY (`id_sconto`) REFERENCES `sconto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto_prodotto`
--

LOCK TABLES `sconto_prodotto` WRITE;
/*!40000 ALTER TABLE `sconto_prodotto` DISABLE KEYS */;
INSERT INTO `sconto_prodotto` VALUES (4,7),(4,8),(5,9),(5,10);
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
  `id_ordine` int NOT NULL,
  `data_consegna` date NOT NULL,
  `indirizzo_consegna` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantita_minima` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ordine_idx` (`id_ordine`),
  CONSTRAINT `ordine` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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

-- Dump completed on 2022-01-15 23:41:29
