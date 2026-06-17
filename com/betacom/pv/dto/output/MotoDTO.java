package com.betacom.pv.dto.output;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MotoDTO extends VeicoliDTO {
	private Integer idMoto;
    private String targa;
    private Integer cc;
    private Integer numeroRuote;
}
