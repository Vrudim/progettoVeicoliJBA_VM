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
public class MacchinaDTO extends VeicoliDTO {
	private Integer idMacchina;
    private String targa;
    private Integer cc;
    private Integer numeroPorte;
    private Integer numeroRuote;
}
