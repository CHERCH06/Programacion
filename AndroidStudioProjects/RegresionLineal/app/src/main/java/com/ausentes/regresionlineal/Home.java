package com.ausentes.regresionlineal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class Home extends AppCompatActivity {
    private String[] headers = {"Valores X","Valores Y"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TableLayout tL = (TableLayout) findViewById(R.id.tableLayout1);
        EditText txtX = (EditText) findViewById(R.id.txtX);
        EditText txtY = (EditText) findViewById(R.id.txtY);
        Button btnAdd = (Button) findViewById(R.id.btnadd);
        Button btnCalc = (Button) findViewById(R.id.btncalculo);

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

        TableDynamic tableDynamic = new TableDynamic(tL,getApplicationContext());
        tableDynamic.addHeader(headers);
    }

    private void agregar(String textoX, String textoY) {

    }
}