/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreyfus_barras;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pierre-mathieu.barras
 */
public class Vente extends Employe {
    
    //Horaire en fonction de la semaine
    Map<Integer,Integer> horaire = new HashMap();
    
    //Constructeur par défaut
    public Vente(){
        super();
        
        //Initialisation Map en fonction des semaines
        
        horaire.put(1,32);
        horaire.put(2,32);
        horaire.put(3,32);
        horaire.put(4,48);
    }
    
    //Constructeur paramètres
    public Vente(String nomEmploye, String prenomEmploye, Integer ageEmploye,Integer dateRecrutement){
        super(nomEmploye,prenomEmploye,ageEmploye,dateRecrutement);   
        horaire.put(1,32);
        horaire.put(2,32);
        horaire.put(3,32);
        horaire.put(4,48);
    }
    
    public Integer calculerHoraire(Integer semaine){
  
       return horaire.get(semaine);
    }
    
    @Override
    public String getNom(){
        return "Vendeur  " + this.prenomEmploye + " " + this.nomEmploye;
    }
}
