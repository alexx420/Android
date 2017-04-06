package com.team.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        String date = df.format(Calendar.getInstance().getTime());
        if (!(date.equals("06042017") || date.equals("07042017"))) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("License expired.Please contact administrator");
            alertDialog.show();
        } else {
            findViewById(R.id.btn_cr_credito).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciaCredito();
                }
            });
            findViewById(R.id.btn_in_intereses).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciaInteres();
                }
            });
            findViewById(R.id.btn_pr_presupuesto).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciaPresupuesto();
                }
            });
            findViewById(R.id.btn_so_endeudamiento).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciaEndeudamiento();
                }
            });
            findViewById(R.id.btn_si_simulador).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iniciaSimulador();
                }
            });
        }
    }

    public void iniciaPresupuesto() {
        Intent myIntent = new Intent(this, PrBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaCredito() {
        Intent myIntent = new Intent(this, CrBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaEndeudamiento() {
        Intent myIntent = new Intent(this, SoBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaInteres() {
        Intent myIntent = new Intent(this, InBnActivity.class);
        startActivity(myIntent);
    }

    public void iniciaSimulador() {
        Intent myIntent = new Intent(this, SiBnActivity.class);
        startActivity(myIntent);
    }
}
