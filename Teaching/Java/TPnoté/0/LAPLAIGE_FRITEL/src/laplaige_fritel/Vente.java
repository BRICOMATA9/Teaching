/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laplaige_fritel;

/**
 *
 * @author ludov
 */
public class Vente extends Employé{
    
    private int horaireV[]={32,32,32,48};
    
    
    public Vente(String nom, String prenom, int age, int aannee)
    {         
    
        super(nom,prenom,age,aannee);
        
        
        
        
    
}
    
    
    
    public int calculerHoraire(int semaine)
    {
        return horaireV[semaine];
        
    }
    
    public String GetNom()
    {
        
        String x = "Vendeur : " + nom + prenom;
        
        return x;
    }
    
}
