package at.htl.todo;


import android.os.Bundle;

import androidx.activity.ComponentActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    @Inject
    MainUiBuilder mainUiBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainUiBuilder.buildContent(this);
    }
}

