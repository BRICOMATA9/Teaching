package Singleton;

public class Singleton {
   private static Singleton instance;

   private Singleton() { }

	public synchronized static Singleton getInstance() {
		if (instance == null)
		    instance = new Singleton();
		return instance;
	}

	public void methodOne() {
		System.out.println("metohde1");
	}

	public void methodTwo() {
		System.out.println("metohde2");
	}

	public static void main(String[] args) {
		Singleton soleOne = Singleton.getInstance();
		Singleton soleTwo = Singleton.getInstance();
       
		soleTwo.methodOne();
		soleOne.methodOne();
		soleOne.methodTwo();
	}
}
