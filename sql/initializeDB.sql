DROP DATABASE IF EXISTS `office_hour_queue`;
CREATE DATABASE IF NOT EXISTS `office_hour_queue`;
USE `office_hour_queue`;

-- Table structure for table `course`
--
use office_hour_queue;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_number` int NOT NULL,
  `teaching_assistant` varchar(255) DEFAULT NULL,
  `professor` varchar(255) NOT NULL,
  PRIMARY KEY (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
INSERT INTO `course` VALUES (111,'Bob Smith','David Hayes'),(151,'John Doe','Stefan Cobeli'),(301,'Freddy Gibbs','Bello Gonzalo'),(362,'Bing Chilling','Mitchell Theys'),(480,'DeMarcus Cousins','Diana Diaz'),(499,'','John Bell');
UNLOCK TABLES;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `office_hour`
--

DROP TABLE IF EXISTS `office_hour`;
CREATE TABLE `office_hour` (
  `id_office_hour` int NOT NULL,
  `course_number` int NOT NULL,
  `ta_email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `meetup_time` varchar(255) DEFAULT NULL,
  `meetup_date` date DEFAULT NULL,
  PRIMARY KEY (`id_office_hour`),
  FOREIGN KEY (course_number) REFERENCES course(course_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `office_hour`
--

LOCK TABLES `office_hour` WRITE;
INSERT INTO `office_hour` VALUES (1,301,'fGibbs@uic.edu','Blackboard Collaborate','12:00:00','2022-03-30'),(2,362,'bChilling@uic.edu','Zoom','13:00:00','2022-04-01');
UNLOCK TABLES;

--
-- Table structure for table `queue`
--
DROP TABLE IF EXISTS `queue`;
CREATE TABLE `queue` (   
`id_queue` int NOT NULL,   
`student_email` varchar(255) DEFAULT NULL,   
`full_name` varchar(255) DEFAULT NULL,   
`follow_up` varchar(255) DEFAULT NULL,   
`queue_date` date DEFAULT NULL,   
`officeHourID` int NOT NULL,   
PRIMARY KEY (`id_queue`),
FOREIGN KEY (student_email) REFERENCES student(student_email),
FOREIGN KEY (officeHourID) REFERENCES office_hour(id_office_hour)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `queue`
--

LOCK TABLES `queue` WRITE;
INSERT INTO `queue` VALUES ('1','ddanci2@uic.edu','Darian Danciu','No','2022-03-30 00:00:00',1),('2','aodich5@uic.edu','Amanuel Odicho','No','2022-04-01 00:00:00',2);
UNLOCK TABLES;



DROP TABLE IF EXISTS `course_student`;
CREATE TABLE `course_student` (
	`student_email` varchar(255) NOT NULL,
    `course_number` int NOT NULL,
    PRIMARY KEY (`student_email`, `course_number`),
    FOREIGN KEY (student_email) REFERENCES student(student_email) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (course_number) REFERENCES course(course_number) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `queueID` int DEFAULT NULL,
  `is_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_email`),
  FOREIGN KEY (queueId) REFERENCES queue(id_queue),
  UNIQUE KEY `student_email_UNIQUE` (`student_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
INSERT INTO `student` VALUES ('aodich5@uic.edu','Amanuel Odicho','',2,'No'),('bChilling@uic.edu','Bing Chilling','',null,'Yes'),('bSmith@uic.edu','Bob Smith','',null,'Yes'),('dCousins@uic.edu','DeMarcus Cousins','',null,'Yes'),('ddanci2@uic.edu','Darian Danciu','',1,'No'),('fGibbs@uic.edu','Freddy Gibbs','',null,'Yes'),('jDoe@uic.edu','John Doe','',null,'Yes');
UNLOCK TABLES;

--
-- Table structure for table `ta_list`
--

DROP TABLE IF EXISTS `ta_list`;
CREATE TABLE `ta_list` (
  `ta_email` varchar(255) NOT NULL,
  `ta_course_number` int NOT NULL,
  `ta_course_department` varchar(255) NOT NULL,
  PRIMARY KEY (`ta_email`),
  FOREIGN KEY (ta_email) REFERENCES student(student_email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ta_list`
--

LOCK TABLES `ta_list` WRITE;
INSERT INTO `ta_list` VALUES ('bChilling@uic.edu',362,'CS'),('bSmith@uic.edu',111,'CS'),('dCousins@uic.edu',480,'CS'),('fGibbs@uic.edu',301,'CS'),('jDoe@uic.edu',151,'CS');
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('A','b','c'),('abc','abc1','abc2'),('pd4','pd4a','pd4b'),('pd4test','pd4test1','pd4test2'),('test','test1','test'),('test_a','test_a1','test_a2');
UNLOCK TABLES;

