/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 12 : Java et Internet
#	Section  : Une application côté serveur : la servlet
#	Fichier  : Cercle.java
#	Class    : Cercle
*/
public class Cercle {
	private int x, y, r ; 
	public final static int TailleEcran = 600 ;
	public Cercle(int centrex, int centrey)		{
		x = centrex ;
		y = centrey;
        }
	public Cercle(int centrex, int centrey, int rayon)		{
		this( centrex, centrey) ;
		r = rayonVérifié(rayon);
	}
	public void agrandir(int nr) {
	 r = rayonVérifié(r + nr);		
	}
	private int rayonVérifié (int tmp) {
 		if (tmp < 0) return 0;
   	else if ( tmp > TailleEcran) return TailleEcran ; 
   	else return tmp;
	}
	public void échangerAvec( Cercle autre) {	 
		int tmp; 
		tmp = x;
		x = autre.x;
		autre.x = tmp;
		tmp = y;
		y = autre.y;
		autre.y = tmp;
	}
	public double périmètre() {
		return 2*Math.PI*r;
	}
	public void déplacer(int nx, int ny) {										
		x = nx;									
		y = ny;
	}
} // Fin de la classe Cercle