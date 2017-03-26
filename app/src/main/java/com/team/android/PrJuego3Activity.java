package com.team.android;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class PrJuego3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_juego3);

        //set listeners on click
        findViewById(R.id.imageButton_o1).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o2).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o3).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o4).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o5).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o6).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o7).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o8).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o9).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o10).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o11).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_o12).setOnClickListener(clickListener);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageButton button = (ImageButton) v;
            int id = v.getId();
            switch (id) {
                case R.id.imageButton_o1:
                    if (button.getTag().equals("img_pr_casilla1_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla1);
                        button.setTag("img_pr_casilla1");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla1_uf);
                        button.setTag("img_pr_casilla1_uf");
                    }
                    break;
                case R.id.imageButton_o2:
                    if (button.getTag().equals("img_pr_casilla2_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla2);
                        button.setTag("img_pr_casilla2");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla2_uf);
                        button.setTag("img_pr_casilla2_uf");
                    }
                    break;
                case R.id.imageButton_o3:
                    if (button.getTag().equals("img_pr_casilla3_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla3);
                        button.setTag("img_pr_casilla3");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla3_uf);
                        button.setTag("img_pr_casilla3_uf");
                    }
                    break;
                case R.id.imageButton_o4:
                    if (button.getTag().equals("img_pr_casilla4_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla4);
                        button.setTag("img_pr_casilla4");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla4_uf);
                        button.setTag("img_pr_casilla4_uf");
                    }
                    break;
                case R.id.imageButton_o5:
                    if (button.getTag().equals("img_pr_casilla5_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla5);
                        button.setTag("img_pr_casilla5");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla5_uf);
                        button.setTag("img_pr_casilla5_uf");
                    }
                    break;
                case R.id.imageButton_o6:
                    if (button.getTag().equals("img_pr_casilla6_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla6);
                        button.setTag("img_pr_casilla6");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla6_uf);
                        button.setTag("img_pr_casilla6_uf");
                    }
                    break;
                case R.id.imageButton_o7:
                    if (button.getTag().equals("img_pr_casilla7_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla7);
                        button.setTag("img_pr_casilla7");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla7_uf);
                        button.setTag("img_pr_casilla7_uf");
                    }
                    break;
                case R.id.imageButton_o8:
                    if (button.getTag().equals("img_pr_casilla8_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla8);
                        button.setTag("img_pr_casilla8");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla8_uf);
                        button.setTag("img_pr_casilla8_uf");
                    }
                    break;
                case R.id.imageButton_o9:
                    if (button.getTag().equals("img_pr_casilla9_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla9);
                        button.setTag("img_pr_casilla9");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla9_uf);
                        button.setTag("img_pr_casilla9_uf");
                    }
                    break;
                case R.id.imageButton_o10:
                    if (button.getTag().equals("img_pr_casilla10_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla10);
                        button.setTag("img_pr_casilla10");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla10_uf);
                        button.setTag("img_pr_casilla10_uf");
                    }
                    break;
                case R.id.imageButton_o11:
                    if (button.getTag().equals("img_pr_casilla11_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla11);
                        button.setTag("img_pr_casilla11");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla11_uf);
                        button.setTag("img_pr_casilla11_uf");
                    }
                    break;
                case R.id.imageButton_o12:
                    if (button.getTag().equals("img_pr_casilla12_uf")) {
                        button.setImageResource(R.drawable.img_pr_casilla12);
                        button.setTag("img_pr_casilla12");
                    } else {
                        button.setImageResource(R.drawable.img_pr_casilla12_uf);
                        button.setTag("img_pr_casilla12_uf");
                    }
                    break;
            }
            //TODO Hacer funcion que valide que ya se seleccionaron todos los elementos correctamente
        }
    };


    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PrJuego3Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("Has llegado a la meta!");
        alertDialog.show();
    }


}




