package Transformation;

import Interface.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;
import java.io.*;

public class Extraction {
	private Pattern pattern;
	private Matcher matcher;
	private BufferedReader r;
	private BufferedWriter p;
	private File temporaire;
	
	public Extraction(String ouv,String enre) throws IOException { 
		if(ouv.indexOf("_medic")!=-1) Medicament(ouv,enre);//si le fichier source contient la lettre 'M' on dira 
		if(ouv.indexOf("_subst")!=-1) Substance(ouv,enre);
	}					

			
	public void Medicament(String source,String destination)throws IOException{
		char i;	
		String s,n,m,a=", .N+medic";
		
		temporaire =new File("./download/tmpmedic.dic");
		p = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temporaire), "UTF-16"));
		for(i='A';i<='Z';i++){	// Ouverture
			r = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-16"));					
			while ((s = r.readLine()) != null) {					
				pattern = Pattern.compile("[>]"+i+"[A-Z ]+[\\Wa-zA-Z_0-9 ]+\\b[<]");
	      matcher = pattern.matcher(s);
	      while(matcher.find()) {
	        n=matcher.group();	        	
	       	n = n.substring (1,n.length()-1); 
	       	pattern = Pattern.compile(i+"[A-Z]*[ ]");
		      matcher = pattern.matcher(n);
		      if(matcher.find()) {
		      	m=matcher.group();
		       	m= m.toLowerCase();
		       	m=m+a;
		       	p.write(m);
		       	p.write(System.getProperty("line.separator"));
		      }    		           
	      }
			}	
			r.close();		
		}
		p.close();				

		p = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "UTF-16"));
		r = new BufferedReader(new InputStreamReader(new FileInputStream(temporaire), "UTF-16"));
		String suivant,courant = r.readLine(); 
		suivant=courant;
		suivant=r.readLine();
		while (courant != null) {
			if(!courant.equals (suivant))
				if(!courant.equals ("VIDAL , .N+medic")) {
					p.write(courant);
					p.write(System.getProperty("line.separator"));
				}
			courant=suivant;
			suivant=r.readLine();		
		}
		r.close();
		p.close();
		temporaire.delete();
		new Dialogue ("Le dictionnaire medic.dic a ete genere avec succes");
	}

	public void Substance(String source,String destination)throws IOException{
		char i;	
		String s,n,m,a=", .N+medic";
		
		temporaire =new File("./download/tmpsubst.dic");
		p = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temporaire), "UTF-16"));
		a=", .N+subst";
		for(i='a';i<='z';i++){	
			r = new BufferedReader(new InputStreamReader(new FileInputStream(source), "UTF-16"));
			while ((s = r.readLine()) != null) {			
	   		pattern = Pattern.compile("[h][t][m][\"][>]"+i+"[a-z]+[\\w\\W]+\\b[<]");
      	matcher = pattern.matcher(s);
      	while(matcher.find()) {
      	  n=matcher.group();
      	  n = n.substring (5,n.length()-1); 
      	  pattern = Pattern.compile(i+"[a-z]+[\\w\\W]+");
	    	  matcher = pattern.matcher(n);
	    	  if(matcher.find()) {
	    	    m=matcher.group();
	    	    m=m+a;
	    	    p.write(m);
						p.write(System.getProperty("line.separator"));
					}   	           
				}
			}
			r.close();	
		}	
		p.close();	
				
		p = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination), "UTF-16"));
		r = new BufferedReader(new InputStreamReader(new FileInputStream(temporaire), "UTF-16"));
		String suivant,courant = r.readLine(); 
		suivant=courant;
		suivant=r.readLine();
		while (courant != null) { 
			if(!courant.equals (suivant)) { 
				if(!courant.equals ("VIDAL , .N+subst")) {p.write(courant);
							p.write(System.getProperty("line.separator"));}
			} 
			courant=suivant;
			suivant=r.readLine();	
		}	
		r.close();	
		p.close();
		temporaire.delete();
		new Dialogue ("Le dictionnaire subst.dic a ete genere avec succes");
	}
}
