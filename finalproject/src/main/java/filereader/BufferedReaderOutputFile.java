package filereader;



import usmanf.models.CustomDate;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class BufferedReaderOutputFile {

    private List<CustomDate> dates;
    private final int LINE_SIZE = 10;

    public BufferedReaderOutputFile() {
        this.dates = new ArrayList<>();

    }

    public void bufferedReaderOutput(Path path) throws IOException {
        String [] data = new String[LINE_SIZE];
        String temp = "[\"]";
        String tempData = "";
        FileReader fileReader = new FileReader(String.valueOf(path));
        final BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((tempData = bufferedReader.readLine()) != null) {
            data = tempData.split(temp);
            dates.add(new CustomDate(data[1], Integer.parseInt(data[3]), Integer.parseInt(data[5]), Integer.parseInt(data[7])));
        }

        bufferedReader.close();
        fileReader.close();
    }

    public Path getOutputPath () throws URISyntaxException {
        Path outputPath;
        String dir = ClassLoader.getSystemClassLoader().getResource("").toURI().getPath();
        String path = dir.substring(0, dir.indexOf("classes")) + File.separator + "resources";

        path += File.separator + "output.txt";
        outputPath = Paths.get(path);
        return outputPath;

    }

    public List<CustomDate> getDates() {

        return this.dates;
    }
}
