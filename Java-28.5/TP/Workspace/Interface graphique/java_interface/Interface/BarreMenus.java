package Interface;

import Browser.Browser;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            MenuActionAdapter, Windows, Preferences, Ouvrir, 
//            Enregistrer, Bookmarks, Apropos, MyPanelTree, 
//            MyPanelDownload, MyPanelInfos

public class BarreMenus
{

    public BarreMenus(Windows windows, MyPanelTree mypaneltree, MyPanelDownload mypaneldownload, MyPanelInfos mypanelinfos)
    {
        menuBar = new JMenuBar();
        fichierMenu = new JMenu("Fichier", true);
        nouveauItem = new JMenuItem("Nouveau");
        ouvrirItem = new JMenuItem("Ouvrir");
        fermerItem = new JMenuItem("Fermer");
        enregistrerItem = new JMenuItem("Enregistrer");
        enregistrerssItem = new JMenuItem("Enregistrer sous");
        imprimerItem = new JMenuItem("Imprimer");
        quitterItem = new JMenuItem("Quitter");
        editionMenu = new JMenu("Edition", true);
        annulerItem = new JMenuItem("Annuler");
        couperItem = new JMenuItem("Couper");
        copierItem = new JMenuItem("Copier");
        collerItem = new JMenuItem("Coller");
        selectItem = new JMenuItem("Tout selectionner");
        optionMenu = new JMenu("Options", true);
        themesMenu = new JMenu("Themes", false);
        motifItem = new JMenuItem("Motif");
        metalItem = new JMenuItem("Metal");
        windowsItem = new JMenuItem("Windows");
        bookmarkItem = new JMenuItem("Signets");
        prefItem = new JMenuItem("Preferences");
        fenetreMenu = new JMenu("Fenetres", true);
        arbreItem = new JMenuItem("Hierarchie");
        proposMenu = new JMenu("A propos de...", true);
        proposItem = new JMenuItem("A propos de ce logiciel");
        aideItem = new JMenuItem("Aide...");
        win = windows;
        tree = mypaneltree;
        download = mypaneldownload;
        infos = mypanelinfos;
        fichierMenu.add(nouveauItem);
        nouveauItem.setMnemonic('n');
        fichierMenu.add(ouvrirItem);
        ouvrirItem.setMnemonic('o');
        fichierMenu.add(fermerItem);
        fermerItem.setMnemonic('w');
        fichierMenu.addSeparator();
        fichierMenu.add(enregistrerItem);
        enregistrerItem.setMnemonic('s');
        fichierMenu.add(enregistrerssItem);
        fichierMenu.add(imprimerItem);
        imprimerItem.setMnemonic('p');
        fichierMenu.addSeparator();
        fichierMenu.add(quitterItem);
        quitterItem.setMnemonic('q');
        editionMenu.add(annulerItem);
        annulerItem.setMnemonic('z');
        editionMenu.addSeparator();
        editionMenu.add(couperItem);
        couperItem.setMnemonic('x');
        editionMenu.add(copierItem);
        copierItem.setMnemonic('c');
        editionMenu.add(collerItem);
        collerItem.setMnemonic('v');
        editionMenu.add(selectItem);
        selectItem.setMnemonic('a');
        optionMenu.add(themesMenu);
        themesMenu.add(motifItem);
        themesMenu.add(metalItem);
        themesMenu.add(windowsItem);
        metalItem.setEnabled(false);
        optionMenu.add(bookmarkItem);
        bookmarkItem.setMnemonic('b');
        optionMenu.addSeparator();
        optionMenu.add(prefItem);
        prefItem.setMnemonic('r');
        fenetreMenu.add(arbreItem);
        proposMenu.add(proposItem);
        proposMenu.addSeparator();
        proposMenu.add(aideItem);
        aideItem.setMnemonic('h');
        motifItem.addActionListener(new MenuActionAdapter(windows));
        metalItem.addActionListener(new MenuActionAdapter(windows));
        windowsItem.addActionListener(new MenuActionAdapter(windows));
        quitterItem.addActionListener(new MenuActionAdapter(windows));
        nouveauItem.addActionListener(new MenuActionAdapter(windows));
        fermerItem.addActionListener(new MenuActionAdapter(windows));
        prefItem.addActionListener(new MenuActionAdapter(windows));
        ouvrirItem.addActionListener(new MenuActionAdapter(windows));
        enregistrerItem.addActionListener(new MenuActionAdapter(windows));
        enregistrerssItem.addActionListener(new MenuActionAdapter(windows));
        bookmarkItem.addActionListener(new MenuActionAdapter(windows));
        proposItem.addActionListener(new MenuActionAdapter(windows));
        arbreItem.addActionListener(new MenuActionAdapter(windows));
        aideItem.addActionListener(new MenuActionAdapter(windows));
        annulerItem.addActionListener(new MenuActionAdapter(windows));
        menuBar.add(fichierMenu);
        menuBar.add(editionMenu);
        menuBar.add(optionMenu);
        menuBar.add(fenetreMenu);
        menuBar.add(proposMenu);
        windows.setJMenuBar(menuBar);
    }

    public void decnbFenetres()
    {
        if(numero == nbFenetres)
            numero--;
        nbFenetres--;
        if(nbFenetres == 0)
            System.exit(0);
    }

    void menuEvent(ActionEvent actionevent)
    {
        String s = actionevent.getActionCommand();
        if("Motif".equals(s))
            theme(0);
        else
        if("Metal".equals(s))
            theme(1);
        else
        if("Windows".equals(s))
            theme(2);
        else
        if("Quitter".equals(s))
            System.exit(0);
        else
        if("Nouveau".equals(s))
        {
            numero++;
            nbFenetres++;
            new Windows("AspiWEB <" + numero + ">");
        } else
        if("Fermer".equals(s))
        {
            win.dispose();
            nbFenetres--;
            if(numero == numero)
                numero--;
            if(nbFenetres == 0)
                System.exit(0);
        } else
        if("Preferences".equals(s))
            new Preferences();
        else
        if("Ouvrir".equals(s))
            new Ouvrir(win);
        else
        if("Enregistrer".equals(s) || "Enregistrer sous".equals(s))
            new Enregistrer(win);
        else
        if("Signets".equals(s))
            new Bookmarks(win);
        else
        if("A propos de ce logiciel".equals(s))
            new Apropos(win);
        else
        if("Hierarchie".equals(s))
        {
            if(MyPanelTree.NUMERO_FENETRE == 0)
                tree = new MyPanelTree();
        } else
        if("Aide...".equals(s))
        {
            String s1 = System.getProperty("user.dir");
            new Browser("file:" + s1 + "/Aide/aide.html");
        } else
        if("Annuler".equals(s))
        {
            download.adresse.setText("");
            download.nom.setText("");
            infos.enCours.setText("");
            infos.telecharges.setText("");
        }
    }

    void theme(int i)
    {
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = true;
        switch(i)
        {
        case 0: // '\0'
            flag = false;
            win.look("Motif");
            break;

        case 1: // '\001'
            flag1 = false;
            win.look("Metal");
            break;

        case 2: // '\002'
            flag2 = false;
            win.look("Windows");
            break;
        }
        motifItem.setEnabled(flag);
        metalItem.setEnabled(flag1);
        windowsItem.setEnabled(flag2);
    }

    private Windows win;
    private MyPanelTree tree;
    private MyPanelDownload download;
    private MyPanelInfos infos;
    private static int numero = 0;
    private static int nbFenetres = 1;
    private final int MOTIF = 0;
    private final int METAL = 1;
    private final int WINDOWS = 2;
    JMenuBar menuBar;
    JMenu fichierMenu;
    JMenuItem nouveauItem;
    JMenuItem ouvrirItem;
    JMenuItem fermerItem;
    JMenuItem enregistrerItem;
    JMenuItem enregistrerssItem;
    JMenuItem imprimerItem;
    JMenuItem quitterItem;
    JMenu editionMenu;
    JMenuItem annulerItem;
    JMenuItem couperItem;
    JMenuItem copierItem;
    JMenuItem collerItem;
    JMenuItem selectItem;
    JMenu optionMenu;
    JMenu themesMenu;
    JMenuItem motifItem;
    JMenuItem metalItem;
    JMenuItem windowsItem;
    JMenuItem bookmarkItem;
    JMenuItem prefItem;
    JMenu fenetreMenu;
    JMenuItem arbreItem;
    JMenu proposMenu;
    JMenuItem proposItem;
    JMenuItem aideItem;

}
