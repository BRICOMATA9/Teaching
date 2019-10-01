/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Fonds;
import Modele.Instrument;
import Modele.Portefeuille;
import java.util.Scanner;
import java.util.ArrayList; 
/**
 *
 * @author Nihal
 */
public class TestPortefeuille {
    public static void main(String[]args) throws FondsInexistantException, FondsExistantException{
        Fonds fd= new Fonds();
        Instrument iM = new Instrument();
        Portefeuille Ptf= new Portefeuille();
        String key1,key2;
        double montant =0.0;
        
        //saisie des données clés et le montant
        Scanner sc= new Scanner(System.in);
        System.out.println("entrez la clé de fonds:");
        key1=sc.next();
        System.out.println("entrez le montant de fonds:");
        montant=sc.nextDouble();
        System.out.println("entrez la clé d'instrument :");
        key2=sc.next();
        System.out.println("entrez le montant de fonds de cet instrument :");
        Double montant2 = sc.nextDouble();
        
        try{
           
            double fondsAmount= Ptf.rechercherFonds(key1);
           
        }
        
        catch(FondsInexistantException e1){
                    System.out.println(e1.getMessage());
                    Ptf.ajoutFonds(key1,montant);
                    System.out.println("le fonds est ajouté au portefeuille.");
                    }
        for(String j: Ptf.getFondsMap().keySet()){
            System.out.println("key="+j+"|value="+Ptf.rechercherFonds(j));
        }
        try
        {
            ArrayList<Fonds> aF = new ArrayList<>();
            aF = Ptf.rechercherInstrument(key2);
        }
        catch (InstrumentInexistantException e3)
        {
            System.out.println(e3.getMessage());
            try
            {
             Fonds f2  = new Fonds (montant2);
             ArrayList<Fonds> alF = new ArrayList<>() ; 
             alF.add(f2);
             iM = new Instrument (alF);
             Ptf.getInstrumentMap().put(key2,iM);
             System.out.println("L'instrument est ajouté");
             Ptf.ajoutInstrument(key2,f2);//ajout du fonds dans la hashmap 
            }
            catch (InstrumentInexistantException e4)
                    {
                        System.out.println(e4.getMessage());
                    }
        }
    }
    
}
