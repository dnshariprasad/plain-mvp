package com.planemvp.app;

import android.app.Application;

/**
 * Created by Hari on 25/09/17.
 */

public class App extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        component.inject(this);
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
