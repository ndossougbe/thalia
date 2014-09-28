package thalia.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thalia.desktop.utils.UTF8Control;

import java.util.Locale;
import java.util.ResourceBundle;

public class ThaliaGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        final Locale locale = new Locale("fr", "FR");
//       final Locale locale = new Locale("en", "EN");
        final ResourceBundle resources = ResourceBundle.getBundle("strings.strings", locale, new UTF8Control());

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(resources);
        Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("views/main_menu.fxml").openStream());

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle(resources.getString("WINDOW_TITLE"));
        stage.setScene(scene);
        stage.show();
    }

}
