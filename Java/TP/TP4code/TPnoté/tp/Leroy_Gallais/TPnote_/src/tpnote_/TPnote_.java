/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote_;

/**
 *
 * @author Jean Leroy
 */
public class TPnote_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
Personnel p = new Personnel();

//try {
p.ajouteEmploye(new Vente("Pierre", "Business", 45, 2005));
p.ajouteEmploye(new Vente("Léon", "Vendtout", 25, 2011));
p.ajouteEmploye(new Production("Yves", "Bosseur", 28, 2000));
p.ajouteEmploye(new Manutention("Jeanne", "Stocketout", 32, 2008));

//} catch (ExceptionEmploye e){}
p.calculerHoraires(2);
System.out.println("Horaire moyen dans cette entreprise est de " + p.HoraireMensuel()/4 + " heures.");







}
    
}
