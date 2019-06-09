
package javatp1;

import java.util.Scanner;

/**
 *
 * @author armel
 */
public class TestEtudiant {
    
    public static void main(String arg[]){
        
        int t;
        int i=0;
        float tab[];
        Scanner sc = new Scanner(System.in);
        
    Etudiant etudiant1;
    Etudiant etudiant2;
    etudiant1 = new Etudiant();
    etudiant1.setIdenttifiant("id1");
    etudiant1.nomE = "nom_Etudiant1";
    etudiant1.prenomE = "prenom_Etudiant1";
    etudiant1.setTaille(7);
    
    
    System.out.println("Entrez un entier: ");
    do{
        t= sc.nextInt();
    }while(t<0);
    tab = new float[t];
    float str;
    System.out.println("Saisissez l'élément "+ i + "/" + t +": ");
    do{
        tab[i] = sc.nextFloat();
        i++;
    }while(i<t);
        
        
    etudiant2 = new Etudiant(tab);
    
    System.out.println("Saisissez l'identifiant etudiant, suivi du nom et du prenom:");
    String id1 = sc.nextLine();
    etudiant2.setIdenttifiant(id1);
    etudiant2.nomE = sc.nextLine();
    etudiant2.prenomE = sc.nextLine();
    
    etudiant1.modifier(etudiant2.getIdenttifiant(), tab, t, etudiant2.nomE, etudiant2.prenomE);
    etudiant1.afficheNotes(tab, t);
    }
}
