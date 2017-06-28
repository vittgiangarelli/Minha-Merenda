package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText escola;
    EditText ra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escola = (EditText)findViewById(R.id.editEscola);
        ra = (EditText)findViewById(R.id.editRa);
    }

    public void passaRa(View v) {

        Intent tela_2 = new Intent(this, Tela_2.class);

        String nEscola = escola.getText().toString();
        String numRa = ra.getText().toString();

        tela_2.putExtra("nomeEscola", nEscola);
        tela_2.putExtra("numeroRa", numRa);

        startActivity(tela_2);
    }
}
