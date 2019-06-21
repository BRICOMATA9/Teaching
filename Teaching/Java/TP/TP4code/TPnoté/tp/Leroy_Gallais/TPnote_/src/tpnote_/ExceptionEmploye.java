/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpnote_;

/**
 *
 * @author Jean Leroy
 */
class ExceptionEmploye extends Exception {
        public ExceptionEmploye() {
        
        System.out.println("l'employe satisfait ces contraintes");
     }

    ExceptionEmploye(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
