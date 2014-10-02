package thalia.desktop.client;

import com.sun.jersey.api.client.WebResource;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ServerStatusService extends Service<String> {

    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                WebResource r = ClientConfiguration.get().client.resource(ClientConfiguration.get().adminEndpoint);
                String response = r.path("healthcheck").get(String.class);
                System.out.println(response);
                return response;
            }
        };
    }
}
