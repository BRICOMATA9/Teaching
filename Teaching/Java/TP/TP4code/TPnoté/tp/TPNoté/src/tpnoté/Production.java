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
public class Production extends Employe{
    private int horaire;
    
    
   public Production(String pprenom, String pnom, int page, int pdate_recrutement)
    {
        super(pprenom, pnom, page, pdate_recrutement);
    }
    
    @Override
    public int calculerHoraire(int semaine)
    {
        if(semaine%2 == 0)
        {
            horaire = 30;
        }
        else
        {
            horaire = 42;
        }
        return horaire;
    }
    
    @Override
    public String getNom()
    {
        String retstr;
        
        retstr = "Employé : Technicien";
        
        return retstr;
    }
}
