package at.htl.todo;


import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import org.eclipse.microprofile.config.Config;

import javax.inject.Inject;

import at.htl.todo.model.TodoService;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Config config;

    @Inject
    MainUiBuilder mainUiBuilder;

    @Inject
    TodoService todoService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var url = config.getValue("json.placeholder.baseurl", String.class);
        todoService.getAll();
        mainUiBuilder.buildContent(this);
    }
}

