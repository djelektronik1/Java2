package exceptions_;

public class EmptyAllException extends Exception {
	
		private static final long serialVersionUID = 1L;

	public EmptyAllException(){

    }

    public EmptyAllException (String msg){
        super(msg);
    }

}
