/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;
import Modele.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean Leroy
 */
public class TP4 {

    /**
     * @param args the command line arguments
     * @throws Modele.ExceptionFondInexistant
     */
    public static void main(String[] args) throws ExceptionFondInexistant, ExceptionFondExistant {
    
        Portefeuille pf = new Portefeuille();
        Instruments ins = new Instruments();
        System.out.println("Saisir le fond a ajouter : ");

        Scanner sc = new Scanner(System.in);
        String cle = sc.nextLine();
        System.out.println("Saisir le montant du fond a ajouter : ");
        sc = new Scanner(System.in);
        int ammount = sc.nextInt();


          pf.add_fond("tarte", 100);

      try
      {
           pf.search_fond(cle);
           pf.add_fond(cle, 10);
           
      }catch (ExceptionFondInexistant e){
          pf.add_fond(cle, ammount);
      }
      catch (ExceptionFondExistant e)
      {
          
      }
              
        System.out.println("Saisir l'instrument a ajouter : ");
        sc = new Scanner(System.in);
        cle = sc.nextLine();
        try
        {
          pf.search_instr(cle);
          
        }catch (ExceptionInstrumentInexistant e){
            pf.add_instr(cle);
        }
        try {
            pf.add_fond_to_instr(cle, new Fonds(500));
        } catch (ExceptionInstrumentInexistant ex) {
                ex.printStackTrace();
        }
            
        pf.display();
      
      System.out.println("Complilation done");   
        
    }
    
}
