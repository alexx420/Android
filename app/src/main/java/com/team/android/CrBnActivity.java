package com.team.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CrBnActivity extends AppCompatActivity {
    ImageButton siguiente;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_cr_bn );

        siguiente = (ImageButton) findViewById(R.id.btn_siguiente);
        home = (ImageButton) findViewById(R.id.btn_menu);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sgt = new Intent (CrBnActivity.this, CrInfo1Activity.class);
                startActivity( sgt );
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hm = new Intent (CrBnActivity.this, MenuActivity.class);
                startActivity( hm );
            }
        });

    }
}
