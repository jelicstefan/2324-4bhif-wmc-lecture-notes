package at.htl.todo.model;

import org.eclipse.microprofile.config.Config;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.todo.util.resteasy.RestApiClientBuilder;

@Singleton
public class TodoService {

    public static final String JSON_PLACEHOLDER_BASE_URL_SETTING = "json.placeholder.baseurl";
    public final String baseUrl;
    public final TodoClient todoClient;
    public final ModelStore modelStore;

    @Inject // Hilt verlangt Constructor Injection
    TodoService(Config config, RestApiClientBuilder builder, ModelStore modelStore) {
        this.baseUrl = config.getValue(JSON_PLACEHOLDER_BASE_URL_SETTING, String.class);
        todoClient = builder.build(TodoClient.class, baseUrl);
        this.modelStore = modelStore;
    }

    public void getAll() {
        CompletableFuture
                .supplyAsync(() -> todoClient.all())
                .thenAccept(modelStore::setTodos);
        //todoClient.all();  // NetworkOnMainThreadException
    }

}
