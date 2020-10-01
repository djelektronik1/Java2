package exceptions_;

public class EmptyAllException extends IllegalArgumentException 
{
	
	private static final long serialVersionUID = 1L;

	public EmptyAllException ()
	{    
		
	}
	
	public EmptyAllException (String s)
	{
        super(s);
    }
	
	public EmptyAllException(String message, Throwable cause) 
	{
	    super(message, cause);
	}
	public EmptyAllException (Throwable cause) 
	{
        super(cause);
    }

}
