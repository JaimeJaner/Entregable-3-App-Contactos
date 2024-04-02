package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {
    String nombre, telefono, descripcion, calificacion;
    int imagen;
    CircleImageView foto;
    TextView textoNombre, textoTelefono, textoDescripciones, textoCalificaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items_list);

        textoNombre = findViewById(R.id.txtNombre);
        textoTelefono = findViewById(R.id.txtTelefono);
        foto = findViewById(R.id.fotoPerfilItemList);
        textoDescripciones = findViewById(R.id.txtDescripcion);
        textoCalificaciones = findViewById(R.id.txtCalificacion);

        Intent recibir = this.getIntent();

        if(recibir != null)
        {
            nombre = recibir.getStringExtra("nombre");
            telefono = recibir.getStringExtra("telefonos");
            imagen = recibir.getIntExtra("fotoperfil", R.drawable.persona);
            descripcion = recibir.getStringExtra("descripciones");
            calificacion = recibir.getStringExtra("calificaciones");


            // falta asignar el nombre y los dem{as valores a los visualizadores.

            textoNombre.setText(String.format("Nombre: %s", nombre));
            textoTelefono.setText(String.format("Telefono: %s", telefono));
            textoDescripciones.setText(String.format("Descripción del proveedor: %s", descripcion));
            textoCalificaciones.setText(String.format("Calificación del Proveedor: %s", calificacion));
            foto.setImageResource(imagen);
        }
    }
}
