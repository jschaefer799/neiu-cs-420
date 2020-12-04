package usmanf.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class JobsPieChart {

    PieChart pieChart;

    public JobsPieChart() {
        pieChart = new PieChart();
    }

    public PieChart getPieChart () throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalNumberOfJobsByNacisCode();
        pieChart.setTitle("U.S. Manufacturing Total Jobs for Sub-Sectors 311, 315, 331 and 336 for 2002-2016");

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                      new PieChart.Data("311: Food Manufacturing", jobData.get(0)),
                        new PieChart.Data("315: Apparel Manufacturing", jobData.get(1)),
                        new PieChart.Data("331: Primary Metal Manufacturing", jobData.get(2)),
                        new PieChart.Data("336: Transportation Equipment Manufacturing", jobData.get(3)));

        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Total Jobs in U.S. Manufacturing Industry 2002-2006");
        return chart;
    }

}
