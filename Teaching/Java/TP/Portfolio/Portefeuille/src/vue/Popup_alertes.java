package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import modele.Gestion_alertes;
import modele.ModeleDynamiqueObjet;

public class Popup_alertes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JSpinner spinner;
	public Popup_alertes(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
	}

	private void initComponent(){


		JPanel panelcombobox = new JPanel();
		panelcombobox.setBackground(Color.white);
		panelcombobox.setPreferredSize(new Dimension(300, 80));
		panelcombobox.setBorder(BorderFactory.createTitledBorder("Poser une alerte sur  "+Panel_interface.tableau.getValueAt(Panel_interface.tableau.getSelectedRow(), 0)));
		JLabel label = new JLabel();
		JLabel label2= new JLabel();
		label.setText("Valeur d'alerte");
		label2.setText("euros");
		spinner = new JSpinner();
		spinner.setValue(50);
		panelcombobox.add(label);
		panelcombobox.add(spinner);
		panelcombobox.add(label2);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panelcombobox);


		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");
		JButton cancelBouton = new JButton("Annuler");
		control.add(okBouton);
		control.add(cancelBouton);



		spinner.addKeyListener(new KeyListener() { 

			@Override
			public void keyTyped(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {

					okBouton.doClick();
				}

			}

			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {
					okBouton.doClick();
				}

			}

			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
				if (e.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER) {

					okBouton.doClick();
				}

			}		
		});
		okBouton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) { 
				String entreprise = Panel_interface.tableau.getValueAt(Panel_interface.tableau.getSelectedRow(), 0).toString();

				for(int i=0;i<Panel_interface.tableau.getRowCount();i++){
					if(Panel_interface.tableau.getValueAt(i, 0).equals(entreprise)){
						if(Double.parseDouble(Panel_interface.tableau.getValueAt(i, 3).toString().replace("euros",""))>Double.parseDouble(spinner.getValue().toString())){
							Date date= new Date();
							DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
									DateFormat.SHORT,
									DateFormat.MEDIUM);

							Gestion_alertes.enregistreralerte(entreprise,Integer.parseInt(spinner.getValue().toString()),shortDateFormat.format(date));
							ModeleDynamiqueObjet.row_a_colorier .add(i);
							Panel_interface.modele.fireTableDataChanged();
							setVisible(false);	
						}
						else{
							Date date= new Date();
							DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
									DateFormat.SHORT,
									DateFormat.MEDIUM);

							Gestion_alertes.enregistreralerte(entreprise,Integer.parseInt(spinner.getValue().toString()),shortDateFormat.format(date));
							setVisible(false);
						}

					}
				}

			}

		});
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		this.getContentPane().add(content, BorderLayout.NORTH);
		this.getContentPane().add(control, BorderLayout.SOUTH);

		this.setVisible(true); 
	} 
}