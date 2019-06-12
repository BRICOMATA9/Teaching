/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/**
 *
 * @author Kiary
 */

//Création de la classe Personnel
public class Personnel {
    
    //ArrayList d'employés
    private ArrayList<Employe> arrayPersonnel=new ArrayList();
    
    /*
    *Méthode qui ajoute un employé à notre ArrayList
    * @param newEmploye: on détaille les attributs de l'employé
    */
    public void ajouterEmploye(Employe newEmploye){
        arrayPersonnel.add(newEmploye);
    }
    
    /*
    *Méthode qui renvoie l'horaire calculé pour un type d'employé
    */
    public void calculerHoraires(int i){
        for (int j=0;j<arrayPersonnel.size();j++){
            System.out.println(arrayPersonnel.get(j).getNom()+" "+arrayPersonnel.get(j).calculerHoraire(i)+" heures");
        }
    }
    
    /*
    * Méthode qui affiche un tableau contenant les horaires des employés de la collection sur un mois
    */
    public int HoraireMensuel(){
        int horaireMoyen=0;
        for (int i=0;i<arrayPersonnel.size();i++){
            for (int j=0;j<4;j++){
                horaireMoyen+=arrayPersonnel.get(i).calculerHoraire(j);
            }
        }
        horaireMoyen/=arrayPersonnel.size();
        return horaireMoyen;
    }
    /*
    * On vérifie si chaque employé peut avoir une prime
    */
    public void verifierPrimes(){
            for(int i=0;i<arrayPersonnel.size();i++){
                try{
                arrayPersonnel.get(i).verifierPrime();
            } catch (ExceptionEmploye ee){
                //System.out.println(ee.getMessage());
                System.out.println(arrayPersonnel.get(i).getNom());}
        } 
    }
    
    /*
    *   On teste nos fonctionnalités
    */
    public static void main(String[] args){
        Personnel p=new Personnel();
        p.ajouterEmploye(new Vente("Pierre", "Business", 45, 2005));
        p.ajouterEmploye(new Vente("Léon", "Vendtout", 25, 2011));
        p.ajouterEmploye(new Production("Yves", "Bosseur", 28, 2000));
        p.ajouterEmploye(new Manutention("Jeanne", "Stocketout", 32, 2008));
        
        p.calculerHoraires(2);
        System.out.println("Horaire moyen dans cette entreprise est de " + p.HoraireMensuel() + " heures.");
        System.out.println("Employés concernés par la prime:");
        p.verifierPrimes();
    }
}