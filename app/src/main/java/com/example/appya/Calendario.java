package com.example.appya;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.appya.db.DbCalendario;
import com.example.appya.db.DbHelper;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Calendario extends AppCompatActivity implements View.OnClickListener{


    private TextView tvtitulo, tllugar,tltitulo;
    private Spinner spinner_im, comboDias;
    private TextInputLayout  tlobersavaciones;
    Button btnfecha, btnhora, btnregis, btncan;
    private EditText ethora, etfecha;
    daoUsuario dao;

    private int dia, mes, anio, hora, minutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        referencias();
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.combo_dias, android.R.layout.simple_spinner_item);
        comboDias.setAdapter(adapter);

    }

    public void referencias() {
        btnfecha = findViewById(R.id.btnfecha);
        btnhora = findViewById(R.id.btnhora);
        btnregis = findViewById(R.id.btnregis);
        btncan = findViewById(R.id.btncan);
        tvtitulo = findViewById(R.id.tvTitulo);
        ethora = findViewById(R.id.ethora);
        etfecha = findViewById(R.id.etfecha);
        comboDias = findViewById(R.id.spinner_im);
        tltitulo = findViewById(R.id.tltitulo);
        tlobersavaciones = findViewById(R.id.tlobservaciones);
        tllugar = findViewById(R.id.tllugar);
        dao = new daoUsuario(this);

        eventos();

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnfecha:
                final Calendar c =Calendar.getInstance();
                dia= c.get(Calendar.DAY_OF_MONTH);
                mes= c.get(Calendar.MONTH);
                anio= c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        etfecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,dia,mes,anio);
                datePickerDialog.show();
                break;


            case R.id.btnhora:
                final Calendar calendar = Calendar.getInstance();
                hora = calendar.get(Calendar.HOUR_OF_DAY);
                minutos = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                        ethora.setText(hourOfDay + ":" + minute);
                    }
                }, hora, minutos, false);
                timePickerDialog.show();
                break;



    }}

    public void eventos(){
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbCalendario dbCalendario = new DbCalendario(Calendario.this);
                long id = dbCalendario.insertarCalendario(tltitulo.getText().toString(), tllugar.getText().toString(),etfecha.getText().toString());

                if (id > 0){
                    Toast.makeText(Calendario.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Calendario.this,"ERROR DE REGISTRO",Toast.LENGTH_LONG).show();

                }
            }
        });

        btncan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Calendario.this, Inicio.class);;
                startActivity(i2);
            }
        });
    }

}



