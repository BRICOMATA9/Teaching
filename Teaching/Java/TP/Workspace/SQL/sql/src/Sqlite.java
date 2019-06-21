
import java.sql.*;

public class Sqlite {
    private Connection con;
    private Statement st;
    private ResultSet rs;
   
    /** Creates a new instance of Sqlite */
    public Sqlite(String dbpath) {
        // driver to load
        try{
        Class.forName("org.sqlite.JDBC");
        //load driver
         con = DriverManager.getConnection("jdbc:sqlite:"+dbpath);
        System.out.println("eeeeeeeeeeeeeee");
        //to execute requet
         st = con.createStatement();
        //resultat
        rs = st.executeQuery("SELECT * FROM USERS ;");
        //show result
        this.show_result();
        
        con.close();
    }
        catch(Exception e){
            System.out.println("DB ERROR: "+e);
           
        }
    
}
    void show_result(){
        try{
        while(rs.next()){
            int id = rs.getInt("ID");
            String login = rs.getString("NAME");
            System.out.println("votre id est ="+id+"\nlogin est:"+login);
        }
    }catch(Exception e){
      System.out.println("Select Error:"+e);  
    }
}
} //class end
