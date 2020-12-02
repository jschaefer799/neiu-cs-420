package usmanf.views;

import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URISyntaxException;

public class RadioButtons {

    HBox hBox;
    ToggleGroup toggleGroup;
    JobsByYearPieChart numberJobsPieChart;
    PieChart pieChart;

    JobsByYearBarGraph numberJobsBarGraph;
    BarChart barChart1;

    JobsLineChart jobsLineChart;
    LineChart lineChart;

    BorderPane borderPane;
    Label label;

    SubmitButton submitButton = new SubmitButton();

    public RadioButtons() throws IOException, URISyntaxException {
        hBox = new HBox();
        toggleGroup = new ToggleGroup();
        numberJobsPieChart = new JobsByYearPieChart();

        numberJobsBarGraph = new JobsByYearBarGraph();

        jobsLineChart = new JobsLineChart();

        borderPane = new BorderPane();
        label = new Label("View Total Jobs By: ");

        createAndAddRadioButtons();
        pieChart = numberJobsPieChart.getPieChart();
        barChart1 = numberJobsBarGraph.getBarChartByYear();
        lineChart = jobsLineChart.getLineChart();
    }
    private void createAndAddRadioButtons() {

        RadioButton rb1 = new javafx.scene.control.RadioButton("Year: Pie Chart");
        rb1.setToggleGroup(toggleGroup);
        rb1.setUserData("Pie Chart: Year");

        RadioButton rb2 = new javafx.scene.control.RadioButton("Year: Bar Chart");
        rb2.setToggleGroup(toggleGroup);
        rb2.setUserData("Bar Chart: Year");

        RadioButton rb3 = new javafx.scene.control.RadioButton("Line Chart: NACIS Code Total Jobs By Year");
        rb3.setToggleGroup(toggleGroup);
        rb3.setUserData("Line Chart: NACIS Code Total Jobs By Year");

        hBox.getChildren().addAll(label,rb1,rb2,rb3,submitButton.getButton());
        hBox.setSpacing(10);
        HBox.setMargin(label, new Insets(20, 30, 5, 20));
        HBox.setMargin(rb1, new Insets(20, 30, 5, 20));
        HBox.setMargin(rb2, new Insets(20, 30, 5, 20));
        HBox.setMargin(rb3, new Insets(20, 30, 5, 20));
        HBox.setMargin(submitButton.getButton(), new Insets(20, 5, 5, 20));

        borderPane.setTop(hBox);


        submitButton.getButton().setOnAction(e-> {
            if (rb1.isSelected()) {
                borderPane.setCenter(pieChart);

            }
            if (rb2.isSelected()) {
                borderPane.setCenter(barChart1);
            }
            if (rb3.isSelected()) {
                borderPane.setCenter(lineChart);
            }
        });
    }

    public BorderPane getBorderPane(){
        return borderPane;
    }

    public HBox getVBox(){
        return hBox;
    }
}
