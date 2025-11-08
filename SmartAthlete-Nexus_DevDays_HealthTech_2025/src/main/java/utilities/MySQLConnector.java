package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector
{
    public static Connection connection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        String databaseName = "db_smartathlete", userName = "root", password = "root", URL2 = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        
        try
        {
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            throw e;
        }
        
        String ip = "localhost", url = "jdbc:mysql://" + ip + ":8889/" + databaseName + "?allowPublicKeyRetrieval=true&useSSL=false";
        
        try
        {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw e;
        }
        
        System.out.println("connection successful");
        
        return con;
    }

    public static void closeDatabaseConnection(Connection con) throws SQLException
    {
        try
        {
            if (con != null)
            {
                System.out.println("connection closed succesfully");
                con.close();
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw e;
        }
    }
}