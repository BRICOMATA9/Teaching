/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreyfus_barras;


import java.util.HashMap;
import java.util.Map;
import java.util.Date;
/**
 *
 * @author pierre-mathieu.barras
 */
public class Manutention extends Employe {
    
    //Horaire en fonction de la semaine
    Map<Integer,Integer> horaire = new HashMap();
    
    
    //Constructeur par défaut
    public Manutention(){
        super();
        
        //Peu importe la semaine toujours le meme horaire mais utilisation d'une map pour respecter la structure
        horaire.put(0,35);

    }
    
    //Constructeur paramètres
    public Manutention(String nomEmploye, String prenomEmploye, Integer ageEmploye,Integer dateRecrutement){
        super(nomEmploye,prenomEmploye,ageEmploye,dateRecrutement);
        horaire.put(0,35);    }
    
    public Integer calculerHoraire(Integer semaine){
      // Nbr modulo 1 = 0  
      return horaire.get(semaine % 1);
    }
    
    @Override
    public String getNom(){
        return "Manutentionnaire  " + this.prenomEmploye + " " + this.nomEmploye;
    }
}
