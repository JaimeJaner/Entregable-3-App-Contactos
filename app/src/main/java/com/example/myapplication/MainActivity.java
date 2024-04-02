package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    boolean [] estadoContacto =
            {
                    false,
                    false,
                    false,
                    false,
                    false,
                    false,
                    false
            };
    ListView listaPersonas;

    @Override
    protected void onResume() {
        super.onResume();

        actualizarIndicacionVisual();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int [] fotoperfil = {
                R.drawable.persona1,
                R.drawable.persona2,
                R.drawable.persona3,
                R.drawable.persona4,
                R.drawable.persona5,
                R.drawable.persona6,
                R.drawable.persona7
        };

        String[] nombres = {
                "Jamones Económicos S.A.",
                "Calidad Carnes Premium",
                "Delicias de Albuquerque",
                "Carnicería Estrella",
                "Gourmet Delight",
                "Premium Meat Supplier",
                "Sabor Gourmet"
        };


        String [] telefonos = {
                "12345655",
                "18238121",
                "12831238",
                "15616511",
                "18984000",
                "79878900",
                "78979800"
        };

        String[] descripciones = {
                "Proveedor especializado en jamones a precios accesibles.",
                "Ofrecemos jamones de la más alta calidad, garantizada.",
                "Delicias de Albuquerque: tu destino para experiencias gastronómicas excepcionales.",
                "Proveedor de carnes frescas y deliciosas.",
                "Explora nuestra selección de productos gourmet, incluyendo jamones y más.",
                "Tu fuente confiable para productos delicatesen y carnes premium.",
                "Ofrecemos una amplia variedad de productos alimenticios, incluyendo jamones de primera calidad."
        };


        String[] calificaciones = {
                "★★★★★",
                "★★★☆☆",
                "★★★★☆",
                "★★★☆☆",
                "★★★★☆",
                "★★★★☆",
                "★★★☆☆"
        };

        //Hay que crear los arreglos a enviarle al ListAdapter...
        ListAdapter personas = new ListAdapter(MainActivity.this, nombres, telefonos, fotoperfil, estadoContacto);

        listaPersonas = (ListView) findViewById(R.id.listaUsuarios);
        listaPersonas.setAdapter(personas);

        listaPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View vista, int posicion, long id) {

                estadoContacto[posicion] = true;

                Intent enviarInfo = new Intent (MainActivity.this, UserActivity.class)
                        .putExtra("nombre", nombres[posicion])
                        .putExtra("telefonos", telefonos[posicion])
                        .putExtra("fotoperfil", fotoperfil[posicion])
                        .putExtra("descripciones", descripciones[posicion])
                        .putExtra("calificaciones", calificaciones[posicion]);

                startActivity(enviarInfo);

                actualizarIndicacionVisual();
            }
        });



    }
    private void actualizarIndicacionVisual() {
        for (int i = 0; i < estadoContacto.length; i++) {
            if (estadoContacto[i]) {
                ListAdapter adapter = (ListAdapter) listaPersonas.getAdapter();
                adapter.setContactoLeido(i, true);
            }
        }
    }

}