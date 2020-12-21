package db2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Observer {

    private final List<String> subscribers = new ArrayList<>();

    public void addSubscriber(String path){
        this.subscribers.add(path);
    }

    public void deleteSubscriber(String path){
        this.subscribers.remove(path);
    }

    public void writeAction(String data){
        if (subscribers.toArray().length > 0){
            for (String subscriber: subscribers){
                try {
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/logs" + "/" + subscriber + "_" + getTime() + ".txt"))) 
                    {
                        bufferedWriter.write(data);
                    }
                } catch (IOException exception) {
                    System.out.println(exception);
                }
            }
        }
    }

    private String getTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime()).replace(":", "-") ;
    }
}
