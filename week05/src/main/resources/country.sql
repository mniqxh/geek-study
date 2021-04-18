/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) DEFAULT NULL,
  `country_code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `country` */

insert  into `country`(`id`,`country_name`,`country_code`) values 
(1,'中国','CN'),
(2,'美国','US'),
(3,'俄罗斯','RU'),
(4,'英国','GB'),
(5,'法国','FR');