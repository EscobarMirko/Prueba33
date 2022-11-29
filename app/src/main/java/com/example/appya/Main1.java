package com.example.appya;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main1 extends AppCompatActivity {
    daoContacto dao;
    Adaptador adapter;
    ArrayList<Contacto> lista;
    Contacto c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        dao=new daoContacto(this);
        lista=dao.verTodos();
        adapter=new Adaptador(this,lista,dao);
        ListView list=(ListView)findViewById(R.id.lista);
        Button agregar=(Button)findViewById(R.id.agregar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Dialogo para ver lista previa de registro vista.xml
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialogo agregar dialogo.xml
                final Dialog dialogo=new Dialog(Main1.this);
                dialogo.setTitle("Nuevo registro");
                dialogo.setCancelable(true);
                dialogo.setContentView(R.layout.dialogo);
                dialogo.show();
                final EditText nombre=(EditText)dialogo.findViewById(R.id.nombre);
                final EditText precio=(EditText)dialogo.findViewById(R.id.precio);
                final EditText marca=(EditText)dialogo.findViewById(R.id.marca);
                final EditText cant=(EditText)dialogo.findViewById(R.id.cant);
                final EditText com=(EditText)dialogo.findViewById(R.id.com);
                Button guardar=(Button)dialogo.findViewById(R.id.d_agregar);
                guardar.setText("Agregar");
                Button cancelar=(Button)dialogo.findViewById(R.id.d_cancelar);
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                           c=new Contacto(nombre.getText().toString(),
                            precio.getText().toString(),
                            marca.getText().toString(),
                                   Integer.parseInt(cant.getText().toString()),
                                   com.getText().toString());
                           dao.insertar(c);
                           lista=dao.verTodos();
                           adapter.notifyDataSetChanged();
                           dialogo.dismiss();
                        }catch (Exception e){
                            Toast.makeText(getApplication(), "ERROR", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogo.dismiss();
                    }
                });
            }
        });

    }
}
