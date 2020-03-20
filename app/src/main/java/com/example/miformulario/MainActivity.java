package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, dni, correo;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = (EditText)findViewById(R.id.editNombre);
        apellido    = (EditText)findViewById(R.id.editApellido);
        dni         = (EditText)findViewById(R.id.editDni);
        correo      = (EditText)findViewById(R.id.editCorreo);
        enviar      = (Button)findViewById(R.id.btnEnviar);
    }

    public void enviarDatos(View view) {

        String nom = nombre.getText().toString();
        String ape = apellido.getText().toString();
        String doc = dni.getText().toString();
        String email = correo.getText().toString();

        if(validarEntradas()) {
            Toast.makeText(this, "Ingresaste los datos correctamente", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(MainActivity.this, MostrarDatos.class);
            i.putExtra("nom", nom);
            i.putExtra("ape", ape );
            i.putExtra("doc", doc);
            i.putExtra("email", email);

            startActivity(i);
        }
    }

    public boolean validarEntradas(){
        Boolean retorno = true;

        String nom = nombre.getText().toString();
        String ape = apellido.getText().toString();
        String doc = dni.getText().toString();
        String email = correo.getText().toString();

        if(nom.isEmpty()){
            nombre.setError("El nombre no puede estar vacío");
            retorno = false;
        }
        if(ape.isEmpty()){
            apellido.setError("El apellido no puede estar vacío");
            retorno = false;
        }
        if(doc.isEmpty()){
            dni.setError("El DNI no puede estar vacío");
            retorno = false;
        }
        if(email.isEmpty()){
            correo.setError("El correo electrónico no puede estar vacío");
            retorno = false;
        }
        return retorno;
    }
}
