Create Table Batiment(
idBatiment INT NOT NULL Primary Key
);

Create Table Salle(
idSalle INT NOT NULL,
capacite INT DEFAULT NULL,
idBatiment INT NOT NULL,
Primary Key (idSalle,idBatiment)/*,
Foreign key (idBatiment) references Batiment(idBatiment)*/
);

Create Table Section(
idSection INT NOT NULL Primary Key,
annee DATE DEFAULT NULL
);

Create Table Groupe(
idGroupe INT NOT NULL,
idSection INT NOT NULL,
Primary Key (idGroupe,idSection)/*,
Foreign key (idSection) references Section(idSection)*/
);

Create Table Etudiant(
idPersonne INT NOT NULL Primary Key,
nom VARCHAR(30) NOT NULL,
prenom VARCHAR(30) NOT NULL,
login VARCHAR(30) NOT NULL,
mdp VARCHAR(30) NOT NULL,
idGroupe INT NOT NULL/*,
Foreign key (idGroupe) references Groupe(idGroupe)*/
);

Create Table Enseignant(
idPersonne INT NOT NULL Primary Key,
nom VARCHAR(30) NOT NULL,
prenom VARCHAR(30) NOT NULL,
login VARCHAR(30) NOT NULL,
mdp VARCHAR(30) NOT NULL,
grade VARCHAR(30) NOT NULL
);

Create Table Module(
idModule VARCHAR(30) NOT NULL Primary Key,
nom VARCHAR(30) NOT NULL,
coef INT NOT NULL
);

Create Table Inscription(
idEtudiant INT NOT NULL,
idModule VARCHAR(30) NOT NULL,
moyenne DOUBLE DEFAULT NULL,
Primary Key (idEtudiant,idModule)/*,
Foreign key (idEtudiant,idModule) references Etudiant(idEtudiant),
Foreign key (idModule) references Module(idModule)*/
);

Create Table Cours(
idSceance INT NOT NULL Primary Key, 
idModule VARCHAR(30) NOT NULL,
idSalle INT NOT NULL,
idEnseignant INT NOT NULL,
idSection INT NOT NULL,
dateDebut DATE DEFAULT NULL,
durree INT DEFAULT NULL/*,
Foreign key (idModule) references Module(idModule),
Foreign key (idSalle) references Salle(idSalle),
Foreign key (idEnseignant) references Enseignant(idEnseignant),
Foreign key (idSection) references Section(idSection)*/
);

Create Table TP(
idSceance INT NOT NULL Primary Key, 
idModule VARCHAR(30) NOT NULL,
idSalle INT NOT NULL,
idEnseignant INT NOT NULL,
idGroupe INT NOT NULL,
dateDebut DATE DEFAULT NULL,
durree INT DEFAULT NULL/*,
Foreign key (idModule) references Module(idModule),
Foreign key (idSalle) references Salle(idSalle),
Foreign key (idEnseignant) references Enseignant(idEnseignant),
Foreign key (idGroupe) references Groupe(idGroupe)*/
);

DROP TABLE Cours;
DROP TABLE TP;
DROP TABLE Inscription;
DROP TABLE Module;
DROP TABLE Salle;
DROP TABLE Batiment;
DROP TABLE Section;
DROP TABLE Groupe;
DROP TABLE Etudiant;
DROP TABLE Enseignant;
