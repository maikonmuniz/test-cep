package com.app.cep.infra.http;

import com.app.cep.contracts.HttpContract;
import com.app.cep.dto.EnderecoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public class Api implements HttpContract {

    private final RestTemplate api;
    ObjectMapper mapper = new ObjectMapper();

    public Api(RestTemplate api) {
        this.api = api;
    }

    @Override
    public EnderecoDTO get(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            String response = this.api.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, EnderecoDTO.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON: " + e.getMessage());
        }
    }
}
