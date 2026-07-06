package com.betacom.pv.dto.output;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BiciDTO extends VeicoliDTO{
	private Integer idBici;
    private Integer numeroRuote;
    private Integer numeroMarce;
    private String tipoFreno;
    private String tipoSospensione;
    private Boolean pieghevole;
}
