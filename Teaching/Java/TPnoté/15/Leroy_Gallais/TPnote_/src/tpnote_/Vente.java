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
public class Vente extends Employe {

    public Vente(String nom, String prenom, int age, int date) {
        super(nom, prenom, age, date);
            type = 'V';

    }


    @Override
    public int calculerHoraire(int semaine) {
        if (semaine %4 == 0 )
        {
            return 48;
        }
        else 
            return 32;
    }
    
    @Override
    public String getFullNom()
    {
        String chaine = "Vente : ";
        chaine =chaine + nom;
        chaine = chaine + " ";
        chaine = chaine + prenom;
        return chaine;
    }
    
}
