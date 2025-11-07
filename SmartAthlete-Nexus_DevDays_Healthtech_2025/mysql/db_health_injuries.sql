-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 07, 2025 at 03:58 PM
-- Server version: 8.0.40
-- PHP Version: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_health_injuries`
--

-- --------------------------------------------------------

--
-- Table structure for table `athletes`
--

CREATE TABLE `athletes` (
  `id_athlete` varchar(50) NOT NULL,
  `id_coach` varchar(50) NOT NULL,
  `id_sport_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `athletes`
--

INSERT INTO `athletes` (`id_athlete`, `id_coach`, `id_sport_name`, `first_name`, `middle_name`, `last_name`, `date_of_birth`, `email`) VALUES
('US0b034e2e', 'US120', 'BASEBALL', '0b034e4c', '0b034', '0b034e4e', '2010-01-11', '0b034e4c.0b034e4e@my.com'),
('US0b03532e', 'US120', 'BASEBALL', '0b035342', '0b035', '0b035344', '2015-09-24', '0b035342.0b035344@my.com'),
('US0b0354aa', 'US120', 'BASEBALL', '0b0354b4', '0b035', '0b0354be', '2009-07-26', '0b0354b4.0b0354be@my.com'),
('US0b03569e', 'US120', 'BASEBALL', '0b0356a8', '0b035', '0b0356aa', '2007-06-29', '0b0356a8.0b0356aa@my.com'),
('US0b0357b6', 'US120', 'BASEBALL', '0b0357c0', '0b035', '0b0357ca', '2014-04-07', '0b0357c0.0b0357ca@my.com'),
('US0b03590a', 'US120', 'BASEBALL', '0b035914', '0b035', '0b03591e', '2011-06-24', '0b035914.0b03591e@my.com'),
('US0b0359fa', 'US120', 'BASEBALL', '0b035a04', '0b035', '0b035a06', '2017-12-21', '0b035a04.0b035a06@my.com'),
('US0b035ae0', 'US120', 'BASEBALL', '0b035aea', '0b035', '0b035af5', '2018-09-11', '0b035aea.0b035af5@my.com'),
('US0b035bd0', 'US120', 'BASEBALL', '0b035bda', '0b035', '0b035bdc', '2017-01-17', '0b035bda.0b035bdc@my.com'),
('US0b035cc0', 'US120', 'BASEBALL', '0b035cca', '0b035', '0b035ccc', '2017-08-09', '0b035cca.0b035ccc@my.com'),
('US3612c7e8', 'US641', 'BASKETBALL', '3612c806', '3612c', '3612c811', '2018-08-29', '3612c806.3612c811@my.com'),
('US3612cf18', 'US641', 'BASKETBALL', '3612cf2c', '3612c', '3612cf37', '2009-05-20', '3612cf2c.3612cf37@my.com'),
('US3612d170', 'US641', 'BASKETBALL', '3612d184', '3612d', '3612d18e', '2012-03-16', '3612d184.3612d18e@my.com'),
('US3612d2ba', 'US641', 'BASKETBALL', '3612d2c4', '3612d', '3612d2ce', '2007-11-25', '3612d2c4.3612d2ce@my.com'),
('US3612d436', 'US641', 'BASKETBALL', '3612d440', '3612d', '3612d44b', '2015-04-28', '3612d440.3612d44b@my.com'),
('US3612d594', 'US641', 'BASKETBALL', '3612d5a8', '3612d', '3612d5b3', '2018-04-26', '3612d5a8.3612d5b3@my.com'),
('US3612d74c', 'US641', 'BASKETBALL', '3612d756', '3612d', '3612d761', '2016-06-20', '3612d756.3612d761@my.com'),
('US3612d896', 'US641', 'BASKETBALL', '3612d8a0', '3612d', '3612d8ab', '2008-10-27', '3612d8a0.3612d8ab@my.com'),
('US3612d990', 'US641', 'BASKETBALL', '3612d99a', '3612d', '3612d9a5', '2014-05-16', '3612d99a.3612d9a5@my.com'),
('US3612da8a', 'US641', 'BASKETBALL', '3612da94', '3612d', '3612da9e', '2016-08-05', '3612da94.3612da9e@my.com'),
('US55c8dd5c', 'US445', 'HOCKEY', '55c8dd70', '55c8d', '55c8dd7b', '2008-05-03', '55c8dd70.55c8dd7b@my.com'),
('US55c8e28e', 'US445', 'HOCKEY', '55c8e2a2', '55c8e', '55c8e2a4', '2010-07-10', '55c8e2a2.55c8e2a4@my.com'),
('US55c8e41e', 'US445', 'HOCKEY', '55c8e428', '55c8e', '55c8e433', '2009-02-16', '55c8e428.55c8e433@my.com'),
('US55c8e536', 'US445', 'HOCKEY', '55c8e540', '55c8e', '55c8e54b', '2012-11-21', '55c8e540.55c8e54b@my.com'),
('US55c8e694', 'US445', 'HOCKEY', '55c8e6a8', '55c8e', '55c8e6aa', '2007-05-05', '55c8e6a8.55c8e6aa@my.com'),
('US55c8e874', 'US445', 'HOCKEY', '55c8e87e', '55c8e', '55c8e889', '2016-10-02', '55c8e87e.55c8e889@my.com'),
('US55c8e982', 'US445', 'HOCKEY', '55c8e98c', '55c8e', '55c8e997', '2007-04-28', '55c8e98c.55c8e997@my.com'),
('US55c8eac2', 'US445', 'HOCKEY', '55c8eacc', '55c8e', '55c8ead7', '2007-04-04', '55c8eacc.55c8ead7@my.com'),
('US55c8eba8', 'US445', 'HOCKEY', '55c8ebb2', '55c8e', '55c8ebbd', '2017-12-28', '55c8ebb2.55c8ebbd@my.com'),
('US55c8ec98', 'US445', 'HOCKEY', '55c8eca2', '55c8e', '55c8eca4', '2018-04-29', '55c8eca2.55c8eca4@my.com'),
('US741461be', 'US19', 'SOCCER', '741461dc', '74146', '741461de', '2007-04-24', '741461dc.741461de@my.com'),
('US74146678', 'US19', 'SOCCER', '7414668c', '74146', '74146696', '2013-05-29', '7414668c.74146696@my.com'),
('US741467d6', 'US19', 'SOCCER', '741467e0', '74146', '741467e2', '2017-06-12', '741467e0.741467e2@my.com'),
('US741469ac', 'US19', 'SOCCER', '741469b6', '74146', '741469c1', '2014-04-05', '741469b6.741469c1@my.com'),
('US74146aba', 'US19', 'SOCCER', '74146ac4', '74146', '74146ace', '2007-09-05', '74146ac4.74146ace@my.com'),
('US74146baa', 'US19', 'SOCCER', '74146bb4', '74146', '74146bb6', '2015-05-09', '74146bb4.74146bb6@my.com'),
('US74146d9e', 'US19', 'SOCCER', '74146da8', '74146', '74146db3', '2012-07-04', '74146da8.74146db3@my.com'),
('US74146e98', 'US19', 'SOCCER', '74146ea2', '74146', '74146ea4', '2007-10-19', '74146ea2.74146ea4@my.com'),
('US74146f7e', 'US19', 'SOCCER', '74146f88', '74146', '74146f92', '2018-11-11', '74146f88.74146f92@my.com'),
('US74147064', 'US19', 'SOCCER', '74147065', '74147', '7414706f', '2010-01-12', '74147065.7414706f@my.com'),
('US915f53a6', 'US192', 'FOOTBALL', '915f53ba', '915f5', '915f53c4', '2017-12-03', '915f53ba.915f53c4@my.com'),
('US915f582e', 'US192', 'FOOTBALL', '915f5842', '915f5', '915f5844', '2013-06-14', '915f5842.915f5844@my.com'),
('US915f5a4a', 'US192', 'FOOTBALL', '915f5a5e', '915f5', '915f5a60', '2007-02-27', '915f5a5e.915f5a60@my.com'),
('US915f5b6c', 'US192', 'FOOTBALL', '915f5b76', '915f5', '915f5b78', '2012-07-25', '915f5b76.915f5b78@my.com'),
('US915f5c7a', 'US192', 'FOOTBALL', '915f5c84', '915f5', '915f5c8e', '2018-04-04', '915f5c84.915f5c8e@my.com'),
('US915f5de2', 'US192', 'FOOTBALL', '915f5dec', '915f5', '915f5df7', '2017-03-04', '915f5dec.915f5df7@my.com'),
('US915f5ed2', 'US192', 'FOOTBALL', '915f5edc', '915f5', '915f5ee6', '2007-12-06', '915f5edc.915f5ee6@my.com'),
('US915f5fae', 'US192', 'FOOTBALL', '915f5fb8', '915f5', '915f5fc3', '2009-09-11', '915f5fb8.915f5fc3@my.com'),
('US915f6094', 'US192', 'FOOTBALL', '915f609e', '915f6', '915f60a0', '2017-06-05', '915f609e.915f60a0@my.com'),
('US915f6184', 'US192', 'FOOTBALL', '915f6198', '915f6', '915f61a2', '2014-09-07', '915f6198.915f61a2@my.com'),
('US9c20e63c', 'US233', 'TENNIS', '9c20e650', '9c20e', '9c20e65b', '2010-05-21', '9c20e650.9c20e65b@my.com'),
('US9c20eb3c', 'US233', 'TENNIS', '9c20eb50', '9c20e', '9c20eb52', '2015-01-26', '9c20eb50.9c20eb52@my.com'),
('US9c20ed9e', 'US233', 'TENNIS', '9c20edb2', '9c20e', '9c20edbc', '2012-12-02', '9c20edb2.9c20edbc@my.com'),
('US9c20eede', 'US233', 'TENNIS', '9c20eee8', '9c20e', '9c20eeea', '2011-11-28', '9c20eee8.9c20eeea@my.com'),
('US9c20f3fc', 'US233', 'TENNIS', '9c20f41a', '9c20f', '9c20f425', '2009-07-11', '9c20f41a.9c20f425@my.com'),
('US9c20f668', 'US233', 'TENNIS', '9c20f672', '9c20f', '9c20f67d', '2013-08-02', '9c20f672.9c20f67d@my.com'),
('US9c20f78a', 'US233', 'TENNIS', '9c20f794', '9c20f', '9c20f796', '2013-09-20', '9c20f794.9c20f796@my.com'),
('US9c20f870', 'US233', 'TENNIS', '9c20f884', '9c20f', '9c20f886', '2010-08-20', '9c20f884.9c20f886@my.com'),
('US9c20f956', 'US233', 'TENNIS', '9c20f960', '9c20f', '9c20f96a', '2017-04-14', '9c20f960.9c20f96a@my.com'),
('US9c20fa3c', 'US233', 'TENNIS', '9c20fa46', '9c20f', '9c20fa51', '2013-09-10', '9c20fa46.9c20fa51@my.com'),
('USb380b74e', 'US84', 'VOLLEYBALL', 'b380b762', 'b380b', 'b380b76c', '2018-11-28', 'b380b762.b380b76c@my.com'),
('USb380bc8a', 'US84', 'VOLLEYBALL', 'b380bc9e', 'b380b', 'b380bca9', '2011-03-14', 'b380bc9e.b380bca9@my.com'),
('USb380bf14', 'US84', 'VOLLEYBALL', 'b380bf28', 'b380b', 'b380bf2a', '2018-06-27', 'b380bf28.b380bf2a@my.com'),
('USb380c022', 'US84', 'VOLLEYBALL', 'b380c02c', 'b380c', 'b380c037', '2012-08-08', 'b380c02c.b380c037@my.com'),
('USb380c126', 'US84', 'VOLLEYBALL', 'b380c130', 'b380c', 'b380c132', '2015-10-15', 'b380c130.b380c132@my.com'),
('USb380c216', 'US84', 'VOLLEYBALL', 'b380c220', 'b380c', 'b380c222', '2010-03-24', 'b380c220.b380c222@my.com'),
('USb380c2f2', 'US84', 'VOLLEYBALL', 'b380c2fc', 'b380c', 'b380c2fe', '2013-06-04', 'b380c2fc.b380c2fe@my.com'),
('USb380c3f6', 'US84', 'VOLLEYBALL', 'b380c400', 'b380c', 'b380c40b', '2010-06-29', 'b380c400.b380c40b@my.com'),
('USb380c540', 'US84', 'VOLLEYBALL', 'b380c54a', 'b380c', 'b380c554', '2016-12-28', 'b380c54a.b380c554@my.com'),
('USb380c680', 'US84', 'VOLLEYBALL', 'b380c68a', 'b380c', 'b380c695', '2009-05-20', 'b380c68a.b380c695@my.com');

-- --------------------------------------------------------

--
-- Table structure for table `athlete_injuries`
--

CREATE TABLE `athlete_injuries` (
  `id_athlete` varchar(50) NOT NULL,
  `id_injury_type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date_of_injury` date NOT NULL,
  `description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `athlete_injuries`
--

INSERT INTO `athlete_injuries` (`id_athlete`, `id_injury_type`, `date_of_injury`, `description`) VALUES
('US0b034e2e', 'SPRAIN', '2025-11-05', 'Limping'),
('US0b0354aa', 'FRACTURE', '2025-11-05', 'Fractured radius and ulna'),
('US0b03590a', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('US0b03590a', 'SPRAIN', '2025-11-05', 'Limping'),
('US0b0359fa', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('US0b0359fa', 'FRACTURE', '2025-11-05', 'Fractured tibula and fibula'),
('US0b0359fa', 'SPRAIN', '2025-11-05', 'Limping'),
('US0b035bd0', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('US0b035cc0', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('US3612cf18', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612d170', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612d2ba', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612d436', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612d594', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612d74c', 'SPRAIN', '2025-11-05', 'Limping'),
('US3612da8a', 'DISLOCATION', '2025-11-05', 'Limping'),
('US3612da8a', 'SPRAIN', '2025-11-05', 'Limping'),
('US55c8e694', 'CONTUSION', '2025-11-05', 'Large bruise stomach'),
('US55c8e694', 'FRACTURE', '2025-11-05', 'Fracture of tibula and fibula'),
('US55c8e874', 'CONTUSION', '2025-11-05', 'Large bruise on face'),
('US55c8e982', 'CONTUSION', '2025-11-05', 'Large bruise on face'),
('US55c8e982', 'FRACTURE', '2025-11-05', 'Fracture of tibula and fibula'),
('US55c8eac2', 'CONTUSION', '2025-11-05', 'Large bruise stomach'),
('US55c8eac2', 'FRACTURE', '2025-11-05', 'Fracture of radius and ulna'),
('US55c8eba8', 'CONTUSION', '2025-11-05', 'Large bruise on face'),
('US741461be', 'CONTUSION', '2025-11-05', 'Bruising of stomach'),
('US741461be', 'FRACTURE', '2025-11-05', 'Fracture of tibula and fibula'),
('US741461be', 'SPRAIN', '2025-11-05', 'Limping'),
('US741467d6', 'CONTUSION', '2025-11-05', 'Bruising of stomach'),
('US741467d6', 'SPRAIN', '2025-11-05', 'Limping'),
('US74146aba', 'SPRAIN', '2025-11-05', 'Limping'),
('US74146baa', 'CONTUSION', '2025-11-05', 'Bruising of stomach'),
('US74146baa', 'SPRAIN', '2025-11-05', 'Limping'),
('US74146e98', 'FRACTURE', '2025-11-05', 'Fracture of tibula and fibula'),
('US74147064', 'DISLOCATION', '2025-11-05', 'Leg numbness, cant move leg'),
('US915f53a6', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f53a6', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f582e', 'CONCUSSION', '2025-11-05', 'Dilated pupils, slurred speech'),
('US915f582e', 'DISLOCATION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f582e', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f5a4a', 'CONCUSSION', '2025-11-05', 'Dilated pupils, slurred speech'),
('US915f5a4a', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f5a4a', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f5b6c', 'CONCUSSION', '2025-11-05', 'Dilated pupils, slurred speech'),
('US915f5b6c', 'CONTUSION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f5b6c', 'DISLOCATION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f5b6c', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f5b6c', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f5c7a', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f5de2', 'CONCUSSION', '2025-11-05', 'Dilated pupils, slurred speech'),
('US915f5de2', 'DISLOCATION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f5de2', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f5de2', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f5ed2', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f5ed2', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f5fae', 'CONCUSSION', '2025-11-05', 'Dilated pupils, slurred speech'),
('US915f5fae', 'CONTUSION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f5fae', 'DISLOCATION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f6094', 'SPRAIN', '2025-11-05', 'Limping'),
('US915f6184', 'DISLOCATION', '2025-11-05', 'Shoulder numbness, cant move arm'),
('US915f6184', 'FRACTURE', '2025-11-05', 'Limping'),
('US915f6184', 'SPRAIN', '2025-11-05', 'Limping'),
('US9c20e63c', 'SPRAIN', '2025-11-05', 'Limping'),
('US9c20ed9e', 'FRACTURE', '2025-11-05', 'Fractured radius and ulna'),
('US9c20eede', 'DISLOCATION', '2025-11-05', 'Numbness of arm and cant move arm'),
('US9c20eede', 'SPRAIN', '2025-11-05', 'Limping'),
('US9c20f668', 'SPRAIN', '2025-11-05', 'Limping'),
('US9c20f78a', 'CONCUSSION', '2025-11-05', 'Dilated pupils and slurred speech'),
('US9c20f78a', 'SPRAIN', '2025-11-05', 'Limping'),
('US9c20fa3c', 'SPRAIN', '2025-11-05', 'Limping'),
('USb380c022', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('USb380c022', 'SPRAIN', '2025-11-05', 'Limping'),
('USb380c126', 'SPRAIN', '2025-11-05', 'Limping'),
('USb380c2f2', 'SPRAIN', '2025-11-05', 'Limping'),
('USb380c680', 'CONTUSION', '2025-11-05', 'Large bruise on stomach'),
('USb380c680', 'SPRAIN', '2025-11-05', 'Limping');

-- --------------------------------------------------------

--
-- Table structure for table `coaches`
--

CREATE TABLE `coaches` (
  `id_coach` varchar(50) NOT NULL,
  `id_sport_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`id_coach`, `id_sport_name`, `first_name`, `middle_name`, `last_name`, `date_of_birth`, `email`) VALUES
('US120', 'BASEBALL', 'Bryon', 'R', 'Leach', '1981-03-09', 'bryon.leach81@my.com'),
('US19', 'SOCCER', 'Alexander', '', 'Brooke', '1982-03-05', 'alexander.brooke@my.com'),
('US192', 'FOOTBALL', 'Kim', 'Quin', 'Stevens', '1989-04-15', 'kim.stevens89@my.com'),
('US233', 'TENNIS', 'Connor', 'Bodie', 'Mason', '1987-07-07', 'connor.mason87@my.com'),
('US445', 'HOCKEY', 'Ambrose', 'O', 'Jerome', '1992-04-03', 'ambrose.jerome92@my.com'),
('US641', 'BASKETBALL', 'Devon', 'Lamont', 'Bronson', '1998-12-22', 'devon.bronson98@my.com'),
('US84', 'VOLLEYBALL', 'Roland', 'Randall', 'Marshall', '1987-07-07', 'roland.marshall87@my.com');

-- --------------------------------------------------------

--
-- Table structure for table `injuries`
--

CREATE TABLE `injuries` (
  `id_injury_type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `injuries`
--

INSERT INTO `injuries` (`id_injury_type`) VALUES
('CONCUSSION'),
('CONTUSION'),
('DISLOCATION'),
('FRACTURE'),
('LACERATION'),
('SPRAIN'),
('STRAIN');

-- --------------------------------------------------------

--
-- Table structure for table `sports`
--

CREATE TABLE `sports` (
  `id_sport_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `sports`
--

INSERT INTO `sports` (`id_sport_name`) VALUES
('BASEBALL'),
('BASKETBALL'),
('FOOTBALL'),
('HOCKEY'),
('SOCCER'),
('TENNIS'),
('VOLLEYBALL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `athletes`
--
ALTER TABLE `athletes`
  ADD PRIMARY KEY (`id_athlete`) USING BTREE,
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_coach` (`id_coach`),
  ADD KEY `id_sport_name` (`id_sport_name`);

--
-- Indexes for table `athlete_injuries`
--
ALTER TABLE `athlete_injuries`
  ADD PRIMARY KEY (`id_athlete`,`id_injury_type`,`date_of_injury`),
  ADD KEY `id_injury_type` (`id_injury_type`);

--
-- Indexes for table `coaches`
--
ALTER TABLE `coaches`
  ADD PRIMARY KEY (`id_coach`) USING BTREE,
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_sport_name` (`id_sport_name`);

--
-- Indexes for table `injuries`
--
ALTER TABLE `injuries`
  ADD PRIMARY KEY (`id_injury_type`);

--
-- Indexes for table `sports`
--
ALTER TABLE `sports`
  ADD PRIMARY KEY (`id_sport_name`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `athletes`
--
ALTER TABLE `athletes`
  ADD CONSTRAINT `athletes_ibfk_1` FOREIGN KEY (`id_sport_name`) REFERENCES `sports` (`id_sport_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `athletes_ibfk_2` FOREIGN KEY (`id_coach`) REFERENCES `coaches` (`id_coach`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `athlete_injuries`
--
ALTER TABLE `athlete_injuries`
  ADD CONSTRAINT `athlete_injuries_ibfk_1` FOREIGN KEY (`id_athlete`) REFERENCES `athletes` (`id_athlete`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `athlete_injuries_ibfk_2` FOREIGN KEY (`id_injury_type`) REFERENCES `injuries` (`id_injury_type`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `coaches`
--
ALTER TABLE `coaches`
  ADD CONSTRAINT `coaches_ibfk_1` FOREIGN KEY (`id_sport_name`) REFERENCES `sports` (`id_sport_name`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
