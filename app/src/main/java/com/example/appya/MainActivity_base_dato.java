package com.example.appya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_base_dato extends AppCompatActivity {

    private EditText etcodigo, etNomb, etFab, etCom;

    private Button btnvolver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_base_datos);
        //boton volver
        btnvolver2=(Button)findViewById(R.id.btnvolver2);

        btnvolver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(MainActivity_base_dato.this,MainActivity2.class);
                startActivity(c);
            }
        });

        etcodigo =(EditText)findViewById(R.id.etCodigo);
        etNomb =(EditText)findViewById(R.id.etNombre);
        etFab =(EditText)findViewById(R.id.etFabricante);
        etCom =(EditText)findViewById(R.id.etComponentes);


    }

    //dar de alta los productos

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDAtos = admin.getWritableDatabase();

        String codigo = etcodigo.getText().toString();
        String nombre = etNomb.getText().toString();
        String fabricante = etFab.getText().toString();
        String componentes = etCom.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !fabricante.isEmpty() && !componentes.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo",codigo);
            registro.put("nombre",nombre);
            registro.put("fabricante",fabricante);
            registro.put("componentes",componentes);

            BaseDAtos.insert("productos", null, registro);

            BaseDAtos.close();
            etcodigo.setText("");
            etNomb.setText("");
            etFab.setText("");
            etCom.setText("");

            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this, "DEBES LLENAR LOS CAMPOS", Toast.LENGTH_SHORT).show();


        }


    }

    //CONSULTAR ARTICULO O PRODUCTO

    public void  Bsucar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String codigo = etcodigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDatos.rawQuery
                    ("select nombre, fabricante, componentes from productos where codigo ="+ codigo, null);

            if (fila.moveToFirst()){

                //etcodigo.setText(fila.getString(0));
                etNomb.setText(fila.getString(0));
                etFab.setText(fila.getString(1));
                etCom.setText(fila.getString(2));
                BaseDatos.close();
            }else{
                Toast.makeText(this,"NO EXISTE EL PRODUCTO", Toast.LENGTH_LONG).show();
                BaseDatos.close();

            }

        }else{
            Toast.makeText(this, "DEBES INTTRODUCIR EL CODIGO",Toast.LENGTH_LONG).show();

        }


    }

    //METODO ELIMINAR

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String codigo = etcodigo.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDatos.delete("productos","codigo=" + codigo, null);
            BaseDatos.close();

            etcodigo.setText("");
            etNomb.setText("");
            etFab.setText("");
            etCom.setText("");

            if(cantidad == 1){
                Toast.makeText(this,"ARTICULO INGRESADO EXITOSAMENTE", Toast.LENGTH_LONG).show();

            }else{
                Toast.makeText(this,"EL ARTICULO NO EXISTE", Toast.LENGTH_LONG).show();

            }

        }else {
            Toast.makeText(this,"DEBES INGRESAR EL PRODUCTO", Toast.LENGTH_LONG).show();

        }

    }

    //METODO MODIFICAR

    public void Modificar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDatos = admin.getWritableDatabase();

        String codigo = etcodigo.getText().toString();
        String nombre = etcodigo.getText().toString();
        String fabricante = etFab.getText().toString();
        String componentes = etCom.getText().toString();

        if (!codigo.isEmpty() && !nombre.isEmpty() && !fabricante.isEmpty() && !componentes.isEmpty()) {

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("nombre", nombre);
            registro.put("fabricante", fabricante);
            registro.put("componentes", componentes);

            int cantidad = BaseDatos.update("productos", registro, "codigo =" + codigo, null);
            BaseDatos.close();

            if (cantidad == 1) {
                Toast.makeText(this, "ARTICULO MODIFICADO EXITOSAMENTE", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "EL ARTICULO NO EXISTE", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "DEBES LLENAR LS CAMPOS", Toast.LENGTH_LONG).show();

        }

    }


}