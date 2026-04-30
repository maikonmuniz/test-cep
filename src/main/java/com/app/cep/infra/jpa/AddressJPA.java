package com.app.cep.infra.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // BIGINT → Long

    @Column(nullable = false, unique = true, length = 9)
    private String cep;

    @Column(nullable = false)
    private String logradouro;

    private String complemento;

    private String unidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String localidade;

    @Column(nullable = false, length = 2)
    private String uf;

    private String estado;

    private String regiao;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;
}
