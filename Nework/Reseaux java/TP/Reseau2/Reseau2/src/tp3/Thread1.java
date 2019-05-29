package tp3;

public class Thread1 extends Exercice4 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            while ( !x1 ) {
							try{
								Thread.sleep(10);
							}catch(Exception e){}
						}
							
						x1=false;
						
            while ( !x2 ) {
							try{
								Thread.sleep(10);
							}catch(Exception e){}
						}
						
						x2=false;
						
            System.out.println( "Thread 1" );	
            	
          	try{
							Thread.sleep(10);
						}catch(Exception e){}
						
						x1=true;
						x2=true;

        }
		}
}
