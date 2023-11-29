package com.ausentes.regresionlineal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    String[] headers;
    String x,y;
    ArrayList<String[]> data = new ArrayList<>();
    ArrayList<String> datosx = new ArrayList<>();;
    ArrayList<String> datosy = new ArrayList<>();;
    EditText txtX,txtY;
    Button btnAdd,btnCalc;
    TextView lbldataX,lbldataY,lbltitx,lbltity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        headers = new String[] {"Valores X","Valores Y"};
        String[] val = {"Valores X","Valores Y"};
        data.add(val);

        txtX = (EditText) findViewById(R.id.txtX);
        txtY = (EditText) findViewById(R.id.txtY);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnCalc = (Button) findViewById(R.id.btncalculo);
        lbldataX = (TextView) findViewById(R.id.lbldataX);
        lbldataY = (TextView) findViewById(R.id.lbldataY);
        lbltitx = (TextView) findViewById(R.id.lbltitX);
        lbltity = (TextView) findViewById(R.id.lblTitY);

        boolean ban = false;

        init(ban);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ban = false;
                String textoX = txtX.getText().toString().trim();
                String textoY = txtY.getText().toString().trim();
                if(textoX.equals("")){
                    txtX.setError("No puede estar vacio");
                }else{
                    ban = true;
                }
                if(textoY.equals("")){
                    txtY.setError("No puede estar vacio");
                    ban = false;
                }else{
                    ban = true;
                }
                if(ban){
                    agregar(textoX,textoY);
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Calculos.class);
                intent.putExtra("x", x);
                intent.putExtra("y", y);
                startActivity(intent);
            }
        });

    }

    private void init(boolean ban) {
        btnCalc.setEnabled(ban);
        int v;
        if(ban){
            v = View.VISIBLE;
        }else{
            v = View.GONE;
        }
        lbltitx.setVisibility(v);
        lbltity.setVisibility(v);
        lbldataX.setVisibility(v);
        lbldataY.setVisibility(v);

    }

    private void agregar(String textoX, String textoY) {
        datosx = new ArrayList<>();
        datosy = new ArrayList<>();

        try{
            datosx.add(textoX);
            datosy.add(textoY);
            init(true);
            actualizar();
            limpiar();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error try: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {
        txtX.setText("");
        txtY.setText("");
    }

    private void actualizar() {
        x = lbldataX.getText().toString();
        y = lbldataY.getText().toString();

        Object[] xar = datosx.toArray();
        Object[] yar = datosy.toArray();
        for(int i=0;i<datosx.size();i++){
            if(x.equals("")){
                x += xar[i];
            }else{
                x += "\n"+xar[i];
            }
            if(y.equals("")){
                y += yar[i];
            }else{
                y += "\n"+yar[i];
            }
        }
        lbldataX.setText(x);
        lbldataY.setText(y);
    }
}