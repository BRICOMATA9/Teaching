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
public abstract class Manutention extends Employe {
    
    public int horraire=35;
    
    
    public Manutention(int hor)
    {
        super();
        horraire=hor;
    }
    
  void calculerHorraire(int semaine, Employe e)
    {
        
    }
 
         public String getNom()
    {
        return "Manutentionnaire : Nom, Prenom =" + getNom(); 
    }
  
  
    
    
    
}










