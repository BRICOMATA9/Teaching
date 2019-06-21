CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enseignant` int(11) NOT NULL,
  `groupe` int(11) NOT NULL,
  `matiere` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `enseignant` (`enseignant`,`groupe`),
  KEY `enseignant_2` (`enseignant`),
  KEY `groupe` (`groupe`)
);

CREATE TABLE IF NOT EXISTS `enseignant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `specialite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `enseignant` (`id`, `nom`, `prenom`, `specialite`) VALUES
(1, 'Attia', 'Mehdi', 'Android'),
(2, 'Karray', 'Gargouri', 'Tizen'),
(3, 'Sayah', 'Salma', 'Unity'),
(4, 'Hjiri', 'Wiem', 'Cross-Platforme'),
(6, 'Chagra', 'Zayen', 'Windows Phone');

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `niveau` varchar(50) DEFAULT NULL,
  `groupe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `groupe` (`groupe`)
);

INSERT INTO `etudiant` (`id`, `nom`, `prenom`, `niveau`, `groupe`) VALUES
(3, 'labassi', 'sofiene', '2ème niveau', 2),
(4, 'labassi', 'sofiene', '2ème niveau', 2),
(5, 'farouk', 'hajji', '2ème niveau', 4);

CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `groupe` (`id`, `libelle`) VALUES
(1, 'SIM1'),
(2, 'SIM2'),
(3, 'SIM3'),
(4, 'SIM4'),
(5, 'SIM5'),
(6, 'SIM6'),
(7, 'SIM7'),
(8, 'SIM8');

CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `successeur` int(11) DEFAULT NULL,
  `predecesseur` int(11) DEFAULT NULL,
  `capacite` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `successeur` (`successeur`,`predecesseur`),
  KEY `predecesseur` (`predecesseur`)
);

ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`enseignant`) REFERENCES `enseignant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `cours_ibfk_3` FOREIGN KEY (`groupe`) REFERENCES `groupe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_5` FOREIGN KEY (`groupe`) REFERENCES `groupe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

