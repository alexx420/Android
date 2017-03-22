package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by administradorcito on 21/03/2017.
 */

public class PrInfo2Activity extends AppCompatActivity {
    ImageButton siguiente;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        siguiente = (ImageButton) findViewById(R.id.btn_siguiente);
        home = (ImageButton) findViewById(R.id.btn_menu);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO alexx420 agregar siguiente activity
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    private void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
