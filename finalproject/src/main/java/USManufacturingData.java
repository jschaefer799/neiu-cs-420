import api.HttpRequestRetrieval;
import api.Reader;
import api.Writer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import usmanf.views.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class USManufacturingData extends Application {

    public static void main(String[] args) throws URISyntaxException {
        String [] URLList;
        String [] data = new String [60];

        String dir = ClassLoader.getSystemClassLoader().getResource("").toURI().getPath();
        String path = dir.substring(0, dir.indexOf("classes")) + File.separator + "resources";

        path += File.separator + "output.txt";
        Path outputPath = Paths.get(path);
        File file = new File(String.valueOf(outputPath));

        if (!file.exists()) {

            try {
                HttpRequestRetrieval req = new HttpRequestRetrieval();
                Reader newData = new Reader();
                Writer writeToFile = new Writer();

                URLList = req.getURLString();

                for (int i = 0; i < URLList.length; i++){
                    req.establishConnection(URLList[i]);

                    if (req.checkConnection()){
                        data[i] = newData.bufferedReader(req.getConnection(), URLList[i]);
                    }
                }
                writeToFile.writer(data);
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
    try {
//        ChartData chartData = new ChartData();
//        chartData.getTotalJobsByOneNacisCode(336);


        RadioButtons radioButton = new RadioButtons();
        BorderPane borderPane = radioButton.getBorderPane();

        Scene scene2 = new Scene(borderPane, 1000, 1000);
        stage.setTitle("U.S. Manufacturing Radio Buttons");
        stage.setScene(scene2);
        stage.show();

        ////////
        Stage secondStage = new Stage();
        secondStage.setTitle("Combobox");

        ComboBoxDisplays comboBoxDisplays = new ComboBoxDisplays();
        BorderPane borderPane2 = comboBoxDisplays.getBorderPane();
        Scene scene1 = new Scene(borderPane2, 800, 300);
        secondStage.setScene(scene1);
        secondStage.show();
    }
    catch(Exception e){
        System.out.println(e.toString());
    }
    }
}



