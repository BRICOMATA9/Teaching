import java.util.Scanner;
import java.lang.Exception;
public class Test1{
	private int[] tab=new int[23];
	private int n;
	private static Scanner scan=new Scanner(System.in);
	private void lire_tab(int n){
		this.n=n;
		for(int i=0;i<n;i++){
			System.out.print("tab["+i+"] = ");
			tab[i]=scan.nextInt();

		}
	}
	private void divise(int x){
	 	for(int i=0;i<n;i++){
	 		try{
				System.out.println(tab[i]+"/"+"("+tab[i]+"-"+x+") = "+tab[i]/(tab[i]-x));
			}
			catch(Exception e){
				System.out.println("devision par zero");
	 		 
			}
		}
	}
	public static void main (String[] args){
		Test1 obj=new Test1();
		System.out.print("Le nombre de chiffres : ");
		obj.lire_tab(scan.nextInt());
		System.out.print("La valeur de x : ");
		obj.divise(scan.nextInt());

	}
}
		
