package usmanf.views;

import filereader.BufferedReaderOutputFile;
import usmanf.models.CustomDate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ChartData {

    private List<CustomDate> customDateList;

    public ChartData() throws IOException, URISyntaxException {
        this.customDateList = getCustomDateList();
    }

    public List<CustomDate> getCustomDateList() throws URISyntaxException, IOException {
        BufferedReaderOutputFile brOutPutFile = new BufferedReaderOutputFile();
        Path path = brOutPutFile.getOutputPath();

        brOutPutFile.bufferedReaderOutput(path);
        return brOutPutFile.getDates();
    }

    public List<Integer> getTotalNumberOfJobsByNacisCode() {
        List<Integer> totalJobs = new ArrayList<>();

        Arrays.asList(311,315,331,336)
                .forEach(nacisCode -> totalJobs
                        .add(customDateList.stream()
                .filter(customDate -> customDate.getNacisCode() == nacisCode)
                                .map(CustomDate::getTotalJobs)
                                .reduce(Integer::sum).get()));
        return totalJobs;
    }

    public List<Integer> getTotalJobsByOneNacisCode(int nacisCode){
        List<CustomDate> test = customDateList.stream()
                .filter(nacis -> nacis.getNacisCode() == nacisCode)
                .sorted(Comparator.comparingInt(CustomDate::getYear))
                .collect(Collectors.toList());

        List<Integer> data = test.stream()
                .map(CustomDate::getTotalJobs)
                .collect(Collectors.toList());

        return data;
    }

}
