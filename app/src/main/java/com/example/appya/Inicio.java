package com.example.appya;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
    Button btnEditar, btnEliminar, btnMostrar, btnSalir, btnCalendario,btnMostrarCal;
    TextView nombre;
    int id = 0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        nombre = (TextView) findViewById(R.id.nombreUsuario);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnMostrarCal = (Button) findViewById(R.id.btnMostrarCal);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnCalendario = (Button) findViewById(R.id.btnCalendario);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        btnCalendario.setOnClickListener(this);
        btnMostrarCal.setOnClickListener(this);



        Bundle b = getIntent().getExtras();
        id = b.getInt("Id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);
        nombre.setText(u.getNombre() + " " + u.getApellidos());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditar:
                Intent a = new Intent(Inicio.this, Editar.class);
                a.putExtra("Id",id);
                startActivity(a);
                break;
            case R.id.btnEliminar:
                //Dialogo para eliminar registro
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage("Estas seguro de que quieres eliminar tu cuenta???");
                b.setCancelable(false);
                b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i) {
                        if (dao.deleteUsuario(id)){
                            Toast.makeText(Inicio.this, "Se elimino correctamente!!", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(Inicio.this, MainActivity.class);
                            a.putExtra("Id",id);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(Inicio.this,"ERROR: No se elimino la cuenta",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                b.setNegativeButton("No",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface,int i) {
                    dialogInterface.cancel();
                }
            });
                b.show();
                break;


            case R.id.btnMostrar:
                Intent c = new Intent(Inicio.this, Mostrar.class);
                startActivity(c);
                break;
            case R.id.btnSalir:
                Intent i2 = new Intent(Inicio.this, MainActivity.class);
                startActivity(i2);
                finish();
                break;

            case R.id.btnCalendario:
                Intent c2 = new Intent(Inicio.this, Calendario.class);
                startActivity(c2);
                finish();
                break;

            case R.id.btnMostrarCal:
                Intent c3 = new Intent(Inicio.this, MostrarCalendario.class);
                startActivity(c3);
                finish();
                break;


        }
    }
}
