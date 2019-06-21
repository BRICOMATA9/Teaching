package javamyadmin.Interface;

import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;

import javamyadmin.Data.*;
import javamyadmin.Model.Module;

public class Afficher <T> extends JFrame implements ActionListener {
	public JList jliste;
	private ServiceEmploi service;
	private String titre;

	public <T> Afficher (String titre,List<T> liste){
		
		this.titre=titre;
		service = new ServiceEmploi();

		JPanel pan1=new JPanel();
    pan1.setLayout(new BorderLayout());
    DefaultListModel model = new DefaultListModel();

		for (T elm: liste) model.addElement(elm);

    jliste = new JList(model);

    JScrollPane pane = new JScrollPane(jliste);
	
    pan1.add(pane, BorderLayout.CENTER);

    setContentPane(pan1);

		setTitle(titre);
		setBounds(100, 100,500, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

	}
}


 
