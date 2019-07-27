/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author vuong
 */
public class TP4 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        //Premire phase de test: 
        
        Portefeuille p = new Portefeuille(); 
        Scanner sc = new Scanner(System.in);  
        boolean sortie= false; 
        String choix;
        String key;
        double amount;
        Vue affiche = new Vue();
        
        //Préparation du menu: 
        System.out.println("**** / Menu / ****");
        do
        {
          
            System.out.println("Portefeuille:   ");            
            System.out.println("1.  Ajouter un fonds");
            System.out.println("2.  Ajouter un fonds à un instrument"); 
            System.out.println("3.  Supprimer un Fonds");            
            System.out.println("4.  Supprimer un Instrument"); 
            System.out.println("5.  Ajouter un Instrument"); 
   
            System.out.println("6.  Rechercher un Fonds"); 
            System.out.println("7.  Rechercher un Instrument"); 

            System.out.println("8.  Trier un Instrument"); 
            System.out.println("9.  Afficher tout les instruments"); 
            System.out.println("10. Pourcentage"); 
            System.out.println("11. Sortie du menu");

            System.out.println("\nVeuillez choisir une option"); 
            choix = sc.next();  
            System.out.println("\n");
            
            if ( null != choix)
            
            switch (choix) {
            
                //Ajouter un fonds
                case "1":
                    System.out.println("Veuillez saisir la clé de votre Fonds");
                    key = sc.next();
                    System.out.println("Veuillez saisir l'amount");
                    try
                    {
                        amount = sc.nextDouble();
                    
                    
                        //Pour add un fonds dans la collection de Fonds
                        try
                        {
                            p.addFonds(key, amount);
                        }
                        catch( FondsExistant e )
                        {
                            System.out.println( "Ce fond existe déjà");
                        }   
                    }
                    catch(InputMismatchException a)
                    {
                        System.out.println("Format invalide");
                    }
                    break;
                //Ajouter un fonds à un instrument
                case "2":
                    System.out.println("Veuillez saisir la clé de votre Instrument");
                    key = sc.next();
                    System.out.println("Veuillez saisir le montant de votre Fonds");
                    try
                    {
                        amount = sc.nextDouble();
                        //Pour add un fonds dans la collection de Instrument
                        try
                        {
                            //Renvoi la taille de la collection de Fonds de l'instrument.
                            System.out.println("1.  Taille de Instument:" + key +" "+ p.searchInstrument(key).size() );
                            p.searchInstrument(key).add(new Fonds(amount));
                            System.out.println("2.  Taille de Instument:" + key +" "+ p.searchInstrument(key).size() );
                        }
                        catch( InstumentINexistant e )
                        {
                            System.out.println( "Instrument Inexistant: "+e );

                            //Instancier l'instrument et l'ajouter à la HashMap Instument.
                            Instrument d = new Instrument(new Fonds(amount));

                            //On add un instrument par défaut dans Portefeuille
                            p.setInstrumentCollect(key, d);

                            //Pour voir si on ajoute bien dans la collection
                            System.out.println("taille de InstumentCollect:  "+p.getInstrumentCollect().size());
                            System.out.println( "vous avez bien add un nouvel Instrument");
                        }
                    }
                    catch(InputMismatchException a)
                    {
                        System.out.println("Format invalide");
                    }
                    break;
                //Pour la suppression d'un fonds
                case "3":
                    try
                    {
                        //Choix du fond a supprimer avec sa clé
                        System.out.println("Veuillez saisir la clé du fond a supprimer");
                        key=sc.next();
                        //Appel de la méthode qui supprime un fond
                        p.suppFonds(key);
                    }
                    //Envoie une exception si le fond n'existe pas ou si le fond existe lors de l'ajout
                    catch (FondINexistant ex)
                    {
                        System.out.println( "Le Fond que vous voulez supprimer n'existe pas");
                    }   break;
                //Pour la suppression d'un instrument                    
                case "4":
                    System.out.println("Veuillez saisir la clé de l'Instrument a supprimer");
                    key = sc.next();
                    try
                    {
                        //Supprime l'instrument saisi
                        p.suppInstrument(key);
                    }
                    //Envoie une exception si l'instrument n'existe pas
                    catch (InstumentINexistant e)
                    {
                        System.out.println("L'instrument sélectionné n'existe pas");
                    }   break;
                //ajouter un instrument            
                case "5":
                    //Instancier l'instrument et l'ajouter à la HashMap Instument.
                    System.out.println("Veuillez saisir la clé de l'Instrument a ajouter dans le Portefeuille: ");
                    key = sc.next();
                    
                    try
                    {
                        System.out.println("Saisir un montant du fonds de l'instrument");
                        amount = sc.nextDouble();
                    
                        //Création du nouvel instrument
                        Instrument d = new Instrument(new Fonds(amount));
                        //On add un instrument par défaut dans Portefeuille
                        p.setInstrumentCollect(key, d);
                        //Pour voir si on ajoute bien dans la collection
                        System.out.println("Size de InstumentCollect:  "+p.getInstrumentCollect().size());
                        System.out.println( "vous avez bien add un nouvel Instrument");
                    }
                    //Pour éviter le cas où l'utilisateur rentre un caractère non numérique
                    catch(InputMismatchException a)
                    {
                        System.out.println("Format invalide");
                    }
                    break;
                //Pour rechercher un fonds            
                case "6":
                    System.out.println("Veuillez saisir la clé du fonds à rechercher: ");
                    key = sc.next();
                    try
                    {
                        System.out.println(key +" "+p.searchFonds(key));
                    }
                    catch(FondINexistant e)
                    {
                        System.out.println("Fonds Inexistant: "+e);
                    }   break;
                //Rechercher un instrument            
                case "7":
                    System.out.println("Veuillez saisir la clé de l'instrument à rechercher: ");
                    key = sc.next();
                    try
                    {
                        //Récupère la collection de Fonds de l'instrument.
                        ArrayList<Fonds> buffer = p.searchInstrument(key);
                        for (int i=0; i< buffer.size(); i++ )
                        {
                            System.out.println("Fonds num: "+ i);
                            System.out.println("Montant" +buffer.get(i).getAmount() );
                        }
                    }
                    catch(InstumentINexistant e)
                    {
                        System.out.println("Instument Inexistant: "+e);
                    }   break;
                //Trier un instrument            
                case "8":
                    System.out.println("Veuillez saisir la clé de l'Instrument à trier");
                    key=sc.next();
                    p.getTableI().get(key).tricollection();
                    //Affichage de tous les instruments
                    
                    affiche.affichage(p);
                    break;
                //Afficher tout les instruments.
                case "9":
                    affiche.affichage(p);
                    break;
                //Pourcentage            
                case "10":
                    System.out.println("Veuillez saisir la clé du fonds pour le pourcentage");
                    key = sc.next();
                    try
                    {
                        affiche.pourcentage(key, p);
                    }
                    catch (FondINexistant a)
                    {
                        System.out.println("Attention: " +a);
                    }   break;
                //POur sortir de la boucle de jeu.
                case "11":
                    sortie = true;
                    break;
                default:
                    sortie = false; 
                    break;
            }
        }while(sortie == false ); 
        
        }
}