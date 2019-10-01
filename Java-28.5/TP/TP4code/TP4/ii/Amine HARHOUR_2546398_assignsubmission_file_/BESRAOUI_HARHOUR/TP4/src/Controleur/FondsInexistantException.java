/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Nihal
 */
public class FondsInexistantException extends Exception {
    public String getMsg(){
        String wrong = "Le fonds n'existe pas";
        return wrong;
    }
}
