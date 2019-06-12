/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Model.FondsInexistant;
import java.util.Scanner;
import Model.Instrument;
import Model.Portefeuille;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe console (vue) ou j'affiche toutes les instructuctions sur la console
 * J'ai déclaré les méthodes en static pour plus de facilité
 * @author Emma
 */
public class Console {
    
    /** Méthode static RecupClefsFonds qui retourne une clef de fonds entrée par 
     * l'utilisateur
     * @return  */
    static public String recupClefFonds()
    {
       Scanner sc = new Scanner(System.in);     
       System.out.print("Entrez une clef de fonds (fn) svp: ");
       String clefFonds = sc.next();
       return clefFonds;
    }
    
     /** Méthode static RecupClefsInstru qui retourne une clef d'instru entrée 
     * par l'utilisateur
     * @return  */
    static public String recupClefInstru()
    {
       Scanner sc = new Scanner(System.in);     
       System.out.print("\nEntrez une clef d'instrument (in) svp: ");
       String clefInstru = sc.next();
       return clefInstru;
    }
    
     /** Méthode static RecupAmount qui retourne une montant entré par 
     * l'utilisateur
     * @return  */
    static public int recupAmount()
    {
       Scanner sc = new Scanner(System.in);     
       System.out.print("Entrez un montant svp: ");
       int amount = sc.nextInt();
       return amount;
    }
    
     /** Méthode static SupprimerFonds qui retourne une clef de fonds entrée par 
     * l'utilisateur
     * @return  */
    static public String supprimerFonds()
    {
       Scanner sc = new Scanner(System.in);     
       System.out.print("\nEntrez la clef du fond (fn) à supprimer: ");
       String clefFonds = sc.next();
       return clefFonds;
    }
    
    /** Méthode static SupprimerInstru qui retourne une clef d'instru entrée 
    * par l'utilisateur
    * @return  */
    static public String supprimerInstru()
    {
       Scanner sc = new Scanner(System.in);     
       System.out.print("Entrez la clef de l'instrument (in) à supprimer: ");
       String clefInstru = sc.next();
       return clefInstru;
    }
    
     /** Méthode static choixTri qui retourne un instrument récupéré dans la 
     * HashMap grace à une clef entrée par l'utilisateur.
     * @param instruments
     * @return  */
    static public Instrument choixTri(HashMap<String,Instrument> instruments)
    {
        Scanner sc = new Scanner(System.in);     
        System.out.print("Entrez la clef de l'instrument à trier svp: ");
        String clef = sc.next();
        return instruments.get(clef);
    }
    
     /** Méthode static affichageTri qui affiche les montants de tous les 
     * fonds de l'instrument passé en paramètre.
     * @param instrument */
    static public void affichageTri(Instrument instrument)
    {
        System.out.println("\nAffichage des montants triés:");
        for(int i=0; i<instrument.getCollection().size(); i++)
        {
            System.out.println(instrument.getCollection().get(i).getAmount()); 
        }
    }
    
     /** Méthode static affichageTout qui affiche la liste la clef de tous 
     * les instruments avec la taille de leur collection de fonds et 
     * la somme de tous les montants de tous leurs fonds de leur collection
     * @param instruments */
    static public void affichageTout(HashMap<String,Instrument> instruments)
    {
        // Faire une iteration sur les clefs de l’interface map 
        Set keys = instruments.keySet(); 
        Iterator it = keys.iterator(); 
        
        System.out.println("\nAffichage de la liste d'instruments");
        while (it.hasNext()) // s’il reste un objet suivant dans la liste
        { 
          // Initialisation
          double somme = 0.0;
          
          Object  key = (String) it.next(); // passer à la clef suivante 
          Instrument valeur = instruments.get(key); // recupère la valeur dans la liste
       
            System.out.println("\nClef instrument: " + key);
            System.out.println("Nombre total de fonds: " + valeur.getCollection().size());
           
            for(int i=0; i<valeur.getCollection().size();i++)
            {
                somme = somme + valeur.getCollection().get(i).getAmount();
            }
            System.out.println("Somme des montants de ses fonds: " + somme);
        }
    }
}
