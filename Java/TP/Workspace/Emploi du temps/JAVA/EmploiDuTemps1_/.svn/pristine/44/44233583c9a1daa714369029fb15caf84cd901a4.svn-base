package Interfaces;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import Systeme.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import bdd.*;
import java.util.*;

/**
 * Interface graphique emploi du temps
 * @author Alexander Remen et Tonya Vo Thanh
 * <p>Classe qui affiche l'emploi du temps et permet de naviguer vers les semaines précédentes et les semaines suivantes.
 * A partir du menu on peut aussi acceder à l'interface graphique d'un envoi d'un mél.</p>
 */
public class Interface_EDT {
	
	public GregorianCalendar maintenant = (GregorianCalendar) GregorianCalendar.getInstance();
	public JFrame fenetre = new JFrame();
	private JLabel LLundi = new JLabel();
	private JLabel LMardi = new JLabel();
	private JLabel LMercredi = new JLabel();
	private JLabel LJeudi = new JLabel();
	private JLabel LVendredi = new JLabel();
	private JButton LSemaine = new JButton();
	private JButton SemainePrec = new JButton();
	private JButton SemaineSuiv = new JButton();
	private JTextPane PLundi =  new JTextPane();
	private JTextPane PMardi =  new JTextPane();
	private JTextPane PMercredi =  new JTextPane();
	private JTextPane PJeudi =  new JTextPane();
	private JTextPane PVendredi =  new JTextPane();
	private Liste_Contacts Fenetremail = new Liste_Contacts();
	private Client Classeclient;
	
    private static void AddtexttoPane(String[] initString,String[] initStyles, JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        addStylesToDocument(doc);

        try {
            for (int i=0; i < initString.length; i++) {
            	
                doc.insertString(doc.getLength(), initString[i],
                                 doc.getStyle(initStyles[i]));
            }
        } catch (BadLocationException ble) {
            System.err.println("Couldn't insert initial text into text pane.");
        }
    }
    /*
     * Méthode qui prend en paramètre le vecteur de vecteur de cours (tous les cours d'une semaine) et les affiches dans 5 differents JTextPane.
     * @param tabCours
     * @see Cours
     */
	private void Addcourstojour(Vector<Vector<Cours>> tabCours) {

		int nbcours;
		JTextPane textpane;
		/* Calculer le nombre de cours */
		for(int jours=0;jours<5;jours++){
			Vector<Cours> listec = tabCours.elementAt(jours);
			nbcours = listec.size();
			String[] SJour = new String[6*nbcours];
			String[] StyleJour = new String[6*nbcours];
			int j =0;
			for (int i=0;i<=(nbcours*6)-1;i=i+6){
				//on va chercher les cours a afficher pour chaque jour
				Cours c = listec.elementAt(j);
				SJour[i]=c.getCreneau().heure()+"-"+c.getCreneau().heureFin()+"\n";
				StyleJour[i]="horaire";
				//la matiere
				SJour[i+1]=c.getMatiere().getIntitule()+"\n";
				StyleJour[i+1]="cours";
				//la salle
				SJour[i+2]="Salle "+c.getSalle().getNom_salle()+"\n";
				StyleJour[i+2]="salle";
				//le prof
				SJour[i+3]=c.getEnseignant().getNom()+"\n";
				StyleJour[i+3]="prof";
				//le groupe
				SJour[i+4]="Groupe "+c.getGroupe().getnum_groupe()+"\n";
				StyleJour[i+4]="groupe";
				//le delimitement
				SJour[i+5]="******************"+"\n";
				StyleJour[i+5]="cours";
				j++;
			}
	        
			switch(jours) {
				case 0:  textpane= PLundi; break;
				case 1:  textpane = PMardi; break;
				case 2:  textpane = PMercredi; break;
				case 3:  textpane = PJeudi; break;
				case 4:  textpane = PVendredi; break;
				default: textpane = null;
			}
	        AddtexttoPane(SJour,StyleJour,textpane);
	        
		}

	}
	
    /* Méthode qui ajoute le style de chaque string dans les JTextPane */
	protected static void addStylesToDocument(StyledDocument doc) {
        //Initialize some styles.
        Style def = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);

        StyleConstants.setAlignment(def, StyleConstants.ALIGN_CENTER);
        StyleConstants.setItalic(def, false);
        StyleConstants.setFontFamily(def, "SansSerif");
        doc.setParagraphAttributes(0, 0, def, true);
        
        Style regular = doc.addStyle("horaire", def);
        StyleConstants.setBold(regular,true);
        
        Style s = doc.addStyle("salle", regular);
        StyleConstants.setItalic(s, true);
        
        Style pr = doc.addStyle("prof", regular);
        StyleConstants.setFontSize(pr, 10);
        
        s = doc.addStyle("groupe", regular);
        StyleConstants.setFontSize(s, 10);

        Style cs = doc.addStyle("cours", regular);
        StyleConstants.setBold(cs, true);
        
        s = doc.addStyle("cours", regular);
        StyleConstants.setBold(s, true);
       
	}

	/**
	 * Méthode utilisé pour actualiser et pour changer de semaine. On lui passe une classe Jours et elle actualise tout la fenêtre.
	 * @param Semaine - les jours que l'on veut afficher dans l'interface graphique
	 * @see Jours
	 */
	public void afficher_contenu(Jours Semaine){
		//On efface le contenu dans les panels
		PLundi.setText("");
		PMardi.setText("");
		PMercredi.setText("");
		PJeudi.setText("");
		PVendredi.setText("");
		//les labels sont rennomés
		LLundi.setText("     "+Semaine.getStringJour1());
		LMardi.setText("     " +Semaine.getStringJour2());
		LMercredi.setText("     " +Semaine.getStringJour3());
		LJeudi.setText("     " +Semaine.getStringJour4());
		LVendredi.setText("     " +Semaine.getStringJour5());
		LSemaine.setText(" Semaine: "+ Semaine.getStringSemaine());
		SemainePrec.setText(" Semaine " + Semaine.getStringSemaineprec());
		SemaineSuiv.setText(" Semaine " + Semaine.getStringSemaineproch());
		addtolisteCours(Semaine);
		
	}
	/**
	 * Méthode qui fait appel à une méthode dans la classe client qui envoi les dates de la semaine.
	 * Ensuite elle fait appel à la méthode qui affiche (actualise le contenu des JTextPanes).
	 * @param Semaine
	 */
	public void addtolisteCours(Jours Semaine){
		try {
			Vector<Vector<Cours>> liste_cours = (Classeclient.recuperercoursdelasemaine(Semaine));
			Addcourstojour(liste_cours);
		} catch (IOException e) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}
		
	}
	
	/*
     * Centre la fenetre au milieu de l'ecran
     * @param frame - la fenetre
     */
	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - ((frameSize.width +210)/ 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
	/**
	 * Méthode qui recoit en paramètre un vecteur de personne et la classe client et fait appelle à la méthode de la classe Liste_Contacts apropriée.
	 * @param ListePersonne - vector<Personne> a afficher dans le JComboBox
	 * @param Classeclient - La classe client qui instancie tout du cote client
	 */
	public void init_fenetre_mail(Vector<Personne> ListePersonne,Client Classeclient){
		
		Fenetremail.Init_fenetre_mail(ListePersonne,Classeclient);
	}
	
	/**
	 * Méthode qui affiche la fenêtre avec l'emploi du temps. Elle commence par afficher la semaine en cours. La communication avec le serveur 
	 * passe par la classe client et doit donc la connaître, et est donc passé en paramètre.
	 * @param notreClasseclient - La classe client qui instancie tout du cote client
	 */
	public void Afficher_EDT(Client notreClasseclient) {
		Classeclient = notreClasseclient;
		
		fenetre.setTitle("Emploi du temps");
		/* On veut que la fenetre ne se ferme pas, mais fait appel à la méthode fermer de la classe Actions */
		fenetre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Actions action = new Actions(Classeclient);
		fenetre.addWindowListener(action.getFermerWindows());
		fenetre.setSize(800,600);
		centerFrame(fenetre);
		
		/* Trouver les jours de la semaine en cours */ 
		Jours Semaine = new Jours(maintenant);
		
		/* Labels et boutons NORD */
		JPanel headerpane = new JPanel();
		headerpane.setLayout(new BorderLayout());
		LSemaine.setBackground(new Color(72,164,255));
		headerpane.add(SemainePrec,BorderLayout.WEST);
		headerpane.add(LSemaine,BorderLayout.CENTER);
		headerpane.add(SemaineSuiv,BorderLayout.EAST);
		
		afficher_contenu(Semaine);
		
		/* Contenu panels dates des jours */
		LLundi.setBorder(new LineBorder(new Color(0,0,0)));
		LLundi.setBackground(new Color(115,167,230));
		LMardi.setBorder(new LineBorder(new Color(0,0,0)));
		LMardi.setBackground(new Color(115,167,230));
		LMercredi.setBorder(new LineBorder(new Color(0,0,0)));
		LMercredi.setBackground(new Color(115,167,230));
		LJeudi.setBorder(new LineBorder(new Color(0,0,0)));
		LJeudi.setBackground(new Color(115,167,230));
		LVendredi.setBorder(new LineBorder(new Color(0,0,0)));
		LVendredi.setBackground(new Color(115,167,230));
		JPanel JoursSemaine = new JPanel();
		JoursSemaine.setLayout(new GridLayout(1,5));
		JoursSemaine.add(LLundi);
		JoursSemaine.add(LMardi);
		JoursSemaine.add(LMercredi);
		JoursSemaine.add(LJeudi);
		JoursSemaine.add(LVendredi);
		
		/* Panel qui regroupe les deux panels du dessus */
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new BorderLayout());
		toppanel.add(headerpane,BorderLayout.NORTH);
		toppanel.add(JoursSemaine,BorderLayout.SOUTH);
		
		fenetre.getContentPane().add(toppanel,BorderLayout.NORTH);
		
		/* Panel qui regroupe les JTextPanes */
		JPanel contenu = new JPanel();
		contenu.setSize(800,400);
		contenu.setLayout(new GridLayout(1,5));
		contenu.setBackground(new Color(255,255,255));
		
		/* Couleurs et bordures des JTextPanes */
		PLundi.setBorder(new LineBorder(new Color(0,0,0)));
		PMardi.setBorder(new LineBorder(new Color(0,0,0)));
		PMercredi.setBorder(new LineBorder(new Color(0,0,0)));
		PJeudi.setBorder(new LineBorder(new Color(0,0,0)));
		PVendredi.setBorder(new LineBorder(new Color(0,0,0)));
		PLundi.setEditable(false);
		PMardi.setEditable(false);
		PMercredi.setEditable(false);
		PJeudi.setEditable(false);
		PVendredi.setEditable(false);
		PLundi.setBackground(new Color(72,164,255));
		PMardi.setBackground(new Color(115,167,230));
		PMercredi.setBackground(new Color(72,164,255));
		PJeudi.setBackground(new Color(115,167,230));
		PVendredi.setBackground(new Color(72,164,255));
		contenu.add(PLundi);
		contenu.add(PMardi);
		contenu.add(PMercredi);
		contenu.add(PJeudi);
		contenu.add(PVendredi);
		
		fenetre.getContentPane().add(contenu,BorderLayout.CENTER);
		
		/* Menu */
		JMenuBar menu = new JMenuBar();
		JMenu mfichier = new JMenu("Fichier");
		JMenuItem envoiemail = new JMenuItem("Envoi email");
		JMenuItem quitter = new JMenuItem("Quitter");
		menu.add(mfichier);
		mfichier.add(envoiemail);
		mfichier.add(quitter);
		menu.add(mfichier);
		fenetre.setJMenuBar(menu);
		
		/* Action afficher la fenêtre mail */
		ActionListener actionmail = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Fenetremail.affiche_interface_mail();
				
			}
		};
		envoiemail.addActionListener(actionmail);
		
		/* Action fermer l'application par le menu */
		quitter.addActionListener(action.getFermerButton());
		
		/* Action actualiser la semaine en cours */
		ActionListener SemaineEnCours = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Jours Semaine = new Jours(maintenant);
				afficher_contenu(Semaine);
			}
		};
		this.LSemaine.addActionListener(SemaineEnCours);
		
		/* Action regarder la semaine suivante */
		ActionListener SemaineSuivante = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				maintenant.add(Calendar.WEEK_OF_YEAR,+1);
				Jours Semaine = new Jours(maintenant);
				afficher_contenu(Semaine);
			}
		};
		SemaineSuiv.addActionListener(SemaineSuivante);
		/* Action regarder la semaine précendente */
		ActionListener SemainePrecedente = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				maintenant.add(Calendar.WEEK_OF_YEAR,-1);
				Jours Semaine = new Jours(maintenant);
				afficher_contenu(Semaine);
				
			}
		};
		SemainePrec.addActionListener(SemainePrecedente);
		
		fenetre.setVisible(true);
		
		
	}
	
}

