package com.app.cep.infra.http;

import com.app.cep.contracts.HttpContract;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Api implements HttpContract {

    private final RestTemplate api;

    public Api(RestTemplate api) {
        this.api = api;
    }

    @Override
    public String get(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<String> resp = this.api.getForEntity(url, String.class);
        return resp.getBody();
    }
}
