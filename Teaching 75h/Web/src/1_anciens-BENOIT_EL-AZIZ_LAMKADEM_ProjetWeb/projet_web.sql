-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 05 Mai 2019 à 22:36
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet_web`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

CREATE TABLE IF NOT EXISTS `acheteur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(256) NOT NULL,
  `prenom` varchar(256) NOT NULL,
  `numero_carte` int(16) NOT NULL,
  `cryptogramme` int(3) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Mdp` varchar(256) NOT NULL,
  `Adresse` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `acheteur`
--

INSERT INTO `acheteur` (`ID`, `nom`, `prenom`, `numero_carte`, `cryptogramme`, `Email`, `Mdp`, `Adresse`) VALUES
(1, 'soukaina', 'pop', 2147483647, 589, 'soukaina@gmail.com', '987456321', '52 rue moumen, Mohammedia, Maroc'),
(2, 'kkk', 'mmm', 2147483647, 568, 'atar.el-aziz@edu.ece.fr', '54872225', '41 Avenue Carnot');

-- --------------------------------------------------------

--
-- Structure de la table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `descri` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `prix` float NOT NULL,
  `categorie` int(11) NOT NULL,
  `flash` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Contenu de la table `items`
--

INSERT INTO `items` (`id`, `nom`, `photo`, `descri`, `prix`, `categorie`, `flash`, `quantite`) VALUES
(1, 'L''alchimiste', 'http://localhost/anciens/images/book1.jpg', 'Un livre magnifique', 15, 1, 1, 1),
(26, 'Casque Musique', 'http://localhost/anciens/images/music2.jpg', 'Un casque magnifique', 42, 2, 1, 1),
(40, 'Chaussure sport', 'images/2dc487ef7619fdba61b345a7376641b9.jpg', 'Chaussure magnifique', 26, 3, 0, 1),
(31, 'Les miserables', 'images/c94bedc04e53058a64f85e650bc1b3a2.jpg', '...', 20, 1, 0, 1),
(23, 'Pére riche Pére pauvre', 'http://localhost/anciens/images/book4.jpg', 'un livre magnifique', 26, 1, 1, 1),
(19, 'The Answer', 'http://localhost/anciens/images/book3.jpg', 'Un livre magnifique', 20, 1, 0, 1),
(17, 'The Old man and the sea', 'http://localhost/anciens/images/book2.jpg', 'Un livre Magnifique', 580, 1, 0, 1),
(28, 'Chemise imprimee', 'http://localhost/anciens/images/chemise.jpg', 'Chemise magnifique', 18, 8, 0, 1),
(29, 'Chemise verte', 'http://localhost/anciens/images/vert.jpg', 'chemise magnifique', 16, 9, 0, 1),
(30, 'Materiel sport', 'http://localhost/anciens/images/muscu.jpg', 'ALtére', 8, 3, 0, 1),
(34, 'Album louis armstrong', 'images/f3d8bee93274a797d5e4293334865ca7.jpg', 'Album magnifique ', 36, 2, 1, 1),
(35, 'Tapis Roulant', 'images/3ff05557ccaf28e2fd732d764b1b96ad.jpg', 'Tapis roulant Magnifique ', 79, 3, 0, 1),
(38, 'Pantalons Jeans', 'images/0f567bbe49d0d86d508c00335e16515e.jpg', 'Pantalon magnifique', 25, 9, 0, 1),
(39, 'T shirt blanc', 'images/e10aa1931ebce002b11a2652647f4c91.jpg', 't shirt magnifique ', 12, 8, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE IF NOT EXISTS `livre` (
  `id` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `auteur` varchar(255) NOT NULL,
  `editeur` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`id`, `categorie`, `genre`, `auteur`, `editeur`, `type`) VALUES
(4, 1, 'aaaa', 'victor hugo', 'Ostrava', 'aaaa'),
(6, 1, 'aaaa', 'victor hugo', 'Ostrava', 'aaaa'),
(8, 1, 'aaaa', 'victor hugo', 'Ostrava', 'aaaa'),
(10, 1, 'aaaa', 'victor hugo', 'Ostrava', 'aaaa'),
(12, 1, 'histoire', 'Ernest Hemingway', 'idk', 'aaaa'),
(14, 1, 'histoire', 'Ernest Hemingway', 'idk', 'aaaa'),
(16, 1, 'histoire', 'Ernest Hemingway', 'idk', 'aaaa'),
(18, 1, 'histoire', 'Ernest Hemingway', 'idk', 'aaaa'),
(20, 1, 'Developpement personnel', 'Allan & Barbara Pease', 'idk', 'aaaa'),
(0, 1, 'aaaa', 'victor hugo', 'Ostrava', 'aaaa'),
(0, 1, 'aaaa', 'J.K.Rowling', 'atar', 'bbbb'),
(0, 1, 'Developpement personnel', 'Robert T.kiyosaki', 'idk', 'zzzz'),
(0, 1, 'compte', 'victor hugo', 'idk', 'compte'),
(32, 1, 'compte', 'victor hugo', 'Ostrava', 'compte'),
(0, 1, 'aaaa', 'Aya Lamkadam', 'idk', 'bbbb');

-- --------------------------------------------------------

--
-- Structure de la table `musique`
--

CREATE TABLE IF NOT EXISTS `musique` (
  `id` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  `artiste` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `album` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `musique`
--

INSERT INTO `musique` (`id`, `categorie`, `artiste`, `genre`, `album`) VALUES
(0, 2, '-', 'outils', '-'),
(0, 2, 'Louis Armstrong', 'Album', 'Variete');

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE IF NOT EXISTS `sport` (
  `id` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `nomactivite` varchar(255) NOT NULL,
  `poid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sport`
--

INSERT INTO `sport` (`id`, `categorie`, `marque`, `nomactivite`, `poid`) VALUES
(0, 3, 'asos', 'musculation', 2000),
(0, 3, 'volvo', 'Cardio', 10000),
(0, 3, 'Adidas', 'courir', 500);

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

CREATE TABLE IF NOT EXISTS `vendeur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(256) NOT NULL,
  `prenom` varchar(256) NOT NULL,
  `pseudo` varchar(256) NOT NULL,
  `Email` varchar(256) NOT NULL,
  `Mdp` varchar(256) NOT NULL,
  `photo` varchar(256) NOT NULL,
  `image_fond` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `vendeur`
--

INSERT INTO `vendeur` (`ID`, `nom`, `prenom`, `pseudo`, `Email`, `Mdp`, `photo`, `image_fond`) VALUES
(7, 'atar', 'elaziz', 'atarela', 'atar19@hotmail.fr', '123456', 'pour', 'contre');

-- --------------------------------------------------------

--
-- Structure de la table `vetementf`
--

CREATE TABLE IF NOT EXISTS `vetementf` (
  `id` int(11) NOT NULL,
  `categorie` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `taille` int(11) NOT NULL,
  `couleur` varchar(255) NOT NULL,
  `matiere` varchar(255) NOT NULL,
  `genre` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vetementf`
--

INSERT INTO `vetementf` (`id`, `categorie`, `type`, `taille`, `couleur`, `matiere`, `genre`) VALUES
(0, 8, 'Chemise', 38, 'noir avec fleur', 'laine', 1),
(0, 8, 'Pull', 38, 'Orange', 'tissu', 1),
(0, 8, 'tshirt', 38, 'blanc', 'tissu', 1);

-- --------------------------------------------------------

--
-- Structure de la table `vetementh`
--

CREATE TABLE IF NOT EXISTS `vetementh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` int(11) NOT NULL,
  `type` varchar(256) NOT NULL,
  `taille` int(11) NOT NULL,
  `couleur` varchar(255) NOT NULL,
  `matiere` varchar(255) NOT NULL,
  `genre` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `vetementh`
--

INSERT INTO `vetementh` (`id`, `categorie`, `type`, `taille`, `couleur`, `matiere`, `genre`) VALUES
(1, 9, 'Chemise', 40, 'Verte', 'laine', 2),
(2, 9, 'Pantalon', 42, 'bleu', 'jeans', 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
