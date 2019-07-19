/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnoté2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author michelclada
 */
public class Personnel {
    protected ArrayList<Employe> Employes; 
    
    
    public Personnel() {
        Employes = new ArrayList<>();
        

    }
    
    public void ajouterEmploye(Employe emp) {
        Employes.add(emp);
    }
    
    public void calculerHoraires(int i){
        for (int j=0;j<Employes.size();j++) {
            int horaire=Employes.get(j).calculerHoraire(i);
            Employes.get(j).getNom();
            System.out.println(horaire + " heure");
        }
    }
    public int HoraireMensuel(){
        int horairem=0;
        for (int i=0; i<Employes.size();i++){
            for(int j=1;j<5;j++){
                horairem=horairem+Employes.get(i).calculerHoraire(j);
            }
            
        }
        return horairem/Employes.size();
    }
}
