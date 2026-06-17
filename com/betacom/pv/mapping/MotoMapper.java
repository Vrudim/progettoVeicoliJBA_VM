package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.MotoDTO;
import com.betacom.pv.models.Moto;

public class MotoMapper {
	public static MotoDTO toDTO(Moto m) {
		MotoDTO dto = new MotoDTO();
        dto.setIdMoto(m.getId());
	    VeicoliMapper.map(dto, m.getVeicoli());
	    dto.setTarga(m.getTarga());
	    dto.setCc(m.getCc());
	    dto.setNumeroRuote(m.getNumeroRuote());
	    return dto;
	}
}