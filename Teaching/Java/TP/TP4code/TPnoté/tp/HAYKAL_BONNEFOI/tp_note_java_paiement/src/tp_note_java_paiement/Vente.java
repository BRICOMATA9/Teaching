/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_note_java_paiement;
import java.sql.Date;
/**
 *
 * @author karll
 */
public  abstract class Vente extends Employe {
    
     public int horraire_premier=32;
    public int horraire_dernier=48;
    
    
    
    
        public Vente(int horpre,int horder)
    {
        super();
        horraire_premier=horpre;
        horraire_dernier=horder;
    }
        
 
    
    
     void calculerHorraire(int semaine, Employe e)
    {
        
    }
     
       public String getNom()
    {
        return "Vendeur : Nom, Prenom =" + getNom(); 
    }
    
   
}













