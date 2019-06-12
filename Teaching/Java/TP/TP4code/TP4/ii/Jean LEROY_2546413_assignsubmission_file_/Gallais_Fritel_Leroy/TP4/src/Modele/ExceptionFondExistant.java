/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *Classe exception pour les fonds existant
 * @author Jean Leroy
 */
public class ExceptionFondExistant extends Exception{


    public ExceptionFondExistant()
    {
        System.out.println("Fonds existant");
    }
}
