package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

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
        //btn inicia siguiente
        findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSiguiente();
            }
        });
        //btn home regresa al menu
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });
    }

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, PrJuego4Activity.class);
        startActivity(myIntent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageButton button = (ImageButton) v;
            int id = v.getId();
            switch (id) {
                case R.id.imageButton_o1:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla1_err);
                    break;
                case R.id.imageButton_o2:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla2_ok);
                    button.setTag("success");
                    break;
                case R.id.imageButton_o3:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla3_err);
                    break;
                case R.id.imageButton_o4:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla4_err);
                    break;
                case R.id.imageButton_o5:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla5_ok);
                    button.setTag("success");
                    break;
                case R.id.imageButton_o6:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla6_ok);
                    button.setTag("success");
                    break;
                case R.id.imageButton_o7:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla7_err);
                    break;
                case R.id.imageButton_o8:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla8_ok);
                    button.setTag("success");
                    break;
                case R.id.imageButton_o9:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla9_err);
                    break;
                case R.id.imageButton_o10:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla10_err);
                    break;
                case R.id.imageButton_o11:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla11_ok);
                    button.setTag("success");
                    break;
                case R.id.imageButton_o12:
                    button.setImageResource(R.drawable.btn_pr_j3_casilla12_ok);
                    button.setTag("success");
                    break;
            }
            if (validaVictoria())
                mensajeGanador();
        }
    };

    /**
     * Valida que todos los elementos esten en las casillas correctas para terminar el juego
     *
     * @return
     */
    private boolean validaVictoria() {
        int i = 0;
        ArrayList<View> list = new ArrayList<>();
        list.add(findViewById(R.id.imageButton_o1));
        list.add(findViewById(R.id.imageButton_o2));
        list.add(findViewById(R.id.imageButton_o3));
        list.add(findViewById(R.id.imageButton_o4));
        list.add(findViewById(R.id.imageButton_o5));
        list.add(findViewById(R.id.imageButton_o6));
        list.add(findViewById(R.id.imageButton_o7));
        list.add(findViewById(R.id.imageButton_o8));
        list.add(findViewById(R.id.imageButton_o9));
        list.add(findViewById(R.id.imageButton_o10));
        list.add(findViewById(R.id.imageButton_o11));
        list.add(findViewById(R.id.imageButton_o12));
        for (View t : list)
            if (t.getTag().equals("success"))
                i++;
        return i == 6;
    }


    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PrJuego3Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }


}




