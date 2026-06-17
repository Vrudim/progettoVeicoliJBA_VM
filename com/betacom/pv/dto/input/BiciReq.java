package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiciReq extends VeicoliReq {
	
    @NotNull(groups = ValidationGroups.Update.class, message = "bici.no.id")
    private Integer id;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.nrRuote")
    private Integer numeroRuote;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.nrMarce")
    private Integer numeroMarce;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    private String tipoFreno;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    private String tipoSospensione;

    @NotNull(groups = ValidationGroups.Create.class,  message = "bici.no.pieghevole")
    private Boolean pieghevole;
}
