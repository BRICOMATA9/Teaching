package tp2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.xml.internal.utils.SerializableLocatorImpl;

class Methodes {
	///////////Q1
	public static void	printFields(Object o){
		Field [] fieldsArray =o.getClass().getFields();
		for(Field item : fieldsArray){
			System.out.println(item.getName().toString());
		}
	}
	
	//*****************Q2
	public static void modifyIntFields (Object o) throws IllegalArgumentException, IllegalAccessException {
		Field [] fieldsArray =o.getClass().getFields();
		for(Field item : fieldsArray){
			System.out.println(item.getType().toString()); 
			if (item.getType() == int.class ){
				item.setInt(o, 42);
			}
		}

	}
	
	
	//*******************Q3
	public static void questionTrois(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method[] methodes = o.getClass().getDeclaredMethods();
		for(Method item : methodes){
			if(item.getName().startsWith("set") 
					&& item.getParameterTypes().length==1 
					&& item.getParameterTypes()[0]==int.class
					&& !Modifier.isStatic(item.getModifiers()) ){
				item.invoke(o, 42);
			}
		}
		
	}
	
	//******************Q4
	public static void questionQuatre(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method[] methodes = o.getClass().getDeclaredMethods();
		for(Method item : methodes){
			if(item.getName().startsWith("set") 
					&& item.getParameterTypes().length==1 
					&& item.getParameterTypes()[0]==int.class){
				item.invoke(o, 42);
			}
		}
		
	}
	
	
	
	//**********************Q5
	
	public static Object questionCinque(Object o) throws NoSuchMethodException, SecurityException{
		Object superClass = o.getClass().getSuperclass();
		while(superClass.getClass().getConstructor().getParameterTypes().length !=0){superClass = superClass.getClass().getSuperclass();}
		Object toReturn = superClass.getClass().getConstructor();
		return toReturn;					
	}
	
	
	//*********************Q6
	public static void questionSix(Object o){
		System.out.println();
		 Method [] methods = o.getClass().getDeclaredMethods();
		 for(Method item : methods)System.out.println(item.getName());
	}
	
	
	//*******************Q7
	public static <T> Collection< Class> suestionSept (Collection<T> input){
		Collection<Class> output = new ArrayList<>();
		for(T item : input){
			if(item instanceof Class)output.add((Class) item);
		}
		
		return output;
	}
}

public class E1q1 {
	
	public String s1, s2;
	public int i1,i2;
	
	public E1q1(String s1, String s2, int i1, int i2) {
		super();
		this.s1 = s1;
		this.s2 = s2;
		this.i1 = i1;
		this.i2 = i2;
	}

	public static void main (String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		E1q1 object1 = new E1q1("toto", "tata", 1, 2);
		//Methodes.printFields(object1);

		//Methodes.modifyIntFields(object1);
		
		//Methodes.questionTrois(object1);
		//System.out.println(object1.i2);
		
		List array = new ArrayList();
		array.add(object1);
		array.add(new String("toto"));

		
		
		Methodes.questionSix(object1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	private  void setto (int i){
		System.out.println(i);
	}

}

