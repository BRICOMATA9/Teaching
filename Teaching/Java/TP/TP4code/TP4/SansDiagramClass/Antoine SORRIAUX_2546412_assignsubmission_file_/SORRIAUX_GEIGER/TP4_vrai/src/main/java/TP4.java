
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * MAIN
 */

/**
 *
 * @author antoinesorriaux et thomasgeiger
 */
public class TP4 {
    
    public static void main(String[] args) throws FondsExistantException, InstrumentInexistantException  {
       
        /**
         * Initialisation des HashMap/Scanner dans le main
         * Instanciation du portefeuille
        */
        HashMap<String,fonds> searchfonds = new HashMap<String,fonds>();
        HashMap<String,Instrument> searchinstru = new HashMap<String,Instrument>(); 
        Scanner input = new Scanner(System.in);
        Portefeuille PF1 = new Portefeuille(searchfonds,searchinstru);
        
        int test = 0;
        /**
         * MENU
        */
        while(test!=10){
        System.out.println("Choisir un test : ");
        System.out.println("1. AJOUT FOND ");
        System.out.println("2. AJOUT INSTRUMENT");
        System.out.println("3. SUPPRESSION FOND ");
        System.out.println("4. SUPPRESSION INSTRUMENT");
        System.out.println("5. AFFICHAGE INSTRUMENT AVEC CLE/MONTANTS");
        
    
        test = input.nextInt();
        
        /**
         * Switch pour les différents propositions du menu
         * AJOUT FOND 
         * AJOUT INSTRUMENT 
         * SUPPRESSION FOND 
         * SUPPRESSION INSTRUMENT 
         * AFFICHAGE
        */
        
        // TEST AJOUT FOND
        switch(test){
            case 1 :
                
            System.out.println("Veuillez saisir une clé :");
            input.nextLine();
            String str = input.nextLine();
            System.out.println("Veuillez saisir un montant :");
            int montant = input.nextInt();
            int montant2 = 0;
        
            try{
            montant2 = PF1.rechercheFonds(str);
            System.out.println("Fond existant : " + str);
            }catch(FondsInexistantException e) {
            PF1.ajoutfonds(str, montant);
            System.out.println("Fond ajouté : " + str);
            }
        break;
        
        // TEST AJOUT INSTRUMENT
            case 2 : 
            
            System.out.println("Veuillez saisir une clé :");
            input.nextLine();
            String str2 = input.nextLine();
            System.out.println("Veuillez saisir un montant :");
            int mont = input.nextInt();
            fonds F1 = new fonds();
            F1.amount = mont; 
            
            try{
            Instrument I3 = new Instrument();
            I3.collectionfonds = PF1.rechercheInstrument(str2);
            
            searchinstru.get(str2).AjoutFonds(F1);
            System.out.println("Instrument existant : " + str2);
            
            }catch(InstrumentInexistantException e) {
            PF1.ajoutInstru(str2, F1);
            System.out.println("Instrument ajouté : " + str2);
            }
            break;
            
        // TEST SUPPRESSION FOND
            
            case 3 : 
            
            System.out.println("Veuillez saisir une clé :");
            input.nextLine();
            String str3 = input.nextLine();
            System.out.println("Veuillez saisir un montant :");
            int montant3 = input.nextInt();
            
        
            try{
            montant3 = PF1.rechercheFonds(str3); 
            PF1.supFonds(str3);
            System.out.println("Fond trouvé et supprimé : " + montant3);
            }catch(FondsInexistantException e) {
            }
            break;
        
        // TEST SUPPRESSION INSTRUMENT
            
            case 4 : 
            
            System.out.println("Veuillez saisir une clé :");
            input.nextLine();
            String str4 = input.nextLine();
            
            try{
            Instrument I3 = new Instrument();
            I3.collectionfonds = PF1.rechercheInstrument(str4);
            PF1.supInstru(str4);
            System.out.println("Instrument trouvé et supprimé : " + str4);
            }catch(InstrumentInexistantException e) {
                
            }
            break;
            
            case 5 : 
                
                Vue V1 = new Vue();
                V1.DisplayforInstru(searchinstru);
                
                break;
                
            
            default : 
                 System.out.println("ERREUR SAISIE");
                 break;
                
           
        } 
            
        
        
    }
    }
    
}
