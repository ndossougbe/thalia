package thalia.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import thalia.desktop.Screen;
import thalia.desktop.ScreenManager;

import java.util.ResourceBundle;

public class MainMenuController extends AbstractController {
    @FXML
    private Text status_text;
    @FXML
    private ResourceBundle resources;

    public void initialize() {
    }

    public void handleScanDirectoryAction(ActionEvent actionEvent) {
    }

    public void handleManualInputAction(ActionEvent actionEvent) {
        ScreenManager.get().switchTo(Screen.ManualInput);
    }

    public void handleServerStatusAction(ActionEvent actionEvent) {
    }

    public void handleToggleServerAction(ActionEvent actionEvent) {
    }

    public void handleBackupDatabaseAction(ActionEvent actionEvent) {
    }

    public void handleRestoreDatabaseAction(ActionEvent actionEvent) {
    }
}
