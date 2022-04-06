CREATE DATABASE  IF NOT EXISTS `office_hour_queue` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `office_hour_queue`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: office_hour_queue
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
-- Table structure for table `course`
--
use office_hour_queue;

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_number` int NOT NULL,
  `teaching_assistant` varchar(255) DEFAULT NULL,
  `professor` varchar(255) NOT NULL,
  PRIMARY KEY (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (111,'Bob Smith','David Hayes'),(151,'John Doe','Stefan Cobeli'),(301,'Freddy Gibbs','Bello Gonzalo'),(362,'Bing Chilling','Mitchell Theys'),(480,'DeMarcus Cousins','Diana Diaz'),(499,'','John Bell');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_hour`
--

DROP TABLE IF EXISTS `office_hour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `office_hour` (
  `id_office_hour` int NOT NULL,
  `course_number` int NOT NULL,
  `ta_email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `meetup_time` varchar(255) DEFAULT NULL,
  `meetup_date` date DEFAULT NULL,
  PRIMARY KEY (`id_office_hour`),
  FOREIGN KEY (course_number) REFERENCES course(course_number)
	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_hour`
--

LOCK TABLES `office_hour` WRITE;
/*!40000 ALTER TABLE `office_hour` DISABLE KEYS */;
INSERT INTO `office_hour` VALUES (1,301,'fGibbs@uic.edu','Blackboard Collaborate','12:00:00','2022-03-30'),(2,362,'bChilling@uic.edu','Zoom','13:00:00','2022-04-01');
/*!40000 ALTER TABLE `office_hour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queue`
--


DROP TABLE IF EXISTS `queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `queue` (   
`id_queue` int NOT NULL,   
`student_email` varchar(255) DEFAULT NULL,   
`full_name` varchar(255) DEFAULT NULL,   
`follow_up` varchar(255) DEFAULT NULL,   
`queue_date` datetime DEFAULT NULL,   
`officeHourID` int NOT NULL,   
PRIMARY KEY (`id_queue`),   
FOREIGN KEY (officeHourID) REFERENCES office_hour(id_office_hour)  ON DELETE CASCADE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queue`
--

LOCK TABLES `queue` WRITE;
/*!40000 ALTER TABLE `queue` DISABLE KEYS */;
INSERT INTO `queue` VALUES ('1','ddanci2@uic.edu','Darian Danciu','No','2022-03-30 00:00:00',1),('2','aodich5@uic.edu','Amanuel Odicho','No','2022-04-01 00:00:00',2);
/*!40000 ALTER TABLE `queue` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
	`student_email` varchar(255) NOT NULL,
    `course_number` int NOT NULL,
    PRIMARY KEY (`student_email`, `course_number`),
    FOREIGN KEY (`student_email`) REFERENCES student(`student_email`)
		ON DELETE CASCADE,
	FOREIGN KEY (`course_number`) REFERENCES course(`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `queueID` int DEFAULT NULL,
  `is_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_email`),
  UNIQUE KEY `student_email_UNIQUE` (`student_email`),
  FOREIGN KEY (`student_email`) REFERENCES course_student(`student_email`),
  FOREIGN KEY (`student_email`) REFERENCES ta_list(`ta_email`),
  FOREIGN KEY (`queueID`) REFERENCES queue(`id_queue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('aodich5@uic.edu','Amanuel Odicho','','2','No'),('bChilling@uic.edu','Bing Chilling','','','Yes'),('bSmith@uic.edu','Bob Smith','','','Yes'),('dCousins@uic.edu','DeMarcus Cousins','','','Yes'),('ddanci2@uic.edu','Darian Danciu','','1','No'),('fGibbs@uic.edu','Freddy Gibbs','','','Yes'),('jDoe@uic.edu','John Doe','','','Yes');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ta_list`
--

DROP TABLE IF EXISTS `ta_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ta_list` (
  `ta_email` varchar(255) NOT NULL,
  `ta_course_number` int NOT NULL,
  `ta_course_department` varchar(255) NOT NULL,
  PRIMARY KEY (`ta_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ta_list`
--

LOCK TABLES `ta_list` WRITE;
/*!40000 ALTER TABLE `ta_list` DISABLE KEYS */;
INSERT INTO `ta_list` VALUES ('bChilling@uic.edu',362,'CS'),('bSmith@uic.edu',111,'CS'),('dCousins@uic.edu',480,'CS'),('fGibbs@uic.edu',301,'CS'),('jDoe@uic.edu',151,'CS');
/*!40000 ALTER TABLE `ta_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('A','b','c'),('abc','abc1','abc2'),('pd4','pd4a','pd4b'),('pd4test','pd4test1','pd4test2'),('test','test1','test'),('test_a','test_a1','test_a2');
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

-- Dump completed on 2022-03-30 21:07:24
