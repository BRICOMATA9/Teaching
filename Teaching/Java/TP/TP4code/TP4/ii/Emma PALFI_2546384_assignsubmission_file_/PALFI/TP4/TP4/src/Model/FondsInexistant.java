/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *Classe FondsInexistant qui hérite de Exception
 * @author Emma
 */
public class FondsInexistant extends Exception{
    
    /** Constructeur qui affiche un message 
    * si l'exception est catchée. 
    */
    public FondsInexistant()
    {
        System.out.println("Exception fonds inexistant");
    }  
}
