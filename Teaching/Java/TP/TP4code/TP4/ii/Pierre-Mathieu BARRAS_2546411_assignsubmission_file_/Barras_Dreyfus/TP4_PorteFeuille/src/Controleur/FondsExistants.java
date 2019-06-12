/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author evadr
 */
public class FondsExistants extends Exception {
    public FondsExistants(){
        System.out.println("Le Fonds que vous essayer de creer existe deja.");
    }
}
