
import java.util.Scanner;
public class Principale {
public Point p1,p2,p3,p4,centre;
public static Scanner lire=new Scanner(System.in);
	public Principale(){
		
		System.out.println("Donnez 4 points: ");
		 p1=new Point(lire.nextDouble(),lire.nextDouble());
		 p2=new Point(lire.nextDouble(),lire.nextDouble());
		 p3=new Point(lire.nextDouble(),lire.nextDouble());
		 p4=new Point(lire.nextDouble(),lire.nextDouble());
		 centre=new Point(0,0);
	}
	public static void main(String[] args) {
	    
		Forme[] TF= new Forme[100];
		
		Principale P=new Principale();
	 	Rectangle R=new Rectangle(P.p1, P.p2,P.p3,P.p4,4,2,P.centre);//Longueur=4, largeur 2
	    TF[0]=R;
	    
	    P=new Principale();
	 	Carre C=new Carre(P.p1,P.p2,P.p3,P.p4,2,P.centre);  //cote = 2
	    TF[1]=C;
	    
	    P=new Principale();
	 	Losange L=new Losange(P.p1,P.p2,P.p3,P.p4,2,P.centre); // cote = 2
	    TF[2]=L;
	 
	    Point centre=new Point(1,4); // point centre
	 	Cercle Ce=new Cercle(centre,6);// rayon = 6
	    TF[3]=Ce;
		   
	for(int i=0;i<4;i++)   	
	 {  TF[i].afficheForme(); 
	  System.out.println("Surface="+TF[i].surface()); 
	  System.out.println("Perimetre="+ TF[i].perimetre());
	 }
 }// fin  main
}// fin Principal	

