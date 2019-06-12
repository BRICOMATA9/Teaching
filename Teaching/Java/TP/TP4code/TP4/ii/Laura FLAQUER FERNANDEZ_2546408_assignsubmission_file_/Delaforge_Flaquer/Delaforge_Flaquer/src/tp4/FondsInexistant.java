/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4;

/**
 *
 * @author laura 
 * @author ludivine
 */
public class FondsInexistant extends Exception {
    /**
     * Renvoie un message d'erreur
     * @param s 
     */
    public FondsInexistant(String s)
    {
        System.out.println("La clé "+s+" n'existe pas dans la collection de Fonds");
    }
}
