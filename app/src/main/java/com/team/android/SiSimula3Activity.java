package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static java.lang.String.format;

public class SiSimula3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_simula3);

        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaAnterior();
            }
        });

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });
        int plazo = getIntent().getExtras().getInt("plazo");
        int meses = -1;
        String prestamo = "-1";
        switch (plazo) {
            case 1:
                meses = 6;
                prestamo = "9,968.88";
                break;
            case 2:
                meses = 9;
                prestamo = "14,267.80";
                break;
            case 3:
                meses = 12;
                prestamo = "17,978.66";
                break;
            case 4:
                meses = 18;
                prestamo = "24,637.97";
                break;
            case 5:
                meses = 24;
                prestamo = "29,125.78";
                break;
            case 6:
                meses = 30;
                prestamo = "32,640.77";
                break;
        }
        Toast.makeText(this, format("Si ganas $10,000.00 a un plazo de %d meses, FONACOT te presta $%s", meses, prestamo), Toast.LENGTH_LONG).show();

    }

    private void iniciaAnterior() {
        Intent myIntent = new Intent(this, SiIngresoActivity.class);
        startActivity(myIntent);
    }



    private void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
