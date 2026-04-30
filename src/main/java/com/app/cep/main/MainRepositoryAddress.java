package com.app.cep.main;

import com.app.cep.infra.operationORM.AddressOperationORM;
import com.app.cep.infra.repository.RepositoryAnddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainRepositoryAddress {

    @Bean
    RepositoryAnddress createRepositoryAddress (AddressOperationORM addressOperationORM) {
        return new RepositoryAnddress(addressOperationORM);
    }
}
