package ru.sberbank.apploaders;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user8 on 18.05.2017.
 */

public class LoaderAnimal extends AsyncTaskLoader<List<Animal>> implements AnimalLists.onChangeContentListener{

    AnimalLists storage ;
    private List<Animal> cacheAnimal;

    public LoaderAnimal(Context context,AnimalLists storage) {
        super(context);
        this.storage = storage;
        storage.AddListener(this);
    }


    @Override
    public void deliverResult(List<Animal> data) {
        super.deliverResult(data);
        cacheAnimal = new ArrayList<>(data);

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        if(cacheAnimal == null || takeContentChanged()){
            forceLoad();
        }





    }

    @Override
    public List<Animal> loadInBackground() {

        List<Animal> n= storage.getList();
        return n;
    }

    @Override
    public void Added(AnimalLists sender, Animal animal) {
        onContentChanged();
        storage.RemoveListener(this);
    }
}
