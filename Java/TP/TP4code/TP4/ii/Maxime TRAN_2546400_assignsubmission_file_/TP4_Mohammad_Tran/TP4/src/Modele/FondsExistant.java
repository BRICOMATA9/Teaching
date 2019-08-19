package Modele;

/**
 * Une exception qui sera levé si le fonds recherché existe déjà.
 * @author Kiary
 */
public class FondsExistant extends Exception{
    
    public FondsExistant(String s){
        super(s);
    }
}
