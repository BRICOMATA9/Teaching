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
public abstract class  Employe {
   
    private String nom;
    private String prenom;
    private int age;
    private Date dateRecrutement;
    
    public Employe()
{
   nom= null;
   prenom= null;
   age= 0;
   dateRecrutement = null;
}  
    public abstract void calculerHoraire(int semaine, Employe e);
    
    public String getNom()
    {
        return "Employe : Prenom =" + prenom  + " Nom=" + nom; 
    }
    
    
}
    




