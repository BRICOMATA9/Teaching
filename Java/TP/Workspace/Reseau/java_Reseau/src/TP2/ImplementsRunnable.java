package TP2;

class ImplementsRunnable implements Runnable {

	private String s;
	private static int counter = 0;

	public ImplementsRunnable(String s){
		this.s=s;
	}

	public synchronized void run() {
		for(int i=0;i<100000;i++){
			while(ThreadVsRunnable.flags)
				try{
					Thread.sleep(1);	
				}catch(Exception e){}
			synchronized(ThreadVsRunnable.object){
				ThreadVsRunnable.turn++;
				ThreadVsRunnable.flags=true;
			}
		}
	}
}