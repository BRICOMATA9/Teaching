import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MySQL client
 * @author Fobec 2010
 */
public class test3 {

    private String dbURL = "jdbc:mysql://localhost";
    private String user = "aghiles";
    private String password = "aghilesDJ35B";
    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;

    /**
     * Constructeur
     * @param url
     * @param user
     * @param password
     */
    public test3(String url, String user, String password) {
        this.dbURL = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Connecter à la base de donnée
     * @return false en cas d'échec
     */
    public Boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.dbConnect = DriverManager.getConnection("jdbc:mysql:" + this.dbURL, this.user, this.password);
            this.dbStatement = this.dbConnect.createStatement();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Executer une requete SQL
     * @param sql
     * @return resultat de la requete
     */
    public ResultSet exec(String sql) {
        try {
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Fermer la connexion au serveur de DB
     */
    public void close() {
        try {
            this.dbStatement.close();
            this.dbConnect.close();
            this.dbConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Exemple d'utilisation de la class
     * @param args
     */
    public static void main(String[] args) {
        test3 mysqlCli = new test3("//localhost", "aghiles", "aghilesDJ35B");
        if (mysqlCli.connect()) {
            try {
            	ResultSet rs = mysqlCli.exec("USE gentoo");
                rs = mysqlCli.exec("SELECT * FROM developers");
                if (rs != null) {
                    while (rs.next()) {
                        System.out.println("Valeur: " + rs.getString(1));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(test3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Mysql connection failed !!!");
        }
        mysqlCli.close();
    }
}





