package Modèle;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author  Idris MERIBAH, Michel CLADA,Nawal ZAID
 */
public class Instrument 
{
    private ArrayList<Fonds> ValeursFonds;
   //constructeur par defaut 
    public Instrument()
    {
        ValeursFonds = new ArrayList<>();
    }
    //constructeur surchargé
    public Instrument(ArrayList<Fonds> liste) 
    {
        this.ValeursFonds = liste;
    }
//getters
    public ArrayList<Fonds> getValeursFonds() 
    {
        return ValeursFonds;
    }
//setters
    public void setValeursFonds(ArrayList<Fonds> liste) 
    {
        this.ValeursFonds = liste;
    }

    public void ajouter(Fonds f)
    {
        ValeursFonds.add(f);
    }
    
    public void sortByAmount()
    {
        Collections.sort(getValeursFonds());
    }
    
    public double totalAmount() 
    {
        double sum = 0.d;

        for (Fonds f : getValeursFonds()) 
        {
            sum += f.getAmount();
        }

        return sum;
    }


}
