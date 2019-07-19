package Interface.Modifier;

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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDD.Section;
import DAO.SectionDAO;

@SuppressWarnings("serial")
public class ModifierSection extends JFrame implements ActionListener {

	JComboBox<Object> idSection;
	JTextField annee;

    JButton enregistrer;
    JButton annuler;

	private SimpleDateFormat formatterDate = new SimpleDateFormat("yy");
	
    public ModifierSection(){

		setTitle("Modifier une promotion");
		setBounds(200, 200,270, 320);
		setVisible(true);

        JLabel section = new JLabel("Promotion");
        idSection = new JComboBox<Object>((Object[])SectionDAO.getInstance().getId().toArray());
        
        JLabel annee_ = new JLabel("Annee");
        annee = new JTextField(10);
 
        enregistrer = new JButton("Enregistrer");
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

        add(idSection,gbc,jp,1,0,1,1);
        add(annee,gbc,jp,1,1,1,1);

        add(section,gbc,jp,0,0,1,1);
        add(annee_,gbc,jp,0,1,1,1);

		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
			try{
				Section promo = new Section();
				promo.setIdSection(Integer.parseInt(idSection.getSelectedItem().toString()));
				promo.setAnnee((Date) formatterDate.parse(annee.getText()));
				SectionDAO.getInstance().modifier(promo);
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
}
