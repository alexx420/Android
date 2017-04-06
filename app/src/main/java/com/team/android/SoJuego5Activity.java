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
public class SoJuego5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_juego5);
        //set listeners on click
        findViewById(R.id.imageButton_f1).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v1).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f2).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v2).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f3).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v3).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f4).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v4).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f5).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v5).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f6).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v6).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_f7).setOnClickListener(clickListener);
        findViewById(R.id.imageButton_v7).setOnClickListener(clickListener);
        //btn home regresa a menu
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

        findViewById(R.id.btn_anterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SoJuego5Activity.this, SoInstJuegoActivity.class));
            }
        });
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageButton button = (ImageButton) v;
            int id = v.getId();
            switch (id) {
                case R.id.imageButton_f1:
                    button.setImageResource(R.drawable.btn_so_j5_falso);
                    button.setTag("success");
                    break;
                case R.id.imageButton_f2:
                    button.setImageResource(R.drawable.btn_so_j5_falso_err);
                    break;
                case R.id.imageButton_f3:
                    button.setImageResource(R.drawable.btn_so_j5_falso);
                    button.setTag("success");
                    break;
                case R.id.imageButton_f4:
                    button.setImageResource(R.drawable.btn_so_j5_falso_err);
                    break;
                case R.id.imageButton_f5:
                    button.setImageResource(R.drawable.btn_so_j5_falso_err);
                    break;
                case R.id.imageButton_f6:
                    button.setImageResource(R.drawable.btn_so_j5_falso);
                    button.setTag("success");
                    break;
                case R.id.imageButton_f7:
                    button.setImageResource(R.drawable.btn_so_j5_falso_err);
                    break;
                case R.id.imageButton_v1:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero_err);
                    break;
                case R.id.imageButton_v2:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero);
                    button.setTag("success");
                    break;
                case R.id.imageButton_v3:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero_err);
                    break;
                case R.id.imageButton_v4:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero);
                    button.setTag("success");
                    break;
                case R.id.imageButton_v5:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero);
                    button.setTag("success");
                    break;
                case R.id.imageButton_v6:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero_err);
                    break;
                case R.id.imageButton_v7:
                    button.setImageResource(R.drawable.btn_so_j5_verdadero);
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
        list.add(findViewById(R.id.imageButton_f1));
        list.add(findViewById(R.id.imageButton_v1));
        list.add(findViewById(R.id.imageButton_f2));
        list.add(findViewById(R.id.imageButton_v2));
        list.add(findViewById(R.id.imageButton_f3));
        list.add(findViewById(R.id.imageButton_v3));
        list.add(findViewById(R.id.imageButton_f4));
        list.add(findViewById(R.id.imageButton_v4));
        list.add(findViewById(R.id.imageButton_f5));
        list.add(findViewById(R.id.imageButton_v5));
        list.add(findViewById(R.id.imageButton_f6));
        list.add(findViewById(R.id.imageButton_v6));
        list.add(findViewById(R.id.imageButton_f7));
        list.add(findViewById(R.id.imageButton_v7));
        for (View t : list)
            if (("success").equals(t.getTag()))
                i++;
        return i == 7;
    }

    private void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    private void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SoJuego5Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }
}




