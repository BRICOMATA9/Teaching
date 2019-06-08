-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 05, 2019 at 06:27 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Ece_amazon`
--

-- --------------------------------------------------------

--
-- Table structure for table `acheteurs`
--

CREATE TABLE `acheteurs` (
  `ID` int(11) NOT NULL,
  `ID_carte` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse1` varchar(255) NOT NULL,
  `adresse2` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `pays` varchar(255) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `connexion` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acheteurs`
--

INSERT INTO `acheteurs` (`ID`, `ID_carte`, `email`, `mdp`, `nom`, `prenom`, `adresse1`, `adresse2`, `ville`, `code_postal`, `pays`, `num_tel`, `connexion`) VALUES
(1, 7, 'jean.pierre@gmail.com', 'jeanpierre17', 'Jean', 'Pierre', '5 avenue de l\'Opera', 'bat Abis', 'Paris', 75001, 'France', 612345678, 1),
(2, 0, 'megane88@yahoo.fr', '8megane8', 'Francois', 'Megane', '5 rue de Marseille', '', 'Paris', 75010, 'France', 743217654, 0),
(3, 0, 'moha96@hotmail.com', 'momo1996', 'Abelrahim', 'Mohammed', 'Rue Paul Devaux 1', '', 'Bruxelles', 1000, 'Belgique', 324754554, 0),
(4, 8, 'marc.john@gmail.fr', 'jojomarco1234', 'John', 'Marc', '13 rue Martenot', '', 'Rennes', 35000, 'France', 198765432, 0),
(5, 9, 'flora.girard@gmail.com', 'floragirard97', 'Girard', 'Flora', '5 Avenue Anatole France', 'Champ de Mars', 'Paris', 75007, 'France', 693471486, 0),
(6, 10, 'sacha44@gmail.com', 'toto44titi', 'Jerome', 'Sacha', 'Quai Jean-Pierre Mayno', '', 'Strasbourg', 67100, 'France', 611223344, 0),
(7, 0, 'loulou@lyon69.fr', 'louloulyon9876', 'Poirier', 'Lea', '28 Pl. du Port-Neuville', 'bat 1', 'Lyon', 69001, 'France', 755667788, 0),
(8, 0, 'georges.d@lille.fr', 'damiengeorges1111', 'Damien', 'Georges', '45 rue de France', '', 'Nice', 6000, 'France', 688998899, 0),
(9, 0, 'mickeal.o@gmail.com', 'mickol2019', 'Mickeal', 'Oliver', 'Route de la Calenzana', '', 'Calvi', 20260, 'France', 666226622, 0),
(10, 11, 'fifi01@gmail.com', '01fififofo', 'Bastien', 'Charlotte', '17 rue de la Concorde', '', 'Bordeaux', 33000, 'France', 697979797, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cartes_bancaires`
--

CREATE TABLE `cartes_bancaires` (
  `ID` int(11) NOT NULL,
  `type_carte` varchar(255) NOT NULL,
  `num_carte` bigint(16) NOT NULL,
  `nom_carte` varchar(255) NOT NULL,
  `date_exp` date NOT NULL,
  `code_secu` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartes_bancaires`
--

INSERT INTO `cartes_bancaires` (`ID`, `type_carte`, `num_carte`, `nom_carte`, `date_exp`, `code_secu`) VALUES
(1, 'MasterCard', 1234567891011213, 'PAUL LABUTTE', '2019-09-01', 890),
(2, 'Visa', 1415161718192021, 'MARGUERITE JARDIN', '2020-04-01', 945),
(3, 'MasterCard', 2223242526272829, 'STEPHANIE HERVE', '2020-08-01', 345),
(4, 'Carte Bleue', 3031323334353637, 'JULIETTE MARTIN', '2019-10-01', 876),
(5, 'American Express', 3839404142434445, 'JEAN DUPONT', '2019-09-01', 564),
(6, 'MasterCard', 4041424344454647, 'ADMIN', '2021-04-01', 123),
(7, 'MasterCard', 2211436577980954, 'JEAN PIERRE', '2020-01-15', 442),
(8, 'Carte Bleue', 8665899876543263, 'JOHN MARC', '2019-07-20', 209),
(9, 'Visa', 6574974532145445, 'GIRARD FLORA', '2019-11-07', 705),
(10, 'Visa', 9988809764654443, 'JEROME SACHA', '2020-03-28', 444),
(11, 'MasterCard', 2121114452769584, 'BASTIEN CHARLOTTE', '2019-09-04', 879);

-- --------------------------------------------------------

--
-- Table structure for table `livres`
--

CREATE TABLE `livres` (
  `ID` int(11) NOT NULL,
  `ID_vendeur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `auteur` varchar(255) NOT NULL,
  `edition` varchar(255) NOT NULL,
  `annee_publication` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `photos` varchar(255) NOT NULL,
  `photo2` varchar(255) NOT NULL,
  `video` varchar(255) NOT NULL,
  `stock` int(11) NOT NULL,
  `nb_vendus` int(11) NOT NULL,
  `date_ligne` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livres`
--

INSERT INTO `livres` (`ID`, `ID_vendeur`, `nom`, `auteur`, `edition`, `annee_publication`, `type`, `genre`, `description`, `prix`, `photos`, `photo2`, `video`, `stock`, `nb_vendus`, `date_ligne`) VALUES
(1, 1, 'Harry Potter a l ecole des sorciers', 'J.K Rowling', 'Editions Gallimard', 1997, 'Roman', 'Fantastique', 'Decouvrez un univers de magie et sorcellerie à Poudlard !', 4, 'harry_potter.jpg', '', '', 60, 12, '2017-10-12 10:00:00'),
(2, 2, 'Le Horla', 'Guy de Maupassant', 'Livre de Poche', 1887, 'Nouvelle', 'Fantastique', 'Ouvrage classique, par l auteur de Bel Ami.', 2, 'le_horla.jpg', '', '', 30, 150, '2018-07-18 15:18:38'),
(3, 3, 'L appel de la foret', 'Jack London', 'Livre de Poche', 1903, 'Roman', 'Aventure', 'Buck est un chien de Californie enleve à son maitre et vendu à un trafiquant de chiens de traineau.', 5, 'Lappel_de_la_foret.jpg', '', '', 25, 5, '2019-01-15 11:48:23'),
(4, 4, 'Asterix Tome 38 La Fille de Vercingetorix', 'Jean-Yves Ferri', 'Albert Rene', 2019, 'BD', 'Jeunesse', 'Astérix et Obélix, les héros créés par René Goscinny et Albert Uderzo, reviennent dans une nouvelle aventure!', 10, 'asterix.jpg', '', '', 15, 2, '2019-04-07 15:21:37'),
(5, 5, 'One Piece Tome 90', 'Eiichiro Oda', 'Glénat', 2019, 'Manga', 'Action', 'La célèbre série de shonen One Piece revient avec un tome 90. ', 7, 'one_piece.jpg', '', '', 55, 17, '2019-02-07 20:29:40'),
(6, 6, 'Twilight Tome 1 Fascination', 'Stephenie Meyer', 'Hachette Romans', 2005, 'Roman', 'Fantastique', 'Decouvrez un univers de vampires, loup garous.', 18, 'Twilight.jpg', '', '', 70, 24, '2019-01-02 10:00:00'),
(7, 1, 'Avant toi', 'Jojo Moyes', 'Milady', 2016, 'Roman', 'Romance', 'Quand Lou se retrouve au chomage, elle accepte un contrat de six mois pour tenir compagnie à un handicape.', 20, 'avant_toi.jpg', '', '', 43, 7, '2019-03-19 22:46:12'),
(8, 2, 'La derniere chasse', 'Jean-Christophe Grangé', 'Albin Michel', 2019, 'Roman', 'Policier', 'En Foret noire, la derniere chasse a commencé...', 23, 'la_derniere_chasse.jpg', '', '', 10, 0, '2019-02-18 06:32:08');

-- --------------------------------------------------------

--
-- Table structure for table `musique`
--

CREATE TABLE `musique` (
  `ID` int(11) NOT NULL,
  `ID_vendeur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `artiste` varchar(255) NOT NULL,
  `annee_sortie` date NOT NULL,
  `genre` varchar(255) NOT NULL,
  `photos` varchar(255) NOT NULL,
  `photo2` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `video` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `nb_vendus` int(11) NOT NULL,
  `date_ligne` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `musique`
--

INSERT INTO `musique` (`ID`, `ID_vendeur`, `nom`, `artiste`, `annee_sortie`, `genre`, `photos`, `photo2`, `description`, `video`, `prix`, `stock`, `nb_vendus`, `date_ligne`) VALUES
(1, 6, 'Brol', 'Angele', '2018-12-07', 'pop', 'brol_angele.png', '', 'Nouvel album d\'Angele', 'https://www.youtube.com/watch?v=YujAn8QpOWY', 7, 93, 7, '2018-10-05 10:00:00'),
(2, 6, 'Bohemian Rhapsody', 'Queen', '2019-02-08', 'rock', 'bohemian_queen.png', '', 'Titre Queen remasterise ', 'https://www.youtube.com/embed/tgbNymZ7vqY', 8, 78, 22, '2019-02-08 10:00:00'),
(3, 6, 'Racine carree', 'Stromae', '2019-04-12', 'house music', 'racinecarree_stromae.png', '', 'Racine carree, album de Stromae en vinyle.', 'https://www.youtube.com/watch?v=lH7wGCV7x2c&list=PLTdOgoLhlrFgiTFfLumGYN4a5To1xV-JV&index=2', 18, 68, 32, '2019-04-12 10:00:00'),
(4, 2, 'La derniere danse', 'Michel Sardou', '2019-03-08', 'variete', 'ladernieredanse_michelsardou.png', '', 'Le dernier album de Michel Sardou retraçant ses plus beaux titres.', '', 10, 1, 0, '2019-04-16 21:27:41'),
(5, 6, 'Best Of 80s', 'Johnny Hallyday', '2019-05-10', 'variete', 'johnny.png', '', 'Best of 80\'s de Johnny Hallyday en edition vinyle.', '', 19, 100, 0, '2019-05-05 10:00:00'),
(6, 6, 'Deux freres', 'PNL', '2019-04-05', 'rap', 'deuxfrere_pnl.png', '', 'Nouvel album de PNL intitule Deux frères.', 'https://www.youtube.com/watch?v=BtyHYIpykN0', 13, 35, 65, '2019-04-05 10:00:00'),
(7, 6, 'Chocolat', 'Roméo Elvis', '2019-04-12', 'rap', 'chocolat_romeo.png', '', 'Nouvel album de Roméo Elvis intitule Chocolat.', 'https://www.youtube.com/watch?v=KcYN17NEMto', 12, 67, 33, '2019-04-12 11:00:00'),
(8, 6, 'When We All Fall Asleep Where Do We Go? ', 'Billie Eilish', '2019-03-29', 'pop', 'billie.png', '', '1er album de Billie Ellish.', '', 15, 61, 39, '2019-03-29 10:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `panier`
--

CREATE TABLE `panier` (
  `ID` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `panier`
--

INSERT INTO `panier` (`ID`, `nom`, `description`, `quantite`, `total`) VALUES
(27, 'Short vert', 'Ce short sera parfait pour les après-midi au bord de la mer !', 2, 37),
(33, 'Tshirt simple', 'Ce t-shirt est indispensable pour parfaire votre garde-robe.', 1, 37);

-- --------------------------------------------------------

--
-- Table structure for table `sports_loisir`
--

CREATE TABLE `sports_loisir` (
  `ID` int(11) NOT NULL,
  `ID_vendeur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `activite` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `lieu` varchar(255) NOT NULL,
  `photos` varchar(255) NOT NULL,
  `photo2` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `video` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `nb_vendus` int(11) NOT NULL,
  `date_ligne` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sports_loisir`
--

INSERT INTO `sports_loisir` (`ID`, `ID_vendeur`, `nom`, `age`, `activite`, `date`, `lieu`, `photos`, `photo2`, `description`, `video`, `prix`, `stock`, `nb_vendus`, `date_ligne`) VALUES
(1, 5, 'Visite d une ferme', 3, 'Plein air', '2019-06-12', 'Magny-en-Bessin', 'ferme.jpg', 'cheval.jpg', 'Venez visiter la magnifique ferme de la famille Brujet ! Partager des moments avec votre famille toute une après-midi.', 'https://www.youtube.com/watch?v=q3ygO5elJww', 5, 8, 2, '2019-04-26 14:32:00'),
(2, 6, 'Concert de MUSE', 18, 'Sortie culturelle', '2019-07-05', 'Paris', 'muse.jpg', 'https://www.youtube.com/watch?v=OVlcjb-52IY', 'Muse sera en tournee mondiale en 2019 avec des concerts !', '', 70, 30, 20, '2018-12-04 10:00:00'),
(3, 3, 'Match de Tennis de Table', 16, 'Sport', '2019-07-06', 'Gymnase Lucien Gaudin,, Paris V', 'tennis.jpg', '', 'Venez participer à un tournois de Tennis de Table et venez affrontez des adversaires de taille au Gymnase Lucien Gaudin !', '', 18, 9, 1, '2019-03-22 13:49:00'),
(4, 6, 'Avant Premiere Cine X-Men : Dark Phoenix', 12, 'Sortie culturelle', '2019-06-03', 'Le Grand REX, Paris II', 'xmen.jpg', '', 'Dans cet ultime volet, les X-MEN affrontent leur ennemi le plus puissant, Jean Grey, l’une des leurs.', 'https://www.youtube.com/watch?v=FPieV3D1eSY', 18, 12, 4, '2019-02-13 08:30:00'),
(5, 4, 'Billets 2 jours pour le Futuroscope', 17, 'Parc d\'attractions', '2019-08-24', 'Chasseneuil-du-Poitou', 'futuroscope.jpg', 'futuroscope2.jpg', 'Venez visiter le parc d\'attraction Futuroscope pendant 2 jours ! Découvrez les nouvelles attractions disponibles et amusez-vous en participant à de nombreuses activites !', 'https://www.youtube.com/watch?v=PBBU0AOmrxM', 82, 30, 12, '2019-01-01 14:48:00'),
(6, 1, 'Massage du corps 55 minutes', 18, 'Détente', '2019-05-22', 'Les Cents Ciels, Paris', 'spa.jpg', '', 'Laissez vous tenter par un massage du corps par des professionnels de la détente. En plus de vos 55 minutes de massage, vous avez accès au hamac ainsi qu\'à la piscine du spa...', '', 95, 5, 0, '2019-03-27 09:00:00'),
(7, 1, 'Billet Musee d Orsay', 12, 'Sortie culturelle', '2019-05-31', 'Paris, VII', 'orsay.jpg', 'orsay2.jpg', 'Le musée d’Orsay est un musée national inauguré en 1986, situé dans le 7e arrondissement de Paris le long de la rive gauche de la Seine.\r\n', '', 14, 10, 3, '2019-01-16 08:10:00'),
(8, 6, 'Saut en parachute en tandem', 18, 'Sport', '2019-06-29', 'Somme', 'parachute.jpg', 'parachute2.jpg', 'Si vous aimez les sensations fortes cette activité est faite pour vous ! Venez realiser votre bapteme de saut en parachute en tandem ou alors renouveler l\'experience !', '', 240, 3, 1, '2019-04-04 16:21:00');

-- --------------------------------------------------------

--
-- Table structure for table `vendeurs`
--

CREATE TABLE `vendeurs` (
  `ID` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `solde` int(11) NOT NULL,
  `nb_ventes` int(11) NOT NULL,
  `ID_carte` int(11) NOT NULL,
  `connexion` int(11) DEFAULT NULL,
  `photo` varchar(255) NOT NULL,
  `fond` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vendeurs`
--

INSERT INTO `vendeurs` (`ID`, `email`, `pseudo`, `nom`, `mdp`, `solde`, `nb_ventes`, `ID_carte`, `connexion`, `photo`, `fond`) VALUES
(1, 'jean.dupont08@edu.ece.fr', 'DupontJ', 'Dupont', '180670', 36, 2, 5, 0, 'jean_profil.jpg', 'fissure.jpg'),
(2, 'marguerite78@edu.ece.fr', 'JardinMarguerite', 'Jardin', 'Pissenlit', 0, 0, 2, 0, 'marguerite_profil.jpg', ''),
(3, 'paul-labutte@edu.ece.fr', 'L-paul', 'Labutte', '4568793', 126, 6, 1, 0, 'paul_profil.jpg', ''),
(4, 'mar.juliette@edu.ece.fr', 'juju-martin', 'Martin', 'JulietteMartin', 45, 3, 4, 0, 'juliette_profil.jpg', ''),
(5, 'stephaneherve@edu.ece.fr', 'Stef98', 'Hervé', 'Hervé7689', 12, 1, 3, 0, 'stephane_profil.jpg', ''),
(6, 'admin@ece.amazon.fr', 'admin', 'admin', 'admin', 2506, 201, 6, 0, 'admin_profil.jpg', '');

-- --------------------------------------------------------

--
-- Table structure for table `vetements`
--

CREATE TABLE `vetements` (
  `ID` int(11) NOT NULL,
  `ID_vendeur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `couleur` varchar(255) NOT NULL,
  `taille` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `modele` varchar(255) NOT NULL,
  `matiere` varchar(255) NOT NULL,
  `photos` varchar(255) NOT NULL,
  `photo2` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `video` varchar(255) NOT NULL,
  `prix` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `nb_vendus` int(11) NOT NULL,
  `date_ligne` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vetements`
--

INSERT INTO `vetements` (`ID`, `ID_vendeur`, `nom`, `couleur`, `taille`, `genre`, `type`, `modele`, `matiere`, `photos`, `photo2`, `description`, `video`, `prix`, `stock`, `nb_vendus`, `date_ligne`) VALUES
(1, 6, 'Bottines Simone', 'marron', 38, 'femme', 'chaussures', 'bottines', 'daim', 'bottines.jpg', '', 'Magnifique bottines en daim marron, idéales avec une jean slim et un petit chemisier fleuri.', '', 35, 6, 0, '2019-04-11 12:14:00'),
(2, 1, 'Chemise printaniere', 'rose', 38, 'homme', 'haut', 'chemise', 'lin', 'chemise_rose.jpg', '', 'Une magnifique chemise qui embellira votre teint en cette merveilleuse saison !', '', 24, 3, 0, '2019-04-12 03:28:00'),
(3, 4, 'Jean slim delave', 'bleu', 40, 'femme', 'bas', 'jean', 'jean', 'slim.jpg', '', 'Un jean slim qui vous galbera le fessier. Cette couleur délavée rappelle les tous premiers jean mis en vente !', '', 36, 8, 3, '2019-04-09 21:33:00'),
(4, 3, 'Robe glamour', 'rouge', 36, 'femme', 'haut', 'longue', 'soie', 'robe_rouge.jpg', '', 'Cette robe fera des envieuses, vous serez la plus belle au bal ce soir !', '', 120, 3, 0, '2019-02-20 18:35:00'),
(5, 6, 'Blouson Cuir Vache', 'marron', 44, 'homme', 'haut', 'veste', 'cuir', 'blouson.jpg', '', 'Ce blouson sera votre vêtement fétiche de la saison. En cuir de vache véritable, il vous protègera du froid.', '', 84, 4, 1, '2019-02-06 08:27:00'),
(6, 3, 'Pantalon en toile', 'bleu', 38, 'homme', 'bas', 'pantalon', 'toile', 'pantalon_toile.jpg', '', 'Ce pantalon fera parfaitement l\'affaire pour la saison chaude !', '', 28, 10, 3, '2019-01-10 09:00:00'),
(7, 6, 'Tshirt simple', 'rouge', 42, 'homme', 'haut', 't-shirt', 'coton', 'tshirt_rouge.jpg', '', 'Ce t-shirt est indispensable pour parfaire votre garde-robe.', '', 6, 15, 60, '2019-04-04 17:20:00'),
(8, 6, 'Short vert', 'vert', 42, 'homme', 'bas', 'short', 'polyester', 'short_vert.jpg', '', 'Ce short sera parfait pour les après-midi au bord de la mer !', '', 12, 5, 7, '2019-02-12 19:20:00'),
(9, 5, 'Debardeur blanc', 'blanc', 38, 'femme', 'haut', 'débardeur', 'coton', 'debardeur.jpg', '', 'Ce débardeur blanc est une pièce incontournable !', '', 15, 9, 5, '2019-02-13 02:31:00'),
(10, 6, 'Chemise Soleil', 'jaune', 34, 'femme', 'haut', 'chemise', 'polyester', 'chemise_jaune.jpg', '', 'Cette couleur ira parfaitement avec votre teint et vous donnera la joie de vivre !', '', 22, 8, 1, '2019-02-17 09:41:00'),
(11, 3, 'Manteau en fausse fourrure', 'marron', 38, 'femme', 'haut', 'manteau', 'fausse fourrure', 'manteau_fourrure.jpg', '', 'Ce manteau en magnifique fausse fourrure vous protègera du froid.', '', 85, 4, 1, '2019-02-05 11:15:00'),
(12, 4, 'Tongues', 'orange', 43, 'homme', 'chaussures', 'tongues', 'plastique', 'tongues.jpg', '', 'Afin de protéger vos petits pieds du sable chaud, ces petites longues seront parfaites !', '', 11, 5, 1, '2019-02-14 23:16:00'),
(13, 2, 'Jean noir troue', 'noir', 44, 'homme', 'bas', 'jean', 'jean', 'jean_noir.jpg', '', 'Osez ce jean pour être le plus stylé de la bande !', '', 25, 7, 3, '2019-01-09 06:47:00'),
(14, 6, 'Basket Femme', 'gris', 36, 'femme', 'chaussures', 'basket', 'toile', 'basket_grises.jpg', '', 'Pour vous donner un air cool et être à l\'aise dans vos basket !', '', 36, 4, 1, '2019-04-06 19:30:00'),
(15, 6, 'Jupe patineuse', 'noir', 40, 'femme', 'bas', 'jupe', 'polyester', 'jupe_noire.jpg', '', 'Cette jupe fluide sera parfaite pour mettre en valeur vos jolies jambes !', '', 13, 3, 0, '2019-02-04 18:24:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acheteurs`
--
ALTER TABLE `acheteurs`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `cartes_bancaires`
--
ALTER TABLE `cartes_bancaires`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `musique`
--
ALTER TABLE `musique`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sports_loisir`
--
ALTER TABLE `sports_loisir`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `vendeurs`
--
ALTER TABLE `vendeurs`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `vetements`
--
ALTER TABLE `vetements`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acheteurs`
--
ALTER TABLE `acheteurs`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `cartes_bancaires`
--
ALTER TABLE `cartes_bancaires`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `livres`
--
ALTER TABLE `livres`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `musique`
--
ALTER TABLE `musique`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `panier`
--
ALTER TABLE `panier`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `sports_loisir`
--
ALTER TABLE `sports_loisir`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `vendeurs`
--
ALTER TABLE `vendeurs`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `vetements`
--
ALTER TABLE `vetements`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
