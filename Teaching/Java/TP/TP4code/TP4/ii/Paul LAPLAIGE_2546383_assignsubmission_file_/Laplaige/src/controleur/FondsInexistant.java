/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * Classe FondInexistant
 * @author Paul
 */
public class FondsInexistant extends Exception
{
    public FondsInexistant()
    {
        System.out.println("Ce fond n'existe pas");
    }
}
