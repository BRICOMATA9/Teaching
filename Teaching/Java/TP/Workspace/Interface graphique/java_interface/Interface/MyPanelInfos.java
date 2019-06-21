package Interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            Windows

public class MyPanelInfos extends JPanel
{

    public MyPanelInfos(Windows windows)
    {
        enCours = new JTextField("0", 4);
        telecharges = new JTextField("0", 4);
        win = windows;
        infos(windows);
    }

    public void infos(Windows windows)
    {
        JLabel jlabel = new JLabel("Nombre de fichiers en cours de telechargement : ");
        JLabel jlabel1 = new JLabel("Nombre de fichiers telecharges : ");
        setLayout(null);
        setBackground(Color.red);
        jlabel.setBounds(10, 10, 390, 18);
        enCours.setBounds(400, 10, 25, 18);
        enCours.setEditable(false);
        jlabel1.setBounds(10, 40, 300, 18);
        telecharges.setBounds(400, 40, 25, 18);
        telecharges.setEditable(false);
        add(jlabel);
        add(enCours);
        add(jlabel1);
        add(telecharges);
    }

    Windows win;
    public JTextField enCours;
    public JTextField telecharges;
}
