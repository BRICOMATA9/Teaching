package Contrôleur;

import Modèle.*;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Idris MERIBAH ,Michel CLADA,Nawal ZAID
 */
public class Main 
{
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        // Déclaration et initialisation de variables nécessaires aux test des méthodes implémentées
        Portefeuille p = new Portefeuille();
        Instrument i = new Instrument(), instruSearched = new Instrument();
        System.out.println("/////////")
        // Question 1.2
        Fonds f1 = new Fonds(200.d); Fonds f2 = new Fonds(300.d); Fonds f3 = new Fonds(400.d);
        i.ajouter(f1); i.ajouter(f2); i.ajouter(f3);
        
        System.out.println("Affichage du résultat de la méthode ajouter()");
        
        for(int j = 0 ; j < i.getValeursFonds().size() ; j++)
        {
            System.out.println("Montant du fonds numéro " + (j+1) + " : " + i.getValeursFonds().get(j).getAmount());
        }
        System.out.println("/////////")
        // Question 1.3
        p.getfondsMap().put("Fonds1", f1); p.getfondsMap().put("Fonds2", f2); p.getfondsMap().put("Fonds3", f3);
        double amount1 = 0.d, amount2 = 0.d, amount3 = 0.d;
        
        try
        {
            amount1 = p.rechercherFonds("Fonds1"); amount2 = p.rechercherFonds("Fonds2"); amount3 = p.rechercherFonds("Fonds3");
        }
        
        catch(FondsInexistant fi)
        {
            System.out.println("Erreur : Les fonds recherchés n'existent pas.");
        }
        
        System.out.println("\nAffichage du résultat de la méthode rechercherFonds()");
        System.out.println("Montant du fonds numéro 1 : " + amount1);
        System.out.println("Montant du fonds numéro 2 : " + amount2);
        System.out.println("Montant du fonds numéro 3 : " + amount3);
        
       
        System.out.println("/////////")
        System.out.println("/////////")
}
