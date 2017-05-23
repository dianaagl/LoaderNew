package ru.sberbank.apploaders;

import android.app.Application;

/**
 * Created by user8 on 20.05.2017.
 */

public class AnimalApplication extends Application {
    private  AnimalLists storage ;

    @Override
    public void onCreate() {
        storage = new AnimalLists();
        super.onCreate();
    }

    public AnimalLists getStorage() {
        return storage;
    }
}
