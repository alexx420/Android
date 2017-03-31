package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SiSimula5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_simula5);

        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaAnterior();
            }
        });
        findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSiguiente();
            }
        });
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });
    }

    private void iniciaAnterior() {
        Intent myIntent = new Intent(this, SiIngresoActivity.class);
        startActivity(myIntent);
    }

    private void iniciaSiguiente() {
        Intent myIntent = new Intent(this, SiFinActivity.class);
        startActivity(myIntent);
    }

    private void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
