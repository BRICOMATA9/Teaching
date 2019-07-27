package javamyadmin.bdd;

import java.io.Serializable;
import java.sql.Time;
import java.util.GregorianCalendar;

public class Creneau implements Serializable{

	public static final int AVANT = 0;
	public static final int APRES = 1;
	public static final int ERREUR = 2;
	private GregorianCalendar  Datedebut;
	private Time Duree;

	public Creneau (String jour, String heureDeb, String duree) throws Exception {
		String tmpJ [] = jour.split("/");
		if (tmpJ.length!=3) throw new Exception("Creation creneau : Erreur format date");
		String tmpH [] = heureDeb.split(":");
		if (tmpH.length!=2) throw new Exception("Creation creneau : Erreur format heure début");
		String tmpD [] = duree.split(":");
		if (tmpD.length!=2) throw new Exception("Creation creneau : Erreur format duree");
		
		int month = Integer.parseInt(tmpJ[1]);
		//if(month==12) month=0;
		month--;
		Datedebut = new GregorianCalendar (Integer.parseInt(tmpJ[2]),
																				month, 
																				Integer.parseInt(tmpJ[0]), 
																				Integer.parseInt(tmpH[0]), 
																				Integer.parseInt(tmpH[1]));
		Duree = Time.valueOf(duree+":00");
	}

	public String date() {
		int month = Datedebut.get(GregorianCalendar.MONTH);
		//if(month==0) month=12;
		month++;
		return Datedebut.get(GregorianCalendar.DAY_OF_MONTH)+"/"+month+"/"+Datedebut.get(GregorianCalendar.YEAR);
	}

	public String heure() {
		int minute = Datedebut.get(GregorianCalendar.MINUTE);
		String min=""+minute;
		if(minute<10)min="0"+minute;
		return Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+":"+min;
	}

	public String heureFin() {
		int heure = (Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+Duree.getHours());
		int minutes = Datedebut.get(GregorianCalendar.MINUTE)+Duree.getMinutes();
		if(minutes>60) {
			minutes=minutes-60;
			heure++;
		}
		String min=""+minutes;
		if(minutes<10)min="0"+minutes;
		
		
		return heure+":"+min;		
	}

	public String duree() {
		return Duree.toString().substring(0, 5);
	}
	
	public GregorianCalendar getDate() {
		return new GregorianCalendar(Datedebut.get(GregorianCalendar.YEAR),
																	Datedebut.get(GregorianCalendar.MONTH),
																	Datedebut.get(GregorianCalendar.DAY_OF_MONTH));
	}

	public GregorianCalendar getDatedebut() {
		return Datedebut;
	}

	public void setDatedebut(GregorianCalendar datedebut) {
		Datedebut = datedebut;
	}

	public Time getDuree() {
		return Duree;
	}

	public void setDuree(Time duree) {
		Duree = duree;
	}

	public static String DatetoString(GregorianCalendar date) {
		int month = date.get(GregorianCalendar.MONTH);
		month++;
		int minute = date.get(GregorianCalendar.MINUTE);
		String min=""+minute;
		if(minute<10)min="0"+minute;
		return date.get(GregorianCalendar.DAY_OF_MONTH)+"/"+
										month+"/"+
										date.get(GregorianCalendar.YEAR)+" "+
										date.get(GregorianCalendar.HOUR_OF_DAY)+":"+min;
	}

	public GregorianCalendar getDateFin() {
		int heure = (Datedebut.get(GregorianCalendar.HOUR_OF_DAY)+Duree.getHours());
		int minutes = Datedebut.get(GregorianCalendar.MINUTE)+Duree.getMinutes();
		if(minutes>60) {
			minutes=minutes-60;
			heure++;
		}
		GregorianCalendar DateFin = new GregorianCalendar(Datedebut.get(GregorianCalendar.YEAR),
																											Datedebut.get(GregorianCalendar.MONTH),
																											Datedebut.get(GregorianCalendar.DAY_OF_MONTH),
																											heure,minutes);
		
		return DateFin;
	}

	public int compare(Creneau c) {		
		int retour=ERREUR;
		
		if((this.Datedebut.before(c.getDatedebut())) && (this.getDateFin().before(c.getDatedebut()))) {
				retour=AVANT;			
		}
		else if((this.Datedebut.after(c.getDatedebut()))&& (this.Datedebut.after(c.getDateFin()))) {
			retour=APRES;
		}
		return retour;
	}

	public boolean egal(Creneau creneau) {
		Boolean ok = true;
		if(Datedebut.compareTo(creneau.getDatedebut())!=0) ok=false;
		if(Duree.compareTo(creneau.getDuree())!=0) ok= false;
		return ok;
	}
	
}
