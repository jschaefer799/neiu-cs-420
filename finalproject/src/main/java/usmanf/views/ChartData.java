package usmanf.views;

import filereader.BufferedReaderOutputFile;
import usmanf.models.CustomDate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Integer> getTotalNumberOfJobs() {
        List<Integer> totalJobs = new ArrayList<>();

        Arrays.asList(2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016).forEach(year -> {
            totalJobs.add(customDateList.stream().filter(customDate -> {
                return customDate.getYear() == year;

            }).map(customDate -> customDate.getTotalJobs()).reduce((subtotal, value) -> subtotal+value).get());

          });
        return totalJobs;
    }
    public List<Integer> getTotalNumberOfJobsByNacisCode() {
        List<Integer> totalJobs = new ArrayList<>();

        Arrays.asList(311,315,331,336).forEach(nacisCode -> {
            totalJobs.add(customDateList.stream()
                    .filter(customDate -> {
                return customDate.getNacisCode() == nacisCode;

            }).map(customDate -> customDate.getTotalJobs()).reduce((subtotal, value) -> subtotal+value).get());

        });
        return totalJobs;
    }

    public List<Integer> getTotalJobsByOneNacisCode(int nacisCode){
        List<CustomDate> test = customDateList.stream()
                .filter(nacis -> nacis.getNacisCode() == nacisCode)
                .sorted(Comparator.comparingInt(CustomDate::getYear))
                .collect(Collectors.toList());

        List<Integer> data = test.stream()
                .map(jobs -> jobs.getTotalJobs())
                .collect(Collectors.toList());

        return data;
    }

}
