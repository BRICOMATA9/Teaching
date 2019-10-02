package BDD;

import java.text.SimpleDateFormat;

public class TP extends Cours {

	private Groupe idGroupe;
	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");

	public Groupe getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(Groupe idGroupe) {
		this.idGroupe = idGroupe;
	}

	@Override
	public String toString() {
		return "Module=" + idModule.getIdModule() + ", Salle=" + idSalle.getIdSalle() + ", Enseignant="
				+ idEnseignant.getIdPersonne() + ", dateDebut=" + formatterDate.format(dateDebut) + ", heureDebut=" + formatterTime.format(heureDebut) + ", heureFin=" + formatterTime.format(duree)
				+ ", Section=" + idSection.getIdSection() + ", Groupe=" + idGroupe.getIdGroupe();
	}
}