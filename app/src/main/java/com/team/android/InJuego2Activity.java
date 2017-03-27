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
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by alexx420 on 21/03/2017.
 */

public class InJuego2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_juego2);
        //respuestas colores
        findViewById(R.id.imageView_c1).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c2).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c3).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c4).setOnLongClickListener(listenClick);

        //set listeners on drag
        findViewById(R.id.imageView_p1).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p2).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p3).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p4).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p5).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p6).setOnDragListener(listenDrag);

        //btn home regresa al menu
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
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
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
                    Drawable dragged_draw = dragged.getDrawable();
                    if (validaRespuesta(dragged, target)) {
                        target.setImageDrawable(dragged_draw);
                        target.setTag("success");
                    }
                    if (validaVictoria())
                        mensajeGanador();
                    break;
            }
            return true;
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
        list.add(findViewById(R.id.imageView_p1));
        list.add(findViewById(R.id.imageView_p2));
        list.add(findViewById(R.id.imageView_p3));
        list.add(findViewById(R.id.imageView_p4));
        list.add(findViewById(R.id.imageView_p5));
        list.add(findViewById(R.id.imageView_p6));
        for (View t : list)
            if (("success").equals(t.getTag()))
                i++;
        return i == 4;
    }

    /**
     * Valida que el elemento arrastrado corresponda a la casilla que lo recibe
     *
     * @param dragged
     * @param target
     * @return
     */
    private boolean validaRespuesta(ImageView dragged, ImageView target) {
        String draggedTag = (String) dragged.getTag();
        String targetTag = (String) target.getTag();
        switch (targetTag) {
            case "imageView_p2":
                if (draggedTag.equals("imageView_c4"))
                    return true;
                break;
            case "imageView_p3":
                if (draggedTag.equals("imageView_c2"))
                    return true;
                break;
            case "imageView_p6":
                if (draggedTag.equals("imageView_c3"))
                    return true;
                break;
            case "imageView_p4":
                if (draggedTag.equals("imageView_c1"))
                    return true;
                break;
        }
        return false;
    }
}




