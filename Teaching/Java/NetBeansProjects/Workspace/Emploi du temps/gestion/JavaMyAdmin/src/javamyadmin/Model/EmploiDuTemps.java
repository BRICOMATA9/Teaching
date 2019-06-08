package javamyadmin.Model;

import java.util.List;

public class EmploiDuTemps extends BaseEntity {
	private String classe;

	private List<Sceance> listSceance;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public List<Sceance> getListSceance() {
		return listSceance;
	}

	public void setListSceance(List<Sceance> listSceance) {
		this.listSceance = listSceance;
	}
}
