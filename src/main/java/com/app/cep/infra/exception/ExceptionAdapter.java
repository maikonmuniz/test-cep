package com.app.cep.infra.exception;

import com.app.cep.contracts.ExceptionContract;

public class ExceptionAdapter implements ExceptionContract {

    private final OperationStatusCode operationStatusCode;

    public ExceptionAdapter(OperationStatusCode operationStatusCode) {
        this.operationStatusCode = operationStatusCode;
    }
    @Override
    public RuntimeException badRequest(String mess) {
        return this.operationStatusCode.BadRequesteError(mess);
    }

    @Override
    public RuntimeException internalServe(String mess) {
        return this.operationStatusCode.InternalServeError(mess);
    }
}
