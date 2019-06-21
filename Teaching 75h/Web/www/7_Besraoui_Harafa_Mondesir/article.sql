CREATE TABLE article 
(

	iD int PRIMARY KEY NOT NULL,
	nom varchar (255) NOT NULL,
	image varchar (255) NOT NULL,
	description varchar (255) NOT NULL,
	prix int NOT NULL,
	type varchar (255) NOT NULL
);

CREATE TABLE acheteur
(

mail_acheteur varchar (20)  Primary key NOT NULL,
nom_acheteur varchar (255)  NOT NULL,
prenom_acheteur varchar (255) NOT NULL,
adresse_acheteur varchar (255) NOT NULL,
motdepasse_acheteur varchar (20) NOT NULL

);

CREATE TABLE vendeur

(
 pseudo_vendeur varchar (255) PRIMARY KEY NOT NULL,
 mail_vendeur varchar (255) Not Null

);
CREATE TABLE administrateur

(
	pseudo varchar (255) Primary key not null,
	mdp varchar (20) not null

);


INSERT INTO administrateur (`pseudo`, `mdp`) VALUES
('admin','admin');

CREATE TABLE payement 

(
	numero_carte int (16) primary key not null, 
	type_carte varchar (255) not null,
	nom_personne varchar (255) not null,
	date_expiration date not null,
	cryptogramme varchar (255) not null

);