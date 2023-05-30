package com.vgsg.myapplication.ui.pedidos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vgsg.myapplication.DBPedidos;
import com.vgsg.myapplication.R;

import java.util.ArrayList;

public class PedidosFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;

    ArrayList<String> names;
    private String mParam2;

    public PedidosFragment() {

    }

    public static PedidosFragment newInstance(String param1, String param2) {
        PedidosFragment fragment = new PedidosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_pedidos, container, false);

        ListView ltvPedidos = (ListView)v.findViewById(R.id.lvtpedidosrealiza);

        DBPedidos db = new DBPedidos(getContext());
        SQLiteDatabase data = db.getReadableDatabase();
        Cursor c = data.rawQuery("select * from pedidos",null);

        names = new ArrayList<String>();

        if(c.moveToFirst()){
               do{
                   names.add(c.getString(1));
               }while(c.moveToNext());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, names);
        ltvPedidos.setAdapter(adapter);
        return v;
    }
}