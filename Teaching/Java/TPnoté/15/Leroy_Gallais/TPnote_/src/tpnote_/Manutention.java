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
public class Manutention extends Employe {
    

    public Manutention(String nom, String prenom, int age, int date) {
        super(nom, prenom, age, date);
            type = 'M';

    }

    @Override
    int calculerHoraire(int semaine) {
      
        return 35;
        
    }
    
        @Override
        
        
    public String getFullNom()
    {
        String chaine = "Production : ";
        chaine =chaine + nom;
        chaine = chaine + " ";
        chaine = chaine + prenom;
        return chaine;
    }
    


}
