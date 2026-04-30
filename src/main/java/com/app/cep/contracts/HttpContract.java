package com.app.cep.contracts;

import com.app.cep.dto.EnderecoDTO;

public interface HttpContract {
    EnderecoDTO get(String data);
}
