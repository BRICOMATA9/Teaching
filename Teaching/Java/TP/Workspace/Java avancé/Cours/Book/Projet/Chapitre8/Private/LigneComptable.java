/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 8 : Les principes du concept "objet"
#	Section  : Projet - La protection privée
#	Fichier  : LigneComptable.java
#	Class    : LigneComptable
*/
import java.util.*;
public class LigneComptable	{
	private double valeur;
	private String date;
	private String motif;
	private String mode;
	public void créerLigneComptable()	{
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer la valeur à créditer (+) ou débiter (-) : ");
		valeur = lectureClavier.nextDouble();
		System.out.print("Date de l'opération [jj/mm/an] ");
		date = lectureClavier.next();
		System.out.print("Motif de l'operation [S(alaire),");
		System.out.print(" L(oyer), A(limenation), D(ivers)] : ");
		motif = lectureClavier.next();
		System.out.print("Entrer le mode [C(B), N(° Cheque), V(irement ) ] : ");
		mode = lectureClavier.next();
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
	public void afficherLigne()	{
		if (valeur < 0) 
		System.out.print("Débiter : "+valeur);
		else
		System.out.print("Créditer : "+valeur);
		System.out.println(" le : "+ date +" motif  : " +motif+ " mode : "+mode);
	}
}