package com.betacom.pv.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlimentazioneDTO {
    private String descrizione;
    private String tipo;
}
