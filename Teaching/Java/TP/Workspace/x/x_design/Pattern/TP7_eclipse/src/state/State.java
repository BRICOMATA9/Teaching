package state;

interface State {
	void insertQuarter(GumballMachine machine);

	void ejectQuarter(GumballMachine gumballMachine);

	void dispense(GumballMachine gumballMachine);


}
