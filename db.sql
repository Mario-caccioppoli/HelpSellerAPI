CREATE DATABASE  IF NOT EXISTS `helpseller` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `helpseller`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: helpseller
-- ------------------------------------------------------
-- Server version	8.0.28

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
INSERT INTO `amministratore` VALUES (1,'AldoAdmin','aldo@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63');
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
  `indirizzo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descrizione` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `logo` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `azienda`
--

LOCK TABLES `azienda` WRITE;
/*!40000 ALTER TABLE `azienda` DISABLE KEYS */;
INSERT INTO `azienda` VALUES (1,'algida@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Algida','111111','Roma, Italia','Algida è un marchio italiano specializzato nella produzione di gelati confezionati facente parte della divisione Heartbrand della multinazionale olandese-britannica Unilever. ','algida.png'),(2,'findus@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Findus','222222','Bjuv, Svezia','Findus è un marchio che produce cibo surgelato destinato alla commercializzazione al dettaglio. In Italia è leader di mercato nel settore del pesce prefritto surgelato e con il marchio 4 Salti in Padella Findus in quello dei piatti pronti surgelati.','findus.png'),(3,'knorr@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Knorr','333333','Heilbronn, Germania','La Knorr è una storica azienda tedesca che produce alimentari, in particolare cibi \"già pronti\" e condimenti per pietanze. Dal 2000 fa parte della multinazionale Unilever.','knorr.png'),(4,'lipton@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Lipton','444444','Glasgow, Scozia','Lipton è una azienda produttrice di tè di attuale proprietà della Unilever.','lipton.png'),(5,'bertolli@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Bertolli','555555','Inveruno, Italia','Bertolli è un\'azienda alimentare italiana specializzata nel settore dell\'olio di oliva, oggi di proprietà del gruppo olandese-britannica Unilever e società spagnolo Deoleo S.A.','bertolli.png'),(6,'coccolino@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Coccolino','666666','Scottsdale, Arizona, Stati Uniti','Coccolino è un marchio commerciale globale di ammorbidenti posseduto da Unilever conosciuto sul mercato per l\'omonimo orsacchiotto che compare come mascotte sulle confezioni e nelle pubblicità dei prodotti nonché come franchise per alcuni gadgets.','coccolino.jpg'),(7,'dove@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Dove','777777','Londra, Regno Unito','Dove è un marchio di prodotti per l\'igiene personale, principalmente sapone, di proprietà della Unilever. I prodotti sono venduti in oltre 81 paesi e per donne e uomini a disposizione. Il logo è una colomba, da cui il nome.','dove.png'),(8,'sunsilk@unilever.com','2ac9cb7dc02b3c0083eb70898e549b63','Sunsilk','888888','Londra, Regno Unito','Sunsilk è un marchio britannico di prodotti per la cura dei capelli, principalmente indirizzati ad un target femminile, prodotto dal gruppo Unilever, considerata l\'azienda leader al mondo nelle vendite di balsamo per capelli, e la seconda per le vendite di shampoo.','sunsilk.png');
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
  `telefono` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `indirizzo_sede` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id_ordine_prova` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `VATNumber_UNIQUE` (`vat`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `ordineprova_idx` (`id_ordine_prova`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distributore`
--

LOCK TABLES `distributore` WRITE;
/*!40000 ALTER TABLE `distributore` DISABLE KEYS */;
INSERT INTO `distributore` VALUES (17,'danieleiervolino','daniele.iervo@gmail.com','2ac9cb7dc02b3c0083eb70898e549b63','Daniele','Iervolino','1122334455','+39 3808681871','Via della Scienza 20, 82021 Apice (BN), IT',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (1,'Coccolino by Moschino Shine',5,'Maestri profumieri hanno dato vita ad un luminoso ed intenso elisir floreale di orchidee, combinato con eleganti note di cedro e frutti rossi. Lascia avvolgere i tuoi capi da un radioso e sofisticato profumo, e splendi ogni giorno più che mai!',10000,'coccolino-1.png',1,1,6,10),(2,'Coccolino Sandalo & Caprifoglio Ammorbidente',4,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',12000,'coccolino-2.png',2,3,6,10),(3,'Coccolino Ammorbidente Aria di Primavera',4,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',7000,'coccolino-3.png',2,3,6,10),(4,'Coccolino Ecocert Ylang Ylang Ammorbidente',3,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',11000,'coccolino-4.jpeg',2,2,6,10),(5,'Coccolino Ammorbidente Sensazione Seta',3,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',9500,'coccolino-5.png',2,2,6,10),(6,'Coccolino Ammorbidente Gelsomino',2,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',8000,'coccolino-6.png',2,2,6,10),(7,'Cornetto Classico x8',3,'Cremoso gelato alla panna in una cialda croccante, in un formato 90ml in un multipack da 8',20000,'algida-1.png',1,2,1,80),(8,'Carte D\'Or Affogato all\'Amarena',2,'Gelato con variegatura all\'amarena (25%) e amarene candite.',18000,'algida-2.jpg',2,4,1,80),(9,'Cucciolone Standard x6',2,'I biscotti al malto con gelato alla vaniglia, al cacao e allo zabaglione.',12000,'algida-3.png',2,2,1,80),(10,'Café Zero, Te nero alla pesca',1,'Cremosa granita al tè nero e alla pesca.',5000,'algida-4.png',1,1,1,80),(11,'Café Zero, Espresso',1,'Cremosa granita al caffè con polvere di caffè zuccherato.',5000,'algida-5.jpg',1,1,1,80),(12,'Café Zero, Cappuccino',1,'Cremosa granita al cappuccino, guarnita con gelato al gusto di vaniglia e cacao magro in polvere zuccherato.',5000,'algida-6.jpg',1,1,1,80),(13,'Croccole',2,'Le mie Croccole sono fatte con 100% filetti di merluzzo da pesca sostenibile e certificata MSC. Per garantirti la massima qualità, sono sfilettati ancora freschi e surgelati entro 3 ore prima di essere avvolti nel mio pangrattato dorato ed extra-croccante, per un gusto inimitabile!',3000,'findus-1.png',1,1,2,50),(14,'Filetti di Platessa',2,'I miei filetti di platessa sono fatti con 100% Filetti di Platessa, fonte di vitamina B12, pescati nelle fredde acque dell\'Oceano Atlantico. Sono avvolti nel mio pangrattato, semplice e croccante, per un gusto inimitabile. Tutto il buono della semplicità!',3500,'findus-2.png',1,1,2,50),(15,'Bastoncini con Omega 3',3,'I miei bastoncini con omega 3 sono fatti con 100% Filetti di Merluzzo d’Alaska da pesca sostenibile e certificata MSC. Per garantirti la massima qualità, sono sfilettati ancora freschi e surgelati entro 3 ore prima di essere avvolti nel mio pangrattato extra-croccante, arricchiti con un goccio di olio di pesce che rende i miei bastoncini ricchi di omega 3.',2000,'findus-3.png',1,1,2,50),(16,'Bastoncini di Salmone',2,'I miei Bastoncini di Salmone sono fatti con pregiato Salmone rosa da pesca sostenibile e certificata MSC, avvolto in una deliziosa pastella e nel mio pangrattato extra-croccante, per un gusto inimitabile!',2800,'findus-4.png',1,1,2,50),(17,'Sofficini Pomodoro Più Mozzarella',1,'Ripieno vibrante, gusto roboante! I Sofficini Findus Pomodoro Più Mozzarella hanno più ripieno e più mozzarella: più golosi che mai! Fatti venire l\'acquolina in bocca con il gusto del pomodoro più un cuore di mozzarella filante! ',10000,'findus-5.png',1,1,2,50),(18,'Sofficini Cheddar e Bacon',1,'Ripieno vibrante, gusto roboante! I Sofficini Findus Cheddar e Bacon hanno più ripieno e più mozzarella: più golosi che mai! Fatti venire l\'acquolina in bocca con il gusto del cheddar e bacon più un cuore di mozzarella filante! ',7000,'findus-6.png',1,1,2,50),(19,'Brodo Granulare Pollo',1.5,'Il Brodo Granulare Knorr dà un sapore pieno ai tuoi piatti, rimanendo un condimento dal gusto leggero.',5000,'knorr-1.png',1,1,3,30),(20,'Brodo Granulare Manzo',1.5,'Il Brodo Granulare Knorr dà un sapore pieno ai tuoi piatti, rimanendo un condimento dal gusto leggero.',4000,'knorr-2.png',1,1,3,30),(21,'Brodo Granulare Vegetale',1.5,'Il Brodo Granulare Knorr dà un sapore pieno ai tuoi piatti, rimanendo un condimento dal gusto leggero.',10000,'knorr-3.png',1,1,3,30),(22,'Risotto Asparagi',0.8,'I Risotti Knorr sono fatti con Riso 100% Italiano e da agricoltura sostenibile',8000,'knorr-4.png',1,1,3,30),(23,'Risotto Milanese',0.8,'I Risotti Knorr sono fatti con Riso 100% Italiano e da agricoltura sostenibile',4000,'knorr-5.png',1,1,3,30),(24,'Risotto Zafferano e Porcini',0.8,'I Risotti Knorr sono fatti con Riso 100% Italiano e da agricoltura sostenibile',5000,'knorr-6.png',1,1,3,30),(25,'Lipton tè verde con zenzero e curcuma',0.4,'La vitamina C contribuisce alla normale funzione del sistema immunitario. Gustati il te verde Lipton allo zenzero e curcuma, con vitamina C per il tuo benessere quotidiano. Si consiglia il consumo di una tazza al giorno, come parte di una dieta varia ed equilibrata e uno stile di vita sano. ',3000,'lipton-1.png',1,1,4,50),(26,'Lipton Erbe per Tisana Detox',0.4,'Olmaria e ortica sono rinomate note per le loro proprietà purificanti. Concediti un momento per purificare la mente e il corpo con la Tisana Detox. ',2500,'lipton-2.png',1,1,4,50),(27,'Lipton Ice Tea Limone',0.4,'Lipton Ice Tea Limone, rinfrescante tè freddo al gusto di limone e a basso contenuto calorico, ideale per tutte le occasioni.',3400,'lipton-3.png',1,1,4,50),(28,'Lipton Ice Tea Zero Green Lemon',0.4,'Lipton Green Ice Tea Zero, la freschezza del tè verde al gusto Limone, senza zucchero e a basso contenuto calorico, per un\'immediata sensazione di leggerezza.',5000,'lipton-4.png',1,1,4,50),(29,'Lipton Tè Nero allo Zenzero',0.5,'La vivacità dello zenzero incontra il gusto intenso del tè nero, la qualità numero uno di Lipton con un gusto aromatico e naturalmente speziato. Con filtro compostabile e confezione senza plastica. ',5600,'lipton-5.png',1,1,4,50),(30,'Lipton Tè nero Yellow Label',0.8,'Assapora il sole in ogni tazza di tè Lipton Yellow Label. Realizzato con foglie di tè maturate sotto il sole splendente delle piantagioni equatoriali, per un gusto naturale e intenso.',10000,'lipton-6.png',1,1,4,50),(31,'Bertolli Gentile',3,'Bertolli Gentile è un olio extra vergine di oliva dall’aroma delicato e un colore verde tendente al paglierino. Indicato per chi ama i gusti delicati, risulta di solito apprezzato dai bambini per il suo sapore non aggressivo.',4000,'bertolli-1.png',2,2,5,50),(32,'Bertolli Fragrante',3,'Bertolli Fragrante è un olio extra vergine di oliva dal carattere vivace che si distingue per il suo aroma invitante e fresco. Chi ama profumi intensi, gusti sfiziosi, troverà in questa varietà di olio il condimento ideale.',4000,'bertolli-2.png',2,2,5,50),(33,'Bertolli Robusto',3.5,'Bertolli Robusto è un olio extravergine di oliva di grande personalità che offre un aroma ricco e gradevolmente deciso. E’perfetto per chi a tavola non scende a compromessi e ama i sapori forti.',3500,'bertolli-3.png',2,2,5,50),(34,'Bertolli Originale',2.8,'È un olio extra vergine di oliva semplice e tradizionale, ideale per accompagnare i piatti più gustosi della nostra tradizione culinaria.',3000,'bertolli-4.png',2,2,5,50),(35,'Bertolli Ideale per Cucinare',3,'Il tradizionale Olio di Oliva Bertolli è un prodotto estremamente versatile, indispensabile per tutti coloro che amano la buona cucina. Ideale per cotture ad alte temperature fino a 210°, ma anche per friggere e per la preparazione di sughi e salse.',3000,'bertolli-5.png',2,2,5,50),(36,'Bertolli Tomato & Basil',3,'Salsa di pomodoro e basilico classica.',3000,'bertolli-6.png',2,2,5,50),(37,'Coccolino Ammorbidente Delicato & Soffice ',2,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',2000,'coccolino-7.png',2,2,6,10),(38,'Coccolino Menta & Lavanda Ammorbidente ',3,'Coccolino ammorbidente concentrato Intense Care è formulato con la rivoluzionaria tecnologia Pro-Fibre che penetra in profondità nelle fibre e le protegge dai danni causati dai lavaggi',3500,'coccolino-8.jpg',2,3,6,10),(39,'Freddolone',1,'Ghiaccioli a vari gusti',2000,'algida-7.jpg',1,2,1,20),(40,'Lemonissimo',1.5,'Ghiacciolo cremoso al limone',3000,'algida-8.jpg',1,2,1,20),(41,'Burger Vegetali',2,'Come sono fatti i Burger Vetegali Findus Green Cuisine? Scegliamo i piselli di una varietà particolare, prendiamo le loro proteine, ricettiamo con gustose erbe e spezie ed ecco dei Burger Vegetali nutrienti e gustosi ideali per tutti, vegetariani e non!',2000,'findus-7.png',1,1,2,50),(42,'Polpette Vegetali',2,'Grazie all\'utilizzo della proteina dei piselli Findus, Green Cuisine è la nuova linea di prodotti vegetali per chi vuole avere un\'alternativa alla carne, nutriente e sostenibile senza compromessi sul gusto!',2000,'findus-8.png',1,1,2,50),(43,'Magia D\'Aromi soffritto',1,'Miscela di erbe aromatiche per insaporire i tuoi piatti',4000,'knorr-7.png',1,1,3,70),(44,'Gran Purè',1,'Un contorno nutriente per accompagnare i tuoi pasti.',4500,'knorr-8.png',1,1,3,70),(45,'Lipton Solubile Pesca',0.4,'Se hai voglia di una gustosa bevanda rinfrescante prova il tè freddo solubile alla pesca Lipton. Facilissimo da preparare: basta aggiungere acqua ed è subito pronto.',2000,'lipton-7.png',1,1,4,50),(46,'Lipton Solubile Limone',0.4,'Se hai voglia di una gustosa bevanda rinfrescante prova il tè freddo solubile al limone Lipton. Facilissimo da preparare: basta aggiungere acqua ed è subito pronto.',2000,'lipton-8.png',1,1,4,50),(47,'Bertolli Four Cheese Alfredo',2,'Salsa Alfredo ai quattro formaggi',9000,'bertolli-7.jpg',1,1,5,40),(48,'Bertolli Marinara Souce',2,'Salsa Marinara made in Italy',8000,'bertolli-8.jpg',1,1,5,40),(49,'Shampoo Ricostruzione Intensiva',2,'Shampoo per la ricostruzione dei capelli',5000,'dove-1.png',1,1,7,50),(50,'Shampoo Idratazione Quotidiana',2,'Shampoo per idratare i capelli tutti i giorni',5000,'dove-2.png',1,1,7,50),(51,'Shampoo Protezione Colore',2,'Shampoo per proteggere il tuo colore',4000,'dove-3.png',1,1,7,50),(52,'Shampoo Anti-Crespo',2,'Shampoo per prevenire i capelli crespi',3500,'dove-4.png',1,1,7,50),(53,'Balsamo Anti-Crespo',3,'Balsamo per aiutare i capelli crespi',4000,'dove-5.png',1,1,7,50),(54,'Balsamo Ricostruzione Intensiva',3,'Balsamo per la ricostruzione intensiva dei capelli danneggiati',3000,'dove-6.png',1,1,7,50),(55,'Balsamo Protezione Colore',3,'Balsamo per proteggere il tuo colore',3500,'dove-7.png',1,1,7,50),(56,'Balsamo Idratazione Quotidiana',3,'Balsamo per idratare quotidianamente i tuoi capelli',3000,'dove-8.png',1,1,7,50),(57,'Shampoo Sunsilk Ricostruzione Intensiva',2,'Cancella i segni dei danni visibili dal 1° lavaggio. Il suo segreto è la formula esclusiva con calcio e cheratina.',2500,'sunsilk-1.png',1,1,8,40),(58,'Balsamo Sunsilk Ricostruzione Intensiva',2,'Cancella i segni dei danni visibili dal 1° lavaggio, con calcio e cheratina, per capelli pieni di vita e morbidi al tatto.',2500,'sunsilk-2.png',1,1,8,40),(59,'Crema Districante Ricostruzione Intensiva',2,'Effetto 24 ore! Crema senza risciacquo, cancella i segni dei danni visibili dei capelli dal 1° minuto e li protegge tutto il giorno.',4000,'sunsilk-3.png',1,1,8,40),(60,'Shampoo Liscio Perfetto',2,'Azione anti-umidità, i capelli sono setosi, pieni di vitalità e movimento, senza l\'effetto crespo grazie alla tecnologia straight-lock.',4000,'sunsilk-4.png',1,1,8,40),(61,'Balsamo Liscio Perfetto',2,'Azione anti-umidità, i capelli sono setosi, pieni di vitalità e movimento, senza l\'effetto crespo grazie alla tecnologia straight-lock.',4000,'sunsilk-5.png',1,1,8,40),(62,'Crema Districante Liscio Perfetto',2,'Effetto 24 ore e azione anti-umidità! Crema senza risciacquo, allinea le fibre capillari e mantiene i capelli setosi per tutta la giornata!',3500,'sunsilk-6.png',1,1,8,40),(63,'Crema Districante Ricci Definiti',2,'Effetto 24 ore! Crema senza risciacquo per ricci visibilmente idratati, definiti, elastici, totalmente sotto controllo per tutto il giorno!',3600,'sunsilk-7.png',1,1,8,40),(64,'Crema Disciplinante Scintille di Luce',3,'La Crema Disciplinante è il tuo alleato per avere capelli morbidi e setosi, addio effetto crespo! La formula senza risciacquo si assorbe istantaneamente, perfetta per disciplinare sia i capelli lisci sia i ricci!',2000,'sunsilk-8.png',1,1,8,40);
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

-- Dump completed on 2022-02-14 18:40:06
