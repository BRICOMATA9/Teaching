package tp4;

public class Exercice2 {

	public static volatile boolean D1 = false;
	public static volatile boolean D2 = false;
	public static volatile int turn = 1;

  public static void main( String[] args ) {
      Thread t1 = new Thread( new Thread1() );
      Thread t2 = new Thread( new Thread2() );

      t1.start();
      t2.start();
  }
}
