package com.betacom.pv.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoriaVeicoliDTO {
	private String descrizione;
    private String tipo;
}
