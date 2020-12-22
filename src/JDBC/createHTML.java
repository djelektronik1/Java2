package JDBC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createHTML {

    public void createHtmlReport(String data){

        String html = "<html> " + data + "</html>";

        File fileHtml = new File("src/report.html");
        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileHtml))) {
                bufferedWriter.write(html);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}