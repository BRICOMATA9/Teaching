package Interface;

	import static java.util.stream.Collectors.toList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BDD.Groupe;
import BDD.Salle;
import DAO.GroupeDAO;
import DAO.SalleDAO;

	@SuppressWarnings("serial")
	public class AfficherSalleByGroupe <T> extends JFrame implements ActionListener {

		JComboBox<Object> supprimer;
		private JList<Salle> jliste;
		private DefaultListModel<Salle> model;

	    JButton enregistrer;
	    JButton annuler;

	    public AfficherSalleByGroupe() throws Exception{

			setTitle("Rcherche");
			setBounds(200, 200,970, 300);
			setVisible(true);

	        JLabel label = new JLabel("Recherche ");
	        supprimer = new JComboBox<Object>(GroupeDAO.getInstance().getAll().toArray());
	 
	        enregistrer = new JButton("Recherche ");
	        enregistrer.addActionListener(this);

	        annuler = new JButton("Annuler");
	        annuler.addActionListener(this);

	        Container contentPane = getContentPane();
	        GridBagLayout gbl = new GridBagLayout();

	        JPanel jp = new JPanel();
	        jp.setLayout(gbl);
	        contentPane.add (jp, BorderLayout.NORTH);

	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.weightx = 0;
	        gbc.weighty = 0;
	        
	       	Insets inset = new Insets(10,10,5,5); 
	        gbc.insets = inset;

	        gbc.anchor = GridBagConstraints.NORTH;
	        gbc.fill = GridBagConstraints.HORIZONTAL; 
	        
	        add(supprimer,gbc,jp,2,0,1,1);

	        add(label,gbc,jp,0,0,1,1);
	        
			JPanel pan1=new JPanel();
		    pan1.setLayout(new BorderLayout());
		    model = new DefaultListModel<Salle>();
		    		
		    Stream<Salle> liste = SalleDAO.getInstance().getSalleByGroupe((Groupe)supprimer.getSelectedItem());
			for (Salle elm: liste.collect(toList())) model.addElement(elm);
		    jliste = new JList<Salle>(model);
		    
		    JScrollPane pane = new JScrollPane(jliste);
		    pan1.add(pane, BorderLayout.CENTER);
		    getContentPane().add (pan1, BorderLayout.CENTER);

			JPanel jp2 = new JPanel();
			jp2.add (enregistrer);
			jp2.add (annuler);

			getContentPane().add (jp2, BorderLayout.SOUTH);
					
	 }

		public void actionPerformed(ActionEvent e){
	    	Object source = e.getSource();
	    	if (source==enregistrer){
					try{
					    Stream<Salle> liste = SalleDAO.getInstance().getSalleByGroupe((Groupe)supprimer.getSelectedItem());
					    model.removeAllElements();
						for (Salle elm: liste.collect(toList())) model.addElement(elm);
						jliste.removeAll();
						jliste.setModel(model);
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


