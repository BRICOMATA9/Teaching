package state;

public class NoQuarterState implements State {

	@Override
	public void insertQuarter(GumballMachine machine) {
		machine.state = GumballMachine.HAS_QUARTER;
		System.out.println("You inserted a quarter");
	}

	@Override
	public void ejectQuarter(GumballMachine gumballMachine) {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void dispense(GumballMachine gumballMachine) {

		System.out.println("You need to pay first");
	}

}
