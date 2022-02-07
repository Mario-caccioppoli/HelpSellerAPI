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
INSERT INTO `amministratore` VALUES (1,'aldoo','aldo@libeo.it','password'),(2,'fabiooo','nuovaemagfdhrhfdhrdhrhrbil','123'),(3,'bevande123','nuovaemail','123'),(12,'giangiorgio','gg@ald.org','giooooooonny'),(13,'gianfrancesco','aldo@gg.com','12345678qwertyuiop');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'bevande@gmail.com','123','bevande SPA','111111','via piedi','descrizione modificata dal test',NULL),(2,'surgelati@gmail.com','234','surgelati','222222','via vai','vendiamo surgelati',NULL),(3,'messico@gmail.com','2982','mexican foods','333333','corso veloce','vendiamo cibo etnico',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributore`
--

LOCK TABLES `distributore` WRITE;
/*!40000 ALTER TABLE `distributore` DISABLE KEYS */;
INSERT INTO `distributore` VALUES (1,'mario','mario@gmail.com','111','mario','de gregorio','125425','2525145','napoli',0),(2,'pino','pino@p.p','3','pino','de gregorio','2','99','casa di ino',0),(3,'anselmo','lorazio@pe.it','56','anselmo','lorazio','5','78','casa di lorazio',0),(4,'elpido','elpiu@email.it','7','elpidio','siepe','3','666','via tenente nastri',0),(5,'fabio','piccioni@email.com','9','fabizio','mazza','7','657','via vai',0),(6,'aldo','aldo@email.aldo','5','aldo','aldo','55','5','casaldo',0),(7,'ermenegildo','gil@gmail.gil','9','ermene','girldo','8','5436','vai via',0),(9,'prova','fabio@email.it','123','Fabio','Frizzi','1','333','via della sede',0),(10,'ordinetest','xlitsl0l@gmail.com','5','xlits','l0l','99','99','casa mia',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (4,'doc del test','aldo baglio',1,'2023-04-01'),(5,'DocumentoTest','aldo moro',1,'2022-01-10');
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
  `commento` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stato` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_distributore` int NOT NULL,
  `data_consegna` date NOT NULL,
  `data_ordinazione` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `distributore_idx` (`id_distributore`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (1,'commento modificato dal test','Generated',155,'2023-12-01','2022-12-01'),(2,NULL,'ricevuto',1,'2022-04-10','2022-01-10'),(3,NULL,'ricevuto',1,'2022-04-05','2022-01-05'),(4,'','Generated',1,'2023-12-01','2022-12-01'),(5,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(6,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(7,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(8,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(9,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(10,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(11,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(12,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(13,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(14,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(15,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(16,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(17,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(18,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(19,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(20,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(21,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(22,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(23,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(24,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(25,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(26,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(27,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(28,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(29,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(30,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(31,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(32,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(33,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(34,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(35,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(36,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(37,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(38,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(39,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(40,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(41,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(42,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(43,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(44,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(45,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(46,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(47,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(48,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(49,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(50,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(51,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(52,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(53,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(54,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(55,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(56,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(57,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(58,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(59,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(60,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(61,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(62,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(63,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(64,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(65,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(66,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(67,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(68,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(69,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(70,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(71,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(72,'no','ricevuto',10,'2022-12-02','2022-12-01'),(73,'no','ricevuto',10,'2022-12-02','2022-12-01'),(74,'no','ricevuto',10,'2022-12-02','2022-12-01'),(75,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(76,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(77,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(78,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(79,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(80,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(81,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(82,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(83,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(84,'commentoTest','statoTest',1,'2022-01-21','2022-01-10'),(85,'commentoTest','statoTest',1,'2022-01-21','2022-01-10');
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
  `quantita_ordine` int NOT NULL,
  `prezzo_ordine` double NOT NULL,
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
INSERT INTO `ordine_prodotto` VALUES (1,1,12,123,2),(2,2,1000,5000,5),(2,4,5000,10000,2),(3,3,500,500,1),(12,1,1,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'cola',4,'bevanda gusto cola generica',50,NULL,1,1,1,0),(2,'cherry cola',1.15,'bevanda gusto cola alla ciliegia',55,NULL,2,1,1,0),(3,'cola zero',1,'bevanda gusto cola zero calorie',40,NULL,3,1,1,0),(4,'sofficini',2,'sofficini generici surgelati',60,NULL,1,2,2,0),(5,'bastoncini',2,'bastoncini di merluzzo surgelati',50,NULL,2,2,2,0),(6,'kebab',3,'kebab surgelato',40,NULL,3,2,2,0),(7,'tacos',1.5,'tacos surgelati',20,NULL,1,3,3,0),(8,'chili sauce',1,'salsa chili piccante',10,NULL,2,3,3,0),(9,'kebab piccante',3,'kebab piccante surgelato',5,NULL,3,3,3,0),(10,'spicy doritos',1.8,'tortillas chips piccanti',1,'',4,3,3,0),(11,'salame piccante',2,'salame piccante',50,NULL,4,3,3,0),(12,'nduja',4,'salume piccante calabrese',50,NULL,4,3,3,0),(13,'peperoncino sott\'olio',3,'peperoncino sott\'olio',50,NULL,4,3,3,0),(14,'ali di pollo piccantoi',2,'alette di posso con osso',50,NULL,4,3,3,0),(15,'salsa piccante',1.5,'salsa piccante',50,NULL,4,3,3,0),(16,'Salsa Worcestershire',2,'Salsa Worcestershire',50,NULL,4,3,3,0);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recensione` (
  `id` int NOT NULL AUTO_INCREMENT,
  `testo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `voto` int NOT NULL,
  `data` date NOT NULL,
  `id_prodotto` int NOT NULL,
  `id_distributore` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Distributore_idx` (`id_distributore`),
  KEY `Prodotto` (`id_prodotto`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (2,'superba',3,'2022-01-19',50505,2),(3,'non m\'interessa nulla al di fuori della cola',1,'2022-02-23',4,1),(4,'amo il piccante',5,'2022-02-23',9,9),(5,'amo il piccante',5,'2022-02-23',10,9),(6,'amo il piccante',5,'2022-02-23',11,9),(7,'amo il piccante',5,'2022-02-23',12,9),(9,'amo il piccante',5,'2022-02-23',14,9),(10,'amo il piccante',5,'2022-02-23',15,9),(11,'amo il piccante',5,'2022-02-23',16,9),(12,'amo il piccante',4,'2022-02-23',9,3),(13,'amo anch\'io il piccante',5,'2022-02-23',10,3),(14,'amo anch\'io il piccante',5,'2022-02-23',11,3),(15,'amo anch\'io il piccante',5,'2022-02-23',12,3),(16,'amo anch\'io il piccante',5,'2022-02-23',13,3),(17,'pessima',1,'2022-02-23',1,3),(18,'ottimo',5,'2022-02-23',10,2),(19,'ottimo',5,'2022-01-13',4,4),(20,'ottimo',5,'2022-01-13',5,4),(21,'ottimo',5,'2022-01-13',6,4),(22,'ottimo',5,'2022-01-13',7,4),(23,'debole relazione con piccante',4,'2022-01-13',15,5),(24,'nice',4,'2022-01-13',16,2),(25,'ok',5,'2022-01-13',16,5),(26,'cola',5,'2022-01-13',2,1),(27,'cola2',5,'2022-01-13',3,1),(28,'piccante',5,'2022-01-13',8,9),(29,'colaldo',5,'2022-02-23',1,6),(30,'colaldo',5,'2022-02-23',2,6);
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
  `nome_sconto` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `percentuale` int NOT NULL,
  `tipo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quantita` int DEFAULT NULL,
  `id_azienda` int NOT NULL,
  `data_fine` date NOT NULL,
  `data_inizio` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `azienda_idx` (`id_azienda`),
  CONSTRAINT `aziend` FOREIGN KEY (`id_azienda`) REFERENCES `azienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sconto`
--

LOCK TABLES `sconto` WRITE;
/*!40000 ALTER TABLE `sconto` DISABLE KEYS */;
INSERT INTO `sconto` VALUES (4,'nome1',4,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(5,'nome2',50,'catalogo',NULL,3,'2022-09-10','2022-04-10'),(7,'nome3',10,'quantita',10,3,'2022-09-10','2022-08-10'),(8,'nome6',10,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(9,'nome100',10,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(10,'nome2900',70,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(11,'newSconto',10,'catalogo',5,1,'2023-12-01','2022-12-01'),(12,'newSconto',10,'catalogo',5,1,'2023-12-01','2022-12-01');
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
INSERT INTO `sconto_prodotto` VALUES (5,9),(5,10);
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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasporto`
--

LOCK TABLES `trasporto` WRITE;
/*!40000 ALTER TABLE `trasporto` DISABLE KEYS */;
INSERT INTO `trasporto` VALUES (1,1,'2022-01-01','nuovo indirizzo',1),(2,1,'2022-01-10','asd',1),(3,1,'2022-01-10','indirizzoconsegnaTest',1),(4,1,'2022-01-10','indirizzoconsegnaTest',1),(5,1,'2022-01-10','indirizzoconsegnaTest',1),(6,1,'2022-01-10','indirizzoconsegnaTest',1),(7,1,'2022-01-10','indirizzoconsegnaTest',1),(8,1,'2022-01-10','indirizzoconsegnaTest',1),(9,1,'2022-01-10','indirizzoconsegnaTest',1),(10,1,'2022-01-10','indirizzoconsegnaTest',1),(11,1,'2022-01-10','indirizzoconsegnaTest',1),(12,1,'2022-01-10','indirizzoconsegnaTest',1),(13,1,'2022-01-10','indirizzoconsegnaTest',1),(14,1,'2022-01-10','indirizzoconsegnaTest',1),(15,1,'2022-01-10','indirizzoconsegnaTest',1),(16,1,'2022-01-10','indirizzoconsegnaTest',1),(17,1,'2022-01-10','indirizzoconsegnaTest',1),(18,1,'2022-01-10','indirizzoconsegnaTest',1),(19,1,'2022-01-10','indirizzoconsegnaTest',1),(20,1,'2022-01-10','indirizzoconsegnaTest',1),(21,1,'2022-01-10','indirizzoconsegnaTest',1),(22,1,'2022-01-10','indirizzoconsegnaTest',1),(23,1,'2022-01-10','indirizzoconsegnaTest',1),(24,1,'2022-01-10','indirizzoconsegnaTest',1),(25,1,'2022-01-10','indirizzoconsegnaTest',1),(26,1,'2022-01-10','indirizzoconsegnaTest',1),(27,1,'2022-01-10','indirizzoconsegnaTest',1),(28,1,'2022-01-10','indirizzoconsegnaTest',1),(29,1,'2022-01-10','indirizzoconsegnaTest',1),(30,1,'2022-01-10','indirizzoconsegnaTest',1),(31,1,'2022-01-10','indirizzoconsegnaTest',1),(32,1,'2022-01-10','indirizzoconsegnaTest',1),(33,1,'2022-01-10','indirizzoconsegnaTest',1),(34,1,'2022-01-10','indirizzoconsegnaTest',1),(35,1,'2022-01-10','indirizzoconsegnaTest',1),(36,1,'2022-01-10','indirizzoconsegnaTest',1),(37,1,'2022-01-10','indirizzoconsegnaTest',1),(38,1,'2022-01-10','indirizzoconsegnaTest',1),(39,1,'2022-01-10','indirizzoconsegnaTest',1),(40,1,'2022-01-10','indirizzoconsegnaTest',1),(41,1,'2022-01-10','indirizzoconsegnaTest',1),(42,1,'2022-01-10','indirizzoconsegnaTest',1),(43,1,'2022-01-10','indirizzoconsegnaTest',1),(44,1,'2022-01-10','indirizzoconsegnaTest',1),(45,1,'2022-01-10','indirizzoconsegnaTest',1),(46,1,'2022-01-10','indirizzoconsegnaTest',1),(47,1,'2022-01-10','indirizzoconsegnaTest',1),(48,1,'2022-01-10','indirizzoconsegnaTest',1),(49,1,'2022-01-10','indirizzoconsegnaTest',1),(50,1,'2022-01-10','indirizzoconsegnaTest',1),(51,1,'2022-01-10','indirizzoconsegnaTest',1),(52,1,'2022-01-10','indirizzoconsegnaTest',1),(53,1,'2022-01-10','indirizzoconsegnaTest',1),(54,1,'2022-01-10','indirizzoconsegnaTest',1),(55,1,'2022-01-10','indirizzoconsegnaTest',1),(56,1,'2022-01-10','indirizzoconsegnaTest',1),(57,1,'2022-01-10','indirizzoconsegnaTest',1),(58,1,'2022-01-10','indirizzoconsegnaTest',1);
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

-- Dump completed on 2022-02-07 22:23:51
