package com.betacom.pv.dto.input;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeicoliReq {
    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.tipoVeicolo")
    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.tipoVeicolo")
    private String tipoVeicolo;

    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.alimentazione")
	@NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.alimentazione")
    private String alimentazione;

    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.categoria")
    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.categoria")
    private String categoria;

    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.marca")
    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.marca")
    private String marca;

    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.modello")
    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.modello")
    private String modello;

    @NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.colore")
    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.colore")
    private String colore;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.annoP")
    private LocalDate annoProduzione;
}