package com.planemvp.app;

import android.content.Context;

import com.planemvp.main.DataRepository;
import com.planemvp.main.MainRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hari on 25/09/17.
 */


@Module
public class AppModule {

    private final App application;

    public AppModule(App app) {
        this.application = app;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    MainRepository providesBooksRepository() {
        return new DataRepository();
    }
}
