package Interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogue extends JFrame
{

    public Dialogue(String s)
    {
        label1 = s;
        int i = JOptionPane.showConfirmDialog(this, s, null, -1, 2, null);
    }

    String label1;
}
