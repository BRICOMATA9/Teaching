package Vue;

import Controleur.*;
import Modele.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe qui permet l'affichage sur la console du menu et des actions de l'utilisateur.
 * @author Kiary
 */
public class Vue {
    
    private Controleur vueControleur;
    private String keyUser;
    private String amountUser;
    
    /**
     * Constructeur surchargé.
     * @param c le controleur lié à la vue qui vérifiera les actions.
     */
    public Vue(Controleur c){
        this.vueControleur=c;
        keyUser=null;
        amountUser=null;
    }
    
    /**
     * Affichage du menu avec les différentes actions possibles pour l'utilisateur.
     * L'utilisateur doit taper un nombre entre 1 et 10 pour effectuer l'action associée à ce nombre.
     * @return l'utilisateur souhaite quitter ou non le programme.
     */
    public boolean displayMenu(){
        System.out.println("************************************");
        System.out.println("Menu:");
        System.out.println("1. Ajouter un fonds dans le portefeuille");
        System.out.println("2. Ajouter un fonds dans l'instrument du portefeuille");
        System.out.println("3. Supprimer un fonds dans le portefeuille");
        System.out.println("4. Supprimer un instrumenet du portefeuille");
        System.out.println("5. Quitter");
        System.out.println("6. Trier la collection de fonds par montant");
        System.out.println("7. Afficher le contenu de chaque instrument");
        System.out.println("8. Afficher le pourcentage d'un fonds dans chaque instrument");
        System.out.println("9. Afficher tous les fonds");
        System.out.println("10. Afficher tous les instruments");
        System.out.print("Faites votre choix : ");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch(choice){
            // ajout du fonds dans le portefeuille avec récupération de la clé et du montant
            // qu'on veut ajouter dans le portefeuille
            case 1:
                System.out.print("Saisissez la clé : ");
                keyUser=sc.next();
                System.out.print("Saisissez le montant : ");
                amountUser=sc.next();
                vueControleur.actionMenu(1,keyUser,amountUser);
                break;
            // ajout du fonds dans un instrument du portefeuille avec récupération de la clé de l'instrument et
            // de la clé du fonds qu'on souhaite ajouter dans l'instrument du portefeuille
            case 2:
                System.out.print("Saisissez la clé de l'instrument : ");
                keyUser=sc.next();
                System.out.print("Saisissez la clé du fonds que vous voulez ajouter : ");
                String keyUserForFonds=sc.next();
                vueControleur.actionMenu(2, keyUser, keyUserForFonds);
                break;
            // suppression d'un fonds dans le portefeuille avec récupération de la clé du fonds à supprimer
            case 3:
                System.out.print("Saisissez la clé du fonds à supprimer : ");
                keyUser=sc.next();
                vueControleur.actionMenu(3, keyUser, amountUser);
                break;
            // suppression d'un instrument du portefeuille avec récupération de la clé de l'instrument à supprimer
            case 4:
                System.out.print("Saisissez la clé de l'instrument à supprimer : ");
                keyUser=sc.next();
                vueControleur.actionMenu(4, keyUser, amountUser);
                break;
            // l'utilisateur quitte le programme
            case 5:
                return true;
            // l'utilisateur trie les fonds par ordre croissant de montant d'un instrument
            // avec récupération de la clé de l'instrument que l'utilisateur veut trier
            case 6:
                System.out.println("Quel instrument souhaitez vous trier?");
                keyUser=sc.next();
                vueControleur.actionMenu(6, keyUser, amountUser);
                break;
            // l'utilisateur affiche chaque instrument présent dans le portefeuille
            // Détails : clé de l'instrument, nombre de fonds dans l'instrument, somme totale des fonds dans l'instrument
            case 7:
                displayEachInstrument();
                break;
            // affichage du pourcentage par rapport au total d'un fonds précis dans chaque instrument
            // avec récupération de la clé du fonds que l'utilisateur veut voir
            case 8:
                System.out.println("Quel fonds souhaitez-vous voir?");
                keyUser=sc.next();
                displayFundsPercentage(keyUser);
                break;
            // affichage de tous les fonds contenus dans le portefeuille
            case 9:
                displayAllFunds();
                break;
            // affichage de tous les instruments contenus dans le portefeuille
            case 10:
                displayAllInstruments();
                break;
            // l'utilisateur a entré un nombre associé à aucune action
            default:
                System.out.println("Erreur de choix.");
                break;
        }
        // On réinitialise les attributs à leurs valeurs par défaut après avoir
        // effectué les actions
        keyUser=null;
        amountUser=null;
        displayAllFunds();
        displayAllInstruments();
        return false;
    }
    
    /**
     * Affichage pour chaque instrument de la clé de l'instrument, du nombre de fonds que possède l'instrument ainsi que la somme totale des fonds de l'instrument.
     * @see <a href=https://beginnersbook.com/2013/12/hashmap-in-java-with-example/>Part of the code used</a> <span>and understand thanks to :</span> <a href=https://stackoverflow.com/questions/1383797/java-hashmap-how-to-get-key-from-value> this</a>
     */
    public void displayEachInstrument(){
        Set setIDInstrument=vueControleur.getControleurPortefeuille().getIDInstrument().entrySet();
        Iterator it=setIDInstrument.iterator();
        int tmp=0;
        while(it.hasNext()){
            Map.Entry mentry=(Map.Entry)it.next();
            System.out.println("Instrument "+tmp+" :");
            System.out.println("Clé de l'instrument : "+ mentry.getKey());
            System.out.println("L'instrument possède "+ vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).getArrayFunds().size()+" fonds.");
            System.out.println("La somme totale des montants de ses fonds est de : "+ vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).totalAmount());
            tmp++;
        }
    }
    
    /**
     * Affichage pour chaque instrument du pourcentage par rapport à la somme totale du fonds demandé par l'utilisateur.
     * @param userKey le fonds dont on souhaite connaître le pourcentage dans chaque instrument.
     */
    public void displayFundsPercentage(String userKey){
        try{
            double searchedAmount=vueControleur.getControleurPortefeuille().searchFunds(userKey);
            double percentageAmountInInstrument=0;
            System.out.println("Voici les pourcentages du fonds pour chaque instrument :");
            Set setIDInstrument=vueControleur.getControleurPortefeuille().getIDInstrument().entrySet();
            Iterator it=setIDInstrument.iterator();
            int tmp=0;
            while(it.hasNext()){
                Map.Entry mentry=(Map.Entry)it.next();
                ArrayList<Fonds> fundsAL=vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).getArrayFunds();
                double sum=vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).totalAmount();
                for(int i=0; i<fundsAL.size(); i++){
                    if(fundsAL.get(i).getAmount()==searchedAmount){
                        percentageAmountInInstrument=searchedAmount/sum*100;
                    }
                }
                System.out.println("Pour l'instrument "+tmp+" : "+percentageAmountInInstrument+"%");
            }
        } catch (FondsInexistant fi) {System.out.println(fi.getMessage());}
    }
    
    /**
     * Affichage de tous les fonds du portefeuille.
     */
    public void displayAllFunds(){
        Set setIDFunds=vueControleur.getControleurPortefeuille().getIDFunds().entrySet();
        Iterator it=setIDFunds.iterator();
        int tmp=0;
        System.out.println("************************************");
        while(it.hasNext()){
            Map.Entry mentry=(Map.Entry)it.next();
            System.out.println("Fonds "+tmp+" :");
            System.out.println("Clé du fonds : "+ mentry.getKey());
            System.out.println("Le montant du fonds est de "+ vueControleur.getControleurPortefeuille().getIDFunds().get(mentry.getKey()).getAmount());
            tmp++;
        }
    }
    
    /**
     * Affichage de tous les instruments du portefeuille.
     */
    public void displayAllInstruments(){
        Set setIDInstrument=vueControleur.getControleurPortefeuille().getIDInstrument().entrySet();
        Iterator it=setIDInstrument.iterator();
        int tmp=0;
        System.out.println("************************************");
        while(it.hasNext()){
            Map.Entry mentry=(Map.Entry)it.next();
            System.out.println("Instrument "+tmp+" :");
            System.out.println("Clé de l'instrument : "+ mentry.getKey());
            System.out.println("L'instrument possède "+ vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).getArrayFunds().size()+" fonds.");
            System.out.print("Voici les montants que possède l'instrument : ");
            for (int i=0; i<vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).getArrayFunds().size();i++){
                System.out.print(vueControleur.getControleurPortefeuille().getIDInstrument().get(mentry.getKey()).getArrayFunds().get(i).getAmount()+" || ");
            }
            tmp++;
            System.out.println();
        }
    }
}
