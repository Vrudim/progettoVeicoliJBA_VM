package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.BiciDTO;
import com.betacom.pv.models.Bici;

public class BiciMapper {
	public static BiciDTO toDTO(Bici b) {
		BiciDTO dto = new BiciDTO();
        dto.setIdBici(b.getId());
        VeicoliMapper.map(dto, b.getVeicoli());
        dto.setNumeroRuote(b.getNumeroRuote());
        dto.setNumeroMarce(b.getNumeroMarce());
        dto.setPieghevole(b.getPieghevole());
        dto.setTipoFreno(b.getTipoFreno() != null ? b.getTipoFreno().getDescrizione() : null);
        dto.setTipoSospensione(b.getTipoSospensione() != null ? b.getTipoSospensione().getDescrizione() : null);

        return dto;
    }
}