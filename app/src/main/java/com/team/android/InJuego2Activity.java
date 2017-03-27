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

public class InJuego2Activity extends AppCompatActivity {
    ImageView imageview_azul;
    ImageView imageview_naranja;
    ImageView imageview_verde;
    ImageView imageview_morado;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_juego2);
        //respuestas colores
        imageview_azul = (ImageView) findViewById(R.id.imageView_c7);
        imageview_naranja = (ImageView) findViewById(R.id.imageView_naranja);
        imageview_verde = (ImageView) findViewById(R.id.imageView_verde);
        imageview_morado = (ImageView) findViewById(R.id.imageView_morado);

        //set listeners on long click
        imageview_azul.setOnLongClickListener(listenClick);
        imageview_naranja.setOnLongClickListener(listenClick);
        imageview_verde.setOnLongClickListener(listenClick);
        imageview_morado.setOnLongClickListener(listenClick);

        //set listeners on drag
        findViewById(R.id.imageView_p12).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p2).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p3).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p4).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p5).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p6).setOnDragListener(listenDrag);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    private class DragShadow extends View.DragShadowBuilder {
        ColorDrawable greyBox;

        public DragShadow(View view) {
            super(view);
            greyBox = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            greyBox.draw(canvas);
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize,
                                           Point shadowTouchPoint) {
            View v = getView();

            int height = (int) v.getHeight();
            int width = (int) v.getWidth();

            greyBox.setBounds(0, 0, width, height);

            shadowSize.set(width, height);

            shadowTouchPoint.set((int) width / 2, (int) height / 2);
        }
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    public void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(InJuego2Activity.this);
        alertDialog.setTitle("Felicidades");
        alertDialog.setMessage("¡Juego terminado!");
        alertDialog.show();
    }

    View.OnLongClickListener listenClick = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            ClipData data = ClipData.newPlainText("", "");
            DragShadow dragShadow = new DragShadow(v);

            v.startDrag(data, dragShadow, v, 0);

            return false;
        }
    };

    View.OnDragListener listenDrag = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent) {
                case DragEvent.ACTION_DROP:
                    ImageView target = (ImageView) v;

                    ImageView dragged = (ImageView) event.getLocalState();

                    Drawable target_draw = target.getDrawable();
                    Drawable dragged_draw = dragged.getDrawable();

                    //TODO preguntar si esta soltando el objeto en la respuesta correcta

//                    dragged.setImageDrawable(target_draw);
                    target.setImageDrawable(dragged_draw);

                    //TODO mostrar mensaje de victoria

                    break;
            }

            return true;
        }
    };
}




