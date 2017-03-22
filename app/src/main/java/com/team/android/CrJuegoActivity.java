package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by administradorcito on 21/03/2017.
 */

public class CrJuegoActivity extends AppCompatActivity {
    ImageButton dado;
    ImageButton home;
    private int meta = 22;
    private int pos = 0;
    private boolean ganador = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meta = 22;
        pos = 0;
        ganador = false;

        dado = (ImageButton) findViewById(R.id.btn_dado);
        home = (ImageButton) findViewById(R.id.btn_menu);

        dado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tiraDado();
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

    private void tiraDado() {
        if (ganador) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(CrJuegoActivity.this);
            alertDialog.setTitle("Felicidades");
            alertDialog.setMessage("Has llegado a la meta!");
            alertDialog.show();
        } else {


            int valorDado = (int) Math.floor(Math.random() * 6 + 1);
            dado = (ImageButton) findViewById(R.id.btn_dado);
            switch (valorDado) {
                case 1:
                    dado.setImageResource(R.drawable.img_cr_dado1);
                    break;
                case 2:
                    dado.setImageResource(R.drawable.img_cr_dado2);
                    break;
                case 3:
                    dado.setImageResource(R.drawable.img_cr_dado3);
                    break;
                case 4:
                    dado.setImageResource(R.drawable.img_cr_dado4);
                    break;
                case 5:
                    dado.setImageResource(R.drawable.img_cr_dado5);
                    break;
                case 6:
                    dado.setImageResource(R.drawable.img_cr_dado6);
                    break;
            }

            if (this.pos + valorDado == this.meta) {
                this.ganador = true;
            } else {
                this.pos += valorDado;
            }
        }
    }
}
