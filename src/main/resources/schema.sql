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

CREATE TABLE `state_wise_covid_stats` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `state` varchar(20) NOT NULL,
  `confirmed` varchar(20) NOT NULL,
  `recovered` varchar(20) NOT NULL,
  `deaths` varchar(20) NOT NULL,
  `active` varchar(20) NOT NULL,
  `state_code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=476684 DEFAULT CHARSET=latin1;

ALTER TABLE state_wise_covid_stats
MODIFY COLUMN state varchar(50)
