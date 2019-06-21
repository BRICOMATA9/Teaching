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
public class Production extends Employe {
    
    //Horaire en fonction de la semaine
    Map<Integer,Integer> horaire = new HashMap();
    
    //Constructeur par défaut
    public Production(){
        super();
        horaire.put(1,42);
        horaire.put(0,30);
        //Initialisation semaine pair impaire impliquant l'utilisation d'un modulo
        
    }
    
    //Constructeur paramètres
    public Production(String nomEmploye, String prenomEmploye, Integer ageEmploye,Integer dateRecrutement){
        super(nomEmploye,prenomEmploye,ageEmploye,dateRecrutement);
        
        //impair modulo 2 = 1
        horaire.put(1,42);
        
        //pair modulo 2 = 0
        horaire.put(0,30);
    }
    
    public Integer calculerHoraire(Integer semaine){
        //Utilisation du modulo pour déterminer si la semaine est paire ou impaire
         return horaire.get(semaine % 2);
    }
    
    @Override
    public String getNom(){
        return "Technicien  " + this.prenomEmploye + " " + this.nomEmploye;
    }
}
