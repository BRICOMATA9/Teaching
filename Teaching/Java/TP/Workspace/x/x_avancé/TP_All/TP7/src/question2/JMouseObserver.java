package question2;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.TextArea;

public class JMouseObserver implements MouseListener{

	private String nom;
	private TextArea contenu;

	public JMouseObserver(String nom, TextArea contenu) {
		this.nom = nom;
		this.contenu = contenu;
	}

	public void mouseClicked(MouseEvent e) {
	}

    public void mouseEntered(MouseEvent e) {
        String message = "L'observeur :"+this.nom+"souris entrée en ("+e.getX()+","+ e.getY()+")";
        contenu.append(message + "\n");
    }

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

}
