package com.example.aluno.myapplication;

import feign.Param;
import feign.RequestLine;

/**
 * Created by aluno on 28/06/2017.
 */

public interface DadosRequest{

    @RequestLine("GET /posts/{id}/")
    Dados getDados(@Param("id") Integer id);
}
