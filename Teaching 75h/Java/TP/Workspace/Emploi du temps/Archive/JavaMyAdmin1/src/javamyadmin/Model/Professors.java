package javamyadmin.Model;

import java.util.List;

public class Professors {
	private List<Professor> listProfs;

	public List<Professor> getAllProfs() {
		return listProfs;
	}

	public void setAllProfs(List<Professor> allProfs) {
		this.listProfs = allProfs;
	}

}
