/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * Classe InstrumentInexistant
 * @author Paul
 */
public class InstrumentInexistant extends Exception
{
   public InstrumentInexistant()
    {
        System.out.println("Cet instrument n'existe pas");
    } 
}
