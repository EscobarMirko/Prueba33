package com.example.appya.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.appya.Calendario;
import com.example.appya.db.entidades.Contactos;

import java.util.ArrayList;

public class DbCalendario extends DbHelper{

    Context context;

    public DbCalendario(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarCalendario(String titulo, String fecha, String lugar){

        long id = 0;
        try {
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("titulo", titulo);
        values.put("fecha", fecha);
        values.put("lugar", lugar);

        id = db.insert(TABLE_CONTACTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Contactos> mostrarContactos(){
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contactos = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM "+ TABLE_CONTACTOS,null);

        if (cursorContactos.moveToFirst()){
            do {
                contactos = new Contactos();
                contactos.setId(cursorContactos.getInt(0));
                contactos.setTitulo(cursorContactos.getString(1));
                contactos.setLugar(cursorContactos.getString(2));
                contactos.setFecha(cursorContactos.getString(3));
                listaContactos.add(contactos);
            }while (cursorContactos.moveToNext());
        }
        cursorContactos.close();

        return listaContactos;
    }
}
