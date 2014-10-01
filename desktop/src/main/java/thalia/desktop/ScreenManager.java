package thalia.desktop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import thalia.desktop.controllers.AbstractController;
import thalia.desktop.controllers.RootController;
import thalia.desktop.utils.UTF8Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Used for screen/scene creation and switch
 */
public class ScreenManager {

    private static ScreenManager instance;

    private final Map<Screen, ScreenData> screens = new HashMap<>();
    private final Locale locale;
    private final ResourceBundle resources;

    private ScreenData rootScreenData;

    private ScreenManager() {
//        locale  = new Locale("en", "EN");
        locale = new Locale("fr", "FR");
        resources = ResourceBundle.getBundle("strings.strings", locale, new UTF8Control());

    }

    public static ScreenManager get() {
        if (instance == null) throw new RuntimeException("No ScreenManager instance");
        return instance;
    }

    public static void create() throws IOException {
        instance = new ScreenManager();
        instance.rootScreenData = initializeScreen(Screen.Root, instance.resources);
    }

    private static ScreenData initializeScreen(Screen screen, ResourceBundle resources) {
        ScreenData newScreenData;
        FXMLLoader loader = new FXMLLoader(screen.getURL(), resources);
        try { // TODO proper exception management
            Parent pane = loader.load();
            newScreenData = new ScreenData(loader.getController(), pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newScreenData;
    }

    public ResourceBundle getResources() {
        return resources;
    }

    private ScreenData getScreenData(Screen screen) {
        if (screen == Screen.Root) throw new RuntimeException("Getting Screen.Root?!?");
        if (!screens.containsKey(screen)) {
            screens.put(screen, initializeScreen(screen, resources));
        }
        return screens.get(screen);
    }

    public Parent getNode(Screen screen) {
        return getScreenData(screen).pane;
    }

    public void switchTo(Screen screen, boolean reset) {
        if (reset) getScreenData(screen).controller.reset();
        ((RootController) (rootScreenData.controller)).setContent(getScreenData(screen).pane);
    }

    public void switchTo(Screen screen) {
        switchTo(screen, true);
    }

    public Parent getRootScreen() {
        return rootScreenData.pane;
    }

    private static class ScreenData {
        public final Parent pane;
        public final AbstractController controller;

        private ScreenData(AbstractController controller, Parent pane) {
            this.controller = controller;
            this.pane = pane;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ScreenData that = (ScreenData) o;

            if (!controller.equals(that.controller)) return false;
            if (!pane.equals(that.pane)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = pane.hashCode();
            result = 31 * result + controller.hashCode();
            return result;
        }
    }
}
