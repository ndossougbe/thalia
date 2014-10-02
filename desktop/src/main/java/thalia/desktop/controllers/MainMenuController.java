package thalia.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import thalia.desktop.Screen;
import thalia.desktop.ScreenManager;
import thalia.desktop.client.ServerStatusService;

import java.util.ResourceBundle;

public class MainMenuController extends AbstractController {
    @FXML
    private Text statusText;
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
        ServerStatusService statusService = new ServerStatusService();
        statusService.setOnSucceeded(e -> statusText.setText(e.getSource().getValue().toString()));
        statusService.setOnFailed(e -> {
            statusText.setText(e.getSource().getException().getMessage());
            throw new RuntimeException(e.getSource().getException());
        });
        statusService.start();
    }

    public void handleBackupDatabaseAction(ActionEvent actionEvent) {
    }

    public void handleRestoreDatabaseAction(ActionEvent actionEvent) {
    }
}
