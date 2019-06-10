/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author alexa
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Personnel p = new Personnel(); 
        p.ajouterEmploye(new Vente("Pierre", "Business", 45, 2005)); 
        p.ajouterEmploye(new Vente("Léon", "Vendtout", 25, 2011)); 
        p.ajouterEmploye(new Production("Yves", "Bosseur", 28, 2000)); 
        p.ajouterEmploye(new Manutention("Jeanne", "Stocktout", 32, 2008)); 
        
        p.calculerHoraire(2); 
        System.out.println("Horaire moyen dans cette entreprise est de" + p.HoraireMensuel() + "heures." ); 

    }
    
}
