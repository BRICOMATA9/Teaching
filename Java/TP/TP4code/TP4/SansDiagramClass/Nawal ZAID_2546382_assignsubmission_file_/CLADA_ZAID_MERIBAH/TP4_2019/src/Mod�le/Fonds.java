package Modèle;

/**
 *
 * @author Idris MRIBAH,Michel CLADA,Nawal ZAID
 */
public class Fonds implements Comparable<Fonds>
{
    private double amount;
//Constructeur par défaut    
    public Fonds()
    {
        amount = 0.d;
    }
//constructeur surchargé
    public Fonds(double montant) 
    {
        this.amount = montant;
    }
//getters
    public double getAmount() 
    {
        return amount;
    }
//setters
    public void setAmount(double montant) 
    {
        this.amount = montant;
    }
    
    public boolean equals(Fonds f)
    {
        return f.getAmount() == this.getAmount();
    }
    
    @Override
    public int compareTo(Fonds f) 
    {
        int compare = -1;

        if (this.getAmount() > f.getAmount()) 
        {
            compare = 1;
        } 
        
        else if (this.equals(f)) 
        {
            compare = 0;
        }

        return compare;
    }
}
