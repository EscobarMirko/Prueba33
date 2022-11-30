package com.example.appya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.zxing.integration.android.IntentIntegrator;
//import com.google.zxing.integration.android.IntentResult;

public class MainEscaneoActivity extends AppCompatActivity {

    //dede aqui
    Button bntScan;
    EditText txtResultado;
    Button btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_escaneo);
        bntScan = findViewById(R.id.btnScan);
        txtResultado = findViewById(R.id.txtResultado);
        btnVolver = (Button)findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainEscaneoActivity.this,MainActivity2.class);
                startActivity(a);
            }
        });

        /*/se programa la accion del boton
        bntScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator integrador = new IntentIntegrator(MainEscaneoActivity.this); //se pone la actividad
                //ahora le pasamos propiedades al integrador
                integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                //indicamos una pequeña leyenda o titulo
                integrador.setPrompt("Lector - CDP");
                // integramos la camara
                integrador.setCameraId(0);
                //agregamos la alerta de sonido
                integrador.setBeepEnabled(true);
                //para que pueda leer los codigos de barra
                integrador.setBarcodeImageEnabled(true);
                //con esto se puede iniciar el lector de escaneo
                integrador.initiateScan();





            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this,"Lectura cancelada", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,result.getContents(), Toast.LENGTH_LONG).show();
                txtResultado.setText(result.getContents());
            }

        }else{
            super.onActivityResult(requestCode, resultCode, data);

        }*/



    }


}