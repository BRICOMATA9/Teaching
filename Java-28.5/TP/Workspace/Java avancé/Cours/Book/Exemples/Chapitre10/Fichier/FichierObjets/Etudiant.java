/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets
#	Section  : Les fichiers d'objets
#	Fichier  : Etudiant.java
#	Class    : Etudiant
*/
import java.util.*;
import java.io.*;
public class Etudiant	 implements Serializable	{
	private String nom, prénom;
	private double [] notes; 
	private double moyenne;
        public Etudiant()   	{
                Scanner lectureClavier = new Scanner(System.in);
		System.out.print("Entrer le nom de l'etudiant : ");
		nom = lectureClavier.next();
		System.out.print("Entrer le prénom de l'etudiant : ");
		prénom = lectureClavier.next();
		System.out.print("Combien de notes pour l'etudiant  ");
		System.out.print( prénom + " " + nom + " :  ");
		int nombre = lectureClavier.nextInt();
		notes = new double [nombre];
		for (int i = 0; i < notes.length; i ++)	{
			System.out.print("Entrer la note  n° "+ (i+1)+ " :  ");
			notes[i] = lectureClavier.nextDouble();
		}
		moyenne = calculMoyenne();
	}
	public void afficheUnEtudiant()  {
  		System.out.print("Les notes  de " + prénom + " " + nom + " sont : ");
  		for(double valeurNote : notes)	System.out.print(" " + valeurNote);
 		System.out.println();
  		System.out.println("Sa moyenne vaut " + moyenne);
 	}

	private double calculMoyenne() 	{ 
  		double somme = 0.0;
  		for(double valeurNote : notes) somme = somme + valeurNote;
  		return somme/notes.length;
	}
	public String quelNom()	{ 
		return nom;
	}
	public String quelPrénom()	{ 
		return prénom;
	}
	public double quelleMoyenne()	{ 
		return moyenne;
	}
}