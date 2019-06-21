package afficher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Afficher <T> extends JFrame implements ActionListener {
	
	private JList<DefaultListModel<T>> jliste;

	public Afficher (String titre,List<T> liste){
	
		JPanel pan1=new JPanel();
	    pan1.setLayout(new BorderLayout());
	    DefaultListModel<T> model = new DefaultListModel<T>();
	
		for (T elm: liste) model.addElement(elm);
	
	    jliste = new JList(model);
	
	    JScrollPane pane = new JScrollPane(jliste);
		
	    pan1.add(pane, BorderLayout.CENTER);
	
	    setContentPane(pan1);

		setTitle(titre);
		setBounds(200, 200,900, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

	}
}


 