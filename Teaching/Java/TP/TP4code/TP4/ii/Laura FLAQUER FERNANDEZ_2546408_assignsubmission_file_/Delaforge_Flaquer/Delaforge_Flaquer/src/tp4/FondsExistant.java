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
public class FondsExistant extends Exception {
    /**
     * Renvoie un message d'erreur
     * @param s 
     */
    public FondsExistant(String s)
    {
        System.out.println("La clé "+s+" existe déjà dans la collection de Fonds");
    }
}
