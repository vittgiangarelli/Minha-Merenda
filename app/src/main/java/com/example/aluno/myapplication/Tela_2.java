package com.example.aluno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela_2 extends AppCompatActivity {


    TextView pegaEscola;
    TextView pegaRa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_2);

        pegaEscola = (TextView)findViewById(R.id.mostraEscola);
        pegaRa = (TextView)findViewById(R.id.mostraRa);

        String escola = getIntent().getStringExtra("nomeEscola");
        String ra = getIntent().getStringExtra("numeroRa");

        pegaEscola.setText(escola);
        pegaRa.setText(ra);
    }
}
