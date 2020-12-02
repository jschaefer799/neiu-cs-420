package usmanf.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class JobsByYearPieChart {

    private PieChart pieChart;

    public JobsByYearPieChart() {
        this.pieChart = new PieChart();
    }

    public PieChart getPieChart () throws IOException, URISyntaxException {
        ChartData chartData = new ChartData();
        List<Integer> jobData = chartData.getTotalNumberOfJobsByNacisCode();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                      new PieChart.Data("311", jobData.get(0)),
                        new PieChart.Data("315", jobData.get(1)),
                        new PieChart.Data("331", jobData.get(2)),
                        new PieChart.Data("336", jobData.get(3)));

        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Total Jobs in U.S. Manufacturing Industry 2002-2006");
        return chart;
    }

}
