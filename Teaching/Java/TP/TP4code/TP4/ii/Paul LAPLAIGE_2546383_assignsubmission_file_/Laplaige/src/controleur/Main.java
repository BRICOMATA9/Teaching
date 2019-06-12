/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import java.io.*;
import java.util.*;
import modele.*;
import vue.*;

/**
 * Main
 * @author Paul
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String nvClef;
        /*int nvMontant;*/
        Portefeuille portefeuille = new Portefeuille();
        System.out.println("Saisir une clé :");
        nvClef = sc.nextLine();
        /*System.out.println("Saisir un fond :");
        nvMontant = sc.nextInt();*/
        /*try
        {
            portefeuille.rechercherFonds(nvClef);
        }
        catch (FondsInexistant e1)
        {
            try
            {
                portefeuille.ajouterHashFonds(nvClef, nvMontant);
                System.out.println(portefeuille.getFonds().get(nvClef).getAmount());
            }
            catch (FondsExistant e2){}
        }
        try
        {
            portefeuille.rechercherInstrument(nvClef);
        }
        catch (InstrumentInexistant e3)
        {
            //Instrument instrument = new Instrument();
            //portefeuille.ajouterHashInstrument(nvClef, instrument);
        }
        */
    }
}

/***********************************************************
* parties de codes inspirées ou provenant de OpenClassroom.com
* http://www.codeurjava.com/2015/10/trier-un-arraylist-dobjets-avec-comparable-et-comparator.html
***********************************************************/