package com.betacom.pv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_veicolo")
@Getter
@Setter
public class TipoVeicolo {
	@Id
    @Column(nullable = false, unique = true)
    private String tipo;
}