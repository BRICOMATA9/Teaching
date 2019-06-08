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
public class Vente extends Employe{
    
    //constructeur vendeur 
    public Vente(String nom,String prenom,int horaireT,int dateRecrutement)
    {
        //appel le constructeur de la classe employe
        super(nom,prenom,horaireT,dateRecrutement);
    }
    
    @Override
    public void calculerHoraire(int semaine)
    {
        // affecte l'horaire de la semaine 1 à 3 à 32h
        if(semaine<=3 || semaine>=1)
        {
            this.horaireT=32;
        }
        
        // affecte l'horaire de la semaine 4 à 48h
        else if(semaine==4)
        {
            this.horaireT=48;
        }
    }
    
    // getter du nom du vendeur 
    @Override
    public String getNom()
    {
       String buffer = "Vendeur:" + this.nom + " " + this.prenom; 
       return buffer; 
    }
    
    //getter des horaires du vendeur
    @Override
    public int getH()
     {
         return this.horaireT;
     }
}
