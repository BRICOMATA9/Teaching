/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 - 11 : Fichiers communs au projet
#	Section  : Projet
#	Fichier  : LigneComptable.java
#	Class    : LigneComptable
*/

import java.io.*;
import java.text.*;
import java.util.*;
public class LigneComptable implements Serializable {
	private double valeur;
	private String date;
	private String motif;
	private String mode;

	public LigneComptable() {
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = lectureClavier.nextDouble();
		motif = contrôleMotif();
	    	mode = contrôleMode();
   	        date = contrôleDate();
	}
	
	private String contrôleDate() {
                Scanner lectureClavier = new Scanner(System.in);
		int nb = 0;
		Date d = null;
		SimpleDateFormat formatIn=new SimpleDateFormat("dd/MM/yyyy"); 
		String sdate;
		while (d == null){
	   	try {
       	          System.out.print("Entrer une date (jj/mm/aaaa): ");
	     	  d = formatIn.parse(lectureClavier.next());
                }
	    	catch( ParseException p) {
		    nb++;
		    if (nb  >= 3) d = new Date();
	     }
	   }
    	sdate = formatIn.format(d); 
    	return sdate;
	}
	/*
	public LigneComptable()	{
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = lectureClavier.nextDouble();
		System.out.print("Date de l'opération [jj/mm/an] ");
		date = lectureClavier.next();
		motif = contrôleMotif();
		mode = contrôleMode();
	} */
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
                Scanner lectureClavier = new Scanner(System.in);
		String tmpS = "";
		char tmpc ;
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