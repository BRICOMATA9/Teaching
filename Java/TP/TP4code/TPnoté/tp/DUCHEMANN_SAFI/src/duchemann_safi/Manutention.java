/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duchemann_safi;

/**
 *
 * @author hugod
 */
public abstract class Manutention extends Employé {    
    public Manutention(String nom, String prenom, int age, int date_recrutement,int horaire){
        super(nom,prenom,age,date_recrutement,horaire);
    }
	
    @Override
    public String getNom(){
        return "Manutentionnaire : " + this.nom+this.prenom;
    }
    public int calculerHoraire(){
        return 35;
    }

}
