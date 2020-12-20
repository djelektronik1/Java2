package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect 
{
	
    private static String url = "jdbc:mysql://localhost/project?serverTimezone=Europe/Moscow&useSSL=false";
    private static String user = "root";
    private static String password = "root";

    @SuppressWarnings("unused")
	private static Connection con;
    @SuppressWarnings("unused")
	private static Statement stmt;
    @SuppressWarnings("unused")
	private static ResultSet rs;

    public Connection get_connection() 
    {
        Connection connection = null;
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
        return connection;
    }
}