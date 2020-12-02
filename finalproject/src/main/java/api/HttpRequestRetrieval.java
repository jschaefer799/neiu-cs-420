package api;

import javax.ws.rs.HttpMethod;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRequestRetrieval {

    private final String URLBase ="https://api.census.gov/data/timeseries/asm/industry";
    private final String URLStaticQuery = "?get=NAICS_TTL,EMP&for=us:*&time=";
    private final String apiKey = "&key=266ae5c42e91514b9076808b0cfa07f79c1dcfdc";
    private HttpURLConnection connection;
    final int connectTimeout = 60;
    private String [] listOfURLs;

    public HttpRequestRetrieval() {
        this.connection = null;
    }

    public String [] getURLString() throws IOException {

        this.listOfURLs = new String [60];
        int count = 0;

        //iterate through years
        for (int i = 2002; i <= 2016; i++){
            //iterate through NAICS codes

                this.listOfURLs[count] = URLBase + URLStaticQuery + i + "&NAICS=" + "311" + this.apiKey;
            count++;
                this.listOfURLs[count] = URLBase + URLStaticQuery + i + "&NAICS=" + "315" + this.apiKey;
            count++;
                this.listOfURLs[count] = URLBase + URLStaticQuery + i + "&NAICS=" + "331" + this.apiKey;
            count++;
                this.listOfURLs[count] = URLBase + URLStaticQuery + i + "&NAICS=" + "336" + this.apiKey;
                count++;

        }
        return this.listOfURLs;
    }

    public void establishConnection (String URLFromMain) throws IOException {
        final URL url = new URL(URLFromMain);
        this.connection = (HttpURLConnection) url.openConnection();
        this.connection.setConnectTimeout(connectTimeout);
        this.connection.setRequestMethod(HttpMethod.GET);

    }

    public HttpURLConnection getConnection (){
        return (this.connection);
    }

    public boolean checkConnection () throws IOException {
        return (this.connection.getResponseCode() == 200);
    }

}
