/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiary
 */
//Création de la classe Manutention qui hérite de la classe Employe
public class Manutention extends Employe{
    
    //Constructeur surchargé de la classe Manutention
    public Manutention(String newNom, String newPrenom, int newAge, int newDate){
        super(newNom,newPrenom,newAge,newDate);
        
    }
    
    //Méthode qui va calculer l'horaire pour le type d'employé Manutentionnaire
    public int calculerHoraire(int semaine){
        return 35;
    }
    
    //Méthode qui renvoie une chaîne avec le type d'employé
    @Override
    public String getNom(){
        return("Manutentionnaire " + this.getPrenom() + " " + this.getNomnom());
    }
}
