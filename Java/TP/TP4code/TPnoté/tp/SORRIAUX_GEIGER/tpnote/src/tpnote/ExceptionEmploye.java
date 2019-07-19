/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote;

/**
 *
 * @author geige
 */
public class ExceptionEmploye extends Exception {
	
	
	String message ="";
	
	// constructeur de MonException
    public ExceptionEmploye(String message) {
        // appel au constructeur de Exception
        super (message);
    }
    
   

}