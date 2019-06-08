
public class Carre extends Quadrilatere implements Perimsurf{
	protected double cote;
	public Carre(Point a,Point b,Point c,Point d, double cote,Point centre){
		super(a,b,c,d,centre);
		this.cote=cote;
	}
	public void setcote(double cote){
		this.cote=cote;
	}
	public double getCote(){
		return cote;
	}
	public double surface(){
	return cote*cote;
	}
	public double perimetre(){
		return cote*4;
	}
	public void afficheForme(){
		super.afficheForme();
		System.out.print("Carre - ") ; 
	}
}
