package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SiBnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_bn);

        findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciaSiguiente();
            }
        });

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresaInicio();
            }
        });

    }

    public void iniciaSiguiente() {
        Intent myIntent = new Intent(this, SiInfo1Activity.class);
        startActivity(myIntent);
    }

    public void regresaInicio() {
        Intent myIntent = new Intent(this, MenuActivity.class);
        startActivity(myIntent);
    }
}
