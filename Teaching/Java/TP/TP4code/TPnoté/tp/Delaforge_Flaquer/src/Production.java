/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class Production extends Employe{
    int horaire;
    
    public Production(String prenom, String nom, int age, int dateRecrutement)
    {
        super(prenom, nom, age, dateRecrutement);
    }
    
    @Override
    public void calculerHoraire(int semaine)
    {
        if ( (semaine % 2) == 0) 
        {
            horaire=30;
        } 
        else 
        {
            horaire=42;
        }
    }
    
    @Override
    public String getNom()
    {
        String s= "Technicien "+prenom+ " "+nom;
        return s;
    }
    
    @Override
    public int getHoraire()
    {
        return horaire;
    }
}
