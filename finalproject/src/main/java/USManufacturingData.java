import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import usmanf.models.CustomDate;
import usmanf.models.TotalJobs;
import usmanf.views.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class USManufacturingData extends Application {

    private ComboBoxDisplays comboBoxes;

    public static void main (String [] args){

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        RadioButtons radioButton = new RadioButtons();
        HBox hBox = radioButton.getVBox();
        hBox.setSpacing(10);
        BorderPane borderPane = radioButton.getBorderPane();

        Scene scene2 = new Scene (borderPane,1000, 1000);
        stage.setTitle("U.S. Manufacturing Radio Buttons");
        stage.setScene(scene2);
        stage.show();

        Stage secondStage = new Stage();
        secondStage.setTitle("Combobox");
        comboBoxes = new ComboBoxDisplays();

        BorderPane borderPane2 = new BorderPane();
        setUpBorderPane(borderPane2);

        Scene scene1 = new Scene(borderPane2, 800, 300);
        secondStage.setScene(scene1);
        secondStage.show();

    }

    private void setUpBorderPane (BorderPane borderPane){
        HBox hBox = new HBox();
        setUpHBox(hBox);
        borderPane.setTop(hBox);
    }

    private void setUpHBox (HBox hBox){
        hBox.setSpacing(10);
        ComboBox<TotalJobs> totals = comboBoxes.getCategories();
        ComboBox<CustomDate> dates = comboBoxes.getDates();
        Text textBox = comboBoxes.getTextBox();
        hBox.getChildren().addAll(totals, dates, textBox);
        HBox.setMargin(totals, new Insets(20, 5, 5, 20));
        HBox.setMargin(dates, new Insets(20, 5, 5, 20));
        HBox.setMargin(textBox, new Insets(20, 5, 5, 20));
    }
}

