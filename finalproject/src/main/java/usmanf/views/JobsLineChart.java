package usmanf.views;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class JobsLineChart {

    CategoryAxis xAxis;
    NumberAxis yAxis;
    LineChart<String, Number> lineChart;
    ChartData chartData;
    List<Integer> data;

    public JobsLineChart() throws IOException, URISyntaxException {
        xAxis = new CategoryAxis();
        xAxis.setLabel("Year");
        yAxis = new NumberAxis();
        yAxis.setLabel("Total Jobs");
        lineChart = new LineChart<String, Number>(xAxis,yAxis);
        chartData = new ChartData();
        createLineChart();

    }

    private void createLineChart(){
        setupLineChart(311, "Food manufacturing");
        setupLineChart(315, "Apparel manufacturing");
        setupLineChart(331, "Primary metal manufacturing");
        setupLineChart(336, "Transportation equipment manufacturing");
    }

    private void setupLineChart(int nacisCode, String industryName){
        XYChart.Series series = new XYChart.Series();
        series.setName(industryName);
        data = chartData.getTotalJobsByOneNacisCode(nacisCode);

        series.getData().add(new XYChart.Data("2002", data.get(0)));
        series.getData().add(new XYChart.Data("2003", data.get(1)));
        series.getData().add(new XYChart.Data("2004", data.get(2)));
        series.getData().add(new XYChart.Data("2005", data.get(3)));
        series.getData().add(new XYChart.Data("2006", data.get(4)));
        series.getData().add(new XYChart.Data("2007", data.get(5)));
        series.getData().add(new XYChart.Data("2008", data.get(6)));
        series.getData().add(new XYChart.Data("2009", data.get(7)));
        series.getData().add(new XYChart.Data("2010", data.get(8)));
        series.getData().add(new XYChart.Data("2011", data.get(9)));
        series.getData().add(new XYChart.Data("2012", data.get(10)));
        series.getData().add(new XYChart.Data("2013", data.get(11)));
        series.getData().add(new XYChart.Data("2014", data.get(12)));
        series.getData().add(new XYChart.Data("2015", data.get(13)));
        series.getData().add(new XYChart.Data("2016", data.get(14)));

        lineChart.getData().add(series);
    }

    public LineChart<String, Number> getLineChart(){
        return lineChart;
    }

}
