package tp4;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		while ( true ) {
			//T1: section NC
			Exercice2.D1 = true;
// D1 & D2			
			while (Exercice2.D2 ){
				if (Exercice2.turn == 2){
					Exercice2.D1 = false;
					while(Exercice2.turn==2) try{ Thread.sleep(10); }catch(Exception e){}
					Exercice2.D1 = true;
				}
			}
// D1 & !D2
			System.out.println("Thread 1");
			Exercice2.turn = 2;
			
			Exercice2.D1 = false;
		}
	}
}
