package tp2;

import java.lang.reflect.Field;

public class Exo2 {
	private int entier = 12;

	public static void main (String [] args) throws IllegalAccessException{
		Exo2 o = new Exo2();	
		Class <?> c = o.getClass();
		Field [] fs = c.getDeclaredFields();
	  for (Field f:fs) {
			if (f.getType() == int.class) {
				f.setAccessible (true);
				f.set (o,42);
				System.out.println(o.entier);
			}
		}
	}
}
