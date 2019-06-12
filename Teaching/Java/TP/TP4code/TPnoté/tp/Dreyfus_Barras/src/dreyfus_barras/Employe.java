/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreyfus_barras;

/**
 *
 * @author pierre-mathieu.barras
 */
public abstract class  Employe {
     
    
      protected String nomEmploye= null;
      protected String prenomEmploye = null;
      protected Integer ageEmploye = null;
      protected Integer dateRecrutement = null; 
      
      //Constructeur par defaut
      public Employe(){
          
      }
      
      //Constructeur parametre
      public Employe(String nomEmploye, String prenomEmploye, Integer ageEmploye,Integer dateRecrutement){
          
          super();
        
          this.nomEmploye= nomEmploye;
          this.prenomEmploye = prenomEmploye;
          this.ageEmploye= ageEmploye;
          this.dateRecrutement= dateRecrutement;
       
      }
      
      public abstract Integer calculerHoraire(Integer semaine); //Methode abstraite donc pas de body
    
      public String getNom(){
          return "Employé  " + this.prenomEmploye + " " + this.nomEmploye;
      }
      
}
