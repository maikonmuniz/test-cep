package com.app.cep.main;

import com.app.cep.infra.exception.ExceptionAdapter;
import com.app.cep.infra.exception.OperationStatusCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainException {
    @Bean
    public OperationStatusCode CreateOperationStatusCode () {
        return new OperationStatusCode ();
    }

    @Bean
    public ExceptionAdapter createExceptionAdapter (
            OperationStatusCode operationStatusCode
    ) {
        return new ExceptionAdapter(operationStatusCode);
    }
}
