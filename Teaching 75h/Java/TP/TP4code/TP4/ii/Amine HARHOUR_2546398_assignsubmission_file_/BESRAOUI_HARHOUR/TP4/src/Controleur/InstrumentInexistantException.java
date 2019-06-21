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
public class InstrumentInexistantException extends Exception{
     public String getMsg(){
        String wrong = "L'instrument n'existe pas";
        return wrong;
    }
}
