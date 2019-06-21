package TD5;
class A {}
class B extends A{}
class C extends B{}

public class TD5 {
	public static void main(String[] args) {
		Class<?> c = C.class;
		while (c!=null){
			System.out.println(c.getName());
			c = c.getSuperclass();
		}
	}
}





