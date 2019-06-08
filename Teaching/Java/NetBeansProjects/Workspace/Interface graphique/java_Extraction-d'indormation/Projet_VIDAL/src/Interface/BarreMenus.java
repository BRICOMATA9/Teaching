package Interface;

import Aspiration.*;
import Transformation.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BarreMenus
{

    private Windows win;
    private Ouvrir ouvrir;
    private JMenuBar menuBar;
    private JMenu fichierMenu;
    private JMenu dictionnaireMenu;
    private JMenuItem ouvrirItem;
    private JMenuItem fermerItem;
    private JMenuItem quitterItem;
    private JMenuItem transformationItem;
    private JMenuItem aspirateurItem;
    
    public BarreMenus(Windows windows)
    {
        menuBar = new JMenuBar();
        fichierMenu = new JMenu("Fichier", true);
        fichierMenu.setToolTipText("Fichier");
        ouvrirItem = new JMenuItem("Ouvrir");
        fermerItem = new JMenuItem("Quitter");
                
        dictionnaireMenu = new JMenu("Dictionnaire", true);
        dictionnaireMenu.setToolTipText("Dictionnaire");
        aspirateurItem = new JMenuItem("Aspiration");
        transformationItem = new JMenuItem("Transformation au format DELA");
        quitterItem = new JMenuItem("Quitter");

        
        win = windows;
        
        fichierMenu.add(ouvrirItem);
        fichierMenu.addSeparator();
        fichierMenu.add(fermerItem);
        
        dictionnaireMenu.add(aspirateurItem);
        dictionnaireMenu.addSeparator();
        dictionnaireMenu.add(transformationItem);
        dictionnaireMenu.addSeparator();
        dictionnaireMenu.add(quitterItem);
        
        aspirateurItem.addActionListener(new MenuActionAdapter(windows));
        transformationItem.addActionListener(new MenuActionAdapter(windows));
        ouvrirItem.addActionListener(new MenuActionAdapter(windows));
        quitterItem.addActionListener(new MenuActionAdapter(windows));
        fermerItem.addActionListener(new MenuActionAdapter(windows));
        
        ouvrirItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        fermerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        aspirateurItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
        transformationItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
        quitterItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        
        menuBar.add(fichierMenu);
        menuBar.add(dictionnaireMenu);
        windows.setJMenuBar(menuBar);
    }

    void menuEvent(ActionEvent actionevent){
        String s = actionevent.getActionCommand();
        if("Quitter".equals(s))
            System.exit(0);
        else
        if("Ouvrir".equals(s)){
        	ouvrir =new Ouvrir(win,"Ouvrir");
          if(ouvrir.valide()==0)
          	try{
    					new Contenu(ouvrir.getpath());
						}catch (IOException e){
    					new Dialogue("aucun fichier ou dossier de ce type");
    				}
        }else
        if("Aspiration".equals(s))
            new Aspirateur(win);
        if("Transformation au format DELA".equals(s))
        		new Transformation(win);     
    }

}
