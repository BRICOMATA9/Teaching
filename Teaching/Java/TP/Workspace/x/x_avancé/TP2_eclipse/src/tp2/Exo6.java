package tp2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exo6 {
	public int entier = 12;

	private void methode1(){
		
	}
	public static void main (String [] args) throws IllegalAccessException{
		Exo6 o = new Exo6();
		Class <?> c = o.getClass();
		Method [] m = c.getDeclaredMethods();
	  for (Method me:m) {
				System.out.println(me.getName());
		}
	}

}
