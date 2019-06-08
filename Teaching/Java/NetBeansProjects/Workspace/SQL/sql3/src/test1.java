//export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar
//mysql -u root -h localhost -p
//mysql -u root -p
//grant all privileges on gentoo.* to aghiles@localhost identified by "aghilesDJ35B";
//flush privileges;
//INSERT INTO developers (job, name) VALUES('outsourced', 'Jane Doe');
//INSERT INTO developers VALUES('Joe Smith', 'joesmith@gentoo.org', 'toolchain');

//export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar
//export ORACLE_HOME=/usr/lib/oracle/11.2/client
//export LD_LIBRARY_PATH=$ORACLE_HOME/lib
//export PATH=$PATH:$ORACLE_HOME/bin
//export ORACLE_BASE=/usr/lib/oracle
//export ORACLE_OWNR=aghiles
//xhost +SI:localuser:oracle


import java.sql.*;
import java.util.Properties;

public class test1
{
  // The JDBC Connector Class.
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  // Connection string. emotherearth is the database the program
  // is connecting to. You can include user and password after this
  // by adding (say) ?user=paulr&password=paulr. Not recommended!

  private static final String CONNECTION =
                          "jdbc:mysql://localhost";

  public static void main(String[] args) throws
                             ClassNotFoundException,SQLException
  {
    System.out.println(dbClassName);
    // Class.forName(xxx) loads the jdbc classes and
    // creates a drivermanager class factory
    Class.forName(dbClassName);

    // Properties for user and password. Here the user and password are both 'paulr'
    Properties p = new Properties();
    p.put("user","aghiles");
    p.put("password","aghilesDJ35B");

    // Now try to connect
    Connection c = DriverManager.getConnection(CONNECTION,p);

    System.out.println("It works !");
    c.close();
    }
}
