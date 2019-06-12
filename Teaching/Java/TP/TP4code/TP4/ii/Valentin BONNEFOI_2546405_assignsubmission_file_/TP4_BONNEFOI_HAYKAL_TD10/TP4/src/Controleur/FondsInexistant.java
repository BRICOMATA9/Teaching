/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author valentin
 */
 public class FondsInexistant extends Exception{ 
  public FondsInexistant(){
    System.out.println("la clé en paramètre n'existe pas !");
  }  
}
