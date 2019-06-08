package Interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogue extends JFrame{
    public Dialogue(String s){
    	JOptionPane.showConfirmDialog(this, s, "Message", -1, 1, null);
    }
}