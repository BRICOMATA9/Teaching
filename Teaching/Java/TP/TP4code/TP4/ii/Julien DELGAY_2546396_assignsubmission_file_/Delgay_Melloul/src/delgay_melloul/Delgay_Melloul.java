/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delgay_melloul;
import java.util.Scanner;

/**
 *
 * @author julien
 */
public class Delgay_Melloul {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        Portefeuille p1 = new Portefeuille();
        Instrument i = new Instrument();
        
        
        //tri
        i.getMontants().add(new Fonds(54));
        i.getMontants().add(new Fonds(14));
        i.getMontants().add(new Fonds(6));
        i.getMontants().add(new Fonds(32));
        try{
            p1.ajouterFondHashMap("cinquante-quatre", 54);
            p1.ajouterFondHashMap("quatorze", 14);
            p1.ajouterFondHashMap("six", 6);
            p1.ajouterFondHashMap("trente-deux", 32);
        } catch(FondsExistant e){
            
        }
        i.trierMontants();
        
        p1.getInstruments().put("instru0",i);
        
        //ajouter un nouveau fond dans la HashMap
        System.out.println("Saisir la cle du fond a creer: ");
        String  cle = sc.next();
        
        System.out.println("Saisir le montant du fond: ");
        double montant = sc.nextDouble();
        
        try{
            p1.chercherFond(cle);
        } catch(FondsInexistant e){
            try{
                p1.ajouterFondHashMap(cle, montant);
                //i.getMontants().add(new Fonds(montant));
            } catch(FondsExistant e2){
                
            }
        }
        
        //creer un instrument dans la HashMap 
        System.out.println("Saisir la cle de l'instrument a ajouter: ");
        String  cle2 = sc.next();
        
        try{
            p1.chercherInstrument(cle2);
        } catch(InstrumentInexistant e3){
            Instrument i2 = new Instrument();
            p1.getInstruments().put(cle2,i2);
        }
        
        //ajouter un fond dans la HashMap instrument
        System.out.println("Saisir la cle du fond a ajouter: ");
        String  cle6 = sc.next();
        
        p1.ajouterFondInstrument(cle2, p1.getFonds().get(cle6));
        
        //affichage
        p1.afficherInstruments();
        System.out.println("Saisir la cle du fond pour afficher son pourcentage: ");
        String cle5 = sc.next();
        p1.afficherPourcentage(cle5);
        
        //supprimer un fond dans la HashMap
        System.out.println("Saisir la cle du fond a supprimer: ");
        String  cle3 = sc.next();
        
        p1.supprimerFond(cle3);
        
        //supprimer un instrument dans la HashMap
        System.out.println("Saisir la cle de l'instrument a supprimer: ");
        String  cle4 = sc.next();
        
        p1.supprimerInstrument(cle4);
        
        //affichage
        p1.afficherInstruments();
    }
    
}
