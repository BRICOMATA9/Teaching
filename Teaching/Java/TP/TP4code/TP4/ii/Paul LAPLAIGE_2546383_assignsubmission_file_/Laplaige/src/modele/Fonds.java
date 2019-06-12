/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.io.*;
import java.util.*;

/**
 * Classe Fonds
 * @author Paul
 */
public class Fonds extends ComparableFonds
{
    private double amount;
    
    public Fonds()
    {
        amount = 0;
    }

    /**
    * Constructeur
    * @author Paul
    */
    public Fonds(double pMontant)
    {
        this.amount = pMontant;
    }
    
    /**
    * Getter
    * @author Paul
    */
    public double getAmount()
    {
        return amount;
    }
}