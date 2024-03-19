package at.ac.htl.myfirstapp.business;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.ac.htl.myfirstapp.model.Store;

@Singleton
public class Logger {

    public static final String TAG = Logger.class.getSimpleName();

    @Inject
    Store store;

    @Inject   // notwendig für Dagger-Hilt - Injection
    public Logger() {}

    public void subscribe() {
        store.subject
                .map(model -> model.firstName + " " + model.lastName)
                .distinctUntilChanged()
                .subscribe(name -> Log.i(TAG, name));
    }

}
