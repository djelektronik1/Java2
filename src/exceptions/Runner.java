package exceptions;

import exceptions.Bolnie;
import exceptions.Sort;
import exceptions_.EmptyAllException;



	public class Runner  {
		
		
		public static void main(String[] args) throws EmptyAllException {
			
	        Bolnie[] Pacient = new Bolnie[10];
	        
	        Pacient[0] = new Bolnie("�������", "���������", "����������","13 ���� 23","+37529889955",1, "angina");
	        Pacient[1] = new Bolnie("�������", "���������", "��������","jyjhg �� 23","+37569632147",2, "uxo");
	        Pacient[2] = new Bolnie("������", "��������", "���������","������ 646","+89562310568",3, "grip");
	        Pacient[3] = new Bolnie("�������", "��������", "���������","GHG ryh45","+37656565678",4, "Zdorov");
	        Pacient[4] = new Bolnie("����", "�������", "����","�������� 76","+79856215850",5, "COVID-19");
	        Pacient[5] = new Bolnie("����", "����������", "��������","������ ������","+37529999998",6, "ne noga");
	        Pacient[6] = new Bolnie("������", "����������", "�������","����������","+37555325684",7, "zdorov");
	        Pacient[7] = new Bolnie("�����", "�������", "�������","� �������","+37529889966",8, "angina");
	        Pacient[8] = new Bolnie("�������", "����������", "��������","0 ��� ���� 23","+12345678912",9, "ne zdorov");
	        Pacient[9] = new Bolnie("����", "����t���", "����","��t����� 76","+79862158450",10,"Noga");
	        
	       /*
	         Scanner sc = null;
	        try 
	        {
	            sc = new Scanner(new FileReader("src/in.txt"));
	            
	            Bolnie[] Pacient = new Bolnie[10];
	            
	            for (int i = 0; i < Pacient.length; i++) 
	            {
	                String surname = sc.next();
	                String name = sc.next();
	                String patronymic = sc.next();
	                String address = sc.next();
	                String phone_number = sc.next();
	                int medical_card_number = sc.nextInt();
	                String disease = sc.next();
	                Pacient[i] = new Bolnie(surname, name, patronymic, address, phone_number, medical_card_number, disease);
	                System.out.println(Pacient);
	            }
	            
	            sc.close();
	        } 
	            catch (EmptyAllException ex)
	        	{
	        		System.out.println("ERORR Read file");
	        	}  
	        */
	        
	         
	        // Sorting by Name
	        
	                System.out.println("\nSorting by Names\n");
	                for( Bolnie bolnie: Sort.byNames(Pacient))
	                {
	            if (bolnie != null){
	            	bolnie.show();
	            }
	        }
	                
	        // Sorting by Range
	        
	        int min = 3;
	        int max = 8;
	                
	        System.out.println("\nSorting by Range\n");
	        
	        	        
	        for(Bolnie bolnie: Pacient)
	        {	                            	
	           if (bolnie != null && bolnie.getMedical_card_number() > min && bolnie.getMedical_card_number() < max)
	           {
	             bolnie.show();	            	            	
	           }	            
	        }
	        
	        
	        
	        // Sorting by Disease
	        System.out.println("\nSorting by Disease\n");
	        
	        String disease = "angina";
	        int Total = 0 ;
	        try 
	        {
	        
	        	for(Bolnie bolnie:Pacient)
	        	{	        	
	        		if (bolnie != null && bolnie.getDisease().equals(disease))
	        		{
	        			bolnie.show();
	        			{
	        				Total++;
	        			}
	        		}
	        	}
	        }
	        catch (EmptyAllException e3) 
	        {
                System.err.println("Negative value ");
            }
	        System.out.println("\nTotal patients diagnosed: "+disease+" = "+Total);
	        
	        // Serialisation
	         
	        System.out.println("\nSerialization\n");
	        Bolnie[] newBolnie = null;
	        
	        try 
	        {
	        	Serialisation serialisation = new Serialisation();
	        	serialisation.serialise(Pacient);
	        }
	        
	        catch (Exception e1)
	        {
	        	throw new EmptyAllException(e1);
	        }  
	        
	        try 
	        {	        
	        	DeSerialisation deSerialisation = new DeSerialisation();
	        	newBolnie = deSerialisation.deSerialize();
	        } 
	        catch (Exception e2) 
	        {
                throw new EmptyAllException(e2);
            }
	        
	        
	        for (Bolnie bolnie: newBolnie)
	        {
	        	System.out.println(bolnie);
	        }
	        
	        System.out.println("\nDeserialization\n");
	        for (Bolnie bolnie: newBolnie)
	        {
	        	bolnie.show();
	        }
	       	       
	        }
}
	


