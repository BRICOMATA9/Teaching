import java.util.Scanner;


public class MainTestException {
public static Scanner sc;
	public static void main(String[] args) {
		ClassTestException T=new ClassTestException();
		
		System.out.println("donnez une 1ere valeur entiere");
		boolean b=false;
		while(!b){
			try {
			 	sc=new Scanner(System.in);
				T.test1(sc.nextInt());
				 b=true;
			 }
			catch(Exception e) {
				System.out.println(e); 
			 }
		}
		System.out.println("Fin test1");

		System.out.println("donnez une 2eme valeur entiere");
		T.test2(sc.nextInt());
		System.out.println("Fin test2");
	}

}
