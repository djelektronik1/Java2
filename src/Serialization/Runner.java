package Serialization;

import Serialization.Bolnie;
import Serialization.Sort;



public class Runner  {
	
	
	public static void main(String[] args) {
		
		Serialisation serialisation = new Serialisation();

        Bolnie[] Pacient = new Bolnie[10];
        
        Pacient[0] = new Bolnie("Дмитрий", "Имануилов", "Алексеевич","13 БССР 23","+37529889955",1, "angina");
        Pacient[1] = new Bolnie("Василий", "Тарасенко", "Петрович","jyjhg СР 23","+37569632147",2, "uxo");
        Pacient[2] = new Bolnie("Алесей", "Колесник", "Андреевич","Гомель 646","+89562310568",3, "grip");
        Pacient[3] = new Bolnie("Дмитрий", "Турецкий", "Федорович","GHG ryh45","+37656565678",4, "Zdorov");
        Pacient[4] = new Bolnie("Семён", "Семёновч", "Шпат","Кукухино 76","+79856215850",5, "COVID-19");
        Pacient[5] = new Bolnie("Иван", "Васильевич", "Федосеко","Четыре хватит","+37529999998",6, "ne noga");
        Pacient[6] = new Bolnie("Измаил", "Николаевич", "Кукухин","Пожалуйста","+37555325684",7, "zdorov");
        Pacient[7] = new Bolnie("Павел", "Зачётов", "Припоев","В зачётку","+37529889966",8, "angina");
        Pacient[8] = new Bolnie("Алексей", "Безымянный", "Никакоев","0 лет БССР 23","+12345678912",9, "ne zdorov");
        Pacient[9] = new Bolnie("Семён", "Семёнtовч", "Шпат","Куtкуино 76","+79862158450",10,"Noga");
        
        serialisation.serialise(Pacient);
           
         
        // Sorting by Name
        
                System.out.println("\nSorting by Names\n");
                for( Bolnie bolnie: Sort.byNames(Pacient)){
            if (bolnie != null){
            	bolnie.show();
            }
        }
                
        // Sorting by Range
        
        int min_ = 3;
        int max_ = 8;
                
        System.out.println("\nSorting by Range\n");
                for( Bolnie bolnie: Pacient){
            if (bolnie != null && bolnie.getMedical_card_number() > min_ && bolnie.getMedical_card_number() < max_){
            	bolnie.show();
            }
        }
        
        // Sorting by Disease
        
        String disease_ = "angina";
        
        
        System.out.println("\nSorting by Disease\n");
        
        for(Bolnie bolnie:Pacient){
            if (bolnie != null && bolnie.getDisease().equals(disease_)){
            	bolnie.show();
            }
        }
        
        //Serialisation
         
        System.out.println("\nSerialization\n");
        
        DeSerialisation deSerialisation = new DeSerialisation();
                Bolnie[] newBolnie = null;
        
        newBolnie = deSerialisation.deSerialize();
        
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


