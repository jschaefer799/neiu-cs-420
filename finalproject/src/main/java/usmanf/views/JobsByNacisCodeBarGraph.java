package usmanf.views;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class JobsByNacisCodeBarGraph {
    private final CategoryAxis xAxis;
    private final NumberAxis yAxis;
    private final BarChart<String, Number> barChart;
    XYChart.Series<String, Number> series;


    public JobsByNacisCodeBarGraph() throws IOException, URISyntaxException {
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        barChart = new BarChart<String, Number>(xAxis, yAxis);
        series = new XYChart.Series<String, Number>();
        setupBarChartNacisCode();
    }

    public BarChart<String, Number> setupBarChartNacisCode() throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalNumberOfJobsByNacisCode();

        barChart.setTitle("U.S. Manufacturing Jobs 2002-2016");
        xAxis.setLabel("NACIS Code");
        yAxis.setLabel("Number of Jobs");

        createBarChartByNacisCode("311", jobData.get(0));
        createBarChartByNacisCode("312", jobData.get(1));
        createBarChartByNacisCode("313", jobData.get(2));
        createBarChartByNacisCode("314", jobData.get(3));

        series.setName("Total Number of Jobs");
        barChart.getData().add(series);

        return barChart;

    }

    private void createBarChartByNacisCode(String nacisCode, int totalJobs) {
        series.getData().add(new XYChart.Data<String, Number>(nacisCode, totalJobs));
    }

    public BarChart<String, Number> getBarChartByNacisCode(){
        return barChart;

    }
}
