package tp4;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		while ( true ) {
// turn = 1			
			while(Exercice1.turn==1)
				try{
					Thread.sleep(10);
			}catch(Exception e){}
// turn = 2
			while(Exercice1.turn==2)
				try{
					Thread.sleep(10);
				}catch(Exception e){}
// turn =  1				
			System.out.println("Thread 2");
			
			Exercice1.turn=1;
		}
	}
}
