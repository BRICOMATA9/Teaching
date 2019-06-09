-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 05, 2019 at 05:00 AM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Projetweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Acheteur`
--

CREATE TABLE `Acheteur` (
  `PseudoAcheteur` varchar(250) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Nom` varchar(250) NOT NULL,
  `Prenom` varchar(250) NOT NULL,
  `Adresse` varchar(250) NOT NULL,
  `Paiement` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Acheteur`
--

INSERT INTO `Acheteur` (`PseudoAcheteur`, `Email`, `Password`, `Nom`, `Prenom`, `Adresse`, `Paiement`) VALUES
('Cynth', 'cynthia.quaye@edu.ece.fr', 'coucou', 'Quaye', 'Cynthia', '5 rue du General Leclerc 94170 Le Perreux sur Marne', '0012 7896 5986 5876'),
('Ev', 'eva.dreyfus@edu.ece.fr', 'coucou', 'Dreyfus', 'Eva', '6 rue des Tournesols 94000 Bobigny', '6595 3658 4478 9651'),
('Blondasse', 'kieran.delagardette@edu.ece.fr', 'coucou', 'De la Gardette', 'Kieran', '59 chemin des Arbres 92560 Le Vésinet', '5888 3569 2547 5195'),
('Lev', 'levanah.masbernat@edu.ece.fr', 'coucou', 'Masbernat', 'Levanah', 'aaaa', '0000'),
('Raamjin', 'ramzi.agougile@edu.ece.fr', 'coucou', 'Agougile', 'Ramzi', '5 rue des Fleurs 75017 Paris', '4589 5669 2358 5195'),
('Raph', 'raphael.partouche@edu.ece.fr', 'coucou', 'Partouche', 'Raphael', '67 avenue Victor cresson 92130 Issy Les Moulineaux', '1111'),
('Salom', 'salome.masbernat@edu.ece.fr', 'coucou', 'Masbernat', 'Salomé', '6 allée des Lilas 94170 Le perreux sur Marne', '8953 1215 2154 1214');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Acheteur`
--
ALTER TABLE `Acheteur`
  ADD PRIMARY KEY (`Email`);
