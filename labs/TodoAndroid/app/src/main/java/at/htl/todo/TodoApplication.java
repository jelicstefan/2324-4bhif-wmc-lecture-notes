package at.htl.todo;

import android.app.Application;
import android.util.Log;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class TodoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TodoApplication.class.getSimpleName(), "App started");
    }
}
