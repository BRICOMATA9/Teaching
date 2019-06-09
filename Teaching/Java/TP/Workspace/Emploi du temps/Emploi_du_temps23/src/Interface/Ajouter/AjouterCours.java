package Interface.Ajouter;

import static java.util.stream.Collectors.toList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import BDD.Cours;
import BDD.Salle;
import DAO.EnseignantDAO;
import DAO.ModuleDAO;
import DAO.SalleDAO;
import DAO.SectionDAO;
import Interface.Function;

@SuppressWarnings("serial")
public class AjouterCours extends JFrame implements ActionListener {

	JComboBox<Object> idModule;
	JComboBox<Object> idSalle;
	JComboBox<Object> salleBis;
	JComboBox<Object> idEnseignant;
	JComboBox<Object> idSection;
	JDateChooser dateDebut;
	JComboBox<Object> heureDebut;
	JComboBox<Object> durree;

	private final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	private String[] duree = {"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
			"13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30"};
	
	private String[] heure_ = {"08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
			"13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30"};
	
    JButton enregistrer;
    JButton annuler;
    private Function<Cours> function; 

    public AjouterCours(String s,Function<Cours> f) throws Exception{

		setTitle(s+" un Cours");
		setBounds(200, 200,360, 390);
		setVisible(true);
		function = f;
		
        JLabel module = new JLabel("Module");
        idModule = new JComboBox<Object>((Object[])ModuleDAO.getInstance().getId().toArray());
        idModule.addActionListener(this);
        
        JLabel enseignant = new JLabel("Enseignant");
        idEnseignant = new JComboBox<Object>((Object[])EnseignantDAO.getInstance().getId().toArray());
        idEnseignant.addActionListener(this);
        
        JLabel salleBis_ = new JLabel("Salle Voisine");
        salleBis = new JComboBox<Object>();
        salleBis.addActionListener(this);
        salleBis.insertItemAt(null, 0);
        salleBis.setSelectedIndex(0);
        
		JLabel date = new JLabel("Date :");
		dateDebut = new JDateChooser();
		dateDebut.setLocale(new Locale("fr","FR"));
		dateDebut.setDate(GregorianCalendar.getInstance().getTime());
		
        JLabel heure = new JLabel("De");
        heureDebut = new JComboBox<Object>(heure_);
        heureDebut.addActionListener(this);
        
        JLabel section = new JLabel("Section");
        idSection = new JComboBox<Object>((Object[])SectionDAO.getInstance().getId().toArray());
        idSection.addActionListener(this);
        
		JLabel durree_ = new JLabel("A");
		durree = new JComboBox<Object>(duree);
		durree.setSelectedItem("01:15");
		durree.addActionListener(this);
		
        JLabel salle = new JLabel("Salle");
        idSalle = new JComboBox<Object>((Object[])SalleDAO.getInstance().getIdDispo(dateDebut.getDate(),
        		(Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"),
        		(Date) formatTime.parse((String)durree.getSelectedItem()+":00")).toArray());
        idSalle.addActionListener(this);
        
		dateDebut.addPropertyChangeListener("date", new PropertyChangeListener() {
		    @Override
		    public void propertyChange(PropertyChangeEvent evt) {
		    	try{
			        Date date = (Date)evt.getNewValue();
			        Stream<Integer> o = SalleDAO.getInstance().getIdDispo(date,
			        		(Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"),
			        		(Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
			        List<Integer> l = o.collect(toList());
			        idSalle.removeAllItems();
		    		for(Integer i:l)
		    			idSalle.addItem(i);
		    		//idSalle.setSelectedIndex(0);
		    	}catch(Exception v){}
		    }
		});
 
		
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

        add(dateDebut,gbc,jp,1,0,1,1);
        add(heureDebut,gbc,jp,1,1,1,1);
        add(durree,gbc,jp,1,2,1,1);
        add(idSalle,gbc,jp,1,3,1,1);
        add(salleBis,gbc,jp,1,4,1,1);
        add(idModule,gbc,jp,1,5,1,1);
        add(idEnseignant,gbc,jp,1,6,1,1);
        add(idSection,gbc,jp,1,7,1,1);

        add(date,gbc,jp,0,0,1,1);
        add(heure,gbc,jp,0,1,1,1);
        add(durree_,gbc,jp,0,2,1,1);
        add(salle,gbc,jp,0,3,1,1);
        add(salleBis_,gbc,jp,0,4,1,1);
        add(module,gbc,jp,0,5,1,1);
        add(enseignant,gbc,jp,0,6,1,1);
        add(section,gbc,jp,0,7,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }
    
    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
		try{
	    	if (source==heureDebut){
		        Object[] o = SalleDAO.getInstance().getIdDispo(dateDebut.getDate(),
		        		(Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"),
		        		(Date) formatTime.parse((String)durree.getSelectedItem()+":00")).toArray();
	    		idSalle.removeAllItems();
	    		for(int i = 0;i<o.length;i++)
	    			idSalle.addItem(o[i]);
	    		//idSalle.setSelectedIndex(0);
	    	} else if (source==durree){
			        Object[] o = SalleDAO.getInstance().getIdDispo(dateDebut.getDate(),
			        		(Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"),
			        		(Date) formatTime.parse((String)durree.getSelectedItem()+":00")).toArray();
		    		idSalle.removeAllItems();
		    		for(int i = 0;i<o.length;i++)
		    			idSalle.addItem(o[i]);
		    		//idSalle.setSelectedIndex(0);
			}else if (source==idSalle){
				if(idSalle.getSelectedItem()!=null){
		    		Salle salle = SalleDAO.getInstance().getById(idSalle.getSelectedItem());
		    		salleBis.removeAllItems();
		    		salleBis.addItem(salle.getSuccesseur().getIdSalle());
		    		salleBis.addItem(salle.getPredecesseur().getIdSalle());
		            salleBis.insertItemAt(null, 0);
		            salleBis.setSelectedIndex(0);
				}
	    	}else if (source==enregistrer){
				Cours cours = new Cours();
				cours.setIdModule(ModuleDAO.getInstance().getById(idModule.getSelectedItem().toString()));
				cours.setIdSalle(SalleDAO.getInstance().getById(Integer.parseInt (idSalle.getSelectedItem().toString())));
				cours.setSalleBis(SalleDAO.getInstance().getById(salleBis.getSelectedItem()));
				cours.setIdEnseignant(EnseignantDAO.getInstance().getById(Integer.parseInt (idEnseignant.getSelectedItem().toString())));
				cours.setIdSection(SectionDAO.getInstance().getById(Integer.parseInt (idSection.getSelectedItem().toString())));
				cours.setDateDebut(dateDebut.getDate());
				cours.setHeureDebut((Date) formatTime.parse((String)heureDebut.getSelectedItem()+":00"));
				cours.setDuree((Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
				//CoursDAO.getInstance().ajouter(cours);
				if (function.apply(cours)) setVisible(false);
	    	}else if (source==annuler)
				setVisible(false);
		}catch(Exception eh){
			JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
    }

	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}
