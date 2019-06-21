/*
#	Le livre de Java, premier langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre indéterminé d'objets 
#	Exercice   : 10.3 
#	Fichier    : Gestionlasse.java
#	Class      : GestionClasse
*/

import java.util.*;
public class GestionClasse  {

 public static void main (String [] argument)
 {
  byte choix = 0 ;
  Classe C = new Classe();
  String prénom, nom;
  Scanner lectureClavier = new Scanner(System.in);
  do  {
    System.out.println("1. Ajoute un etudiant");
    System.out.println("2. Supprime un etudiant");
    System.out.println("3. Affiche la classe");
    System.out.println("4. Affiche un etudiant");
    System.out.println("5. Modifie un etudiant");
    System.out.println("6. Sortir");
    System.out.println();
    System.out.print("Votre choix : ");
    choix  = lectureClavier.nextByte();
    switch (choix) {
     case 1 : C.ajouteUnEtudiant();
     	break;
     case 2 :
     	    System.out.print("Entrer le prenom de l'étudiant a supprimer : ");
    	    prénom = lectureClavier.next();
     	    System.out.print("Entrer le nom de l'étudiant a supprimer : ");
     	    nom = lectureClavier.next();
            C.supprimeUnEtudiant(prénom, nom);
            break;
     case 3 :	
            C.afficheLesEtudiants(); 
            break;
     case 4 :
     	    System.out.print("Entrer le prenom de l'étudiant recherche : ");
    	    prénom = lectureClavier.next();
     	    System.out.print("Entrer le nom de l'étudiant recherche : ");
     	    nom = lectureClavier.next();
     	    C.rechercheUnEtudiant(prénom, nom);
            break;
     case 5 :
     	    System.out.print("Entrer le prenom de l'étudiant a modifier : ");
    	    prénom = lectureClavier.next();
     	    System.out.print("Entrer le nom de l'étudiant a modifier : ");
     	    nom = lectureClavier.next();
     	    C.modifieUnEtudiant(prénom, nom);
            break;
     case 6 : System.exit(0) ;    
     default : System.out.println("Cette option n'existe pas ");
   }
  } while ( choix != 6);
 }
}