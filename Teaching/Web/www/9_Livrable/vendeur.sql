-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 05, 2019 at 06:37 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Projetweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Vendeur`
--

CREATE TABLE `Vendeur` (
  `Admin` varchar(255) NOT NULL,
  `Email` varchar(250) NOT NULL,
  `PseudoVendeur` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Nom` varchar(250) NOT NULL,
  `Prenom` varchar(250) NOT NULL,
  `Photo` varchar(250) NOT NULL,
  `Fondecran` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Vendeur`
--

INSERT INTO `Vendeur` (`Admin`, `Email`, `PseudoVendeur`, `Password`, `Nom`, `Prenom`, `Photo`, `Fondecran`) VALUES
('Non', 'levanah.masbernat@edu.ece.fr', 'Lele', 'coucou', 'Masbernat', 'Lévanah', 'img/vendeur3.png', 'img/fondecran3.jpg'),
('Non', 'louis.baret@edu.ece.fr', 'loulou', 'coucou', 'Baret', 'Louis', 'img/vendeur4.jpg', 'img/fondecran4.jpg'),
('Oui', 'raphael.partouche@edu.ece.fr', 'Raphou', 'coucou', 'Partouche', 'Raphael', 'img/vendeur2.jpg', 'img/fondecran2.jpg'),
('Oui', 'salome.masbernat@edu.ece.fr', 'Salom', 'coucou', 'Masbernat', 'Salomé', 'img/vendeur1.jpg', 'img/fondecran1.jpg'),
('Non', 'sixtine.polart@edu.ece.fr', 'Sixt', 'coucou', 'Polart', 'Sixtine', 'img/vendeur5.jpg', 'img/fondecran5.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Vendeur`
--
ALTER TABLE `Vendeur`
  ADD PRIMARY KEY (`Email`);
