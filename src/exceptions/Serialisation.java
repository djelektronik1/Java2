package exceptions;

import exceptions.Bolnie;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.NoSuchFileException;

public class Serialisation  
{	
	public void serialise(Bolnie[] bolnie) throws IOException
	{	
	ObjectOutputStream objectOutputStream = null;
		if (bolnie.length == 0) 
		{        
			try 
			{    	
				objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/bolnie.ser"));
				objectOutputStream.writeObject(bolnie);
				objectOutputStream.close();            
			}         
			catch (NoSuchFileException e)
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
