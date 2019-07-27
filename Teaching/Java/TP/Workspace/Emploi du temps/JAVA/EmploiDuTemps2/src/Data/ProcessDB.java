package Data;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ProcessDB {
	public boolean Execute_DB(Connection conn, String query) {
		java.sql.Statement st;
		int ir = 0;
		try {
			st = conn.createStatement();
			ir = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ir > 0)
			return true;
		return false;
	}

	public ResultSet Get_DB(Connection conn, String query) throws Exception{
		java.sql.Statement st;
		ResultSet rs = null;
		try {
			st =  conn.createStatement();
			rs =  st.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
