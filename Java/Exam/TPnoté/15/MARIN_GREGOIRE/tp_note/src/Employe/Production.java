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
public class Production extends Employe{

    public Production(String nom, String prenom, int age, int date_embauche) {
        super(nom, prenom, age, date_embauche);
    }

    @Override
    public int calculerHoraire(int semaine) {
      if(semaine > 0 && semaine < 5)
      {
        if(semaine%2 == 0) // paire
        {
            return 30;
        }

        else if(semaine%2 == 1)
        {
            return 42;
        }
      }
        return 0;
  }   
    
    @Override
    public String getNom(){
        return "Technicien: "+ this.prenom +" "+  this.nom ;         
    }
}
