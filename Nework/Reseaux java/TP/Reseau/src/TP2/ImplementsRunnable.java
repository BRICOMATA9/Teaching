package TP2;

class ImplementsRunnable implements Runnable {

	private String s;
	private static int counter = 0;

	public ImplementsRunnable(String s){
		this.s=s;
	}

	public synchronized void run() {
		for(int i=0;i<100000;i++)
			counter++;
		System.out.println(Thread.currentThread().getId()+" : "+counter);
	}
}