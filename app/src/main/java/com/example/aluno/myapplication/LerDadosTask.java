package com.example.aluno.myapplication;

import android.os.AsyncTask;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by aluno on 28/06/2017.
 */

public class LerDadosTask extends AsyncTask<String, Void, Dados> {

    @Override
    protected Dados doInBackground(String... params) {

        try {

            DadosRequest request = Feign.builder()
                    .decoder(new GsonDecoder()).target(DadosRequest.class, "http://jsonplaceholder.typicode.com");

            Dados dadosrecuperados = request.getDados(params[0]);

            return dadosrecuperados;
        } catch (Exception e) {
            System.err.println("Erro na consulta da API");
            e.printStackTrace();
            return null;
        }
    }
}
