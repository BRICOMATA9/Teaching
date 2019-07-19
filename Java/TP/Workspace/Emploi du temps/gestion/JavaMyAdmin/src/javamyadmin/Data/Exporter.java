package javamyadmin.Data;
import javax.swing.*;

public class Exporter extends JDialog{
	public Object s;
	public Exporter(JFrame fen){
		super(fen,"BdAdministration-Exporter",true);
		s=JOptionPane.showInputDialog(this, "Choisissez une base","Boite d'options",
																				JOptionPane.QUESTION_MESSAGE,
																				null,
																				Mysql.listData(),
																				Mysql.listData()[0]);
		try{
			Runtime.getRuntime().exec("mysqldump -h localhost -u root "+(String)s+" > "+(String)s+".sql");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		//String sql=new String("mysqldump -h localhost -u root "+(String)s+" > "+(String)s+".sql");
		//Mysql.executer(sql);
	}
}
