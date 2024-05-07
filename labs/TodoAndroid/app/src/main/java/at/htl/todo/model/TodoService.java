package at.htl.todo.model;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
//public class TodoService {
//
//
//    public static final String JSON_PLACEHOLDER_BASE_URL_SETTING = "json.placeholder.baseurl";
//    public final String baseUrl;
//    public final ToDoClient toDoClient;
//    public final ModelStore store;
//
//    @Inject
//    ToDoService(Config config, RestApiClientBuilder builder, ModelStore store) {
//        this.baseUrl = config.getValue(JSON_PLACEHOLDER_BASE_URL_SETTING, String.class);
//        toDoClient = builder.build(ToDoClient.class, baseUrl);
//        this.store = store;
//    }
//
//    public void getAll() {
//        CompletableFuture
//                .supplyAsync(() -> toDoClient.all())
//                .thenAccept(store::setTodos);
//    }
//
//}
