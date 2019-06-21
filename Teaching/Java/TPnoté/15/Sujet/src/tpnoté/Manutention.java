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
public class Manutention extends Employe{
    private int horaire;
    
    public Manutention(String pprenom, String pnom, int page, int pdate_recrutement)
    {
        super(pprenom, pnom, page, pdate_recrutement);
    }
    
    @Override
    public int calculerHoraire(int semaine)
    {
        horaire = 35;
        return horaire;
    }
    
    @Override
    public String getNom()
    {
        String retstr;
        
        retstr = "Employé : Manutentionaire";
        
        return retstr;
    }
}
