package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, NumeroTelefono;
    int[] Imagen;

    boolean[] correoLeido;
    LayoutInflater inflater;
    //Sirve para poner datos (Inflater.) En una interfaz gráfica.

    public ListAdapter (Context contexto, String[] nombres, String[] numeroTelefono, int[] imagen, boolean[] correoLeido)
    {
        this.Contexto = contexto;
        this.Nombres = nombres;
        this.NumeroTelefono = numeroTelefono;
        this.Imagen= imagen;
        this.correoLeido = correoLeido;
        inflater = LayoutInflater.from(Contexto);
    }

    @Override
    public int getCount() {
        return Nombres.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.list_item, null);
        ImageView fotoPerfil= view.findViewById(R.id.fotoPerfilUsuario);
        TextView nombreUsuario = view.findViewById(R.id.Nombre);
        TextView telefonoUsuario = view.findViewById(R.id.Telefono);

        fotoPerfil.setImageResource(Imagen[i]); //Asignamos la imagen.
        nombreUsuario.setText(Nombres[i]);
        telefonoUsuario.setText(NumeroTelefono[i]);

        // Modificar la apariencia según el estado de lectura
        if (correoLeido[i]) {
            view.setBackgroundColor(Contexto.getResources().getColor(R.color.leido));
        } else {
            view.setBackgroundColor(Contexto.getResources().getColor(android.R.color.transparent));
        }

        return view;
    }

    // Método para actualizar el estado de lectura de un contacto
    public void setContactoLeido(int posicion, boolean leido) {
        correoLeido[posicion] = leido;
        notifyDataSetChanged();
    }
}
