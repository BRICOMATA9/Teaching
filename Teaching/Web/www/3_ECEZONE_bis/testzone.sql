-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 05 mai 2019 à 18:45
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
-- Base de données :  `testzone`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

DROP TABLE IF EXISTS `acheteur`;
CREATE TABLE IF NOT EXISTS `acheteur` (
  `id_acheteur` int(128) NOT NULL,
  `Email_acheteur` varchar(100) NOT NULL,
  `Login` varchar(15) NOT NULL,
  `Type_carte` varchar(15) NOT NULL,
  `Num_carte` varchar(100) NOT NULL,
  `Nom_sur_carte` char(100) NOT NULL,
  `Date_expiration` date NOT NULL,
  `Code_securite` int(128) NOT NULL,
  PRIMARY KEY (`id_acheteur`),
  KEY `Email_acheteur` (`Email_acheteur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id_acheteur` int(128) NOT NULL,
  `Image` varchar(256) NOT NULL,
  `id_produit_1` int(128) NOT NULL,
  PRIMARY KEY (`id_acheteur`),
  KEY `id_produit` (`id_produit_1`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_vendeur` int(11) NOT NULL,
  `id_produit` int(128) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Description` text NOT NULL,
  `Categorie` varchar(100) NOT NULL,
  `Prix` float NOT NULL,
  `Photo` varchar(256) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_vendeur`, `id_produit`, `Nom`, `Description`, `Categorie`, `Prix`, `Photo`) VALUES
(0, 12, 'Casque', 'Casque audio bluetooth ', 'Musique', 58, 'Casque.jpg'),
(0, 14, 'Velo', 'Velo de ville noire', 'Sport', 50, 'Velo.jpg'),
(0, 15, 'Tee-shirt', 'Tee-shirt unisexe simple', 'Vetement', 12, 'Teeshirt.jpg'),
(0, 17, 'Harry Potter', 'Harry Potter et les reliques de la Morts', 'Livre', 10, 'Harry.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `Email` varchar(100) NOT NULL,
  `Nom` char(100) DEFAULT NULL,
  `Prenom` char(100) DEFAULT NULL,
  `Adresse` varchar(100) DEFAULT NULL,
  `Mot_de_passe` varchar(15) DEFAULT NULL,
  `Ville` varchar(50) DEFAULT NULL,
  `Code_postal` varchar(10) DEFAULT NULL,
  `Pays` varchar(25) DEFAULT NULL,
  `Telephone` varchar(20) DEFAULT NULL,
  `Modeconnexion` tinyint(1) NOT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Email`, `Nom`, `Prenom`, `Adresse`, `Mot_de_passe`, `Ville`, `Code_postal`, `Pays`, `Telephone`, `Modeconnexion`) VALUES
('Alex@gmail.com', 'Corbet', 'Alex', 'looeoee', 'oihg', 'paris', '75015', 'France', '0987654345', 0),
('tahamaaroufpro@gmail.com', 'MAAROUF', 'taha', '142 rue de courcelles', '1234', 'paris', '75017', 'France', '0768389854', 0),
('sofia.afkir@edu.ece.fr', 'Afkir', 'Sofia', 'Rue Losserand', '456', 'Paris', '75015', 'France', '0635465842', 1),
('sarah.lexa@hotmail.fr', 'lexa', 'sarah', 'Rue Gergovie', 'chat', 'Paris', '75014', 'France', '0635465814', 0);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `Id_vendeur` int(128) NOT NULL,
  `Email_vendeur` varchar(100) NOT NULL,
  `Iban_vendeur` varchar(100) NOT NULL,
  `Pseudo` varchar(15) NOT NULL,
  `Photo` varchar(100) NOT NULL,
  `Image_fond` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_vendeur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
