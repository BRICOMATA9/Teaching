/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author evadr
 * @param <Fonds>
 */
public interface Com<Fonds> {
    
    Integer compareTo (Fonds f);
    
    @Override
    boolean equals (Object o);
    
}
