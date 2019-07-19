/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package delgay_melloul;
import java.util.ArrayList;

public class Personnel {
    
    //attributs
    private ArrayList<Employe> employes = new ArrayList<Employe>();
    
    //methodes
    public void ajouterEmploye(Employe e){
        employes.add(e);
    }
    
    public void calculerHoraires(int i){
        //parcours de l'arrayList employes
        for(int j=0; j < employes.size(); j++){
            System.out.println(employes.get(j).getNom());
            employes.get(j).calculerHoraire(i);
        }
    }
    
    /*public int HoraireMensuel(){
        for(int j=0; j < employes.size(); j++){
            employes[j].
                    }
    }*/
}
