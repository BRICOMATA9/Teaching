package sql;

import java.sql.*;
import javax.swing.*;

public class DB {

	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static DB mysql;

	private DB(String user,String mdp) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost",user,mdp);
	}

	public static DB getInstance(String user,String psw) throws Exception{
		if (mysql == null)
			mysql = new DB(user,psw);
		return mysql;
	}

	public Connection getConnection(){
		return con;
	}

	public boolean Execute_DB(String query) {
		int ir = 0;
		try {
			st = con.createStatement();
			ir = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ir > 0)
			return true;
		return false;
	}

	public ResultSet Get_DB(String query) throws Exception{
		try {
			st =  con.createStatement();
			rs =  st.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void fermerConnexion(){
		try{
			if(con!=null){
				 rs.close();
				 st.close();
				 con.close();
			}
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}
}
