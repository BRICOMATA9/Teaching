package javamyadmin.Data;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Importer extends JDialog implements ActionListener{
	public JFileChooser fichier;
	public Box box1;

	public Importer(JFrame fen){
		super(fen,"BdAdministration-Importer",true);
		Container c=this.getContentPane();
		c.setLayout(new FlowLayout());
		box1=Box.createHorizontalBox();
		fichier=new JFileChooser();
		fichier.setFileSelectionMode(JFileChooser.FILES_ONLY);
		box1.add(fichier);
		c.add(box1);
		setBounds(150, 100,750, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		JOptionPane.showMessageDialog(null, e.getSource());   
  }
}
