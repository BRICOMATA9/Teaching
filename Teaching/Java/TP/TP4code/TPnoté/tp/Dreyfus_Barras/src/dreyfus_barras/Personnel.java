/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreyfus_barras;
import java.util.ArrayList;

/**
 *
 * @author pierre-mathieu.barras
 */
public class Personnel {
    
    private ArrayList<Employe> listeEmploye;
    
    
    public Personnel(){
        listeEmploye= new ArrayList();
    }
    
    
    //Ajoute un employe a la collection
    public void ajouterEmploye(Employe emp){
        this.listeEmploye.add(emp);
    }
    
    public void calculerHoraires(Integer i){
        for(int j=0;j<this.listeEmploye.size();j++){
            System.out.println(this.listeEmploye.get(j).getNom() + " " + this.listeEmploye.get(j).calculerHoraire(i) + " heures.");
        }
    }
    
    public Integer horaireMensuel(){
        Integer moyHoraireMensuel=0;
        
        //Récupère la liste de tous les employes 
        for(int j=0;j<this.listeEmploye.size();j++){
            //Récupère les 4 semaines 
            for(int g=1;g<5;g++){
                //Récupere le nombre d'heure par semaine de l'employe
                moyHoraireMensuel= moyHoraireMensuel + this.listeEmploye.get(j).calculerHoraire(g);
            }
        }
        
        
        //Moyenne du nombre d'heure fait par les employés par mois 
        
        moyHoraireMensuel= moyHoraireMensuel/this.listeEmploye.size();
        
        return moyHoraireMensuel;
    }
    
}
