package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class InInfo2Activity extends AppCompatActivity {
    ImageButton siguiente;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_info2);
        siguiente = (ImageButton) findViewById(R.id.btn_siguiente);
        home = (ImageButton) findViewById(R.id.btn_home);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSiguiente();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });
        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InInfo2Activity.this, InInfo1Activity.class));
            }
        });
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, InInfo3Activity.class);
        startActivity(myIntent);
    }
}
