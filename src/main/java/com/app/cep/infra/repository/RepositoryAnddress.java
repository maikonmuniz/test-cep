package com.app.cep.infra.repository;

import com.app.cep.contracts.RepositoryAnddressContract;
import com.app.cep.domain.Endereco;
import com.app.cep.infra.jpa.AddressJPA;
import com.app.cep.infra.operationORM.AddressOperationORM;

public class RepositoryAnddress implements RepositoryAnddressContract {

    private final AddressOperationORM addressOperationORM;

    public RepositoryAnddress (AddressOperationORM anddressOperationORM) {
        this.addressOperationORM = anddressOperationORM;
    }

    @Override
    public Endereco save(Endereco endereco) {

        AddressJPA addressJPA = new AddressJPA();
        addressJPA.setPostalCode(endereco.getCep());
        addressJPA.setStreet(endereco.getLogradouro());
        addressJPA.setComplement(endereco.getComplemento());
        addressJPA.setUnit(endereco.getUnidade());
        addressJPA.setNeighborhood(endereco.getBairro());
        addressJPA.setCity(endereco.getLocalidade());
        addressJPA.setStateCode(endereco.getUf());
        addressJPA.setState(endereco.getEstado());
        addressJPA.setRegion(endereco.getRegiao());
        addressJPA.setIbge(endereco.getIbge());
        addressJPA.setGia(endereco.getGia());
        addressJPA.setDdd(endereco.getDdd());
        addressJPA.setSiafi(endereco.getSiafi());

        AddressJPA addressJPASave = this.addressOperationORM.save(addressJPA);

        Endereco addressNew = new Endereco();

        addressNew.setCep(addressJPASave.getPostalCode());
        addressNew.setLogradouro(addressJPASave.getStreet());
        addressNew.setComplemento(addressJPASave.getComplement());
        addressNew.setUnidade(addressJPASave.getUnit());
        addressNew.setBairro(addressJPASave.getNeighborhood());
        addressNew.setLocalidade(addressJPASave.getCity());
        addressNew.setUf(addressJPASave.getStateCode());
        addressNew.setEstado(addressJPASave.getState());
        addressNew.setRegiao(addressJPASave.getRegion());
        addressNew.setIbge(addressJPASave.getIbge());
        addressNew.setGia(addressJPASave.getGia());
        addressNew.setDdd(addressJPASave.getDdd());
        addressNew.setSiafi(addressJPASave.getSiafi());
        addressNew.setCreatedAt(addressJPASave.getCreatedAt());

        return addressNew;
    }
}
