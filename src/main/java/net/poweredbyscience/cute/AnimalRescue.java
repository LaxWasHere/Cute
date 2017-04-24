package net.poweredbyscience.cute;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Lax on 4/14/2017.
 */
public class AnimalRescue {

    public static String getCuteShit(String query) {
        try {
            StringBuilder res = new StringBuilder();
            URL url = new URL("http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag="+query);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int i = con.getResponseCode();
            final Reader reader = new InputStreamReader(con.getInputStream());
            final BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
            br.close();
            return parseData(res.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return query;
    }

    public static String parseData(String line) {
        JsonElement jason = new JsonParser().parse(line);
        JsonObject jamesson = jason.getAsJsonObject();
        String s = jamesson.getAsJsonObject("data").get("image_url").toString().replace("\"","");
        return "https://i.giphy.com/"+s.split("/")[4]+".gif";
    }
}
