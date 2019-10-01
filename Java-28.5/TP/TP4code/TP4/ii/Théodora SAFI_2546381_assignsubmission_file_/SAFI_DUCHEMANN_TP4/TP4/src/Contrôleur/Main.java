package Contrôleur;
import Modèle.FondExistant;
import Modèle.FondInexistant;
import Modèle.Fonds;
import Modèle.InstruInexistant;
import Modèle.Instrument;
import Modèle.Portefeuille;


import java.util.HashMap;
import java.util.Scanner;

//Binome THEODORA SAFI-HUGO DUCHEMANN

public class Main {
    
    public static void main(String[] args) throws FondInexistant, InstruInexistant {
    	
        String entrée;
        char choix;
        
        //affichage du menu, avec option 1 à 6
        
        Portefeuille p= new Portefeuille();
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1 pour ajouter un fond avec le montant");
        System.out.println("2 pour ajouter un fond avec le fond");
        System.out.println("3 pour ajouter un instrument avec le montant");
        System.out.println("4 pour rechercher un fond");
        System.out.println("5 pour rechercher un instrument");
        System.out.println("6 pour supprimer un fond");
        System.out.println("7 pour supprimer un instrument");
        System.out.println("Saisir le numéro de votre option :");
        
        Scanner sc= new Scanner(System.in);
        entrée=sc.nextLine();
        choix=entrée.charAt(0);
        
        //switch pour les choix
        
        switch(choix){
            case '1' :{ 
                System.out.println("Entrez la clé :");
                String key=sc.nextLine();
                System.out.println("Entrez le montant :");
                Double montant=sc.nextDouble();}
            break;
            case 2 : {
                System.out.println("Entrez la clé :");
                String key=sc.nextLine();
                System.out.println("Entrez le fond :");
                //problème de type ??
                //Fonds fond=sc.next();
                //System.out.println("Vous avez saisi" + key + "et" + fond);
                }
                break;
            case 3 :{
                System.out.println("Entrez ");
            } break;
            case 4 : {
                System.out.println("Entrez la clé du fond recherché :");
                String key = sc.nextLine();
                p.rechercheFond(key);
            } break;
            case 5 : {
                System.out.println("Entrez la clé de l'intrument recherché :");
                String key=sc.nextLine();
                p.rechercheInstru(key);
            } break;
            case 6 : {
                System.out.println("Entrez la clé du fond que vous voulez supprimer :");
                String key= sc.nextLine();
                p.supprimerFond(key, null);
            }break;
            case 7 : {
                System.out.println("Entrez la clé de l'instrument que vous voulez suprimer :");
                String key = sc.nextLine();
                p.supprimerInstru(key);
            }break;
            default : break;
         
            
        }
            
        
    }
}