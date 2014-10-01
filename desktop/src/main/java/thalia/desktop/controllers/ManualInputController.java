package thalia.desktop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputControl;
import org.controlsfx.control.CheckListView;

public class ManualInputController extends AbstractController {

    @FXML
    private TextInputControl titleField;

    @FXML
    private TextInputControl descriptionField;

    @FXML
    private CheckListView<String> genresField;

    public void initialize() {
        final ObservableList<String> strings = FXCollections.observableArrayList();
        for (int i = 0; i <= 5; i++) {
            strings.add("Genre " + i);
        }
        genresField.setItems(strings);
    }

    public void handleFormSubmit(ActionEvent actionEvent) {
        System.out.println(titleField.getText());
        System.out.println(descriptionField.getText());
        System.out.println(genresField.getCheckModel().getCheckedIndices());
    }

    @Override
    public void reset() {
        titleField.clear();
        descriptionField.clear();
        genresField.getCheckModel().clearChecks();
    }
}
