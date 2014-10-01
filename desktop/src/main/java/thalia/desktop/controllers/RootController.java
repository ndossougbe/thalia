package thalia.desktop.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import thalia.desktop.Screen;
import thalia.desktop.ScreenManager;

public class RootController extends AbstractController {

    @FXML
    private Pane container;


    public void initialize() {
        container.getChildren().add(ScreenManager.get().getNode(Screen.MainMenu));
    }


    public void setContent(Parent node) {
        container.getChildren().clear();
        container.getChildren().add(node);
    }

    public void handleMenuScreenAction(ActionEvent actionEvent) {
        ScreenManager.get().switchTo(Screen.MainMenu);
    }
}
