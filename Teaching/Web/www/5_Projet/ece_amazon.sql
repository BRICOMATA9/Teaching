-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 05 mai 2019 à 16:30
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ece_amazon`
--

-- --------------------------------------------------------

--
-- Structure de la table `cartes`
--

DROP TABLE IF EXISTS `cartes`;
CREATE TABLE IF NOT EXISTS `cartes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeCarte` int(1) NOT NULL,
  `Carte` bigint(16) NOT NULL,
  `CVV` int(4) NOT NULL,
  `Titulaire` varchar(255) NOT NULL,
  `ExpMois` int(2) NOT NULL,
  `ExpAn` int(4) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cartes`
--

INSERT INTO `cartes` (`ID`, `TypeCarte`, `Carte`, `CVV`, `Titulaire`, `ExpMois`, `ExpAn`) VALUES
(1, 1, 1000000000000000, 100, 'Dix Dix', 10, 2030),
(2, 1, 1111111111111111, 111, 'Un Un', 1, 2021),
(3, 1, 2222222222222222, 222, 'Deux Deux', 2, 2022),
(4, 1, 3333333333333333, 333, 'Trois Trois', 3, 2023),
(5, 1, 4444444444444444, 444, 'Quatre Quatre', 4, 2024),
(6, 1, 5555555555555555, 555, 'Cinq Cinq', 5, 2025),
(7, 1, 6666666666666666, 666, 'Six Six', 6, 2026),
(8, 1, 7777777777777777, 77, 'Sept Sept', 7, 2027),
(9, 1, 8888888888888888, 888, 'Huit Huit', 8, 2028),
(10, 1, 9999999999999999, 999, 'Neuf Neuf', 9, 2029);

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

DROP TABLE IF EXISTS `comptes`;
CREATE TABLE IF NOT EXISTS `comptes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TypeCompte` set('ADMINISTRATEUR','ACHETEUR','VENDEUR','') NOT NULL,
  `Pseudonyme` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `Prenom` varchar(255) DEFAULT NULL,
  `Telephone` int(11) DEFAULT NULL,
  `CarteCredit` bigint(16) DEFAULT NULL,
  `TypeCarte` int(1) DEFAULT NULL,
  `CVV` int(4) DEFAULT NULL,
  `Adresse` varchar(255) DEFAULT NULL,
  `CodePostal` int(11) DEFAULT NULL,
  `Pays` varchar(255) DEFAULT NULL,
  `Ville` varchar(255) DEFAULT NULL,
  `PhotoProfil` varchar(255) DEFAULT NULL,
  `PhotoBack` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptes`
--

INSERT INTO `comptes` (`ID`, `TypeCompte`, `Pseudonyme`, `MotDePasse`, `Email`, `Nom`, `Prenom`, `Telephone`, `CarteCredit`, `TypeCarte`, `CVV`, `Adresse`, `CodePostal`, `Pays`, `Ville`, `PhotoProfil`, `PhotoBack`) VALUES
(31, 'ACHETEUR', 'dzdddd', 'dzdz', 'dz.d@d.d', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(30, 'ACHETEUR', 'gzef', 'dzdz', 'dd@d.ddzd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(29, 'ACHETEUR', 'dzddd', 'dzdz', 'dd@d.d', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(28, 'ACHETEUR', 'test', 'test', 'nathan.lcn@gmail.fe', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(27, 'ACHETEUR', 'nathandd', 'dz', 'nathan.5@ef.f', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(26, 'ACHETEUR', 'nathand', 'd', 'nathan.lcmn@gmail.comf', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(19, 'ADMINISTRATEUR', 'nathanddzdz', 'dddd', 'nathan.lcmn@gmfail.comdddd', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '19.png', NULL),
(32, 'ADMINISTRATEUR', 'z', 'zz', 'aa.a@a.a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '32.jpg', NULL),
(33, 'ACHETEUR', 'nathanadmin', 'dz', 'd@a.fr', NULL, NULL, 98459856, NULL, NULL, NULL, 'quelquepart', NULL, 'jean', 'test', NULL, NULL),
(34, 'ACHETEUR', 'nathadzdzn', 'i', 'dz@d.dzbb', NULL, NULL, 601427, NULL, NULL, NULL, 'i', NULL, 'i', 'i', NULL, NULL),
(35, 'VENDEUR', 'nathanvendeur', 'dz', 'd@a.frl', NULL, NULL, 601472300, NULL, NULL, NULL, 'dz', NULL, 'dz', 'dz', NULL, NULL),
(36, 'ACHETEUR', 'nathanacheteur', 'dz', 'natddzmn@gmd.om', NULL, NULL, 85, NULL, NULL, NULL, 'dz', NULL, 'dz', 'dz', NULL, NULL),
(37, 'ACHETEUR', 'adda', 'dz', 'nathan.lcmn@gdmdail.com', NULL, NULL, 1, NULL, NULL, NULL, 'd', NULL, 'd', 'd', NULL, NULL),
(38, 'ACHETEUR', 'nathan134', 'dz', 'nathan.5@ooef.f', NULL, NULL, 98459856, NULL, NULL, NULL, 'dz', NULL, 'i', 'dz', NULL, NULL),
(39, 'ACHETEUR', 'nathankjk', 'dz', 'kj@k.k', NULL, NULL, 4, NULL, NULL, NULL, 'dz', NULL, 'i', 'dz', NULL, NULL),
(40, 'ACHETEUR', 'nathanxeb', 'dz', 'nathan.lckyxmn@gmail.com', NULL, NULL, 4, NULL, NULL, NULL, 'fe', NULL, 'i', 'dz', NULL, NULL),
(41, 'ACHETEUR', 'zertyu', 'dz', 'ertyuilkb@jh.m', NULL, NULL, 4, NULL, NULL, NULL, 'dz', NULL, 'i', 'dz', NULL, NULL),
(42, 'ACHETEUR', 'girv', 'dz', 'nathagirvn.lcmn@gmail.com', NULL, NULL, 4, NULL, NULL, NULL, 'dz', NULL, 'i', 'dz', NULL, NULL),
(43, 'ACHETEUR', 'testtest', 'dz', 'natdhadn.5@ezzf.f', NULL, NULL, 4, NULL, NULL, NULL, 'fe', NULL, 'i', 'test', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NomItem` varchar(255) NOT NULL,
  `Photo` varchar(255) DEFAULT NULL,
  `Description` varchar(255) NOT NULL,
  `Prix` int(11) NOT NULL,
  `TypeItem` set('Livre','Musique','Vetement','Loisir') NOT NULL,
  `Quantite` int(11) NOT NULL,
  `Pointure` int(11) DEFAULT NULL,
  `Taille` set('XS','S','M','L','XL') DEFAULT NULL,
  `Couleur` varchar(255) DEFAULT NULL,
  `Auteur` varchar(255) DEFAULT NULL,
  `Video` varchar(255) DEFAULT NULL,
  `Genre` set('Homme','Femme','') DEFAULT NULL,
  `IDVendeur` int(11) DEFAULT NULL,
  `Artiste` varchar(255) DEFAULT NULL,
  `TypeVetement` set('Habits','Chaussures','') DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `items`
--

INSERT INTO `items` (`ID`, `NomItem`, `Photo`, `Description`, `Prix`, `TypeItem`, `Quantite`, `Pointure`, `Taille`, `Couleur`, `Auteur`, `Video`, `Genre`, `IDVendeur`, `Artiste`, `TypeVetement`) VALUES
(97, 'NARUTO C COOL', '97.jpg', 'livre', 12, 'Livre', 86, NULL, NULL, NULL, 'Nathan', NULL, NULL, 35, NULL, NULL),
(98, 'Musique', '98.jpg', 'c ouf', 5, 'Musique', 100, NULL, NULL, NULL, NULL, NULL, NULL, 35, 'Jeanbon', NULL),
(91, 'Livre', '91.jpg', 'fzuoifhzk', 12, 'Livre', 100, NULL, NULL, NULL, 'hhh', NULL, NULL, 35, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `paniers`
--

DROP TABLE IF EXISTS `paniers`;
CREATE TABLE IF NOT EXISTS `paniers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDAcheteur` int(11) NOT NULL,
  `IDItem` int(11) NOT NULL,
  `Quantite` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paniers`
--

INSERT INTO `paniers` (`ID`, `IDAcheteur`, `IDItem`, `Quantite`) VALUES
(49, 43, 97, 14);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
