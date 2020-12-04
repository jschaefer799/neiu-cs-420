package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Reader {

    private String output;

    public Reader (){
        this.output = null;

    }

    public String bufferedReader(HttpURLConnection connection, String URLFromMain) throws IOException {

        final InputStream inputStream = connection.getInputStream();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (bufferedReader.readLine() != null)
            this.output = ((bufferedReader.readLine()));

        return this.output;
    }



}
