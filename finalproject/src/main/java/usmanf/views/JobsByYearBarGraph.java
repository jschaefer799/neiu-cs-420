package usmanf.views;

import javafx.scene.chart.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class JobsByYearBarGraph {

    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final BarChart<String,Number> barChart = new BarChart <String, Number>(xAxis,yAxis);
    XYChart.Series <String,Number> series = new XYChart.Series<String,Number>();



    public JobsByYearBarGraph() throws IOException, URISyntaxException {

        getBarChart();
    }

    public BarChart<String,Number> getBarChart () throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalNumberOfJobs();

        barChart.setTitle("U.S. Manufacturing Jobs 2002-2016");
        xAxis.setLabel("Year");
        yAxis.setLabel("Number of Jobs");

        createBarChart("2002",jobData.get(0));
        createBarChart("2003",jobData.get(1));
        createBarChart("2004",jobData.get(2));
        createBarChart("2005",jobData.get(3));
        createBarChart("2006",jobData.get(4));
        createBarChart("2007",jobData.get(5));
        createBarChart("2008",jobData.get(6));
        createBarChart("2009",jobData.get(7));
        createBarChart("2010",jobData.get(8));
        createBarChart("2011",jobData.get(9));
        createBarChart("2012",jobData.get(10));
        createBarChart("2013",jobData.get(11));
        createBarChart("2014",jobData.get(12));
        createBarChart("2015",jobData.get(13));
        createBarChart("2016",jobData.get(14));

        series.setName("Total Number of Jobs");
        barChart.getData().add(series);

        return barChart;

    }
    private void createBarChart(String year, int totalJobs){
        series.getData().add(new XYChart.Data<String,Number>(year,totalJobs));


    }
}
