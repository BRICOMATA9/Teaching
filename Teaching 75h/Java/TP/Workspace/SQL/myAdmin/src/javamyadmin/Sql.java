  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javamyadmin;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author khalid
 */
public class Sql extends JDialog implements ActionListener
{
     public Box box1,box2;
     public JButton button1;
     public JTextArea sql;
     public Object s;
     public Sql(JFrame fen)
            {
                super(fen,"BdAdministration-SQL",true);
                Container c=getContentPane();
                c.setLayout(new FlowLayout());
                sql=new JTextArea(7, 40);
                button1=new JButton("Executer");
                button1.addActionListener(this);
                box1=Box.createHorizontalBox();
                box2=Box.createHorizontalBox();
                box1.add(sql);
                box2.add(button1);
                c.add(box1);
                c.add(box2);
                s=JOptionPane.showInputDialog(this, "Choisissez une base","Boite d'options",JOptionPane.QUESTION_MESSAGE,null, new Mysql().listData(), new Mysql().listData()[0]);
                setBounds(150, 200,750, 300);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setVisible(true);
            }
public void actionPerformed(ActionEvent e)
  {
      if(e.getSource()==button1)
      {
          Mysql a;
          JDialog d;
          JLabel label;
          Box b;
          JList liste;
          a=new Mysql(0);
          String ch=sql.getText();
          a.executer("use "+(String)s);
          String tab[]=a.executerSQL(ch);
          if(tab!=null)
          {
          d=new JDialog(this,"resultat de la requete",true);
          b=Box.createVerticalBox();
          liste=new JList(tab);
          label=new JLabel("Résultat de la requete : "+ch);
          b.add(label);
          b.add(liste);
          d.add(b);
          d.setBounds(200, 150,600, 500);
          d.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          d.setVisible(true);
          }
      }
  }
}
