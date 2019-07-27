/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 - 11 : Fichiers communs au projet
#	Section  : Projet
#	Fichier  : CteEpargne.java
#	Class    : CpteEpargne
*/
import java.util.*;
import java.io.*;
public class CpteEpargne extends Compte implements Serializable {	 
	private double  taux ; 
	public CpteEpargne() {
		super("Epargne");
		taux = contrôleTaux();
	 }
	private double contrôleTaux() {
		double tmp;
                Scanner lectureClavier = new Scanner(System.in);
		do {
			System.out.print("Taux de placement :     ");
			tmp = lectureClavier.nextDouble();
		} while (tmp < 0);
		return tmp;
	}
	public  void afficherCpte()   {
		super.afficherCpte();
		System.out.println(" Taux d'epargne du compte :  " + taux);
	}
	public double quelTaux()	{
		return taux;
	}
}