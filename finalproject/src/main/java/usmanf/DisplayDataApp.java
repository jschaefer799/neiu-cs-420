package usmanf;

import api.Writer;
import filereader.TextScanner;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DisplayDataApp extends Application {
    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        final ComboBox<String> categories = new ComboBox<>();
        categories.setPromptText("--Select a value--");

        final ComboBox<Date> dates = new ComboBox<>();
        dates.setVisible(false);

        TextScanner ts = new TextScanner();
        Path path = ts.getOutputPath();
        ts.getText(path);
        Map<String, List<Date>> dateMap = Date.getDateMap(ts.getDates());
        ObservableList<String> dateRanges = FXCollections.observableArrayList(dateMap.keySet());
        categories.getItems().addAll(dateRanges);

        categories.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                dates.getItems().clear();
                dates.getItems().addAll(dateMap.get(newValue));
                dates.setVisible(true);
            }

        });

        BorderPane pane = new BorderPane();
        pane.setTop(categories);
        pane.setCenter(dates);
        Scene scene = new Scene (pane, 300, 300);
        stage.setScene(scene);
        stage.setTitle("U.S. Manufacturing Jobs");
        stage.show();
    }
}
