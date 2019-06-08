import java.util.Scanner;
import java.util.InputMismatchException;

public class test5 {

	public static Scanner sc;
	
	public static void f(){
		boolean b=false;
		while(!b){
			try{
				sc=new Scanner(System.in);
				int n=sc.nextInt();
				System.out.println(n);
				b=true;
			}
			catch(Exception e){System.out.println(e);}
		}
	}
		
	public static void main(String[] args) {
		f();
	}
}
