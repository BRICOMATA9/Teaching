/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.ArrayList;

/**
 *
 * @author alexa
 */
public class Personnel {
    
    // création du de la liste des employer
    ArrayList<Employe> listE=new ArrayList();
    
    // méthode d'ajout
    public void ajouterEmploye(Employe e)
    {
        this.listE.add(e);
    }
    
    // méthode qui affiche les horaires en fonction de la semaine
    public void calculerHoraire(int semaine)
    {
        for(int i=0; i<this.listE.size();i++)
        {
            this.listE.get(i).calculerHoraire(semaine);
            System.out.println(this.listE.get(i).getNom() + " " + this.listE.get(i).getH() + " heures");
        }
    }
    
    
    //méthode qui affiche la moyenne des horaires mensuelles
    public int HoraireMensuel()
    {
        int moyenne=0;
        int compteur=0;
        for(int i=0; i<this.listE.size();i++)
        {
            for(int j=0; j<4; j++)
            {
                this.listE.get(i).calculerHoraire(j);
                compteur=compteur+this.listE.get(i).getH();
            }
            
            moyenne=compteur/4;
            
        }
            
        return moyenne;
    }
}
