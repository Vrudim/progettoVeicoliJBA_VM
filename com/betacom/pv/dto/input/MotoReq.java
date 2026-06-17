package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotoReq extends VeicoliReq {

    @NotNull(groups = ValidationGroups.Update.class, message = "moto.no.id")
    private Integer id;
    
    @NotBlank(groups = ValidationGroups.Create.class, message = "moto.no.targa")
    @NotNull(groups = ValidationGroups.Create.class, message = "moto.no.targa")
    @Pattern(groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, regexp = "^[A-Z]{2}[0-9]{5}$",message = "targa.non.valida")
    private String targa;
    
    @NotNull(groups = ValidationGroups.Create.class, message = "moto.no.cc")
    private Integer cc;

    @NotNull(groups = ValidationGroups.Create.class, message = "moto.no.nrRuote")
    private Integer numeroRuote;
}