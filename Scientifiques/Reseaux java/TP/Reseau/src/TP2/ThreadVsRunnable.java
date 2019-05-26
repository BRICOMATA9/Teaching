package TP2;

public class ThreadVsRunnable {
	
	public static boolean flags=false;
	public static Object object=new Object();
	public static int turn=0;

	public static void main(String args[]) throws Exception {
		
//	    ImplementsRunnable r1 = new ImplementsRunnable("Runnable1");
//	    Thread t1 = new Thread(r1);
//	    t1.start();

//	    ImplementsRunnable r2 = new ImplementsRunnable("Runnable2");
//	    Thread t2 = new Thread(r1);
//	    t2.start();
	    
	    ExtendsThread t1 = new ExtendsThread("t1");
	    t1.start();
	    ExtendsThread t2 = new ExtendsThread("t2");
	    t2.start();
  }
}
