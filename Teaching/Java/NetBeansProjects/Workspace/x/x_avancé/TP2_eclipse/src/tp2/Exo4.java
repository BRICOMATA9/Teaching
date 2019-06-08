package tp2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Exo4 {
	public void setEntier (int entier){
		this.entier=entier;
		System.out.println(this.entier);
	}
	
	public static void setEntier2 (int entier){
		//this.entier=entier;
		System.out.println(entier);
	}
	
	private int entier = 12;

	public static void main (String [] args) throws IllegalAccessException{
		Exo4 o = new Exo4();	
		Class <?> c = o.getClass();
		Method[] ms = c.getMethods();
		
		for (Method m:ms) {
			if (m.getName().startsWith("set") && 
				m.getParameterCount()==1 &&
				m.getParameterTypes()[0] == int.class &&
			    !Modifier.isStatic(m.getModifiers())) {
					System.out.println(m.getName());
			}
		}
	}
}
