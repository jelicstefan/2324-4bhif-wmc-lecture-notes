package at.htl.todo;


import android.os.Bundle;

import androidx.activity.ComponentActivity;

import org.eclipse.microprofile.config.Config;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {

    @Inject
    Config config;

    @Inject
    MainUiBuilder mainUiBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        var url = config.getValue("json.placeholder.baseurl", String.class);
        mainUiBuilder.buildContent(this);
    }
}

