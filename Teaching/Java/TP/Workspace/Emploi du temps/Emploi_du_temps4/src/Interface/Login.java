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

import sql.DB;

@SuppressWarnings("serial")
public class Login extends JFrame {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JTextField baseDonee;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
 
	public static void main(String[] args) {
		new Login();
    }
    
    public Login() {
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
		tfUsername.setText("root");
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
		pfPassword.setText("aghiles");
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        
        JLabel lbd = new JLabel("Base de donnee: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbd, cs);
        
        baseDonee = new JTextField(20);;
        baseDonee.setText("upec");
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(baseDonee, cs);
        
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("OK");
 
        btnLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	try{
            		DB db = DB.getInstance(getUsername(), getPassword(),getBaseDonee());
            		if (db!=null) {
            			//db.Execute_DB("use upec");
						new Utilisateur(db);
						succeeded = true;
						dispose();
					} 
            		else {}
            	}catch (Exception ex) {									
						JOptionPane.showMessageDialog(Login.this,ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
	                    // reset username and password
	                    tfUsername.setText("");
	                    pfPassword.setText("");
	                    baseDonee.setText("");
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
 
    public String getBaseDonee() {
        return baseDonee.getText().trim();
    }
    
    public boolean isSucceeded() {
        return succeeded;
    }

	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   frame.setLocation((screenSize.width / 2) - 150, (screenSize.height / 2) - 50);
	}
}