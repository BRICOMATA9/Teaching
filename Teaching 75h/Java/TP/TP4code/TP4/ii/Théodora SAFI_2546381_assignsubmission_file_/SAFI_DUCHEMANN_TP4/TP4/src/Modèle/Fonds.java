package Modèle;
//classe fond qui implémente l'interface comparable<Fonds>
public class Fonds implements Comparable<Fonds> {
	
	Double amount;
	public String key;
	// le montant du fonds amount de type double + key
	
	//Constructeur par défaut
	public Fonds() {		
		this.amount=null;		
	}
	//Constructeur avec paramètre
	public Fonds(Double montant) {
		this.amount=montant;
	}
	
	//getter amount 
	public Double getFond() {
		return this.amount;
	}
		
	//getter key
	public String getKey() {
		return this.key;
	}
	
	
	public boolean equalsTo(Double montant) {
		if(amount==montant) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public int compareTo(Double montant) {
		 if (amount < montant) {
			 return -1 ;
		 }
		 if (amount > montant) {
			 return 1 ;
		 }
		 else {
			 equalsTo(montant);
			 return 0 ;
		 }

	}
	
	@Override
	public int compareTo(Fonds o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
