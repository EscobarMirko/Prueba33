package com.example.appya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user,pass;
Button btnEntrar,btnRegistrar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);

        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        user.setText(preferences.getString("user",""));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrar:
                String u=user.getText().toString();
                String  p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error: campos vacios",Toast.LENGTH_LONG).show();
                }else if (dao.login(u,p)==1){
                    Usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this,Inicio.class);
                    i2.putExtra("Id", ux.getId());
                    startActivity(i2);
                    SharedPreferences preferencias = getSharedPreferences("Credenciales",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("user",user.getText().toString());
                    editor.commit();
                    finish();
                }else{
                    Toast.makeText(this, "Usuario y/o Password incorrectos",Toast.LENGTH_LONG).show();
                }
        break;
            case R.id.btnRegistrar:
                Intent i=new Intent(MainActivity.this,Registrar.class);
                startActivity(i);
                break;
        }

    }
}
