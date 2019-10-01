package Interface;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            Windows, MyPanelDownload

class Bookmarks extends JFrame
{

    Bookmarks(Windows windows)
    {
        listScroller = new JScrollPane();
        adr = new JList();
        listModel = new DefaultListModel();
        nomAdr = new JLabel();
        ajoutButton = new JButton();
        effacButton = new JButton();
        okButton = new JButton();
        annulButton = new JButton();
        ajoutTextField = new JTextField();
        ajoutNom = new JTextField();
        ajoutLabel = new JLabel();
        nomLabel = new JLabel();
        selection = "";
        nom = "";
        win = windows;
        gerer();
    }

    void open()
    {
        int i = 0;
        String s = "";
        String as[] = new String[0xf4240];
        File file = new File("./.signets.dat");
        boolean flag = file.exists();
        if(!flag)
        {
            fermer(false);
            bookmark = new String[1];
            bookmark[0] = "";
        } else
        {
            try
            {
                FileReader filereader = new FileReader("./.signets.dat");
                BufferedReader bufferedreader = new BufferedReader(filereader);
                bufferedreader.readLine();
                as[i++] = bufferedreader.readLine();
                while(!"&FIN".equals(s)) 
                {
                    s = bufferedreader.readLine();
                    if(!"&FIN".equals(s) && !"".equals(s))
                        as[i++] = s;
                }
                bookmark = new String[i];
                for(int j = 0; j < i; j++)
                    bookmark[j] = as[j];

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

    void gerer()
    {
        getContentPane().setLayout(null);
        setTitle("Signets");
        setResizable(false);
        setBounds(100, 100, 400, 300);
        open();
        adr.setModel(listModel);
        listScroller.setBounds(15, 36, 165, 220);
        adr.setSelectionMode(0);
        adr.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent mouseevent)
            {
                selection = (String)adr.getSelectedValue();
                int j = 0;
                nom = "";
                for(; j < selection.length() && selection.charAt(j) != '#'; j++);
                if(j != selection.length())
                {
                    nom = selection.substring(j + 1, selection.length());
                    selection = selection.substring(0, j);
                }
                ajoutTextField.setText(selection);
                ajoutNom.setText(nom);
                if(mouseevent.getClickCount() == 2)
                {
                    win.download.adresse.setText(selection);
                    win.download.nom.setText(nom);
                    fermer(true);
                    dispose();
                }
            }

        });
        nomAdr.setText("Liste des adresses ");
        nomAdr.setBounds(33, 14, 160, 15);
        ajoutButton.setText("Ajouter");
        ajoutButton.setBounds(239, 192, 110, 23);
        ajoutButton.setFocusPainted(false);
        for(int i = 0; i < bookmark.length; i++)
            listModel.addElement(bookmark[i]);

        ajoutButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                String s = ajoutTextField.getText();
                if(!"".equals(ajoutNom.getText()) && !"".equals(s))
                    s = s + '#' + ajoutNom.getText();
                if(!"#".equals(s) && !"".equals(s))
                {
                    listModel.addElement(s);
                    ajoutTextField.setText("");
                    ajoutNom.setText("");
                }
                ajoutNom.setText("");
            }

        });
        ajoutTextField.setBounds(200, 44, 190, 19);
        ajoutLabel.setText("Adresse : ");
        ajoutLabel.setBounds(260, 26, 111, 15);
        ajoutNom.setBounds(200, 84, 190, 19);
        nomLabel.setText("Nom du fichier : ");
        nomLabel.setBounds(235, 65, 160, 15);
        okButton.setText("OK");
        okButton.setBounds(239, 112, 110, 23);
        okButton.setFocusPainted(false);
        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                if(!"".equals(ajoutTextField.getText()))
                {
                    String s = "";
                    selection = (String)adr.getSelectedValue();
                    int j;
                    for(j = 0; j < selection.length() && selection.charAt(j) != '#'; j++);
                    if(j != selection.length())
                    {
                        s = selection.substring(j + 1, selection.length());
                        selection = selection.substring(0, j);
                    }
                    win.download.adresse.setText(selection);
                    win.download.nom.setText(s);
                }
                fermer(true);
                dispose();
            }

        });
        effacButton.setText("Effacer");
        effacButton.setBounds(239, 152, 110, 23);
        effacButton.setFocusPainted(false);
        effacButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                if(selection != "")
                    if(nom != "")
                        listModel.removeElement(selection + "#" + nom);
                    else
                        listModel.removeElement(selection);
                ajoutTextField.setText("");
                ajoutNom.setText("");
                nom = "";
                selection = "";
            }

        });
        annulButton.setText("Annuler");
        annulButton.setBounds(239, 232, 110, 23);
        annulButton.setFocusPainted(false);
        annulButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionevent)
            {
                dispose();
            }

        });
        listScroller.getViewport().add(adr);
        getContentPane().add(listScroller);
        getContentPane().add(nomAdr);
        getContentPane().add(effacButton);
        getContentPane().add(ajoutButton);
        getContentPane().add(ajoutTextField);
        getContentPane().add(ajoutLabel);
        getContentPane().add(okButton);
        getContentPane().add(annulButton);
        getContentPane().add(ajoutNom);
        getContentPane().add(nomLabel);
        setVisible(true);
    }

    void fermer(boolean flag)
    {
        try
        {
            FileWriter filewriter = new FileWriter("./.signets.dat");
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);
            printwriter.println("&bookmark");
            if(flag)
            {
                int i = listModel.getSize();
                for(int j = 0; j < i; j++)
                    printwriter.println(listModel.get(j));

            }
            printwriter.println("");
            printwriter.println("&FIN");
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

    Windows win;
    static final int MAX_BOOKMARK = 0xf4240;
    static final String name = "./.signets.dat";
    JScrollPane listScroller;
    JList adr;
    DefaultListModel listModel;
    JLabel nomAdr;
    JButton ajoutButton;
    JButton effacButton;
    JButton okButton;
    JButton annulButton;
    JTextField ajoutTextField;
    JTextField ajoutNom;
    JLabel ajoutLabel;
    JLabel nomLabel;
    String selection;
    String nom;
    String bookmark[];
}
