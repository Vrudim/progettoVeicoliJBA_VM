package com.betacom.pv.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SospensioneReq {
    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    private String sospensione;
}
