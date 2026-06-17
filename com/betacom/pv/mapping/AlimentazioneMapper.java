package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.AlimentazioneDTO;
import com.betacom.pv.models.TipoAlimentazione;

public class AlimentazioneMapper {
	public static AlimentazioneDTO toDTO(TipoAlimentazione alim) {
		return AlimentazioneDTO.builder()
				.descrizione(alim.getDescrizione())
				.tipo(alim.getTipoVeicolo().getTipo())
				.build();
	}
}
