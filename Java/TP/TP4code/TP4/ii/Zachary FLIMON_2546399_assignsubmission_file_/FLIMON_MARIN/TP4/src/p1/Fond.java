package p1;
import java.util.*;
public class Fond implements Comparable<Fond> {
	private double montant;

          
        @Override
    public int compareTo(Fond o) {
        
        if( this.getMontant() == o.getMontant() )
            return 0;
        else{
            if ( this.getMontant() < o.getMontant() )
                // si on a le montant de ce qu'on compare inférieur à celui qu'on compare on dit que c'est inférieur donc -1
                return -1;
            else
                return 1;
            // si plus grand
        } 
            
    } 
    
    public boolean equals (Fond a){
            return a.getMontant()==this.getMontant();
    }
        
        
    public Fond(double a) {		
		montant = a;
    }

    public Fond() {		
		montant = 0;
    }
	

    public void affiche(){
    System.out.println(getMontant());
    }


    public double getMontant() {
	return montant;
    }

    public void setMontant(double montant) {
	this.montant = montant;
    }



}
