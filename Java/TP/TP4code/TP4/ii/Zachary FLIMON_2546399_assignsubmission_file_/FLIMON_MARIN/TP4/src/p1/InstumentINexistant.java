package p1;

public class InstumentINexistant extends Exception {

	public InstumentINexistant(){ System.out.println(" Cet instrument n'existe pas");}
	public InstumentINexistant(String s){ super(s); }
}
