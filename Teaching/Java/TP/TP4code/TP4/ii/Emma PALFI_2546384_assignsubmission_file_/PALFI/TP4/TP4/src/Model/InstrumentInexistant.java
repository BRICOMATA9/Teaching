/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe InstrumentInexistant qui hérite de Exception
 * @author Emma
 */
public class InstrumentInexistant extends Exception {
    
    /** Constrcuteur qui affiche un message si l'exception est catchée */
    public InstrumentInexistant()
    {
        System.out.println("Exception instrument inexistant");
    }
    
}
