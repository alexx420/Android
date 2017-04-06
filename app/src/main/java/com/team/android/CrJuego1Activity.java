package com.team.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alexx420 on 21/03/2017.
 */
public class CrJuego1Activity extends AppCompatActivity {
    private int meta = 22;
    private int pos = 0;
    private int count = 0;
    private boolean ganador = false;
    private int valorDado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_juego1);
        findViewById(R.id.btn_dado);
        findViewById(R.id.btn_home);
        findViewById(R.id.btn_dado).setOnClickListener(diceListener);
        findViewById(R.id.btn_home).setOnClickListener(homeListener);
        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrJuego1Activity.this, CrInstJuegoActivity.class));
            }
        });
    }

    View.OnClickListener diceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tiraDado();
        }
    };
    View.OnClickListener homeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            regresaInicio();
        }
    };

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    private void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CrJuego1Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }

    private void tiraDado() {
        if (ganador) {
            mensajeGanador();
        } else {
            valorDado = (int) Math.floor(Math.random() * 6 + 1);
            ImageView imgv_dado = (ImageView) findViewById(R.id.spinning_dice_image);
            switch (valorDado) {
                case 1:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f1);
                    break;
                case 2:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f2);
                    break;
                case 3:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f3);
                    break;
                case 4:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f4);
                    break;
                case 5:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f5);
                    break;
                case 6:
                    imgv_dado.setBackgroundResource(R.drawable.spin_animation_f6);
                    break;
            }
            CustomAnimationDrawable frameAnimation = new CustomAnimationDrawable(
                    (AnimationDrawable) imgv_dado.getBackground()) {
                @Override
                void onAnimationFinish() {
                    muestraPregunta();
                }
            };
            imgv_dado.setBackgroundDrawable(frameAnimation);
            frameAnimation.setOneShot(true);
            frameAnimation.start();
        }
    }

    private void avanzaCasillas() {
        int anterior = this.pos;
        if (this.pos + valorDado >= this.meta) {
            this.ganador = true;
            this.pos = 22;
        } else {
            this.pos += valorDado;
        }
        int id_view = getId("imageViewC" + anterior, R.id.class);
        ImageView imgv_casilla = (ImageView) findViewById(id_view);
        int id_drwbl = getId("img_cr_casilla" + anterior + "_uf", R.drawable.class);
        imgv_casilla.setImageResource(id_drwbl);
        id_view = getId("imageViewC" + this.pos, R.id.class);
        imgv_casilla = (ImageView) findViewById(id_view);
        id_drwbl = getId("img_cr_casilla" + this.pos, R.drawable.class);
        imgv_casilla.setImageResource(id_drwbl);
        if (ganador) {
            mensajeGanador();
        }
    }

    private int getId(String resourceName, Class<?> c) {
        int id = -1;
        Field idField;
        try {
            idField = c.getDeclaredField(resourceName);
            id = idField.getInt(idField);
        } catch (Exception e) {
            System.err.println("mensaje: " + e.getMessage());
            System.err.println("resopurce name: " + resourceName);
        }
        return id;
    }

    private void muestraToast(boolean isAcierto) {
        if (isAcierto)
            Toast.makeText(this, "Correcto! avanzas a la siguiente casilla", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Incorrecto, te quedas en tu misma casilla", Toast.LENGTH_SHORT).show();
    }

    private void muestraPregunta() {
        final Pregunta preguntaRandom = obtenerPregunta();
        AlertDialog.Builder builder = new AlertDialog.Builder(CrJuego1Activity.this);
        builder.setTitle("Pregunta");
        builder.setCancelable(false);
        builder.create();
        builder.setMessage(preguntaRandom.getPregunta())
                .setPositiveButton("Verdadero", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (preguntaRandom.isRespuesta())
                            avanzaCasillas();
                        dialog.dismiss();
                        muestraToast(preguntaRandom.isRespuesta());
                    }
                })
                .setNegativeButton("Falso", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!preguntaRandom.isRespuesta())
                            avanzaCasillas();
                        dialog.dismiss();
                        muestraToast(!preguntaRandom.isRespuesta());
                    }
                });
        builder.show();
    }

    private Pregunta obtenerPregunta() {
        if (count >= Pregunta.values().length)
            count = 0;
        List preguntas = Arrays.asList(Pregunta.values());
        Pregunta pregunta = (Pregunta) preguntas.get(count);
        count++;
        return pregunta;
    }
}