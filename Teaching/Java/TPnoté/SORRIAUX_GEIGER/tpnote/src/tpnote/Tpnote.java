/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author geige
 */
public class Tpnote {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Personnel p = new Personnel();
	p.ajouteEmploye(new Vente("Pierre","Business",45,2005));
	p.ajouteEmploye(new Vente("Léon","Vendtout",25,2011));
	p.ajouteEmploye(new Production("yves","Bosseur",28,2000));
	p.ajouteEmploye(new Manutention("Jeanne","Stocketout",32,2008));
        
        p.calculerHoraires(2);
        System.out.println("Horaire moyen dans cette entreprise est de " +p.HoraireMensuel() + " heures.");

    }
    
}
