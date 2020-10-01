package exceptions;

import java.io.Serializable;


public class Bolnie implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	{
        idGenertor++;
    }

    private static int idGenertor = 0;
    private int id = idGenertor;
    private String Surname;
    private String Name;
    private String Patronymic;
    private String Address;
    private String Phone_number;
    private int Medical_card_number;
    private String Disease;
    
    
	
	    public Bolnie(
	    		String Surname,
	    		String Name,
	    		String Patronymic,
	    		String Address,
	    		String Phone_number,
	    		int Medical_card_number,
	    		String Disease)	
	    {
	        
	        this.Surname = Surname;
	        this.Name = Name;
	        this.Patronymic = Patronymic;
	        this.Address = Address;
	        this.Phone_number = Phone_number;
	        this.Medical_card_number = Medical_card_number;
	        this.Disease = Disease;
	        
	    }

	    public String getSurname() {
	        return Surname;
	    }	   
	    public String getName() {
	        return Name;
	    }
	    public String Patronymic() {
	        return Patronymic;
	    }
	    public String getAddress() {
	        return Address;
	    }
	    public String getPhone_number() {
	        return Phone_number;
	    }
	    public int getMedical_card_number() {
	        return Medical_card_number;
	    }
	    public String getDisease() {
	        return Disease;
	    }
	   public void show()
	   		
	   		{
			System.out.format("ID: %d\t Surname:   %s\t Name:   %s\t Patronymic: %s\t Address:%s \t Phone_number: %s \t Medical_card_number: %d\t Disease: %s%n", 
					id, Surname, Name, Patronymic, Address, Phone_number, Medical_card_number, Disease );
			
		}

}
