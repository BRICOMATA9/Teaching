package state;

public class GumballMachine {

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State state = soldOutState;
	int count = 0;

	public GumballMachine (int numberGumballs) {
		soldOutState = new SoldOutState (this);
		noQuarterState = new NoQuarterState (this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new HasSoldState (this);

		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}
	public void insertQuarter () {
		state.insertQuarter();
	}
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	public void turnCrank() {
		state.turnCrank ();
		state.dispense();
	}
	public void setState (State state) {
		this.state = state;
	}
	void releaseBall ( ) {
		System.out.println ("A gumball comes rolling out of the slot....");
		if  (count != 0 ) count --; 
	} 
}
