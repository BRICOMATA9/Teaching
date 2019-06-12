/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class Vente extends Employe {
    //déclaration attributs
    protected int horaire;
    
    //constructeur surchargé
    public Vente(String prenom, String nom, int age, int dateRecrutement)
    {
        //appel constructeur classe mère
        super(prenom, nom, age, dateRecrutement);
    }
    
    @Override //on passe outre la méthode de la classe mère
    //méthode pour calculer l'horaire des vendeurs
    public void calculerHoraire(int semaine)
    {
        if(semaine==4) 
        {
            horaire=48;
        }
        else //les trois premières semaines
        {
            horaire=32;
        }
    }
    
    @Override
    //"Employé :" devient "Vendeur "
    public String getNom()
    {
        String s= "Vendeur "+prenom+ " "+nom;
        return s;
    }
    
    @Override
    //méthode get
    public int getHoraire()
    {
        return horaire;
    }
}
