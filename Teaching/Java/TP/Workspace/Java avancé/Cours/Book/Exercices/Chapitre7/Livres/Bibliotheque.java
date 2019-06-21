/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 7 : Creer une classe et un objet 
#	Exercice 7.3 et 7.4 
#	Fichier : Bibliotheque.java
#	Class : Bibliotheque
*/
import java.util.*;
public class Bibliotheque {

	public static void main(String [] arg){
                Scanner lectureClavier = new Scanner(System.in);
		// 7.3
		Livre livrePoche = new Livre();
		System.out.print("Entrez le titre : ");
		livrePoche.titre= lectureClavier.next();
		System.out.print("Entrez la categorie : ");
		livrePoche.categorie = lectureClavier.next();
		System.out.print("Entrez le nom de l'auteur : ");
		livrePoche.nomAuteur= lectureClavier.next();
		System.out.print("Entrez le prenom de l'auteur : ");
		livrePoche.prenomAuteur= lectureClavier.next();		
		System.out.print("Entrez le numero ISBN : ");
		livrePoche.isbn= lectureClavier.next();
		// 7.4
		livrePoche.afficherUnLivre();
		System.out.println("code du livre : " + livrePoche.calculerLeCode());
	}
}
