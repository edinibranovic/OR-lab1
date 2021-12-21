-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2021 at 09:29 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `obuca`
--

-- --------------------------------------------------------

--
-- Table structure for table `boja`
--

CREATE TABLE `boja` (
  `id` int(11) NOT NULL,
  `naziv` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `boja`
--

INSERT INTO `boja` (`id`, `naziv`) VALUES
(1, 'Bijela'),
(2, 'Crna'),
(3, 'Plava'),
(4, 'Crvena'),
(5, 'zuta'),
(6, 'Zelena'),
(7, 'Narancasta'),
(8, 'Ljubicasta'),
(9, 'Ruzicasta'),
(10, 'Zlatna'),
(11, 'Siva');

-- --------------------------------------------------------

--
-- Table structure for table `ima`
--

CREATE TABLE `ima` (
  `bojaid` int(11) NOT NULL,
  `obucaid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ima`
--

INSERT INTO `ima` (`bojaid`, `obucaid`) VALUES
(1, 1),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(2, 2),
(2, 9),
(2, 10),
(3, 3),
(3, 10),
(4, 2),
(5, 5),
(6, 4),
(6, 5),
(7, 4),
(7, 5),
(7, 7),
(8, 6),
(8, 7),
(9, 7),
(10, 1),
(11, 8);

-- --------------------------------------------------------

--
-- Table structure for table `obuca`
--

CREATE TABLE `obuca` (
  `id` int(11) NOT NULL,
  `marka` text NOT NULL,
  `model` text NOT NULL,
  `spol` text NOT NULL,
  `velicina` int(11) NOT NULL,
  `godProizvodnje` int(11) NOT NULL,
  `materijal` text NOT NULL,
  `vrsta` text NOT NULL,
  `visinaDona` text NOT NULL,
  `tipZatvaranja` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `obuca`
--

INSERT INTO `obuca` (`id`, `marka`, `model`, `spol`, `velicina`, `godProizvodnje`, `materijal`, `vrsta`, `visinaDona`, `tipZatvaranja`) VALUES
(1, 'Nike', 'Air Force', 'M', 45, 2017, 'Koza', 'Casual Tenisice', 'Visok', 'Vezice'),
(2, 'Nike', 'Air Max', 'z', 40, 2016, 'Tekstil', 'Sportske Tenisice', 'Visok', 'Vezice'),
(3, 'Nike', 'Air Jordan', 'M', 48, 2003, 'Koza', 'Sportske Tenisice', 'Visok', 'Vezice'),
(4, 'Adidas', 'Gazelle', 'UNI', 42, 2012, 'Sintetika', 'Casual Tenisice', 'Srednji', 'Vezice'),
(5, 'Adidas', 'Spezial', 'M', 44, 2010, 'Sintetika', 'Casual Tenisice', 'Nizak', 'Vezice'),
(6, 'Puma', 'Rider', 'z', 41, 2020, 'Najlon', 'Casual Tenisice', 'Srednji', 'Vezice'),
(7, 'Puma', 'Smash', 'UNI', 43, 2020, 'Najlon', 'Casual Tenisice', 'Srednji', 'Vezice'),
(8, 'New Balance', 'NYCM', 'z', 42, 2019, 'Sintetika', 'Tenisice za trcanje', 'Srednji', 'Vezice'),
(9, 'Karl Lagerfeld', 'Volt Aktiv', 'M', 47, 2021, 'Najlon', 'Sandale', 'Nizak', 'Otvoreno'),
(10, 'Umbro', 'Medusae 3', 'M', 46, 2020, 'Koza', 'Kopacke', 'Visok', 'Slip-on');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `boja`
--
ALTER TABLE `boja`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ima`
--
ALTER TABLE `ima`
  ADD PRIMARY KEY (`bojaid`,`obucaid`),
  ADD KEY `ima_obucaid_fk` (`obucaid`);

--
-- Indexes for table `obuca`
--
ALTER TABLE `obuca`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ima`
--
ALTER TABLE `ima`
  ADD CONSTRAINT `ima_bojaid_fk` FOREIGN KEY (`bojaid`) REFERENCES `boja` (`id`),
  ADD CONSTRAINT `ima_obucaid_fk` FOREIGN KEY (`obucaid`) REFERENCES `obuca` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
