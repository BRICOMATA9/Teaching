/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controleur.bouton_inscription;

/**
 *
 * @author Utilisateur
 */
public class Panel_connexion extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

    public Panel_connexion() {
        initComponents();
    }
    
              
    private void initComponents() {

        Panel_titre_connexion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel_connexion = new javax.swing.JPanel();
        bouton_connexion = new javax.swing.JButton();
        textfield_motdepasse_connexion = new javax.swing.JPasswordField();
        textfield_utilisateur_connexion = new javax.swing.JTextField();
        label_utilisateur_connexion = new javax.swing.JLabel();
        label_motdepasse_connexion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bouton_inscription = new javax.swing.JButton(new bouton_inscription());
        jLabel2 = new javax.swing.JLabel();
        textfield_motdepasse_inscription = new javax.swing.JPasswordField();
        textfield_username_inscription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Panel_gauche_connexion = new javax.swing.JPanel();
        Panel_web_connexion = new javax.swing.JPanel();

 
  
        jLabel1.setText("Bienvenue sur le gestionnaire de portefeuille des Gigaby'TSE");

        bouton_connexion.setText("Connexion");

      
        
        textfield_utilisateur_connexion.addKeyListener(new KeyListener(){
       	 
 			@Override
 			public void keyTyped(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_connexion.doClick();
 				}
 			}
 			@Override
 			public void keyPressed(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_connexion.doClick();
 				}		
 			}
 			@Override
 			public void keyReleased(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 				
 					bouton_connexion.doClick();
 				}		
 			}	
     });
         textfield_motdepasse_connexion.addKeyListener(new KeyListener(){

 			@Override
 			public void keyTyped(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_connexion.doClick();
				}				
 			}
 			@Override
 			public void keyPressed(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_connexion.doClick();
 				}			
 			}
 			@Override
 			public void keyReleased(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					System.out.println("entrée");
 					bouton_connexion.doClick();
 				}				
 			} 					
     });
       textfield_motdepasse_inscription.addKeyListener(new KeyListener(){
     	 

   			@Override
   			public void keyTyped(java.awt.event.KeyEvent e) {
   				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
   					bouton_inscription.doClick();
   				}   				
   			}
   			@Override
   			public void keyPressed(java.awt.event.KeyEvent e) {
   				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
   					bouton_inscription.doClick();
   				}   				
   			}
   			@Override
   			public void keyReleased(java.awt.event.KeyEvent e) {
   				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
   					System.out.println("entrée");
   					bouton_inscription.doClick();
   				}  				
   			}  			
       });
       textfield_username_inscription.addKeyListener(new KeyListener(){
 			@Override
 			public void keyTyped(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_inscription.doClick();
 				}		
 			}
 			@Override
 			public void keyPressed(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					bouton_inscription.doClick();
 				}		
 			}
 			@Override
 			public void keyReleased(java.awt.event.KeyEvent e) {
 				if (e.getKeyCode()== KeyEvent.VK_ENTER) {
 					System.out.println("entrée");
 					bouton_inscription.doClick();
 				} 				
 			}			
     });
       
        label_utilisateur_connexion.setText("Username");

        label_motdepasse_connexion.setText("Password");

        javax.swing.GroupLayout Panel_connexionLayout = new javax.swing.GroupLayout(Panel_connexion);
        Panel_connexion.setLayout(Panel_connexionLayout);
        Panel_connexionLayout.setHorizontalGroup(
            Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_connexionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfield_utilisateur_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_utilisateur_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_connexionLayout.createSequentialGroup()
                        .addComponent(textfield_motdepasse_connexion, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bouton_connexion))
                    .addGroup(Panel_connexionLayout.createSequentialGroup()
                        .addComponent(label_motdepasse_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        Panel_connexionLayout.setVerticalGroup(
            Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_connexionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_utilisateur_connexion)
                    .addComponent(label_motdepasse_connexion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_utilisateur_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfield_motdepasse_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bouton_connexion))
                .addContainerGap())
        );

        javax.swing.GroupLayout Panel_titre_connexionLayout = new javax.swing.GroupLayout(Panel_titre_connexion);
        Panel_titre_connexion.setLayout(Panel_titre_connexionLayout);
        Panel_titre_connexionLayout.setHorizontalGroup(
            Panel_titre_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_titre_connexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_titre_connexionLayout.setVerticalGroup(
            Panel_titre_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_connexion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_titre_connexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bouton_inscription.setText("Inscription");

        jLabel2.setText("Inscription");

     

        jLabel3.setText("Nom d'utilisateur :");

        jLabel4.setText("Mot de passe :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfield_username_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfield_motdepasse_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 103, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(bouton_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(136, 136, 136))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textfield_username_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfield_motdepasse_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(bouton_inscription)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Panel_web_connexion.setLayout(new javax.swing.OverlayLayout(Panel_web_connexion));

        javax.swing.GroupLayout Panel_gauche_connexionLayout = new javax.swing.GroupLayout(Panel_gauche_connexion);
        Panel_gauche_connexion.setLayout(Panel_gauche_connexionLayout);
        Panel_gauche_connexionLayout.setHorizontalGroup(
            Panel_gauche_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_gauche_connexionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel_web_connexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_gauche_connexionLayout.setVerticalGroup(
            Panel_gauche_connexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_web_connexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_gauche_connexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(448, 448, 448))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_titre_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel_titre_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(Panel_gauche_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }                      

    // Variables declaration - do not modify                     
    private javax.swing.JPanel Panel_connexion;
    private static javax.swing.JPanel Panel_gauche_connexion;
    private javax.swing.JPanel Panel_titre_connexion;
    private javax.swing.JPanel Panel_web_connexion;
    public static javax.swing.JButton bouton_connexion;
    public static javax.swing.JButton bouton_inscription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_motdepasse_connexion;
    private javax.swing.JLabel label_utilisateur_connexion;
    public static javax.swing.JPasswordField textfield_motdepasse_connexion;
    public static javax.swing.JPasswordField textfield_motdepasse_inscription;
    public static javax.swing.JTextField textfield_username_inscription;
    public static javax.swing.JTextField textfield_utilisateur_connexion;                  
}