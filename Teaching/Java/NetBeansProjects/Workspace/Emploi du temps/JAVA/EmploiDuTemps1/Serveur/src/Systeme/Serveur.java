package Systeme;

import java.net.ServerSocket;
import java.util.Vector;

/**
 * Classe serveur qui s'occuppe des demandes de connection.
 * @author Alexander Remen et Tonya Vo Thanh
 *<p>La classe est seulement instancé une seule fois (utilisation d'un singleton).
 * Elle recoit toutes les demandes de connection et leurs créer un thread Gestion EDT.</p>
 */
public class Serveur extends Thread{

	static final int port = 8080;
	
	//Création d'un singleton
	private static Serveur instance = new Serveur();
//	private Thread t;
	private Serveur()
	{/*
		t = new Thread(this);
		t.start();*/
		new Gestion_EDT();
	}

	
	/**
	 *	Lance un serveur si il n'a pas déja été instancié
	 * 
	 */
	public static void lanceServeur()
	{
		if(instance==null){instance=new Serveur();}
	}
	
	/**
	 * Quand le serveur tourne il attend tout le temps de nouvelles connections socket et instancie un Gestion_EDT pour chaque connection 
	 */
/*	public void run()
	{
		try{
		    ServerSocket ses = new ServerSocket(port);
		    System.out.println("serveur socket cree");
		     while(true)
		     {     
		    	 new Gestion_EDT(ses.accept());
		     }
	     }catch(Exception e){
	        e.printStackTrace();
	     }
	}*/
	/**
	 * Main côté serveur fait juste appel à la méthode statique lanceServeur()
	 * @param args
	 */
	public static void main(String[] args) {
		Serveur.lanceServeur();
	}
	
}
