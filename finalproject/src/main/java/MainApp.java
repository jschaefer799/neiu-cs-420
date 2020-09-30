import api.HttpRequestRetrieval;
import api.Reader;
import api.Writer;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args){

        String [] URLList;
        String [] data = new String [60];



        try {
            HttpRequestRetrieval req = new HttpRequestRetrieval();
            Reader newData = new Reader();
            Writer writeToFile = new Writer();

            URLList = req.getURLString();

            for (int i = 0; i < URLList.length; i++){
                req.establishConnection(URLList[i]);

                if (req.checkConnection()){
                    data[i] = newData.bufferedReader(req.getConnection(), URLList[i]);
                }
            }

            writeToFile.writer(data);

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
