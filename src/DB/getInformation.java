package DB;


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
    
    
    public String getClientInfo(String id_client) throws SQLException {
        String query = "select FIO, contact_information\n" +
                "from client\n" +
                "where id_client = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_client));
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String x ="";
        String Fio ="";
        String Contact ="";
        
        
        while (resultSet.next())
        {
        	
            Fio = resultSet.getString(1);
            Contact = resultSet.getString(2);
            System.out.format("+------------+--+--------------------------------------------------------------------------+\n");
            System.out.format("|ID client: %s|\t|Fio: %s|\t|contact information: %s|\n", id_client,Fio,Contact);
            System.out.format("+------------+--+--------------------------------------------------------------------------+\n");
        }

        return x;
    }
    
    public String getProviderInfo(String id_provider) throws SQLException {
        String query = "select adress, contact_information, title from provider where id_provider = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_provider));
        ResultSet resultSet = preparedStatement.executeQuery();
        
        String x ="";
        String adress ="";
        String Contact ="";
        String title ="";
        
        while (resultSet.next())
        {
        	
        	adress = resultSet.getString(1);
            Contact = resultSet.getString(2);
            title = resultSet.getString(3);
            
            System.out.format("+--------------+--+---------------------------------------------------------------------------+\n");
            System.out.format("|ID provider: %s|\t|Adress: %s|\t|contact information: %s|\n", id_provider,adress,Contact,title);
            System.out.format("+--------------+--+---------------------------------------------------------------------------+\n");
        }

        return x;
    }
    
    public String getDelite(String table ,String id) throws SQLException 
    {
    	try 
    	{
    		if(table == "provider") 
    		{
    			String query = "DELETE FROM incoming where provider_id ="+ id +"";
    			statement.executeUpdate(query);
    			query = "DELETE FROM "+ table +" where id_"+ table +" ="+ id +"";
    			statement.executeUpdate(query);
    			//System.out.println(query);
               
    	    }
    		else 
    		{
    			String query = "DELETE FROM "+ table +" where id_"+ table +" ="+ id +"";
    			statement.executeUpdate(query);
    			//System.out.println(query);
    		}
    	}
    	catch (Exception e)
    	{
    		System.out.println("Erorr Delite\n");
    	}
    	
    	 String x="DELITE SUCCESSFUL!\n";
		return x;
    }
    
    
    public String getClients() throws SQLException {
        String query = "select * from client";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id_client = resultSet.getString(1);
            String fio = resultSet.getString(2);
            String contact_information = resultSet.getString(3);

            System.out.format("+------------+--+--------------------------------------------------------------------------+\n");
            System.out.format("|id client: %s|\t|Fio: %s|\t|contact information: %s|\n", id_client,fio,contact_information);
            System.out.format("+------------+--+--------------------------------------------------------------------------+\n");
        }

       
        return result.toString();
    }
    
    public String getProvider() throws SQLException {
        String query = "select * from provider";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id_provider = resultSet.getString(1);
            String adress = resultSet.getString(2);
            String contact_information = resultSet.getString(3);
            String title = resultSet.getString(4);
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.format("|id provider:  %s|\t |Adress: %s|\t |contact information: %s| |Title:  %s|\t \n", id_provider,adress,contact_information,title);

        }

       
        return result.toString();
    }
    
    
    public String getProvideriD() throws SQLException {
        String query = "select * from provider where id_provider = (select max(id_provider) as max_id_provider from provider)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        String id_provider ="";
         
        while (resultSet.next()){
        	id_provider = resultSet.getString(1);
          
        }
        return id_provider;
    }
    
    public String getProvider_adress(String id_provider) throws SQLException {
        String query = "select adress,contact_information,title\n" +
                "from provider\n" +
                "where id_provider = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_provider));
        ResultSet resultSet = preparedStatement.executeQuery();
        String adress ="";
        
        while (resultSet.next())
        {
            adress = resultSet.getString(1);
        }

        return adress;
    }
   
    
    public String getincoming() throws SQLException {
        String query = "select * from incoming";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();
        while (resultSet.next())
        {
        	String product_id = resultSet.getString(1);
        	String provider_id = resultSet.getString(2);
        	String data_in = resultSet.getString(3);
        	String title = resultSet.getString(4);
            
            System.out.println("|-----------------------------------------------------------------------------------------------------------------------------|");
            System.out.format("|Product_id:  %s|\t |Provider_adress: %s|\t |Data_in: %s| |Title product:  %s|\t \n", product_id,getProvider_adress(provider_id),data_in,title);

        }       
        return result.toString();
        
    }
    
    
    
    
 }
  

