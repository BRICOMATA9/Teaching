/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - Le contôle des données
#	Fichier  : Compte.java
#	Class    : Compte
*/
import java.util.*;
public class Compte	{
 private String typeCpte ;
 private double val_courante, taux ;
 private String numéroCpte ;
 private LigneComptable ligne;
 private int nbLigneRéel ;  
	public  Compte () 	{ 
                Scanner lectureClavier = new Scanner(System.in);
		typeCpte = contrôleType();
		System.out.print("Numéro du compte : ");
		numéroCpte = lectureClavier.next();
		if ( typeCpte.equalsIgnoreCase("Epargne"))   {
			System.out.print("Taux de placement :     ");
			taux = lectureClavier.nextDouble();
		} 
		val_courante = contrôleValinit();   
		nbLigneRéel = 0 ;  
	}
	public  Compte( String num)  {
		numéroCpte = num;
		nbLigneRéel = 0;
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
	public double quelTaux()	{
		return taux;
	}
	private String contrôleType()		{
		char tmpc;
                Scanner lectureClavier = new Scanner(System.in);
		String tmpS = "";
		do {
				System.out.print("Type du compte [Types possibles :" ); 
				System.out.print("C(ourant), J(oint), E(pargne)] : ");
				tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'C' && tmpc!= 'J' && tmpc != 'E');
		switch (tmpc)	{
				case 'C' : typeCpte = "Courant";
				break;
				case 'J' : typeCpte = "Joint";
				break;
				case 'E' : typeCpte = "Epargne";
				break;
		}
		return tmpS;
	}
	private double contrôleValinit()	 {
		double tmp, tmpval;
                Scanner lectureClavier = new Scanner(System.in);
		do {
			System.out.print("Valeur initiale du compte : ");
			tmpval= lectureClavier.nextDouble();  
		} while ( tmpval <= 0);
		return tmpval;
	}
	public void créerCpte() 	{ 
                Scanner lectureClavier = new Scanner(System.in);
		typeCpte = contrôleType();
		System.out.print("Numéro du compte : ");
		numéroCpte = lectureClavier.next();
		if ( typeCpte.equalsIgnoreCase("Epargne"))   {
			System.out.print("Taux de placement :     ");
			taux = lectureClavier.nextDouble();
		}    
		val_courante = contrôleValinit();   
	}
	public void créerLigne()	{
		ligne = new LigneComptable();
		nbLigneRéel = 1 ;  
		val_courante = val_courante + ligne.quelleValeur();
	}
	public  void afficherCpte() {
		System.out.print("Le compte n° : " + numéroCpte );
		System.out.println(" est un compte " + typeCpte);
		if ( typeCpte.equalsIgnoreCase("Epargne"))
			System.out.println(" dont le taux est  " + taux);
		if (	 nbLigneRéel > 0) ligne.afficherLigne();
		System.out.println("Valeur courante : " + val_courante);
		if (val_courante < 0) 
			System.out.println("Attention compte débiteur ... !!!");
	}   
}