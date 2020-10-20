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
import usmanf.Date;
import usmanf.EmployeeNumber;
import usmanf.EmployeeNumberComparator;
import usmanf.EmployeeNumberUtil;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class USManufacturingData extends Application {
    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        final ComboBox<EmployeeNumber> categories = new ComboBox<>();
        categories.setPromptText("--Select a Population Size--");

        final ComboBox<Date> dates = new ComboBox<>();
        dates.setPromptText("---Select a Value---");
        dates.setVisible(false);

        TextScanner ts = new TextScanner();
        Path path = ts.getOutputPath();
        ts.getText(path);
        Map<EmployeeNumber, List<Date>> dateMap = EmployeeNumberUtil.getDateMap(ts.getDates());
        ObservableList<EmployeeNumber> dateRanges = FXCollections.observableArrayList(dateMap.keySet());
        dateRanges.sort(new EmployeeNumberComparator());
        categories.getItems().addAll(dateRanges);

        categories.valueProperty().addListener(new ChangeListener<EmployeeNumber>(){
            @Override
            public void changed(ObservableValue<? extends EmployeeNumber> observable, EmployeeNumber oldValue, EmployeeNumber newValue) {

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
