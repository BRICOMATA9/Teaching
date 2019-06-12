/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dreyfus_barras;

/**
 *
 * @author pierre-mathieu.barras
 */

//Début du travail sur les exceptions (manque de temps)
public class ExceptionEmploye extends Exception {
    
    public void verifierPrime() throws ExceptionEmploye{
        System.out.println("Eligible à la prime");
    }
}
