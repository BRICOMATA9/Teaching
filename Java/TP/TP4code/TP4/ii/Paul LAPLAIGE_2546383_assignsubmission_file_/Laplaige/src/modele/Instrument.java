/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.io.*;
import java.util.*;

/**
 * Classe Instrument
 * @author Paul
 */
public class Instrument 
{
    private ArrayList<Fonds>listeFonds;
    
    public void Instrument()
    {
        listeFonds = new ArrayList<>();
    }
    
    /**
    * Constructeur
    * @author Paul
    */
    public Instrument(ArrayList<Fonds> pListeFonds)
    {
        this.listeFonds = pListeFonds;
    }
    
    /**
    * Getter
    * @author Paul
    */
    public ArrayList<Fonds> getListeFonds()
    {
        return listeFonds;
    }
    
    //1.2
    public void ajouterFonds(Fonds pFond)
    {
        listeFonds.add(pFond);
    }
    
    //1.9
    public void trierFonds()
    {
        Collections.sort(listeFonds);
    }
}