package thalia.desktop.client;

import com.sun.jersey.api.client.Client;

public class ClientConfiguration {
    private final int apiPort;
    public final String apiEndpoint;
    public final String adminEndpoint;
    public final Client client;

    public static ClientConfiguration instance;

    public static ClientConfiguration get() {
        return instance;
    }

    public static void init(int port) {
        instance = new ClientConfiguration(port);
    }

    public ClientConfiguration(int port) {
        apiPort = port;
        apiEndpoint = "http://localhost:" + apiPort + "/api";
        adminEndpoint = "http://localhost:" + apiPort + "/admin";
        client = Client.create();
    }
}
