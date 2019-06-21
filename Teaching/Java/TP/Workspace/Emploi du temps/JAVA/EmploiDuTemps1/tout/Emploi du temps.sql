Create Table Promotion(
id varchar(30) NOT NULL,
Constraint pkPromotion Primary Key (id)
);

Create Table Salle (
id number(2) NOT NULL,
taille  number(2) NOT NULL,
type varchar(30) NOT NULL,
Constraint pkSalle Primary Key (id)
);

Create Table Inspecteur(
id number(2) NOT NULL,
nom  varchar(30) NOT NULL,
prénom varchar(30) NOT NULL,
mail varchar(30) default NULL,
login varchar(30) NOT NULL,
pass varchar(30) NOT NULL,
promotion varchar(30) NOT NULL,
Constraint pkInspecteur Primary Key (id),
Constraint fk_promotion Foreign key (promotion) references promotion(id)
);

Create Table Enseignant(
id number(2) NOT NULL,
nom  varchar(30) NOT NULL,
prénom varchar(30) NOT NULL,
mail varchar(30) default NULL,
login varchar(30) NOT NULL,
pass varchar(30) NOT NULL,
Constraint pkEnseignant Primary Key (id)
);

Create Table Etudiant(
id number(2) NOT NULL,
nom  varchar(30) NOT NULL,
prénom varchar(30) NOT NULL,
login varchar(30) NOT NULL,
pass varchar(30) NOT NULL,
promotion varchar(30) NOT NULL,
Constraint pkEtudiant Primary Key (id),
Constraint fk_promotion Foreign key (promotion) references promotion(id)
);

Create Table Groupe(
id number(2) NOT NULL,
Constraint pkGroupe Primary Key (id)
);

Create Table GroupeEtudiant(
idG number(2) NOT NULL,
idE number(2) NOT NULL,
Constraint pkGroupeEtudiant Primary Key (idG,idE),
Constraint fk_Groupe Foreign key (promotion) references promotion(id),
Constraint fk_Etudiant Foreign key (promotion) references promotion(id)
);

Create Table Reservation (
date_ date NOT NULL,
heure varchar(30) NOT NULL,
durée varchar(30) NOT NULL,
salle number(2) NOT NULL,
groupe number(2) NOT NULL,
matiere number(2) NOT NULL,
Constraint pkSalle Primary Key (date_,heure),
Constraint fk_Salle Foreign key (salle) references Salle(id),
Constraint fk_Grpupe Foreign key (groupe) references Groupe(id),
Constraint fk_Matiere Foreign key (matiere) references Matiere(id)
);


Insert Into Promotion values('4GI');
Insert Into Promotion values('4RT');
Insert Into Promotion values('4GM');

Insert Into Inspecteur values(1,'Remen','Alexander','alex.remen@gmail.com','aremen','toto1','4GI');
Insert Into Inspecteur values(2,'Vo Thanh','Tonya','sadako22@free.fr','tvo_than','toto2','4RT');
Insert Into Inspecteur values(3,'inspect3','toto3','toto3@bla','toto3','toto3','4GM');

Insert Into Enseignant values(1,'Marre','Daniel','daniel.marre@insa-toulouse.fr','dmarre','titi1');
Insert Into Enseignant values(2,'enseign2','titi2','titi2@bla','titi2','titi2');
Insert Into Enseignant values(3,'enseign3','titi3','titi3@bla','titi3','titi3');
Insert Into Enseignant values(4,'enseign4','titi4','titi4@bla','titi4','titi4');

Insert Into Etudiant values(1,'etud1','lala1','lala1','lala1','4GI');
Insert Into Etudiant values(2,'etud2','lala2','lala2','lala2','4GI');
Insert Into Etudiant values(3,'etud3','lala3','lala3','lala3','4RT');
Insert Into Etudiant values(4,'etud4','lala4','lala4','lala4','4RT');
Insert Into Etudiant values(5,'etud5','lala5','lala5','lala5','4RT');
Insert Into Etudiant values(6,'etud6','lala6','lala6','lala6','4RT');
Insert Into Etudiant values(7,'etud7','lala7','lala7','lala7','4RT');
Insert Into Etudiant values(8,'etud8','lala8','lala8','lala8','4GM');
Insert Into Etudiant values(9,'etud9','lala9','lala9','lala9','4GM');

Insert Into Groupe values(1);
Insert Into Groupe values(12);
Insert Into Groupe values(13);
Insert Into Groupe values(2);
Insert Into Groupe values(21);
Insert Into Groupe values(23);
Insert Into Groupe values(3);
Insert Into Groupe values(31);
Insert Into Groupe values(32);

Insert Into GroupeEtudiant values(1,1);
Insert Into GroupeEtudiant values(1,2);
Insert Into GroupeEtudiant values(11,1);
Insert Into GroupeEtudiant values(12,2);
Insert Into GroupeEtudiant values(2,3);
Insert Into GroupeEtudiant values(2,4);
Insert Into GroupeEtudiant values(2,5);
Insert Into GroupeEtudiant values(2,6);
Insert Into GroupeEtudiant values(2,7);
Insert Into GroupeEtudiant values(21,3);
Insert Into GroupeEtudiant values(21,4);
Insert Into GroupeEtudiant values(21,5);
Insert Into GroupeEtudiant values(22,6);
Insert Into GroupeEtudiant values(22,7);
Insert Into GroupeEtudiant values(3,8);
Insert Into GroupeEtudiant values(3,9);
Insert Into GroupeEtudiant values(31,8);
Insert Into GroupeEtudiant values(31,9);

Insert Into Salle values(1,15,'amphi');
Insert Into Salle values(2,15,'cours');
Insert Into Salle values(3,15,'cours');
Insert Into Salle values(4,15,'tp');

Insert Into Reservation values(1,15,'amphi');






