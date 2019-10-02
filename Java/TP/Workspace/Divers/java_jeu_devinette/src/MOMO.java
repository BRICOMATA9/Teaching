import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MOMO extends JFrame {
 DEVINETTE d=new DEVINETTE();
 private JPanel contentPane;
 private JTextField textField;
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
     MOMO frame = new MOMO();
     frame.setVisible(true);
    } 
    catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }
 
 public MOMO() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 362, 209);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  final JLabel lab = new JLabel("");
  lab.setFont(new Font("Tempus Sans ITC", Font.BOLD, 50));
  lab.setBounds(52, 45, 83, 91);
  contentPane.add(lab);
  JButton b = new JButton("OK");
  b.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {				
    d.go(Integer.parseInt(textField.getText()));			
    lab.setText(String.valueOf(d.nb));
    textField.setText("");			
   }
  });
  b.setBounds(254, 144, 89, 23);
  contentPane.add(b);
		
  JButton btnNewButton_1 = new JButton("exit");
  btnNewButton_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    System.exit(0);			
   }
  });
  btnNewButton_1.setBounds(155, 144, 89, 23);
  contentPane.add(btnNewButton_1);
		
  textField = new JTextField();
  textField.setBounds(155, 70, 181, 20);
  contentPane.add(textField);
  textField.setColumns(10);
		
  JLabel lblNewLabel =new JLabel("deviner un nombre");
  lblNewLabel.setBounds(155, 45, 181, 14);
  contentPane.add(lblNewLabel);		
 }
}
