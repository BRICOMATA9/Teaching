package javamyadmin.Interface;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Jours {
	
	
	private Date jour1;
	private Date jour2;
	private Date jour3;
	private Date jour4;
	private Date jour5;
	static final SimpleDateFormat formatsemaine =  new SimpleDateFormat("w",new Locale("fr","FR"));
	static final SimpleDateFormat formatjour =  new SimpleDateFormat("EEEE dd/MM",new Locale("fr","FR"));
	TimeZone cet = TimeZone.getTimeZone( "CET" );

	public Jours(GregorianCalendar maintenant){	
		formatsemaine.setTimeZone(cet);
		formatjour.setTimeZone(cet);
		maintenant.setFirstDayOfWeek(GregorianCalendar.MONDAY);

		if (maintenant.get(GregorianCalendar.DAY_OF_WEEK)>6){
			maintenant.add(GregorianCalendar.DAY_OF_WEEK,(+9-maintenant.get(GregorianCalendar.DAY_OF_WEEK)));
		}
		else {

			maintenant.add(GregorianCalendar.DAY_OF_WEEK,+2-maintenant.get(GregorianCalendar.DAY_OF_WEEK));
		}
	
		jour1 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour2 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour3 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour4 = maintenant.getTime();
		maintenant.add(GregorianCalendar.DAY_OF_WEEK,+1);
		jour5 = maintenant.getTime();
	}

	public Date getJour1() {
		return jour1;
	}

	public Date getJour2() {
		return jour2;
	}

	public Date getJour3() {
		return jour3;
	}

	public Date getJour4() {
		return jour4;
	}

	public Date getJour5() {
		return jour5;
	}

	public Date getJours(int i){
		Date d=null;
		switch (i){
			case 1: d=jour1;break;
			case 2:d=jour2;break;
			case 3:d=jour3;break;
			case 4:d=jour4;break;
			case 5:d=jour5;break;
		}
		return d;
	}

	public String getStringJour1() {
		return formatjour.format(jour1);
	}

	public String getStringJour2() {
		return formatjour.format(jour2);
	}

	public String getStringJour3() {
		return formatjour.format(jour3);
	}

	public String getStringJour4() {
		return formatjour.format(jour4);
	}

	public String getStringJour5() {
		return formatjour.format(jour5);
	}

	public String getStringSemaine() {
		return formatsemaine.format(jour1);
	}

	public String getStringSemaineproch() {
		return Integer.toString(Integer.parseInt(formatsemaine.format(jour1))+1);
	}

	public String getStringSemaineprec() {
		return Integer.toString(Integer.parseInt(formatsemaine.format(jour1))-1);
	}
}

