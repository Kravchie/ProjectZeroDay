package com.crazysquirrelsofdestruction.zeroday.Controllers;

/**
 * Created by Nadin on 4/13/2016.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetController {
    public void connect() {
          try {
            URL url = new URL("http://129.241.138.162:8080/");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            String readStream = readStream(con.getInputStream());
            // Give output for the command line
            System.out.println(readStream);
          } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        BufferedReader  reader = new BufferedReader(new InputStreamReader(in));

        try {

            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}