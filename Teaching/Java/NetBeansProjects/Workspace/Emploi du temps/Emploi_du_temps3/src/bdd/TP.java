package bdd;

import java.text.SimpleDateFormat;

public class TP extends Cours {

	private Integer idGroupe;
	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

	public Integer getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Integer idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Override
	public String toString() {
		return "Module=" + idModule + ", Salle=" + idSalle + ", Enseignant="
				+ idEnseignant + ", dateDebut=" + formatterDate.format(dateDebut) + ", heureDebut=" + formatterTime.format(heureDebut) + ", duree=" + formatterTime.format(duree)
				+ ", Section=" + idSection + ", Groupe=" + idGroupe;
	}
}