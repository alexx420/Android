package com.team.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by alexx420 on 21/03/2017.
 */
public class CrJuego1Activity extends AppCompatActivity {
    private int meta = 22;
    private int pos = 0;
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
            muestraPregunta();
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
        final Pregunta preguntaRandom = obtenerPreguntaRandom();
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

    private Pregunta obtenerPreguntaRandom() {
        Pregunta pregunta;
        int numeroRandom = (int) Math.floor(Math.random() * Pregunta.values().length + 1);
        pregunta = Pregunta.valueOf("P_" + numeroRandom);
        return pregunta;
    }
}