package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.SospensioneDTO;
import com.betacom.pv.models.TipoSospensione;

public class SospensioneMapper {
	public static SospensioneDTO toDTO(TipoSospensione sosp) {
		return SospensioneDTO.builder()
				.sospensione(sosp.getDescrizione())
				.build();
	}
}
