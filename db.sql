CREATE DATABASE  IF NOT EXISTS `helpseller` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `helpseller`;
-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: localhost    Database: helpseller
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nome_azienda` varchar(45) DEFAULT NULL,
  `vat` varchar(12) DEFAULT NULL,
  `indirizzo` varchar(45) DEFAULT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `logo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `vat` varchar(12) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `indirizzo_sede` varchar(45) DEFAULT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
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
INSERT INTO `distributore` VALUES (1,'aldo123','aldo123@123.it','123','aldo','romulov','111110','1234','via sede',0),(2,'manfredi','manfr@hotmail.it','123','giacobbe','stianz','111112','1234','via tenente rossi',0),(3,'anselmo','ansia@gmail.com','123','stuart','bababa','111113','1234','corso rupestre',0),(4,'aldoo','4ld0@gmail.com','123','rosangelo','chiaro','111114','1234','piazza diego',0),(5,'menfranco','frank@libero.it','123','malbalbo','rossi','111115','1234','stretto delle meraviglie',0),(6,'alsazio','lorena@libero.it','vivalacia','pistrenco','verdi','111116','1234','corso lungo',0);
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
  `id_ordine` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ordinedoc_idx` (`id_ordine`),
  CONSTRAINT `ordinedoc` FOREIGN KEY (`id_ordine`) REFERENCES `ordine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (1,'diritti','1',NULL,NULL),(3,'documentobello','danielinowewe',1,'2022-01-01');
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
  `commento` varchar(45) DEFAULT NULL,
  `stato` varchar(45) DEFAULT NULL,
  `id_distributore` int DEFAULT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `data_ordinazione` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `distributore_idx` (`id_distributore`),
  KEY `ordineProva_idx` (`id_ordine_prova`),
  CONSTRAINT `distrib` FOREIGN KEY (`id_distributore`) REFERENCES `distributore` (`id`),
  CONSTRAINT `ordineP` FOREIGN KEY (`id_ordine_prova`) REFERENCES `distributore` (`id_ordine_prova`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (1,'ttok','consegnato',1,NULL,'2022-01-10','2022-01-01');
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
  `nome_prodotto` varchar(45) DEFAULT NULL,
  `prezzo` double DEFAULT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `immagine` varchar(45) DEFAULT NULL,
  `peso` int DEFAULT NULL,
  `volume` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `quantita_minima` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nomeProdotto_UNIQUE` (`nome_prodotto`),
  KEY `Azienda_idx` (`id_azienda`),
  CONSTRAINT `Azienda` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'cola',1,'bevanda gusto cola generica',50,NULL,1,1,1,0),(2,'cherry cola',1.15,'bevanda gusto cola alla ciliegia',55,NULL,2,1,1,0),(3,'cola zero',1,'bevanda gusto cola zero calorie',40,NULL,3,1,1,0),(4,'sofficini',2,'sofficini generici surgelati',60,NULL,1,2,2,0),(5,'bastoncini',2,'bastoncini di merluzzo surgelati',50,NULL,2,2,2,0),(6,'kebab',3,'kebab surgelato',40,NULL,3,2,2,0),(7,'tacos',1.5,'tacos surgelati',20,NULL,1,3,3,0),(8,'chili sauce',1,'salsa chili piccante',10,NULL,2,3,3,0),(9,'kebab piccante',3,'kebab piccante surgelato',5,NULL,3,3,2,0),(10,'spicy doritos',1.5,'tortillas chips piccanti',1,NULL,4,3,3,0);
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
  `testo` varchar(255) DEFAULT NULL,
  `voto` int DEFAULT NULL,
  `data` date DEFAULT NULL,
  `id_prodotto` int DEFAULT NULL,
  `id_distributore` int DEFAULT NULL,
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
INSERT INTO `recensione` VALUES (1,'adoro il piccante',5,NULL,9,1),(2,'adoro il piccante',5,NULL,8,1),(3,'adoro il piccante',5,NULL,10,1),(4,'buona la cola',5,NULL,1,2),(5,'buona la cola',5,NULL,2,2),(6,'buona la cola',5,NULL,3,2),(7,'ottimo surgelato',5,NULL,4,3),(8,'ottimo surgelato',5,NULL,5,3),(9,'ottimo surgelato',5,NULL,6,3),(10,'anche a me piace il piccante',5,NULL,9,4),(11,'sono un patito della cola',5,NULL,1,5),(12,'molto comodi da cucinare ',5,NULL,4,6),(13,'pessimo sapore',1,NULL,3,4),(14,'troppo piccante',1,NULL,10,5);
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
  `tipo` varchar(45) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  `id_azienda` int DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `azienda_idx` (`id_azienda`),
  CONSTRAINT `aziend` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto`
--

LOCK TABLES `sconto` WRITE;
/*!40000 ALTER TABLE `sconto` DISABLE KEYS */;
INSERT INTO `sconto` VALUES (1,5,'',100,1,NULL,NULL),(2,10,NULL,100,1,NULL,NULL),(3,5,NULL,100,1,NULL,NULL);
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
  `id_ordine` int DEFAULT NULL,
  `data_consegna` date DEFAULT NULL,
  `indirizzo_consegna` varchar(255) DEFAULT NULL,
  `quantita_minima` int NOT NULL,
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

-- Dump completed on 2022-01-11 13:16:22
