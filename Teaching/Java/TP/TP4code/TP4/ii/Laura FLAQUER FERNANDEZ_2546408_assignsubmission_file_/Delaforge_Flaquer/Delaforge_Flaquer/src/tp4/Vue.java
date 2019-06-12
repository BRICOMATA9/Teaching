/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laura 
 * @author ludivine
 * 
 * Sources : 
 *   - Cours de M. Segado
 *   - Javadoc :
 *        - https://docs.oracle.com/javase/6/docs/api/
 *   - Comparable :
 *        - https://pedago-ece.campusonline.me/pluginfile.php/10901/mod_resource/content/0/cours_Interfaces_comparable_et_comparator.pdf
 *        - http://www.iro.umontreal.ca/~dift1020/cours/ift1020/communs/Cours/C10/ComparableComparator.pdf
 *        - https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
 *   - Cours OpenClassroom Hashmap : 
 *        - https://openclassrooms.com/fr/courses/1826586-java-et-les-collections/2666737-linterface-map-k-v
 *   - Tri d'ArrayList avec Collections.sort :
 *        - https://openclassrooms.com/fr/courses/1826586-java-et-les-collections/2666791-generalites
 * 
 */

public class Vue {
    
    /**
     * Afficher les informations relatives à un instrument
     * @param mapInstrument 
     */
    public static void afficheInstrument(Map<String,Instrument> mapInstrument)
    {
        int somme=0;
        Set<Map.Entry<String, Instrument>> setMapInstrument = mapInstrument.entrySet();
        Iterator<Map.Entry<String, Instrument>> it = setMapInstrument.iterator();

        while(it.hasNext())
        {
            Map.Entry<String, Instrument> e = it.next();
            for(int i=0; i<e.getValue().getCollectInstru().size(); i++)
            {
                somme+=e.getValue().getCollectInstru().get(i).getMontant();
            }
            
            System.out.println("L'instrument : "+e.getKey()+" a un nombre total de fonds de "+e.getValue().getCollectInstru().size()+" dont la somme vaut "+somme+"euros.");
        }   
    }
    
    /**
     * Afficher le pourcentage de chaque fonds pour un instrument
     * @param cle
     * @param collectInstru 
     */
    public static void affichePourcentage(String cle, ArrayList<Fonds> collectInstru)
    {
        double pourcentage, total=0;

        System.out.println("Cet instrument possède "+collectInstru.size()+" Fonds.");
        
        for(int i=0; i<collectInstru.size(); i++)
        {
            total+=collectInstru.get(i).getMontant();
        }
        
        for(int i=0; i<collectInstru.size(); i++)
        {
           
            pourcentage=collectInstru.get(i).getMontant()*100/total;
            
            System.out.println("Pourcentage pour le Fonds "+ i +" : " +pourcentage+"%");
        }
    }
        
        
        
    /**
     * Main
     * @param args
     */
    
    public static void main(String[] args) {
        
       Portefeuille portef = new Portefeuille();
       boolean quitte=false;
       
       //Boucle infinie
       do
       {
            Scanner sc=new Scanner(System.in);
            System.out.println("\nQue voulez vous faire ?\n");
            System.out.println("1. Ajouter un fonds");
            System.out.println("2. Ajouter un fonds à un instrument");
            System.out.println("3. Supprimer un fonds");
            System.out.println("4. Supprimer un instrument");
            System.out.println("5. Afficher les fonds d'un instrument triés par montant");
            System.out.println("6. Afficher les informations des instruments");
            System.out.println("7. Afficher le pourcentage de chaque fonds pour un instrument");
            System.out.println("8. Quitter\n");

            String choix = sc.nextLine(); 
            
           //Choix de l'action
            switch(choix)
            {
                 case "1" :
                     System.out.println("Choisir la clé : ");
                     String c = sc.nextLine(); 

                     System.out.println("Choisir le montant du fonds : ");
                     double f = sc.nextInt();

                     try 
                     {
                         portef.ajouterFonds(c,f);
                     }

                     catch (FondsExistant ex) {}
                     break;

                 case "2" : 
                     System.out.println("Clé de l'instument : ");
                     c = sc.nextLine(); 

                     System.out.println("Choisir le montant du fonds : ");
                     f = sc.nextInt();

                     Fonds fond1 = new Fonds(f);

                     try
                     {
                         portef.ajouterInstrument(c, fond1);
                     }

                     catch (FondsExistant ex) {}
                     break;


                 case "3" :
                     System.out.println("Clé du fonds à supprimer : ");
                     c = sc.nextLine(); 
                     portef.supprimerFonds(c);
                     break;

                 case "4" :
                     System.out.println("Clé de l'instrument à supprimer : ");
                     c = sc.nextLine();
                     portef.supprimerInstrument(c);
                     break;

                 case "5" :
                     System.out.println("Clé de l'instrument à trier : ");
                     c = sc.nextLine();
                     try
                     {
                         Instrument instr1 = new Instrument(portef.rechercheInstrument(c));
                         instr1.triCollection();
                         for(Fonds n : instr1.collectInstru) System.out.println(n.montant);
                     }
                     catch (InstrumentInexistant ex) {}
                     break;

                 case "6" :
                     System.out.println("Informations : (vide si pas d'instruments) ");
                     afficheInstrument(portef.mapInstrument);
                     break;

                 case "7" :
                     System.out.println("Clé de l'instrument : ");
                     c = sc.nextLine();
                     
                     try
                     {
                        Instrument instr2 = new Instrument(portef.rechercheInstrument(c));
                        affichePourcentage(c, instr2.collectInstru);
                     }
                     catch (InstrumentInexistant ex) {}
                     
                     break;
                     
                 case "8" : 
                     quitte=true;
                     break;
                     
                default : break;
            }
       }while(!quitte);
       
    }
}