package tp4;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		while ( true ) {
			//T1: section NC
			Exercice2.D1 = true; 
			turn = 2;
			while(!Exercice2.D2 || turn=1)     
				try{
						Thread.sleep(10);
				}catch(Exception e){}
			}
			System.out.println("Thread 1");
			Exercice2.D1 = false;
		}
	}
}
