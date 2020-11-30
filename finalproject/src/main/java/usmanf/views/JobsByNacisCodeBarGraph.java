package usmanf.views;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class JobsByNacisCodeBarGraph {
    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final BarChart<String,Number> barChart = new BarChart <String, Number>(xAxis,yAxis);
    XYChart.Series <String,Number> series = new XYChart.Series<String,Number>();



    public JobsByNacisCodeBarGraph() throws IOException, URISyntaxException {

        getBarChart();
    }
    public BarChart<String,Number> getBarChart () throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalNumberOfJobsByNacisCode();

        barChart.setTitle("U.S. Manufacturing Jobs 2002-2016");
        xAxis.setLabel("NACIS Code");
        yAxis.setLabel("Number of Jobs");

        createBarChart("311",jobData.get(0));
        createBarChart("312",jobData.get(1));
        createBarChart("313",jobData.get(2));
        createBarChart("314",jobData.get(3));

        series.setName("Total Number of Jobs");
        barChart.getData().add(series);

        return barChart;

    }
    private void createBarChart(String year, int totalJobs){
        series.getData().add(new XYChart.Data<String,Number>(year,totalJobs));
    }

}
