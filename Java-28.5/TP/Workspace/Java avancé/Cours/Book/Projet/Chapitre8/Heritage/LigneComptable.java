/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - Comprendre l'héritage
#	Fichier  : LigneComptable.java
#	Class    : LigneComptable
*/

import java.util.*;
public class LigneComptable {
	private double valeur;
	private String date;
	private String motif;
	private String mode;
	public LigneComptable()	{
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = lectureClavier.nextDouble();
		System.out.print("Date de l'opération [jj/mm/an] ");
		date = lectureClavier.next();
		motif = contrôleMotif();
		mode = contrôleMode();
	}
	private String contrôleMode() {
                Scanner lectureClavier = new Scanner(System.in);
		String tmpS = "";
		char tmpc ;
		do {
			System.out.print("Mode [C(B), N(° Cheque), V(irement ) ]  : ");
			tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'C' && tmpc != 'N' && tmpc != 'V');
		switch (tmpc) {
			case 'C' : tmpS = "CB";
			break;
			case 'N' : tmpS = "Cheque";
			break;
			case 'V' : tmpS = "Virement";
			break;		
		}
		return tmpS;
	}
	private String contrôleMotif() {
		String tmpS = "";
		char tmpc ;
                Scanner lectureClavier = new Scanner(System.in);
		do {
			System.out.print("Motif de l'operation [S(alaire),");
			System.out.print(" L(oyer), A(limenation), D(ivers)] : ");
			tmpc = lectureClavier.next().charAt(0);
		} while ( tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
		switch (tmpc) {
			case 'S' : tmpS = "Salaire";
			break;
			case 'L' : tmpS = "Loyer";
			break;
			case 'A' : tmpS = "Alimentation";
			break;		
			case 'D' : tmpS = "Divers";
			break;
		}
		return tmpS;
	}
	public double quelleValeur() {
		return valeur ;
	}
	public String quelMotif(){
		return motif ;
	}
	public String quelMode(){
		return mode ;
	}
	public String quelleDate(){
		return date ;
	}
	public void afficherLigne()  {
		if (valeur < 0) 
		System.out.print("Débiter : "+valeur);
		else
    	System.out.print("Créditer : "+valeur);
		System.out.println(" le : "+ date +" motif  : " +motif+ " mode : "+mode);
	}
}