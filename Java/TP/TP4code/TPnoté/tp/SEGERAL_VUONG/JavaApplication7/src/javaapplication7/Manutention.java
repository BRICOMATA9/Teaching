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
public class Manutention extends Employe{
    
    //constructeur manutentionnaire
    public Manutention(String nom,String prenom,int horaireT,int dateRecrutement)
    {
        super(nom,prenom,horaireT,dateRecrutement);
    }
    
    //donne l'horaire 
    @Override
    public void calculerHoraire(int semaine)
    {
       this.horaireT=35;
    }
    
    @Override
    public String getNom()
    {
       String buffer = "Manutentionnaire:" + this.nom + " " + this.prenom; 
       return buffer; 
    }
     @Override
    public int getH()
     {
         return this.horaireT;
     }
}
