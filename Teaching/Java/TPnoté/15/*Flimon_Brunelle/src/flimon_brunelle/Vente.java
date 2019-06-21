/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimon_brunelle;

/**
 *
 * @author sebas
 */
public class Vente extends Employe
{
    public Vente(String n, String p, int a, String d)
    {
        super(n, p, a, d, "vente");
    }
    
   
    
    public static void calculerHoraire(int semaine)
    {
        if(semaine<4)
            horaire=32;
        else
            horaire=48;
        System.out.print(horaire);
        
    }
    
     public String getNom()
    {
        return("Vendeur: "+prenom+ " "+nom);
    }
     
     public String getType()
     {
         return type;
     }
     
      public int getHoraire()
     {
         return horaire;
     }
}
