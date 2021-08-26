package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    static String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        texto = Resultado.texto;
        atualizaTexto();
    }
    public void atualizaTexto(){
        TextView t = (TextView) findViewById(R.id.Texto);
        t.setText(texto);
    }
}