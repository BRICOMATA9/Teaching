/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - La protection privée
#	Fichier  : Compte.java
#	Class    : Compte
*/
import java.util.*;
public class Compte {
 private String typeCpte ;
 private double val_courante, taux ;
 private String numéroCpte ;
 private LigneComptable ligne;
 private int nbLigneRéel ;  
	// Accéder en lecture aux données de la classe
	public String quelTypeDeCompte() 	{
		return typeCpte;
	}
	public String quelNuméroDeCompte()	{
		return numéroCpte;
	}
	public double quelleValeurCourante()	{
		return val_courante;
	}
	public double quelTaux()	{
		return taux;
	}
	 public void créerCpte() 	{ 
                Scanner lectureClavier = new Scanner(System.in);
		char tmp;
		do {
			System.out.print("Type du compte [Types possibles :" ); 
			System.out.print("C(ourant), J(oint), E(pargne)] : ");
			tmp = lectureClavier.next().charAt(0);
		} while ( tmp != 'C' && tmp!= 'J' && tmp != 'E');
		switch (tmp)	{
			case 'C' : typeCpte = "Courant";
			break;
			case 'J' : typeCpte = "Joint";
			break;
			case 'E' : typeCpte = "Epargne";
			break;
	}
	System.out.print("Numéro du compte : ");
	numéroCpte = lectureClavier.next();
	if ( typeCpte.equalsIgnoreCase("Epargne"))	{
		System.out.print("Taux de placement :     ");
		taux = lectureClavier.nextDouble();
	}
	System.out.print("Valeur initiale du compte : ");
	val_courante = lectureClavier.nextDouble();   
	nbLigneRéel = 0;
}
	public void créerLigne()	{
		ligne = new LigneComptable();
		ligne.créerLigneComptable();
		nbLigneRéel = 1;
		// val_courante = val_courante + ligne.valeur;
                val_courante = val_courante + ligne.quelleValeur();
	}
	public  void afficherCpte() {
		System.out.print("Le compte n° : " + numéroCpte );
		System.out.println(" est un compte " + typeCpte);
		if ( typeCpte.equalsIgnoreCase("Epargne"))
			System.out.println(" dont le taux est  " + taux);
		if (nbLigneRéel > 0) ligne.afficherLigne();
		System.out.println("Valeur courante : " + val_courante);
	}
}