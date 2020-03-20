package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    TextView tvnombre, tvapellido, tvdni, tvcorreo;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre = (TextView) findViewById(R.id.tvNombre);
        tvapellido = (TextView) findViewById(R.id.tvApellido);
        tvdni = (TextView) findViewById(R.id.tvDni);
        tvcorreo = (TextView) findViewById(R.id.tvCorreo);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostrarDatos.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mostrarDato();
    }

    private void mostrarDato() {
    Bundle datos = this.getIntent().getExtras();
    String nombre = datos.getString("nom");
    String apellido = datos.getString("ape");
    String dni = datos.getString("doc");
    String correo = datos.getString("email");

    tvnombre.setText(nombre);
    tvapellido.setText(apellido);
    tvdni.setText(dni);
    tvcorreo.setText(correo);
    }
}
