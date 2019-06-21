package builder;

import java.util.ArrayList;

public class SupervisorConverter extends AbstractConverter {

	private ArrayList<String> supervisors = new ArrayList<String>();

	public ArrayList<String> getSupervisors() {
		return supervisors;
	}

	@Override
	public void ReadSupervisor(String supervisorName) {
		supervisors.add(supervisorName);
	}

}
