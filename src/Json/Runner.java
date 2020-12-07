package Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Runner 
{
    public static Map<String, Object> jsonToMap(String str) 
    {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() 
        {
        }.getType());
        return map;
    }

    public static void main(String[] args) 
    {
        String API_KEY = "3972aa19a4e7a4e3e6d504dfb6cb185d";
        String LOCATION = "Los Angeles,us";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY + "&units=imperial";
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) 
            {
                result.append(line);
            }
            reader.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());

            @SuppressWarnings("unchecked")
			Map<String, Object> weatherMap = (Map<String, Object>) ((List<Object>) respMap.get("weather")).get(0);
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
            Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());
            Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());

            String city = respMap.get("name").toString();
            String country = sysMap.get("country").toString();
            String iconId = weatherMap.get("icon").toString();
            String shortDescription = weatherMap.get("main").toString();
            String extendedDescription = weatherMap.get("description").toString();
            double temperature = (double) mainMap.get("temp");
            double pressure = (double) mainMap.get("pressure");
            double humidity = (double) mainMap.get("humidity");
            double minTemperature = (double) mainMap.get("temp_min");
            double maxTemperature = (double) mainMap.get("temp_max");
            double windSpeed = (double) windMap.get("speed");
            double windDirection = (double) windMap.get("deg");
            double cloudiness = (double) cloudsMap.get("all");

            WeatherWidget weather = new WeatherWidget(city, country, iconId, shortDescription, extendedDescription, temperature,
                    pressure, humidity, minTemperature, maxTemperature, windSpeed, windDirection, cloudiness);

            System.out.println(weather);

            weather.saveWidgetHtml();


        } 
        
        catch (IOException e) 
        {
            System.out.println(e.getMessage());
        }

    }
}