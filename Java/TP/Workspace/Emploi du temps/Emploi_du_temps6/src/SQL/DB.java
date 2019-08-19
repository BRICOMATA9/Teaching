package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class DB {

	//Declaration des attributs
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static DB mysql;

	//Constructeur qui prend en argument le login et le mot de passe de la base de donnée
	private DB(String user,String mdp,String bd) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/"+bd,user,mdp);
	}

	//methode statique pour instansier notre singleton
	public static DB getInstance(String user,String psw,String bd) throws Exception {
		if (mysql == null)
			mysql = new DB(user,psw,bd);
		return mysql;
	}
	
	public static DB getInstance(){
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
	
	public List<String> listData()throws Exception{
		List<String> list = new ArrayList<String>();
		ResultSet result = Get_DB("show databases");
		while (result.next())
			list.add(result.getString(1));
		return list;
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

	public Connection getConnection() {
		return con;
	}
}
