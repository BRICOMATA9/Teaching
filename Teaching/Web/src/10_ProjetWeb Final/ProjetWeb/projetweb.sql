-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 05 mai 2019 à 21:53
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
-- Base de données :  `projetweb`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `email_admin` varchar(255) NOT NULL,
  `password_admin` varchar(255) NOT NULL,
  `nom_admin` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `id_item` int(4) NOT NULL,
  `email_vendeur` varchar(255) NOT NULL,
  PRIMARY KEY (`email_admin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`email_admin`, `password_admin`, `nom_admin`, `email`, `id_item`, `email_vendeur`) VALUES
('fredjdg@edu.ece.fr', 'jeudemerde', 'Fred', '', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `carte_bancaire`
--

DROP TABLE IF EXISTS `carte_bancaire`;
CREATE TABLE IF NOT EXISTS `carte_bancaire` (
  `numero_carte` varchar(255) NOT NULL,
  `expiration` varchar(255) NOT NULL,
  `nom_affiche` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `code` int(4) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `email_vendeur` varchar(255) NOT NULL,
  PRIMARY KEY (`numero_carte`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `carte_bancaire`
--

INSERT INTO `carte_bancaire` (`numero_carte`, `expiration`, `nom_affiche`, `type`, `code`, `email_client`, `email_vendeur`) VALUES
('0123456789', '05/15', 'Tombe', 'Visa', 1540, 'stagiaire@edu.ece.fr', ''),
('123456789', '21/29', '	\r\nVUONG', 'Visa', 1111, 'Vuong.jimmy@ymail.com', ''),
('01010101010101', '01/23', 'Ali', 'Visa', 1234, 'Alibaba@gmail.com', ''),
('456789123', '21/21', 'Martin', 'Visa', 4568, '	\r\nsamir@edu.ece.fr', ''),
('789456123', '01/20', 'Lefevre', 'Visa', 12456, 'client1@gmail.com', '');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `email_client` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom_client` varchar(255) NOT NULL,
  `prenom_client` varchar(255) NOT NULL,
  `adresse_postale` varchar(255) NOT NULL,
  `code_postale` int(5) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `numero_tel` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`email_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`email_client`, `password`, `nom_client`, `prenom_client`, `adresse_postale`, `code_postale`, `ville`, `pays`, `numero_tel`, `email`) VALUES
('stagiaire@edu.ece.fr', 'unticketrestosvp', 'Tombe', 'Alexa', '24 rue high street', 56360, 'Bangor', 'De_Galle', 650147895, ''),
('Vuong.jimmy@ymail.com', '1234', 'VUONG', 'Jimmy', '9 rue Victor Hugo', 92300, 'Levallois Perret', 'France', 682511678, ''),
('Alibaba@gmail.com', '1234', 'Ali', 'BABA ', '3 rue Delaforge', 93, 'Bordeaux', 'France', 632423528, ''),
('samir@edu.ece.fr', 'boumsafaitdeschocapic', 'Martin', 'Samir', '36 rue cache', 78456, '', '', 9999999, ''),
('client1@gmail.com', 'client1', 'Lefevre', 'Alain', '26 rue jean pigeon ', 94220, 'Charenton', 'France', 647852134, '');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(255) NOT NULL AUTO_INCREMENT,
  `id_item` int(10) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  `quantite` int(5) NOT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `id_item`, `email_client`, `quantite`) VALUES
(1, 3, 'stagiaire@edu.ece.fr', 1),
(2, 3, 'stagiaire@edu.ece.fr', 1),
(3, 2, 'stagiaire@edu.ece.fr', 1),
(4, 1, 'stagiaire@edu.ece.fr', 1),
(5, 1, 'stagiaire@edu.ece.fr', 1);

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `email_admin` varchar(255) NOT NULL,
  `email_vendeur` varchar(255) NOT NULL,
  `email_acheteur` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `connexion`
--

INSERT INTO `connexion` (`email`, `password`, `type`, `email_admin`, `email_vendeur`, `email_acheteur`) VALUES
('fredjdg@edu.ece.fr', 'jeudemerde', 'Admin', '', '', ''),
('jeanmichelbruitage@gmail.com', 'yametekudasai', 'Vendeur', '', '', ''),
('davidgoodenough@gmail.com', 'cpassimal', 'Vendeur', '', '', ''),
('stagiaire@edu.ece.fr', 'unticketrestosvp', 'Client', '', '', ''),
('Vuong.jimmy@ymail.com', '1234', 'Client', '', '', ''),
('Alibaba@gmail.com', '1234', 'Client', '', '', ''),
('samir@edu.ece.fr', 'boumsafaitdeschocapic 	', 'Client', '', '', ''),
('client1@gmail.com', 'client1', 'Client', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id_item` int(4) NOT NULL AUTO_INCREMENT,
  `nom_item` varchar(255) NOT NULL,
  `photos_item` varchar(255) NOT NULL,
  `description_item` varchar(500) NOT NULL,
  `video_item` varchar(255) NOT NULL,
  `categorie_item` varchar(255) NOT NULL,
  `sous_categorie` varchar(255) NOT NULL,
  `prix_item` float NOT NULL,
  `stock_item` int(5) NOT NULL,
  `id_commande` int(4) NOT NULL,
  `email_admin` varchar(255) NOT NULL,
  `id_mesventes` int(4) NOT NULL,
  `email_client` varchar(255) NOT NULL,
  PRIMARY KEY (`id_item`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`id_item`, `nom_item`, `photos_item`, `description_item`, `video_item`, `categorie_item`, `sous_categorie`, `prix_item`, `stock_item`, `id_commande`, `email_admin`, `id_mesventes`, `email_client`) VALUES
(1, 'The Magikarp Song', 'https://i.ytimg.com/vi/H3x3-22Gi3g/maxresdefault.jpg', 'Voici une ode au meilleur (et au pire !) Pokemon de tous les temps : Magicarpe ! Montrez-lui votre amour en chantant sa chanson avec nous !', 'https://www.youtube.com/watch?v=dNkVjo_L30o', 'Chanson', 'ost_animu', 150, 130, 0, '', 2, ''),
(12, 'Metro 2033', 'https://static.fnac-static.com/multimedia/Images/FR/NR/f3/b0/2a/2797811/1507-1/tsp20160713155052/Metro-2033.jpg', 'A cause d\'une apocalypse nucleaire, la population se refugie dans les souterrains du metro de Moscou, ils se sont organises en micro societes et survivent tant bien que mal aux penuries, maladies et aux guerres pour la possession des dernieres ressources. ', '', 'Livre', 'science_fiction', 40, 50, 0, '', 1, ''),
(10, 'Ballon de basket', 'https://www.ballonbasket.fr/images/produits/zoom/ballon-de-basket-nba-grip-control-indoor-outdoor.jpg', 'Ballon de basket NBA Grip Control ', '', 'Sport_Loisir', 'basket', 30, 15, 0, '', 1, ''),
(9, 'Starway to Heaven', 'https://i.ytimg.com/vi/8pPvNqOb6RA/hqdefault.jpg', 'Single de musique rock de Led Zepzllin', 'https://www.youtube.com/watch?v=iXQUu5Dti4g', 'Chanson', 'rock', 100, 1, 0, '', 2, ''),
(8, 'Ballon de volley', 'https://images-na.ssl-images-amazon.com/images/I/51jWL5h-VTL._SX355_.jpg', 'Mini ballon de volley ball Multicolore  Diametre 15 cm', '', 'Sport_Loisir', 'volley', 10, 100, 0, '', 1, ''),
(7, 'Kit de pêche', 'https://www.guide-bask-peche.com/wp-content/uploads/2015/03/materiel-garbolino-baskpeche.jpg', 'Kit de pêche pour se détendre de temps en temps au bord de l\'eau', '', 'Sport_Loisir', 'peche', 25, 25, 0, '', 1, ''),
(6, 'jogging homme', 'https://cdn.laredoute.com/products/362by362/0/4/6/0460fe629278504c26ec20a96e270833.jpg', 'Jogging homme noir NIKE', '', 'Vetement', 'jogging', 30, 100, 0, '', 2, ''),
(5, 'Blouson Vero', 'https://www.ccvmode.com/48190-product_zoom_default/blouson-femme-blanc.jpg', 'Blouson femme blanc Vero', '', 'Vetement', 'blouson', 60, 150, 0, '', 1, ''),
(4, 'Homme Jeans Slim', 'https://images-na.ssl-images-amazon.com/images/I/8142uMwaQFL._UY550_.jpg', 'Jean Homme Vetement Denim Slim fit', '', 'Vetement', 'jean', 40, 300, 0, '', 1, ''),
(11, 'BD Les profs ', 'https://images-na.ssl-images-amazon.com/images/I/919vWKIVcBL.jpg', 'Une BD humoristique qui se focalise sur la parodie du quotidien des profs et des élèves dans un lycée', '', 'Livre', 'bd', 15, 60, 0, '', 2, ''),
(3, 'Single Hit the road jack ', 'https://img.discogs.com/BNFPYX6cOPmeaxe8evCzMmSdaaY=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/R-1756035-1519463231-8844.jpeg.jpg', 'Un disque classique de Jazz de Ray Charles', 'https://www.youtube.com/watch?v=SrnWp5O0DEs', 'Chanson', 'jazz', 100, 50, 0, '', 1, ''),
(2, 'OST ANIME THEATER D', 'https://i.ytimg.com/vi/xLktaNafcvg/maxresdefault.jpg', 'OST de l\'anime re zero kara hajimeru isekai seikatsu', 'https://www.youtube.com/watch?v=OI5buDX4v2c', 'Chanson', 'ost_animu', 60, 40, 0, '', 2, ''),
(13, 'L\'Assomoir', 'https://static.fnac-static.com/multimedia/Images/FR/NR/0c/cd/04/314636/1540-1/tsp20180411114703/L-aommoir.jpg', 'L\'Assommoir raconte la grandeur puis la decadence de Gervaise Macquart, blanchisseuse dans le quartier de la Goutte-d\'Or à Paris', '', 'Livre', 'roman', 5, 70, 0, '', 1, ''),
(40, 'bhsdvbvs', '', ' ', '', 'Livre', '', 0, 0, 0, '', 1, '');

-- --------------------------------------------------------

--
-- Structure de la table `mes_ventes`
--

DROP TABLE IF EXISTS `mes_ventes`;
CREATE TABLE IF NOT EXISTS `mes_ventes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_mes_ventes` int(4) NOT NULL,
  `email_vendeur` varchar(255) NOT NULL,
  `id_item` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `mes_ventes`
--

INSERT INTO `mes_ventes` (`id`, `id_mes_ventes`, `email_vendeur`, `id_item`) VALUES
(1, 2, 'jeanmichelbruitage@gmail.com', 1),
(2, 2, 'jeanmichlebruitage@gmail.com', 2),
(3, 1, 'davidgoodenough@gmail.com', 3),
(4, 1, 'davidgoodenough@gmail.com', 4),
(5, 1, 'davidgoodenough@gmail.com', 5),
(6, 2, 'jeanmichelbruitage@gmail.com', 6),
(7, 1, 'davidgoodenough@gmail.com', 7),
(8, 1, 'davidgoodenough@gmail.com', 8),
(9, 2, 'jeanmichelbruitage@gmail.com', 9),
(10, 1, 'davidgoodenough@gmail.com', 10),
(11, 2, 'jeanmichelbruitage@gmail.com', 11),
(12, 1, 'davidgoodenough@gmail.com', 12),
(13, 1, 'davidgoodenough@gmail.com', 13);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id_panier` int(4) NOT NULL AUTO_INCREMENT,
  `email_client` varchar(255) NOT NULL,
  `id_commande` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_panier`)
) ENGINE=MyISAM AUTO_INCREMENT=675 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id_panier`, `email_client`, `id_commande`) VALUES
(1, 'stagiaire@gmail.com', '1'),
(668, 'stagiaire@edu.ece.fr', '1'),
(669, 'stagiaire@edu.ece.fr', '2'),
(670, 'stagiaire@edu.ece.fr', '3'),
(671, 'stagiaire@edu.ece.fr', '671'),
(672, 'stagiaire@edu.ece.fr', '672'),
(673, 'stagiaire@edu.ece.fr', '673'),
(674, 'stagiaire@edu.ece.fr', '674');

-- --------------------------------------------------------

--
-- Structure de la table `vendeur`
--

DROP TABLE IF EXISTS `vendeur`;
CREATE TABLE IF NOT EXISTS `vendeur` (
  `email_vendeur` varchar(255) NOT NULL,
  `prenom_vendeur` varchar(255) NOT NULL,
  `nom_vendeur` varchar(255) NOT NULL,
  `photo_vendeur` varchar(255) NOT NULL,
  `photo_fond` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `email_admin` varchar(255) NOT NULL,
  `id_ventes` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`email_vendeur`),
  KEY `id_ventes` (`id_ventes`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vendeur`
--

INSERT INTO `vendeur` (`email_vendeur`, `prenom_vendeur`, `nom_vendeur`, `photo_vendeur`, `photo_fond`, `email`, `email_admin`, `id_ventes`) VALUES
('davidgoodenough@gmail.com', '', 'Goodenough', 'https://risibank.fr/cache/stickers/d910/91038-full.png', 'https://france3-regions.francetvinfo.fr/provence-alpes-cote-d-azur/sites/regions_france3/files/styles/top_big/public/assets/images/2019/03/19/sdis83-4143574.jpg?itok=pqqwo8qC', '', '', 1),
('jeanmichelbruitage@gmail.com', '', 'Bruitage', 'https://risibank.fr/cache/stickers/d471/47177-full.png', 'https://www.thomann.de/blog/wp-content/uploads/2016/03/12-accessoires-pour-le-home-studio-10.jpg', '', '', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
