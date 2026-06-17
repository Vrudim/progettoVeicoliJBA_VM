package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.CategoriaVeicoliDTO;
import com.betacom.pv.models.CategoriaVeicolo;

public class CategoriaMapper {
	public static CategoriaVeicoliDTO toDTO(CategoriaVeicolo cat) {
		return CategoriaVeicoliDTO.builder()
				.descrizione(cat.getDescrizione())
				.tipo(cat.getTipoVeicolo().getTipo())
				.build();
	}
}
