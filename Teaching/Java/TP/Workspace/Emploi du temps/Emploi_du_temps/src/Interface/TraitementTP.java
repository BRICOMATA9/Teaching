package Interface;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import BDD.TP;
import DAO.EnseignantDAO;
import DAO.GroupeDAO;
import DAO.ModuleDAO;
import DAO.SalleDAO;
import DAO.SectionDAO;

@SuppressWarnings("serial")
public class TraitementTP extends JFrame implements ActionListener {

	JComboBox<Object> idModule;
	JComboBox<Object> idSalle;
	JComboBox<Object> salleBis;
	JComboBox<Object> idEnseignant;
	JComboBox<Object> idSection;
	JComboBox<Object> idGroupe;
	JDateChooser dateDebut;
	JComboBox<Object> heureDebut;
	JComboBox<Object> durree;
	int i = 16;

	private final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	private String[] duree = {"00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15"
							,"02:30","02:45","03:00","03:30","04:00","05:00","06:00"};
	
	private String[] heure_ = {"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
			"13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30"};
	
    JButton enregistrer;
    JButton annuler;
    private Function<TP> function; 

    public TraitementTP(String s,Function<TP> f) throws Exception{

		setTitle(s+" un TP");
		setBounds(200, 200,360, 390);
		setVisible(true);
		function = f;
		
        JLabel module = new JLabel("Module");
        idModule = new JComboBox<Object>((Object[])ModuleDAO.getInstance().getId().toArray());
         
        JLabel enseignant = new JLabel("Enseignant");
        idEnseignant = new JComboBox<Object>((Object[])EnseignantDAO.getInstance().getId().toArray());
        
        JLabel salle = new JLabel("Salle");
        idSalle = new JComboBox<Object>((Object[])SalleDAO.getInstance().getId().toArray());
        
        JLabel salleBis_ = new JLabel("Salle Voisine");
        salleBis = new JComboBox<Object>((Object[])SalleDAO.getInstance().getId().toArray());
        salleBis.addActionListener(this);
        salleBis.insertItemAt(null, 0);
        
        JLabel groupe = new JLabel("Groupe");
        idGroupe = new JComboBox<Object>((Object[])GroupeDAO.getInstance().getId().toArray());
        
		JLabel date = new JLabel("Date :");
		dateDebut = new JDateChooser();
		dateDebut.setLocale(new Locale("fr","FR"));
		dateDebut.setDate(GregorianCalendar.getInstance().getTime());
		
        JLabel heure = new JLabel("Heure");
        heureDebut = new JComboBox<Object>(heure_);
        
        JLabel section = new JLabel("Section");
        idSection = new JComboBox<Object>((Object[])SectionDAO.getInstance().getId().toArray());
        
		JLabel durree_ = new JLabel("Duree :");
		durree = new JComboBox<Object>(duree);
		durree.setSelectedItem("01:15");
 
        enregistrer = new JButton(s);
        enregistrer.addActionListener(this);
        
        annuler = new JButton("Annuler");
        annuler.addActionListener(this);
                
        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();

        JPanel jp = new JPanel();
        jp.setLayout(gbl);
        contentPane.add(jp);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        add(idModule,gbc,jp,1,0,1,1);
        add(idSalle,gbc,jp,1,1,1,1);
        add(salleBis,gbc,jp,1,2,1,1);
        add(idEnseignant,gbc,jp,1,3,1,1);
        add(idSection,gbc,jp,1,4,1,1);
        add(idGroupe,gbc,jp,1,5,1,1);
        add(dateDebut,gbc,jp,1,6,1,1);
        add(heureDebut,gbc,jp,1,7,1,1);
        add(durree,gbc,jp,1,8,1,1);

        add(module,gbc,jp,0,0,1,1);
        add(salle,gbc,jp,0,1,1,1);
        add(salleBis_,gbc,jp,0,2,1,1);
        add(enseignant,gbc,jp,0,3,1,1);
        add(section,gbc,jp,0,4,1,1);
        add(groupe,gbc,jp,0,5,1,1);
        add(date,gbc,jp,0,6,1,1);
        add(heure,gbc,jp,0,7,1,1);
        add(durree_,gbc,jp,0,8,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				TP tp = new TP();
				tp.setIdModule(ModuleDAO.getInstance().getById(idModule.getSelectedItem().toString()));
				tp.setIdSalle(SalleDAO.getInstance().getById(idSalle.getSelectedItem().toString()));
				tp.setSalleBis(SalleDAO.getInstance().getById(salleBis.getSelectedItem().toString()));
				tp.setIdEnseignant(EnseignantDAO.getInstance().getById(idEnseignant.getSelectedItem().toString()));
				tp.setIdSection(SectionDAO.getInstance().getById(idSection.getSelectedItem().toString()));
				tp.setIdGroupe(GroupeDAO.getInstance().getById(idGroupe.getSelectedItem().toString()));
				tp.setDateDebut(dateDebut.getDate());
				tp.setHeureDebut((Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"));
				tp.setDuree((Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
				if (function.apply(tp)) setVisible(false);
			}catch(Exception eh){
				JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
			}
    	}else if (source==annuler)
			setVisible(false);
    }

	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}

