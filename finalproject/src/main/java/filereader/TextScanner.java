package filereader;



import usmanf.Date;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextScanner {

    private int count = 0;
    private List<Date> dates;
    private final int LINE_SIZE = 10;

    public TextScanner() throws IOException, URISyntaxException {
        this.dates = new ArrayList<>();


    }

    public void getText(Path path) throws IOException {
        String [] data = new String[LINE_SIZE];
        File file = new File (String.valueOf(path));
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        String temp = "[\"]";
        String tempData = "";
        while (scanner.hasNextLine()){
            tempData = scanner.nextLine();
            data = tempData.split(temp);
            dates.add(new Date(data[1], Integer.parseInt(data[3]), Integer.parseInt(data[5]), Integer.parseInt(data[7])));
            //updateFinalArray(data);
             //1,3,5,7,
        }
    }

    public Path getOutputPath () throws IOException, URISyntaxException {
        Path outputPath;
        String dir = ClassLoader.getSystemClassLoader().getResource("").toURI().getPath();
        String path = dir.substring(0, dir.indexOf("classes")) + File.separator + "resources";
        File dirs = new File(path);
        if (!dirs.exists())
            dirs.mkdirs();
        path += File.separator + "output.txt";
        outputPath = Paths.get(path);
        return outputPath;

    }

    public List<Date> getDates() {

        return this.dates;
    }
}
