
public class Losange extends Carre {
	public Losange(Point a, Point b, Point c, Point d, double cote, Point centre){
		super(a,b,c,d,cote,centre);
	}
	public double surface(){
		
	return ((super.distance(a,c)*super.distance(b,d))/2);
	}
	/*public double perimetre(){ //EXISTE DANS CARRE
		return cote*4;
	}*/
	public void afficheForme(){
		super.afficheForme();System.out.println("Losange") ; 
	}
}
