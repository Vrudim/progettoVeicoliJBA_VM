package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.FrenoDTO;
import com.betacom.pv.models.TipoFreno;

public class FrenoMapper {
	public static FrenoDTO toDTO (TipoFreno frn) {
		return FrenoDTO.builder()
				.descrizione(frn.getDescrizione())
				.build();
	}
}
