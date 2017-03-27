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

public class PrJuego4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr_juego4);
        //set listeners on long click
        findViewById(R.id.imageView_c1).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c2).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c3).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c4).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c5).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c6).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c7).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c8).setOnLongClickListener(listenClick);
        findViewById(R.id.imageView_c9).setOnLongClickListener(listenClick);
        //set listeners on drag
        findViewById(R.id.imageView_p1).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p2).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p3).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p4).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p5).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p6).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p7).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p8).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p9).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p10).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p11).setOnDragListener(listenDrag);
        findViewById(R.id.imageView_p12).setOnDragListener(listenDrag);
        //btn home regresa a menu
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

    private void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }

    private void mensajeGanador() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(PrJuego4Activity.this);
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
                    if (validaRespuesta(dragged, target)) {
                        dragged.setImageDrawable(target_draw);
                        target.setImageDrawable(dragged_draw);
                        target.setTag("success");
                    }
                    if (validaVictoria()) {
                        mensajeGanador();
                        muestraTotal();
                    }
                    break;
            }
            return true;
        }
    };

    /**
     * Muestra la imagen de total en calculadora
     */
    private void muestraTotal() {
        findViewById(R.id.imageView_total).setVisibility(View.VISIBLE);
    }

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
        list.add(findViewById(R.id.imageView_p7));
        list.add(findViewById(R.id.imageView_p8));
        list.add(findViewById(R.id.imageView_p9));
        list.add(findViewById(R.id.imageView_p10));
        list.add(findViewById(R.id.imageView_p11));
        list.add(findViewById(R.id.imageView_p12));
        for (View t : list)
            if (t.getTag().equals("success"))
                i++;
        return i == 9;
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
            case "imageView_p1":
            case "imageView_p2":
            case "imageView_p3":
                if (draggedTag.equals("img_pr_j4_casilla1") || draggedTag.equals("img_pr_j4_casilla4"))
                    return true;
                break;
            case "imageView_p4":
            case "imageView_p5":
            case "imageView_p6":
                if (draggedTag.equals("img_pr_j4_casilla7") || draggedTag.equals("img_pr_j4_casilla8"))
                    return true;
                break;
            case "imageView_p7":
            case "imageView_p8":
            case "imageView_p9":
                if (draggedTag.equals("img_pr_j4_casilla2") || draggedTag.equals("img_pr_j4_casilla6"))
                    return true;
                break;
            case "imageView_p10":
            case "imageView_p11":
            case "imageView_p12":
                if (draggedTag.equals("img_pr_j4_casilla3") || draggedTag.equals("img_pr_j4_casilla5") || draggedTag.equals("img_pr_j4_casilla9"))
                    return true;
                break;
        }
        return false;
    }
}




