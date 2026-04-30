package com.app.cep.services;

import com.app.cep.dto.EnderecoDTO;
import com.app.cep.infra.exception.ExceptionAdapter;
import com.app.cep.infra.http.Api;
import com.app.cep.infra.repository.RepositoryAnddress;

public class CepServices {

    private final Api api;
    private final ExceptionAdapter exceptionAdapter;
    private final RepositoryAnddress repoAnddress;

    public CepServices (Api api, ExceptionAdapter exceptionAdapter, RepositoryAnddress repositoryAnddress) {
        this.api = api;
        this.exceptionAdapter = exceptionAdapter;
        this.repoAnddress = repositoryAnddress;
    }

    public EnderecoDTO execute (String cep) {
        if (cep == null || cep.isEmpty()) throw this.exceptionAdapter.badRequest("Campo cep está em branco!");
        if (!cep.matches("\\d+")) throw this.exceptionAdapter.badRequest("Campo cep deve conter apenas números!");
        if (cep.length() != 8) throw this.exceptionAdapter.badRequest("Campo cep deve ter 8 dígitos!");

        try {
            EnderecoDTO enderecoDTO = this.api.get(cep);
            return repoAnddress.save(enderecoDTO);
        } catch (Exception exception) {
            throw this.exceptionAdapter.internalServe("Erro ao processar o CEP: " + exception.getMessage());
        }
    }
}
