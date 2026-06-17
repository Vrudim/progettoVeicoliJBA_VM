package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacchinaReq extends VeicoliReq {
    @NotNull(groups = ValidationGroups.Update.class, message = "macchina.no.id")
    private Integer id;

    @NotBlank(groups = ValidationGroups.Create.class, message = "macchina.no.targa")
    @NotNull(groups = ValidationGroups.Create.class, message = "macchina.no.targa")
    @Pattern(groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$",message = "targa.non.valida")
    private String targa;

    @NotNull(groups = ValidationGroups.Create.class,  message = "macchina.no.cc")
    private Integer cc;

    @NotNull(groups = ValidationGroups.Create.class, message = "macchina.no.nrRuote")
    private Integer numeroRuote;

    @NotNull(groups = ValidationGroups.Create.class, message = "macchina.no.nrPorte")
    private Integer numeroPorte;

}
