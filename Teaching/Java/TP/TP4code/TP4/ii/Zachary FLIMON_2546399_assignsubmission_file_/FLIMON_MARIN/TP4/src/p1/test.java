package p1;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {

    public static void ex_tri_instru(){
        
        Instrument i1 = new Instrument();
        i1.ajout(new Fond(100));
        i1.ajout(new Fond(30));
        i1.ajout(new Fond(600));
        i1.ajout(new Fond(600));
        i1.ajout(new Fond(80));
        
        ///Afichage du tri d'un instrument
        System.out.println( " ");
        
        System.out.println( "TRI D'UN INSTRUMENT ");
        System.out.println( "       NON TRIE ");
        
        
        for( int i =0 ; i< i1.collec.size() ; i++){
            System.out.println(i1.collec.get(i).getMontant()+ " ");
        }

        i1.tri();
        System.out.println( " ");
        System.out.println( "       TRIE");

        for( int i =0 ; i< i1.collec.size() ; i++){
            System.out.println(i1.collec.get(i).getMontant()+ " ");
        }   
    }

    public static void ex1_5(boolean test, String nom){
        
        Fond f1 = new Fond(10);
        Fond f2 = new Fond(20);
        Fond f3 = new Fond(30);
        Fond f4 = new Fond(500);
        
        
        
        Portefeuille p1 = new Portefeuille();
        
        // on ajoute les fonds
        
        System.out.println( " ");
        
        System.out.println( "EXAMPLE D'AJOUT  DE FOND AU PORTEFEUILLE");
        System.out.println( "   on ajoute les fond 'un' 'deux' 'trois'  'quatre' de valeur "+ f1.getMontant() +
                " "+f2.getMontant()+ " " +f3.getMontant()+ " "+f4.getMontant());
        
        // on tente d'ajouter, 
        try {
            p1.ajout_f("un", f1);
            p1.ajout_f("deux", f2);
            p1.ajout_f("trois", f3);
            p1.ajout_f("quatre", f4);
        } catch (FondExistant ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println( "   Si vous voulez tester que l'ajout d'un fond déjà existant proqvoque une erreur, mettre en paramètre true ");
        
        if(test){
            try {
                
                p1.ajout_f(nom, f4);
                System.out.println( "Le fond " + nom+ " de valeur "+ f4.getMontant() +" a bien été ajouté");
            } catch (FondExistant ex) {
                System.out.println("    "+ex.getMessage()+ " existe déjà dans le portefeuille, opn ne peut donc pas l'ajouter");
            }            
        }
        
        System.out.println( "   On va chercher le fond avec comme clef: "+nom);
        try {
            double x = p1.chercher_f(nom);
            System.out.println( "   On a trouvé le fond "+ nom+ " de montant : " + x);
        } catch (FondNexistant ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
    }
    
    public static void ex_1_7(String nom){
        
        Fond f1 = new Fond(10);
        Fond f2 = new Fond(20);
        Fond f3 = new Fond(30);
        Fond f4 = new Fond(500);
        
        
        
        Portefeuille p1 = new Portefeuille();
        
        // on ajoute les fonds
        
        System.out.println( " ");
        
        System.out.println( "EXAMPLE DE SUPRESSION DE FOND DU PORTEFEUILLE");
        System.out.println( "   on ajoute les fond 'un' 'deux' 'trois'  'quatre' de valeur "+ f1.getMontant() +
                " "+f2.getMontant()+ " " +f3.getMontant()+ " "+f4.getMontant());
        
        // on tente d'ajouter, 
        try {
            p1.ajout_f("un", f1);
            p1.ajout_f("deux", f2);
            p1.ajout_f("trois", f3);
            p1.ajout_f("quatre", f4);
        } catch (FondExistant ex) {
            System.out.println(ex.getMessage());
        }
       
        
        System.out.println( "   On va chercher le fond avec comme clef: "+nom+" puis le supprimer");
        p1.supp_f(nom);
        
        p1.afficher_hash_fond();
    }
    
    public static void ex_1_6(String nom){
        
        System.out.println( " ");
        
        System.out.println( "EXAMPLE D'AJOUT  DE FOND A L'INSTRUMENT "+ nom);
        
        Portefeuille p1 = new Portefeuille();
        
        p1.ajout_i(nom, new Fond(50));
        p1.afficher_instr(nom);
        
    }
    
    public static void ex_10_instru(){
        
        Instrument i1 = new Instrument();
        i1.ajout(new Fond(100));
        i1.ajout(new Fond(30));
        i1.ajout(new Fond(600));
        i1.ajout(new Fond(600));
        i1.ajout(new Fond(80));
        
        ///Afichage du tri d'un instrument
        System.out.println( " ");
        
        System.out.println( " Info fond ");
        
        i1.affiche();
        
    }
    public static void main(String[] args) throws FondNexistant, InstumentINexistant, FondExistant 
    {	
        
        //ex1_5(true, "quatre");
        //ex_1_6("un");
        //ex_1_7("un");
        //ex_tri_instru();
        ex_10_instru();
    }
}
