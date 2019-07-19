/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.util.*;
import Modèle.*;
import Vue.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valentin
 */
public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static Porte_feuille pf = new Porte_feuille(); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FondsExistant {
        
   String clef;
   int montant;
  
     System.out.println("rentrer clef du fond");
     clef = sc.next();
     System.out.println("rentrer montant");
     montant=sc.nextInt();
     //Q1.5
     try{
     System.out.println(pf.recherche_fonds(clef));
     }
        catch (FondsInexistant e){}
        
     try{
   pf.ajout_fond_hash(clef, montant);
    System.out.println(pf.getFd().get(clef).getA());
    
     }
     catch (FondsExistant e){}
     
        
    
    //Q1.6
   
    System.out.println("rentrer clef de l'instrument");
      String clefinst = sc.next();
        Instrument inst = null;
        
        try{
            pf.recherche_inst(clefinst);
        }
        catch(InstrumentInexistant e){
            inst = new Instrument();
                pf.ajouter_inst(clefinst,inst);
                System.out.println("L'instrument " + clefinst + " est ajouté");
            }
        
        
        Fonds f = pf.getFd(clef);
        
        pf.ajout_fond_instru(clefinst, f);
        System.out.println("Le fonds " + clef + " est mis à l'instrument " + clefinst);
        
        //Q1.7
        System.out.println("création du fonds aide de montant 10");
        
        try{
            pf.ajout_fond_hash("aide", 10);
        }
        catch(FondsExistant e){
        }
       
        System.out.println("suppression du fonds:");
        try {
            pf.suppr_fd("aide");
        } catch (FondsInexistant ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            double mt = pf.recherche_fonds("aide");
            System.out.println("Le fonds de clé aide existe encore !");
        }
        catch(FondsInexistant e){
            System.out.println("Le fonds a été supprimé");
        }
        
    
        System.out.println("création d'un instrument aide de 2 fonds");
        
        pf.ajouter_inst("aide", new Instrument());
        pf.ajout_fond_instru("aide",new Fonds(2));
        pf.ajout_fond_instru("aide",new Fonds(4));
        
        
        System.out.println("On appelle la méthode pour supprimer cet instrument:");
        try {
            pf.suppr_inst("aide");
        } catch (InstrumentInexistant ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            pf.recherche_inst("aide");
            System.out.println("la suppression a échoué");
        }catch(InstrumentInexistant e){
            System.out.println("instrument  supprimé");
        }

      //Q1.9
        System.out.println("création d'un instrument placement de 3 fonds");

       pf.ajouter_inst("placement",new Instrument());
        
        pf.ajout_fond_instru("placement",new Fonds(10));
        pf.ajout_fond_instru("placement",new Fonds(20));
        pf.ajout_fond_instru("placement",new Fonds(30));
       

        System.out.println("On affiche les fonds de l'instrument");
        Afficher.affinst(pf.getInstru("placement"));
        
       //tri ne fonctionne pas 
       //Q1.10 
        System.out.println("Instrument :");
        Afficher.pourc_inst(pf);
        System.out.println("pourcentage de chaque instrument pour le fonds");
        Afficher.pourc_fd(pf, clef);
        
    }
}