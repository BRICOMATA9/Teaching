/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 :Java et Internet
#	Section  : Projet  
#	Fichier  : Compte.java
#	Class    : Compte
*/

public class Compte {
 private String typeCpte ;
 private double val_courante;
 private String numéroCpte ;
 public Compte (double valeur, String numero, char t ) 	{ 
	switch (t)	{
		case 'C' : case 'c' : typeCpte = "Courant";
		break;
		case 'J' : case 'j' : typeCpte = "Joint";
		break;
		case 'E' : case 'e' : typeCpte = "Epargne";
		break;
	}
	numéroCpte = numero;
	val_courante = valeur;
 }
 public String getNuméroCpte() {
	return numéroCpte;
 }
 public  String afficherCpte() {
	String message = " <BR> Compte n° : " + numéroCpte + " <br>";
	message = message + "Type du compte : "+typeCpte +"<br>";
	message = message +"Valeur courante : " + val_courante + " &euro;";
	return message;
 }
}
