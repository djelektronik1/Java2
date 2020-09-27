package exceptions;

import exceptions.Bolnie;
import exceptions_.EmptyAllException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialisation {
	
	public Bolnie[] deSerialize() throws EmptyAllException
	 {
		  Bolnie[] bolnie = null;
	        
	        try 
	        {
	            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/bolnie.ser"));
	            bolnie = (Bolnie[])objectInputStream.readObject();
	            objectInputStream.close(); 	            
	        } 
	        
	        catch (Exception ex)
	        
	         {
	           System.out.println(ex.getMessage());
	         }
	        	        
	        if (bolnie.length == 0) throw new EmptyAllException("Array is empty");
	         return bolnie;
	        
	    }

}
