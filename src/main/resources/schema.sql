CREATE TABLE `indian_case_time_series` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `date` varchar(50) NOT NULL,
  `date1` date DEFAULT NULL,
  `daily_confirmed` varchar(20) NOT NULL,
  `total_confirmed` varchar(20) NOT NULL,
  `daily_recovered` varchar(20) NOT NULL,
  `total_recovered` varchar(20) NOT NULL,
  `daily_deceased` varchar(20) NOT NULL,
  `total_deceased` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=276684 DEFAULT CHARSET=latin1;
