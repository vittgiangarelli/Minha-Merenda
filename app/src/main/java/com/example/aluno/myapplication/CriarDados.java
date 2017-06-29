package com.example.aluno.myapplication;

import android.os.AsyncTask;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * Created by aluno on 28/06/2017.
 */

public class CriarDados extends AsyncTask<Dados, Void, Void> {

    @Override
    protected Void doInBackground(Dados... params) {

        try {
            // Preparação da chamada via Feign, usando a interface que criamos
            DadosRequest request = Feign.builder().decoder(new GsonDecoder()).target(DadosRequest.class,
                            "http://jsonplaceholder.typicode.com/posts/vittorio");

            // o método "createPostagem(...) irá:
            //  - acessar a internet
            //  - verificar a existência no endpoint
            //  - converter o Java para JSON
            //  - enviar o JSON gerado para a API
            request.createDados(params[0]);

            return null;

        } catch (Exception e) {
            System.err.println("Erro na consulta da API");
            e.printStackTrace();
            return null;
        }
    }
}
