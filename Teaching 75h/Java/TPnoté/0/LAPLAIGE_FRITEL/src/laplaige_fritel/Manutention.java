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
public class Manutention extends Employé{
    
    private int horaireM[]={35,35,35,35};
    
    
    
    public Manutention(String noom, String prenoom, int aage, int aaannee)
    {
        super(noom,prenoom,aage,aaannee);
    }
   public int calculerHoraire(int semaine)
    {
        return horaireM[semaine];
        
    }
    
    public String GetNom()
    {
        
        String x = "Manutentioneur: " + nom + prenom;
        
        return x;
    }
    
}
