package com.app.cep.infra.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postal_code" ,nullable = false, unique = true, length = 9)
    private String postalCode;

    @Column(nullable = false)
    private String street;

    private String complement;

    private String unit;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(name = "state_code", nullable = false, length = 2)
    private String stateCode;

    private String state;

    private String region;

    private String ibge;

    private String gia;

    private String ddd;

    private String siafi;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }
}
