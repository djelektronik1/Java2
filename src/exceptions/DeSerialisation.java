package exceptions;

import exceptions.Bolnie;
import exceptions_.EmptyAllException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialisation 
{	
	public Bolnie[] deSerialize() throws IOException, ClassNotFoundException
	 {
		Bolnie[] bolnie = null;
		try 
	    {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/bolnie.ser"));
	        bolnie = (Bolnie[])objectInputStream.readObject();
	        objectInputStream.close(); 	            
	    }	        
	    catch (EmptyAllException e3) 
	    {
            System.err.println("ERORR Open File ");
        }	        	        
	    if (bolnie.length == 0);
	       return bolnie;	        
	 }
}
