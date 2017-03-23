package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by administradorcito on 21/03/2017.
 */

public class CrJuegoActivity extends AppCompatActivity {
    Button dado;
    ImageButton home;
    private int meta = 22;
    private int pos = 0;
    private boolean ganador = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Agregar imagen del dado en 3d para el boton de tirar, una imagen con flechita que diga tirar y agregar efecto oscurecio de las casillas cuando no se encuentren activas
        meta = 22;
        pos = 0;
        ganador = false;

        dado = (Button) findViewById(R.id.btn_dado);
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
            ImageView imgv_dado = (ImageView) findViewById(R.id.imageView_dado);
            switch (valorDado) {
                case 1:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado1);
                    break;
                case 2:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado2);
                    break;
                case 3:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado3);
                    break;
                case 4:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado4);
                    break;
                case 5:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado5);
                    break;
                case 6:
                    imgv_dado.setImageResource(R.drawable.img_cr_dado6);
                    break;
            }

            if (this.pos + valorDado == this.meta) {
                this.ganador = true;
            } else {
                //opaca casilla del tiro anterior
                int id_view = getId("imageViewC" + this.pos, R.id.class);
                ImageView imgv_casilla = (ImageView) findViewById(id_view);
                int id_drwbl = getId("img_cr_casilla" + this.pos + "_uf", R.drawable.class);
                imgv_casilla.setImageResource(id_drwbl);
                //activa casilla del tiro nuevo
                this.pos += valorDado;
                id_view = getId("imageViewC" + this.pos, R.id.class);
                imgv_casilla = (ImageView) findViewById(id_view);
                id_drwbl = getId("img_cr_casilla" + this.pos, R.drawable.class);
                imgv_casilla.setImageResource(id_drwbl);
            }
        }
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}
