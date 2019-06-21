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
abstract public class Employe 
{
    protected static String nom;
    protected static String prenom;
    protected static int age;
    protected static String date;
    protected static int horaire;
    protected static String type;
    
    public Employe(String n, String p, int a, String d, String t)
    {
        nom=n;
        prenom=p;
        age=a;
        date=d;
        type=t;
    }
    
    static void calculerHoraire(int s)
    {
        
    }
    
    public String getNom()
    {
        return("Employe: "+prenom+ " "+nom);
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
