package Modele;
/**
 * Cette exception est levée seulement lorsque le fonds recherché n'existe pas.
 * @author Kiary
 */
public class FondsInexistant extends Exception{
    
    public FondsInexistant(){};
    public FondsInexistant(String s){
        super(s);
    }
    
}
