package com.ausentes.regresionlineal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Calculos extends AppCompatActivity {
    String x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos);
        x = getIntent().getExtras().getString("x","Error de datos");
        y = getIntent().getExtras().getString("y","Error de datos");
        Toast.makeText(getApplicationContext(),x,Toast.LENGTH_LONG).show();
    }
}