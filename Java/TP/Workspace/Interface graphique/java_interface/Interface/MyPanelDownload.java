package Interface;

import Algorithme.Telechargement;
import Algorithme.Verrou;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.PrintStream;
import javax.swing.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            ButtonListener, KeyAction, Windows, MyPanelInfos, 
//            MyPanelTree

class MyPanelDownload extends JPanel
{

    MyPanelDownload(Windows windows, Telechargement telechargement, MyPanelTree mypaneltree, MyPanelInfos mypanelinfos)
    {
        adresse = new JTextField();
        nom = new JTextField();
        adresseLabel = new JLabel("Adresse :");
        nomLabel = new JLabel("Fichier :");
        tel = new JButton("Telecharger");
        stop = new JButton("Arreter");
        annuler = new JButton("Annuler");
        win = windows;
        telechar = telechargement;
        tree = mypaneltree;
        infos = mypanelinfos;
        setLayout(null);
        setBackground(new Color(200, 235, 200));
        tel.addActionListener(new ButtonListener(windows));
        stop.addActionListener(new ButtonListener(windows));
        annuler.addActionListener(new ButtonListener(windows));
        adresseLabel.setBounds(10, 30, 80, 18);
        adresse.setBounds(90, 29, 350, 22);
        nomLabel.setBounds(10, 70, 80, 18);
        nom.setBounds(90, 69, 200, 22);
        tel.setBounds(30, 100, 140, 25);
        tel.setFocusPainted(false);
        stop.setBounds(180, 100, 120, 25);
        stop.setFocusPainted(false);
        annuler.setBounds(310, 100, 120, 25);
        annuler.setFocusPainted(false);
        adresse.addKeyListener(new KeyAction(this, mypaneltree, mypanelinfos, telechargement, verrou, windows));
        nom.addKeyListener(new KeyAction(this, mypaneltree, mypanelinfos, telechargement, verrou, windows));
        add(adresseLabel);
        add(adresse);
        add(nomLabel);
        add(nom);
        add(tel);
        add(stop);
        add(annuler);
    }

    void buttonPressed(ActionEvent actionevent)
    {
        String s = actionevent.getActionCommand();
        if("Telecharger".equals(s) && !"".equals(win.adresse()))
        {
            verrou = new Verrou(win, infos);
            telechar = new Telechargement(win, adresse.getText(), nom.getText(), 0, tree, verrou);
            telechar.start();
            infos.enCours.setText(String.valueOf(Integer.parseInt(infos.enCours.getText()) + 1));
        } else
        if("Arreter".equals(s))
            System.out.println();
        else
        if("Annuler".equals(s))
        {
            adresse.setText("");
            nom.setText("");
            infos.enCours.setText("0");
            infos.telecharges.setText("0");
        }
    }

    Windows win;
    Telechargement telechar;
    MyPanelTree tree;
    MyPanelInfos infos;
    public JTextField adresse;
    public JTextField nom;
    public JLabel adresseLabel;
    public JLabel nomLabel;
    private JButton tel;
    private JButton stop;
    private JButton annuler;
    Verrou verrou;
}
