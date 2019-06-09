package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import bdd.Personne;
import sql.DB;
import sql.Recherche;

@SuppressWarnings("serial")
public class Utilisateur extends JFrame {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
 
	public static void main(String[] args) {
		new Login();
    }
    
    public Utilisateur(DB db) {
        super("Authetification");
		centerFrame(this);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Utilisateur: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
		tfUsername.setText("login");
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Mot de passe: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
		pfPassword.setText("login");
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("OK");
 
        btnLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	try{
            			Recherche service = new Recherche(db);
            			Personne personne = service.login(getUsername(), getPassword());
						new EmploiDuTemps(personne,db);
						succeeded = true;
						//dispose();
            	}catch (Exception ex) {									
						JOptionPane.showMessageDialog(Utilisateur.this,ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
	                    // reset username and password
	                    tfUsername.setText("");
	                    pfPassword.setText("");
	                    succeeded = false;
 
                }
            }
        });
        btnCancel = new JButton("Annuler");
        
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        pack();

        setResizable(false);
        setVisible(true);
    }
 
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
    
    public boolean isSucceeded() {
        return succeeded;
    }

	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   frame.setLocation((screenSize.width / 2) - 150, (screenSize.height / 2) - 50);
	}
}