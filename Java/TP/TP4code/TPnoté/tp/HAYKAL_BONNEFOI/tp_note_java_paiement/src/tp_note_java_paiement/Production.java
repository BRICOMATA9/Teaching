/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_note_java_paiement;

/**
 *
 * @author karll
 */
public abstract class Production extends Employe {
    
    public int horraire_paire=30;
    public int horraire_impaire=42;
    
    
    
    
        public Production(int horp,int horimp)
    {
        super();
        horraire_paire=horp;
        horraire_impaire=horimp;
    }
     void calculerHorraire(int semaine, Employe e)
    {
        
    }
     
       public String getNom()
    {
        return "Technicien : Nom, Prenom =" + getNom(); 
    }
    
    
}







