-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` text NOT NULL,
  `author_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`),
  KEY `articles_ibfk_1` (`author_id`),
  CONSTRAINT `articles_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (1,'文章標題 1','文章內容 1 ...',1),(2,'文章標題 2','文章內容 2 ...',55),(3,'文章標題 3','文章內容 3 ...',56),(4,'文章標題 4','文章內容 4 ...',57),(5,'文章標題 5','文章內容 5 ...',58),(6,'文章標題 6','文章內容 6 ...',59),(7,'文章標題 7','文章內容 7 ...',60),(8,'文章標題 8','文章內容 8 ...',61),(9,'文章標題 9','文章內容 9 ...',62),(10,'文章標題 10','文章內容 10 ...',63),(11,'文章標題 11','文章內容 11 ...',64),(12,'文章標題 12','文章內容 12 ...',65),(13,'文章標題 13','文章內容 13 ...',55),(14,'文章標題 14','文章內容 14 ...',55),(15,'文章標題 15','文章內容 15 ...',57),(16,'文章標題 16','文章內容 16 ...',58),(17,'文章標題 17','文章內容 17 ...',55),(18,'文章標題 18','文章內容 18 ...',59),(19,'文章標題 19','文章內容 19 ...',60),(20,'文章標題 20','文章內容 20 ...',56),(21,'文章標題 21','文章內容 21 ...',57),(22,'文章標題 22','文章內容 22 ...',59),(23,'文章標題 23','文章內容 23 ...',61),(24,'文章標題 24','文章內容 24 ...',62),(25,'文章標題 25','文章內容 25 ...',64),(26,'文章標題 26','文章內容 26 ...',65),(27,'文章標題 27','文章內容 27 ...',64),(28,'文章標題 28','文章內容 28 ...',63),(29,'文章標題 29','文章內容 29 ...',63),(30,'文章標題 30','文章內容 30 ...',63);
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'james5603@gmail.com','00000000'),(55,'test@gmail.com','00000000'),(56,'test1@gmail.com','00000000'),(57,'test2@gmail.com','00000000'),(58,'test3@gmail.com','00000000'),(59,'test4@gmail.com','00000000'),(60,'test5@gmail.com','00000000'),(61,'test6@gmail.com','00000000'),(62,'test7@gmail.com','00000000'),(63,'test8@gmail.com','00000000'),(64,'test9@gmail.com','00000000'),(65,'test10@gmail.com','00000000'),(66,'9uxhdiuajsoid@oiusfas','2666226+'),(67,'abc@bc','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-11  9:36:23
