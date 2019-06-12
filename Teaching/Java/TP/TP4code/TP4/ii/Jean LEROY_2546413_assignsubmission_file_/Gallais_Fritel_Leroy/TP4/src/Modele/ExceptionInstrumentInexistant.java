/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *Classe exception pour les instruments inexistant
 * @author Jean Leroy
 */
public class ExceptionInstrumentInexistant extends Exception {
    public ExceptionInstrumentInexistant()
    {
          System.out.println("Instrument inexistant");  
    }

    
}
