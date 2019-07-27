package question2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextArea;

public class JButtonObserver implements ActionListener {

	private String nom;
	private TextArea contenu;

	public JButtonObserver(String nom, TextArea contenu) {
		this.nom = nom;
		this.contenu = contenu;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        String message = "L'observeur :"+this.nom+"du bouton :"+e.getActionCommand(); 
        contenu.append(message + "\n");
    } 

}

