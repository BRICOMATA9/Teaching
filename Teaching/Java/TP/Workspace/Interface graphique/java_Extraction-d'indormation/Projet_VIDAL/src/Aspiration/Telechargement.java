package Aspiration;

import Interface.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Telechargement extends Thread{
	final int CONSTANTE = 10000;//si la taille du fichier est inconnue on supposera qu'elle est de 10000 octet pour faire progresser la barre
	String fichier;//contient le fichier dans le quel on va sauvegarder les page aspire
	String urlstart;//contient l'URL des pages
	private int indice1;//contient la valeur de progression de chaque fichier aspire
	private int indice2;//contient la valeur de progression de tout l'aspiration
	private Graphique progressBar;
	private InputStream inputstream;
	private int taille_page;
	private JLabel jlabel1;
  
	class Graphique extends JFrame{
	
	  private JProgressBar bar;
  	private JProgressBar bar1;
  	
  	void progression(){		
      setTitle(urlstart);
	    this.setSize(480, 125);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);  
	    getContentPane().setLayout(null);    
	    
	    bar  = new JProgressBar();
	    bar.setMaximum(100);
	    bar.setMinimum(0);
	    bar.setForeground(new Color(0, 0, 113));
	    bar.setBounds(new Rectangle(30, 35, 207, 27));
	    bar.setStringPainted(true);
	    
	    JLabel jlabel = new JLabel("Progression en %");
	    jlabel1 = new JLabel("URL");
	    jlabel.setBounds(new Rectangle(35, 14, 150, 15));
	    jlabel1.setBounds(new Rectangle(35, 14, 250, 115));
	      
	    bar1  = new JProgressBar();
	    bar1.setMaximum(100);
	    bar1.setMinimum(0);
	    bar1.setForeground(new Color(0, 0, 113));
	    bar1.setBounds(new Rectangle(250, 35, 207, 27));
	    bar1.setStringPainted(true); 
	    
	    JLabel jlabel2 = new JLabel("Progression en %");
	    JLabel jlabel3 = new JLabel("Telechargement en cours.");
	    jlabel2.setBounds(new Rectangle(255, 14, 150, 15));
	    jlabel3.setBounds(new Rectangle(255, 14, 250, 115));  
	     
	    getContentPane().add(bar);  
	    getContentPane().add(bar1);
	    getContentPane().add(jlabel);
	    getContentPane().add(jlabel1); 
	    getContentPane().add(jlabel2);
	    getContentPane().add(jlabel3);
	    
	    setResizable(false); //On desactive le redimensionnement de la fenetre
	    this.setVisible(true);
		}
		
		public void set_lettre(char lettre){
	   	jlabel1.setText("URL  "+lettre);
	  }

		public void progress(int i, int j){
    	bar.setValue(i);
      bar1.setValue(j);
      try {
      	sleep(10);
      } catch (InterruptedException e) {
      	e.printStackTrace();
     	}
		}

    void close(){
    	dispose();
    }

    Graphique(){
      progression();
		}
	}//************************************************  FIN DE LA CLASSE GRAPHIQUE  *********************************************************
	
	public Telechargement(String s, String s1){
  	urlstart = transforme(s);
    fichier = s1;
    progressBar = new Graphique();
	}

	String transforme (String s){
  	if(s.startsWith("http://"))//si le protocole de transmission est http on garde l'URL tel qu'il est
    	return s;
		else 
    	return "http://".concat(s);//sinon on ajoute le nom du protacole au debut de l'URL
	}
  
  private String transformer_url (char c){//on trandforme l'URL pour qu'il correspond a la page de la lettre voulue
  		
  		return urlstart.substring(0,urlstart.length()-5)+c+urlstart.substring(urlstart.length()-4,urlstart.length());
  }
  
  private boolean verifier_url(String adresse){
  	URL url=null;
		URLConnection urlconnection=null;
		try{
			url = new URL(adresse);
			try{
				urlconnection = url.openConnection();
			}catch(IOException _ex){
				new Dialogue("Probleme de connexion a l'URL "+adresse);
				progressBar.close();//on ferme la barre de progression
				return true;//si la page ne s'ouvre pas on passe a la suivante
			}
		}catch(MalformedURLException _ex){
			new Dialogue("Adresse mal formee, Veuillez la verifier.");
			progressBar.close();//on ferme la barre de progression
			return false;//si l'adresse n'est pas bien formé on peut pas continuer l'aspiration
		}
		try {
			inputstream =url.openStream();
		}catch(IOException _ex){
			new Dialogue("Probleme de connexion à Internet");
			progressBar.close();//on ferme la barre de progression
			return false;//si la connexion est echoue on peut pas continuer l'aspiration
		}
		taille_page = urlconnection.getContentLength();//length contient la taille de la page courante
		return true;
  }

	public void run(){
		try{
			if (!verifier_url(urlstart))return;//on verifier d'abord si l'url est correcte
			if(urlstart.indexOf("Medicament")!=-1) fichier+="_medic.htm";//pour referencer les medicaments on utilise l'ettiquete medic
			else if(urlstart.indexOf("Substance")!=-1) fichier+="_subst.htm";//pour referencer les substances on utilise l'ettiquete subst
			BufferedWriter ecrire = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fichier), "UTF-16"));
			int j=1;//on initialise un compteur j des pages a aspirer 
			for(char i='A';i<='Z';j++,i++){//pour chaque lettre 
				if(urlstart.indexOf("Medicament")!=-1)//si l'URL saisi est celui des medicaments ie l'URL contient la lettre 'M'
					if (i=='D' || i=='N' || i=='M' ||i=='S') continue;//on saute les pages qui ete desactivees
				urlstart = transformer_url(i);//on modifier l'URL pour afficher tous les pages de A a Z
				progressBar.setTitle(urlstart);//l'URL de la page courante sera affiche comme titre de la barre de progression
				progressBar.set_lettre(i);
				if (!verifier_url(urlstart))return;
				try {
					BufferedReader lire = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
					if (taille_page == -1) 
						taille_page = CONSTANTE;//si on ne peut pas connaitre la taille du fichier a aspirer on suppose une taille CONSTANTE
					do {
						String line = lire.readLine();
						if(line == null) break;
						indice1+= line.length()*100/taille_page;
						progressBar.progress(indice1, indice2);
						ecrire.write(line);
						ecrire.write(System.getProperty("line.separator"));
					}while(true);
					lire.close();
				}catch(IOException _ex){
					new Dialogue("Probleme de lecture de la page");
					progressBar.close();//on ferme la barre de progression
					return;//si une erreur de lecture se produit on ne peut pas continuer l'aspiration
				}  			
				indice2=j*100/26;
				indice1=0;
			}
			ecrire.close();
		}catch(IOException _ex){
			new Dialogue("Probleme d'ecriture sur le fichier");
			progressBar.close();//on ferme la barre de progression
			return;
		}
		new Dialogue("Fin de l’aspiration");
		progressBar.close();			
	}
}

