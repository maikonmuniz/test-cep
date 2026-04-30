package com.app.cep.infra.repository;

import com.app.cep.contracts.RepositoryAnddressContract;
import com.app.cep.dto.EnderecoDTO;
import com.app.cep.infra.jpa.AddressJPA;
import com.app.cep.infra.operationORM.AddressOperationORM;

public class RepositoryAnddress implements RepositoryAnddressContract {

    private final AddressOperationORM addressOperationORM;

    public RepositoryAnddress (AddressOperationORM anddressOperationORM) {
        this.addressOperationORM = anddressOperationORM;
    }

    @Override
    public EnderecoDTO save(EnderecoDTO enderecoDTO) {

        AddressJPA addressJPA = new AddressJPA();
        addressJPA.setCep(enderecoDTO.getCep());
        addressJPA.setLogradouro(enderecoDTO.getLogradouro());
        addressJPA.setComplemento(enderecoDTO.getComplemento());
        addressJPA.setUnidade(enderecoDTO.getUnidade());
        addressJPA.setBairro(enderecoDTO.getBairro());
        addressJPA.setLocalidade(enderecoDTO.getLocalidade());
        addressJPA.setUf(enderecoDTO.getUf());
        addressJPA.setEstado(enderecoDTO.getEstado());
        addressJPA.setRegiao(enderecoDTO.getRegiao());
        addressJPA.setIbge(enderecoDTO.getIbge());
        addressJPA.setGia(enderecoDTO.getGia());
        addressJPA.setDdd(enderecoDTO.getDdd());
        addressJPA.setSiafi(enderecoDTO.getSiafi());

        AddressJPA addressJPASave = this.addressOperationORM.save(addressJPA);
        enderecoDTO.setCep(addressJPASave.getCep());
        enderecoDTO.setLogradouro(addressJPASave.getLogradouro());
        enderecoDTO.setComplemento(addressJPASave.getComplemento());
        enderecoDTO.setUnidade(addressJPASave.getUnidade());
        enderecoDTO.setBairro(addressJPASave.getBairro());
        enderecoDTO.setLocalidade(addressJPASave.getLocalidade());
        enderecoDTO.setUf(addressJPASave.getUf());
        enderecoDTO.setEstado(addressJPASave.getEstado());
        enderecoDTO.setRegiao(addressJPASave.getRegiao());
        enderecoDTO.setIbge(addressJPASave.getIbge());
        enderecoDTO.setGia(addressJPASave.getGia());
        enderecoDTO.setDdd(addressJPASave.getDdd());
        enderecoDTO.setSiafi(addressJPASave.getSiafi());

        return enderecoDTO;
    }
}
