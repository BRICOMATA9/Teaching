package bdd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cours {

	protected String idModule;
	protected Integer idSalle;
	protected Integer idEnseignant;
	protected Date dateDebut;
	protected Date heureDebut;
	protected Date duree;
	protected Integer idSection;
	
	//private SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");
	
	public String getIdModule() {
		return idModule;
	}
	public void setIdModule(String idModule) {
		this.idModule = idModule;
	}
	public Integer getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(Integer idSalle) {
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
	public Integer getIdEnseignant() {
		return idEnseignant;
	}
	public void setIdEnseignant(Integer idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	@Override
	public String toString() {
		return idModule+"   "+idSalle+"   "+idEnseignant+"   "+idSection+"   "+dateDebut+"   "+heureDebut;
	}



	public Integer getIdSection() {
		return idSection;
	}

	public void setIdSection(Integer idSection) {
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
	
}
