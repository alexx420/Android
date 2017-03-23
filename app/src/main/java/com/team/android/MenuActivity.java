package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ImageButton menu_credito;
    ImageButton menu_interes;
    ImageButton menu_presupuesto;
    ImageButton menu_sobre_endeudamiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        menu_credito = (ImageButton) findViewById(R.id.img_btn_menu_credito);
        menu_interes = (ImageButton) findViewById(R.id.img_btn_menu_interes);
        menu_presupuesto = (ImageButton) findViewById(R.id.img_btn_menu_presupuesto);
        menu_sobre_endeudamiento = (ImageButton) findViewById(R.id.img_btn_menu_sobre_endeudamiento);
        


        menu_credito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Abrir actividad credito bienvenida
               /* AlertDialog.Builder alertDialog = new AlertDialog.Builder(MenuActivity.this);
                alertDialog.setMessage("Abre activity Credito Bienvenida");
                alertDialog.show();*/
                iniciaCredito();
            }
        });
        menu_interes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Abrir actividad interes bienvenida
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MenuActivity.this);
                alertDialog.setMessage("Abre activity Interes Bienvenida");
                alertDialog.show();
            }
        });
        menu_presupuesto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Abrir actividad presupuesto bienvenida
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MenuActivity.this);
//                alertDialog.setMessage("Abre activity Presupuesto Bienvenida");
//                alertDialog.show();

                iniciaPresupuesto();


            }
        });
        menu_sobre_endeudamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Abrir actividad sobre endeudamiento bienvenida
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MenuActivity.this);
                alertDialog.setMessage("Abre activity Sobre Endeudamiento Bienvenida");
                alertDialog.show();
            }
        });


    }

    public void iniciaPresupuesto() {
        Intent myIntent = new Intent(this, CrJuegoActivity.class);
        startActivity(myIntent);
    }

    public void iniciaCredito(){
        Intent credito = new Intent(MenuActivity.this,CrInfo1Activity.class);
        startActivity(credito);
    }
}
