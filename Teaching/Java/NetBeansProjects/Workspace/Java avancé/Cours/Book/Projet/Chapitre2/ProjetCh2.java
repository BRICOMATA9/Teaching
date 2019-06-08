/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 2 : Communiquer une information
#	Section  : Projet
#	Fichier  : ProjetCh2.java
#	Class    : ProjetCh2
*/
import java.util.*;
public class ProjetCh2 {
 public static void main (String [] argument) {
  byte choix;
  char typeCpte ='\0';
  double val_courante = 0.0, taux = 0.0;
  long numéroCpte = 0, numéroLu = 0 ;
  Scanner lectureClavier = new Scanner(System.in);
  System.out.println("1. Création d'un compte");
  System.out.println("2. Affichage d'un compte");
  System.out.println("3. Ecrire une ligne comptable");
  System.out.println("4. Sortir");
  System.out.println("5. De l'aide");
  System.out.println();
  System.out.print("Votre choix : ");
  choix = lectureClavier.nextByte();
  //Option 1
  System.out.print("Type du compte [Types possibles : ");
  System.out.print("C(ourant), J(oint), E(pargne)] :");
  typeCpte = lectureClavier.next().charAt(0);
  System.out.print("Numero du compte :");
  numéroCpte = lectureClavier.nextLong();
  System.out.print("Premiere valeur creditee  :");
  val_courante = lectureClavier.nextDouble();  
  //Si compte épargne
  System.out.print("Taux de placement :     ");
  taux = lectureClavier.nextDouble();
  //Option 2
  //demande à l'utilisateur de saisir le numéro du compte à afficher
  System.out.print ( " Quel compte souhaitez vous afficher ? : ");
  numéroLu = lectureClavier.nextLong();
  // Si le numéro du compte existe, 
  System.out.print("Le compte n° : " + numéroCpte + " est un compte ");
  // affiche son taux dans le cas d'un compte épargne.
  System.out.println("epargne  dont le taux est  " + taux);
  System.out.println("Première valeur creditee  : " + val_courante);
  // Sinon, il affiche un message indiquant que le numéro du compte n'est pas valide.
  System.out.println("Le systeme ne connait pas le compte " + numéroLu);
  //Option 3, le programme affiche "option non programmée"
  System.out.println("Option non programmée");
  //Option 4,  le programme termine son exécution
  System.out.println("Au revoir et à bientôt");
  // System.exit(0) ;    
  // Option 5
  // le programme affiche une ligne d'explication pour chaque option
  // du menu principal.
  System.out.println("Option 1. Pour créer un compte Courant entrer C ");
  System.out.println("          Pour créer un compte Joint entrer J ");
  System.out.println("          Pour créer un compte Epargne entrer E");
  System.out.print("          Puis, entrer le numéro du compte, et"); 
  System.out.println(" sa première valeur creditee ");
  System.out.println("          Dans le cas d'un compte epargne, entrer le taux ");
  System.out.println("Option 2. Le systeme affiche les données du compte choisi ");
  System.out.println("Option 3. Ecrire une ligne comptable");
  System.out.println("Option 4. Pour quitter le programme");
  System.out.println("Option 5. Pour afficher de l'aide");
 }
}