package usmanf.views;

import javafx.scene.chart.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class JobsBarChart {

    private final CategoryAxis xAxis;
    private final NumberAxis yAxis;
    private final BarChart<String, Number> barChart;
    XYChart.Series<String, Number> series;

    public JobsBarChart() throws IOException, URISyntaxException {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        barChart = new BarChart<>(xAxis, yAxis);
        series = new XYChart.Series<>();
        setupBarChartByYear();
    }

    public void setupBarChartByYear() throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalJobsByOneNacisCode(336);
        barChart.setTitle("U.S. Manufacturing Total Combined Jobs for Sub-Sectors 311, 315, 331 and 336 for 2002-2016");
        xAxis.setLabel("Year");
        yAxis.setLabel("Number of Jobs");

        createBarChartByYear("2002", jobData.get(0));
        createBarChartByYear("2003", jobData.get(1));
        createBarChartByYear("2004", jobData.get(2));
        createBarChartByYear("2005", jobData.get(3));
        createBarChartByYear("2006", jobData.get(4));
        createBarChartByYear("2007", jobData.get(5));
        createBarChartByYear("2008", jobData.get(6));
        createBarChartByYear("2009", jobData.get(7));
        createBarChartByYear("2010", jobData.get(8));
        createBarChartByYear("2011", jobData.get(9));
        createBarChartByYear("2012", jobData.get(10));
        createBarChartByYear("2013", jobData.get(11));
        createBarChartByYear("2014", jobData.get(12));
        createBarChartByYear("2015", jobData.get(13));
        createBarChartByYear("2016", jobData.get(14));

        series.setName("Total Number of Jobs");
        barChart.getData().add(series);

    }

    private void createBarChartByYear(String year, int totalJobs) {
        series.getData().add(new XYChart.Data<>(year, totalJobs));
    }

    public BarChart<String, Number> getBarChartByYear() {
        return barChart;
    }
}
