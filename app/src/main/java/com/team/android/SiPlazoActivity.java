package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SiPlazoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_plazo);

        findViewById(R.id.radioButton_1).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_2).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_3).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_4).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_5).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_6).setOnClickListener(clickListener);

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

    public void iniciaAnterior() {
        Intent myIntent = new Intent(this, SiIngresoActivity.class);
        startActivity(myIntent);
    }

    public void iniciaSiguiente() {
        Intent myIntent = null;
        switch (getIntent().getExtras().getInt("ingreso")) {
            case 1:
                myIntent = new Intent(this, SiSimula1Activity.class);
                break;
            case 2:
                myIntent = new Intent(this, SiSimula2Activity.class);
                break;
            case 3:
                myIntent = new Intent(this, SiSimula3Activity.class);
                break;
            case 4:
                myIntent = new Intent(this, SiSimula4Activity.class);
                break;
            case 5:
                myIntent = new Intent(this, SiSimula5Activity.class);
                break;
        }
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(SiPlazoActivity.this, "Presiona siguiente para continuar", Toast.LENGTH_SHORT).show();
        }
    };

}
