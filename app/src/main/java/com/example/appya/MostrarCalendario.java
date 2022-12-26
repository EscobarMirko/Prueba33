package com.example.appya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appya.adaptadores.ListaContactosAdapter;
import com.example.appya.db.DbCalendario;
import com.example.appya.db.entidades.Contactos;

import java.util.ArrayList;

public class MostrarCalendario extends AppCompatActivity {

    RecyclerView listacalendario;
    ArrayList<Contactos> listaArrayContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_calendario);

        listacalendario = findViewById(R.id.listaCalendario);
        listacalendario.setLayoutManager(new LinearLayoutManager(this));

        DbCalendario dbCalendario = new DbCalendario(MostrarCalendario.this);

        listaArrayContactos = new ArrayList<>();

        ListaContactosAdapter adapter = new ListaContactosAdapter(dbCalendario.mostrarContactos());
        listacalendario.setAdapter(adapter);
    }
}