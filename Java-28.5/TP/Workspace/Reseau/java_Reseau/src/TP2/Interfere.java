package TP2;

public class Interfere {
	private int data = 0 ;
	private boolean[] wants_to_enter={false,false};
	private int turn = 0;
	
	public synchronized void update ( ) {
		data++;
	}
}