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
public abstract class Employe {
    protected String nom;
    protected String prenom;
    protected int age;
    protected int date_recrutement;
    
    public Employe(String pprenom, String pnom, int page, int pdate_recrutement)
    {
        this.nom = pnom;
        this.prenom = pprenom;
        this.age = page;
        this.date_recrutement = pdate_recrutement;
    }
    
    public abstract int calculerHoraire(int semaine);
    
    public String getNom()
    {
        String retstr;
        
        retstr = "Employé: " + nom + " " + prenom;
        
        return retstr;
    }
}
