package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    int contR = 0;
    int contP = 1;
    String pergunta1 = "Quanto é 2 + 2?";
    String resposta1 = "4";
    String pergunta2 = "O que é o que é, surdo e mudo, mas conta tudo!";
    String resposta2 = "Livro";
    String pergunta3 = "A gravidade é o ponto. Gravattack é o _______?";
    String resposta3 = "monstro";
    String pergunta4 = "Qual o nome científico da espécie do enormossauro?";
    String resposta4 = "Vaxassauriano";

    TextView pergunta;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atualizaPergunta();

        botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botao(v);
            }
        });
    }


    public void botao(View view){
        if (contP == 1) {
            perguntar(resposta1);
        }
        else if (contP == 2) {
            perguntar(resposta2);
        }
        else if(contP == 3){
            perguntar(resposta3);
        }
        else if(contP == 4){
            perguntar(resposta4);
        }
    }

    public void atualizaPergunta(){
        pergunta = (TextView) findViewById(R.id.pergunta);
        if (contP == 1) {
            pergunta.setText(pergunta1);
        }
        else if (contP == 2) {
            pergunta.setText(pergunta2);
        }
        else if(contP == 3){
            pergunta.setText(pergunta3);
        }
        else if(contP == 4){
            pergunta.setText(pergunta4);
        }
        else{
            exibeResultadoFinal();
        }
    }

    public void perguntar(String respostaCorreta){
        EditText r = (EditText) findViewById(R.id.Resposta);
        String respostaUsuario = r.getText().toString();
        if(respostaCorreta.equals(respostaUsuario)){
            Toast.makeText(MainActivity.this, "Você acertou!", Toast.LENGTH_LONG).show();
            contR++;
        }
        else{
            Toast.makeText(MainActivity.this, "Você Errou!", Toast.LENGTH_LONG).show();
        }
        contP++;
        r.setText(null);
        atualizaPergunta();
    }

    public void exibeResultadoFinal(){
        Intent i = new Intent(this, Resultado.class);
        Resultado.texto = "Você acertou "+Integer.toString(contR)+" Questões!";
        startActivity(i);
        contP = 1;
        contR = 0;
    }
}
