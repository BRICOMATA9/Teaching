import java.util.Scanner;
import java.util.InputMismatchException;

public class test4 {

	public static Scanner sc;
	
	public static void f() throws Exception{
		sc=new Scanner(System.in);
		//System.out.println(sc.nextInt());
		if(sc.nextInt()==4)throw new Exception("errrrrrrrrrreur");
	}
		
	public static void main(String[] args) {
		boolean b=false;
		while(!b){
			try{
				f();
				b=true;
			}
			catch(Exception e){System.out.println(e);}
		}
		System.out.println("hmd");
	}
}
