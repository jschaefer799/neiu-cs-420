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
        List<Integer> jobData = chartData.getTotalNumberOfJobs();

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                      new PieChart.Data("2002", jobData.get(0)),
                        new PieChart.Data("2003", jobData.get(1)),
                        new PieChart.Data("2004", jobData.get(2)),
                        new PieChart.Data("2005", jobData.get(3)),
                        new PieChart.Data("2006", jobData.get(4)),
                        new PieChart.Data("2007", jobData.get(5)),
                        new PieChart.Data("2008", jobData.get(6)),
                        new PieChart.Data("2009", jobData.get(7)),
                        new PieChart.Data("2010", jobData.get(8)),
                        new PieChart.Data("2011", jobData.get(9)),
                        new PieChart.Data("2012", jobData.get(10)),
                        new PieChart.Data("2013", jobData.get(11)),
                        new PieChart.Data("2014", jobData.get(12)),
                        new PieChart.Data("2015", jobData.get(13)),
                        new PieChart.Data("2016", jobData.get(14)));

        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Total Jobs in U.S. Manufacturing Industry 2002-2006");
        return chart;
    }

}
