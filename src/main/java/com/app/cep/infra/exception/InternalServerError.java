package com.app.cep.infra.exception;

public class InternalServerError extends RuntimeException{
    public InternalServerError (String messagem) {
        super(messagem);
    }
}
