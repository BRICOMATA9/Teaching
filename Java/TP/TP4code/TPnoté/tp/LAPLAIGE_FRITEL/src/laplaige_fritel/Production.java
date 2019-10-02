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
public class Production extends Employé {
    
    
    private int horaireP[]={30,42,30,42};
    
    
    public Production(String __nom, String __prenom, int __age, int __aannee)
    {
        
        super(__nom,__prenom,__age,__aannee);
    }
   public int calculerHoraire(int semaine)
    {
        return horaireP[semaine];
        
    }
    
    public String GetNom()
    {
        
        String x = "Technicien : " + nom + prenom;
        
        return x;
    }
    
}
