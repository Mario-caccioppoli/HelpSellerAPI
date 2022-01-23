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
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES (1,'aldoo','aldo@libeo.it','password'),(2,'fabiooo','fabio@email.it','123'),(3,'bevande123','nuovaemail','123'),(12,'giangiorgio','gg@ald.org','giooooooonny'),(13,'gianfrancesco','aldo@gg.com','12345678qwertyuiop');
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'bevande@gmail.com','123','bevande SPA','111111','via piedi','descrizione modificata dal test',NULL),(2,'surgelati@gmail.com','234','surgelati','222222','via vai','vendiamo surgelati',NULL),(3,'messico@gmail.com','2982','mexican foods','333333','corso veloce','vendiamo cibo etnico',NULL);
/*!40000 ALTER TABLE `azienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `distributore`
--

LOCK TABLES `distributore` WRITE;
/*!40000 ALTER TABLE `distributore` DISABLE KEYS */;
INSERT INTO `distributore` VALUES (1,'mario','mario@gmail.com','111','mario','de gregorio','125425','2525145','napoli',0),(2,'pino','pino@p.p','3','pino','de gregorio','2','99','casa di ino',0),(3,'anselmo','lorazio@pe.it','56','anselmo','lorazio','5','78','casa di lorazio',0),(4,'elpido','elpiu@email.it','7','elpidio','siepe','3','666','via tenente nastri',0),(5,'fabio','piccioni@email.com','9','fabizio','mazza','7','657','via vai',0),(9,'prova','fabio@email.it','123','Fabio','Frizzi','1','333','via della sede',0);
/*!40000 ALTER TABLE `distributore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (4,'doc del test','aldo baglio',1,'2023-04-01'),(5,'DocumentoTest','aldo moro',1,'2022-01-10');
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (1,'commento modificato dal test','Generated',155,'2023-12-01','2022-12-01'),(2,NULL,'ricevuto',1,'2022-04-10','2022-01-10'),(3,NULL,'ricevuto',1,'2022-04-05','2022-01-05'),(4,'','Generated',1,'2023-12-01','2022-12-01'),(5,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(6,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(7,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(8,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(9,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(10,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(11,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(12,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(13,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(14,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(15,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(16,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(17,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(18,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(19,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(20,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(21,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(22,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(23,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(24,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(25,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(26,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(27,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(28,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(29,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(30,'commentoTest','Generated',1,'2022-01-21','2022-01-10'),(31,'commentoTest','Generated',1,'2022-01-21','2022-01-10');
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ordine_prodotto`
--

LOCK TABLES `ordine_prodotto` WRITE;
/*!40000 ALTER TABLE `ordine_prodotto` DISABLE KEYS */;
INSERT INTO `ordine_prodotto` VALUES (1,1,12,123,2),(2,2,1000,1150,1.15),(2,4,5000,10000,2),(3,3,500,500,1);
/*!40000 ALTER TABLE `ordine_prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'cola',4,'bevanda gusto cola generica',50,NULL,1,1,1,0),(2,'cherry cola',1.15,'bevanda gusto cola alla ciliegia',55,NULL,2,1,1,0),(3,'cola zero',1,'bevanda gusto cola zero calorie',40,NULL,3,1,1,0),(4,'sofficini',2,'sofficini generici surgelati',60,NULL,1,2,2,0),(5,'bastoncini',2,'bastoncini di merluzzo surgelati',50,NULL,2,2,2,0),(6,'kebab',3,'kebab surgelato',40,NULL,3,2,2,0),(7,'tacos',1.5,'tacos surgelati',20,NULL,1,3,3,0),(8,'chili sauce',1,'salsa chili piccante',10,NULL,2,3,3,0),(9,'kebab piccante',3,'kebab piccante surgelato',5,NULL,3,3,3,0),(10,'spicy doritos',1.8,'tortillas chips piccanti',1,'',4,3,3,0),(11,'salame piccante',2,'salame piccante',50,NULL,4,3,3,0),(12,'nduja',4,'salume piccante calabrese',50,NULL,4,3,3,0),(13,'peperoncino sott\'olio',3,'peperoncino sott\'olio',50,NULL,4,3,3,0),(14,'ali di pollo piccantoi',2,'alette di posso con osso',50,NULL,4,3,3,0),(15,'salsa piccante',1.5,'salsa piccante',50,NULL,4,3,3,0),(16,'Salsa Worcestershire',2,'Salsa Worcestershire',50,NULL,4,3,3,0);
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (1,'buona',3,'2022-01-20',50505,1),(2,'fa schifo',1,'2022-01-19',1,2),(3,'testo recensione',3,'2022-02-23',4,1),(4,'amo il piccante',5,'2022-02-23',9,9),(5,'amo il piccante',5,'2022-02-23',10,9),(6,'amo il piccante',4,'2022-02-23',11,9),(7,'amo il piccante',3,'2022-02-23',12,9),(8,'amo il piccante',5,'2022-02-23',13,9),(9,'amo il piccante',5,'2022-02-23',14,9),(10,'amo il piccante',5,'2022-02-23',15,9),(11,'amo il piccante',5,'2022-02-23',16,9),(12,'amo il piccante',4,'2022-02-23',9,3),(13,'amo anch\'io il piccante',5,'2022-02-23',10,3),(14,'amo anch\'io il piccante',5,'2022-02-23',11,3),(15,'amo anch\'io il piccante',5,'2022-02-23',12,3),(16,'amo anch\'io il piccante',5,'2022-02-23',13,3),(17,'bella cola',1,'2022-02-23',1,3),(18,'ottimo',5,'2022-02-23',10,2),(19,'ottimo',5,'2022-01-13',4,4),(20,'ottimo',5,'2022-01-13',5,4),(21,'ottimo',5,'2022-01-13',6,4),(22,'ottimo',5,'2022-01-13',7,4),(23,'debole relazione con piccante',4,'2022-01-13',15,5),(24,'nice',4,'2022-01-13',4,2),(25,'ok',5,'2022-01-13',16,5),(27,'recensione test fail',5,'2022-01-10',16,16),(29,'recensione test fail',5,'2022-01-10',16,160),(30,'recensione test fail',5,'2022-01-10',16,160),(31,'recensione test fail',5,'2022-01-10',16,160);
/*!40000 ALTER TABLE `recensione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sconto`
--

LOCK TABLES `sconto` WRITE;
/*!40000 ALTER TABLE `sconto` DISABLE KEYS */;
INSERT INTO `sconto` VALUES (4,'nome1',4,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(5,'nome2',50,'catalogo',NULL,3,'2022-09-10','2022-04-10'),(7,'nome3',10,'quantita',10,3,'2022-09-10','2022-08-10'),(8,'nome6',10,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(9,'nome100',10,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(10,'nome2900',70,'catalogo',NULL,3,'2022-09-10','2022-02-10'),(11,'newSconto',10,'catalogo',5,1,'2023-12-01','2022-12-01'),(12,'newSconto',10,'catalogo',5,1,'2023-12-01','2022-12-01');
/*!40000 ALTER TABLE `sconto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sconto_prodotto`
--

LOCK TABLES `sconto_prodotto` WRITE;
/*!40000 ALTER TABLE `sconto_prodotto` DISABLE KEYS */;
INSERT INTO `sconto_prodotto` VALUES (4,7),(4,8),(5,9),(5,10);
/*!40000 ALTER TABLE `sconto_prodotto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `trasporto`
--

LOCK TABLES `trasporto` WRITE;
/*!40000 ALTER TABLE `trasporto` DISABLE KEYS */;
INSERT INTO `trasporto` VALUES (1,1,'2022-01-01','nuovo indirizzo',1),(2,1,'2022-01-10','asd',1),(3,1,'2022-01-10','indirizzoconsegnaTest',1),(4,1,'2022-01-10','indirizzoconsegnaTest',1),(5,1,'2022-01-10','indirizzoconsegnaTest',1),(6,1,'2022-01-10','indirizzoconsegnaTest',1),(7,1,'2022-01-10','indirizzoconsegnaTest',1),(8,1,'2022-01-10','indirizzoconsegnaTest',1),(9,1,'2022-01-10','indirizzoconsegnaTest',1),(10,1,'2022-01-10','indirizzoconsegnaTest',1),(11,1,'2022-01-10','indirizzoconsegnaTest',1),(12,1,'2022-01-10','indirizzoconsegnaTest',1),(13,1,'2022-01-10','indirizzoconsegnaTest',1),(14,1,'2022-01-10','indirizzoconsegnaTest',1),(15,1,'2022-01-10','indirizzoconsegnaTest',1),(16,1,'2022-01-10','indirizzoconsegnaTest',1),(17,1,'2022-01-10','indirizzoconsegnaTest',1),(18,1,'2022-01-10','indirizzoconsegnaTest',1),(19,1,'2022-01-10','indirizzoconsegnaTest',1),(20,1,'2022-01-10','indirizzoconsegnaTest',1),(21,1,'2022-01-10','indirizzoconsegnaTest',1),(22,1,'2022-01-10','indirizzoconsegnaTest',1),(23,1,'2022-01-10','indirizzoconsegnaTest',1);
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

-- Dump completed on 2022-01-24  0:42:55
