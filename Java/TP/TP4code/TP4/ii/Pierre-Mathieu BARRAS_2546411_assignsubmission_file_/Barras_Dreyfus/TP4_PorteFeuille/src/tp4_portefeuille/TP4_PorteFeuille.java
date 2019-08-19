/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_portefeuille;
import Modele.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Controleur.*;
import Vue.Affichage;
/**
 *
 * @author evadr
 */
public class TP4_PorteFeuille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
        double amount;
        String cle;
        
        
        Affichage a1= new Affichage();
        Fonds f1=new Fonds(120);
        Fonds f2=new Fonds(130);
        Fonds f3= new Fonds(150);
        Fonds f4=new Fonds(160);
        Fonds f5= new Fonds(170);
        Fonds f6 = new Fonds(190);
        Fonds f7= new Fonds(200);
        Fonds f8= new Fonds(260);
        Fonds f9= new Fonds(269);
        Fonds f10= new Fonds(12348);
        
        HashMap<String,Fonds> hs1=new HashMap();
        
        hs1.put("d",f4);
        hs1.put("g",f6);
        hs1.put("k",f9);
        hs1.put("v",f1);
        
        ArrayList list=new ArrayList();
        list.add(f1);
        list.add(f4);
        list.add(f3);
        list.add(f2);
        
        ArrayList list1=new ArrayList();
        list1.add(f4);
        list1.add(f10);
        list1.add(f8);
        
        Instrument i2= new Instrument(list1);
        Instrument i1=new Instrument(list);
        
        HashMap<String,Instrument> hs2= new HashMap();
        
        hs2.put("a", i1);
        hs2.put("b",i2);
        
        PorteFeuille p1 = new PorteFeuille(hs1,hs2);
        
        
        System.out.println("Entrez vos choix de gestion");
        System.out.println("Hors portefeuille");
        System.out.println("1 - Ajouter un nouveau Fond à un Instrument");
        System.out.println("2 - Test comparator compareTo()");
        System.out.println("3 - Test comparator equals()");
        System.out.println("Dans le portefeuille");
        System.out.println("4 - Gestion Fonds");
        System.out.println("5 - Gestion Instruments");
        System.out.println("6 - Affichage des instruments ");
        System.out.println("7 - Affichage du pourcentage d'un fond dans un portefeuille");
        System.out.println("8 - Test du tri d'un instrument par ordre croissant du montant de ses fonds");
        System.out.println("0 - Quitter");
        Integer choix=input.nextInt();

        switch(choix){
            case 1: 
                System.out.println("Veuillez saisir le montant du nouveau Fond à ajouter à l'instrument : ");
                amount= input.nextDouble();
                i1.addFonds(new Fonds(amount)); 
                System.out.println("Ajout réussi");
                break;
                
            case 2:
                switch(f1.compareTo(f2)){
                    case 0:
                        System.out.println("Le fond f1 et le fond f2 ont le meme montant");
                        break;
                    
                    case 1:
                        System.out.println("Le fond f1 a un montant supérieur à celui du fond f2");
                        break;
                    
                    case -1:
                        System.out.println("Le fond f1 à un montant inférieur à celui du fond f2");
                        break;
                }
                break;
                
            case 3:
                if(f1.equals(f2)){
                    System.out.println("Le fond f1 et le fond f2 ont le meme montant");
                }else{
                    System.out.println("Le fond f1 et le fond f2 n'ont pas le meme montant");
                }
                break;
                
            case 4:
                System.out.println("1 - Rechercher un Fond");
                System.out.println("2 - Ajouter un Fond");
                System.out.println("3 - Supprimer un Fond");
                choix=input.nextInt();
                switch(choix){
                    case 1:
                        System.out.println("Veuillez rentrer la cle du fond à rechercher: ");
                        cle=input.next();
                        try{
                            System.out.println("Le montant du Fond recherché = " + p1.rechercheFonds(cle));
                        }catch(FondsInexistants e){
                            
                        }
                        break;
                        
                    case 2:
                        System.out.println("Veuillez rentrer le montant et la cle du fond à ajouter :");
                        amount = input.nextDouble();
                        cle=input.next();
                        
                        try{
                            p1.addFonds(cle, amount);
                        }catch(FondsExistants e){
                            
                        }
                        break;
                        
                    case 3:
                        System.out.println("Veuillez rentrer la cle du fond à supprimer :");
                        cle=input.next();
                        
                        try{
                            p1.suppFonds(cle);
                        }catch(FondsInexistants e){
                            
                        }
                        break;
                }
                break;
            
                
            case 5:
                System.out.println("1 - Rechercher un instrument");
                System.out.println("2 - Ajouter un fond à un instrument");
                System.out.println("3 - Supprimer un instrument");
                choix= input.nextInt();
                switch(choix){
                    case 1:
                        System.out.println("Veuilez rentrer la cle de l'instrument recherché : ");
                        cle= input.next();
                        
                        try{
                            System.out.println(p1.rechercheInstrument(cle));
                        }catch(InstrumentInexistants e){
                            
                        }
                        break;
                      
                    case 2:
                        System.out.println("Veuillez rentrer la cle de l'instrument auquel vous voulez ajouter le fond f1 : ");
                        cle=input.next();
                        p1.addFondsInstruments(cle, f1);
                        break;
                        
                    case 3:
                        System.out.println("Veuillez rentrer la cle de l'instrument à supprimer : ");
                        cle=input.next();
                        
                        try{
                            p1.suppInstruments(cle);
                        }catch(InstrumentInexistants e){
                            
                        }
                        break;
                        
                        
                }
                break;
                
            case 6:
                a1.displayInstruments(p1);
                break;
                
            case 7:
               System.out.println("Veuillez rentrer la cle du fond dont vous voulez connaitre le pourcentage : ");
               cle=input.next();
               
               try{
                   System.out.println(a1.displayPercentage(cle, p1));
               }catch(FondsInexistants e){
                   
               }
               break;
                
            case 8:
                System.out.println("Le test se fait avec l'instrument i1");
                for(int i=0;i<i1.getValeurFonds().size();i++){
                    System.out.println(i1.getValeurFonds().get(i).getAmount());
                }
                
                System.out.println("On applique maintenant le tri");
                i1.sortInstrument();
                
                for(int i=0;i<i1.getValeurFonds().size();i++){
                    System.out.println(i1.getValeurFonds().get(i).getAmount());
                }
                break;
                
            case 0:
                
                break;
        }
        
        
        
        
        //PorteFeuille pf1= new 
    }
    
}
