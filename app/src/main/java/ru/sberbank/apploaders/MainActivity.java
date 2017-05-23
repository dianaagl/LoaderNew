package ru.sberbank.apploaders;



import android.content.Intent;
import android.support.v4.app.FragmentManager;
import  android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List>{
    private static final int LOADER_ID =1;
    public static final String TAG = "main";
    private ListView list;
    private AnimalLists storage;
    AnimalAdapter adapter;
    //private WeakReference<Context> mContext = new WeakReference<Context>(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = ((AnimalApplication)getApplication()).getStorage();
        getSupportLoaderManager().initLoader(LOADER_ID,null,this);


        list = (ListView) findViewById(R.id.listAnimals);


        adapter = new AnimalAdapter();
        list.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.animals_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_animal: {
                startActivity(new Intent(this, CreateAnimal.class));
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
        public Loader onCreateLoader(int id, Bundle args) {
            return new LoaderAnimal(MainActivity.this,storage);
        }



    @Override
    public void onLoadFinished(Loader<List> loader, List data) {

        adapter.setAnimals(new ArrayList<Animal>(data));
        Log.e(TAG,"data.");
    }

        @Override
        public void onLoaderReset(Loader loader) {

        }

}
