package sql;

import java.sql.*;
import javax.swing.*;

//Singleton
public class DB {

	//Declaration des attributs
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static DB mysql;

	//Constructeur qui prend en argument le login et le mot de passe de la base de donnée
	private DB(String user,String mdp) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost",user,mdp);
	}

	//methode statique pour instansier notre singleton
	public static DB getInstance(String user,String psw) throws Exception {
		if (mysql == null)
			mysql = new DB(user,psw);
		return mysql;
	}

	//metohde pour executer les commandes SQL
	public boolean Execute_DB(String query) throws Exception {
		int ir = 0;
		st = con.createStatement();
		ir = st.executeUpdate(query);

		if (ir > 0)
			return true;
		return false;
	}

	//metohde pour executer les requetes SQL
	public ResultSet Get_DB(String query) throws Exception{
		st =  con.createStatement();
		rs =  st.executeQuery(query);
		return rs;
	}

	//metohode pour fermer la connexion a la base de donnée
	public void fermerConnexion() throws Exception {
		if(con!=null){
			 rs.close();
			 st.close();
			 con.close();
		}
	}
}
