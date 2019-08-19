package Test;

import Modele.*;
import Controleur.*;
import Vue.*;

/**
 * On utilise seulement la vue qu'on a créé dans notre main, le programme s'arrête lorsque
 * dans le menu l'utilisateur choisit de quitter le programme.
 * @author Kiary
 */
public class Main {
    
    public static void main(String[] args){
        Portefeuille pf=new Portefeuille();
        Controleur c=new Controleur(pf);
        Vue v=new Vue(c);
        // Tant que l'utilisateur n'a pas choisi de quitter le programme, on continue de faire tourner notre programme
        boolean exitProgram=false;
        do{
            exitProgram=v.displayMenu();
        } while (exitProgram==false);
        System.exit(0);
    }
}
