package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.TipoDTO;
import com.betacom.pv.models.TipoVeicolo;

public class TipiVeicoliMapper {
	public static TipoDTO toDTO(TipoVeicolo tipo) {
		return TipoDTO.builder()
				.descrizione(tipo.getTipo())
				.build();
	}
}
