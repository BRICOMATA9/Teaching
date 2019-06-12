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
public class FondsInexistants extends Exception {
    public FondsInexistants(){
        System.out.println("Ce Fond n'existe pas.");
    }
}
