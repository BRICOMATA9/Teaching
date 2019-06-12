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
public class Production extends Employe
{
    public Production(String n, String p, int a, String d)
    {
        super(n, p, a, d, "prod");
    }
    
    public static void calculerHoraire(int semaine)
    {
        if(semaine%2==0)
            horaire=30;
        else
            horaire=42;
        System.out.print(horaire);
    }
    
     public String getNom()
    {
        return("Technicien: "+prenom+ " "+nom);
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
