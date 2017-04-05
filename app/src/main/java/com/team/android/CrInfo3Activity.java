package com.team.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CrInfo3Activity extends AppCompatActivity {
    ImageButton siguiente;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_info3);

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
                startActivity(new Intent(CrInfo3Activity.this, CrInfo2Activity.class));
            }
        });
    }

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, CrInfo4Activity.class);
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
