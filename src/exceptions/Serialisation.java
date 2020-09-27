package exceptions;

import exceptions.Bolnie;
import exceptions_.EmptyAllException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;

public class Serialisation  {
	
public void serialise(Bolnie[] bolnie) throws EmptyAllException{
		
        ObjectOutputStream objectOutputStream = null;
        
        if (bolnie.length == 0) throw new EmptyAllException("Array is empty");
        {
        
        	try 
        		{        	
        		   
        		   objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/bolnie.ser"));
        		   objectOutputStream.writeObject(bolnie);
        		   objectOutputStream.close();            
        		} 
        
        		catch (NoSuchFileException ex)
                {
        			System.out.println("File not found");
                } 
        
        			catch (IOException e) 
        			{
        			    System.out.println(e);
        			}
    }

}

}
