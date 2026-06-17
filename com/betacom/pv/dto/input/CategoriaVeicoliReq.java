package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaVeicoliReq {
	@NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.categoria")
	@NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.categoria")
    private String descrizione;

	@NotNull(groups = ValidationGroups.Create.class, message = "veicoli.no.tipoVeicolo")
	@NotBlank(groups = ValidationGroups.Create.class, message = "veicoli.no.tipoVeicolo")
    private String tipo;
}
