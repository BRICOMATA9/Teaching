package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(null /* null est à remplacer */);
        boutons.add(add);   add.addActionListener(null /* null est à remplacer */);
        boutons.add(sub);   sub.addActionListener(null /* null est à remplacer */);
        boutons.add(mul);   mul.addActionListener(null /* null est à remplacer */);
        boutons.add(div);   div.addActionListener(null /* null est à remplacer */);
        boutons.add(clear); clear.addActionListener(null /* null est à remplacer */);
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        // à compléter
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    // à compléter
    // en cas d'exception comme division par zéro, mauvais format de nombre
    // la pile reste en l'état (intacte)

}
