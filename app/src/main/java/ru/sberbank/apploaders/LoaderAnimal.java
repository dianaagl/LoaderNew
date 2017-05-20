package ru.sberbank.apploaders;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.Random;

/**
 * Created by user8 on 18.05.2017.
 */

public class LoaderAnimal extends AsyncTaskLoader {
    final Random random = new Random();

    public LoaderAnimal(Context context) {
        super(context);
        forceLoad();


    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        AnimalLists l = new AnimalLists();
    }

    @Override
    public Object loadInBackground() {
        int k = Math.abs(random.nextInt())%3;
        Animal n= AnimalLists.getList().get(k);
        return n;
    }
}
