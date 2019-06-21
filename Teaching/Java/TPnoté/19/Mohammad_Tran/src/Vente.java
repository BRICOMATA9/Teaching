/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiary
 */
//Création de la classe Vente qui hérite de la classe Employe
public class Vente extends Employe{
    
    //Constructeur surchargé de la classe Vente
    public Vente(String newNom, String newPrenom, int newAge, int newDate){
        super(newNom,newPrenom,newAge,newDate);
    }
    
    @Override
    //Méthode qui va calculer l'horaire pour le type d'employé Vendeur
    public int calculerHoraire(int semaine){
        int horaire=0;
        //Pour les 3 premières semaines
        if (semaine<4 && semaine > 0){
            horaire=32;
        }
        //Pour la dernière semaine
        else
            horaire=48;
        return horaire;
    }
    
    //Méthode qui renvoie une chaîne avec le type d'employé
    @Override
    public String getNom(){
        return("Vendeur " + this.getPrenom() + " " + this.getNomnom());
    }
}
