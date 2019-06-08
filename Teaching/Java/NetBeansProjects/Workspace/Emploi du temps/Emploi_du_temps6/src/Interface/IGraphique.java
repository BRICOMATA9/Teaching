package Interface;

import static java.util.stream.Collectors.toList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import BDD.TP;
import DAO.EnseignantDAO;
import DAO.ModuleDAO;
import DAO.TPDAO;
import SQL.Recherche;

public class IGraphique implements ActionListener {

	private SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
	private GregorianCalendar maintenant = (GregorianCalendar) GregorianCalendar.getInstance();
	
	private JLabel    LLundi      = new JLabel();
	private JLabel    LMardi      = new JLabel();
	private JLabel    LMercredi   = new JLabel();
	private JLabel    LJeudi      = new JLabel();
	private JLabel    LVendredi   = new JLabel();
	private JButton   LSemaine    = new JButton();
	private JButton   SemainePrec = new JButton();
	private JButton   SemaineSuiv = new JButton();
	private JTextPane PLundi      = new JTextPane();
	private JTextPane PMardi      = new JTextPane();
	private JTextPane PMercredi   = new JTextPane();
	private JTextPane PJeudi      = new JTextPane();
	private JTextPane PVendredi   = new JTextPane();
	
  private static void AddtexttoPane(String[] initString,String[] initStyles, JTextPane textPane) {
    StyledDocument doc = textPane.getStyledDocument();
    try {
      for (int i=0; i < initString.length; i++) {
          doc.insertString(doc.getLength(), initString[i],doc.getStyle(initStyles[i]));
      }
    } catch (BadLocationException ble) {
      System.err.println("Couldn't insert initial text into text pane.");
    }
  }
  
  private void Addcourstojour(List<List<TP>> tabCours) throws Exception{
		int nbcours;
		JTextPane textpane;
		/* Calculer le nombre de cours */
		for(int jours=0;jours<5;jours++){
			List<TP> listec = tabCours.get(jours);
			nbcours = listec.size();
			String[] SJour = new String[8*nbcours];
			String[] StyleJour = new String[8*nbcours];
			int j =0;
			for (int i=0;i<=(nbcours*8)-1;i=i+8){
				//on va chercher les cours a afficher pour chaque jour
				TP c = listec.get(j);
				//type
				SJour[i]="  Type : "+(c.getIdGroupe()!=null?"TP":"Cours")+"\n";
				StyleJour[i]="cours";
				//Heure
				SJour[i+1]= "  Heure : "+formatterTime.format(c.getHeureDebut())+"\n  Durree : "+formatterTime.format(c.getDuree())+"\n";
				StyleJour[i+1]="horaire";
				//la matiere
				SJour[i+2]="  Module : "+ModuleDAO.getInstance().getById(c.getIdModule().getIdModule()).getNom()+"\n";
				StyleJour[i+2]="cours";
				//la salle
				SJour[i+3]="  Salle : "+c.getIdSalle().getIdSalle()+"\n";
				StyleJour[i+3]="salle";
				//le prof
				SJour[i+4]="  Prof : "+EnseignantDAO.getInstance().getById(c.getIdEnseignant().getIdPersonne()).getNom()+"\n";
				StyleJour[i+4]="prof";
				//le section
				SJour[i+5]="  Section : "+c.getIdSection().getIdSection()+"\n";
				StyleJour[i+5]="groupe";
				//le groupe
				SJour[i+6]=(c.getIdGroupe()==null?"":"  Groupe : "+c.getIdGroupe().getIdGroupe())+"\n";
				StyleJour[i+6]="groupe";
				//le delimitement
				SJour[i+7]="----------------------------------------------------------------------"+"\n";
				StyleJour[i+7]="cours";
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
  
  	public void afficher(){
  		afficher_contenu(new Jours(maintenant));
  	}

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
		SemainePrec.setText(" <  Semaine " + Semaine.getStringSemaineprec());
		SemaineSuiv.setText(" Semaine " + Semaine.getStringSemaineproch()+"  > ");
		
		addtolisteCours(Semaine);
	}

	public void addtolisteCours(Jours Semaine){
		try {
			List<List<TP>> liste_cours = visualiser_EDT(Semaine);
			Addcourstojour(liste_cours);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* methode qui trie les cours par jour dans la liste que l'on utilise */
	private List<List<TP>> trie_par_jour(List<TP> cours){
		String date="";
		List<List<TP>> liste_cours= new ArrayList<List<TP>>();
		for(int i = 0; i<cours.size(); i++) {
			//A chaque novelle date on ajoute un vecteur de cours
			if(cours.get(i).getDateDebut().toString().compareTo(date)!=0){
				liste_cours.add(new ArrayList<TP>());
				date = cours.get(i).getDateDebut().toString();
			}
			//On ajoute le cours au dernier vecteur de cours cree
			liste_cours.get(liste_cours.size()-1).add(cours.get(i));
		}
		return liste_cours;
	}
	
	/* methode qui envoi au client les cours qu'il a demandé */
	private List<List<TP>> visualiser_EDT(Jours Semaine) throws Exception {
		List<List<TP>> liste_cours = trie_par_jour(TPDAO.getInstance().getAll().collect(toList()));
		//System.out.println("list_cours"+service.getAllSeance());
		/* on recupere seulement ceux de la semaine desiree */
		List<List<TP>> tabCours = new ArrayList<List<TP>>();
		
		int j=1, i=0;
		//System.out.println(Semaine.getJours(j));
		Date jour = Semaine.getJours(j);
		while(i< liste_cours.size() && j<6){
			TP c = liste_cours.get(i).get(0);
			int test =c.compareJour(jour);
			if(test==0){
				tabCours.add(liste_cours.get(i));
				j++;
				jour = Semaine.getJours(j);
				i++;
			}
			else if(test<0){
				i++;
			}
			else if(test>0) {//liste_cours[i] apres le jour 
				tabCours.add(new ArrayList<TP>());
				j++;
				jour = Semaine.getJours(j);	
			}
		}
		
		while(tabCours.size()<5){
			tabCours.add(new Vector<TP>());
		}
		//System.out.println("tabCours"+tabCours);
		return tabCours;
	}

	public IGraphique(JFrame fenetre,Recherche service) {
		
		/* Trouver les jours de la semaine en cours */ 
		Jours Semaine = new Jours(maintenant);
		/* Labels et boutons NORD */
		JPanel headerpane =    new JPanel();
		headerpane.setLayout  (new BorderLayout());
		//LSemaine.setBackground(new Color(220,220,220));
		headerpane.add(SemainePrec,BorderLayout.WEST);
		headerpane.add(LSemaine,BorderLayout.CENTER);
		headerpane.add(SemaineSuiv,BorderLayout.EAST);
		
		afficher_contenu(Semaine);
		
		/* Contenu panels dates des jours */
		LLundi.setBorder(new LineBorder(new Color(0,0,0)));
		LLundi.setBackground(new Color(220,220,250));
		LMardi.setBorder(new LineBorder(new Color(0,0,0)));
		LMardi.setBackground(new Color(220,220,250));
		LMercredi.setBorder(new LineBorder(new Color(0,0,0)));
		LMercredi.setBackground(new Color(220,220,250));
		LJeudi.setBorder(new LineBorder(new Color(0,0,0)));
		LJeudi.setBackground(new Color(220,220,250));
		LVendredi.setBorder(new LineBorder(new Color(0,0,0)));
		LVendredi.setBackground(new Color(220,220,250));
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
		toppanel.add(headerpane  ,BorderLayout.NORTH);
		toppanel.add(JoursSemaine,BorderLayout.SOUTH);
		
		fenetre.getContentPane().add(toppanel,BorderLayout.NORTH);
		
		/* Panel qui regroupe les JTextPanes */
		JPanel contenu = new JPanel();
		contenu.setSize(800,400);
		contenu.setLayout(new GridLayout(1,5));
		//contenu.setBackground(new Color(0,0,0));
		
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
		PLundi.setBackground(new Color(220,220,250));
		PMardi.setBackground(new Color(220,220,250));
		PMercredi.setBackground(new Color(220,220,250));
		PJeudi.setBackground(new Color(220,220,250));
		PVendredi.setBackground(new Color(220,220,250));
		contenu.add(PLundi);
		contenu.add(PMardi);
		contenu.add(PMercredi);
		contenu.add(PJeudi);
		contenu.add(PVendredi);
		
		fenetre.getContentPane().add(contenu,BorderLayout.CENTER);

		LSemaine.addActionListener   (this);
		SemaineSuiv.addActionListener(this);
		SemainePrec.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
	    if (e.getSource()==LSemaine)
			afficher_contenu(new Jours(maintenant));
		else if (e.getSource()==SemaineSuiv){
			maintenant.add(Calendar.WEEK_OF_YEAR,+1);
			afficher_contenu(new Jours(maintenant));
		}else if (e.getSource()==SemainePrec){
			maintenant.add(Calendar.WEEK_OF_YEAR,-1);
			afficher_contenu(new Jours(maintenant));
		}
	}
}
