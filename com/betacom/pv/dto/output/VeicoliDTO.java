package com.betacom.pv.dto.output;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class VeicoliDTO {
    private String marca;
    private String modello;
    private String colore;
    private LocalDate annoProduzione;
    private String tipoVeicolo;
    private String alimentazione;
    private String categoria;
}
