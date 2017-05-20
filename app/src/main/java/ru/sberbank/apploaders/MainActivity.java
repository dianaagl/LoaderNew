package ru.sberbank.apploaders;



import android.content.Context;
import android.support.v4.app.FragmentManager;
import  android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Animal>{
    private static final int LOADER_ID =1;
    public final String TAG = "main";
    private FragmentManager mFragmentManager;
    private LoaderManager.LoaderCallbacks<Animal> call= this;
    private FragmentTransaction mFragmentTransaction;
    private Button animalBut;
    private Animal data ;
    //private WeakReference<Context> mContext = new WeakReference<Context>(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(LOADER_ID,null,this);
        mFragmentManager = getSupportFragmentManager();


        animalBut = (Button) findViewById(R.id.animal_but);
        animalBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportLoaderManager().restartLoader(LOADER_ID,null,call);
                if(data != null) {
                    FragmentElement myFragment = FragmentElement.newInstance(data.getSpecie(), data.getMass(), data.getHeight(), data.getNickName());
                    mFragmentManager.beginTransaction()

                            .replace(R.id.container, myFragment)
                            .commit();
                }

            }
        });
    }


        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            return new LoaderAnimal(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader loader, Animal data) {
            this.data = data;
            Log.e(TAG,"data."+ data.getNickName());


        }

        @Override
        public void onLoaderReset(Loader loader) {

        }
}
