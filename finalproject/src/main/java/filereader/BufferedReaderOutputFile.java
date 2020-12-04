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

    public BufferedReaderOutputFile() {
        this.dates = new ArrayList<>();
    }

    public void bufferedReaderOutput(Path path) throws IOException {
        String [] data;
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

        //Wasn't able to find the time/energy to rework the two BufferedReader loops.
        //        Stream<String> lines = Files.lines(path);
//        lines.map(line -> line.split(temp))
//                .forEach(array -> dates.add(new CustomDate(array[1], Integer.parseInt(array[3]),
//                        Integer.parseInt(array[5]),
//                        Integer.parseInt(array[7]))));
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
