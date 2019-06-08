/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnoté;

/**
 *
 * @author David
 */
public class TPNoté {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Personnel p = new Personnel("abc", "bcd", 1 , 1);
       p.ajouterEmploye(new Vente("Pierre", "Business", 45, 2005));
       p.ajouterEmploye(new Vente("Léon", "Vendtout", 25, 2011));
       p.ajouterEmploye(new Production("Yves", "Bosseur", 28, 2000));
       p.ajouterEmploye(new Manutention("Jeanne", "Stocketout", 32, 2008));
       
       p.calculerHoraires(2);
       System.out.println("Horaire moyen de cette entreprise est de " + p.HoraireMensuel() + " heures.");
       
    }
    
}
