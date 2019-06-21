/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author alexa
 */

public class Production extends Employe{
    
    //constructeur Technicien
    public Production(String nom,String prenom,int horaireT,int dateRecrutement)
    {
        super(nom,prenom,horaireT,dateRecrutement);
    }
    
    @Override
    //affecte l'horaire en fonction de si c'est une semaine impair ou pair
    public void calculerHoraire(int semaine)
    {
        //semaine pair = 30h
        if(semaine%2==0)
        {
            this.horaireT=30;
        }
        //semiane impair =42h
        else
        {
            this.horaireT=42;
        }
    }
    
    // getter du nom du vendeur
    @Override
    public String getNom()
    {
       String buffer = "Technicien:" + this.nom + " " + this.prenom; 
       return buffer; 
    }
    
    //getter des horaires du vendeur
   @Override
    public int getH()
     {
         return this.horaireT;
     }
}
