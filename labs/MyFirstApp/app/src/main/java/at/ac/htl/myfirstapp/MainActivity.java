package at.ac.htl.myfirstapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import at.ac.htl.myfirstapp.model.Model;
import at.ac.htl.myfirstapp.model.Store;
import at.ac.htl.myfirstapp.ui.layout.MainView;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainView mainView;

    @Inject
    Store store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        store.subject.subscribe(model -> Log.i(TAG, model.greeting));
        var model = new Model();
        model.greeting="Juhu";
        store.subject.onNext(model);
        mainView.compose(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
}

