package Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

class Preferences extends JFrame
{

    public Preferences()
    {
        frame = new JFrame("Preferences");
        tabbedPane = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        gbl = new GridLayout(2, 1);
        selectAll = new JRadioButton("Tous les types de fichiers", true);
        indiv = new JRadioButton("Seulement les types selectionnes", false);
        videos = new JCheckBox("Videos", false);
        sons = new JCheckBox("Audios", false);
        images = new JCheckBox("Images", false);
        textes = new JCheckBox("Textes", true);
        programmes = new JCheckBox("Programmes", false);
        archives = new JCheckBox("Archives", false);
        ext = new boolean[8];
        timeout = new JTextField();
        niveau = new JTextField();
        oui = new JCheckBox("oui");
        non = new JCheckBox("non");
        thread = new JTextField();
        rec = new JTextField();
        prop = new boolean[2];
        login = new JTextField();
        password = new JPasswordField();
        frame.setSize(520, 350);
        tabbedPane.setSize(520, 330);
        frame.getContentPane().setLayout(gbl);
        tabbedPane.addTab("Extensions", panel1);
        tabbedPane.addTab("Proprietes", panel3);
        tabbedPane.addTab("Identification", panel4);
        tabbedPane.setBackground(FOND);
        frame.getContentPane().add(tabbedPane, "Center");
        open(ext);
        extensions(panel1);
        proprietes(panel3);
        boutons(panel2);
        identification(panel4);
        tabbedPane.setSize(520, 330);
        frame.setResizable(false);
        frame.getContentPane().add(tabbedPane);
        frame.getContentPane().add(panel2);
        tabbedPane.setVisible(true);
        frame.setVisible(true);
    }

    void close()
    {
        frame.dispose();
    }

    void boutons(JPanel jpanel)
    {
        JButton jbutton = new JButton("OK");
        JButton jbutton1 = new JButton("Annuler");
        JButton jbutton2 = new JButton("Aide");
        jpanel.setSize(5, 10);
        jpanel.setLayout(null);
        jpanel.setBackground(FOND);
        jbutton.setBounds(60, 40, 120, 30);
        jbutton.setFocusPainted(false);
        jbutton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                ext[0] = selectAll.isSelected();
                ext[1] = indiv.isSelected();
                ext[2] = videos.isSelected();
                ext[3] = sons.isSelected();
                ext[4] = images.isSelected();
                ext[5] = textes.isSelected();
                ext[6] = programmes.isSelected();
                ext[7] = archives.isSelected();
                prop[0] = oui.isSelected();
                prop[1] = non.isSelected();
                fermer(ext);
                close();
            }

        });
        jbutton1.setBounds(190, 40, 120, 30);
        jbutton1.setFocusPainted(false);
        jbutton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                close();
            }

        });
        jbutton2.setBounds(320, 40, 120, 30);
        jbutton2.setFocusPainted(false);
        jpanel.add(jbutton, null);
        jpanel.add(jbutton1, null);
        jpanel.add(jbutton2, null);
    }

    void open(boolean aflag[])
    {
        File file = new File("./.pref.conf");
        boolean flag = file.exists();
        if(!flag)
        {
            aflag[0] = true;
            aflag[1] = false;
            aflag[2] = false;
            aflag[3] = false;
            aflag[4] = false;
            aflag[5] = false;
            aflag[6] = false;
            aflag[7] = false;
            timeout.setText("5");
            niveau.setText("3");
            prop[0] = false;
            prop[1] = true;
            thread.setText("5");
            login.setText("");
            password.setText("");
            fermer(aflag);
        } else
        {
            try
            {
                FileReader filereader = new FileReader("./.pref.conf");
                BufferedReader bufferedreader = new BufferedReader(filereader);
                for(int i = 0; i < 8; i++)
                    aflag[i] = "true".equals(bufferedreader.readLine());

                bufferedreader.readLine();
                timeout.setText(bufferedreader.readLine());
                niveau.setText(bufferedreader.readLine());
                prop[0] = "true".equals(bufferedreader.readLine());
                prop[1] = "true".equals(bufferedreader.readLine());
                thread.setText(bufferedreader.readLine());
                bufferedreader.readLine();
                login.setText(bufferedreader.readLine());
                filereader.close();
                bufferedreader.close();
            }
            catch(IOException ioexception)
            {
                System.out.println("Impossible de lire le fichier" + ioexception);
                System.exit(0);
            }
        }
    }

    void fermer(boolean aflag[])
    {
        try
        {
            FileWriter filewriter = new FileWriter("./.pref.conf");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);
            for(int i = 0; i < 8; i++)
                printwriter.println(aflag[i]);

            printwriter.println("");
            printwriter.println(timeout.getText());
            printwriter.println(niveau.getText());
            for(int j = 0; j < 2; j++)
                printwriter.println(prop[j]);

            printwriter.println(thread.getText());
            printwriter.println("");
            printwriter.println(login.getText());
            printwriter.flush();
            printwriter.close();
            bufferedwriter.close();
            filewriter.close();
        }
        catch(IOException ioexception)
        {
            System.out.println("Impossible d'ecrire le fichier " + ioexception);
            System.exit(0);
        }
    }

    void extensions(JPanel jpanel)
    {
        ButtonGroup buttongroup = new ButtonGroup();
        jpanel.setLayout(null);
        jpanel.setBackground(FOND);
        selectAll.setBounds(30, 14, 300, 22);
        selectAll.setFocusPainted(false);
        selectAll.setSelected(ext[0]);
        selectAll.setBackground(FOND);
        indiv.setBounds(30, 36, 300, 22);
        indiv.setFocusPainted(false);
        indiv.setSelected(ext[1]);
        indiv.setBackground(FOND);
        buttongroup.add(selectAll);
        buttongroup.add(indiv);
        videos.setBounds(50, 70, 150, 22);
        videos.setFocusPainted(false);
        videos.setSelected(ext[2]);
        videos.setBackground(FOND);
        sons.setBounds(200, 70, 150, 22);
        sons.setFocusPainted(false);
        sons.setSelected(ext[3]);
        sons.setBackground(FOND);
        images.setBounds(350, 70, 150, 22);
        images.setFocusPainted(false);
        images.setSelected(ext[4]);
        images.setBackground(FOND);
        textes.setBounds(50, 100, 150, 22);
        textes.setFocusPainted(false);
        textes.setSelected(ext[5]);
        textes.setBackground(FOND);
        programmes.setBounds(200, 100, 150, 22);
        programmes.setFocusPainted(false);
        programmes.setSelected(ext[6]);
        programmes.setBackground(FOND);
        archives.setBounds(350, 100, 150, 22);
        archives.setFocusPainted(false);
        archives.setSelected(ext[7]);
        archives.setBackground(FOND);
        jpanel.add(selectAll, null);
        jpanel.add(indiv, null);
        jpanel.add(videos, null);
        jpanel.add(sons, null);
        jpanel.add(images, null);
        jpanel.add(textes, null);
        jpanel.add(programmes, null);
        jpanel.add(archives, null);
    }

    void proprietes(JPanel jpanel)
    {
        JLabel jlabel = new JLabel("Delai : ");
        JLabel jlabel1 = new JLabel("Niveau de recursivite : ");
        JLabel jlabel2 = new JLabel("Changement de site : ");
        ButtonGroup buttongroup = new ButtonGroup();
        JLabel jlabel3 = new JLabel("Nombre de telechargements simultanes : ");
        jpanel.setLayout(null);
        jpanel.setBackground(FOND);
        jlabel.setBounds(10, 10, 70, 10);
        timeout.setBounds(70, 8, 30, 18);
        jlabel3.setBounds(130, 10, 350, 12);
        thread.setBounds(460, 8, 30, 18);
        jlabel1.setBounds(10, 60, 200, 10);
        niveau.setBounds(190, 58, 30, 18);
        jlabel2.setBounds(225, 60, 180, 12);
        oui.setBounds(395, 59, 50, 15);
        oui.setBackground(FOND);
        oui.setSelected(prop[0]);
        oui.setFocusPainted(false);
        non.setBounds(445, 59, 50, 15);
        non.setBackground(FOND);
        non.setSelected(prop[1]);
        non.setFocusPainted(false);
        buttongroup.add(oui);
        buttongroup.add(non);
        jpanel.add(timeout);
        jpanel.add(jlabel);
        jpanel.add(niveau);
        jpanel.add(jlabel1);
        jpanel.add(jlabel2);
        jpanel.add(oui);
        jpanel.add(non);
        jpanel.add(jlabel3);
        jpanel.add(thread);
    }

    void identification(JPanel jpanel)
    {
        JLabel jlabel = new JLabel("Nom             : ");
        JLabel jlabel1 = new JLabel("Mot de passe : ");
        jpanel.setLayout(null);
        jpanel.setBackground(FOND);
        jlabel.setBounds(50, 50, 150, 15);
        login.setBounds(170, 48, 150, 20);
        jlabel1.setBounds(50, 80, 150, 15);
        password.setBounds(170, 78, 150, 20);
        jpanel.add(jlabel);
        jpanel.add(login);
        jpanel.add(jlabel1);
        jpanel.add(password);
    }

    private static final int x = 520;
    private static final int y = 330;
    private static final int MAXEXT = 8;
    private static final int MAXPROP = 2;
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private static final Color FOND = new Color(200, 235, 200);
    private final String name = "./.pref.conf";
    private GridLayout gbl;
    private JRadioButton selectAll;
    private JRadioButton indiv;
    private JCheckBox videos;
    private JCheckBox sons;
    private JCheckBox images;
    private JCheckBox textes;
    private JCheckBox programmes;
    private JCheckBox archives;
    public boolean ext[];
    private JTextField timeout;
    private JTextField niveau;
    private JCheckBox oui;
    private JCheckBox non;
    private JTextField thread;
    private JTextField rec;
    public boolean prop[];
    JTextField login;
    JPasswordField password;











}
