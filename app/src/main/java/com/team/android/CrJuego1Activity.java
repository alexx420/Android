package com.team.android;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class CrJuego1Activity extends AppCompatActivity {
    private ImageButton dado;
    private ImageButton home;
    private int meta = 22;
    private int pos = 0;
    private boolean ganador = false;
    private Pregunta anterior = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_juego1);

        meta = 22;
        pos = 0;
        ganador = false;

        dado = (ImageButton) findViewById(R.id.btn_dado);
        home = (ImageButton) findViewById(R.id.btn_home);

        dado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    tiraDado();
                } catch (Exception e) {
                    Log.e(this.toString(), e.getMessage());
                }
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(CrJuego1Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }

    public void tiraDado() throws NoSuchFieldException, IllegalAccessException {
        //pregunta si es ganador
        if (ganador) {
            //si
            // muestra mensaje
            mensajeGanador();
        } else {
            //no
            // tira dado
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
            //muestra pregunta si es acierto avanza las casillas sino se regresa
            muestraPregunta();
            if (isAcierto) {

                int anterior = this.pos;
                //pregunta si llega a la meta
                if (this.pos + valorDado == this.meta) {
                    //es ganador
                    this.ganador = true;
                    this.pos += valorDado;
                } else if (this.pos + valorDado > this.meta) {
                    //pregunta si se pasa
                    //no suma valor
                } else {
                    this.pos += valorDado;
                }
                //pinta casillas
                //opaca casilla del tiro anterior
                int id_view = getId("imageViewC" + anterior, R.id.class);
                ImageView imgv_casilla = (ImageView) findViewById(id_view);
                int id_drwbl = getId("img_cr_casilla" + anterior + "_uf", R.drawable.class);
                imgv_casilla.setImageResource(id_drwbl);

                //activa casilla del tiro nuevo
                id_view = getId("imageViewC" + this.pos, R.id.class);
                imgv_casilla = (ImageView) findViewById(id_view);
                id_drwbl = getId("img_cr_casilla" + this.pos, R.drawable.class);
                imgv_casilla.setImageResource(id_drwbl);
                //pregunta si es ganador
                if (ganador) {
                    //si
                    // muestra mensaje
                    mensajeGanador();
                }
            }
        }
    }

    public static int getId(String resourceName, Class<?> c) throws IllegalAccessException, NoSuchFieldException {
        Field idField = c.getDeclaredField(resourceName);
        return idField.getInt(idField);
    }

    private boolean isAcierto;

    private void muestraToast() {
        if (isAcierto)
            Toast.makeText(this, "Correcto! avanzas a la siguiente casilla", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Incorrecto, retrocedes las casillas que avanzaste", Toast.LENGTH_SHORT).show();
    }

    private void muestraPregunta() {
        final Pregunta preguntaRandom = obtenerPreguntaRandom();
        AlertDialog.Builder builder = new AlertDialog.Builder(CrJuego1Activity.this);
        builder.setTitle("Pregunta");
        builder.setMessage(preguntaRandom.getPregunta())
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (preguntaRandom.isRespuesta())
                            isAcierto = true;
                        else
                            isAcierto = false;
                        muestraToast();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (!preguntaRandom.isRespuesta())
                            isAcierto = true;
                        else
                            isAcierto = false;
                        muestraToast();
                    }
                });
        builder.create();
        builder.show();
    }

    private Pregunta obtenerPreguntaRandom() {
        Pregunta pregunta;
        int numeroRandom = (int) Math.floor(Math.random() * 9 + 1);
        do {
            pregunta = Pregunta.valueOf("P_" + numeroRandom);
        } while (pregunta.equals(anterior));

        anterior = pregunta;
        return pregunta;
    }


}

enum Pregunta {

    P_1("¿Usamos el crédito cuando tenemos la necesidad o la meta de adquirir un bien cuyo valor esta fuera de nuestras Posibilidades?", true),
    P_2("¿Sólo podemos usar el crédito a nuestro favor para comprar productos simples y cotidianos?", false),
    P_3("¿Sólo podemos usar el crédito a nuestro favor para comprar productos con precio elevado?", false),
    P_4("¿En la sociedad actual prácticamente no hay consumo importante sin crédito?", true),
    P_5("¿En la sociedad actual prácticamente no hay necesidad de utilizar el crédito?", false),
    P_6("¿El crédito nunca se puede usar a nuestro favor?", false),
    P_7("¿El crédito es un instrumento financiero?", true),
    P_8("¿El crédito bien utilizado se puede usar a nuestro favor?", true),
    P_9("¿El crédito es un instrumento estadístico?", false);

    private final String pregunta;
    private final boolean respuesta;

    Pregunta(String pregunta, boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }


}
