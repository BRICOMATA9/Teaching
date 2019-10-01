import java.io.*;
class UpecException extends RuntimeException{}

class AppExc {
        static int[] tab = new int [3];
	public static void main (String [] args) {
		try {                
		  j();
                }
		catch (UpecException e) {
		StackTraceElement[] t =e.getStackTrace();
		for (StackTraceElement ste:t)
			System.out.println(ste);
		}
		System.out.println("fin du main");
		h();
	}

	public static void f () {
		throw new UpecException();
	}

	public static void j () {
		f();
	}


	public static void g () {
		try {
  			for (int i=0; i<5; i++)
				tab[i]=2;
			System.out.println("Reussi!");
                }
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);	
		}
        }


        public static void h() {
	        try {
		   for (int i=0; i<2; i++)
			tab[i]=4;
		    String s = null;
		    s.contains("toto");
		}
		catch (NullPointerException e) {
			System.out.println("segmentation fault");
		}
                catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("all your base are belong to us");
		}
	}
}
