/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe FondsExistant héritant d'exception
 * Affiche un message si appelé
 * @author margo
 */
public class FondsExistant extends Exception{
    public FondsExistant(){
        System.out.println("Fonds existant");
    }
}
