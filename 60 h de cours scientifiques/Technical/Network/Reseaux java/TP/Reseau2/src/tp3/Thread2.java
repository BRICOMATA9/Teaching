package tp3;

public class Thread2 extends Exercice4 implements Runnable {

    @Override
    public void run() {
        while ( true ) {
            while ( !x2 ) {
							try{
								Thread.sleep(10);
							}catch(Exception e){}
						}
							
						x2=false;
						
            while ( !x1 ) {
							try{
								Thread.sleep(10);
							}catch(Exception e){}
						}
						
						x1=false;
						
            System.out.println( "Thread 2" );
            		
          	try{
							Thread.sleep(10);
						}catch(Exception e){}
						
						x1=true;
						x2=true;

        }
		}
}