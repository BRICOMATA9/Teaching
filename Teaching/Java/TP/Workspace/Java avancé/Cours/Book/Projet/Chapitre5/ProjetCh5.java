/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 5 : De l'algorithme paramétré à l'écriture de fonction
#	Section  : Projet
#	Fichier  : ProjetCh5.java
#	Class    : ProjetCh5
*/
import java.util.*;
public class ProjetCh5  {
 // La fonction principale
 public static void main (String [] argument) {
 byte choix;
 char typeCpte ='\0';
 double val_courante = 0.0, taux = 0.0;
 long numéroCpte = 0, numéroLu = 0 ;
 Scanner lectureClavier = new Scanner(System.in);
 do  {
	choix = menuPrincipal();
	switch (choix) {
		case 1 :
		 do   { 
			System.out.print("Type du compte [Types possibles :" ); 
			System.out.print("C(ourant), J(oint), E(pargne)] :");
			typeCpte = lectureClavier.next().charAt(0);
		 } while ( typeCpte != 'C' && typeCpte != 'J' && typeCpte != 'E');
		 System.out.print("Numéro du compte :");
		 numéroCpte = lectureClavier.nextLong();
		 System.out.print("Première valeur créditée :");
		 val_courante = lectureClavier.nextDouble();  
		 if ( typeCpte == 'E')  {
		  System.out.print("Taux de placement :     ");
		  taux = lectureClavier.nextDouble();
		 }    
		 break;
		case 2 :
		 System.out.print ( " Quel compte souhaitez vous afficher ? : ");
		 numéroLu = lectureClavier.nextLong();
		 if ( numéroLu == numéroCpte)  { 
			System.out.print("Le compte n° : " + numéroCpte + " est un compte ");
			if (typeCpte == 'C') System.out.println(" courant  ");
			else if (typeCpte == 'J') System.out.println(" joint  ");
			else if (typeCpte == 'E') 
				System.out.println(" épargne  dont le taux est  " + taux);
			System.out.println(" Valeur initiale : " + val_courante);
		 }
		 else
		 System.out.println("Le systeme ne connait pas le compte " + numéroLu);
		 break;
		case 3 : 
                 System.out.println("Option non programmée");
		 break;
		case 4 : 
                 sortir();    
		 break;
		case 5 :
		 alAide();
		 break;
		default : 
                 System.out.println("Cette option n'existe pas ");
	}
 } while (choix != 4);
}

// Affiche le menu principal, retourne la valeur de l'option choisie
 public static byte menuPrincipal() {
    byte tmp;
    Scanner lectureClavier = new Scanner(System.in);
    System.out.println("1. Création d'un compte");
    System.out.println("2. Affichage d'un compte");
    System.out.println("3. Ecrire une ligne comptable");
    System.out.println("4. Sortir");
    System.out.println("5. De l'aide");
    System.out.println();
    System.out.print("Votre choix : ");
    tmp  = lectureClavier.nextByte();
    return tmp;
 }
// pour sortir poliment du programme 
 public static void sortir( ) {
   System.out.println("Au revoir et à bientôt");
   System.exit(0) ;    
}
public static void alAide( ) {
  System.out.println("Option 1. Pour creer un compte Courant entrer C ");
  System.out.println("          Pour creer un compte Joint entrer J ");
  System.out.println("          Pour creer un compte Epargne entrer E");
  System.out.print("          Puis, entrer le numero du compte, et"); 
  System.out.println(" sa premiere valeur creditee ");
  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
  System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
  System.out.println("Option 3. Ecrire une ligne comptable");
  System.out.println("Option 4. Pour quitter le programme");
  System.out.println("Option 5. Pour afficher de l'aide");
 }
}