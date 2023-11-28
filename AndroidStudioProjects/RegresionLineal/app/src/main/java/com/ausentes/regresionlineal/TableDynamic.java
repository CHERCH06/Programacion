package com.ausentes.regresionlineal;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TableDynamic {
    private TableLayout tableLayout;
    private Context context;
    private String[] headers;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView lblCell;
    private int indexCol;
    private int indexRow;

    public TableDynamic (TableLayout tableLayout,Context context){
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void addHeader(String[] header){
        this.headers = header;
    }

    public void addData(ArrayList<String[]> data){
        this.data = data;
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCell(){
        lblCell = new TextView(context);
        lblCell.setGravity(Gravity.CENTER);
        lblCell.setTextSize(25);
    }

    private void CreateHeader(){
        indexCol = 0;
        newRow();
        while(indexCol<headers.length){
            newCell();
            lblCell.setText(headers[indexCol++]);
            tableRow.addView(lblCell,newTableParams());
        }
        tableRow.addView(tableRow);
    }

    private void CreateDataTable (){
        String info;
        for(indexRow=0;indexRow<=headers.length;indexRow++){
            newRow();
            for(indexCol=0;indexCol<=headers.length;indexCol++){
                newCell();
                String[] columns = data.get(indexRow-1);
                info = (indexCol<=columns.length)?columns[indexCol]:"";
                lblCell.setText(info);
                tableRow.addView(lblCell,newTableParams());
            }
            tableLayout.addView(tableRow);
        }
    }

    private TableRow.LayoutParams newTableParams(){
        TableRow.LayoutParams params = new ViewGroup.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight=1;
        return params;
    }
}
