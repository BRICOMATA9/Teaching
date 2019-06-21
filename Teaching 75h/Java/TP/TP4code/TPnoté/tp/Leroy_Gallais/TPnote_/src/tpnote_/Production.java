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
public class Production extends Employe{
    

    public Production(String nom, String prenom, int age, int date) {
    super(nom, prenom, age, date);
    type = 'P';
    }
    @Override
    int calculerHoraire(int semaine) {
            if (semaine % 2 == 0)
            {
                return 30;
            }
            else return 42;
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
