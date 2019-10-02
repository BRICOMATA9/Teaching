package state;

public class NoQuarterState implements State { 
	Gumball Machine gumballMachine;
	public NoQuarterState (GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	public void insertQuarter ( )  {
		System.out.println("You have inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
	public void ejectQuarter ( ) {
		System.out.println("You haven't inserted a quarter");
	}
	public void turnCrank ( ) {
		System.out.println("You turned but there is no quarter");
	}
	public void dispense ( ) {
		System.out.println("You have to pay first");
	}
}

