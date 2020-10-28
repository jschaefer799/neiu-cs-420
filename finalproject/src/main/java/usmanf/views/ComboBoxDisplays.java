package usmanf.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import usmanf.models.CustomDate;
import usmanf.models.TotalJobs;
import static usmanf.models.TotalJobsUtil.getDateMap;
import filereader.BufferedReaderOutputFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static javafx.collections.FXCollections.observableArrayList;

public class ComboBoxDisplays {

    private ComboBox<TotalJobs> categories;
    private ComboBox<CustomDate> dates;
    private Map<TotalJobs, List<CustomDate>> datesMap;
    private ObservableList<TotalJobs> totals;
    private Text textBox;
    private List<CustomDate> datesList;
    private Path path;
    BufferedReaderOutputFile bufferedReaderOutputFile = new BufferedReaderOutputFile();


    public ComboBoxDisplays() throws URISyntaxException, IOException {
        path = bufferedReaderOutputFile.getOutputPath();
        bufferedReaderOutputFile.bufferedReaderOutput(path);
        datesList = bufferedReaderOutputFile.getDates();
        datesMap = getDateMap(datesList);
        totals = observableArrayList(datesMap.keySet());
        textBox = new Text();
        setUpCategories();
        setUpDates();
    }

    private class DatesStringConverter extends StringConverter<CustomDate> {

        private final String SEP = ", Industry NACIS Code: ";
        @Override
        public String toString(CustomDate dates) {
            if (dates == null)
                return null;
            else
                return dates.getYear() + SEP + dates.getNacisCode();
        }

        @Override
        public CustomDate fromString(String string) {
            int nacisCode = Integer.parseInt(string.split(SEP)[2]);
            BufferedReaderOutputFile bufferedReaderOutputFile = new BufferedReaderOutputFile();
            for (CustomDate dates: bufferedReaderOutputFile.getDates()){
                if (dates.getNacisCode() == nacisCode)
                    return dates;
            }
            return null;
        }


    }

    private ObservableList<TotalJobs> sortTotals(){
        return totals.sorted(new Comparator<TotalJobs>(){
           @Override
           public int compare(TotalJobs o1, TotalJobs o2){
               if (o1.getMin() < o2.getMin())
                   return -1;
               else if (o1.getMin() > o2.getMin())
                   return 1;
               else
                   return 0;
           }
        });
    }

    private void setUpDates(){
        dates = new ComboBox<>();
        dates.setPromptText("--Select a Value--");
        dates.setConverter(new DatesStringConverter());
        dates.setVisible(false);
        createDatesSelectionListener();
        handleDatesComboBoxUpdate();
    }

    private void handleDatesComboBoxUpdate(){
        dates.setButtonCell(new ListCell<>(){
            @Override
            protected void updateItem(CustomDate dates, boolean empty){
                super.updateItem(dates, empty);
                if (empty || dates == null)
                    setText("--Select a Value--");
                else{
                    DatesStringConverter converter = new DatesStringConverter();
                    setText(converter.toString(dates));
                }
            }
        });
    }

    private void createDatesSelectionListener(){
        dates.valueProperty().addListener(new ChangeListener<CustomDate>(){
            @Override
            public void changed (ObservableValue<? extends CustomDate> observable, CustomDate oldValue, CustomDate newValue){
                if (newValue != null){
                    String displayText = "Year: " + newValue.getYear() + "\n"
                            + "NACIS Code: " + newValue.getNacisCode() + "\n"
                            + "Industry Name: " + newValue.getIndustryName() + "\n"
                            + "Total Jobs: " + newValue.getTotalJobs();

                    textBox.setText(displayText);
                    textBox.setVisible(true);
                }
            }
        });
    }

    private void setUpCategories(){
        categories = new ComboBox<>();
        categories.getItems().addAll(sortTotals());
        categories.setPromptText("--Select a Value--");
        categories.valueProperty().addListener(new ChangeListener<TotalJobs>(){
            @Override
            public void changed (ObservableValue<? extends TotalJobs> observable, TotalJobs oldValue, TotalJobs newValue){
                textBox.setVisible(false);
                dates.getItems().clear();
                dates.getItems().addAll(datesMap.get(newValue));
                dates.setVisible(true);
            }
        });
    }

    public ComboBox<TotalJobs> getCategories(){
        return categories;
    }

    public ComboBox<CustomDate> getDates(){
        return dates;
    }

    public Text getTextBox(){
        return textBox;
    }
}
