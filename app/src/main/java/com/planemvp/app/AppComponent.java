package com.planemvp.app;

import com.planemvp.main.MainActivity;
import com.planemvp.main.MainRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Hari on 25/09/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App application);

    void inject(MainActivity mainActivity);
}
