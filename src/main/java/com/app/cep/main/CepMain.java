package com.app.cep.main;

import com.app.cep.infra.exception.ExceptionAdapter;
import com.app.cep.infra.http.Api;
import com.app.cep.services.CepServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CepMain {

    @Bean
    Api createApi (RestTemplate api) {
        return new Api(api);
    }

    @Bean
    CepServices createCepServices (Api api, ExceptionAdapter exceptionAdapter) {
        return new CepServices(api, exceptionAdapter);
    }
}