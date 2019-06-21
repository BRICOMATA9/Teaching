/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flimon_brunelle;

import static flimon_brunelle.Employe.nom;

/**
 *
 * @author sebas
 */
public class Manutention extends Employe
{
    public Manutention(String n, String p, int a, String d)
    {
        super(n, p, a, d, "manu");
    }
    
    public static void calculerHoraire(int semaine)
    {
        horaire=35;
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
