package XML;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static final String URL = "http://news.tut.by/rss/index.rss";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XMLStreamException {
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean isTrue = true;

        while (isTrue){
        	System.out.println("|-----------------------------------------|");
            System.out.println("|    �������� ����� ��������� ������:     |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|1:�������� ������ ��� ������ Dom ������� |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|2:�������� ������ ��� ������ SAX ������� |");
            System.out.println("|-----------------------------------------|");
            System.out.println("|3:�������� ������ ��� ������ StAX �������|");
            System.out.println("|-----------------------------------------|");
            System.out.println("|         4:����� �� ���������            |");
            System.out.println("|-----------------------------------------|");
            userInput = scanner.nextInt();
            Channel channel;
            switch (userInput) {
                case (1): {
                    channel = DomParser.parse(URL);
                    showResult(channel);
                    break;
                }
                case (2): {
                    channel = SaxParser.parse(URL);
                    showResult(channel);
                    break;
                }
                case (3):{
                    channel = StaxParse.parse(URL);
                    showResult(channel);
                    break;
                }
                case (4): {
                    isTrue = false;
                    break;
                }
                default:
                    System.out.println("������������ �����!");
            }


        }
    }

    public static void showResult(Channel channel) {
        for (Item item : channel.getItems()) {
        	System.out.println(
"-----------------------------------------------------------------------------------------------------------------------");
            System.out.println("Title: " + item.getItemTitle());
            System.out.println("Link: " + item.getItemLink());
            System.out.println("Description: " + item.getItemDescription());
            System.out.println(
"-----------------------------------------------------------------------------------------------------------------------\n");
        }
    }
}