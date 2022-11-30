package com.example.appya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button botonScan,botonMas,botonPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        botonScan = (Button)findViewById(R.id.btnIngresoScan);
        botonMas = (Button)findViewById(R.id.btnMas);
        botonPerfil = (Button)findViewById(R.id.btnPerfil);

        botonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,MainEscaneoActivity.class);
                startActivity(i);
            }
        });


        botonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(MainActivity2.this,MainActivity_base_dato.class);
                startActivity(m);
            }
        });

        botonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity2.this,Inicio.class);
                startActivity(i);
                finish();
            }
        });



    }
}