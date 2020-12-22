package JDBC;

import java.sql.*;

import java.util.ArrayList;




public class getInformation
{
    Connection connection;
    Statement statement;

    public getInformation(Connection connection) throws SQLException 
    {
        this.connection = connection;
        this.statement = connection.createStatement();
    }
    
    
    public String getRoot_directoryInfo(String id_root_directory) throws SQLException {
        String query = "select id_root_directory, title\n" +
                "from root_directory\n" +
                "where id_root_directory = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_root_directory));
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String x ="";
        String id ="";
        String title ="";
        
        
        while (resultSet.next())
        {
        	
        	id = resultSet.getString(1);
            title = resultSet.getString(2);
            System.out.format("+---------------------+--+---------------------------+\n");
            System.out.format("|ID root_directory: %s|\t|Title: %s|\n",id,title);
            System.out.format("+---------------------+--+---------------------------+\n");
        }

        return  x;
    }
    
    public String getChild_directoryInfo(String id_child_directory) throws SQLException {
        String query = "select id_child_directory, id_root_directory, title from child_directory where id_child_directory = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_child_directory));
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String x ="";
        String id2 ="";
        String id_root_directory ="";
        String title ="";
        
        while (resultSet.next())
        {
        	
        	id2 = resultSet.getString(1);
        	id_root_directory = resultSet.getString(2);
            title = resultSet.getString(3);
            
            System.out.format("+----------------+--+-----------------------------------------------------------------------+\n");
            System.out.format("|ID directory: %s|\t|id_root_directory: %s|\t|Title: %s|\n", id2,id_root_directory,title);
            System.out.format("+----------------+--+-----------------------------------------------------------------------+\n");
        }

        return x;
    }
    
    public String getDelite(String table ,String id) throws SQLException 
    {
    	try 
    	{
    		
    			String query = "DELETE FROM "+ table +" where id_"+ table +" ="+ id +"";
    			statement.executeUpdate(query);
    			//System.out.println(query);
    	
    	}
    	catch (Exception e)
    	{
    		System.out.println("Erorr Delite\n");
    		
    	}
    	
    	 String x="DELITE SUCCESSFUL!\n";
		return x;
    }
    
    
    public String getRoot_directory() throws SQLException {
        String query = "select * from root_directory";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();
 
        while (resultSet.next()){
            String id_root_directory = resultSet.getString(1);
            String title = resultSet.getString(2);
            

            System.out.format("+--------------------+--+------------------------------------------+\n");
            System.out.format("|id root_directory: %s|\t|Title: %s|\t\n", id_root_directory,title);
            System.out.format("+--------------------+--+------------------------------------------+\n");
        }

       
        return result.toString();
    }
    
    public String getfiles() throws SQLException {
        String query = "select * from files";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id_files = resultSet.getString(1);
            String id_chd=resultSet.getString(2);
            String Title = resultSet.getString(3);
            String extension = resultSet.getString(4);
            String Size = resultSet.getString(5);
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.format("|id_file:  %s|\t |id_ch_directory: %s|\t |Title: %s| |Extension:  %s|\t |Size: %s| \n",id_files,id_chd,Title,extension,Size);
            
        }

       
        return result.toString();
    }
    
    
    
    public String getSearch_files(String extension) throws SQLException {
    	String query = "select * from files where extension = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(extension));
        ResultSet resultSet = preparedStatement.executeQuery();

       
        String out="";
        
        while (resultSet.next())
        {
        	String id_files = resultSet.getString(1);
            String id_chd=resultSet.getString(2);
            String Title = resultSet.getString(3);
            String extension1 = resultSet.getString(4);
            String Size = resultSet.getString(5);
            
            out = "File: "+ id_files +"|"+ id_chd +"|"+ Title +"|"+ extension1 +"|"+ Size +"";
            
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("|                                      Searching Results                                                                      |");
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.format("|    id_file:  %s|\t |id_ch_directory: %s|\t |Title: %s| |Extension:  %s|\t |Size: %s| \n",id_files,id_chd,Title,extension1,Size);
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|\n");
            
            
        }

       
        return out;
    }
   
    
    public String getChild_directory() throws SQLException {
        String query = "select * from child_directory";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next())
        {
        	String id_Child_directory = resultSet.getString(1);
        	String id_root_directory = resultSet.getString(2);
        	String title = resultSet.getString(3);
            
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.format("|id_Child_directory:  %s|\t |id_root_directory: %s| |Title directory:  %s|\t \n", id_Child_directory,id_root_directory,title);

        }       
        return result.toString();     
    }
   
 }
  
