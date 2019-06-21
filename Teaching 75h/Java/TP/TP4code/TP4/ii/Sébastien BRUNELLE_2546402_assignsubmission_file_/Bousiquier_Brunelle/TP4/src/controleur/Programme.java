/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.*;
import modele.*;
import vue.*;
/**
 *
 * @author sebas
 */
public class Programme {
    
    public static void ajouter_mapFond()
    {
        HashMap<String, Fonds> new_hash=new HashMap<String, Fonds>();
        new_hash.put("pret", new Fonds(1500));
        
    }
    
    /**
     * 
     * @param mfond
     * @param minstru
     * @param liste 
     */
    
    public static void remplir_hashmap(HashMap<String, Fonds> mfond, HashMap<String, Instrument> minstru, ArrayList<Fonds> liste)
    {
        mfond.put("pret", new Fonds(65));
        minstru.put("hypotheque", new Instrument(liste));
    }
    
    /**
     * 
     * @param args
     * @throws InstrumentInexistant
     * @throws FondsExistant 
     */
    
    public static void main(String [] args) throws InstrumentInexistant, FondsExistant
    {
        Scanner scan=new Scanner(System.in);
        int choix=-1;
        Portefeuille p=new Portefeuille();
        String nouv;
        double val;
        
                  
        System.out.println("Pour ajouter un fond a votre portefeuille, tapez '1' ");
        System.out.println("Pour ajouter un fond a un instrument de votre portefeuille, tapez '2' ");
        System.out.println("Pour supprimer un fond de votre portefeuille, tapez '3' ");
        System.out.println("Pour supprimer un instrument de votre portefeuille, tapez '4' ");
        System.out.println("Pour consulter les statistiques concernant les instruments, tapez '5' ");
        System.out.println("Pour consulter les statistiques concernant les fonds, tapez '6' ");
        System.out.println("Pour afficher le contenu de votre portefeuille, tapez '7' ");
        
        while(choix!=0){
        
        choix=scan.nextInt();
        scan.nextLine();
        
        switch(choix)
        {
            case 1:
                System.out.println("Saisissez le nom de votre nouveau fond et sa valeur.");
                nouv=scan.nextLine();
                val=scan.nextDouble();
                if(p.recherche_fond(nouv)<0)
                    p.ajouter_fond(nouv, val);
            break;
            
            case 2:
                System.out.println("Saisissez le nom de l'instrument que vous souhaitez modifier et la valeur du fond que vous soouhaitez y ajouter.");
                nouv=scan.nextLine();
                val=scan.nextDouble();
                p.ajouter_fond_instru(nouv, new Fonds(val));
            break;
            
            case 3:
                System.out.println("Saisissez le nom du fond que vous souhaitez supprimer");
                nouv=scan.nextLine();
                p.suppr_fond(nouv);
            break;
            
            case 4:
                System.out.println("Saisissez le nom de l'instrument que vous souhaitez supprimer");
                nouv=scan.nextLine();
                p.suppr_instru(nouv);
            break;
            
            case 5:
                Affichage.afficher_tout(p);
            break;
            
            case 6:
                System.out.println("Saisissez le fond dont vous souhaitez connaitre l'occurence");
                nouv=scan.nextLine();
                Affichage.afficher_fond(p, nouv);
            break;
                
            case 7:
                p.afficher();
            break;
                
        }
        }
        
    /*    Scanner scan=new Scanner(System.in);
        Fonds fond=new Fonds(45);
        Instrument instru=new Instrument();
        ArrayList<Fonds> liste=new ArrayList<Fonds>();
        liste.add(new Fonds(9877));
        HashMap<String, Fonds> mfond=new HashMap<String, Fonds>();
        HashMap<String, Instrument> minstru=new HashMap<String, Instrument>();
        remplir_hashmap(mfond, minstru, liste);
        Portefeuille p=new Portefeuille(mfond, minstru);

        Instrument test=new Instrument(p.recherche_instru("hypotheque"));
        test.afficher();
     */   
    /*    System.out.println("Saisissez le nom du fond à ajouter et sa valeur");
        String cle_cher=scan.nextLine();
        double mon_cher=scan.nextDouble();
       
        if(p.recherche_fond(cle_cher)<0)
            p.ajouter_fond(cle_cher, mon_cher);
        
        System.out.println("Saisissez le nom de l'instrument à ajouter et la valeur du fond correspondant");
        scan.nextLine();
        String nouv_instru=scan.nextLine();
        System.out.println(nouv_instru);
        
        double montant_nouv_instru=scan.nextDouble();
        Fonds f_ajouter=new Fonds(montant_nouv_instru);
        p.ajouter_fond_instru(nouv_instru, f_ajouter);
        
        p.afficher();
        
        System.out.println("Test de suppression de fond :");
        scan.nextLine();
        String sup=scan.nextLine();
        p.suppr_fond(sup);
       p.afficher();
       
       System.out.println("Test de suppression d'instrument :");
       scan.nextLine();
       sup=scan.nextLine();
       p.suppr_instru(sup);
       p.afficher();
       
       
        Instrument nouv=new Instrument();
        Affichage.afficher_tri(nouv);
      */  
       
        
    }
    
}
