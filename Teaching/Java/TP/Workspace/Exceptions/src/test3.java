import java.util.Scanner;
import java.util.InputMismatchException;

public class test3 {

	public static Scanner sc;
		
	public static void main(String[] args) {
		boolean b=false;
		while(!b){
			try{
				sc=new Scanner(System.in);
				System.out.println(sc.nextInt());
				b=true;
			}
			catch(Exception e){System.out.println(e);}
		}
		System.out.println("hmd");
	}
}
