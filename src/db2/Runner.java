package db2;

import java.util.Scanner;
import java.io.IOException;
import java.sql.*;




public class Runner
{


    public static void main(String[] args) throws SQLException, IOException
    {


        @SuppressWarnings("unused")
        String query = "select * from products";

        Connection conn = new Connect().get_connection();
        Statement statement = conn.createStatement();

        // create tables

        statement.executeUpdate(
                "create table if not exists provider(\n" +
                        "    id_provider int auto_increment,\n" +
                        "    adress varchar(60) not null,\n" +
                        "    contact_information varchar(60) not null,\n" +
                        "    title varchar(60) not null,\n" +
                        "    primary key (id_provider)\n" +
                        "\n" +
                        ");");
        statement.executeUpdate(
                "create table if not exists client(\n" +
                        "    id_client int auto_increment,\n" +
                        "    FIO varchar(60) not null,\n" +
                        "    contact_information varchar(60) not null,\n" +
                        "    primary key (id_client)\n" +
                        ");");
        statement.executeUpdate(
                "create table if not exists incoming(\n" +
                        "    product_id int auto_increment,\n" +
                        "    provider_id int,\n" +
                        "    data_in varchar(60) not null,\n" +
                        "    title varchar(60) not null,\n" +
                        "    primary key (product_id),\n" +
                        "    foreign key (provider_id) references provider(id_provider)\n" +
                        ");");
        statement.executeUpdate(
                "create table if not exists outcoming(\n" +
                        "    id_outcoming int auto_increment,\n" +
                        "    client_id int,\n" +
                        "    product_id int,\n" +
                        "    data_out varchar(60) not null,\n" +
                        "    primary key (id_outcoming),\n" +
                        "    foreign key (client_id) references client(id_client),\n" +
                        "    foreign key (product_id) references incoming(product_id)\n" +
                        ");");


        getInformation getInfo = new getInformation(conn);

        //add subscribers
        getInfo.observer.addSubscriber("Sub_1");
        getInfo.observer.addSubscriber("Sub_2");


        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int userInput;
        boolean isTrue = true;
        while (isTrue)
        {
        	System.out.println("+-----------------------------------------+");
            System.out.println("|             Главное меню                |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|   1:Операции с Клиентами                |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|   2:Операции с Поставщиками             |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|   3:Просмотр содержимого скада          |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|   4:Операции с Выдачей                  |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|         5:Выход из программы            |");
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
                        System.out.println(getInfo.getClients());
                        System.out.println("+----------------------------------------------------+");
                        System.out.println("| Добавить Клиента | Удалить Клиента | Главное меню  |");
                        System.out.println("| >>>>>>> 1 <<<<<< | >>>>>> 2 <<<<<< | >>>>> 3 <<<<< |");
                        System.out.println("+----------------------------------------------------+\n");
                        int menu = in.nextInt();
                        @SuppressWarnings("resource")
                        Scanner in2 = new Scanner(System.in);

                        switch (menu)
                        {
                            case (1):
                                String line ="-------------------------------------------";

                                System.out.println("Enter Fio");
                                String fio = in2.nextLine();

                                System.out.println("Enter number phone");
                                String number_phone = in2.nextLine();

                                System.out.println(line);
                                System.out.println("USER :"+ fio +"|"+ number_phone +"");
                                System.out.println(line);

                                statement.executeUpdate("insert into client(FIO, contact_information) values ( '"+ fio +"', '"+ number_phone +"')");
                                System.out.println("enter date complet!\n");

                                break;
                            case (2):
                                System.out.println("Enter ID Client");
                                String id_client = in2.nextLine();
                                System.out.println(getInfo.getClientInfo(id_client));
                                System.out.println(getInfo.getDelite("client",id_client));

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
                        System.out.println(getInfo.getProvider());
                        System.out.println("+----------------------------------------------------------+");
                	    System.out.println("| Добавить Поставщика | Удалить Поставщика | Главное меню  |");
                	    System.out.println("| >>>>>>>> 1 <<<<<<<< | >>>>>>> 2 <<<<<<<< | >>>>> 3 <<<<< |");
                	    System.out.println("+----------------------------------------------------------+\n");
                        int menu = in.nextInt();
                        @SuppressWarnings("resource")
                        Scanner in3= new Scanner(System.in);

                        switch (menu)
                        {
                            case (1):
                                String line ="-------------------------------------------";

                                System.out.println("Enter adress");
                                String adress = in3.nextLine();

                                System.out.println("Enter contact information");
                                String contact_information = in3.nextLine();

                                System.out.println("Enter title product");
                                String title = in3.nextLine();

                                System.out.println("Enter data");
                                String data = in3.nextLine();

                                System.out.println(line);
                                System.out.println("Provider :"+ adress +"|"+ contact_information +"|"+ title +"");
                                System.out.println(line);

                                statement.executeUpdate("insert into provider(adress, contact_information, title) values ( '"+ adress +"', '"+ contact_information +"','"+ title +"')");
                                statement.executeUpdate("insert into incoming(provider_id, data_in, title) values ( '"+ getInfo.getProvideriD() +"', '"+ data +"','"+ title +"')");
                                System.out.println("enter date complet!\n");

                                break;
                            case (2):
                                System.out.println("Enter ID Provider");
                                String id_provider = in3.nextLine();
                                System.out.println(getInfo.getProviderInfo(id_provider));
                                System.out.println(getInfo.getDelite("provider",id_provider));

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
                    System.out.println(getInfo.getincoming());
                    break;
                }
                case (4):{
                    System.out.println(" 404 Not Found");
                    break;
                }

                case (5): {
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






