package Interface.Supprimer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BDD.Batiment;
import BDD.Cours;
import BDD.Enseignant;
import BDD.Etudiant;
import BDD.Groupe;
import BDD.Module;
import BDD.Salle;
import BDD.Section;
import BDD.TP;
import DAO.BatimentDAO;
import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.GroupeDAO;
import DAO.ModuleDAO;
import DAO.SalleDAO;
import DAO.SectionDAO;
import DAO.TPDAO;

@SuppressWarnings("serial")
public class Supprimer <T> extends JFrame implements ActionListener {

	JComboBox<Object> supprimer;

    JButton enregistrer;
    JButton annuler;

    public Supprimer(Supplier<Stream<T>> f){

		setTitle("Supprimer");
		setBounds(200, 200,970, 100);
		setVisible(true);

        JLabel label = new JLabel("Supprimer ");
        supprimer = new JComboBox<Object>(f.get().toArray()); 
 
        enregistrer = new JButton("Supprimer");
        enregistrer.addActionListener(this);

        annuler = new JButton("Annuler");
        annuler.addActionListener(this);
                
        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();

        JPanel jp = new JPanel();
        jp.setLayout(gbl);
        contentPane.add(jp);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        
       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
        add(supprimer,gbc,jp,2,0,1,1);

        add(label,gbc,jp,0,0,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

	public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
				try{
					if(supprimer.getSelectedItem() instanceof Enseignant)
						EnseignantDAO.getInstance().supprimer((Enseignant)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Etudiant)
						EtudiantDAO.getInstance().supprimer((Etudiant)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Module)
						ModuleDAO.getInstance().supprimer((Module)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Groupe)
						GroupeDAO.getInstance().supprimer((Groupe)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Section)
						SectionDAO.getInstance().supprimer((Section)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof TP)
						TPDAO.getInstance().supprimer((TP)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Cours)
						CoursDAO.getInstance().supprimer((Cours)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Salle)
						SalleDAO.getInstance().supprimer((Salle)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Batiment)
						BatimentDAO.getInstance().supprimer((Batiment)supprimer.getSelectedItem());
					else if(supprimer.getSelectedItem() instanceof Batiment)
						BatimentDAO.getInstance().supprimer((Batiment)supprimer.getSelectedItem());
					setVisible(false);
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

/*	private void supprimer(T elm){
		Object o=JOptionPane.showInputDialog(this, "Choisissez la base que vous voulez supprimer",
			"Boite d'options",JOptionPane.QUESTION_MESSAGE,null, elm.toArray(), null);
		//Mysql.executer("use "+(String)o);
		Mysql.supprimer("Drop database "+(String)o+";");
	}*/
}
