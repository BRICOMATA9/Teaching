/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employe;

/**
 *
 * @author Daniel Marin
 */
public class Vente extends Employe{

    public Vente(String nom, String prenom, int age, int date_embauche) {
        super(nom, prenom, age, date_embauche);
    }

    @Override
    public int calculerHoraire(int semaine) {
      if(semaine > 0 && semaine < 5)
      {
        if(semaine < 4) // paire
        {
            return 32;
        }
        else if(semaine == 4)
        {
            return 48;
        }
      }
        return 0;
  }
    
    @Override
    public String getNom(){
        return "Vendeur: "+ this.prenom +" "+  this.nom ;         
    }
    
}
