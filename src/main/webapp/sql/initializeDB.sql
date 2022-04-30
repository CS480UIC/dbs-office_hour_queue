DROP DATABASE IF EXISTS office_hour_queue;

CREATE DATABASE `office_hour_queue` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use `office_hour_queue`;

CREATE TABLE `course` (
  `course_number` int NOT NULL,
  `teaching_assistant` varchar(255) DEFAULT NULL,
  `professor` varchar(255) NOT NULL,
  PRIMARY KEY (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `office_hour` (
  `id_office_hour` int NOT NULL,
  `course_number` int NOT NULL,
  `ta_email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `meetup_time` varchar(255) DEFAULT NULL,
  `meetup_date` date DEFAULT NULL,
  PRIMARY KEY (`id_office_hour`),
  KEY `course_number` (`course_number`),
  CONSTRAINT `office_hour_ibfk_1` FOREIGN KEY (`course_number`) REFERENCES `course` (`course_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student` (
  `student_email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `queueID` int DEFAULT NULL,
  `is_ta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_email`),
  UNIQUE KEY `student_email_UNIQUE` (`student_email`),
  KEY `queueID` (`queueID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `queue` (
  `id_queue` int NOT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `follow_up` varchar(255) DEFAULT NULL,
  `queue_date` date DEFAULT NULL,
  `officeHourID` int NOT NULL,
  PRIMARY KEY (`id_queue`),
  KEY `student_email` (`student_email`),
  KEY `officeHourID` (`officeHourID`),
  CONSTRAINT `queue_ibfk_1` FOREIGN KEY (`student_email`) REFERENCES `student` (`student_email`),
  CONSTRAINT `queue_ibfk_2` FOREIGN KEY (`officeHourID`) REFERENCES `office_hour` (`id_office_hour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `course_student` (
  `student_email` varchar(255) NOT NULL,
  `course_number` int NOT NULL,
  PRIMARY KEY (`student_email`,`course_number`),
  KEY `course_number` (`course_number`),
  CONSTRAINT `course_student_ibfk_1` FOREIGN KEY (`student_email`) REFERENCES `student` (`student_email`),
  CONSTRAINT `course_student_ibfk_2` FOREIGN KEY (`student_email`) REFERENCES `student` (`student_email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `course_student_ibfk_3` FOREIGN KEY (`course_number`) REFERENCES `course` (`course_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ta_list` (
  `ta_email` varchar(255) NOT NULL,
  `ta_course_number` int NOT NULL,
  `ta_course_department` varchar(255) NOT NULL,
  PRIMARY KEY (`ta_email`),
  CONSTRAINT `ta_list_ibfk_1` FOREIGN KEY (`ta_email`) REFERENCES `student` (`student_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `student` WRITE;
INSERT INTO `student` VALUES ('aodich5@uic.edu','Amanuel Odicho','',2,'No'),('bChilling@uic.edu','Bing Chilling','',0,'Yes'),('bSmith@uic.edu','Bob Smith','',0,'Yes'),('dCousins@uic.edu','DeMarcus Cousins','',0,'Yes'),('ddanci2@uic.edu','Darian Danciu','',1,'No'),('fGibbs@uic.edu','Freddy Gibbs','',0,'Yes'),('jDoe@uic.edu','John Doe','',0,'Yes');
UNLOCK TABLES;

LOCK TABLES `ta_list` WRITE;
INSERT INTO `ta_list` VALUES ('bChilling@uic.edu',362,'CS'),('bSmith@uic.edu',111,'CS'),('dCousins@uic.edu',480,'CS'),('fGibbs@uic.edu',301,'CS'),('jDoe@uic.edu',151,'CS');
UNLOCK TABLES;

LOCK TABLES `course` WRITE;
INSERT INTO `course` VALUES (111,'Bob Smith','David Hayes'),(151,'John Doe','Stefan Cobeli'),(301,'Freddy Gibbs','Bello Gonzalo'),(362,'Bing Chilling','Mitchell Theys'),(480,'DeMarcus Cousins','Diana Diaz'),(499,'','John Bell');
UNLOCK TABLES;

LOCK TABLES `office_hour` WRITE;
INSERT INTO `office_hour` VALUES (1,301,'fGibbs@uic.edu','Blackboard Collaborate','12:00:00','2022-03-30'),(2,362,'bChilling@uic.edu','Zoom','13:00:00','2022-04-01');
UNLOCK TABLES;

LOCK TABLES `queue` WRITE;
INSERT INTO `queue` VALUES ('1','ddanci2@uic.edu','Darian Danciu','No','2022-03-30 00:00:00',1),('2','aodich5@uic.edu','Amanuel Odicho','No','2022-04-01 00:00:00',2);
UNLOCK TABLES;

LOCK TABLES `course_student` WRITE;
INSERT INTO `course_student` VALUES ('bChilling@uic.edu', 362), ('bSmith@uic.edu', 111), ('dCousins@uic.edu', 480);
UNLOCK TABLES;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('A','b','c'),('abc','abc1','abc2'),('pd4','pd4a','pd4b'),('pd4test','pd4test1','pd4test2'),('test','test1','test'),('test_a','test_a1','test_a2');
UNLOCK TABLES;


CREATE VIEW course_view AS
SELECT * FROM course
WHERE course_number > 300
ORDER BY course_number;

-- simple query #2
CREATE VIEW office_hour_view AS
SELECT * FROM office_hour
WHERE meetup_date >= '2022-04-01'
ORDER BY id_office_hour;

-- AGGREGATE QUERY #1
CREATE VIEW upper_name_view AS
SELECT UPPER(full_name) from student
WHERE is_ta = 'No';

-- AGGREGATE QUERY #2
CREATE VIEW number_of_tas_view AS
SELECT COUNT(*) AS number_of_tas FROM student
WHERE is_ta = 'Yes';

-- COMPLEX QUERY #1
CREATE VIEW inner_join_view AS
select course_number from course
INNER JOIN ta_list
ON course.course_number = ta_list.ta_course_number;

-- COMPLEX QUERY #2
CREATE VIEW ta_view AS
SELECT teaching_assistant from course
WHERE course_number = (SELECT MIN(course_number) FROM office_hour);