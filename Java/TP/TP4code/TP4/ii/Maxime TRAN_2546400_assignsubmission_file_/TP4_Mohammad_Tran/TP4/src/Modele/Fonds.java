package Modele;
/**
 * La classe Fonds comporte un seul attribut : le montant.<br>
 * On lui implémente l'interface Comparable afin de pouvoir effectuer un tri plus tard parmi tous les fonds que nous possédons.
 * @author Kiary
 */

public class Fonds implements Comparable<Fonds>{
    
    private double amount;
    
    /**
     * Constructeur par défaut (inutilisé)
     */
    public Fonds(){
        amount=0;
    }
    
    /**
    * Constructeur surchargée de la classe Fonds.
    * @param newAmount Le montant du nouveau Fonds.
    */
    public Fonds(double newAmount){
        amount=newAmount;
    }
    
    /**
     * Getter du montant.
     * @return le montant du fonds.
     */
    public double getAmount(){
        return amount;
    }
    
    /**
     * Méthode permettant de vérifier si deux fonds sont égaux.
     * @param f le fonds qu'on souhaite comparer avec notre fonds actuel.
     * @return vrai si le montant du fonds est égal à celui qu'on compare sinon faux.
     */
    public boolean equals(Fonds f){
        if(this.amount==f.getAmount()){
            return true;
        }
        else{
        return false;
        }
    }
    
    /**
     * Méthode permettant de comparer deux fonds, on vérifie si le fonds actuel est supérieur, égal ou inférieur au fonds comparé.
     * @param f le fonds qu'on souhaite comparer avec notre fonds actuel.
     * @return 1 si le fonds actuel est supérieur au fonds comparé, 0 s'ils sont égaux, -1 si le fonds actuel est inférieur au fonds comparé.
     */
    @Override
    public int compareTo(Fonds f){
        if(this.amount>f.getAmount()){
            return 1;
        }
        if(this.equals(f)==true){
            return 0;
        }
        else{
            return -1;
        }
    }
}
