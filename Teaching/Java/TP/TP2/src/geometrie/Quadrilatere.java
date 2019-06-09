package geometrie;


public class Quadrilatere extends Forme{
	protected Point a,b,c,d;
	public Quadrilatere(Point a,Point b,Point c,Point d,Point centre){
		super(centre);
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	public static Point milieu(Point p1,Point p2){
		return new Point((p1.getx()+p2.getx())/2,(p1.gety()+p2.gety())/2);
	}
	public static double distance(Point p1,Point p2){
	return Math.sqrt(Math.pow(p2.getx()-p1.getx(),2)+Math.pow(p2.gety()-p1.gety(), 2));
	}
	public boolean parallelogramme(double epsilon){
		return (distance(milieu(a,d),milieu(b,c))<epsilon);
	}
	public void afficheForme(){
		super.afficheForme();System.out.print("Quadrilatere - "); 
	           
	}
}
