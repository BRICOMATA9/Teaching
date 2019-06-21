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
public abstract class Employé {
    
    protected String nom,prenom;
    
  
    
    protected int age,annee_recrutement;
    
    public Employé(String _nom, String _prenom, int _age, int annee)
    {
        
       this.nom=_nom;
        this.prenom=_prenom;
        this.age=_age;
        this.annee_recrutement=annee;
      
    }
    
    abstract int calculerHoraire(int semaine);
    
        
        
    
    
    public String GetNom()
    {
        
        String x = "Employé : " + nom + prenom;
        
        return x;
    }
}
