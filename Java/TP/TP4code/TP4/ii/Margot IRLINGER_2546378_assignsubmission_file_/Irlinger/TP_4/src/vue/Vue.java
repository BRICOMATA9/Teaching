/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import modele.*;

/**
 * Classe vue affichant les fonds et les instruments
 * @author margo
 */
public class Vue {
    
    /**
     * Attribut privé du portefeuille à afficher
     */
    private Portefeuille pf;
    
    /**
     * Attribut privé Scanner pour récupérer les données de l'utilisateur
     */
    private Scanner sc;
    
    /**
     * Constructeur surchargé avec un portefeuille en parametre
     */
    public Vue(Portefeuille pf){
        this.pf=pf;
        sc = new Scanner(System.in);
    }
    
    /**
     * Methode qui permet à l'utilisateur de saisir un string pour la cle 
     * pour le fonds à créer
     */
    public String saisieCleFonds(){
        System.out.println("Veuillez entrer une clé pour le fonds:");
        return sc.next();
    }
    
    /**
     * Methode qui permet à l'utilisateur de saisir un double pour le montant 
     * du fonds à créer
     */
    public double saisieMontant(){
        
        System.out.println("Veuillez entrer le montant :");
        return (double) sc.nextInt();
    }
    
    /**
     * Methode qui permet à l'utilisateur de saisir un string pour la cle pour 
     * l'instrument à créer
     */
    public String saisieCleInstru(){
        System.out.println("Veuillez entrer une clé pour l'instrument:");
        return sc.next();
    }
    
    /**
     * Methode qui permet à l'utilisateur de saisir un string pour la cle 
     * pour le fonds à supprimer
     */
    public String saisieCleFondsSupp(){
        System.out.println("Veuillez entrer une clé pour le fonds à supprimer:");
        return sc.next();
    }
    
    /**
     * Methode qui permet à l'utilisateur de saisir un string pour la cle 
     * pour l'instrument à supprimer
     */
    public String saisieCleInstruSupp(){
        System.out.println("Veuillez entrer une clé pour l'instrument à supprimer:");
        return sc.next();
    }
    
    /**
     * Méthode qui affiche les fonds du portefeuille avec en paramètre la c
     * lé du fonds concerné
     */
    public void afficherFonds(String cle){
        
        //verifier qu'il existe
        try{
            pf.rechercheFonds(cle);
            
        }catch(FondsInexistant FI){
            System.out.println("Erreur");
        }
    }
    
    /**
     * Methode qui affiche les instruments du portefeuille
     * Avec sa clé, son nombre de fonds, le total des montants de ses fonds
     */
    public void afficherInstruments(){
        Set keys = pf.getInstruMap().keySet();
        Iterator i = keys.iterator();
        while(i.hasNext()){
            String cle = (String) i.next();
            //On affiche sa clé
            System.out.println("Cle de l'instrument : "+cle);
            //On affiche son nombre total de fonds
            System.out.println("Nombre total de fonds : "+pf.getInstru(cle).getCollection().size());
            //On affiche la somme totale des montants de ses fonds
            double total = 0;
            for(int j =0; j<pf.getInstru(cle).getCollection().size(); j++){
                total+= pf.getInstru(cle).getCollection().get(j).getMontant();
            }
            System.out.println("Total des montants de ses fonds : "+total+"\n");
           
        }
    }
}
