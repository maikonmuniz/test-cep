package com.app.cep.contracts;

import com.app.cep.domain.Endereco;

public interface HttpContract {
    Endereco get(String data);
}
