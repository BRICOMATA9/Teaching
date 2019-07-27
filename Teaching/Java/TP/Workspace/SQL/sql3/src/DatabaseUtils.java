import java.sql.*;
import java.util.*;

/**
 * util.DatabaseUtils
 * User: Michael
 * Date: Aug 17, 2010
 * Time: 7:58:02 PM
 */
public class DatabaseUtils
{
    private static final String DEFAULT_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@host:1521:database";
    private static final String DEFAULT_USERNAME = "system";
    private static final String DEFAULT_PASSWORD = "adel?";
/*
    private static final String DEFAULT_DRIVER = "org.postgresql.Driver";
    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/party";
    private static final String DEFAULT_USERNAME = "pgsuper";
    private static final String DEFAULT_PASSWORD = "pgsuper";
*/
/*
    private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/party";
    private static final String DEFAULT_USERNAME = "party";
    private static final String DEFAULT_PASSWORD = "party";
*/

    public static void main(String[] args)
    {
        long begTime = System.currentTimeMillis();

        String driver = ((args.length > 0) ? args[0] : DEFAULT_DRIVER);
        String url = ((args.length > 1) ? args[1] : DEFAULT_URL);
        String username = ((args.length > 2) ? args[2] : DEFAULT_USERNAME);
        String password = ((args.length > 3) ? args[3] : DEFAULT_PASSWORD);

        Connection connection = null;

        try
        {
            connection = createConnection(driver, url, username, password);
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println(meta.getDatabaseProductName());
            System.out.println(meta.getDatabaseProductVersion());

            //String sqlQuery = "SELECT PERSON_ID, FIRST_NAME, LAST_NAME FROM PERSON ORDER BY LAST_NAME";
            //System.out.println("before insert: " + query(connection, sqlQuery, Collections.EMPTY_LIST));

            //connection.setAutoCommit(false);
            //String sqlUpdate = "INSERT INTO PERSON(FIRST_NAME, LAST_NAME) VALUES(?,?)";
            //List parameters = Arrays.asList( "Foo", "Bar" );
            //int numRowsUpdated = update(connection, sqlUpdate, parameters);
            //connection.commit();

            //System.out.println("# rows inserted: " + numRowsUpdated);
            //System.out.println("after insert: " + query(connection, sqlQuery, Collections.EMPTY_LIST));
        }
        catch (Exception e)
        {
            rollback(connection);
            e.printStackTrace();
        }
        finally
        {
            close(connection);
            long endTime = System.currentTimeMillis();
            System.out.println("wall time: " + (endTime - begTime) + " ms");
        }
    }

    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException
    {
        Class.forName(driver);

        if ((username == null) || (password == null) || (username.trim().length() == 0) || (password.trim().length() == 0))
        {
            return DriverManager.getConnection(url);
        }
        else
        {
            return DriverManager.getConnection(url, username, password);
        }
    }

    public static void close(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void close(Statement st)
    {
        try
        {
            if (st != null)
            {
                st.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.rollback();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> map(ResultSet rs) throws SQLException
    {
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

        try
        {
            if (rs != null)
            {
                ResultSetMetaData meta = rs.getMetaData();
                int numColumns = meta.getColumnCount();
                while (rs.next())
                {
                    Map<String, Object> row = new HashMap<String, Object>();
                    for (int i = 1; i <= numColumns; ++i)
                    {
                        String name = meta.getColumnName(i);
                        Object value = rs.getObject(i);
                        row.put(name, value);
                    }
                    results.add(row);
                }
            }
        }
        finally
        {
            close(rs);
        }

        return results;
    }

    public static List<Map<String, Object>> query(Connection connection, String sql, List<Object> parameters) throws SQLException
    {
        List<Map<String, Object>> results = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            ps = connection.prepareStatement(sql);

            int i = 0;
            for (Object parameter : parameters)
            {
                ps.setObject(++i, parameter);
            }

            rs = ps.executeQuery();
            results = map(rs);
        }
        finally
        {
            close(rs);
            close(ps);
        }

        return results;
    }

    public static int update(Connection connection, String sql, List<Object> parameters) throws SQLException
    {
        int numRowsUpdated = 0;

        PreparedStatement ps = null;

        try
        {
            ps = connection.prepareStatement(sql);

            int i = 0;
            for (Object parameter : parameters)
            {
                ps.setObject(++i, parameter);
            }

            numRowsUpdated = ps.executeUpdate();
        }
        finally
        {
            close(ps);
        }

        return numRowsUpdated;
    }
}