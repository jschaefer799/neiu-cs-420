package api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Writer {

    public Writer(){

    }
    public void writer (String [] output) throws IOException, URISyntaxException {

        String dir = ClassLoader.getSystemClassLoader().getResource("").toURI().getPath();
        String path = dir.substring(0, dir.indexOf("classes")) + File.separator + "resources";
        File dirs = new File(path);
        if (!dirs.exists())
            dirs.mkdirs();
        path += File.separator + "output.txt";
        FileWriter APIWriter = new FileWriter(path);

        for (int i = 0; i < output.length; i++)
            APIWriter.write(output[i] + "\n");
        APIWriter.close();
    }
}
