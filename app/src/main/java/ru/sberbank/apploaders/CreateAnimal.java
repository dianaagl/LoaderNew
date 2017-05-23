package ru.sberbank.apploaders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by user8 on 20.05.2017.
 */

public class CreateAnimal extends AppCompatActivity {
    private Button addButton;
    private EditText nameEditText;
    private EditText specieEditText;
    private EditText heightEditText;
    private EditText weightEditText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_animal);
        addButton = (Button) findViewById(R.id.add_but);
        nameEditText = (EditText) findViewById(R.id.input_name);
        weightEditText = (EditText) findViewById(R.id.input_weight);
        specieEditText = (EditText) findViewById(R.id.input_specie);
        heightEditText = (EditText) findViewById(R.id.input_height);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal anim = new Animal(specieEditText.getText().toString()
                        , Integer.parseInt(weightEditText.getText().toString()),
                        Integer.parseInt(heightEditText.getText().toString()), nameEditText.getText().toString());
                ((AnimalApplication)getApplication()).getStorage().addAnimal(anim);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }
}
