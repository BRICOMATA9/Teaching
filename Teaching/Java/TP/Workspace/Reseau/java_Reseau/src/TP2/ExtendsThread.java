package TP2;

class ExtendsThread extends Thread {

	private String s;
	private static int counter = 0;
	
	public ExtendsThread(String s){
		this.s=s;
	}

	public void run() {
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
