package BDD;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cours {

	protected Module idModule;
	protected Salle idSalle;
	protected Salle salleBis;
	protected Enseignant idEnseignant;
	protected Section idSection;
	protected Date dateDebut;
	protected Date heureDebut;
	protected Date duree;
	
	private static SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	private static SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
	
	public Module getIdModule() {
		return idModule;
	}
	public void setIdModule(Module idModule) {
		this.idModule = idModule;
	}
	public Salle getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Salle idSalle) {
		this.idSalle = idSalle;
	}
	public Date getDuree() {
		return duree;
	}
	public void setDuree(Date duree) {
		this.duree = duree;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Enseignant getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Enseignant idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	
	@Override
	public String toString() {
		return "Module=" + idModule.getIdModule() + ", Salle=" + idSalle.getIdSalle() + ", Enseignant=" + idEnseignant.getIdPersonne()
				+ ", dateDebut=" + formatterDate.format(dateDebut) + ", heureDebut=" + formatterTime.format(heureDebut) + ", heureFin=" + formatterTime.format(duree) + ", Section="
				+ idSection.getIdSection();
	}

	public Section getIdSection() {
		return idSection;
	}

	public void setIdSection(Section idSection) {
		this.idSection = idSection;
	}
	
	public int compareJour(Date jour1) {
		GregorianCalendar d1 = new GregorianCalendar();
		GregorianCalendar d2 = new GregorianCalendar();
		
		d1.setTime(getDateDebut());
		d2.setTime(jour1);
		
		d1.set(GregorianCalendar.HOUR_OF_DAY, 0);
		d1.set(GregorianCalendar.MINUTE, 0);
		d1.set(GregorianCalendar.SECOND, 0);
		d1.set(GregorianCalendar.MILLISECOND, 0);
		
		d2.set(GregorianCalendar.HOUR_OF_DAY, 0);
		d2.set(GregorianCalendar.MINUTE, 0);
		d2.set(GregorianCalendar.SECOND, 0);
		d2.set(GregorianCalendar.MILLISECOND, 0);

		//System.out.println(getDateDebut()+" == "+jour1);
		return d1.compareTo(d2);
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Salle getSalleBis() {
		return salleBis;
	}
	public void setSalleBis(Salle salleBis) {
		this.salleBis = salleBis;
	}
	
}
