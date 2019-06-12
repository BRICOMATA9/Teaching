package p1;

public class FondNexistant extends Exception {

	public FondNexistant(){ System.out.println(" Ce fond n'existe pas");}
	public FondNexistant(String s){ super(s); }
	
}
