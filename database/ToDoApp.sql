
CREATE DATABASE /*!32312 IF NOT EXISTS*/`todoapp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `todoapp`;

/*Table structure for table `graph_data` */

DROP TABLE IF EXISTS `graph_data`;

CREATE TABLE `graph_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `regcount` int(11) NOT NULL,
  `taskcount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_64mcwmh54q3ulu1gj7cd79jy9` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `task` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `username` varchar(255) NOT NULL,
  `accstatus` bit(1) NOT NULL,
  `birthdate` varchar(255) NOT NULL,
  `emailstatus` bit(1) NOT NULL,
  `id` int(11) NOT NULL,
  `lastactive` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

