/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laura
 */
public class Manutention extends Employe{
    //déclaration attributs
    protected int horaire;
    
    //constructeur surchargé
    
    public Manutention(String prenom, String nom, int age, int dateRecrutement)
    {
        //appel constructeur classe mère
        super(prenom, nom, age, dateRecrutement);
    }
    
    @Override //on passe outre la méthode de la classe mère
    //méthode pour calculer l'horaire des vendeurs
    public void calculerHoraire(int semaine)
    {
        horaire=35; //horaire constant
    }
    
    @Override
    public String getNom()
    {
        String s= "Manutentionnaire "+prenom+ " "+nom;
        return s;
    }
    
    @Override
    public int getHoraire()
    {
        return horaire;
    }
    
}
