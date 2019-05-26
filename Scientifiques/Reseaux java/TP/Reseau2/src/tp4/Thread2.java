package tp4;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		while ( true ) {
			//T1: section NC
			Exercice2.D2 = true;
			while (Exercice2.D1 ){
				if (Exercice2.turn == 1){
					Exercice2.D2 = false;
					while(Exercice2.turn!=2)
						try{
								Thread.sleep(10);
						}catch(Exception e){}
					Exercice2.D2 = true;
				}
			}
			System.out.println("Thread 2");
			Exercice2.turn = 1;
			Exercice2.D2 = false;
		}
	}
}
