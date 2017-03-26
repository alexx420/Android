package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    ImageButton menu_credito;
    ImageButton menu_interes;
    ImageButton menu_presupuesto;
    ImageButton menu_sobre_endeudamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menu_credito = (ImageButton) findViewById(R.id.img_btn_home_credito);
        menu_interes = (ImageButton) findViewById(R.id.img_btn_home_interes);
        menu_presupuesto = (ImageButton) findViewById(R.id.img_btn_home_presupuesto);
        menu_sobre_endeudamiento = (ImageButton) findViewById(R.id.img_btn_home_sobre_endeudamiento);
        menu_credito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaCredito();
            }
        });
        menu_interes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaInteres();
            }
        });
        menu_presupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaPresupuesto();
            }
        });
        menu_sobre_endeudamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaEndeudamiento();
            }
        });
    }

    public void iniciaPresupuesto() {
        Intent myIntent = new Intent(this, PrBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaCredito() {
        Intent myIntent = new Intent(this, CrBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaEndeudamiento() {
        Intent myIntent = new Intent(this, SoBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaInteres() {
        Intent myIntent = new Intent(this, InBnActivity.class);
        startActivity(myIntent);
    }
}
