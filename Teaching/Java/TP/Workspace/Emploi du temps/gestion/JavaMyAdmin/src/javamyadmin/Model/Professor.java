package javamyadmin.Model;

import java.util.List;

public class Professor extends Person {
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
