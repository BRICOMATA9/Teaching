/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - Comprendre l'héritage
#	Fichier  : Compte.java
#	Class    : Compte
*/

import java.util.*;
public class Compte	{
 private String typeCpte ;
 protected double val_courante;
 private String numéroCpte ;
 private LigneComptable ligne;
 private int nbLigneRéel ;  
	public  Compte () 	{ 
                Scanner lectureClavier = new Scanner(System.in);
		typeCpte = contrôleType();
		System.out.print("Numéro du compte : ");
		numéroCpte = lectureClavier.next();
		val_courante = contrôleValinit();   
		nbLigneRéel = 0; ;  
	}
	public  Compte( String type)  {
		Scanner lectureClavier = new Scanner(System.in);
                if (type.equalsIgnoreCase("Epargne")) {
			typeCpte = type;
			System.out.print("Numéro du compte : ");
			numéroCpte = lectureClavier.next();
			val_courante = contrôleValinit();   
			nbLigneRéel = 0 ;  
		}
	}
	public String quelTypeDeCompte() 	{
		return typeCpte;
	}
	public String quelNuméroDeCompte()	{
		return numéroCpte;
	}
	public double quelleValeurCourante()	{
		return val_courante;
	}
	private String contrôleType()		{
                Scanner lectureClavier = new Scanner(System.in);
		char tmpc;
		String tmpS = "";
		do {
				System.out.print("Type du compte [Types possibles :" ); 
				System.out.print("C(ourant), J(oint)] : ");
				tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'C' && tmpc != 'J' );
		switch (tmpc) {
			case 'C' : tmpS = "Courant";
			break;
			case 'J' : tmpS = "Joint";
			break;
		}
		return tmpS;
	}
	private double contrôleValinit()	 {
                Scanner lectureClavier = new Scanner(System.in);
		double tmp, tmpval;
		do {
			System.out.print("Valeur initiale du compte : ");
			tmpval= lectureClavier.nextDouble();  
		} while ( tmpval <= 0);
		return tmpval;
	}
	public void créerLigne()	{
		ligne = new LigneComptable();
		nbLigneRéel = 1 ;  
		val_courante = val_courante + ligne.quelleValeur();
	}
	public  void afficherCpte() {
		System.out.print("Le compte n° : " + numéroCpte );
		System.out.println(" est un compte " + typeCpte);
		if (	 nbLigneRéel > 0) ligne.afficherLigne();
		System.out.println("Valeur courante : " + val_courante);
		if (val_courante < 0) 
			System.out.println("Attention compte débiteur ... !!!");
	}   
}