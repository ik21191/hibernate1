/*
SQLyog Community- MySQL GUI v8.21 
MySQL - 5.6.31-log : Database - hibernate1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hibernate1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hibernate1`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(40) DEFAULT NULL,
  `city_name` varchar(40) DEFAULT NULL,
  `state_name` varchar(40) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`street_name`,`city_name`,`state_name`,`zipcode`) values (7,'Kondapur','Hyderabad','AP','532'),(8,'Kondapur','Hyderabad','AP','532');

/*Table structure for table `bankemployee` */

DROP TABLE IF EXISTS `bankemployee`;

CREATE TABLE `bankemployee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `address` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `bankemployee` */

insert  into `bankemployee`(`id`,`first_name`,`last_name`,`salary`,`address`) values (7,'Manoj','Kumar',5000,7),(8,'Dilip','Kumar',3000,8),(9,'Manoj','Kumar',5000,9),(10,'Dilip','Kumar',3000,10);

/*Table structure for table `bankemployeeaddress` */

DROP TABLE IF EXISTS `bankemployeeaddress`;

CREATE TABLE `bankemployeeaddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(40) DEFAULT NULL,
  `city_name` varchar(40) DEFAULT NULL,
  `state_name` varchar(40) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `bankemployeeaddress` */

insert  into `bankemployeeaddress`(`id`,`street_name`,`city_name`,`state_name`,`zipcode`) values (7,'Kondapur','Hyderabad','AP','532'),(8,'Saharanpur','Ambehta','UP','111'),(9,'Kondapur','Hyderabad','AP','532'),(10,'Saharanpur','Ambehta','UP','111');

/*Table structure for table `certificate` */

DROP TABLE IF EXISTS `certificate`;

CREATE TABLE `certificate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `certificate_name` varchar(30) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `certificate` */

insert  into `certificate`(`id`,`certificate_name`,`employee_id`) values (21,'MBA',9),(22,'PMP',9),(23,'MCA',9),(24,'BCA',10),(25,'BA',10),(26,'MBA',11),(27,'PMP',11),(28,'MCA',11),(29,'BCA',12),(30,'BA',12);

/*Table structure for table `certificate_of_student` */

DROP TABLE IF EXISTS `certificate_of_student`;

CREATE TABLE `certificate_of_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `certificate_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `certificate_of_student` */

insert  into `certificate_of_student`(`id`,`certificate_name`) values (19,'MBA'),(20,'PMP'),(21,'MCA');

/*Table structure for table `courses1` */

DROP TABLE IF EXISTS `courses1`;

CREATE TABLE `courses1` (
  `COURSEID` int(11) NOT NULL,
  `COURSENAME` varchar(100) DEFAULT NULL,
  `DURATION` int(2) DEFAULT NULL,
  PRIMARY KEY (`COURSEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courses1` */

insert  into `courses1`(`COURSEID`,`COURSENAME`,`DURATION`) values (500,'Hibernate',7),(501,'Java',30);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `address` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`first_name`,`last_name`,`salary`,`address`) values (1,'Manoj','Kumar',4000,NULL),(2,'Dilip','Kumar',3000,NULL),(3,'Manoj','Kumar',4000,8),(4,'Dilip','Kumar',3000,8);

/*Table structure for table `employee1` */

DROP TABLE IF EXISTS `employee1`;

CREATE TABLE `employee1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `employee1` */

insert  into `employee1`(`id`,`first_name`,`last_name`,`salary`) values (9,'Manoj','Kumar',5000),(10,'Dilip','Kumar',3000),(11,'Manoj','Kumar',5000),(12,'Dilip','Kumar',3000);

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `dcolumn` varchar(20) DEFAULT NULL,
  `amt` double(7,2) DEFAULT NULL,
  `cctype` varchar(10) DEFAULT NULL,
  `cqtype` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `payment` */

insert  into `payment`(`pid`,`dcolumn`,`amt`,`cctype`,`cqtype`) values (10,'CC',2500.00,'Visa',NULL),(11,'cq',2600.00,NULL,'ICICI');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `ID` int(11) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `AGE` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`ID`,`name`,`AGE`) values (2,'PPP',12),(3,'QQQ',12),(4,'Vinay Kumar',83);

/*Table structure for table `person2` */

DROP TABLE IF EXISTS `person2`;

CREATE TABLE `person2` (
  `ID` int(5) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person2` */

insert  into `person2`(`ID`,`NAME`,`COUNTRY`) values (1,'Vinay Kumar','India'),(2,'Vinay Kumar','India'),(3,'Vinay Kumar','India');

/*Table structure for table `person3` */

DROP TABLE IF EXISTS `person3`;

CREATE TABLE `person3` (
  `ID` int(5) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `COUNTRY` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person3` */

insert  into `person3`(`ID`,`NAME`,`COUNTRY`) values (1,'Imran Khan','India'),(2,'Imran Khan','India'),(3,'Gautam Kumar','Africa'),(4,'Imran Khan','India');

/*Table structure for table `stu_cert` */

DROP TABLE IF EXISTS `stu_cert`;

CREATE TABLE `stu_cert` (
  `employee_id` int(11) NOT NULL,
  `certificate_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`,`certificate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu_cert` */

insert  into `stu_cert`(`employee_id`,`certificate_id`) values (13,19),(13,20),(13,21),(14,19),(14,20),(14,21);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`first_name`,`last_name`,`salary`) values (13,'Manoj','Kumar',5000),(14,'Dilip','Kumar',3000);

/*Table structure for table `student1` */

DROP TABLE IF EXISTS `student1`;

CREATE TABLE `student1` (
  `STUDENTID` int(11) NOT NULL,
  `STUDENTNAME` varchar(100) DEFAULT NULL,
  `MARKS` int(3) DEFAULT NULL,
  PRIMARY KEY (`STUDENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student1` */

insert  into `student1`(`STUDENTID`,`STUDENTNAME`,`MARKS`) values (100,'mmmmmm',98),(101,'Lee',99);

/*Table structure for table `students_courses` */

DROP TABLE IF EXISTS `students_courses`;

CREATE TABLE `students_courses` (
  `STUDENT_ID` int(11) DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `students_courses` */

insert  into `students_courses`(`STUDENT_ID`,`COURSE_ID`) values (100,500),(100,501),(101,500),(101,501);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
