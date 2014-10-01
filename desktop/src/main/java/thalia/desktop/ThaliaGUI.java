package thalia.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ThaliaGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ScreenManager.create();
        Scene scene = new Scene(ScreenManager.get().getRootScreen(), 800, 600);

        stage.setTitle(ScreenManager.get().getResources().getString("WINDOW_TITLE"));
        stage.setScene(scene);
        stage.show();
    }

}
