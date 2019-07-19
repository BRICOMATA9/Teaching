import java.util.Scanner;
public class test2{
	public static Scanner scan=new Scanner(System.in);
	
	public static int f() throws Exception {
			int n=scan.nextInt();
			if(n<0)throw new Exception();
			return n;
	}
	
	public static void main(String[] args)throws Exception{	
		int i=-2;
		while(i<0){
			try{
				System.out.println(f());
				i=4;
			}
			catch(Exception e){
				System.out.println("errrreur"+e);
			}
		}	
		System.out.println("hmd");
	
	}
}

