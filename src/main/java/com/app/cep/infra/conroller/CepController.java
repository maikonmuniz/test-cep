package com.app.cep.infra.conroller;
import com.app.cep.domain.Endereco;
import com.app.cep.services.CepServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {
    @Autowired
    private CepServices cepServices;

    @GetMapping("/{cep}")
    public Endereco consultCep(@PathVariable String cep) {
        Endereco result = this.cepServices.execute(cep);
        return result;
    }
}
