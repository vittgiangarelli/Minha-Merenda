package com.example.aluno.myapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText escola;
    EditText ra;
    TextView erro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escola = (EditText)findViewById(R.id.editEscola);
        ra = (EditText)findViewById(R.id.editRa);
        erro = (TextView)findViewById(R.id.txtErro);

        // código necessário para evitar problemas de restrição do Android
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void passaRa(View v) {

        Intent tela_2 = new Intent(this, Tela_2.class);

        String nEscola = escola.getText().toString();
        String numRa = ra.getText().toString();

        tela_2.putExtra("nomeEscola", nEscola);
        tela_2.putExtra("numeroRa", numRa);

        startActivity(tela_2);
    }

    public void consultar(View v) {

        LerDadosTask task = new LerDadosTask();

        // Usando a Task para recuperar a postagem da API REST pela internet
        Dados dados = task.doInBackground(String.valueOf(ra.getText().toString()));

        // usando os valores recuperados nos componentes de tela
        if (dados.ra == ra.getText().toString())
            erro.setText("Você já avaliou a merenda de hoje!");
    }
}
