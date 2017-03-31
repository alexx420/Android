package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SiIngresoActivity extends AppCompatActivity {

    private int ingreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_ingreso);

        findViewById(R.id.radioButton_1).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_2).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_3).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_4).setOnClickListener(clickListener);
        findViewById(R.id.radioButton_5).setOnClickListener(clickListener);

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

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, SiPlazoActivity.class);
        myIntent.putExtra("ingreso", ingreso);
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.radioButton_5:
                    ingreso = 1;
                    break;
                case R.id.radioButton_4:
                    ingreso = 2;
                    break;
                case R.id.radioButton_3:
                    ingreso = 3;
                    break;
                case R.id.radioButton_2:
                    ingreso = 4;
                    break;
                case R.id.radioButton_1:
                    ingreso = 5;
                    break;
            }
            Toast.makeText(SiIngresoActivity.this, "Presiona siguiente para continuar", Toast.LENGTH_SHORT).show();
        }
    };


}
