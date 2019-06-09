Create Table Promotion(
id_promo VARCHAR(30) NOT NULL Primary Key,
name_promo VARCHAR(30) NOT NULL,
year date NOT NULL
);

Create Table Classe(
id_classe VARCHAR(30) NOT NULL Primary Key,
id_promo VARCHAR(30) NOT NULL,
name_classe VARCHAR(30) NOT NULL/*,
Foreign key (id_promo) references Promotion(id_promo)*/
);

Create Table Emploi(
id_emploi VARCHAR(30) NOT NULL Primary Key,
id_classe VARCHAR(30) NOT NULL/*,
Foreign key (id_classe) references Classe(id_classe)*/
);

Create Table Professor(
id_prof VARCHAR(30) NOT NULL Primary Key,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email VARCHAR(30) NOT NULL
);

Create Table Module(
id_module VARCHAR(30) NOT NULL Primary Key,
id_prof VARCHAR(30) NOT NULL,
name_module VARCHAR(30) NOT NULL,
duree VARCHAR(30) NOT NULL/*,
Foreign key (id_prof) references Professor(id_prof)*/
);

Create Table Sceance(
id_sceance VARCHAR(30) NOT NULL Primary Key, 
id_module VARCHAR(30) NOT NULL,
id_emploi VARCHAR(30) NOT NULL,
date_sceance date NOT NULL,
time_sceance VARCHAR(30) NOT NULL/*,
Foreign key (id_module) references Module(id_module),
Foreign key (id_emploi) references Emploi(id_emploi)*/
);

DROP TABLE Sceance;
DROP TABLE Module;
DROP TABLE Professor;
DROP TABLE Emploi;
DROP TABLE Classe;
DROP TABLE Promotion;
