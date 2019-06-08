-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 02 mai 2019 à 10:26
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
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `Nom` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `Photo` varchar(255) NOT NULL,
  `Prix` float NOT NULL,
  `Categorie` varchar(255) NOT NULL,
  `Quantite` int(3) NOT NULL,
  `Vente` int(3) NOT NULL,
  `id` int(11) NOT NULL,
  `Vendeur` varchar(255) NOT NULL,
  PRIMARY KEY (`Nom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`Nom`, `Description`, `Photo`, `Prix`, `Categorie`, `Quantite`, `Vente`, `id`, `Vendeur`) VALUES
('Ballon', 'Ballon de football reglementaire.', 'images/ballon.png', 17, 'Sport et Loisirs', 1, 0, 1, 'filibert@gmail.com'),
('Huis clos', 'Classique de la littérature française', 'image/huisclos.png', 9.99, 'Livre', 4, 0, 2, 'filibert@gmail.com'),
('Initial D', 'Album de musique', 'images/initialD.png', 19.99, 'Musique', 4, 0, 4, 'rick@gmail.com'),
('Jean homme taille 40', 'Jean bleu délavé de la marque Mevis.', 'images/jean.png', 145, 'Vetement', 90, 0, 3, 'rick@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `nom` varchar(255) NOT NULL,
  `prix` float NOT NULL,
  `quantite` int(11) NOT NULL DEFAULT '1',
  `description` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Adresse` text NOT NULL,
  `Numero` varchar(11) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `nomcarte` varchar(255) DEFAULT NULL,
  `numerocarte` int(11) DEFAULT NULL,
  `typecarte` varchar(255) DEFAULT NULL,
  `codecarte` int(4) DEFAULT NULL,
  `datecarte` date DEFAULT NULL,
  PRIMARY KEY (`Nom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Nom`, `Prenom`, `Adresse`, `Numero`, `mail`, `mdp`, `nomcarte`, `numerocarte`, `typecarte`, `codecarte`, `datecarte`) VALUES
('Flimon', 'Zachary', '6 rue des Abesses \r\n75014 Paris', '0956873418', 'zflimon@gmail.com', 'mdpzac', 'Zachary Flimon', 675459985, 'American Express', 675, '2020-08-13'),
('Terre', 'Mikhali', '5 rue de la poupée qui tousse\r\n59067 Lille', '063476942', 'mterre@gmail.com', 'mdpmikha', 'Mikhali Terre', 54867887, 'Visa Electron', 667, '2021-03-19');

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `photocouv` varchar(255) NOT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`nom`, `prenom`, `mail`, `mdp`, `photo`, `photocouv`) VALUES
('Seperdu', 'Filibert', 'Filibert@gmail.com', 'mdpfili', 'images/filibert.png', 'images/fondtera.png'),
('Gremy', 'Rick', 'rick@gmail.com', 'mdprick', 'images/rick.png', 'images/foret.png'),
('Hina', 'Manolo', 'Admin@gmail.com', 'mdpadmin', 'images/beargrills.png', 'images/serveur.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
