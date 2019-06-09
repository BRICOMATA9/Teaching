
public class Losange extends Carre {
	public Losange(Point a, Point b, Point c, Point d, double cote, Point centre){
		super(a,b,c,d,cote,centre);
	}
	public double surface(){  
		
	return ((Quadrilatere.distance(a,c)*super.distance(b,d))/2);
	}
	
	public void afficheForme(){
		super.afficheForme();System.out.print("Losange - ") ; 
	}
}
