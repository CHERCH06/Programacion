package com.ausentes.regresionlineal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int tiempoTranscurrir = 2000; //1 segundo, 1000 millisegundos.

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);

                handler.removeCallbacks(null);
            }
        }, tiempoTranscurrir );//define el tiempo.
    }
}