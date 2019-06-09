package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppletteQuestion2 extends JApplet {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");
    private boolean testSouris = true; 
    private TextArea contenu = new TextArea(60, 80);

    public void init() {

        JRootPane rootPane = this.getRootPane();
        rootPane.putClientProperty("defeatSystemEventQueueCheck", Boolean.TRUE);
        try {
            testSouris = getParameter("mouse").equals("oui");
        } catch (Exception e) {}
        
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu);

        if (testSouris)
            enHaut.setBackground(Color.magenta);
        else
            enHaut.setBackground(Color.blue);

        // l'initiation des observateurs
	   JButtonObserver jbo1 = new JButtonObserver("jbo1", contenu);
	   JButtonObserver jbo2 = new JButtonObserver("jbo2", contenu);
	   JButtonObserver jbo3 = new JButtonObserver("jbo3", contenu);
	   // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
	   boutonA.addActionListener(jbo1);
	   boutonA.addActionListener(jbo2);
	   boutonA.addActionListener(jbo3);
	   // le bouton B a 2 observateurs jbo1 et jbo2
	   boutonB.addActionListener(jbo1);
	   boutonB.addActionListener(jbo2);

       // le bouton C a 1 observateur jbo1
       boutonC.addActionListener(jbo1);

       if (testSouris) { // à compléter en q2.2
           // le bouton A a 1 observateur jmo1
           boutonA.addMouseListener(new JMouseObserver("jmo1", contenu));
           // le bouton B a 1 observateur jmo2
           boutonB.addMouseListener(new JMouseObserver("jmo2", contenu));
           // le bouton C a 1 observateur jmo3
           boutonC.addMouseListener(new JMouseObserver("jmo3", contenu));
       }
    }

}
