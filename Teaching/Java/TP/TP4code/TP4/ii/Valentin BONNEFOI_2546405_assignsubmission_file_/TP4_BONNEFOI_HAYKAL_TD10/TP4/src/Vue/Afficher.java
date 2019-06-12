/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import java.util.HashMap;
import java.util.function.BiConsumer;
import Modèle.*;
import Controleur.*;



/**
 *
 * @author valentin
 */
public class Afficher {
    //affichage de l'instrument
    public static void affinst(Instrument in){
        System.out.println("Fonds de l'instrument: ");
        in.affinst();
    }
    //affichage du fond
    public static void afffds(Fonds fonds){
        System.out.println("Montant du fond: " + fonds.getA());
    }
    //affichage fond totaux
    public static void pourc_inst(Porte_feuille pf){
        HashMap<String, Instrument> instru = pf.getInstru();
        for(String clefinst : instru.keySet()){
            System.out.println("Clef de l'instrument: " + clefinst);
            System.out.println("Fonds: " + instru.get(clefinst).getfondinst().size());
            System.out.println("Totaux des fonds: " + instru.get(clefinst).gettotalfd());
        }
        
    }
    //affichage pourcentage de chaque instrument pour ce fonds
    public static void pourc_fd(Porte_feuille pf, String cleffonds){
        try{
            double amount = pf.recherche_fonds(cleffonds);
            
            for(String clefinst : pf.getInstru().keySet()){
                System.out.println("Clef de l'instrument: " + clefinst);
                double pourcentage = (amount/pf.getInstru(clefinst).gettotalfd())*100;
                System.out.println("Pourcentage de chaque instrument pour ce fonds: " + pourcentage + " %");
                
            }
            
        }catch(FondsInexistant e){
            System.out.println("fond non trouvé ");
        }
        
    }
    
}
