package com.app.cep.infra.operationORM;

import com.app.cep.infra.jpa.AddressJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressOperationORM extends JpaRepository<AddressJPA, Long> {
}
