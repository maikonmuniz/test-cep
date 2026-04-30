package com.app.cep.services;

import com.app.cep.infra.exception.ExceptionAdapter;
import com.app.cep.infra.http.Api;

public class CepServices {

    private final Api api;
    private final ExceptionAdapter exceptionAdapter;

    public CepServices (Api api, ExceptionAdapter exceptionAdapter) {
        this.api = api;
        this.exceptionAdapter = exceptionAdapter;
    }

    public String execute (String cep) {
        if (cep == null || cep.isEmpty()) throw this.exceptionAdapter.badRequest("Campo cep está em branco!");
        if (!cep.matches("\\d+")) throw this.exceptionAdapter.badRequest("Campo cep deve conter apenas números!");
        if (cep.length() != 8) throw this.exceptionAdapter.badRequest("Campo cep deve ter 8 dígitos!");

        try {
            return this.api.get(cep);
        } catch (Exception exception) {
            throw this.exceptionAdapter.internalServe("Erro ao processar o CEP: " + exception.getMessage());
        }
    }
}
