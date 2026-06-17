package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.MacchinaDTO;
import com.betacom.pv.models.Macchina;

public class MacchinaMapper {
	public static MacchinaDTO toDTO(Macchina m) {
        MacchinaDTO dto = new MacchinaDTO();
        dto.setIdMacchina(m.getId());
        VeicoliMapper.map(dto, m.getVeicoli());
        dto.setTarga(m.getTarga());
        dto.setCc(m.getCc());
        dto.setNumeroPorte(m.getNumeroPorte());
        dto.setNumeroRuote(m.getNumeroRuote());

        return dto;
    }
}