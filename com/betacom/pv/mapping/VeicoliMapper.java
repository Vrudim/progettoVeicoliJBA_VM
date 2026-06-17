package com.betacom.pv.mapping;

import com.betacom.pv.dto.output.VeicoliDTO;
import com.betacom.pv.models.Veicoli;

public class VeicoliMapper {
	public static void map(VeicoliDTO dto, Veicoli v) {
        dto.setMarca(v.getMarca());
        dto.setModello(v.getModello());
        dto.setColore(v.getColore());
        dto.setAnnoProduzione(v.getAnnoProduzione());
        dto.setTipoVeicolo(v.getTipoVeicolo() != null ? v.getTipoVeicolo().getTipo() : null);
        dto.setAlimentazione(v.getAlimentazione() != null ? v.getAlimentazione().getDescrizione() : null);
        dto.setCategoria(v.getCategoria() != null ? v.getCategoria().getDescrizione() : null);
    }
}
