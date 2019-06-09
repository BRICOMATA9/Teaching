/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import javax.swing.JFrame;

/**
 *
 * @author kiyth
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame objet = new JFrame();
        Gameplay gameplay = new Gameplay(); 
        objet.setTitle("game");
        objet.setBounds(10, 10, 700, 600);
        objet.setVisible(true);
        objet.setResizable(false);
        objet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objet.add(gameplay);
    }
    
}
