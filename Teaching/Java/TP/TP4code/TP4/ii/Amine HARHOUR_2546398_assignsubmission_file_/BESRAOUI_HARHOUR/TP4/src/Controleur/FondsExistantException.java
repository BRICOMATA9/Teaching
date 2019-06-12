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
public class FondsExistantException extends Exception {
     public String getMsg(){
        String wrong = "Le fonds existe déjà";
        return wrong;
    }
    
}
