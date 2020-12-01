package usmanf.views;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URISyntaxException;

public class RadioButtons {

    HBox hBox = new HBox();
    ToggleGroup toggleGroup = new ToggleGroup();
    JobsByYearPieChart numberJobsPieChart = new JobsByYearPieChart();
    PieChart pieChart;

    JobsByYearBarGraph numberJobsBarGraph = new JobsByYearBarGraph();
    BarChart barChart1;

    JobsByNacisCodeBarGraph jobsByNacisCode = new JobsByNacisCodeBarGraph();
    BarChart barChart2;

    BorderPane borderPane = new BorderPane();
    Label label = new Label("View Total Jobs By: ");

    SubmitButton submitButton = new SubmitButton();

    public RadioButtons() throws IOException, URISyntaxException {
        createAndAddRadioButtons();
        pieChart = numberJobsPieChart.getPieChart();
        barChart1 = numberJobsBarGraph.getBarChart();
        barChart2 = jobsByNacisCode.getBarChart();
    }
    private void createAndAddRadioButtons() {


        RadioButton rb1 = new javafx.scene.control.RadioButton("Pie Chart: Year");
        rb1.setToggleGroup(toggleGroup);
        rb1.setUserData("Pie Chart: Year");

        RadioButton rb2 = new javafx.scene.control.RadioButton("Bar Chart: Year");
        rb2.setToggleGroup(toggleGroup);
        rb2.setUserData("Bar Chart: Year");

        RadioButton rb3 = new javafx.scene.control.RadioButton("Bar Chart: NACIS Code");
        rb3.setToggleGroup(toggleGroup);
        rb3.setUserData("Bar Chart: NACIS Code");

        hBox.getChildren().addAll(label,rb1,rb2,rb3,submitButton.getButton());
        borderPane.setTop(hBox);


        submitButton.getButton().setOnAction(e-> {
            if (rb1.isSelected()) {
                rb1.setGraphic(pieChart);
                borderPane.setCenter(rb1);

            }
            if (rb2.isSelected()) {
                rb2.setGraphic(barChart1);
                borderPane.setCenter(rb2);
            }
            if (rb3.isSelected()) {
                rb3.setGraphic(barChart2);
                borderPane.setCenter(rb3);
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
