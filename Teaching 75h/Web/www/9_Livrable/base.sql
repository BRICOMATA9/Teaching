-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 05, 2019 at 06:06 AM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Projetweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Items`
--

CREATE TABLE `Items` (
  `Id` int(250) NOT NULL,
  `Nom` varchar(250) NOT NULL,
  `Description` varchar(250) NOT NULL,
  `Photo` varchar(250) NOT NULL,
  `Video` varchar(250) NOT NULL,
  `Prix` varchar(250) NOT NULL,
  `Categorie` varchar(250) NOT NULL,
  `Taille` varchar(250) NOT NULL,
  `Couleur` varchar(250) NOT NULL,
  `Note` varchar(250) NOT NULL,
  `Stock` varchar(250) NOT NULL,
  `StockVendu` varchar(255) NOT NULL,
  `Vendeur` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Items`
--

INSERT INTO `Items` (`Id`, `Nom`, `Description`, `Photo`, `Video`, `Prix`, `Categorie`, `Taille`, `Couleur`, `Note`, `Stock`, `StockVendu`, `Vendeur`) VALUES
(1, 'Les larmes de l’assassin', 'Auteur : Anne-Laure Bondoux\r\nRésumé : L\'homme et la femme Poloverdo avaient un enfant qui poussait comme le reste sur cette terre, c\'est-à-dire pas très bien.', 'img/2.jpg', '', '4.50', 'Livres', '', '', '4', '10', '0', 'levanah.masbernat@edu.ece.fr'),
(2, 'Une vie', 'Auteur : Simone Veil\r\nRésumé : Simone Veil accepte de se raconter à la première personne.\n', 'img/1.jpg', '', '5.80', 'Livres', '', '', '5', '10', '12', 'raphael.partouche@edu.ece.fr'),
(3, 'Larousse de poche 2019', 'Editeur : Larousse\r\nDescription : Termes avec leurs différents sens. \n', 'img/9.jpg', '', '7.90', 'Livres', '', '', '3', '71', '0', 'levanah.masbernat@edu.ece.fr'),
(4, 'Bose QuietComfort 35 II', 'Ecouteurs avec micro, pleine taille, sans fil, NFC, suppresseur de bruit actif, jack 3,5mm, isolation acoustique', 'img/3.png', 'https://youtu.be/tpR1YLJ7r5Y', '262.89', 'Musique', '', 'Gris', '5', '3', '0', 'raphael.partouche@edu.ece.fr'),
(5, 'Bose QuietComfort 35 II', 'Ecouteurs avec micro, pleine taille, sans fil, NFC, suppresseur de bruit actif, jack 3,5mm, isolation acoustique', 'img/3bis.png', 'https://youtu.be/tpR1YLJ7r5Y', '262.89', 'Musique', '', 'Noir', '5', '3', '10', 'salome.masbernat@edu.ece.fr'),
(6, 'Vinyle-Grund', 'Pour fêter le grand retour du vinyle, Mike Evans propose de revenir sur son histoire passionnante. ', 'img/4.jpg', '', '29.60', 'Musique', '', '', '3', '59', '0', 'salome.masbernat@edu.ece.fr'),
(7, 'Swimmin- CD Album', 'CD Album du Kid de Pittsburg qui à commencé à rapper dès 14ans.', 'img/10.jpg', '', '18', 'Musique', '', '', '2', '36', '0', 'raphael.partouche@edu.ece.fr'),
(8, 'Nu1xPe Noir', 'Marque : Yamaha- Centre Chopin\r\nDescription : Piano numériques, sans fil, usb, 88touches, polyphonique, pédales fortes, pédales tonales, pédales douces, demi-pédales\r\n', 'img/11.jpg', '', '4250', 'Musique ', '', '', '5', '22', '0', 'raphael.partouche@edu.ece.fr'),
(9, 'Ballon Adidas World Cup Top Glider', 'Marque : ADIDAS \r\nDescription : Ballon de football FIFA Coupe du monde 2018 Top Glider Mixte Blanc et noir Motif pixellisé Composition surface 100% en TPU Vessie Butyle pour un excellent maintien de la pression. Vendu dégonflé.\r\n', 'img/5.png', '', '23.60', 'Sport et Loisirs', '', '', '5', '560', '5', 'salome.masbernat@edu.ece.fr'),
(10, 'Le Terrible Quatro', 'Marque : Le Slip Français \r\nDescription : Pack composé d’un slip bleu marine, d’un slip blanc, d’un slip rouge et d’un slip imprimé marinière\r\nFabriqué en France\r\n', 'img/7.jpg', '', '83.30', 'Vêtement', 'M', '', '5', '10', '0', 'salome.masbernat@edu.ece.fr'),
(11, 'Jeans Femme', 'Marque : Dr Denim \r\nDescription : Jean court, slim, taille haute, bleu vide \r\nFabriqué en Italie\r\n', 'img/8.jpg', '', '69.99', 'Vêtement', 'XS', 'Bleu', '5', '90', '10', 'raphael.partouche@edu.ece.fr'),
(12, 'T-shirt ', 'Marque : Petit bateau\r\nDescription : T-shirt à col rond de qualité supérieur, manche courte, 100% coton, lavage machine\r\nFabriqué en Chine\r\n', 'img/6.jpg', '', '12.50', 'Vêtement', 'S', 'Gris', '1', '45\r\n', '0', 'raphael.partouche@edu.ece.fr');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Items`
--
ALTER TABLE `Items`
  ADD PRIMARY KEY (`Id`);
