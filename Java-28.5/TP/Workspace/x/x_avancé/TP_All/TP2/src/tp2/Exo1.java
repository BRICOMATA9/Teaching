package tp2;

import java.lang.reflect.Field;

public class Exo1 {
	public int entier = 12;

	public static void main (String [] args) throws IllegalAccessException{
		Exo1 o = new Exo1();
		Class <?> c = o.getClass();
		Field [] fs = c.getFields();
	  for (Field f:fs) {
				System.out.println(f.getName());
		}
	}

}
