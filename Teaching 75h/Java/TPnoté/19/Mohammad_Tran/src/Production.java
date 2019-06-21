/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiary
 */
public class Production extends Employe{
    
    public Production(String newNom, String newPrenom, int newAge, int newDate){
        super(newNom,newPrenom,newAge,newDate);
        
    }
    
    @Override
    public int calculerHoraire(int semaine){
        int horaire=0;
        if (semaine%2==0){
            horaire=30;
        }
        if (semaine%2==1){
            horaire=42;
        }
        return horaire;
    }
    
    @Override
    public String getNom(){
        return ("Technicien: "+this.getPrenom()+" "+this.getNomnom());
    }
}
