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
public class Vente extends Employe{
    private int horaire;
    
    public Vente(String pprenom, String pnom, int page, int pdate_recrutement)
    {
        super(pprenom, pnom, page, pdate_recrutement);
    }
    
    @Override
    public int calculerHoraire(int semaine)
    {
        if(semaine <= 3 )
        {
            horaire = 32;
        }
        else if(semaine > 3)
        {
            horaire = 48;
        }
        return horaire;
    }
    
    @Override
    public String getNom()
    {
        String retstr;
        
        retstr = "Employé : Vendeur";
        
        return retstr;
    }
}
