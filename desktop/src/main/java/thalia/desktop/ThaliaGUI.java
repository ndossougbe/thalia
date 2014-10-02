package thalia.desktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import thalia.ThaliaApplication;
import thalia.desktop.client.ClientConfiguration;

public class ThaliaGUI extends Application {

    public static void main(String[] args) throws Exception {
        ThaliaApplication server = new ThaliaApplication();
        server.run(new String[]{"server", "server/config.yaml"});
        ClientConfiguration.init(server.getApiPort());
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
