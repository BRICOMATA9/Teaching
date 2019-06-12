package Modele;
/**
 * Cette exception est levée si l'instrument n'existe pas.
 * @author Kiary
 */
public class InstrumentInexistant extends Exception{
     
    public InstrumentInexistant(String s){
        super(s);
    }
}
