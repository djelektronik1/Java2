package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBC.Connect;
import JDBC.getInformation;

public class Runner 
{
	 public static void main(String[] args) throws SQLException, IOException 
	    {
	    	
	    	
	        @SuppressWarnings("unused")
			//String query = "select * from products";

	        Connection conn = new Connect().get_connection();
	        Statement statement = conn.createStatement();

	        // create tables
	        
	        statement.executeUpdate(
	        		"create table if not exists root_directory(\n" +
	                "    id_root_directory int auto_increment,\n" +
	                "    title varchar(60) not null,\n" +
	                "    primary key (id_root_directory)\n" +
	                "\n" +
                    ");");
	        statement.executeUpdate(
	        		"create table if not exists child_directory(\n" +
	                "    id_child_directory int auto_increment,\n" +
	                "    id_root_directory int not null,\n" +
	                "    title varchar(60) not null,\n" +
	                "    primary key (id_child_directory),\n" +
	                "    foreign key (id_root_directory) references root_directory (id_root_directory)\n" +
	                ");");
	        statement.executeUpdate(
	        		"create table if not exists files(\n" +
	        		"    id_files int auto_increment,\n" +
	        		"    id_child_directory int not null,\n" +
	        		"    title varchar(60) not null,\n" +
	        		"    extension varchar(60) not null,\n" +
	        		"    size int not null,\n" +
	                "    primary key (id_files),\n" +
	                "    foreign key (id_child_directory) references child_directory (id_child_directory)\n" +
	                ");");
	       

	        getInformation getInfo = new getInformation(conn);
	        
	        @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
	        
	        int userInput;
	        boolean isTrue = true;
	        while (isTrue)
	        {
	        	System.out.println("+-----------------------------------------+");
	            System.out.println("|             Главное меню                |");
	            System.out.println("|-----------------------------------------|");
	            System.out.println("|   1:Операции с корневым каталогом       |");
	            System.out.println("|-----------------------------------------|");
	            System.out.println("|   2:Операции с дочерним каталогом       |");
	            System.out.println("|-----------------------------------------|");
	            System.out.println("|   3:Операции с Файлами                  |");
	            System.out.println("|-----------------------------------------|");
	            System.out.println("|         4:Выход из программы            |");
	            System.out.println("+-----------------------------------------+\n");
	            userInput = scanner.nextInt();
	            @SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
	            
	            
	            switch (userInput) 
	            {
	                case (1): 
	                {  
	                  
	                	boolean menu2 = true;
	                    while (menu2)
	                    {
	                    	System.out.println(getInfo.getRoot_directory());
	                    	System.out.println("+----------------------------------------------------+");
	                        System.out.println("| Добавить каталог | Удалить каталог | Главное меню  |");
	                        System.out.println("| >>>>>>> 1 <<<<<< | >>>>>> 2 <<<<<< | >>>>> 3 <<<<< |");
	                        System.out.println("+----------------------------------------------------+\n");
	             		int menu = in.nextInt();
	             		@SuppressWarnings("resource")
						Scanner in2 = new Scanner(System.in);
	             		
	             		switch (menu) 
	             		{
	                    case (1):
	                    		String line ="-------------------------------------------";
	              	  
	                   			System.out.println("Enter Title of directory");
	                   			String title = in2.nextLine();
	                   		                   	
	                   			System.out.println(line);           
	                   			System.out.println("Title of directory :"+ title +""); 
	                   			System.out.println(line);
	              	   
	                   			statement.executeUpdate("insert into root_directory (title) values ( '"+ title +"')"); 
	                   			System.out.println("enter date complet!\n");
	                   			
	                        break;
	                    case (2):
	                    	System.out.println("Enter ID root_directory");
	                        String id_root_directory = in2.nextLine();
	                    	//System.out.println(getInfo.getRoot_directoryInfo(id_root_directory));
	                    	System.out.println(getInfo.getDelite("root_directory",id_root_directory));
	                    	
	                        break;
	        
	                    case (3):
	                    	menu2 = false;
	                        break;
	                    default:
	                        ;
	                        break;
	                   }
	             		            		
	                  }
	                  
	                    
	                    break;
	                }
	                case (2): 
	                {
	               	  
	                	boolean menu3 = true;
	                	while (menu3)
	                	{
	                		System.out.println(getInfo.getChild_directory());
	                		System.out.println("+----------------------------------------------------------------------+");
	                	    System.out.println("| Добавить дочерний каталог | Удалить дочерний каталог | Главное меню  |");
	                	    System.out.println("| >>>>>>>>>>> 1 <<<<<<<<<<< | >>>>>>>>>> 2 <<<<<<<<<<< | >>>>> 3 <<<<< |");
	                	    System.out.println("+----------------------------------------------------------------------+\n");
	                		int menu = in.nextInt();
	                		@SuppressWarnings("resource")
							Scanner in3= new Scanner(System.in);
	                		
	                		switch (menu) 
	                		{
	                	case (1):
	                			   System.out.println(getInfo.getRoot_directory());
	                				String line ="-------------------------------------------";
	                	  
	                				System.out.println("Enter id_root_directory\n");
	                				String id_rd = in3.nextLine();
	                			                					                		
	                				System.out.println("Enter title directory\n");
	                				String title = in3.nextLine();
	                		
	                				                		
	                				System.out.println(line);           
	                				System.out.println("Child_directory: "+ id_rd +"|"+ title +""); 
	                				System.out.println(line);

	                				statement.executeUpdate("insert into child_directory(id_root_directory,title) values ( '"+ id_rd +"','"+ title +"')");
	                				System.out.println("enter date complet!\n");
	                				
	                				break;
	                		case (2):
	                		System.out.println("Enter ID Child_directory");
	                	    String id = in3.nextLine();
	                		//System.out.println(getInfo.getChild_directoryInfo(id));
	                		System.out.println(getInfo.getDelite("child_directory",id));
	                		
	                	    break;

	                	case (3):
	                		menu3 = false;
	                	    break;
	                	default:
	                	    ;
	                	    break;
	                	}
	                		            		
	                	}
	                    	                      
	               	  
	                    break;
	                }
	                case (3): {
	                	boolean menu4 = true;
	                	while (menu4)
	                	{
	                		System.out.println(getInfo.getfiles());
	                		System.out.println("+------------------------------------------------------------+");
	                	    System.out.println("| Добавить файл | Удалить Файл | Поиск файла | Главное меню  |");
	                	    System.out.println("| >>>>> 1 <<<<< | >>>>> 2 <<<< | >>>> 3 <<<< | >>>>> 4 <<<<< |");
	                	    System.out.println("+------------------------------------------------------------+\n");
	                		int menu = in.nextInt();
	                		@SuppressWarnings("resource")
							Scanner in4= new Scanner(System.in);
	                		
	                		switch (menu) 
	                		{
	                	case (1):
	                			   System.out.println(getInfo.getChild_directory());
	                				String line ="-------------------------------------------------------------";
	                	  
	                				System.out.println("Enter id_Child_directory\n");
	                				String id_rd = in4.nextLine();
	                			                					                		
	                				System.out.println("Enter title File\n");
	                				String title = in4.nextLine();
	                				
	                				System.out.println("Enter extension\n");
	                				String extension = in4.nextLine();
	                				
	                				System.out.println("Enter Size files\n");
	                				String size = in4.nextLine();
	                		
	                				                		
	                				System.out.println(line);           
	                				System.out.println("File: "+ id_rd +"|"+ title +"|"+ extension +"|"+ size +""); 
	                				System.out.println(line);

	                				statement.executeUpdate("insert into files(id_Child_directory,title,extension,size) "
	                						+ "values ( '"+ id_rd +"','"+ title +"','"+ extension +"','"+ size +"')");
	                				System.out.println("enter date complet!\n");
	                				
	                				break;
	                		case (2):
	                			
	                		System.out.println("Enter ID files");
	                	    String id = in4.nextLine();
	                		//System.out.println(getInfo.getChild_directoryInfo(id));
	                		System.out.println(getInfo.getDelite("files",id));
	                		
	                	    break;
	                	    
	                		case (3):
	                			System.out.println("Enter Extension files");
	                	    String extension2 = in4.nextLine();
	                		System.out.println(getInfo.getSearch_files(extension2));
	                		
	                		createHTML html = new createHTML();
		                    html.createHtmlReport(getInfo.getSearch_files(extension2));
		                    System.out.println("Creation of HTML completed!");	
		                		
		                	    break;
	                		
	                	case (4):
	                		menu4 = false;
	                	    break;
	                	default:
	                	    ;
	                	    break;
	                	}
	                		            		
	                	}
	                    break;
	                }
	                case (4):{
	                	
	                   	System.out.println("Программа завершина успешно!");
	                    isTrue = false;
	                 	break;
	                }
	             	
	                default:
	                    System.out.println("Неправильный выбор!");
	            	}
	            
	        } 
	        
		}

}
