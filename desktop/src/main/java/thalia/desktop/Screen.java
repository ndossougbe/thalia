package thalia.desktop;

import java.net.URL;

public enum Screen {
    MainMenu("views/main_menu.fxml"),
    ManualInput("views/manual_input.fxml"),
    Root("views/root.fxml");


    public final String filename;

    private Screen(String url) {
        this.filename = url;
    }

    public URL getURL() {
        return getClass().getClassLoader().getResource(filename);
    }
}
