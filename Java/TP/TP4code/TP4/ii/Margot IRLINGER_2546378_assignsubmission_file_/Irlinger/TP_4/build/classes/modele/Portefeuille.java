/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe Portefeuille
 * @author margo
 */
public class Portefeuille {
    /**Attribut privé HashMap ayant comme clé un String et comme valeur un Fonds*/
    private HashMap<String,Fonds> fondsMap;
    /**Attribut privé HashMap ayant comme clé un String et comme valeur un Instrument*/
    private HashMap<String,Instrument> instruMap;
    
    /**Constructeur par defaut instanciant les HashMap*/
    public Portefeuille(){
        fondsMap = new HashMap<String,Fonds>();
        instruMap = new HashMap<String,Instrument>();
    }
    
    /**Constructeur chargé avec en paramètre deux Hashmap correspondant aux 2 attributs*/
    public Portefeuille(HashMap<String,Fonds> fondsMap, HashMap<String,Instrument> instruMap){
        this.fondsMap=fondsMap;
        this.instruMap=instruMap;
    }
    
    /**Getter prenant en paramètre un String pour retourner le fonds correspondant*/
    public Fonds getFonds(String cle){
        return fondsMap.get(cle);
    }
    
    /**Getter prenant en paramètre un String pour retourner le hashmap de fonds correspondant*/
    public HashMap<String,Fonds> getFondsMap(){
        return fondsMap;
    
    }
    /**Getter prenant en paramètre un String pour retourner l'instrument correspondant*/
    public Instrument getInstru(String cle){
        return instruMap.get(cle);
    }
    
    /**Getter prenant en paramètre un String pour retourner le hashmap d'instrument correspondant*/
    public HashMap<String,Instrument> getInstruMap(){
        return instruMap;
    }
    
    /**Methode recherchant le fond associé au string passé en parametre
     lance l'exception FondsInexistant s'il n'existe pas*/
    public double rechercheFonds(String cle)throws FondsInexistant{   

        if(!fondsMap.containsKey(cle)){
            throw new FondsInexistant();               
        }else return fondsMap.get(cle).getMontant();
    }
    
    /**Methode recherchant l'instrument associé au string passé en parametre
     lance l'exception InstruInexistant s'il n'existe pas*/
    public ArrayList<Fonds> rechercheInstru(String cle)throws InstruInexistant{
        if(!instruMap.containsKey(cle)){
            throw new InstruInexistant();
        }else return instruMap.get(cle).getCollection(); 
    }
    
    /**Methode ajoutant un fonds à la hashmap grâce à un string passé en paramètre pour le clé
     et un double pour le montant 
     Lance les exceptions FondsExistant et FondsInexistant*/
    public void ajouterFonds(String cle, double montant)throws FondsExistant{
        try{
            rechercheFonds(cle);
            throw new FondsExistant();
        }
        catch(FondsInexistant FI){
            Fonds f = new Fonds(montant);
            fondsMap.put(cle, f);
            System.out.println("Fonds ajouté");
        }
               
    }
    
    /**
     * Methode ajoutant un instrument à la hashmap grâce à un string passé en paramètre 
     * pour le clé et un fonds
     * Lance les exceptions InstruExistant et InstruInexistant
     */
    public void ajouterInstru(String cle, Fonds f)throws InstruExistant{
        try{
            rechercheInstru(cle);
            throw new InstruExistant();
        }
        catch(InstruInexistant II){
            Instrument instru = new Instrument();
            instru.ajouterFonds(f);
            instruMap.put(cle,instru);
            System.out.println("Instrument ajouté");
        }
        catch(InstruExistant IE){
            instruMap.get(cle).ajouterFonds(f);
            System.out.println("Instrument ajouté");
        }
    }
    
    /**Methode supprimant le fonds de la hashmap grâce au string passé en parametre
     Catch l'exception FondsInexistant*/
    public void supprimerFonds(String cle){
        try{
            rechercheFonds(cle);
            fondsMap.remove(cle);
            System.out.println("Fonds supprimé");
        }catch(FondsInexistant FI){
            System.out.println("Impossible de supprimer ce fond");
        }
    }
    
    /**Methode supprimant l'instrument de la hashmap grâce au string passé en parametre
     Catch l'exception InstruInexistant*/
    public void supprimerInstru(String cle){
        try{
            rechercheInstru(cle);
            instruMap.get(cle).supprimerCollection();
            instruMap.remove(cle);
            System.out.println("Instrument supprimé");
        }catch(InstruInexistant II){
            System.out.println("Impossible de supprimer cet instrument");
        }
    }
    
       
}
