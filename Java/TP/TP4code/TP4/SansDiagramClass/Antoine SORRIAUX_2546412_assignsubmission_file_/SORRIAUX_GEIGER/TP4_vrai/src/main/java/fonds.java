

/*
 * FONDS
 */

/**
 *
 * @author antoinesorriaux et thomasgeiger
 */
public class fonds implements Comparable<fonds> {
    
    
    /**
    * Initialisation variable amount dans "fonds"
    */
    
    public int amount; 
    /**
    * constructeur par défaut et surchargé de la classe "Vue"
    */
    
    fonds(){
   
    }
    
    fonds(int montant){
        
        this.amount = montant;
    }
    
    /**
    * METHODES
    */
    
    /**
    * CompareTo de la classe COMPARABLE
    */
    
    @Override
    public int compareTo(fonds F1){
        if(this.amount == F1.amount)
        {
            return 0; 
        }
        else if(this.amount < F1.amount){
            return -1;
        }
        else{
            return 1; 
        }
    }
    
    /**
    * equals de la classe COMPARABLE
    */
    

    @Override
    public boolean equals(Object o) {
        if(o instanceof fonds  )
            {
                if(this.amount == ((fonds) o).amount){
                    return true;
                }
                else{return false;}
                    
            }
        
        else 
        {return false;} 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.amount;
        return hash;
    }

   

   
    
    
}
