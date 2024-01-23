package at.ac.htl.myfirstapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;
import at.ac.htl.myfirstapp.ui.layout.MainViewKt;

public class MainActivity extends ComponentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        MainViewKt.compose(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
}

